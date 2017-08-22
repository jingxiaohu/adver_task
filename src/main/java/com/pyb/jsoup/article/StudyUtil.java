package com.pyb.jsoup.article;

import com.highbeauty.pinyin.PinYin;
import com.pyb.bean.Wp_post_jxh;
import com.pyb.bean.Wp_term_jxh;
import com.pyb.bean.Wp_term_taxonomy;
import com.pyb.bean.Wp_terms;
import com.pyb.exception.QzException;
import com.pyb.jsoup.article.model.WpPostModel;
import com.pyb.mvc.service.BaseBiz;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * https://jsoup.org/apidocs/
 */
@Service
public class StudyUtil extends BaseBiz {
    static Logger log = LoggerFactory.getLogger(StudyUtil.class);

    /**
     * 一、校验数字的表达式
     * 数字：^[0-9]*$
     * n位的数字：^\d{n}$
     * 至少n位的数字：^\d{n,}$
     * m-n位的数字：^\d{m,n}$
     * 零和非零开头的数字：^(0|[1-9][0-9]*)$
     * 非零开头的最多带两位小数的数字：^([1-9][0-9]*)+(.[0-9]{1,2})?$
     * 带1-2位小数的正数或负数：^(\-)?\d+(\.\d{1,2})?$
     * 正数、负数、和小数：^(\-|\+)?\d+(\.\d+)?$
     * 有两位小数的正实数：^[0-9]+(\.[0-9]{2})?$
     * 有1~3位小数的正实数：^[0-9]+(\.[0-9]{1,3})?$
     * 非零的正整数：^[1-9]\d*$ 或 ^([1-9][0-9]*){1,3}$ 或 ^\+?[1-9][0-9]*$
     * 非零的负整数：^\-[1-9][]0-9"*$ 或 ^-[1-9]\d*$
     * 非负整数：^\d+$ 或 ^[1-9]\d*|0$
     * 非正整数：^-[1-9]\d*|0$ 或 ^((-\d+)|(0+))$
     * 非负浮点数：^\d+(\.\d+)?$ 或 ^[1-9]\d*\.\d*|0\.\d*[1-9]\d*|0?\.0+|0$
     * 非正浮点数：^((-\d+(\.\d+)?)|(0+(\.0+)?))$ 或 ^(-([1-9]\d*\.\d*|0\.\d*[1-9]\d*))|0?\.0+|0$
     * 正浮点数：^[1-9]\d*\.\d*|0\.\d*[1-9]\d*$ 或 ^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$
     * 负浮点数：^-([1-9]\d*\.\d*|0\.\d*[1-9]\d*)$ 或 ^(-(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*)))$
     * 浮点数：^(-?\d+)(\.\d+)?$ 或 ^-?([1-9]\d*\.\d*|0\.\d*[1-9]\d*|0?\.0+|0)$
     * 校验字符的表达式
     * 汉字：^[\u4e00-\u9fa5]{0,}$
     * 英文和数字：^[A-Za-z0-9]+$ 或 ^[A-Za-z0-9]{4,40}$
     * 长度为3-20的所有字符：^.{3,20}$
     * 由26个英文字母组成的字符串：^[A-Za-z]+$
     * 由26个大写英文字母组成的字符串：^[A-Z]+$
     * 由26个小写英文字母组成的字符串：^[a-z]+$
     * 由数字和26个英文字母组成的字符串：^[A-Za-z0-9]+$
     * 由数字、26个英文字母或者下划线组成的字符串：^\w+$ 或 ^\w{3,20}$
     * 中文、英文、数字包括下划线：^[\u4E00-\u9FA5A-Za-z0-9_]+$
     * 中文、英文、数字但不包括下划线等符号：^[\u4E00-\u9FA5A-Za-z0-9]+$ 或 ^[\u4E00-\u9FA5A-Za-z0-9]{2,20}$
     * 可以输入含有^%&',;=?$\"等字符：[^%&',;=?$\x22]+
     * 禁止输入含有~的字符：[^~\x22]+
     * 三、特殊需求表达式
     * Email地址：^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$
     * 域名：[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(/.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+/.?
     * InternetURL：[a-zA-z]+://[^\s]* 或 ^http://([\w-]+\.)+[\w-]+(/[\w-./?%&=]*)?$
     * 手机号码：^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$
     * 电话号码("XXX-XXXXXXX"、"XXXX-XXXXXXXX"、"XXX-XXXXXXX"、"XXX-XXXXXXXX"、"XXXXXXX"和"XXXXXXXX)：^(\(\d{3,4}-)|\d{3.4}-)?\d{7,8}$
     * 国内电话号码(0511-4405222、021-87888822)：\d{3}-\d{8}|\d{4}-\d{7}
     * 电话号码正则表达式（支持手机号码，3-4位区号，7-8位直播号码，1－4位分机号）: ((\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)
     * 身份证号(15位、18位数字)，最后一位是校验位，可能为数字或字符X：(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)
     * 帐号是否合法(字母开头，允许5-16字节，允许字母数字下划线)：^[a-zA-Z][a-zA-Z0-9_]{4,15}$
     * 密码(以字母开头，长度在6~18之间，只能包含字母、数字和下划线)：^[a-zA-Z]\w{5,17}$
     * 强密码(必须包含大小写字母和数字的组合，不能使用特殊字符，长度在8-10之间)：^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,10}$
     * 日期格式：^\d{4}-\d{1,2}-\d{1,2}
     * 一年的12个月(01～09和1～12)：^(0?[1-9]|1[0-2])$
     * 一个月的31天(01～09和1～31)：^((0?[1-9])|((1|2)[0-9])|30|31)$
     * 钱的输入格式：
     * 有四种钱的表示形式我们可以接受:"10000.00" 和 "10,000.00", 和没有 "分" 的 "10000" 和 "10,000"：^[1-9][0-9]*$
     * 这表示任意一个不以0开头的数字,但是,这也意味着一个字符"0"不通过,所以我们采用下面的形式：^(0|[1-9][0-9]*)$
     * 一个0或者一个不以0开头的数字.我们还可以允许开头有一个负号：^(0|-?[1-9][0-9]*)$
     * 这表示一个0或者一个可能为负的开头不为0的数字.让用户以0开头好了.把负号的也去掉,因为钱总不能是负的吧。下面我们要加的是说明可能的小数部分：^[0-9]+(.[0-9]+)?$
     * 必须说明的是,小数点后面至少应该有1位数,所以"10."是不通过的,但是 "10" 和 "10.2" 是通过的：^[0-9]+(.[0-9]{2})?$
     * 这样我们规定小数点后面必须有两位,如果你认为太苛刻了,可以这样：^[0-9]+(.[0-9]{1,2})?$
     * 这样就允许用户只写一位小数.下面我们该考虑数字中的逗号了,我们可以这样：^[0-9]{1,3}(,[0-9]{3})*(.[0-9]{1,2})?$
     * 1到3个数字,后面跟着任意个 逗号+3个数字,逗号成为可选,而不是必须：^([0-9]+|[0-9]{1,3}(,[0-9]{3})*)(.[0-9]{1,2})?$
     * 备注：这就是最终结果了,别忘了"+"可以用"*"替代如果你觉得空字符串也可以接受的话(奇怪,为什么?)最后,别忘了在用函数时去掉去掉那个反斜杠,一般的错误都在这里
     * xml文件：^([a-zA-Z]+-?)+[a-zA-Z0-9]+\\.[x|X][m|M][l|L]$
     * 中文字符的正则表达式：[\u4e00-\u9fa5]
     * 双字节字符：[^\x00-\xff] (包括汉字在内，可以用来计算字符串的长度(一个双字节字符长度计2，ASCII字符计1))
     * 空白行的正则表达式：\n\s*\r (可以用来删除空白行)
     * HTML标记的正则表达式：<(\S*?)[^>]*>.*?|<.*? /> ( 首尾空白字符的正则表达式：^\s*|\s*$或(^\s*)|(\s*$) (可以用来删除行首行尾的空白字符(包括空格、制表符、换页符等等)，非常有用的表达式)
     * 腾讯QQ号：[1-9][0-9]{4,} (腾讯QQ号从10000开始)
     * 中国邮政编码：[1-9]\d{5}(?!\d) (中国邮政编码为6位数字)
     * IP地址：((?:(?:25[0-5]|2[0-4]\\d|[01]?\\d?\\d)\\.){3}(?:25[0-5]|2[0-4]\\d|[01]?\\d?\\d))
     */
    public List<Wp_term_jxh> FindWptermsJxh(long fatherId,long startid,long endid) {
        try {
            //首先检查是否存在 wp_terms
            String sql = "select * from wp_term_jxh where category_father_id=? and ( id > ? and id < ?)";
            List<Wp_term_jxh> wp_terms_list = getMySelfService().queryListT(sql,Wp_term_jxh.class,fatherId,startid,endid);
            return wp_terms_list;
        } catch (Exception e) {
            log.error("addClass  is error",e);
        }
        return null;
    }

