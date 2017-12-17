package com.pyb.mvc.action.v1.weixin.user.param;

import apidoc.jxh.cn.TargetComment;
import com.pyb.mvc.action.v1.param.BaseParam;

/**
 * 获取用户信息
 */
public class Param_userinfo extends BaseParam{
    @TargetComment(value = "用户微信对应平台的openid",isnull = "是")
    private  String openid;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
