package com.pyb.bean;

import java.io.*;
import java.util.*;

//task_info
@SuppressWarnings({"serial"})
public class Task_info implements Cloneable , Serializable{

    //public static String[] carrays ={"ti_id","ti_nd","ti_title","ti_money","ti_money_vip","ti_type","ti_first_url","ti_second_url","ti_third_url","ti_sign","ti_limit","ti_current","ti_starttime","ti_endtime","ti_model","ctime","note","ui_id","ui_nd","ti_open"};

    public long ti_id;//bigint(20)    主键ID
    public String ti_nd="";//varchar(80)    任务nd
    public String ti_title="";//varchar(100)    任务标题
    public int ti_money;//int(11)    任务普通奖励(虚拟币)
    public int ti_money_vip;//int(11)    任务VIP奖励(虚拟币)
    public int ti_type;//int(11)    任务类型(0:l浏览广告1:点击广告2:搜索广告3:注册广告4:商家问答)
    public String ti_first_url="";//varchar(255)    任务第一步网址
    public byte[] ti_second_url;//varbinary(255)    任务第二步内容步骤图片
    public String ti_third_url="";//varchar(255)    第三步需要提交的验证结果（网址或者文字）
    public String ti_sign="";//varchar(60)    任务验证码
    public int ti_limit;//int(11)    限定参数人数
    public int ti_current;//int(11)    当前参与人数
    public java.util.Date ti_starttime=new java.util.Date();//datetime    任务开启时间
    public java.util.Date ti_endtime=new java.util.Date();//datetime    任务结束时间
    public int ti_model;//int(11)    任务投放类型(0:按时间1:按人数)
    public java.util.Date ctime=new java.util.Date();//datetime    创建时间
    public String note="";//varchar(100)    备注
    public long ui_id;//bigint(20)    发布人用户ID
    public String ui_nd="";//varchar(100)    发布人用户ND
    public int ti_open;//int(11)    是否开启(0:不开启1:开启)



    public long getTi_id(){
        return ti_id;
    }

    public void setTi_id(long value){
        this.ti_id= value;
    }

    public String getTi_nd(){
        return ti_nd;
    }

    public void setTi_nd(String value){
    	if(value == null){
           value = "";
        }
        this.ti_nd= value;
    }

    public String getTi_title(){
        return ti_title;
    }

    public void setTi_title(String value){
    	if(value == null){
           value = "";
        }
        this.ti_title= value;
    }

    public int getTi_money(){
        return ti_money;
    }

    public void setTi_money(int value){
        this.ti_money= value;
    }

    public int getTi_money_vip(){
        return ti_money_vip;
    }

    public void setTi_money_vip(int value){
        this.ti_money_vip= value;
    }

    public int getTi_type(){
        return ti_type;
    }

    public void setTi_type(int value){
        this.ti_type= value;
    }

    public String getTi_first_url(){
        return ti_first_url;
    }

    public void setTi_first_url(String value){
    	if(value == null){
           value = "";
        }
        this.ti_first_url= value;
    }

    public byte[] getTi_second_url(){
        return ti_second_url;
    }

    public void setTi_second_url(byte[] value){
        this.ti_second_url= value;
    }

    public String getTi_third_url(){
        return ti_third_url;
    }

    public void setTi_third_url(String value){
    	if(value == null){
           value = "";
        }
        this.ti_third_url= value;
    }

    public String getTi_sign(){
        return ti_sign;
    }

    public void setTi_sign(String value){
    	if(value == null){
           value = "";
        }
        this.ti_sign= value;
    }

    public int getTi_limit(){
        return ti_limit;
    }

    public void setTi_limit(int value){
        this.ti_limit= value;
    }

    public int getTi_current(){
        return ti_current;
    }

    public void setTi_current(int value){
        this.ti_current= value;
    }

    public java.util.Date getTi_starttime(){
        return ti_starttime;
    }

    public void setTi_starttime(java.util.Date value){
    	if(value == null){
           value = new java.util.Date();
        }
        this.ti_starttime= value;
    }

    public java.util.Date getTi_endtime(){
        return ti_endtime;
    }

    public void setTi_endtime(java.util.Date value){
    	if(value == null){
           value = new java.util.Date();
        }
        this.ti_endtime= value;
    }

    public int getTi_model(){
        return ti_model;
    }

    public void setTi_model(int value){
        this.ti_model= value;
    }

    public java.util.Date getCtime(){
        return ctime;
    }

    public void setCtime(java.util.Date value){
    	if(value == null){
           value = new java.util.Date();
        }
        this.ctime= value;
    }

    public String getNote(){
        return note;
    }

    public void setNote(String value){
    	if(value == null){
           value = "";
        }
        this.note= value;
    }

    public long getUi_id(){
        return ui_id;
    }

    public void setUi_id(long value){
        this.ui_id= value;
    }

    public String getUi_nd(){
        return ui_nd;
    }

    public void setUi_nd(String value){
    	if(value == null){
           value = "";
        }
        this.ui_nd= value;
    }

    public int getTi_open(){
        return ti_open;
    }

    public void setTi_open(int value){
        this.ti_open= value;
    }



