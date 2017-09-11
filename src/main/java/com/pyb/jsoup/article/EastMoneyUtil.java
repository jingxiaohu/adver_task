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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://jsoup.org/apidocs/
 */
@Service
public class EastMoneyUtil extends BaseBiz {
    static Logger log = LoggerFactory.getLogger(Nfcj_singleStock_Spider.class);

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


    /**
     * 入口：：：：：：
     * http://www.cs.com.cn/gppd/tzpj/
     */
    public void DoWithRecursion() {
        try {
            String prefx = "http://finance.eastmoney.com/news/";
            String url = "http://finance.eastmoney.com/news/cywjh.html";
            Wp_term_jxh wp_term_jxh = new Wp_term_jxh();
            wp_term_jxh.setCategory_code("zqyw");//证券要闻精华
            wp_term_jxh.setCategory_id(92);
            DoWithContent(prefx,url, wp_term_jxh);

            prefx = "http://finance.eastmoney.com/news/";
            url = "http://finance.eastmoney.com/news/czqyw.html";
            wp_term_jxh = new Wp_term_jxh();
            wp_term_jxh.setCategory_code("zqyw");//证券要闻
            wp_term_jxh.setCategory_id(92);
            DoWithContent(prefx,url, wp_term_jxh);

            prefx = "http://finance.eastmoney.com/news/";
            url = "http://finance.eastmoney.com/news/cgnjj.html";
            wp_term_jxh = new Wp_term_jxh();
            wp_term_jxh.setCategory_code("cgnjj");//国内经济 cgnjj
            wp_term_jxh.setCategory_id(93);
            DoWithContent(prefx,url, wp_term_jxh);
        } catch (Exception e) {
            log.error("DoWithRecursion is error message={}", e.getMessage());
        }
    }

















   @Deprecated
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































    /**
     * dowith content s
     * @param prefx
     * @param url :内容URL
     * @param wp_term_jxh
     */
    public void DoWithContent(String prefx,String url,Wp_term_jxh wp_term_jxh) {
        try {
            EaverydayArticleSpider testspider = new EaverydayArticleSpider();
            List<Wp_post_jxh>  wp_post_jxhList =  FindurlList( wp_term_jxh, prefx, url, testspider);
            if (wp_post_jxhList != null && wp_post_jxhList.size() > 0){
                for ( Wp_post_jxh wp_post_jxh :  wp_post_jxhList){
                    String title = wp_post_jxh.getTitle();
                    String href = wp_post_jxh.getUrl();
                    log.info("数据 title={},href={}",title ,href);
                    if ("".equalsIgnoreCase(href)) {
                        return;
                    }
                    if (href == null || title == null) {
                        return;
                    }
                    //拿到标题之前先进行验证 是否已经存在了 如果存在则不进行后面的处理了
                    String sql = "select * from wp_post_jxh where title=? limit 1";
                    try {
                        Wp_post_jxh wp_post_jxh2 = getMySelfService().queryUniqueT(sql,Wp_post_jxh.class,title.trim());
                        if(wp_post_jxh2 != null){
                            //标题已经存在了
                            System.out.println(title.trim()+"  已经存在了");
                            return;
                        }
                    } catch (Exception e) {
                        log.error("查询错误",e);
                    }
                    if (href.indexOf("http") == -1) {
                        href = prefx + href;
                    }
                    String content = GetContent(href, testspider, prefx,url);
                    if (content == null || "".equals(content)) return;
                    //最后进行 搜索引擎的关键词SEO 优化
                    content = ContentDecorateLast(content);
                    wp_post_jxh.setContent(content);
                    //每次插入之前先检查是否有标题相同的 如果有则标题名称后面 加一
                    int id = daoFactory.getWp_post_jxhDao().insert(wp_post_jxh);
                    log.info("新插入 id==={}"+id);
                }
            }
        } catch (Exception e) {
            log.error("插入Wp_post_jxh错误", e);
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
            Elements elements2 = document2.select(".Body");
            if (elements2 == null || elements2.size() == 0) {
                return null;
            }
            StringBuffer sb = new StringBuffer();
            Element element = elements2.get(0);
            element = AddImagePrefx(element, prefx);
            String content = ContentDecorate(element);
            if (content == null || "".equalsIgnoreCase(content)){
                return  null;
            }
            return  content;
        } catch (IOException e) {
            log.error("解析错误", e);
        }
        return null;
    }

