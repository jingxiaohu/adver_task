package com.pyb.mvc.action.v1.weixin.admin.param;

import com.pyb.mvc.action.v1.param.BaseParam;

public class Param_AdminUserLogin  extends BaseParam{
    /**
     * 帐号
     */
    private String loginname;
    /**
     * 密码
     */
    private String password;

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
