package com.pyb.mvc.action.v1.user.param;

import org.springframework.web.multipart.MultipartFile;

import com.pyb.mvc.action.v1.param.BaseParam;
/**
 * 用户重置密码 用户修改绑定手机号码   用户修改头像  用户修改昵称
 * @author jingxiaohu
 *
 */
public class Param_UserModify extends BaseParam {
	/********************接收参数区*************************/
	public String tel;//用户手机号码
	public String verify_code;//用户验证码
	public String verify_list;//由发送验证码接口或者重新发送验证码接口返回的verify_list参数的值
	public String password;//用户密码 
	public String repassword;//确认密码
	public String vclass;//固定参数：1：注册 2：重置密码
	public String nickname;//昵称
	public  Integer sex;//用户性别 0:未知 1:男 2:女
	public String name;//用户姓名
	public String email;//用户邮箱
	
	
	
	//用户头像
	public  MultipartFile avatar;
    //提交过来的file的名字
	public String avatarFileName;
    //提交过来的file的MIME类型
	public String avatarContentType;
	
	/************************get set 方法区****************************/

	public String getTel() {
		return tel;
	}

	public String getVerify_code() {
		return verify_code;
	}

	public void setVerify_code(String verify_code) {
		this.verify_code = verify_code;
	}

	public String getVerify_list() {
		return verify_list;
	}

	public void setVerify_list(String verify_list) {
		this.verify_list = verify_list;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getVclass() {
		return vclass;
	}

	public void setVclass(String vclass) {
		this.vclass = vclass;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MultipartFile getAvatar() {
		return avatar;
	}

	public void setAvatar(MultipartFile avatar) {
		this.avatar = avatar;
	}

	public String getAvatarFileName() {
		return avatarFileName;
	}

	public void setAvatarFileName(String avatarFileName) {
		this.avatarFileName = avatarFileName;
	}

	public String getAvatarContentType() {
		return avatarContentType;
	}

	public void setAvatarContentType(String avatarContentType) {
		this.avatarContentType = avatarContentType;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	

	
}
