package pyb.com.spider;

import com.pyb.bean.Wp_posts;
import com.pyb.jsoup.article.EaverydayArticleSpider;
import com.pyb.jsoup.article.Study766;
import com.pyb.jsoup.article.model.WpPostModel;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pyb.com.BaseWebTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class TestSpiderArticle extends BaseWebTest{
    Logger log = LoggerFactory.getLogger(this.getClass());
    @Test
    public void  spiderArticle(){
        //https://jsoup.org/apidocs/
        String url = "http://www.net767.com/gupiao/gupiao2/List_1.html";
        EaverydayArticleSpider testspider = new EaverydayArticleSpider();
        try {
            Document document = testspider.MakeArticle(url);
            Elements elements  =  document
                    .select("a[href ^= /gupiao/gupiao2/]")
                    .select("a[href $= .html]");
            System.out.println(elements.size());
            //定义 第一级的集合
            List list1 = new ArrayList<String>();

            for (Element element : elements) {
                System.out.println(element.text()+"  "+element.attr("href"));
            }
        } catch (IOException e) {
            log.error("错误｛｝",e);
        }
    }
    @Test
    public void tt(){
        String baseurl = "http://www.net767.com/gupiao/gupiao2/List_%s.html";
        spider766("c767" ,baseurl,1,11);
    }




    public  void spider766(String CategoryCode , String baseurl,int startPage,int endPage){
        //https://jsoup.org/apidocs/
        EaverydayArticleSpider testspider = new EaverydayArticleSpider();
        String prefx = "http://www.net767.com";
        for (int i = startPage; i < endPage; i++) {
            String url = "http://www.net767.com/gupiao/gupiao2/List_%s.html";
            url = String.format(url,i);
            log.info("url={}",url);
            try {
                Document document = testspider.MakeArticle(url);
                Elements elements  =  document
                        .select("a[href ^= /gupiao/gupiao2/]")
                        .select("a[href $= .html]");
                log.info("条数={}",elements.size());
                //定义 第一级的集合
//                List list1 = new ArrayList<String>();
                List list2 = new ArrayList<Wp_posts>();

                for (Element element : elements) {
                    String title = element.text();
                    String href = element.attr("href");
                    if (href == null || title== null){continue;}

                    if (href != null && href.indexOf("List") != -1){
                        href = prefx+href;
//                        list1.add(href);
                    }else{
                        log.info("数据={}",element.text()+"  "+element.attr("href"));
                        Wp_posts wp_posts = WpPostModel.getWp_posts();
                        wp_posts.setPost_title(title.trim());
                        String content = GetContent( prefx+href, testspider);
                        if (content == null) continue;
                        wp_posts.setPost_content(URLEncoder.encode(content,"UTF-8"));
                        list2.add(wp_posts);
                    }
                }
            } catch (Exception e) {
                log.error("错误｛｝",e);
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
@Resource  //自动注入,默认按名称
private Study766 study766;
@Test
public void  executeSql(){
//        study766.DoPostData();
        study766.DoPostData("stock",1,4);
}






}
