package com.pyb.mvc.service.common.asyn;

import com.pyb.bean.ReturnDataNew;
import com.pyb.bean.User_info_new;
import com.pyb.bean.User_login_log;
import com.pyb.mvc.service.BaseBiz;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 用户公用方法
 * @author jingxiaohu
 *
 */
@Service
public class UserAsyn extends BaseBiz{
	/**
	 * 记录用户登录日志
	 * @param userinfo
	 * @param dtype
	 * @param ip
	 * @param returnData
	 */
	@Async
	public void Log_recordUserLogin(User_info_new userinfo, int dtype, String ip, ReturnDataNew returnData){
		try {
			//$strsql = "insert into {$tablehead}app_user_login_report (u_tel,u_logindate,u_login_ip) values ('$username','$nowtimesharp','$userip')";
		      Date date = new Date();
		      User_login_log userlog = new User_login_log();
		      //用户ID
		      userlog.setUi_id(userinfo.getUi_id());
		      //0:android 1:ios 2: web 3:PC
		      userlog.setFlag(dtype);
		      userlog.setCtime(date);
		      userlog.setUtime(date);
		      userlog.setUll_ip(ip);
		      int indexid = daoFactory.getUser_login_logDao().insert(userlog);
		      if (indexid < 1) {
		        log.error("Log_recordUserLogin.user_login_logDao.insert(userlog) is error");
		        returnData.setReturnData(errorcode_data, "记录用户登录日志失败", null);
		      }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("UserAsyn.Log_recordUserLogin 记录用户登录日志", e);
		}
	}
	
}
