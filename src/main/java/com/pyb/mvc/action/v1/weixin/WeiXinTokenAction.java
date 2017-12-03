package com.pyb.mvc.action.v1.weixin;

import com.pyb.mvc.action.v1.BaseV1Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户登录
 * http://blog.csdn.net/maguanghui_2012/article/details/52808139
 */
@RestController
@RequestMapping(value = "/v1")
public class WeiXinTokenAction extends BaseV1Controller {
//    @Autowired
//    private UserBiz userBiz;
    /**
     * 获取我的基本信息
     */
    @RequestMapping(value = "/weixin_token")
    @ResponseBody
    public void Read_myinfo(HttpServletRequest request, HttpServletResponse response) {
        try {
            String signature = request.getParameter("signature");
            String timestamp = request.getParameter("timestamp");
            String nonce = request.getParameter("nonce");
            String echostr = request.getParameter("echostr");
            System.out.println("signature:" + signature);
            System.out.println("timestamp:" + timestamp);
            System.out.println("nonce:" + nonce);
            System.out.println("echostr:" + echostr);
           /* PrintWriter pw = response.getWriter();
            pw.append(echostr);
            pw.flush();*/
            sendResp(echostr,response);
            return;
        } catch (Exception e) {
            log.error("weixin token sign is fail",e);
        }
        sendResp("error", response);
    }

}
