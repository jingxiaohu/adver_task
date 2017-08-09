package com.pyb.bean;

import java.io.*;
import java.util.*;

//user_exchange
@SuppressWarnings({"serial"})
public class User_exchange implements Cloneable , Serializable{

    //public static String[] carrays ={"ue_id","ui_id","ue_time","ue_time_str","ue_state","us_id","us_name","ue_money","ue_desc","ue_zfb","ue_telephone","ue_cft","ui_vc_old","note"};

    public long ue_id;//bigint(20)    
    public long ui_id;//bigint(20)    用户ID
    public long ue_time;//bigint(20)    创建时间
    public String ue_time_str="";//varchar(60)    
    public int ue_state;//int(11)    兑换状态：0未兑换1已兑换
    public long us_id;//bigint(20)    兑换种类0：电话充值1：Q币
    public String us_name="";//varchar(100)    兑换礼物名称
    public long ue_money;//bigint(20)    兑换消耗的牛币
    public String ue_desc="";//varchar(200)    描述
    public String ue_zfb="";//varchar(100)    支付宝
    public String ue_telephone="";//varchar(11)    电话号码
    public String ue_cft="";//varchar(30)    财付通
    public long ui_vc_old;//bigint(20)    用户兑换前的牛币总数
    public String note="";//varchar(100)    备注



    public long getUe_id(){
        return ue_id;
    }

    public void setUe_id(long value){
        this.ue_id= value;
    }

    public long getUi_id(){
        return ui_id;
    }

    public void setUi_id(long value){
        this.ui_id= value;
    }

    public long getUe_time(){
        return ue_time;
    }

    public void setUe_time(long value){
        this.ue_time= value;
    }

    public String getUe_time_str(){
        return ue_time_str;
    }

    public void setUe_time_str(String value){
    	if(value == null){
           value = "";
        }
        this.ue_time_str= value;
    }

    public int getUe_state(){
        return ue_state;
    }

    public void setUe_state(int value){
        this.ue_state= value;
    }

    public long getUs_id(){
        return us_id;
    }

    public void setUs_id(long value){
        this.us_id= value;
    }

    public String getUs_name(){
        return us_name;
    }

    public void setUs_name(String value){
    	if(value == null){
           value = "";
        }
        this.us_name= value;
    }

    public long getUe_money(){
        return ue_money;
    }

    public void setUe_money(long value){
        this.ue_money= value;
    }

    public String getUe_desc(){
        return ue_desc;
    }

    public void setUe_desc(String value){
    	if(value == null){
           value = "";
        }
        this.ue_desc= value;
    }

    public String getUe_zfb(){
        return ue_zfb;
    }

    public void setUe_zfb(String value){
    	if(value == null){
           value = "";
        }
        this.ue_zfb= value;
    }

    public String getUe_telephone(){
        return ue_telephone;
    }

    public void setUe_telephone(String value){
    	if(value == null){
           value = "";
        }
        this.ue_telephone= value;
    }

    public String getUe_cft(){
        return ue_cft;
    }

    public void setUe_cft(String value){
    	if(value == null){
           value = "";
        }
        this.ue_cft= value;
    }

    public long getUi_vc_old(){
        return ui_vc_old;
    }

