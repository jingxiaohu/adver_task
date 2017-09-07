package com.pyb.bean;

import java.io.*;
import java.util.*;

//stock_hand
@SuppressWarnings({"serial"})
public class Stock_hand implements Cloneable , Serializable{

    //public static String[] carrays ={"id","s_name","s_code","s_price","s_time","s_type","s_hand","ctime","md5_str","note"};

    public long id;//bigint(20) unsigned    
    public String s_name="";//varchar(150)    名称
    public String s_code="";//varchar(100)    代码
    public String s_price="";//varchar(100)    当时价格
    public String s_time="";//varchar(100)    当时时间
    public String s_type="";//varchar(255)    类型（buy:买sell:卖）
    public int s_hand;//int(11)    手数
    public java.util.Date ctime=new java.util.Date();//datetime    创建时间
    public String md5_str="";//varchar(100)    对内容进行MD5进行签名
    public String note="";//varchar(100)    备注



    public long getId(){
        return id;
    }

    public void setId(long value){
        this.id= value;
    }

    public String getS_name(){
        return s_name;
    }

    public void setS_name(String value){
    	if(value == null){
           value = "";
        }
        this.s_name= value;
    }

    public String getS_code(){
        return s_code;
    }

    public void setS_code(String value){
    	if(value == null){
           value = "";
        }
        this.s_code= value;
    }

    public String getS_price(){
        return s_price;
    }

    public void setS_price(String value){
    	if(value == null){
           value = "";
        }
        this.s_price= value;
    }

    public String getS_time(){
        return s_time;
    }

    public void setS_time(String value){
    	if(value == null){
           value = "";
        }
        this.s_time= value;
    }

    public String getS_type(){
        return s_type;
    }

    public void setS_type(String value){
    	if(value == null){
           value = "";
        }
        this.s_type= value;
    }

    public int getS_hand(){
        return s_hand;
    }

    public void setS_hand(int value){
        this.s_hand= value;
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

    public String getMd5_str(){
        return md5_str;
    }

    public void setMd5_str(String value){
    	if(value == null){
           value = "";
        }
        this.md5_str= value;
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



    public static Stock_hand newStock_hand(long id, String s_name, String s_code, String s_price, String s_time, String s_type, int s_hand, java.util.Date ctime, String md5_str, String note) {
        Stock_hand ret = new Stock_hand();
        ret.setId(id);
        ret.setS_name(s_name);
        ret.setS_code(s_code);
        ret.setS_price(s_price);
        ret.setS_time(s_time);
        ret.setS_type(s_type);
        ret.setS_hand(s_hand);
        ret.setCtime(ctime);
        ret.setMd5_str(md5_str);
        ret.setNote(note);
        return ret;    
    }

    public void assignment(Stock_hand stock_hand) {
        long id = stock_hand.getId();
        String s_name = stock_hand.getS_name();
        String s_code = stock_hand.getS_code();
        String s_price = stock_hand.getS_price();
        String s_time = stock_hand.getS_time();
        String s_type = stock_hand.getS_type();
        int s_hand = stock_hand.getS_hand();
        java.util.Date ctime = stock_hand.getCtime();
        String md5_str = stock_hand.getMd5_str();
        String note = stock_hand.getNote();

        this.setId(id);
        this.setS_name(s_name);
        this.setS_code(s_code);
        this.setS_price(s_price);
        this.setS_time(s_time);
        this.setS_type(s_type);
        this.setS_hand(s_hand);
        this.setCtime(ctime);
        this.setMd5_str(md5_str);
        this.setNote(note);

    }

    @SuppressWarnings("unused")
    public static void getStock_hand(Stock_hand stock_hand ){
        long id = stock_hand.getId();
        String s_name = stock_hand.getS_name();
        String s_code = stock_hand.getS_code();
        String s_price = stock_hand.getS_price();
        String s_time = stock_hand.getS_time();
        String s_type = stock_hand.getS_type();
        int s_hand = stock_hand.getS_hand();
        java.util.Date ctime = stock_hand.getCtime();
        String md5_str = stock_hand.getMd5_str();
        String note = stock_hand.getNote();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(Stock_hand stock_hand){
        long id = stock_hand.getId();
        String s_name = stock_hand.getS_name();
        String s_code = stock_hand.getS_code();
        String s_price = stock_hand.getS_price();
        String s_time = stock_hand.getS_time();
        String s_type = stock_hand.getS_type();
        int s_hand = stock_hand.getS_hand();
        java.util.Date ctime = stock_hand.getCtime();
        String md5_str = stock_hand.getMd5_str();
        String note = stock_hand.getNote();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("id",id);
        _ret.put("s_name",s_name);
        _ret.put("s_code",s_code);
        _ret.put("s_price",s_price);
        _ret.put("s_time",s_time);
        _ret.put("s_type",s_type);
        _ret.put("s_hand",s_hand);
        _ret.put("ctime",ctime);
        _ret.put("md5_str",md5_str);
        _ret.put("note",note);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Stock_hand clone2(){
        try{
            return (Stock_hand) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
