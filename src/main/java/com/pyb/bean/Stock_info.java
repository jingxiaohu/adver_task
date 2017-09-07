package com.pyb.bean;

import java.io.*;
import java.util.*;

//stock_info
@SuppressWarnings({"serial"})
public class Stock_info implements Cloneable , Serializable{

    //public static String[] carrays ={"sid","stock_name","stock_code","stock_type","stock_pinyin","stock_t_price","stock_y_price","ctime","note"};

    public long sid;//bigint(20)    
    public String stock_name="";//varchar(100)    
    public String stock_code="";//varchar(100)    
    public String stock_type="";//varchar(30)    上海：sh深圳：sz
    public String stock_pinyin="";//varchar(60)    
    public String stock_t_price="";//varchar(100)    最新价
    public String stock_y_price="";//varchar(100)    昨天的价格
    public java.util.Date ctime=new java.util.Date();//datetime    
    public String note="";//varchar(255)    



    public long getSid(){
        return sid;
    }

    public void setSid(long value){
        this.sid= value;
    }

    public String getStock_name(){
        return stock_name;
    }

    public void setStock_name(String value){
    	if(value == null){
           value = "";
        }
        this.stock_name= value;
    }

    public String getStock_code(){
        return stock_code;
    }

    public void setStock_code(String value){
    	if(value == null){
           value = "";
        }
        this.stock_code= value;
    }

    public String getStock_type(){
        return stock_type;
    }

    public void setStock_type(String value){
    	if(value == null){
           value = "";
        }
        this.stock_type= value;
    }

    public String getStock_pinyin(){
        return stock_pinyin;
    }

    public void setStock_pinyin(String value){
    	if(value == null){
           value = "";
        }
        this.stock_pinyin= value;
    }

    public String getStock_t_price(){
        return stock_t_price;
    }

    public void setStock_t_price(String value){
    	if(value == null){
           value = "";
        }
        this.stock_t_price= value;
    }

    public String getStock_y_price(){
        return stock_y_price;
    }

    public void setStock_y_price(String value){
    	if(value == null){
           value = "";
        }
        this.stock_y_price= value;
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



    public static Stock_info newStock_info(long sid, String stock_name, String stock_code, String stock_type, String stock_pinyin, String stock_t_price, String stock_y_price, java.util.Date ctime, String note) {
        Stock_info ret = new Stock_info();
        ret.setSid(sid);
        ret.setStock_name(stock_name);
        ret.setStock_code(stock_code);
        ret.setStock_type(stock_type);
        ret.setStock_pinyin(stock_pinyin);
        ret.setStock_t_price(stock_t_price);
        ret.setStock_y_price(stock_y_price);
        ret.setCtime(ctime);
        ret.setNote(note);
        return ret;    
    }

    public void assignment(Stock_info stock_info) {
        long sid = stock_info.getSid();
        String stock_name = stock_info.getStock_name();
        String stock_code = stock_info.getStock_code();
        String stock_type = stock_info.getStock_type();
        String stock_pinyin = stock_info.getStock_pinyin();
        String stock_t_price = stock_info.getStock_t_price();
        String stock_y_price = stock_info.getStock_y_price();
        java.util.Date ctime = stock_info.getCtime();
        String note = stock_info.getNote();

        this.setSid(sid);
        this.setStock_name(stock_name);
        this.setStock_code(stock_code);
        this.setStock_type(stock_type);
        this.setStock_pinyin(stock_pinyin);
        this.setStock_t_price(stock_t_price);
        this.setStock_y_price(stock_y_price);
        this.setCtime(ctime);
        this.setNote(note);

    }

    @SuppressWarnings("unused")
    public static void getStock_info(Stock_info stock_info ){
        long sid = stock_info.getSid();
        String stock_name = stock_info.getStock_name();
        String stock_code = stock_info.getStock_code();
        String stock_type = stock_info.getStock_type();
        String stock_pinyin = stock_info.getStock_pinyin();
        String stock_t_price = stock_info.getStock_t_price();
        String stock_y_price = stock_info.getStock_y_price();
        java.util.Date ctime = stock_info.getCtime();
        String note = stock_info.getNote();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(Stock_info stock_info){
        long sid = stock_info.getSid();
        String stock_name = stock_info.getStock_name();
        String stock_code = stock_info.getStock_code();
        String stock_type = stock_info.getStock_type();
        String stock_pinyin = stock_info.getStock_pinyin();
        String stock_t_price = stock_info.getStock_t_price();
        String stock_y_price = stock_info.getStock_y_price();
        java.util.Date ctime = stock_info.getCtime();
        String note = stock_info.getNote();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("sid",sid);
        _ret.put("stock_name",stock_name);
        _ret.put("stock_code",stock_code);
        _ret.put("stock_type",stock_type);
        _ret.put("stock_pinyin",stock_pinyin);
        _ret.put("stock_t_price",stock_t_price);
        _ret.put("stock_y_price",stock_y_price);
        _ret.put("ctime",ctime);
        _ret.put("note",note);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Stock_info clone2(){
        try{
            return (Stock_info) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
