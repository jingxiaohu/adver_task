package com.pyb.bean;

import java.io.*;
import java.util.*;

//user_task
@SuppressWarnings({"serial"})
public class User_task implements Cloneable , Serializable{

    //public static String[] carrays ={"ut_id","ut_nd","ti_id","ti_nd","ui_id","ui_nd","ut_code","ut_sign","ut_sate","ut_money","ctime","note","type","deal_state"};

    public long ut_id;//bigint(20)    主键ID
    public String ut_nd="";//varchar(80)    nd
    public long ti_id;//bigint(20)    任务主键ID
    public String ti_nd="";//varchar(80)    任务nd
    public long ui_id;//bigint(20)    用户ID
    public String ui_nd="";//varchar(80)    用户nd
    public String ut_code="";//varchar(60)    提交的验证码
    public String ut_sign="";//varchar(255)    提交的验证信息
    public int ut_sate;//int(11)    是否验证成功（0:没有1:成功）
    public int ut_money;//int(11)    获取金额
    public java.util.Date ctime=new java.util.Date();//datetime    创建时间
    public String note="";//varchar(100)    备注
    public int type;//int(11)    任务类型（0:普通任务1:游戏任务）
    public int deal_state;//int(11)    是否已经处理（0:没有1:处理成功2:处理失败）



    public long getUt_id(){
        return ut_id;
    }

    public void setUt_id(long value){
        this.ut_id= value;
    }

    public String getUt_nd(){
        return ut_nd;
    }

    public void setUt_nd(String value){
    	if(value == null){
           value = "";
        }
        this.ut_nd= value;
    }

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

    public String getUt_code(){
        return ut_code;
    }

    public void setUt_code(String value){
    	if(value == null){
           value = "";
        }
        this.ut_code= value;
    }

    public String getUt_sign(){
        return ut_sign;
    }

    public void setUt_sign(String value){
    	if(value == null){
           value = "";
        }
        this.ut_sign= value;
    }

    public int getUt_sate(){
        return ut_sate;
    }

    public void setUt_sate(int value){
        this.ut_sate= value;
    }

    public int getUt_money(){
        return ut_money;
    }

    public void setUt_money(int value){
        this.ut_money= value;
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

    public int getType(){
        return type;
    }

    public void setType(int value){
        this.type= value;
    }

    public int getDeal_state(){
        return deal_state;
    }

    public void setDeal_state(int value){
        this.deal_state= value;
    }



    public static User_task newUser_task(long ut_id, String ut_nd, long ti_id, String ti_nd, long ui_id, String ui_nd, String ut_code, String ut_sign, int ut_sate, int ut_money, java.util.Date ctime, String note, int type, int deal_state) {
        User_task ret = new User_task();
        ret.setUt_id(ut_id);
        ret.setUt_nd(ut_nd);
        ret.setTi_id(ti_id);
        ret.setTi_nd(ti_nd);
        ret.setUi_id(ui_id);
        ret.setUi_nd(ui_nd);
        ret.setUt_code(ut_code);
        ret.setUt_sign(ut_sign);
        ret.setUt_sate(ut_sate);
        ret.setUt_money(ut_money);
        ret.setCtime(ctime);
        ret.setNote(note);
        ret.setType(type);
        ret.setDeal_state(deal_state);
        return ret;    
    }

    public void assignment(User_task user_task) {
        long ut_id = user_task.getUt_id();
        String ut_nd = user_task.getUt_nd();
        long ti_id = user_task.getTi_id();
        String ti_nd = user_task.getTi_nd();
        long ui_id = user_task.getUi_id();
        String ui_nd = user_task.getUi_nd();
        String ut_code = user_task.getUt_code();
        String ut_sign = user_task.getUt_sign();
        int ut_sate = user_task.getUt_sate();
        int ut_money = user_task.getUt_money();
        java.util.Date ctime = user_task.getCtime();
        String note = user_task.getNote();
        int type = user_task.getType();
        int deal_state = user_task.getDeal_state();

        this.setUt_id(ut_id);
        this.setUt_nd(ut_nd);
        this.setTi_id(ti_id);
        this.setTi_nd(ti_nd);
        this.setUi_id(ui_id);
        this.setUi_nd(ui_nd);
        this.setUt_code(ut_code);
        this.setUt_sign(ut_sign);
        this.setUt_sate(ut_sate);
        this.setUt_money(ut_money);
        this.setCtime(ctime);
        this.setNote(note);
        this.setType(type);
        this.setDeal_state(deal_state);

    }

    @SuppressWarnings("unused")
    public static void getUser_task(User_task user_task ){
        long ut_id = user_task.getUt_id();
        String ut_nd = user_task.getUt_nd();
        long ti_id = user_task.getTi_id();
        String ti_nd = user_task.getTi_nd();
        long ui_id = user_task.getUi_id();
        String ui_nd = user_task.getUi_nd();
        String ut_code = user_task.getUt_code();
        String ut_sign = user_task.getUt_sign();
        int ut_sate = user_task.getUt_sate();
        int ut_money = user_task.getUt_money();
        java.util.Date ctime = user_task.getCtime();
        String note = user_task.getNote();
        int type = user_task.getType();
        int deal_state = user_task.getDeal_state();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(User_task user_task){
        long ut_id = user_task.getUt_id();
        String ut_nd = user_task.getUt_nd();
        long ti_id = user_task.getTi_id();
        String ti_nd = user_task.getTi_nd();
        long ui_id = user_task.getUi_id();
        String ui_nd = user_task.getUi_nd();
        String ut_code = user_task.getUt_code();
        String ut_sign = user_task.getUt_sign();
        int ut_sate = user_task.getUt_sate();
        int ut_money = user_task.getUt_money();
        java.util.Date ctime = user_task.getCtime();
        String note = user_task.getNote();
        int type = user_task.getType();
        int deal_state = user_task.getDeal_state();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("ut_id",ut_id);
        _ret.put("ut_nd",ut_nd);
        _ret.put("ti_id",ti_id);
        _ret.put("ti_nd",ti_nd);
        _ret.put("ui_id",ui_id);
        _ret.put("ui_nd",ui_nd);
        _ret.put("ut_code",ut_code);
        _ret.put("ut_sign",ut_sign);
        _ret.put("ut_sate",ut_sate);
        _ret.put("ut_money",ut_money);
        _ret.put("ctime",ctime);
        _ret.put("note",note);
        _ret.put("type",type);
        _ret.put("deal_state",deal_state);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public User_task clone2(){
        try{
            return (User_task) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
