package pyb.com.spider;

import com.pyb.jsoup.article.ZzUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pyb.com.BaseWebTest;

import javax.annotation.Resource;

/**
 */
public class TestSpiderArticle_Zzweb extends BaseWebTest {
    Logger log = LoggerFactory.getLogger(this.getClass());
    @Resource  //自动注入,默认按名称
    private ZzUtil zzUtil;

    @Test
    public void executeSql() {
        try {
            zzUtil.DoWithRecursion();
        } catch (Exception e) {

        }
    }



        




}
