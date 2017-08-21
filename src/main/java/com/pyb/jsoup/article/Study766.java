package com.pyb.jsoup.article;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
@Service
public class Study766 extends BaseBiz{
    Logger log = LoggerFactory.getLogger(Study766.class);


    public void DoPostData(){
        String baseurl = "http://www.net767.com/gupiao/gupiao2/List_%s.html";
        spider766("study" ,baseurl,"gupiao2",1,11);
    }
    //http://www.net767.com/gupiao/stock/
    public void DoPostData(String classname,int startpage,int endpage){
        String baseurl = "http://www.net767.com/gupiao/"+classname+"/List_%s.html";
        spider766("study" ,baseurl,classname,startpage,endpage);
    }
    //http://www.net767.com/gupiao/stock/
    //String baseurl = "http://www.net767.com/gupiao/"+classname+"/List_%s.html";
    public void DoPostData(String baseurl,String classname,int startpage,int endpage){
        spider766("study" ,baseurl,classname,startpage,endpage);
    }


    public  void spider766(String CategoryCode , String baseurl,String classname,int startPage,int endPage){
        //定义 第一级的集合
        //https://jsoup.org/apidocs/
        EaverydayArticleSpider testspider = new EaverydayArticleSpider();
        String prefx = "http://www.net767.com";
        for (int i = startPage; i < endPage; i++) {
            List<Wp_post_jxh> list2 = new ArrayList<Wp_post_jxh>();
            String url = baseurl;
            url = String.format(url,i);
            log.info("url={}",url);
            try {
                Document document = testspider.MakeArticle(url);
                Elements elements  =  document
                        .select("a[href ^= /gupiao/"+classname+"]")
                        .select("a[href $= .html]");
                log.info("条数={}",elements.size());


                for (Element element : elements) {
                    String title = element.text();
                    String href = element.attr("href");
                    if("".equalsIgnoreCase(href)){continue;}
                    if (href == null || title== null){continue;}

                    if (href != null && href.indexOf("List") != -1){
                        href = prefx+href;
//                        list1.add(href);
                    }else{
                        log.info("数据={}",element.text()+"  "+element.attr("href"));
                        Wp_post_jxh wp_post_jxh = WpPostModel.getWp_post_jxh();
                        wp_post_jxh.setTitle(title.trim());
                        if(href.indexOf("http") == -1){
                            href = prefx+href;
                        }
                        String content = GetContent( href, testspider,prefx);
                        if (content == null) continue;
                        wp_post_jxh.setContent(content.replaceAll("767股票学习网",""));
                        wp_post_jxh.setDate_time(new Date());
                        wp_post_jxh.setCategory_id(10);
                        wp_post_jxh.setCategory_code("study");
                        wp_post_jxh.setUrl(href);
                        wp_post_jxh.setFather_url(url);
                        list2.add(wp_post_jxh);
                    }
                }
            } catch (Exception e) {
                log.error("错误｛｝",e);
            }
            //写入数据库
            if (list2.size() > 0){
                for (Wp_post_jxh wp_post_jxh : list2) {
                    try {
                        //每次插入之前先检查是否有标题相同的 如果有则标题名称后面 加一

                        daoFactory.getWp_post_jxhDao().insert(wp_post_jxh);
                    } catch (SQLException e) {
                        log.error("插入Wp_post_jxh错误",e);
                    }
                }
            }

        }
    }





