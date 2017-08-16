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
        spider766("study" ,baseurl,1,11);
    }




    public  void spider766(String CategoryCode , String baseurl,int startPage,int endPage){
        //定义 第一级的集合
        //https://jsoup.org/apidocs/
        EaverydayArticleSpider testspider = new EaverydayArticleSpider();
        String prefx = "http://www.net767.com";
        for (int i = startPage; i < endPage; i++) {
            List<Wp_post_jxh> list2 = new ArrayList<Wp_post_jxh>();
            String url = "http://www.net767.com/gupiao/gupiao2/List_%s.html";
            url = String.format(url,i);
            log.info("url={}",url);
            try {
                Document document = testspider.MakeArticle(url);
                Elements elements  =  document
                        .select("a[href ^= /gupiao/gupiao2/]")
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
                        String content = GetContent( prefx+href, testspider);
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
                        daoFactory.getWp_post_jxhDao().insert(wp_post_jxh);
                    } catch (SQLException e) {
                        log.error("插入Wp_post_jxh错误",e);
                    }
                }
            }

        }
    }

    public String GetContent(String url,EaverydayArticleSpider testspider)  {
        Document document2 = null;
        try {
            document2 = testspider.MakeArticle(url);
            Elements elements2  =  document2.select(".neirong");
            if (elements2.size() == 1){
                String content = elements2.get(0).text();
                log.info("content={}",content);
                return content;
            }
        } catch (IOException e) {
            log.error("解析错误",e);
        }
        return null;
    }

}
