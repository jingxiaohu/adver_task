package com.pyb.jsoup.article;

import com.pyb.jsoup.BaseSpider;
import com.pyb.jsoup.article.model.ArticleModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * eaveryday spider article
 * https://jsoup.org/apidocs/
 */
public class EaverydayArticleSpider extends BaseSpider {
    Logger log = LoggerFactory.getLogger(EaverydayArticleSpider.class);
    /**
     * make content spider
     */
    public Document MakeArticle(String url) throws MalformedURLException ,IOException {
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        URL xx = new URL(url);
        Document document = Jsoup.parse(xx, 12000);
//        log.info(document.html());
        return document;
    }

    public ArticleModel MakeModel(Document document ){
        if (document == null){
            return null;
        }
        /**
         *  进行过滤
         */
        String titile = document.title();//标题
//        String content = document.get
       /* Elements list_node = document.select("p");
        for (Element element : list_node) {
            System.out.println(element.html());
            System.out.println(element.parent().html());
        }*/
        Elements list_node = document.getElementsByTag("p");
        for (Element element : list_node) {
            System.out.println(element.html());
            System.out.println(element.parent().html());
        }
        ArticleModel articleModel = new ArticleModel();
        return  articleModel;
    }
}