    public void spider766_2(String prefx, Wp_term_jxh wp_term_jxh, String url, String classname) {
        try {
            EaverydayArticleSpider testspider = new EaverydayArticleSpider();
            //首先验证是否是内容
            Document document = testspider.MakeArticle(url);
            boolean iscontent = checkIsContent(testspider, document);
            if (iscontent) {
                //进行内容处理
                Elements elements = document
                        .select("a[href ^=" + classname + "]")
                        .select("a[href $= .html]");
                log.info("条数={}", elements.size());
                if(elements == null){
                        return;
                }
                DoWithContent( elements.get(0), prefx, url, testspider, wp_term_jxh);
            } else {
                //不是内容进行非内容处理
                Elements elements = document
                        .select("a[href ^=" + classname + "]")
                        .select("a[href $= .html]");
                log.info("条数={}", elements.size());
                if(elements == null){
                    return;
                }
                for (Element element : elements) {
                    String text = element.text();
                    String href = element.attr("href");
                    if ("".equalsIgnoreCase(href)) {
                        return;
                    }
                    if (href == null || text == null) {
                        return;
                    }
                    if (href.indexOf("http") == -1) {
                        href = prefx + href;
                    }
                    log.info("数据={}", element.text() + "  " + element.attr("href"));
                    spider766_2( prefx,  wp_term_jxh,  href,  classname);
                }
            }
        } catch (Exception e) {
            log.error("spider766_2 is error message={}", e.getMessage());
        }
    }
    /**
     * dowith content s
     * @param element
     * @param prefx
     * @param url :内容URL
     * @param testspider
     * @param wp_term_jxh
     */
    public void DoWithContent(Element element,String prefx,String url,EaverydayArticleSpider testspider,Wp_term_jxh wp_term_jxh) {
        try {
            String title = element.text();
            String href = element.attr("href");
            if ("".equalsIgnoreCase(href)) {
                return;
            }
            if (href == null || title == null) {
                return;
            }
            log.info("数据={}", element.text() + "  " + element.attr("href"));
            Wp_post_jxh wp_post_jxh = WpPostModel.getWp_post_jxh();
            wp_post_jxh.setTitle(title.trim());
            if (href.indexOf("http") == -1) {
                href = prefx + href;
            }
            String content = GetContent(href, testspider, prefx);
            if (content == null) return;
            wp_post_jxh.setContent(content.replaceAll("767股票学习网", ""));
            wp_post_jxh.setDate_time(new Date());
            wp_post_jxh.setCategory_id(wp_term_jxh.category_id);
            wp_post_jxh.setCategory_code(wp_term_jxh.category_code);
            wp_post_jxh.setUrl(href);
            wp_post_jxh.setFather_url(url);
//                        list2.add(wp_post_jxh);

            //每次插入之前先检查是否有标题相同的 如果有则标题名称后面 加一

            daoFactory.getWp_post_jxhDao().insert(wp_post_jxh);
        } catch (SQLException e) {
            log.error("插入Wp_post_jxh错误", e);
        }
    }


