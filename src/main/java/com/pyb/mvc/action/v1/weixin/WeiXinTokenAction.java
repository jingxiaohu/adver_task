package com.pyb.mvc.action.v1.weixin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pyb.bean.Wx_accesstoken;
import com.pyb.constants.Constants;
import com.pyb.dao.Wx_accesstokenDao;
import com.pyb.mvc.action.v1.BaseV1Controller;
import com.pyb.mvc.weixin.biz.Wx_UserBiz;
import com.pyb.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * 用户登录
 * http://blog.csdn.net/maguanghui_2012/article/details/52808139
 */
@RestController
@RequestMapping(value = "/v1")
public class WeiXinTokenAction extends BaseV1Controller {
    //    @Autowired
//    private UserBiz userBiz;
    @Autowired
    Wx_accesstokenDao wx_accesstokenDao;
    @Autowired
    Wx_UserBiz wx_UserBiz;

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

            if (StringUtils.hasLength(echostr)) {
                System.out.println("signature:" + signature);
                System.out.println("timestamp:" + timestamp);
                System.out.println("nonce:" + nonce);
                System.out.println("echostr:" + echostr);
                sendResp(echostr, response);
                return;
            }
            //用户关注微信公众号 通过事件被动消息发送给用户 回调该接口获取到用户绑定该公众号的 openid
            String openid = request.getParameter("openid");
            System.out.println("openid:" + openid);
            //通过accesstoken + openid 获取用户基本信息
            doAccessToken();
           //https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
            String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="
                    +Constants.getWx_accesstoken().getAccess_token()
                    +"&openid="
                    +openid
                    +"&lang=zh_CN ";

            String jsondata = HttpUtil.doGet(url,null,null);
            if(jsondata != null){
                JSONObject oob = JSON.parseObject(jsondata);
                if(oob != null){
                   boolean flag =  wx_UserBiz.ReturnUserRegister(oob);
                    if(flag){
                        //注册成功
                        sendResp("success", response);
                    }
                }
            }
            return;
        } catch (Exception e) {
            log.error("注册 is fail", e);
        }
        sendResp("error", response);
    }


    //处理access_tonken
    public void doAccessToken() throws Exception {
        if (Constants.getWx_accesstoken() == null) {
            //从数据库里面获取accesstoken
            List<Wx_accesstoken> wx_accesstoken_list = wx_accesstokenDao.selectAll();
            if (wx_accesstoken_list != null && wx_accesstoken_list.size() == 1) {
                Wx_accesstoken wx_accesstoken = wx_accesstoken_list.get(0);
                //检查是否access_token 过期  Expires_in 凭证有效时间，单位：秒
                if (System.currentTimeMillis() - wx_accesstoken.getExpires_in() * 1000 >= wx_accesstoken.getUtime().getTime()) {
                    //过期重新请求
                    JSONObject obj = RefeshAccessToken();
                    if (obj != null) {
                        String WeiXinAccessToken = obj.getString("access_token");
                        String expires_in = obj.getString("expires_in");
                        wx_accesstoken.setAccess_token(WeiXinAccessToken);
                        wx_accesstoken.setExpires_in(Integer.parseInt(expires_in));
                        wx_accesstoken.setUtime(new Date());
                        int count = wx_accesstokenDao.updateByKey(wx_accesstoken);
                        if (count != 1) {
                            log.error("access_token 刷新失败 wx_accesstokenDao.updateByKey(wx_accesstoken)");
                        }
                    }

                }
                //设置到Constants 中的 access_token 中去
                Constants.setWx_accesstoken(wx_accesstoken);
            } else {
                //
                Wx_accesstoken wx_accesstoken = new Wx_accesstoken();
                //重新请求
                JSONObject obj = RefeshAccessToken();
                if (obj != null) {
                    String WeiXinAccessToken = obj.getString("access_token");
                    String expires_in = obj.getString("expires_in");
                    wx_accesstoken.setAccess_token(WeiXinAccessToken);
                    wx_accesstoken.setExpires_in(Integer.parseInt(expires_in));
                    wx_accesstoken.setUtime(new Date());
                    int id = wx_accesstokenDao.insert(wx_accesstoken);
                    if (id < 1) {
                        log.error("access_token 刷新失败 wx_accesstokenDao.insert(wx_accesstoken)");
                    }
                }
                //设置到Constants 中的 access_token 中去
                Constants.setWx_accesstoken(wx_accesstoken);
            }
        } else {
            //过期检查
            Wx_accesstoken wx_accesstoken = Constants.getWx_accesstoken();
            if (System.currentTimeMillis() - wx_accesstoken.getExpires_in() * 1000 >= wx_accesstoken.getUtime().getTime()) {
                //过期重新请求
                JSONObject obj = RefeshAccessToken();
                if (obj != null) {
                    String WeiXinAccessToken = obj.getString("access_token");
                    String expires_in = obj.getString("expires_in");
                    List<Wx_accesstoken> wx_accesstoken_list =  wx_accesstokenDao.selectAll();
                    wx_accesstoken = wx_accesstoken_list.get(0);

                    wx_accesstoken.setAccess_token(WeiXinAccessToken);
                    wx_accesstoken.setExpires_in(Integer.parseInt(expires_in));
                    wx_accesstoken.setUtime(new Date());
                    int count = wx_accesstokenDao.updateByKey(wx_accesstoken);
                    if (count != 1) {
                        log.error("access_token 刷新失败 wx_accesstokenDao.updateByKey(wx_accesstoken)");
                    }
                }
                //设置到Constants 中的 access_token 中去
                Constants.setWx_accesstoken(wx_accesstoken);
            }

        }
    }

}