    public void setUi_vc_old(long value){
        this.ui_vc_old= value;
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



    public static User_exchange newUser_exchange(long ue_id, long ui_id, long ue_time, String ue_time_str, int ue_state, long us_id, String us_name, long ue_money, String ue_desc, String ue_zfb, String ue_telephone, String ue_cft, long ui_vc_old, String note) {
        User_exchange ret = new User_exchange();
        ret.setUe_id(ue_id);
        ret.setUi_id(ui_id);
        ret.setUe_time(ue_time);
        ret.setUe_time_str(ue_time_str);
        ret.setUe_state(ue_state);
        ret.setUs_id(us_id);
        ret.setUs_name(us_name);
        ret.setUe_money(ue_money);
        ret.setUe_desc(ue_desc);
        ret.setUe_zfb(ue_zfb);
        ret.setUe_telephone(ue_telephone);
        ret.setUe_cft(ue_cft);
        ret.setUi_vc_old(ui_vc_old);
        ret.setNote(note);
        return ret;    
    }

    public void assignment(User_exchange user_exchange) {
        long ue_id = user_exchange.getUe_id();
        long ui_id = user_exchange.getUi_id();
        long ue_time = user_exchange.getUe_time();
        String ue_time_str = user_exchange.getUe_time_str();
        int ue_state = user_exchange.getUe_state();
        long us_id = user_exchange.getUs_id();
        String us_name = user_exchange.getUs_name();
        long ue_money = user_exchange.getUe_money();
        String ue_desc = user_exchange.getUe_desc();
        String ue_zfb = user_exchange.getUe_zfb();
        String ue_telephone = user_exchange.getUe_telephone();
        String ue_cft = user_exchange.getUe_cft();
        long ui_vc_old = user_exchange.getUi_vc_old();
        String note = user_exchange.getNote();

        this.setUe_id(ue_id);
        this.setUi_id(ui_id);
        this.setUe_time(ue_time);
        this.setUe_time_str(ue_time_str);
        this.setUe_state(ue_state);
        this.setUs_id(us_id);
        this.setUs_name(us_name);
        this.setUe_money(ue_money);
        this.setUe_desc(ue_desc);
        this.setUe_zfb(ue_zfb);
        this.setUe_telephone(ue_telephone);
        this.setUe_cft(ue_cft);
        this.setUi_vc_old(ui_vc_old);
        this.setNote(note);

    }

    @SuppressWarnings("unused")
    public static void getUser_exchange(User_exchange user_exchange ){
        long ue_id = user_exchange.getUe_id();
        long ui_id = user_exchange.getUi_id();
        long ue_time = user_exchange.getUe_time();
        String ue_time_str = user_exchange.getUe_time_str();
        int ue_state = user_exchange.getUe_state();
        long us_id = user_exchange.getUs_id();
        String us_name = user_exchange.getUs_name();
        long ue_money = user_exchange.getUe_money();
        String ue_desc = user_exchange.getUe_desc();
        String ue_zfb = user_exchange.getUe_zfb();
        String ue_telephone = user_exchange.getUe_telephone();
        String ue_cft = user_exchange.getUe_cft();
        long ui_vc_old = user_exchange.getUi_vc_old();
        String note = user_exchange.getNote();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(User_exchange user_exchange){
        long ue_id = user_exchange.getUe_id();
        long ui_id = user_exchange.getUi_id();
        long ue_time = user_exchange.getUe_time();
        String ue_time_str = user_exchange.getUe_time_str();
        int ue_state = user_exchange.getUe_state();
        long us_id = user_exchange.getUs_id();
        String us_name = user_exchange.getUs_name();
        long ue_money = user_exchange.getUe_money();
        String ue_desc = user_exchange.getUe_desc();
        String ue_zfb = user_exchange.getUe_zfb();
        String ue_telephone = user_exchange.getUe_telephone();
        String ue_cft = user_exchange.getUe_cft();
        long ui_vc_old = user_exchange.getUi_vc_old();
        String note = user_exchange.getNote();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("ue_id",ue_id);
        _ret.put("ui_id",ui_id);
        _ret.put("ue_time",ue_time);
        _ret.put("ue_time_str",ue_time_str);
        _ret.put("ue_state",ue_state);
        _ret.put("us_id",us_id);
        _ret.put("us_name",us_name);
        _ret.put("ue_money",ue_money);
        _ret.put("ue_desc",ue_desc);
        _ret.put("ue_zfb",ue_zfb);
        _ret.put("ue_telephone",ue_telephone);
        _ret.put("ue_cft",ue_cft);
        _ret.put("ui_vc_old",ui_vc_old);
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
