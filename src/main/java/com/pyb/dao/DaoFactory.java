package com.pyb.dao;


import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

//DAO Factory

@Repository("daoFactory")
public class DaoFactory{

@Autowired
protected User_info_newDao user_info_newDao;
@Autowired
protected Game_taskDao game_taskDao;
@Autowired
protected Task_infoDao task_infoDao;
@Autowired
protected User_exchangeDao user_exchangeDao;
@Autowired
protected User_recommendDao user_recommendDao;
@Autowired
protected User_taskDao user_taskDao;
@Autowired
protected Request_params_logDao request_params_logDao;
@Autowired
protected User_login_logDao user_login_logDao;
@Autowired
protected User_vc_actDao user_vc_actDao;
@Autowired
protected User_payDao user_payDao;
@Autowired
protected Sms_runningDao sms_runningDao;
@Autowired
protected Sms_validateDao sms_validateDao;
@Autowired
protected Pay_parkDao pay_parkDao;
@Autowired
protected Live_infoDao live_infoDao;
@Autowired
protected Message_infoDao message_infoDao;
@Autowired
protected Channel_infoDao channel_infoDao;
@Autowired
protected User_externalDao user_externalDao;
@Autowired
protected Wp_postsDao wp_postsDao;
@Autowired
protected Wp_termsDao wp_termsDao;
@Autowired
protected Wp_term_taxonomyDao wp_term_taxonomyDao;
@Autowired
protected Wp_termmetaDao wp_termmetaDao;
@Autowired
protected Wp_term_jxhDao wp_term_jxhDao;
@Autowired
protected Wp_post_jxhDao wp_post_jxhDao;
@Autowired
protected Joke_segmentDao joke_segmentDao;
@Autowired
protected Stock_handDao stock_handDao;
@Autowired
protected Day_newsDao day_newsDao;
@Autowired
protected Stock_infoDao Stock_infoDao;

/*******************************下面是GET方法**************************************/
public User_info_newDao getUser_info_newDao() {
	return user_info_newDao;
}
public Game_taskDao getGame_taskDao() {
	return game_taskDao;
}
public Task_infoDao getTask_infoDao() {
	return task_infoDao;
}
public User_exchangeDao getUser_exchangeDao() {
	return user_exchangeDao;
}
public User_recommendDao getUser_recommendDao() {
	return user_recommendDao;
}
public User_taskDao getUser_taskDao() {
	return user_taskDao;
}
public Request_params_logDao getRequest_params_logDao() {
	return request_params_logDao;
}
public User_login_logDao getUser_login_logDao() {
	return user_login_logDao;
}
public User_vc_actDao getUser_vc_actDao() {
	return user_vc_actDao;
}
public User_payDao getUser_payDao() {
	return user_payDao;
}
public Sms_runningDao getSms_runningDao() {
	return sms_runningDao;
}
public Sms_validateDao getSms_validateDao() {
	return sms_validateDao;
}
public Pay_parkDao getPay_parkDao() {
	return pay_parkDao;
}
public Live_infoDao getLive_infoDao() {
	return live_infoDao;
}
public Message_infoDao getMessage_infoDao() {
	return message_infoDao;
}
public Channel_infoDao getChannel_infoDao() {
	return channel_infoDao;
}
public User_externalDao getUser_externalDao() {
	return user_externalDao;
}
public Wp_postsDao getWp_postsDao() {
	return wp_postsDao;
}
public Wp_termsDao getWp_termsDao() {
	return wp_termsDao;
}
public Wp_term_taxonomyDao getWp_term_taxonomyDao() {
	return wp_term_taxonomyDao;
}
public Wp_termmetaDao getWp_termmetaDao() {
	return wp_termmetaDao;
}
public Wp_term_jxhDao getWp_term_jxhDao() {
	return wp_term_jxhDao;
}
public Wp_post_jxhDao getWp_post_jxhDao() {
	return wp_post_jxhDao;
}
public Joke_segmentDao getJoke_segmentDao() {
	return joke_segmentDao;
}
public Stock_handDao getStock_handDao() {
	return stock_handDao;
}
public Day_newsDao getDay_newsDao() {
	return day_newsDao;
}
public Stock_infoDao getStock_infoDao() {
	return Stock_infoDao;
}


}
