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
		String[] tablenames =
				{
				"user_info_new","game_task","task_info","user_exchange","user_recommend"
				,"user_task","request_params_log","user_login_log","user_vc_act","user_pay","sms_running","sms_validate"
				,"pay_park"
				,"live_info","message_info","channel_info","user_external"
				,"wp_posts","wp_terms","wp_term_taxonomy","wp_termmeta",
				"wp_term_jxh",
				"wp_post_jxh","joke_segment","stock_hand","day_news","stock_info",
				"wx_user_info"
						,"wx_after_sale","wx_evaluate","wx_goods","wx_goods_details"
						,"wx_goods_order","wx_order_goods"
						,"wx_goods_type","wx_user_address","wx_apply_cash",
						"wx_recommend_user","wx_recommend_earnings","wx_accesstoken"
						,"admin_user","admin_role","wx_banner_img"
				};
//		String ip = "114.55.10.246";
		String ip = "127.0.0.1";
		int port = 3306;
		String user = "root";
//		String password = "jxh@@jingling123";
		String password = "root";
		String databaseName = "wypyb";
		ABuilder.AutoCoder(is_maven,src,moduleName, pkg, tablenames, ip, port, user, password, databaseName);
	}

}
