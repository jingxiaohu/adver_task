package com.pyb.auto;

import com.highbeauty.sql.spring.builder.ABuilder;
/**
 * 
* @ClassName: JxhCoderAuto
* @Description: TODO(数据库表字段自动生成bean、dao)
* @author 敬小虎
* @date 2015年3月5日 下午2:24:48
*
 */
public class JxhCoderAuto {
	public static void main(String[] args) throws Throwable { 
		boolean src = true;
		boolean is_maven = true;
		String pkg = "com.pyb.";
		String moduleName="";
		String[] tablenames = {"user_info","game_task","task_info","user_exchange","user_recommend"
				,"user_task","request_params_log","user_login_log","user_vc_act","user_pay","sms_running","sms_validate"
				,"pay_park"};
		String ip = "114.55.10.246";
//		String ip = "127.0.0.1";
		int port = 3306;
		String user = "root";
		String password = "jxh@@jingling123";
//		String password = "root";
		String databaseName = "wetask";
		ABuilder.AutoCoder(is_maven,src,moduleName, pkg, tablenames, ip, port, user, password, databaseName);
	}

}
