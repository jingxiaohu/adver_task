package pyb.com.spider;

import com.pyb.jsoup.article.EastMoneyUtil;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pyb.com.BaseWebTest;

import javax.annotation.Resource;

/**
 */
public class TestSpiderArticle_EastMoneyweb extends BaseWebTest {
    Logger log = LoggerFactory.getLogger(this.getClass());
    @Resource  //自动注入,默认按名称
    private EastMoneyUtil eastMoneyUtil;

    @Test
    public void executeSql() {
        try {
            eastMoneyUtil.DoWithRecursion();
        } catch (Exception e) {

        }
    }




        




}
