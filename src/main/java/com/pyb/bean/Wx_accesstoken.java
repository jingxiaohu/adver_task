package com.pyb.bean;

import java.io.*;
import java.util.*;

//wx_accesstoken
@SuppressWarnings({"serial"})
public class Wx_accesstoken implements Cloneable , Serializable{

    //public static String[] carrays ={"id","access_token","expires_in","utime"};

    public long id;//bigint(20)    主键ID
    public String access_token="";//varchar(255)    access_token
    public int expires_in;//int(11)    expires_in
    public java.util.Date utime=new java.util.Date();//timestamp    刷新时间



    public long getId(){
        return id;
    }

    public void setId(long value){
        this.id= value;
    }

    public String getAccess_token(){
        return access_token;
    }

    public void setAccess_token(String value){
    	if(value == null){
           value = "";
        }
        this.access_token= value;
    }

    public int getExpires_in(){
        return expires_in;
    }

    public void setExpires_in(int value){
        this.expires_in= value;
    }

    public java.util.Date getUtime(){
        return utime;
    }

    public void setUtime(java.util.Date value){
    	if(value == null){
           value = new java.util.Date();
        }
        this.utime= value;
    }



    public static Wx_accesstoken newWx_accesstoken(long id, String access_token, int expires_in, java.util.Date utime) {
        Wx_accesstoken ret = new Wx_accesstoken();
        ret.setId(id);
        ret.setAccess_token(access_token);
        ret.setExpires_in(expires_in);
        ret.setUtime(utime);
        return ret;    
    }

    public void assignment(Wx_accesstoken wx_accesstoken) {
        long id = wx_accesstoken.getId();
        String access_token = wx_accesstoken.getAccess_token();
        int expires_in = wx_accesstoken.getExpires_in();
        java.util.Date utime = wx_accesstoken.getUtime();

        this.setId(id);
        this.setAccess_token(access_token);
        this.setExpires_in(expires_in);
        this.setUtime(utime);

    }

    @SuppressWarnings("unused")
    public static void getWx_accesstoken(Wx_accesstoken wx_accesstoken ){
        long id = wx_accesstoken.getId();
        String access_token = wx_accesstoken.getAccess_token();
        int expires_in = wx_accesstoken.getExpires_in();
        java.util.Date utime = wx_accesstoken.getUtime();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(Wx_accesstoken wx_accesstoken){
        long id = wx_accesstoken.getId();
        String access_token = wx_accesstoken.getAccess_token();
        int expires_in = wx_accesstoken.getExpires_in();
        java.util.Date utime = wx_accesstoken.getUtime();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("id",id);
        _ret.put("access_token",access_token);
        _ret.put("expires_in",expires_in);
        _ret.put("utime",utime);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Wx_accesstoken clone2(){
        try{
            return (Wx_accesstoken) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
