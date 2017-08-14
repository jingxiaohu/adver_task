package com.pyb.mvc.action.v1.user.param;

import apidoc.jxh.cn.TargetComment;
import com.pyb.mvc.action.v1.param.BaseParam;

/**
 * 第三方授权
 * @author jingxiaohu
 *
 */
public class Param_External_login extends BaseParam {
	/********************接收参数区*************************/
	@TargetComment(value = "头像",isnull = "是")
	public String avtar;//头像
	@TargetComment(value = "昵称",isnull = "是")
	public String nickname;//昵称
	@TargetComment(value = "性别",isnull = "是")
	public int sex;//性别
	//第三方登录
	@TargetComment(value = "用户账户类型 来源0:未指定1:web2:android 3:ios 4:QQ 5:微信 6:新浪 7:阿里",isnull = "否")
	public Integer up_type;//用户账户类型 来源0:未指定1:web2:android 3:ios 4:QQ 5:微信 6:新浪 7:阿里,
	@TargetComment(value = "外部TOKEN",isnull = "否")
	public String up_token;//外部TOKEN
	@TargetComment(value = "外部KEY",isnull = "否")
	public String up_key;//外部KEY
	/************************get set 方法区****************************/

	public String getAvtar() {
		return avtar;
	}



	public void setAvtar(String avtar) {
		this.avtar = avtar;
	}



	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getUp_token() {
		return up_token;
	}



	public void setUp_token(String up_token) {
		this.up_token = up_token;
	}



	public String getUp_key() {
		return up_key;
	}



	public void setUp_key(String up_key) {
		this.up_key = up_key;
	}

	public Integer getUp_type() {
		return up_type;
	}

	public void setUp_type(Integer up_type) {
		this.up_type = up_type;
	}
}
