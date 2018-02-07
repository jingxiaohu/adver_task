package pyb.com;

import com.pyb.bean.ReturnDataNew;
import com.pyb.mvc.weixin.biz.WxPayBiz;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/spring/spring_test.xml")
public class TransfersWeiXinTest {

    @Autowired
    WxPayBiz wxPayBiz;
    @Test
    public void tt(){
        ReturnDataNew dd = new ReturnDataNew();
        String openid="oA_cb0jLCM68XRZMlQ5Z_VHX5onI";
        String orderid = "2018012721001004940262614714";
        int amount=100;
        wxPayBiz.RemitToUser(dd,orderid,openid,amount);
    }
}