    public void spider766_3(String prefx, Wp_term_jxh wp_term_jxh, String baseurl, String classname, int startPage, int endPage) {
        //https://jsoup.org/apidocs/
        EaverydayArticleSpider testspider = new EaverydayArticleSpider();
        for (int i = startPage; i < endPage; i++) {
            List<Wp_post_jxh> list2 = new ArrayList<Wp_post_jxh>();
            String url = "";
            if (i == 1) {
                url = prefx + wp_term_jxh.url;
            } else {
                url = baseurl;
                url = String.format(url, i);
            }

            log.info("url={}", url);
            try {
                Document document = testspider.MakeArticle(url);
                Elements elements = document
                        .select("a[href ^=" + classname + "]")
                        .select("a[href $= .html]");
                log.info("条数={}", elements.size());


                for (Element element : elements) {
                    String title = element.text();
                    String href = element.attr("href");
                    if ("".equalsIgnoreCase(href)) {
                        continue;
                    }
                    if (href == null || title == null) {
                        continue;
                    }

                    if (href != null && href.indexOf("List") != -1) {
//                        list1.add(href);
                    } else {
                        log.info("数据={}", element.text() + "  " + element.attr("href"));
                        Wp_post_jxh wp_post_jxh = WpPostModel.getWp_post_jxh();
                        wp_post_jxh.setTitle(title.trim());
                        if (href.indexOf("http") == -1) {
                            href = prefx + href;
                        }
                        String content = GetContent(href, testspider, prefx);
                        if (content == null) continue;
                        wp_post_jxh.setContent(content.replaceAll("767股票学习网", ""));
                        wp_post_jxh.setDate_time(new Date());
                        wp_post_jxh.setCategory_id(wp_term_jxh.category_id);
                        wp_post_jxh.setCategory_code(wp_term_jxh.category_code);
                        wp_post_jxh.setUrl(href);
                        wp_post_jxh.setFather_url(url);
//                        list2.add(wp_post_jxh);
                        try {
                            //每次插入之前先检查是否有标题相同的 如果有则标题名称后面 加一

                            daoFactory.getWp_post_jxhDao().insert(wp_post_jxh);
                        } catch (SQLException e) {
                            log.error("插入Wp_post_jxh错误", e);
                        }
                    }
                }
            } catch (Exception e) {
                log.error("错误｛｝", e);
            }
            //写入数据库
            if (list2.size() > 0) {
                for (Wp_post_jxh wp_post_jxh : list2) {
                    try {
                        //每次插入之前先检查是否有标题相同的 如果有则标题名称后面 加一

                        daoFactory.getWp_post_jxhDao().insert(wp_post_jxh);
                    } catch (SQLException e) {
                        log.error("插入Wp_post_jxh错误", e);
                    }
                }
            }

        }
    }

