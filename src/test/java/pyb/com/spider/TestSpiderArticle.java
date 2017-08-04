package pyb.com.spider;

import com.pyb.jsoup.article.EaverydayArticleSpider;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class TestSpiderArticle {
    Logger log = LoggerFactory.getLogger(this.getClass());
    @Test
    public void  spiderArticle(){
        String url = "http://finance.cngold.org/c/2017-08-02/c5209208.html";
        EaverydayArticleSpider xx = new EaverydayArticleSpider();
        try {
            Document document = xx.MakeArticle(url);
            xx.MakeModel(document);
        } catch (IOException e) {
            log.error("错误｛｝",e);
        }
    }
    @Test
    public  void tt(){
        System.out.println("abcdefg".getBytes().length);
    }
}
