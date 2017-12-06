package com.pyb.mvc.weixin.biz.admin;

import com.pyb.bean.Admin_user;
import com.pyb.bean.ReturnDataNew;
import com.pyb.mvc.action.v1.weixin.admin.param.Param_AdminUserLogin;
import com.pyb.mvc.weixin.biz.BaseWxBiz;
import com.pyb.util.MD5;
import org.springframework.stereotype.Service;

@Service
public class AdminUserBiz extends BaseWxBiz {
    /**
     * 后台用户登录
     * @param returnData
     * @param param
     */
    public void  AdminLogin(ReturnDataNew returnData, Param_AdminUserLogin param) {
        try {
            String sql = "select *  from admin_user where au_loginname=? and au_password=? ";
            Admin_user admin_user  = getDB().queryUniqueT(sql,Admin_user.class,param.getLoginname(), MD5.getMD5(param.getPassword()));
            if(admin_user == null){
                //帐号或者密码错误
                returnData.setReturnData(errorcode_systerm, "帐号或者密码错误", "");
                return;
            }
            returnData.setReturnData(errorcode_success, "登录成功", admin_user);
        } catch (Exception e) {
            log.error("AdminUserBiz AdminLogin is error", e);
            returnData.setReturnData(errorcode_systerm, "AdminUserBiz AdminLogin is error", "");
        }
    }



}