    /**
     * 遍历取代
     *
     * @param elements3
     * @param content
     * @return
     */
    public String ReplaceStr(Elements elements3, String content) {
        if (elements3 != null && elements3.size() > 0) {
            for (Element element1 : elements3) {
                content = content.replace(element1.outerHtml(), "");
            }
        }
        return content;
    }

    public String GetContent2(String url, EaverydayArticleSpider testspider, String prefx) {
        Document document2 = null;
        try {
            document2 = testspider.MakeArticle(url);
            Elements elements2 = document2.select(".neirong").select("FONT");
            if (elements2.size() > 0) {
//                String content = elements2.get(0).text();
                Element element = elements2.get(0);
                element = AddImagePrefx(element, prefx);
                String content = element.html();
//                log.info("content={}",content);
                //获取里面的连接地址 检查是否还有下一页
                elements2 = element.select("a");
                System.out.println("elements2.size()=" + elements2.size());
                if (elements2.size() > 0) {
                    //遍历
                    for (Element element1 : elements2) {
                        String href = element1.attr("href");
                        if (href == null) {
                            continue;
                        }
                        if (href.contains("net767.com")) {
                            //内容清除掉
                            content = content.replace(element1.toString(), "");
                        }
                    }
                    //添加内容
                    Elements elements3 = element.select("div");
                    content = ReplaceStr(elements3, content);
                }
                return content;
            }
        } catch (IOException e) {
            log.error("解析错误", e);
        }
        return null;
    }