    public String GetContent(String url, EaverydayArticleSpider testspider, String prefx, String baseurl) {
        Document document2 = null;
        try {
            if (url.indexOf("http") == -1) {
                url = baseurl + url;
            }
            document2 = testspider.MakeArticle(url);
            Elements elements2 = document2.select(".Body");
            if (elements2 == null || elements2.size() == 0) {
                return null;
            }
            StringBuffer sb = new StringBuffer();
            Element element = elements2.get(0);
            element = AddImagePrefx(element, prefx);
            String content = ContentDecorate(element);
            if (content == null || "".equalsIgnoreCase(content)){
                return  null;
            }

            //添加内容
            sb.append(content);
            //                log.info("content={}",content);
            //获取里面的连接地址 检查是否还有下一页
            int pagecount = pagenum(url);
            if (pagecount < 2) {
                //没有下一页
                return sb.toString();
            } else {
                //遍历页面
                for (int page = 1; page < pagecount; page++) {
                    //----------------这里处理如果还有没有完全的分页内容-------------------------
                    String nexturl = nextPage(url, page);
                    String content_temp = GetContent2(nexturl, testspider, prefx);
                    if (content_temp == null || "".equalsIgnoreCase(content_temp)) {
                        continue;
                    }
                    sb.append("\r\n").append("<!--nextpage-->").append("\r\n");
                    sb.append(content_temp);
                }
            }
            return sb.toString();
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

        Elements elements2 = document.select(".Body");
        if (elements2.size() > 0) {
            //是内容
            return true;
        }
        return false;
    }

    /**
     * 内容装饰器
     */
    public String ContentDecorate(Element element){
        Elements elements = element.select(".pagesize");
        if (elements != null) {
            elements.remove();
        }
        elements = element.select("a[href $=.html]");
        if (elements != null && elements.size() > 0) {
            for (int i = 0; i < elements.size(); i++) {
                Element element2 = elements.get(i);
                element2.attr("href","");
            }
        }

        String content = element.html();
        int index = content.indexOf("<strong><span style=\"color:#ff0000\">");
        if(index != -1){
            content = content.substring(0,index)+"</div>";
        }
        //int index2 = content.lastIndexOf("</div>");
        return content;
    }

    /**
     * 内容装饰器
     */
    public String ContentDecorateLast(String content){
        StringBuffer sb = new StringBuffer();
        sb.append("<html>\n" +
                "<head>\n" +
                "<meta charset=\"gb2312\">\n" +
                "<title>个股行情,今日个股行情,股市行情</title>\n" +
                "<meta name=\"description\" content=\"股掌个股行情频道,为您提供最新最及时的个股动态行情及今日股票行情。\">\n" +
                "<meta name=\"Keywords\" content=\"今日个股行情,个股,个股行情,股票\">\n" +
                "</head>\n" +
                "<body>").append("\r\n").append(content).append("\r\n").append("</body>\n" +
                "</html>");
        return sb.toString();
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
//        String url = "http://www.southmoney.com/gegu/";
        EaverydayArticleSpider testspider = new EaverydayArticleSpider();
//        String prefx = "http://www.southmoney.com/gegu/";
        Document document2 = testspider.MakeArticle(url);
        // class="subLink"
        Elements elements = document2.select(".subLink");
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

    /**
     * 是否存在汉字
     * @param str
     * @return
     */
    public static boolean isContainChinese(String str) {

        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }




    public  List<Wp_post_jxh>  FindurlList(Wp_term_jxh wp_term_jxh,String prefx,String url,EaverydayArticleSpider testspider){
//        String url = "http://www.cs.com.cn/gppd/tzpj/";
//        EaverydayArticleSpider testspider = new EaverydayArticleSpider();
        Document document = null;
        try {
            List<Wp_post_jxh> list = new ArrayList<Wp_post_jxh>();
            document = testspider.MakeArticle(url);
            Elements elements = document.select("p[class=title]");
            if (elements == null || elements.size() == 0){
                return  null;
            }

            for (int i = 0; i < elements.size(); i++) {
                Element element = elements.get(i);
                element = element.select("a[href $=.html]").get(0);
                String title = element.text();
                String url_sub = element.attr("href");
                if (url_sub.indexOf("http") == -1) {
                    if(url_sub.startsWith("../")){
                        url_sub = prefx + url_sub.replace("../","");
                    }else{
                        url_sub = url + url_sub.replace("./","");
                    }
                }

                Wp_post_jxh wp_post_jxh = WpPostModel.getWp_post_jxh();
                wp_post_jxh.setFather_url(url);
                wp_post_jxh.setDate_time(new Date());
                wp_post_jxh.setTitle(title);
                wp_post_jxh.setUrl(url_sub);
                wp_post_jxh.setCategory_id(wp_term_jxh.category_id);
                wp_post_jxh.setCategory_code(wp_term_jxh.category_code);
                list.add(wp_post_jxh);
                }
            log.info("list.size=={}",list.size());
            if (list.size() == 0){
                return  null;
            }
            return list;
        } catch (Exception e) {
            log.error("解析错误", e);
        }
        return  null;
    }


    /**
     * 返回总页数
     * @param url
     * @return
     */
    public  int  pagenum(String url){
//        String url = "http://www.cs.com.cn/gppd/sjjj/201709/t20170908_5464697.html";
        EaverydayArticleSpider testspider = new EaverydayArticleSpider();
        Document document = null;
        try {
            document = testspider.MakeArticle(url);
            Elements elements = document.select(".pagesize").select(".page").select("a[href$=.html]");
            if(elements == null || elements.size() == 0){
                return 1;
            }
            int maxpage = 1;
            for (Element element : elements) {
                try {
                    String page = element.text();
                    if(Integer.parseInt(page) > maxpage){
                        maxpage = Integer.parseInt(page);
                    }
                } catch (NumberFormatException e) {

                }
            }
            return  maxpage;
        } catch (IOException e) {
            log.error("解析错误", e);
        }
        return  1;
    }

    public  String nextPage(String url,int page){
        if (page < 1){
            return  null;
        }
        int index = url.lastIndexOf(".");
        String suffix = url.substring(index);
        url =  url.substring(0,index)+"_"+page+suffix;
        log.info("nextpage_url={}",url);
        return  url;
    }
    public void  df(){
        nextPage("http://www.cs.com.cn/gppd/sjjj/201709/t20170908_5464697.html",2);
    }


}

//<!--nextpage-->