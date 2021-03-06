package com.pyb.mvc.action.v1.weixin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pyb.constants.Constants;
import com.pyb.mvc.action.v1.BaseV1Controller;
import com.pyb.util.HttpUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

@RestController
@RequestMapping(value = "/v1")
public class UserOpenIdJump extends BaseV1Controller {
    @RequestMapping(value = "/goods/openid_jump")
//    @ResponseBody
    public ModelAndView GainUserOpenId(HttpServletRequest request, HttpServletResponse response) {
        try {
            String str = request.getQueryString();
            System.out.println("str=" + str);
            String CODE = request.getParameter("code");
            //拿到code 和 state 后获取 token
            String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
                    + Constants.appId
                    +"&secret="
                    +Constants.appSecret
                    +"&code="
                    +CODE
                    +"&grant_type=authorization_code";
            String jsondata = HttpUtil.doGet(url, null, null);
            JSONObject oob = null;
            if (jsondata != null) {
                 oob = JSON.parseObject(jsondata);
                /**
                 * { "access_token":"ACCESS_TOKEN",

                 "expires_in":7200,

                 "refresh_token":"REFRESH_TOKEN",

                 "openid":"OPENID",

                 "scope":"SCOPE" }
                 */
                //System.out.println(jsondata);
            }
//            return new ModelAndView(new RedirectView("http://www.528ads.com?jsondata="+jsondata));
            ModelAndView mav = new ModelAndView();
            mav.setViewName("index"); //返回的文件名
            System.out.println("返回页面：message="+jsondata);
            //openid
//            mav.addObject("message", URLEncoder.encode(jsondata,"UTF-8"));
            mav.addObject("message", URLEncoder.encode(oob.getString("openid"),"UTF-8"));
            return mav;


        } catch (Exception e) {
            log.error("获取用户授权后的用户信息",e);
        }
//        return new ModelAndView(new RedirectView("http://www.528ads.com?jsondata="));
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index"); //返回的文件名
        mav.addObject("message","没有");
        return mav;

    }
}
