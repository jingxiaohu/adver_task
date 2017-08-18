package com.pyb.jsoup.article;

import com.pyb.bean.Wp_post_jxh;
import com.pyb.jsoup.article.model.WpPostModel;
import com.pyb.mvc.service.BaseBiz;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
                    if (href == null || title== null){continue;}

                    if (href != null && href.indexOf("List") != -1){
                        href = prefx+href;
//                        list1.add(href);
                    }else{
                        log.info("数据={}",element.text()+"  "+element.attr("href"));
                        Wp_post_jxh wp_post_jxh = WpPostModel.getWp_post_jxh();
                        wp_post_jxh.setTitle(title.trim());
                        if(href.indexOf("http:") == -1){
                            href = prefx+href;
                        }
                        String content = GetContent( href, testspider);
                        if (content == null) continue;
                        wp_post_jxh.setContent(content.replaceAll("767股票学习网",""));
                        wp_post_jxh.setDate_time(new Date());
                        wp_post_jxh.setCategory_id(10);
                        wp_post_jxh.setCategory_code("study");
                        wp_post_jxh.setUrl(prefx+href);
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
    public  void spider766_3(String CategoryCode , String baseurl,String classname,int startPage,int endPage){
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
                    if (href == null || title== null){continue;}

                    if (href != null && href.indexOf("List") != -1){
                        href = prefx+href;
//                        list1.add(href);
                    }else{
                        log.info("数据={}",element.text()+"  "+element.attr("href"));
                        //获取内容之前 先检查是否不是最终的内容页面
                        if(href.indexOf("http:") == -1){
                            href = prefx+href;
                        }
                        if (!checkIsContent(href,testspider)){

                        }else{

                        }


                        String content = GetContent( href, testspider);
                        /*if(){

                        }*/





                        Wp_post_jxh wp_post_jxh = WpPostModel.getWp_post_jxh();
                        wp_post_jxh.setTitle(title.trim());
                        if (content == null) continue;
                        wp_post_jxh.setContent(content.replaceAll("767股票学习网",""));
                        wp_post_jxh.setDate_time(new Date());
                        wp_post_jxh.setCategory_id(10);
                        wp_post_jxh.setCategory_code("study");
                        wp_post_jxh.setUrl(prefx+href);
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

    public String GetContent2(String url,EaverydayArticleSpider testspider)  {
        Document document2 = null;
        try {
            document2 = testspider.MakeArticle(url);
            Elements elements2  =  document2.select("neirong").select("FONT");
            if (elements2.size() > 0){
//                String content = elements2.get(0).text();
                Element element = elements2.get(0);
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

    public String GetContent(String url,EaverydayArticleSpider testspider)  {
        Document document2 = null;
        String prefx = "http://www.net767.com";
        try {
            document2 = testspider.MakeArticle(url);
            Elements elements2  =  document2.select("neirong").select("FONT");
            if (elements2.size() > 0){
                StringBuffer sb = new StringBuffer();
                Element element = elements2.get(0);
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
                            if(surl.indexOf("http:") == -1){
                                surl = prefx+surl;
                            }
                            String content_temp  =  GetContent2( surl, testspider);
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
     * @param url
     * @param testspider
     * @return false:不是 true:是
     */
    public boolean checkIsContent(String url,EaverydayArticleSpider testspider){
        Document document2 = null;
        try {
            document2 = document2 = testspider.MakeArticle(url);
        } catch (IOException e) {
            log.error("错误");
        }
        Elements elements2  =  document2.select("neirong").select("FONT");
        if(elements2.size() > 0){
            //是内容
            return  true;
        }
        return  false;
    }








}

//<!--nextpage-->