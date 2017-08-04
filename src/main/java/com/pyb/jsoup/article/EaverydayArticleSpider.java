package com.pyb.jsoup.article;

import com.pyb.jsoup.BaseSpider;
import com.pyb.jsoup.article.model.ArticleModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * eaveryday spider article
 */
public class EaverydayArticleSpider extends BaseSpider {
    /**
     * make content spider
     */
    public Document MakeArticle(String url) throws MalformedURLException ,IOException {
        URL xx = new URL(url);
        Document document = Jsoup.parse(xx, 600);
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