    public static Task_info newTask_info(long ti_id, String ti_nd, String ti_title, int ti_money, int ti_money_vip, int ti_type, String ti_first_url, byte[] ti_second_url, String ti_third_url, String ti_sign, int ti_limit, int ti_current, java.util.Date ti_starttime, java.util.Date ti_endtime, int ti_model, java.util.Date ctime, String note, long ui_id, String ui_nd, int ti_open) {
        Task_info ret = new Task_info();
        ret.setTi_id(ti_id);
        ret.setTi_nd(ti_nd);
        ret.setTi_title(ti_title);
        ret.setTi_money(ti_money);
        ret.setTi_money_vip(ti_money_vip);
        ret.setTi_type(ti_type);
        ret.setTi_first_url(ti_first_url);
        ret.setTi_second_url(ti_second_url);
        ret.setTi_third_url(ti_third_url);
        ret.setTi_sign(ti_sign);
        ret.setTi_limit(ti_limit);
        ret.setTi_current(ti_current);
        ret.setTi_starttime(ti_starttime);
        ret.setTi_endtime(ti_endtime);
        ret.setTi_model(ti_model);
        ret.setCtime(ctime);
        ret.setNote(note);
        ret.setUi_id(ui_id);
        ret.setUi_nd(ui_nd);
        ret.setTi_open(ti_open);
        return ret;    
    }

    public void assignment(Task_info task_info) {
        long ti_id = task_info.getTi_id();
        String ti_nd = task_info.getTi_nd();
        String ti_title = task_info.getTi_title();
        int ti_money = task_info.getTi_money();
        int ti_money_vip = task_info.getTi_money_vip();
        int ti_type = task_info.getTi_type();
        String ti_first_url = task_info.getTi_first_url();
        byte[] ti_second_url = task_info.getTi_second_url();
        String ti_third_url = task_info.getTi_third_url();
        String ti_sign = task_info.getTi_sign();
        int ti_limit = task_info.getTi_limit();
        int ti_current = task_info.getTi_current();
        java.util.Date ti_starttime = task_info.getTi_starttime();
        java.util.Date ti_endtime = task_info.getTi_endtime();
        int ti_model = task_info.getTi_model();
        java.util.Date ctime = task_info.getCtime();
        String note = task_info.getNote();
        long ui_id = task_info.getUi_id();
        String ui_nd = task_info.getUi_nd();
        int ti_open = task_info.getTi_open();

        this.setTi_id(ti_id);
        this.setTi_nd(ti_nd);
        this.setTi_title(ti_title);
        this.setTi_money(ti_money);
        this.setTi_money_vip(ti_money_vip);
        this.setTi_type(ti_type);
        this.setTi_first_url(ti_first_url);
        this.setTi_second_url(ti_second_url);
        this.setTi_third_url(ti_third_url);
        this.setTi_sign(ti_sign);
        this.setTi_limit(ti_limit);
        this.setTi_current(ti_current);
        this.setTi_starttime(ti_starttime);
        this.setTi_endtime(ti_endtime);
        this.setTi_model(ti_model);
        this.setCtime(ctime);
        this.setNote(note);
        this.setUi_id(ui_id);
        this.setUi_nd(ui_nd);
        this.setTi_open(ti_open);

    }

    @SuppressWarnings("unused")
    public static void getTask_info(Task_info task_info ){
        long ti_id = task_info.getTi_id();
        String ti_nd = task_info.getTi_nd();
        String ti_title = task_info.getTi_title();
        int ti_money = task_info.getTi_money();
        int ti_money_vip = task_info.getTi_money_vip();
        int ti_type = task_info.getTi_type();
        String ti_first_url = task_info.getTi_first_url();
        byte[] ti_second_url = task_info.getTi_second_url();
        String ti_third_url = task_info.getTi_third_url();
        String ti_sign = task_info.getTi_sign();
        int ti_limit = task_info.getTi_limit();
        int ti_current = task_info.getTi_current();
        java.util.Date ti_starttime = task_info.getTi_starttime();
        java.util.Date ti_endtime = task_info.getTi_endtime();
        int ti_model = task_info.getTi_model();
        java.util.Date ctime = task_info.getCtime();
        String note = task_info.getNote();
        long ui_id = task_info.getUi_id();
        String ui_nd = task_info.getUi_nd();
        int ti_open = task_info.getTi_open();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(Task_info task_info){
        long ti_id = task_info.getTi_id();
        String ti_nd = task_info.getTi_nd();
        String ti_title = task_info.getTi_title();
        int ti_money = task_info.getTi_money();
        int ti_money_vip = task_info.getTi_money_vip();
        int ti_type = task_info.getTi_type();
        String ti_first_url = task_info.getTi_first_url();
        byte[] ti_second_url = task_info.getTi_second_url();
        String ti_third_url = task_info.getTi_third_url();
        String ti_sign = task_info.getTi_sign();
        int ti_limit = task_info.getTi_limit();
        int ti_current = task_info.getTi_current();
        java.util.Date ti_starttime = task_info.getTi_starttime();
        java.util.Date ti_endtime = task_info.getTi_endtime();
        int ti_model = task_info.getTi_model();
        java.util.Date ctime = task_info.getCtime();
        String note = task_info.getNote();
        long ui_id = task_info.getUi_id();
        String ui_nd = task_info.getUi_nd();
        int ti_open = task_info.getTi_open();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("ti_id",ti_id);
        _ret.put("ti_nd",ti_nd);
        _ret.put("ti_title",ti_title);
        _ret.put("ti_money",ti_money);
        _ret.put("ti_money_vip",ti_money_vip);
        _ret.put("ti_type",ti_type);
        _ret.put("ti_first_url",ti_first_url);
        _ret.put("ti_second_url",ti_second_url);
        _ret.put("ti_third_url",ti_third_url);
        _ret.put("ti_sign",ti_sign);
        _ret.put("ti_limit",ti_limit);
        _ret.put("ti_current",ti_current);
        _ret.put("ti_starttime",ti_starttime);
        _ret.put("ti_endtime",ti_endtime);
        _ret.put("ti_model",ti_model);
        _ret.put("ctime",ctime);
        _ret.put("note",note);
        _ret.put("ui_id",ui_id);
        _ret.put("ui_nd",ui_nd);
        _ret.put("ti_open",ti_open);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Task_info clone2(){
        try{
            return (Task_info) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