    public  void spider766_3( String prefx,Wp_term_jxh wp_term_jxh , String baseurl,String classname,int startPage,int endPage){
        //定义 第一级的集合
        //https://jsoup.org/apidocs/
        //定义 第一级的集合
        //https://jsoup.org/apidocs/
        EaverydayArticleSpider testspider = new EaverydayArticleSpider();
//        String prefx = "http://www.net767.com";
        for (int i = startPage; i < endPage; i++) {
            List<Wp_post_jxh> list2 = new ArrayList<Wp_post_jxh>();
            String url = "";
            if(i == 1){
                url = prefx+wp_term_jxh.url;
            }else{
                url = baseurl;
                url = String.format(url,i);
            }

            log.info("url={}",url);
            try {
                Document document = testspider.MakeArticle(url);
                Elements elements  =  document
                        .select("a[href ^="+classname+"]")
                        .select("a[href $= .html]");
                log.info("条数={}",elements.size());


                for (Element element : elements) {
                    String title = element.text();
                    String href = element.attr("href");
                    if("".equalsIgnoreCase(href)){continue;}
                    if (href == null || title== null){continue;}

                    if (href != null && href.indexOf("List") != -1){
//                        list1.add(href);
                    }else{
                        log.info("数据={}",element.text()+"  "+element.attr("href"));
                        Wp_post_jxh wp_post_jxh = WpPostModel.getWp_post_jxh();
                        wp_post_jxh.setTitle(title.trim());
                        if(href.indexOf("http") == -1){
                            href = prefx+href;
                        }
                        String content = GetContent( href, testspider,prefx);
                        if (content == null) continue;
                        wp_post_jxh.setContent(content.replaceAll("767股票学习网",""));
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
                            log.error("插入Wp_post_jxh错误",e);
                        }
                    }
                }
            } catch (Exception e) {
                log.error("错误｛｝",e);
            }
            //写入数据库
            if (list2.size() > 0){
                for (Wp_post_jxh wp_post_jxh : list2) {
                    try {
                        //每次插入之前先检查是否有标题相同的 如果有则标题名称后面 加一

                        daoFactory.getWp_post_jxhDao().insert(wp_post_jxh);
                    } catch (SQLException e) {
                        log.error("插入Wp_post_jxh错误",e);
                    }
                }
            }

        }
    }

    /**
     * 遍历取代
     * @param elements3
     * @param content
     * @return
     */
    public String ReplaceStr(Elements elements3,String content){
        if (elements3 != null && elements3.size() > 0){
            for (Element element1 : elements3) {
                content = content.replace(element1.outerHtml(),"");
            }
        }
        return content;
    }

    public String GetContent2(String url,EaverydayArticleSpider testspider,String prefx)  {
        Document document2 = null;
        try {
            document2 = testspider.MakeArticle(url);
            Elements elements2  =  document2.select(".neirong").select("FONT");
            if (elements2.size() > 0){
//                String content = elements2.get(0).text();
                Element element = elements2.get(0);
                element = AddImagePrefx( element, prefx);
                String content = element.html();
//                log.info("content={}",content);
                //获取里面的连接地址 检查是否还有下一页
                elements2 = element.select("a");
                System.out.println("elements2.size()="+elements2.size());
                if (elements2.size() > 0){
                    //遍历
                    for (Element element1 : elements2) {
                        String href = element1.attr("href");
                        if (href == null){
                            continue;
                        }
                        if (href.contains("net767.com")){
                            //内容清除掉
                            content = content.replace(element1.toString(),"");
                        }
                    }
                    //添加内容
                    Elements elements3 = element.select("div");
                    content = ReplaceStr(elements3,content);
                }
                return content;
            }
        } catch (IOException e) {
            log.error("解析错误",e);
        }
        return null;
    }

    public String GetContent(String url,EaverydayArticleSpider testspider,String prefx)  {
        Document document2 = null;
//        String prefx = "http://www.net767.com";
        try {
            document2 = testspider.MakeArticle(url);
            Elements elements2  =  document2.select(".neirong").select("FONT");
            if (elements2.size() > 0){
                StringBuffer sb = new StringBuffer();
                Element element = elements2.get(0);
                element = AddImagePrefx( element, prefx);
                String content = element.html();
//                log.info("content={}",content);
                //获取里面的连接地址 检查是否还有下一页
                elements2 = element.select("a");
                System.out.println("elements2.size()="+elements2.size());
                if (elements2.size() > 0){
                    List<String> list = new ArrayList<String>();
                    //遍历
                    for (Element element1 : elements2) {
                        //System.out.println("element1.outerHtml="+element1.outerHtml());
                        //System.out.println("element1.toString="+element1.toString());
                        String href = element1.attr("href");
                        if (href == null){
                            continue;
                        }
                        if (href.contains("net767.com")){
                            //内容清除掉
                            content = content.replace(element1.toString(),"");
                        }else{
                            list.add(href);
                        }
                    }
                    //添加内容
                    //添加内容
                    Elements elements3 = element.select("div");
                    content = ReplaceStr(elements3,content);
                    sb.append(content);
                    //----------------这里处理如果还有没有完全的分页内容-------------------------
                    if(list.size() > 0){
                        //有数据
                        for (String surl : list) {
                            if(surl.indexOf("http") == -1){
                                surl = prefx+surl;
                            }
                            String content_temp  =  GetContent2( surl, testspider,prefx);
                            if (content_temp == null || "".equalsIgnoreCase(content_temp)){
                                continue;
                            }
                            sb.append("\r\n").append("<!--nextpage-->").append("\r\n");
                            sb.append(content_temp);
                        }
                    }

                    //-----------------------------------------
                    return sb.toString();
                }else{
                    return content;
                }

            }else{
                //不是内容页面


            }
        } catch (IOException e) {
            log.error("解析错误",e);
        }
        return null;
    }

    /**
     * 检查是否是内容
     * @param testspider
     * @return false:不是 true:是
     */
    public boolean checkIsContent(EaverydayArticleSpider testspider,Document document){

        Elements elements2  =  document.select(".neirong").select("FONT");
        if(elements2.size() > 0){
            //是内容
            return  true;
        }
        return  false;
    }

    /**
     * 获取目录
     * @return
     */
    public String  GetMuLu(String ss){
        //String ss = "/book/duanxianshiyin/201003/17399.html";
        ss = ss.replace(ss.substring(ss.lastIndexOf("/")),"" );
       return ss.replace(ss.substring(ss.lastIndexOf("/")),"" );
    }

    /**
     * 给内容里面的图片 添加上访问全地址  就是图片访问的前缀
     */
    public Element AddImagePrefx(Element element,String prefx){
        try {
            Elements elements = element.select("img");
            if(elements != null && elements.size() > 0){
                for (int i = 0; i < elements.size(); i++) {
                    Element element1 = elements.get(i);
                    String src = element1.attr("src");
                    if(src.indexOf("http") == -1){
                        if(src.indexOf("/") == 0){
                            src = prefx+src;
                        }else{
                            src = prefx+"/"+src;
                        }
                        element1.attr("src",src);
                    }
                }
            }
        } catch (Exception e) {
            log.error("AddImagePrefx=>错误{}",e.getMessage());
        }
        return element;
    }

    /**
     * 新增分类目录
     * @throws IOException
     */
    @Transactional(rollbackFor = QzException.class)
    public void addClass(Wp_terms wp_terms, Long fatherId,String url,String fatherurl) throws QzException {
        if(wp_terms == null ){
                return ;
        }
        try {
        //首先检查是否存在 wp_terms
            String sql = "select * from wp_terms where name=? limit 1";
            Wp_terms wp_terms2 = getMySelfService().queryUniqueT(sql,Wp_terms.class,wp_terms.getName());
            if (wp_terms2 != null){
                return;
            }

        //首先验证是否新增二级目录 如果是则需要对 目录关系表中添加数据
        if(fatherId == null){
              //只是一级目录
                int id = daoFactory.getWp_termsDao().insert(wp_terms);
                if(id < 1){
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
                if(id < 1){
                    throw new QzException("addClass:daoFactory.getWp_term_jxhDao().insert(wp_term_jxh)  is error");
                }

        }else{
            //二级目录
                int id =  daoFactory.getWp_termsDao().insert(wp_terms);
                if(id < 1){
                    throw new QzException("addClass:daoFactory.getWp_termsDao().insert(wp_terms)  is error");
                }
                wp_terms.setTerm_id(id);
                //插入成功
                Wp_term_taxonomy wp_term_taxonomy = new Wp_term_taxonomy();
                wp_term_taxonomy.setParent(fatherId);
                wp_term_taxonomy.setTerm_id(id);
                wp_term_taxonomy.setTaxonomy("category");
                wp_term_taxonomy.setDescription("");
                id  = daoFactory.getWp_term_taxonomyDao().insert(wp_term_taxonomy);
                if(id < 1){
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
                if(id < 1){
                    throw new QzException("addClass:daoFactory.getWp_term_jxhDao().insert(wp_term_jxh)  is error");
                }
        }

        } catch (Exception e) {
            log.error("addClass  is error",e);
            throw new QzException("addClass  is error",e);
        }
    }



    /**
     * 添加分类目录或者二级目录
     * @param fatherId
     * @param url
     * @throws IOException
     * @throws QzException
     */
    public void addClassMain(Long fatherId,String url) throws IOException, QzException {
//        String url = "http://www.net767.com";
        EaverydayArticleSpider testspider = new EaverydayArticleSpider();
//        String prefx = "http://www.net767.com";
        Document document2 = testspider.MakeArticle(url);
        //<P style="MARGIN-TOP: 4px; FONT-SIZE: 14px; MARGIN-BOTTOM
        Elements elements  =  document2.select("p[style^=MARGIN-TOP: 4px; FONT-SIZE: 14px; MARGIN-BOTTOM]");
        elements = elements.select("a");
        if(elements.size() == 0){
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

            addClass(wp_terms, fatherId, href,url);
        }
    }


    /**
     * 新增分类目录
     * @throws IOException
     */
    public List<Wp_term_jxh> FindWptermsJxh(long fatherId) {
        try {
            //首先检查是否存在 wp_terms
            String sql = "select * from wp_term_jxh where category_father_id=?";
            List<Wp_term_jxh> wp_terms_list = getMySelfService().queryListT(sql,Wp_term_jxh.class,fatherId);
            return wp_terms_list;
        } catch (Exception e) {
            log.error("addClass  is error",e);
        }
        return null;
    }

}

//<!--nextpage-->