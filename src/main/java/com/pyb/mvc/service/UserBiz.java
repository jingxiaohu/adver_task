package com.pyb.mvc.service;

import com.pyb.DataSource.DynamicDataSourceHolder;
import com.pyb.DataSource.TargetDataSource;
import com.pyb.bean.ReturnDataNew;
import com.pyb.bean.Sms_validate;
import com.pyb.bean.User_info;
import com.pyb.constants.Constants;
import com.pyb.mvc.service.common.asyn.UserAsyn;
import com.pyb.util.FileUtil;
import com.pyb.util.RequestUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.URLDecoder;
import java.util.Date;

/**
 * 用户信息管理
 *
 * @author jingxiaohu
 */
@Service
public class UserBiz extends BaseBiz {

  @Autowired
  protected UserAsyn userAsyn;


  /**
   * 2.1.4. 用户注册
   *
   * @param verify_list :跟随验证码一起生产的 MD5验证串
   */
  public void ReturnUserRegister(ReturnDataNew returnData, int dtype, String telephone,
      String verify_code, String verify_list, String vclass, String password,Integer reg_type) {
    // TODO Auto-generated method stub
    try {
      //从什么设备发出的请求  1:android 2:ios 3:web
      //进行验证码的验证
      String sql = "SELECT v_code,v_time FROM sms_validate WHERE v_tel = ? AND v_list = ? AND v_class = ? AND v_code=?  LIMIT 1";
      Sms_validate bsv = getMySelfService()
          .queryUniqueT(sql, Sms_validate.class, telephone, verify_list, vclass, verify_code);
      if (bsv == null) {
        returnData.setReturnData(errorcode_data, "验证码错误", "");
        return;
      }
      //检查时间是否过期 6分钟
      long time = bsv.getV_time();
      if (System.currentTimeMillis() - time > 6 * 60 * 1000) {
        returnData.setReturnData(errorcode_data, "验证码过期", "");
        return;
      }
      //检查该手机号码是否已经注册
      User_info userinfo = gainUserInfoByTelePhone(telephone);
      if (userinfo != null) {
        returnData.setReturnData(errorcode_data, "您已经注册过了", "");
        return;
      }

      //写入用户信息到用户基本信息表中
      userinfo = new User_info();
      userinfo.setUi_reg_type(reg_type);
      if(reg_type == 1){
    	  //邮箱注册
    	  //设置保密邮箱
    	  userinfo.setUi_email(telephone);
      }
      userinfo.setUi_nd(returnUUID());
      Date date = new Date();
      userinfo.setUi_tel(telephone);
      //绑定手机号（注册的时候默认是注册手机号码）
      userinfo.setUi_bind_tel(telephone);
      userinfo.setUi_password(password);
      userinfo.setCtime(date);
      //注册来源 0:android 1:ios 2: web 3:PC
      userinfo.setUi_flag(dtype);
      //未知
      userinfo.setUi_sex(0);
      userinfo.setUi_nickname(RandomStringUtils.random(8, true, true));//用户昵称
      //电话号码+密码 生成的MD5码 （授权码）
      userinfo.setUi_token(DigestUtils.md5Hex(telephone + password));
      int userid = daoFactory.getUser_infoDao().insert(userinfo);
      if (userid < 1) {
        returnData.setReturnData(errorcode_data, "注册失败", null);
        return;
      }
      userinfo.setUi_id(userid);
      /**
       * 返回数据
       */
      returnData.setReturnData(errorcode_success, "注册成功", userinfo);
      return;
    } catch (Exception e) {
      // TODO Auto-generated catch block
      log.error("UserBiz ReturnUserRegister is error", e);
      returnData.setReturnData(errorcode_systerm, "system is error", "");
      return;
    }
  }

