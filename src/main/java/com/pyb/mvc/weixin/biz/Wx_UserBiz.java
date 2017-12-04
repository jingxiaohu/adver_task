package com.pyb.mvc.weixin.biz;

import com.alibaba.fastjson.JSONObject;
import com.pyb.bean.Wx_recommend_user;
import com.pyb.bean.Wx_user_info;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
//     String weixin_no = userObj.getString("unionid");
        String weixin_no = returnUUID();
     //用户的标识，对当前公众号唯一
     String weixin_id = userObj.getString("openid");
      //用户地区
      String area = userObj.getString("province")+":"+userObj.getString("city");
      int sex = userObj.getIntValue("sex");
        //判断是否是推荐人 推荐进入的
        String EventKey = userObj.getString("EventKey");
        Wx_user_info wx_user_info_recommend = null;
        if(StringUtils.hasLength(EventKey)){
            //是推荐进入的
            String recommend_id = EventKey.replace("qrscene_","");
            wx_user_info_recommend =  FindUserInfoByWeixin_no(recommend_id);
        }



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

        if(wx_user_info_recommend != null){
            //是推荐进入的
            userinfo.setRecommend_id(wx_user_info_recommend.getUi_id());
            userinfo.setRecommend_nickname(wx_user_info_recommend.getNickname());
        }

      int userid = daoFactory.getWx_user_infoDao().insert(userinfo);
      if (userid < 1) {
//        returnData.setReturnData(errorcode_data, "注册失败", null);
        return false;
      }
      userinfo.setUi_id(userid);

        //判断是否是推荐人 推荐进入的
        if(wx_user_info_recommend != null){
            //是
            userinfo.setRecommend_id(wx_user_info_recommend.getUi_id());
            userinfo.setRecommend_nickname(wx_user_info_recommend.getNickname());
            //记录推荐人和新入驻人的关系
            Wx_recommend_user wx_recommend_user =  FindRecommendRelation(wx_user_info_recommend.getUi_id()
                    ,userinfo.getUi_id());
            if(wx_recommend_user == null){
                //添加推荐关系
                wx_recommend_user = new Wx_recommend_user();
                wx_recommend_user.setRecommend_id(wx_user_info_recommend.getUi_id());
                wx_recommend_user.setRecommended_id(userinfo.getUi_id());
                wx_recommend_user.setRecommended_nickname(userinfo.getNickname());
                wx_recommend_user.setAvatar(userinfo.getAvatar());
                int id = daoFactory.getWx_recommend_userDao().insert(wx_recommend_user);
                if (userid < 1) {
                    // returnData.setReturnData(errorcode_data, "推荐人关系记录失败", null);
                    log.error("推荐人关系记录失败 Recommend_id={},Recommended_id={}",wx_user_info_recommend.getUi_id(),userinfo.getUi_id());
                    return false;
                }
            }
        }


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



  /****************************下面是封装的查询方法********************************/
    /**
     * 通过weixin_no  获取用户基本信息
     * @param weixin_no
     * @return
     */
    public Wx_user_info FindUserInfoByWeixin_no(String weixin_no){
        try {
            String sql = "select * from wx_user_info where weixin_no=? limit 1";
            Wx_user_info userinfo = getMySelfService().queryUniqueT(sql,Wx_user_info.class,weixin_no);
            return userinfo;
        } catch (Exception e) {
            log.error("FindUserInfoByWeixin_no 查询用户信息失败",e);
        }
        return null;
    }

    /**
     * 通过 推荐人ID 和 被推荐人ID 查询是否存在他们之间的推荐关系
     * @param recommend_id :推荐人ID
     * @param recommended_id ：被推荐人ID
     * @return
     */
    public Wx_recommend_user FindRecommendRelation(long recommend_id,long recommended_id){
        try {
            String sql = "select * from wx_recommend_user where recommend_id=? and recommended_id=? limit 1";
            Wx_recommend_user wx_recommend_user = getMySelfService().queryUniqueT(sql,Wx_recommend_user.class,recommend_id,recommended_id);
            return wx_recommend_user;
        } catch (Exception e) {
            log.error("FindUserInfoByWeixin_no 查询推荐关系信息表失败",e);
        }
        return null;
    }
}