    public String GetContent(String url, EaverydayArticleSpider testspider, String prefx) {
        Document document2 = null;
//        String prefx = "http://www.net767.com";
        try {
            document2 = testspider.MakeArticle(url);
            Elements elements2 = document2.select(".neirong").select("FONT");
            if (elements2.size() > 0) {
                StringBuffer sb = new StringBuffer();
                Element element = elements2.get(0);
                element = AddImagePrefx(element, prefx);
                String content = element.html();
//                log.info("content={}",content);
                //获取里面的连接地址 检查是否还有下一页
                elements2 = element.select("a");
                System.out.println("elements2.size()=" + elements2.size());
                if (elements2.size() > 0) {
                    List<String> list = new ArrayList<String>();
                    //遍历
                    for (Element element1 : elements2) {
                        //System.out.println("element1.outerHtml="+element1.outerHtml());
                        //System.out.println("element1.toString="+element1.toString());
                        String href = element1.attr("href");
                        if (href == null) {
                            continue;
                        }
                        if (href.contains("net767.com")) {
                            //内容清除掉
                            content = content.replace(element1.toString(), "");
                        } else {
                            list.add(href);
                        }
                    }
                    //添加内容
                    //添加内容
                    Elements elements3 = element.select("div");
                    content = ReplaceStr(elements3, content);
                    sb.append(content);
                    //----------------这里处理如果还有没有完全的分页内容-------------------------
                    if (list.size() > 0) {
                        //有数据
                        for (String surl : list) {
                            if (surl.indexOf("http") == -1) {
                                surl = prefx + surl;
                            }
                            String content_temp = GetContent2(surl, testspider, prefx);
                            if (content_temp == null || "".equalsIgnoreCase(content_temp)) {
                                continue;
                            }
                            sb.append("\r\n").append("<!--nextpage-->").append("\r\n");
                            sb.append(content_temp);
                        }
                    }

                    //-----------------------------------------
                    return sb.toString();
                } else {
                    return content;
                }

            } else {
                //不是内容页面


            }
        } catch (IOException e) {
            log.error("解析错误", e);
        }
        return null;
    }

    /**
     * 检查是否是内容
     *
     * @param testspider
     * @return false:不是 true:是
     */
    public boolean checkIsContent(EaverydayArticleSpider testspider, Document document) {

        Elements elements2 = document.select(".neirong").select("FONT");
        if (elements2.size() > 0) {
            //是内容
            return true;
        }
        return false;
    }

    /**
     * 获取目录
     *
     * @return
     */
    public String GetMuLu(String ss) {
        //String ss = "/book/duanxianshiyin/201003/17399.html";
        ss = ss.replace(ss.substring(ss.lastIndexOf("/")), "");
        return ss.replace(ss.substring(ss.lastIndexOf("/")), "");
    }

    /**
     * 给内容里面的图片 添加上访问全地址  就是图片访问的前缀
     */
    public Element AddImagePrefx(Element element, String prefx) {
        try {
            Elements elements = element.select("img");
            if (elements != null && elements.size() > 0) {
                for (int i = 0; i < elements.size(); i++) {
                    Element element1 = elements.get(i);
                    String src = element1.attr("src");
                    if (src.indexOf("http") == -1) {
                        if (src.indexOf("/") == 0) {
                            src = prefx + src;
                        } else {
                            src = prefx + "/" + src;
                        }
                        element1.attr("src", src);
                    }
                }
            }
        } catch (Exception e) {
            log.error("AddImagePrefx=>错误{}", e.getMessage());
        }
        return element;
    }