  /**
   * 用户登录
   */
  public void ReturnUserLogin(ReturnDataNew returnData, int dtype,
      String telephone, String password, String ip) {
    // TODO Auto-generated method stub dtype,tel,password,tel_version,ip
    try {
      User_info userinfo = null;
      //普通登陆
      //检查该用户是否已经注册过 如果没有则不能进行修改密码
      userinfo = gainUserInfoByTelePhone(telephone);
      if (userinfo == null) {
        returnData.setReturnData(errorcode_data, "您还没有注册!", null);
        return;
      }
      if (1 == userinfo.getUi_lock()) {
        //禁用
        returnData.setReturnData(errorcode_data, "用户已禁用", null);
        return;
      }
      if (!password.equalsIgnoreCase(userinfo.getUi_password())) {
        //密码不正确
        returnData.setReturnData(errorcode_data, "密码错误", null);
        return;
      }

      //这里调用异步 用户登录日志记录
      userAsyn.Log_recordUserLogin(userinfo, dtype, ip, returnData);

      //返回数据
      returnData.setReturnData(errorcode_success, "登录成功", userinfo);
      return;

    } catch (Exception e) {
      // TODO Auto-generated catch block
      log.error("UserBiz ReturnUserLogin is error", e);
      returnData.setReturnData(errorcode_systerm, "system is error", null);
      return;
    }

  }

  /**
   * 用户修改密码、重置密码
   */
  public void ReturnUserModifyPassword(ReturnDataNew returnData,
      int dtype, String telephone, String verify_code, String verify_list, String vclass,
      String password, String repassword) {
    // TODO Auto-generated method stub
    //dtype,tel,verify_code,verify_list,password,repassword,imei,tel_version
    try {
      //检查该手机号码是否已经注册
      User_info userinfo = gainUserInfoByTelePhone(telephone);
      if (userinfo == null) {
        returnData.setReturnData(errorcode_data, "您还没有注册!", null);
        return;
      }
      //从什么设备发出的请求1-收音机2-手机APP 3-WEB
      //进行验证码的验证
      String sql = "SELECT v_code,v_time FROM sms_validate WHERE v_tel = ? AND v_list = ? AND v_class = ? AND v_code=?  LIMIT 1";
      Sms_validate bsv = getMySelfService()
          .queryUniqueT(sql, Sms_validate.class, telephone, verify_list, vclass, verify_code);
      if (bsv == null) {
        returnData.setReturnData(errorcode_data, "验证码错误", null);
        return;
      }
      //检查时间是否过期
      long time = Long.parseLong(bsv.getV_time() + "000");
      if (System.currentTimeMillis() - time > 6 * 60 * 1000) {
        returnData.setReturnData(errorcode_data, "验证码过期", null);
        return;
      }
      Date date = new Date();
      //更新用户密码
      userinfo.setUi_password(password);
      //电话号码+密码 生成的MD5码 （授权码）
      userinfo.setUi_token(DigestUtils.md5Hex(telephone + password));
      userinfo.setUtime(date);
      int count = daoFactory.getUser_infoDao().updateByKey(userinfo);
      if (count < 1) {
        returnData.setReturnData(errorcode_data, "更改密码失败", null);
        return;
      }

      returnData.setReturnData(errorcode_success, "更改密码成功", userinfo);
      return;

    } catch (Exception e) {
      // TODO Auto-generated catch block
      log.error("UserBiz ReturnUserModifyPassword is error", e);
      returnData.setReturnData(errorcode_systerm, "system is error", null);
      return;
    }
  }

