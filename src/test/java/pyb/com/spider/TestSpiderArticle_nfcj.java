package pyb.com.spider;

import com.pyb.bean.Wp_term_jxh;
import com.pyb.jsoup.article.Nfcj_singleStock_Spider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pyb.com.BaseWebTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * http://www.southmoney.com/gupiao/
 */
public class TestSpiderArticle_nfcj extends BaseWebTest {
    Logger log = LoggerFactory.getLogger(this.getClass());
    @Resource  //自动注入,默认按名称
    private Nfcj_singleStock_Spider nfcj_singleStock_Spider;

    @Test
    public void executeSql() {
        //添加数据
        /*try {
            nfcj_singleStock_Spider.addClassMain((long) 5,"http://www.southmoney.com/gegu/");
        } catch (Exception e) {

        }*/
        try {

            List<Wp_term_jxh> list =  nfcj_singleStock_Spider.FindWptermsJxh(5);
            if(list != null && list.size() > 0){
                String prefx = "http://www.southmoney.com";
                for (Wp_term_jxh wp_term_jxh : list) {
                    try {
                        String classname =  wp_term_jxh.url.replace(prefx,"");
                        String baseurl = prefx+classname;
                        nfcj_singleStock_Spider.DoWithRecursion(prefx,wp_term_jxh,baseurl,classname,null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {

        }
    }



        




}