    /**
     * 新增分类目录
     *
     * @throws IOException
     */
    @Transactional(rollbackFor = QzException.class)
    public void addClass(Wp_terms wp_terms, Long fatherId, String url, String fatherurl) throws QzException {
        if (wp_terms == null) {
            return;
        }
        try {
            //首先检查是否存在 wp_terms
            String sql = "select * from wp_terms where name=? limit 1";
            Wp_terms wp_terms2 = getMySelfService().queryUniqueT(sql, Wp_terms.class, wp_terms.getName());
            if (wp_terms2 != null) {
                return;
            }

            //首先验证是否新增二级目录 如果是则需要对 目录关系表中添加数据
            if (fatherId == null) {
                //只是一级目录
                int id = daoFactory.getWp_termsDao().insert(wp_terms);
                if (id < 1) {
                    throw new QzException("addClass:daoFactory.getWp_termsDao().insert(wp_terms)  is error");
                }
                wp_terms.setTerm_id(id);

                Wp_term_jxh wp_term_jxh = new Wp_term_jxh();
                wp_term_jxh.setCategory_code(wp_terms.getSlug());
                wp_term_jxh.setCategory_id(wp_terms.getTerm_id());
                wp_term_jxh.setCtime(new Date());
                wp_term_jxh.setFatherurl(fatherurl);
                wp_term_jxh.setName(wp_terms.getName());
                wp_term_jxh.setUrl(url);
                wp_term_jxh.setCategory_father_id(fatherId);
                id = daoFactory.getWp_term_jxhDao().insert(wp_term_jxh);
                if (id < 1) {
                    throw new QzException("addClass:daoFactory.getWp_term_jxhDao().insert(wp_term_jxh)  is error");
                }

            } else {
                //二级目录
                int id = daoFactory.getWp_termsDao().insert(wp_terms);
                if (id < 1) {
                    throw new QzException("addClass:daoFactory.getWp_termsDao().insert(wp_terms)  is error");
                }
                wp_terms.setTerm_id(id);
                //插入成功
                Wp_term_taxonomy wp_term_taxonomy = new Wp_term_taxonomy();
                wp_term_taxonomy.setParent(fatherId);
                wp_term_taxonomy.setTerm_id(id);
                wp_term_taxonomy.setTaxonomy("category");
                wp_term_taxonomy.setDescription("");
                id = daoFactory.getWp_term_taxonomyDao().insert(wp_term_taxonomy);
                if (id < 1) {
                    throw new QzException("addClass:daoFactory.getWp_term_taxonomyDao().insert(wp_term_taxonomy)  is error");
                }

                Wp_term_jxh wp_term_jxh = new Wp_term_jxh();
                wp_term_jxh.setCategory_code(wp_terms.getSlug());
                wp_term_jxh.setCategory_id(wp_terms.getTerm_id());
                wp_term_jxh.setCtime(new Date());
                wp_term_jxh.setFatherurl(fatherurl);
                wp_term_jxh.setName(wp_terms.getName());
                wp_term_jxh.setUrl(url);
                wp_term_jxh.setCategory_father_id(fatherId);
                id = daoFactory.getWp_term_jxhDao().insert(wp_term_jxh);
                if (id < 1) {
                    throw new QzException("addClass:daoFactory.getWp_term_jxhDao().insert(wp_term_jxh)  is error");
                }
            }

        } catch (Exception e) {
            log.error("addClass  is error", e);
            throw new QzException("addClass  is error", e);
        }
    }


    /**
     * 添加分类目录或者二级目录
     *
     * @param fatherId
     * @param url
     * @throws IOException
     * @throws QzException
     */
    public void addClassMain(Long fatherId, String url) throws IOException, QzException {
//        String url = "http://www.net767.com";
        EaverydayArticleSpider testspider = new EaverydayArticleSpider();
//        String prefx = "http://www.net767.com";
        Document document2 = testspider.MakeArticle(url);
        //<P style="MARGIN-TOP: 4px; FONT-SIZE: 14px; MARGIN-BOTTOM
        Elements elements = document2.select("p[style^=MARGIN-TOP: 4px; FONT-SIZE: 14px; MARGIN-BOTTOM]");
        elements = elements.select("a");
        if (elements.size() == 0) {
            System.out.println("没有数据");
            return;
        }
        for (Element element : elements) {
            System.out.println(element.toString());
            String title = element.text();
            String href = element.attr("href");
            Wp_terms wp_terms = new Wp_terms();
            wp_terms.setName(title);
            wp_terms.setSlug(PinYin.getShortPinYin(title));
            wp_terms.setTerm_group(0);

            addClass(wp_terms, fatherId, href, url);
        }
    }


    /**
     * 新增分类目录
     *
     * @throws IOException
     */
    public List<Wp_term_jxh> FindWptermsJxh(long fatherId) {
        try {
            //首先检查是否存在 wp_terms
            String sql = "select * from wp_term_jxh where category_father_id=?";
            List<Wp_term_jxh> wp_terms_list = getMySelfService().queryListT(sql, Wp_term_jxh.class, fatherId);
            return wp_terms_list;
        } catch (Exception e) {
            log.error("addClass  is error", e);
        }
        return null;
    }

}

//<!--nextpage-->