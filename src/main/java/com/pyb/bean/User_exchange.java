package com.pyb.bean;

import java.io.*;
import java.util.*;

//user_exchange
@SuppressWarnings({"serial"})
public class User_exchange implements Cloneable , Serializable{

    //public static String[] carrays ={"ue_id","ue_nd","ui_id","ui_nd","ue_type","ue_name","ue_money","rest_money","ctime","note"};

    public long ue_id;//bigint(20)    主键ID
    public String ue_nd="";//varchar(80)    兑换提现表ND
    public long ui_id;//bigint(20)    用户主键ID
    public String ui_nd="";//varchar(80)    用户ND
    public int ue_type;//int(11)    类型（0:提现1:电话充值2:充值Q币）
    public String ue_name="";//varchar(80)    兑换或者提现名称
    public int ue_money;//int(11)    兑换或者提现金额（单位分）
    public int rest_money;//int(11)    兑换后剩余金额(单位分)
    public java.util.Date ctime=new java.util.Date();//datetime    创建时间
    public String note="";//varchar(100)    备注



    public long getUe_id(){
        return ue_id;
    }

    public void setUe_id(long value){
        this.ue_id= value;
    }

    public String getUe_nd(){
        return ue_nd;
    }

    public void setUe_nd(String value){
    	if(value == null){
           value = "";
        }
        this.ue_nd= value;
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

    public int getUe_type(){
        return ue_type;
    }

    public void setUe_type(int value){
        this.ue_type= value;
    }

    public String getUe_name(){
        return ue_name;
    }

    public void setUe_name(String value){
    	if(value == null){
           value = "";
        }
        this.ue_name= value;
    }

    public int getUe_money(){
        return ue_money;
    }

    public void setUe_money(int value){
        this.ue_money= value;
    }

    public int getRest_money(){
        return rest_money;
    }

    public void setRest_money(int value){
        this.rest_money= value;
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



    public static User_exchange newUser_exchange(long ue_id, String ue_nd, long ui_id, String ui_nd, int ue_type, String ue_name, int ue_money, int rest_money, java.util.Date ctime, String note) {
        User_exchange ret = new User_exchange();
        ret.setUe_id(ue_id);
        ret.setUe_nd(ue_nd);
        ret.setUi_id(ui_id);
        ret.setUi_nd(ui_nd);
        ret.setUe_type(ue_type);
        ret.setUe_name(ue_name);
        ret.setUe_money(ue_money);
        ret.setRest_money(rest_money);
        ret.setCtime(ctime);
        ret.setNote(note);
        return ret;    
    }

    public void assignment(User_exchange user_exchange) {
        long ue_id = user_exchange.getUe_id();
        String ue_nd = user_exchange.getUe_nd();
        long ui_id = user_exchange.getUi_id();
        String ui_nd = user_exchange.getUi_nd();
        int ue_type = user_exchange.getUe_type();
        String ue_name = user_exchange.getUe_name();
        int ue_money = user_exchange.getUe_money();
        int rest_money = user_exchange.getRest_money();
        java.util.Date ctime = user_exchange.getCtime();
        String note = user_exchange.getNote();

        this.setUe_id(ue_id);
        this.setUe_nd(ue_nd);
        this.setUi_id(ui_id);
        this.setUi_nd(ui_nd);
        this.setUe_type(ue_type);
        this.setUe_name(ue_name);
        this.setUe_money(ue_money);
        this.setRest_money(rest_money);
        this.setCtime(ctime);
        this.setNote(note);

    }

    @SuppressWarnings("unused")
    public static void getUser_exchange(User_exchange user_exchange ){
        long ue_id = user_exchange.getUe_id();
        String ue_nd = user_exchange.getUe_nd();
        long ui_id = user_exchange.getUi_id();
        String ui_nd = user_exchange.getUi_nd();
        int ue_type = user_exchange.getUe_type();
        String ue_name = user_exchange.getUe_name();
        int ue_money = user_exchange.getUe_money();
        int rest_money = user_exchange.getRest_money();
        java.util.Date ctime = user_exchange.getCtime();
        String note = user_exchange.getNote();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(User_exchange user_exchange){
        long ue_id = user_exchange.getUe_id();
        String ue_nd = user_exchange.getUe_nd();
        long ui_id = user_exchange.getUi_id();
        String ui_nd = user_exchange.getUi_nd();
        int ue_type = user_exchange.getUe_type();
        String ue_name = user_exchange.getUe_name();
        int ue_money = user_exchange.getUe_money();
        int rest_money = user_exchange.getRest_money();
        java.util.Date ctime = user_exchange.getCtime();
        String note = user_exchange.getNote();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("ue_id",ue_id);
        _ret.put("ue_nd",ue_nd);
        _ret.put("ui_id",ui_id);
        _ret.put("ui_nd",ui_nd);
        _ret.put("ue_type",ue_type);
        _ret.put("ue_name",ue_name);
        _ret.put("ue_money",ue_money);
        _ret.put("rest_money",rest_money);
        _ret.put("ctime",ctime);
        _ret.put("note",note);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public User_exchange clone2(){
        try{
            return (User_exchange) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
