package com.pyb.mvc.action.v1.user.param;


import apidoc.jxh.cn.TargetComment;
import com.pyb.mvc.action.v1.param.BaseParam;
/**
 * 用户发送验证码
 * @author jingxiaohu
 *
 */
public class Param_sendcode extends BaseParam {
	/********************接收参数区*************************/
	@TargetComment(value="用户手机号码 或者 邮箱",isnull="否")
	public String tel;//用户手机号码 或者 邮箱
	@TargetComment("固定参数：1：注册 2：重置密码 3:重置绑定电话号码  4：绑定银行卡")
	public String vclass;//固定参数：1：注册 2：重置密码 3:重置绑定电话号码  4：绑定银行卡
	@TargetComment("md5(tel+code)")
	public String verify_list;//md5(tel+code)
	@TargetComment("类型（0:未指定 1:邮箱 2:手机）")
	public Integer type;//类型（0:未指定 1:邮箱 2:手机）
	/************************get set 方法区****************************/

	public String getTel() {
		return tel;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getVerify_list() {
		return verify_list;
	}

	public void setVerify_list(String verify_list) {
		this.verify_list = verify_list;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getVclass() {
		return vclass;
	}
	public void setVclass(String vclass) {
		this.vclass = vclass;
	}

}
