package com.pyb.bean;

import java.io.*;
import java.util.*;

//user_recommend
@SuppressWarnings({"serial"})
public class User_recommend implements Cloneable , Serializable{

    //public static String[] carrays ={"ur_id","ur_nd","ur_ui_id","ur_ui_nd","other_ui_id","other_ui_nd","ur_money","deal_state","ctime","note"};

    public long ur_id;//bigint(20)    主键ID
    public String ur_nd="";//varchar(80)    唯一标识ND
    public long ur_ui_id;//bigint(20)    推荐人用户ID
    public String ur_ui_nd="";//varchar(80)    推荐人ND
    public long other_ui_id;//bigint(20)    被推荐人用户ID
    public String other_ui_nd="";//varchar(80)    被推荐人用户ND
    public int ur_money;//int(11)    推荐奖励金额（单位分）
    public int deal_state;//int(11)    是否已经处理（0:没有处理1:处理成功2:处理失败）
    public java.util.Date ctime=new java.util.Date();//datetime    创建时间
    public String note="";//varchar(100)    备注



    public long getUr_id(){
        return ur_id;
    }

    public void setUr_id(long value){
        this.ur_id= value;
    }

    public String getUr_nd(){
        return ur_nd;
    }

    public void setUr_nd(String value){
    	if(value == null){
           value = "";
        }
        this.ur_nd= value;
    }

    public long getUr_ui_id(){
        return ur_ui_id;
    }

    public void setUr_ui_id(long value){
        this.ur_ui_id= value;
    }

    public String getUr_ui_nd(){
        return ur_ui_nd;
    }

    public void setUr_ui_nd(String value){
    	if(value == null){
           value = "";
        }
        this.ur_ui_nd= value;
    }

    public long getOther_ui_id(){
        return other_ui_id;
    }

    public void setOther_ui_id(long value){
        this.other_ui_id= value;
    }

    public String getOther_ui_nd(){
        return other_ui_nd;
    }

    public void setOther_ui_nd(String value){
    	if(value == null){
           value = "";
        }
        this.other_ui_nd= value;
    }

    public int getUr_money(){
        return ur_money;
    }

    public void setUr_money(int value){
        this.ur_money= value;
    }

    public int getDeal_state(){
        return deal_state;
    }

    public void setDeal_state(int value){
        this.deal_state= value;
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



    public static User_recommend newUser_recommend(long ur_id, String ur_nd, long ur_ui_id, String ur_ui_nd, long other_ui_id, String other_ui_nd, int ur_money, int deal_state, java.util.Date ctime, String note) {
        User_recommend ret = new User_recommend();
        ret.setUr_id(ur_id);
        ret.setUr_nd(ur_nd);
        ret.setUr_ui_id(ur_ui_id);
        ret.setUr_ui_nd(ur_ui_nd);
        ret.setOther_ui_id(other_ui_id);
        ret.setOther_ui_nd(other_ui_nd);
        ret.setUr_money(ur_money);
        ret.setDeal_state(deal_state);
        ret.setCtime(ctime);
        ret.setNote(note);
        return ret;    
    }

    public void assignment(User_recommend user_recommend) {
        long ur_id = user_recommend.getUr_id();
        String ur_nd = user_recommend.getUr_nd();
        long ur_ui_id = user_recommend.getUr_ui_id();
        String ur_ui_nd = user_recommend.getUr_ui_nd();
        long other_ui_id = user_recommend.getOther_ui_id();
        String other_ui_nd = user_recommend.getOther_ui_nd();
        int ur_money = user_recommend.getUr_money();
        int deal_state = user_recommend.getDeal_state();
        java.util.Date ctime = user_recommend.getCtime();
        String note = user_recommend.getNote();

        this.setUr_id(ur_id);
        this.setUr_nd(ur_nd);
        this.setUr_ui_id(ur_ui_id);
        this.setUr_ui_nd(ur_ui_nd);
        this.setOther_ui_id(other_ui_id);
        this.setOther_ui_nd(other_ui_nd);
        this.setUr_money(ur_money);
        this.setDeal_state(deal_state);
        this.setCtime(ctime);
        this.setNote(note);

    }

    @SuppressWarnings("unused")
    public static void getUser_recommend(User_recommend user_recommend ){
        long ur_id = user_recommend.getUr_id();
        String ur_nd = user_recommend.getUr_nd();
        long ur_ui_id = user_recommend.getUr_ui_id();
        String ur_ui_nd = user_recommend.getUr_ui_nd();
        long other_ui_id = user_recommend.getOther_ui_id();
        String other_ui_nd = user_recommend.getOther_ui_nd();
        int ur_money = user_recommend.getUr_money();
        int deal_state = user_recommend.getDeal_state();
        java.util.Date ctime = user_recommend.getCtime();
        String note = user_recommend.getNote();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(User_recommend user_recommend){
        long ur_id = user_recommend.getUr_id();
        String ur_nd = user_recommend.getUr_nd();
        long ur_ui_id = user_recommend.getUr_ui_id();
        String ur_ui_nd = user_recommend.getUr_ui_nd();
        long other_ui_id = user_recommend.getOther_ui_id();
        String other_ui_nd = user_recommend.getOther_ui_nd();
        int ur_money = user_recommend.getUr_money();
        int deal_state = user_recommend.getDeal_state();
        java.util.Date ctime = user_recommend.getCtime();
        String note = user_recommend.getNote();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("ur_id",ur_id);
        _ret.put("ur_nd",ur_nd);
        _ret.put("ur_ui_id",ur_ui_id);
        _ret.put("ur_ui_nd",ur_ui_nd);
        _ret.put("other_ui_id",other_ui_id);
        _ret.put("other_ui_nd",other_ui_nd);
        _ret.put("ur_money",ur_money);
        _ret.put("deal_state",deal_state);
        _ret.put("ctime",ctime);
        _ret.put("note",note);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public User_recommend clone2(){
        try{
            return (User_recommend) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
