package com.pyb.dao;


import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

//DAO Factory

@Repository("daoFactory")
public class DaoFactory{

@Autowired
protected User_infoDao user_infoDao;
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

/*******************************下面是GET方法**************************************/
public User_infoDao getUser_infoDao() {
	return user_infoDao;
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


}
