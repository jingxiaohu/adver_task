package com.pyb.bean;

import java.io.*;
import java.util.*;

//user_external
@SuppressWarnings({"serial"})
public class User_external implements Cloneable , Serializable{

    //public static String[] carrays ={"up_id","ui_id","up_type","up_token","up_key","ctime","utime","note"};

    public long up_id;//bigint(20)    
    public long ui_id;//bigint(20)    用户标识关联user_info表里面的用户uuid
    public int up_type;//int(11)    用户账户类型0微信用户1新浪账户2腾讯账户3人人账户4开心账户5天涯账户6FACEBOOK
    public String up_token="";//varchar(500)    外部TOKEN
    public String up_key="";//varchar(500)    外部主键
    public long ctime;//bigint(20)    
    public long utime;//bigint(20)    
    public String note="";//varchar(255)    



    public long getUp_id(){
        return up_id;
    }

    public void setUp_id(long value){
        this.up_id= value;
    }

    public long getUi_id(){
        return ui_id;
    }

    public void setUi_id(long value){
        this.ui_id= value;
    }

    public int getUp_type(){
        return up_type;
    }

    public void setUp_type(int value){
        this.up_type= value;
    }

    public String getUp_token(){
        return up_token;
    }

    public void setUp_token(String value){
    	if(value == null){
           value = "";
        }
        this.up_token= value;
    }

    public String getUp_key(){
        return up_key;
    }

    public void setUp_key(String value){
    	if(value == null){
           value = "";
        }
        this.up_key= value;
    }

    public long getCtime(){
        return ctime;
    }

    public void setCtime(long value){
        this.ctime= value;
    }

    public long getUtime(){
        return utime;
    }

    public void setUtime(long value){
        this.utime= value;
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



    public static User_external newUser_external(long up_id, long ui_id, int up_type, String up_token, String up_key, long ctime, long utime, String note) {
        User_external ret = new User_external();
        ret.setUp_id(up_id);
        ret.setUi_id(ui_id);
        ret.setUp_type(up_type);
        ret.setUp_token(up_token);
        ret.setUp_key(up_key);
        ret.setCtime(ctime);
        ret.setUtime(utime);
        ret.setNote(note);
        return ret;    
    }

    public void assignment(User_external user_external) {
        long up_id = user_external.getUp_id();
        long ui_id = user_external.getUi_id();
        int up_type = user_external.getUp_type();
        String up_token = user_external.getUp_token();
        String up_key = user_external.getUp_key();
        long ctime = user_external.getCtime();
        long utime = user_external.getUtime();
        String note = user_external.getNote();

        this.setUp_id(up_id);
        this.setUi_id(ui_id);
        this.setUp_type(up_type);
        this.setUp_token(up_token);
        this.setUp_key(up_key);
        this.setCtime(ctime);
        this.setUtime(utime);
        this.setNote(note);

    }

    @SuppressWarnings("unused")
    public static void getUser_external(User_external user_external ){
        long up_id = user_external.getUp_id();
        long ui_id = user_external.getUi_id();
        int up_type = user_external.getUp_type();
        String up_token = user_external.getUp_token();
        String up_key = user_external.getUp_key();
        long ctime = user_external.getCtime();
        long utime = user_external.getUtime();
        String note = user_external.getNote();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(User_external user_external){
        long up_id = user_external.getUp_id();
        long ui_id = user_external.getUi_id();
        int up_type = user_external.getUp_type();
        String up_token = user_external.getUp_token();
        String up_key = user_external.getUp_key();
        long ctime = user_external.getCtime();
        long utime = user_external.getUtime();
        String note = user_external.getNote();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("up_id",up_id);
        _ret.put("ui_id",ui_id);
        _ret.put("up_type",up_type);
        _ret.put("up_token",up_token);
        _ret.put("up_key",up_key);
        _ret.put("ctime",ctime);
        _ret.put("utime",utime);
        _ret.put("note",note);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public User_external clone2(){
        try{
            return (User_external) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
