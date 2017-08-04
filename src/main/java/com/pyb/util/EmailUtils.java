/***************************************************************************
 * 
 * Copyright (c) by ihiyo.com, Inc. All Rights Reserved
 * 
 **************************************************************************/
package com.pyb.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jingxiaohu
 *
 */
public class EmailUtils {
	public static Logger logger=LoggerFactory.getLogger(EmailUtils.class);
	
	
	public static String formatmsg_reg = "您验证码是：%s,欢迎您使用手机客户端,我们将竭诚为您服务!"; 
	public static String formatmsg_change_pass = "尊敬的用户%s,您请求的重置密码的验证码为:%s,我们将竭诚为您服务!";
	public static String formatmsg_change_tel = "尊敬的用户%s,您请求的修改手机号码的验证码为:%s,我们将竭诚为您服务!";
	
	public static boolean sendEmail(String target,String content,String template){
		boolean success=false;
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.exmail.qq.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("xiaohu@51pyb.com", "Jingling1234"));
			email.setSSLOnConnect(true);
			email.setFrom("xiaohu@51pyb.com");
			email.setSubject("拼一把");
			email.setMsg(String.format(template, content));
			email.addTo(target);
			email.send();
			success=true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return success;
	}
	public static boolean sendEmail(String target,String message){
		boolean success=false;
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.exmail.qq.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("xiaohu@51pyb.com", "Jingling1234"));
			email.setSSLOnConnect(true);
			email.setFrom("xiaohu@51pyb.com");
			email.setSubject("拼一把");
			email.setMsg(message);
			email.addTo(target);
			email.send();
			success=true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return success;
	}
}