  /**
   * 修改用户基本信息
   */
  public void change_userinfo(ReturnDataNew returnData, int dtype,long ui_id, MultipartFile avatar, String avatarFileName, String nickname,Integer sex, String name,  String email) {
    // TODO Auto-generated method stub ui_autopay;//

    try {
      //检查该手机号码是否已经注册
      User_info userinfo = daoFactory.getUser_infoDao().selectByKey(ui_id);
      if (userinfo == null) {
        returnData.setReturnData(errorcode_data, "用户不存在!", null);
        return;
      }
      if (!RequestUtil.checkObjectBlank(nickname)) {
        //昵称
        userinfo.setUi_nickname(nickname);
      }
      if (!RequestUtil.checkObjectBlank(name)) {
        //姓名
        name = URLDecoder.decode(name, Constants.SYSTEM_CHARACTER);
        userinfo.setUi_name(name);
      }
      if (!RequestUtil.checkObjectBlank(sex)) {
        //性别
        userinfo.setUi_sex(sex);
      }
      if (!RequestUtil.checkObjectBlank(email)) {
        //邮箱
        userinfo.setUi_email(email);
      }

      if (!RequestUtil.checkObjectBlank(avatar) && !RequestUtil.checkObjectBlank(avatarFileName)) {
        //处理用户头像问题
        //上传文件
        String url = FileUtil.uploadScaleAvatarImage(avatar, avatarFileName, Constants.USER_AVATAR,
            Constants.AVATAR_WIDTH, Constants.AVATAR_HIGHT, userinfo.getUi_tel());
        if (url == null) {
          returnData.setReturnData(errorcode_data, "上传头像错误", null);
          return;
        }
        userinfo.setUi_avtar(url);
      }
      //更新用户的昵称
      int count = daoFactory.getUser_infoDao().updateByKey(userinfo);
      if (count < 1) {
        returnData.setReturnData(errorcode_data, "更改用户基本信息失败", null);
        return;
      }
      returnData.setReturnData(errorcode_success, "更改用户基本信息成功", userinfo);
      return;

    } catch (Exception e) {
      // TODO Auto-generated catch block
      log.error("UserBiz ReturnUserUpdateUserInfo is error", e);
      returnData.setReturnData(errorcode_systerm, "system is error", null);
      return;
    }
  }

  /**
   * 修改用户绑定手机
   */
  public void ReturnUserUpdateTel(ReturnDataNew returnData, int dtype, String tel, String password,
      long ui_id) {
    // TODO Auto-generated method stub
    try {
      //检查该用户是否已经注册过了的
      String sql = "SELECT * FROM user_info WHERE ui_id=? AND ui_password=? LIMIT 1";
      User_info userinfo = getMySelfService().queryUniqueT(sql, User_info.class, ui_id, password);
      if (userinfo == null) {
        //用户密码错误
        returnData.setReturnData(errorcode_data, "用户密码错误", null);
        return;
      }
      //检查该手机号码是否已经注册 或者 被绑定过
      User_info userinfo2 = gainUserInfoByTel_bind(tel);
      if (userinfo2 != null && ui_id != userinfo2.getUi_id()) {
        returnData.setReturnData(errorcode_data, "该手机号码已经被注册!", null);
        return;
      }
      userinfo.setUi_bind_tel(tel);
      //更新用户的绑定手机号码
      int count = daoFactory.getUser_infoDao().updateByKey(userinfo);
      if (count < 1) {
        returnData.setReturnData(errorcode_data, "绑定手机号码失败", null);
        return;
      }

      returnData.setReturnData(errorcode_success, "绑定手机号码成功", userinfo);
      return;
    } catch (Exception e) {
      // TODO Auto-generated catch block
      log.error("UserBiz ReturnUserUpdateTel is error", e);
      returnData.setReturnData(errorcode_systerm, "system is error", null);
      return;
    }
  }

  /**
   * 获取我自己的基本信息
   */
  @TargetDataSource(value = DynamicDataSourceHolder.SLAVE)
  public void ReturnReadMyInfo(ReturnDataNew returnData, int dtype, long ui_id) {
    // TODO Auto-generated method stub
    try {
      //检查该手机号码是否已经注册
      User_info userinfo = daoFactory.getUser_infoDao().selectByKey(ui_id);
      if (userinfo == null) {
        returnData.setReturnData(errorcode_data, "用户不存在!", null);
        return;
      }
      userinfo.setUi_password("");
      returnData.setReturnData(errorcode_success, "读取我的信息成功", userinfo);
      return;

    } catch (Exception e) {
      // TODO Auto-generated catch block
      log.error("UserBiz ReturnReadMyInfo is error", e);
      returnData.setReturnData(errorcode_systerm, "system is error", null);
      return;
    }
  }

