package com.pyb.mvc.action.v1.weixin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pyb.constants.Constants;
import com.pyb.mvc.action.v1.BaseV1Controller;
import com.pyb.util.HttpUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping(value = "/v1")
public class test extends BaseV1Controller {
    @RequestMapping(value = "/goods/test")
    @ResponseBody
    public void user_info(HttpServletRequest request, HttpServletResponse response) {
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
            }
            if(oob != null){
                PrintWriter out = response.getWriter();
                out.print(oob.toJSONString());
                out.close();
                out = null;
            }else{
                PrintWriter out = response.getWriter();
                out.print(str);
                out.close();
                out = null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
