package pyb.com.spider;

import com.pyb.jsoup.article.Nfcj_singleStock_Spider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pyb.com.BaseWebTest;

import javax.annotation.Resource;

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
                try {
                    nfcj_singleStock_Spider.addClassMain((long) 5,"http://www.southmoney.com/gegu/");
                } catch (Exception e) {

                }
    }



        




}
