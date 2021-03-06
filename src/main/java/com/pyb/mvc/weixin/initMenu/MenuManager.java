package com.pyb.mvc.weixin.initMenu;

import com.pyb.mvc.weixin.bean.*;
import com.pyb.mvc.weixin.util.WeixinUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 类名: MenuManager </br>
 * 包名： com.souvc.weixin.main
 * 描述:菜单管理器类 </br>
 * 开发人员： liuhf </br>
 * 创建时间：  2015-12-1 </br>
 * 发布版本：V1.0  </br>
 * https://www.cnblogs.com/liuhongfeng/p/4857312.html
 */
public class MenuManager {
    private static Logger log = LoggerFactory.getLogger(MenuManager.class);
    static String scope = "snsapi_userinfo";//"snsapi_base";
    // 第三方用户唯一凭证
    static String appId = "wxebee99b0aba36d8f";
    // 第三方用户唯一凭证密钥
    static String appSecret = "a4a6df2df45185cf4746a381155cf0fa";
    static String redirect_baseurl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="
            +appId
            +"&redirect_uri=REDIRECT_URI&response_type=code&scope="
            +scope
            +"&state=1#wechat_redirect";
    public static void main(String[] args) {


        // 调用接口获取access_token
//        AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);
        AccessToken at = new AccessToken();
        at.setToken("7_J3oYm6i3kzM51j3X5VG_SWgZC1LVklSeS7EhpHncpJ-RIJaVwKeTXuJu6G7j2YoecD6YXLS-JBQut_2HvuNDPVflP4NESOl6CXklDk-t4Ox7WK7e5ML_GwRZ7okSZEeAEAOVA");
        at.setExpiresIn(7200);
        if (null != at) {
            // 调用接口创建菜单
            int result = WeixinUtil.createMenu(getMenu(), at.getToken());

            // 判断菜单创建结果
            if (0 == result)
                log.info("菜单创建成功！");
            else
                log.info("菜单创建失败，错误码：" + result);
        }
    }

    /**
     * 组装菜单数据
     *
     * @return
     */
    private static Menu getMenu() {
        CommonButton btn31 = new CommonButton();
        btn31.setName("我的订单");
        btn31.setType("click");
        btn31.setKey("31");

        CommonButton btn32 = new CommonButton();
        btn32.setName("在线客服");
        btn32.setType("click");
        btn32.setKey("32");

        CommonButton btn33 = new CommonButton();
        btn33.setName("申请合伙人");
        btn33.setType("click");
        btn33.setKey("33");


        /**
         * 微信：  mainBtn1,mainBtn2,mainBtn3底部的三个一级菜单。
         */

        CommonButton mainBtn1 = new CommonButton();
        mainBtn1.setName("拼把商城");
//        mainBtn1.setUrl("http://www.528ads.com");//http://task.51pyb.com/wx/index.html
        try {
            mainBtn1.setUrl(redirect_baseurl.replace("REDIRECT_URI", URLEncoder.encode("http://task.51pyb.com/v1/goods/openid_jump.php","UTF-8")) );
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        mainBtn1.setType("view");


        CommonButton mainBtn2 = new CommonButton();
        mainBtn2.setName("拼把动态");
//        mainBtn2.setUrl("http://www.51pyb.com");
        try {
            mainBtn2.setUrl(redirect_baseurl.replace("REDIRECT_URI", URLEncoder.encode("http://task.51pyb.com/v1/goods/openid_jump.php","UTF-8")) );
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        mainBtn2.setType("view");


        ComplexButton mainBtn3 = new ComplexButton();
        mainBtn3.setName("个人中心");
        mainBtn3.setSub_button(new CommonButton[] { btn31, btn32, btn33 });


        /**
         * 封装整个菜单
         */
        Menu menu = new Menu();
//        menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });
        menu.setButton(new Button[] { mainBtn1});

        return menu;
    }
}