  /**
   * 用户反馈
   */
  @Deprecated
  public void feedback(ReturnDataNew returnData, long ui_id, String content) {
    // TODO Auto-generated method stub
    /*try {
      //检查用户是否存在
      User_info userinfo = daoFactory.getUser_infoDao().selectByKey(ui_id);
      if (userinfo == null) {
        returnData.setReturnData(errorcode_data, "用户不存在!", null);
        return;
      }
      //记录反馈信息
      Date date = new Date();
      User_feedback user_feedback = new User_feedback();
      user_feedback.setContent(content);
      user_feedback.setUi_id(ui_id);
      user_feedback.setCtime(date);
      user_feedback.setUtime(date);
      int id = user_feedbackDao.insert(user_feedback);
      if (id < 1) {
        returnData.setReturnData(errorcode_data, "用户反馈失败", "");
        return;
      }
      returnData.setReturnData(errorcode_success, "用户反馈成功", "");
      return;

    } catch (Exception e) {
      // TODO Auto-generated catch block
      log.error("UserBiz feedback is error", e);
      returnData.setReturnData(errorcode_systerm, "system is error", null);
      return;
    }*/
  }

  /**********************下面是分离的方法************************/
  /**
   * 检查该手机号码是否已经被其他人注册过了
   */
  public User_info gainUserInfoByTelePhone(String telephone) throws Exception {
    try {
      String sql = "SELECT * FROM user_info WHERE ui_tel=? LIMIT 1";
      return getMySelfService().queryUniqueT(sql, User_info.class, telephone);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      log.error("gainUserInfoByTelePhone(String telephone)  telephone=" + telephone + "  is error",
          e);
      throw new Exception("gainUserInfoByTelePhone 检查该手机号码是否已经被其他人注册过了 失败", e);
    }
  }

  /**
   * 检查该手机号码是否已经被其他人注册过了 或者  绑定过了
   */
  public User_info gainUserInfoByTel_bind(String telephone) throws Exception {
    try {
      String sql = "SELECT * FROM user_info WHERE ui_tel=? AND bind_tel=? LIMIT 1";
      return getMySelfService().queryUniqueT(sql, User_info.class, telephone);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      log.error("gainUserInfoByTelePhone(String telephone)  telephone=" + telephone + "  is error",
          e);
      throw new Exception("gainUserInfoByTelePhone 检查该手机号码是否已经被其他人注册过了 失败", e);
    }
  }
/**
 * 修改用户密码
 * @param returnData
 * @param dtype
 * @param ui_id
 * @param old_password
 * @param new_password
 */
public void UpUserModifyPassword(ReturnDataNew returnData, int dtype,
		long ui_id, String old_password, String new_password) {
	// TODO Auto-generated method stub
    try {
        //检查该手机号码是否已经注册
        User_info userinfo = daoFactory.getUser_infoDao().selectByKey(ui_id);
        
        if (userinfo == null) {
          returnData.setReturnData(errorcode_data, "您还没有注册!", "");
          return;
        }
        //验证输入的旧密码是否跟数据库当前保存的一致
        if(!old_password.equalsIgnoreCase(userinfo.getUi_password())){
        	 returnData.setReturnData(errorcode_data, "原密码输入错误", "");
             return;
        }
        
        
        Date date = new Date();
        //更新用户密码
        userinfo.setUi_password(new_password);
        //电话号码+密码 生成的MD5码 （授权码）
        userinfo.setUi_token(DigestUtils.md5Hex(userinfo.getUi_tel() + new_password));
        userinfo.setUtime(date);
        
        int count = daoFactory.getUser_infoDao().updateByKey(userinfo);
        if (count < 1) {
          returnData.setReturnData(errorcode_data, "更改密码失败", "");
          return;
        }

        returnData.setReturnData(errorcode_success, "更改密码成功", userinfo);
        return;

      } catch (Exception e) {
        // TODO Auto-generated catch block
        log.error("UserBiz UpUserModifyPassword is error", e);
        returnData.setReturnData(errorcode_systerm, "system is error", "");
        return;
      }
}


}
