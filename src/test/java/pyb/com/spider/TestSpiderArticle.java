package pyb.com.spider;

import com.pyb.bean.Wp_posts;
import com.pyb.bean.Wp_term_jxh;
import com.pyb.jsoup.article.EaverydayArticleSpider;
import com.pyb.jsoup.article.Study766;
import com.pyb.jsoup.article.StudyUtil;
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

public class TestSpiderArticle extends BaseWebTest {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Test
    public void spiderArticle() {
        //https://jsoup.org/apidocs/
        String url = "http://www.net767.com/gupiao/gupiao2/List_1.html";
        EaverydayArticleSpider testspider = new EaverydayArticleSpider();
        try {
            Document document = testspider.MakeArticle(url);
            Elements elements = document
                    .select("a[href ^= /gupiao/gupiao2/]")
                    .select("a[href $= .html]");
            System.out.println(elements.size());
            //定义 第一级的集合
            List list1 = new ArrayList<String>();

            for (Element element : elements) {
                System.out.println(element.text() + "  " + element.attr("href"));
            }
        } catch (IOException e) {
            log.error("错误｛｝", e);
        }
    }

    @Test
    public void tt() {
        String baseurl = "http://www.net767.com/gupiao/gupiao2/List_%s.html";
        spider766("c767", baseurl, 1, 11);
    }


    public void spider766(String CategoryCode, String baseurl, int startPage, int endPage) {
        //https://jsoup.org/apidocs/
        EaverydayArticleSpider testspider = new EaverydayArticleSpider();
        String prefx = "http://www.net767.com";
        for (int i = startPage; i < endPage; i++) {
            String url = "http://www.net767.com/gupiao/gupiao2/List_%s.html";
            url = String.format(url, i);
            log.info("url={}", url);
            try {
                Document document = testspider.MakeArticle(url);
                Elements elements = document
                        .select("a[href ^= /gupiao/gupiao2/]")
                        .select("a[href $= .html]");
                log.info("条数={}", elements.size());
                //定义 第一级的集合
//                List list1 = new ArrayList<String>();
                List list2 = new ArrayList<Wp_posts>();

                for (Element element : elements) {
                    String title = element.text();
                    String href = element.attr("href");
                    if (href == null || title == null) {
                        continue;
                    }

                    if (href != null && href.indexOf("List") != -1) {
                        href = prefx + href;
//                        list1.add(href);
                    } else {
                        log.info("数据={}", element.text() + "  " + element.attr("href"));
                        Wp_posts wp_posts = WpPostModel.getWp_posts();
                        wp_posts.setPost_title(title.trim());
                        String content = GetContent(prefx + href, testspider);
                        if (content == null) continue;
                        wp_posts.setPost_content(URLEncoder.encode(content, "UTF-8"));
                        list2.add(wp_posts);
                    }
                }
            } catch (Exception e) {
                log.error("错误｛｝", e);
            }
        }

    }


    public String GetContent(String url, EaverydayArticleSpider testspider) {
        Document document2 = null;
        try {
            document2 = testspider.MakeArticle(url);
            Elements elements2 = document2.select(".neirong");
            if (elements2.size() == 1) {
                String content = elements2.get(0).text();
                log.info("content={}", content);
                return content;
            }
        } catch (IOException e) {
            log.error("解析错误", e);
        }
        return null;
    }

    @Resource  //自动注入,默认按名称
    private Study766 study766;
    @Resource
    private StudyUtil studyUtil;

    @Test
    public void executeSql() {
//        study766.DoPostData();
//        study766.DoPostData("stock",1,4);
        //String classname = "stock";
        //String baseurl = "http://www.net767.com/gupiao/"+classname+"/List_%s.html";
        //study766.DoPostData(baseurl,classname,1,4);
    /*try {
        study766.addClassMain((long) 11,"http://www.net767.com");
    } catch (Exception e) {

    }*/
    /*List<Wp_term_jxh> list =  study766.FindWptermsJxh(11);
    if(list != null && list.size() > 0){
        for (Wp_term_jxh wp_term_jxh : list) {
            try {
                String classname = wp_term_jxh.url;
                String baseurl = wp_term_jxh.fatherurl+classname+"/List_%s.html";
                study766.spider766_3( wp_term_jxh.fatherurl,  wp_term_jxh ,  baseurl, classname,1,8);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }*/
        //添加数据
       /* try {
            //<FONT color=#0d519c>
            EaverydayArticleSpider testspider = new EaverydayArticleSpider();
            //首先验证是否是内容
            Document document = testspider.MakeArticle("http://www.net767.com");
            //进行内容处理
            Elements elements = document.select("FONT[color=#0d519c]")
                    .select("a");
            // .select("a[href ^=" + classname + "]")
            //.select("a[href $= .html]");
            log.info("条数={}", elements.size());
            for (Element element : elements) {
                if(element.attr("target") != null && !"".equalsIgnoreCase(element.attr("target"))){
                        continue;
                }
//                System.out.println(element.toString());
                String text = element.text();
                String href = element.attr("href");
                System.out.println("text=" + text + "  href=" + href);
                try {
                    study766.addClassMain2((long) 11,"http://www.net767.com");
                } catch (Exception e) {

                }
            }
        } catch (Exception e) {
        }*/

        List<Wp_term_jxh> list =  studyUtil.FindWptermsJxh(11,40,42);
        if(list != null && list.size() > 0){
            for (Wp_term_jxh wp_term_jxh : list) {
                try {
                    String classname = wp_term_jxh.url;
                    String baseurl = wp_term_jxh.fatherurl+classname;
//                    study766.spider766_3( wp_term_jxh.fatherurl,  wp_term_jxh ,  baseurl, classname,1,8);
                    studyUtil.spider766_2(wp_term_jxh.fatherurl,wp_term_jxh,baseurl,classname);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
