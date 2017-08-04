package com.pyb.mvc.action.v1.user.param;

import com.pyb.mvc.action.v1.param.BaseParam;
/**
 * 用户重置密码
 * @author jingxiaohu
 *
 */
public class Param_ModifyPassword extends BaseParam {
	/********************接收参数区*************************/
	public String old_password;//用户旧密码 
	public String new_password;//用户新密码
	/************************get set 方法区****************************/
	public String getOld_password() {
		return old_password;
	}
	public void setOld_password(String old_password) {
		this.old_password = old_password;
	}
	public String getNew_password() {
		return new_password;
	}
	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}

	
	

	
}
