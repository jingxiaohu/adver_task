package com.pyb.mvc.weixin.biz;

import com.alibaba.fastjson.JSONObject;
import com.pyb.bean.Wx_user_info;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 用户信息管理
 *
 * @author jingxiaohu
 */
@Service
public class Wx_UserBiz extends BaseWxBiz {
  /**
   * 用户注册
   */
  public boolean ReturnUserRegister(JSONObject userObj) {
    // TODO Auto-generated method stub
    try {
      //头像
     String avatar = userObj.getString("headimgurl");
     String nickname = userObj.getString("nickname");
     //只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     String weixin_no = userObj.getString("unionid");
     //用户的标识，对当前公众号唯一
     String weixin_id = userObj.getString("openid");
      //用户地区
      String area = userObj.getString("province")+":"+userObj.getString("city");
      int sex = userObj.getIntValue("sex");

      //首先验证该微信用户是否之前关注过我们平台 如果是则不再创建新的用户ID
       String sql = "select * from wx_user_info where weixin_id=? limit 1";
        Wx_user_info userinfo = getMySelfService().queryUniqueT(sql,Wx_user_info.class,weixin_id);
        if(userinfo != null){
            //已经注册过了
            return true;
        }

      //写入用户信息到用户基本信息表中
      userinfo = new Wx_user_info();
      Date date = new Date();
      userinfo.setAvatar(avatar);
      userinfo.setNickname(nickname);
      userinfo.setRecommend_code(RandomStringUtils.random(6, false, true));
      userinfo.setWeixin_id(weixin_id);
      userinfo.setWeixin_no(weixin_no);
      userinfo.setArea(area);
      userinfo.setSex(sex);


      userinfo.setCtime(date);
      //电话号码+密码 生成的MD5码 （授权码）
      userinfo.setToken(DigestUtils.md5Hex(weixin_id+date.getTime()));
      int userid = daoFactory.getWx_user_infoDao().insert(userinfo);
      if (userid < 1) {
//        returnData.setReturnData(errorcode_data, "注册失败", null);
        return false;
      }
      userinfo.setUi_id(userid);
      /**
       * 返回数据
       */
      // returnData.setReturnData(errorcode_success, "注册成功", userinfo);
      return true;
    } catch (Exception e) {
      // TODO Auto-generated catch block
      log.error("UserBiz ReturnUserRegister is error", e);
     // returnData.setReturnData(errorcode_systerm, "system is error", "");
      return false;
    }
  }



}
