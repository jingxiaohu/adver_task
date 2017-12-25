package com.pyb.mvc.action.v1.weixin.user.param;

import apidoc.jxh.cn.TargetComment;
import com.pyb.mvc.action.v1.param.BaseParam;

/**
 * 合作人提现
 */
public class Param_user_withdraw_complement extends BaseParam {
    @TargetComment(value = "用户电话号码",isnull = "否")
    private  String  telephone;//用户电话号码

    @TargetComment(value = "用户微信号码",isnull = "否")
    private  String  user_weixin;//用户微信号码

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUser_weixin() {
        return user_weixin;
    }

    public void setUser_weixin(String user_weixin) {
        this.user_weixin = user_weixin;
    }
}
