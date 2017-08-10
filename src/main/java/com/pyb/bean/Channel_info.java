package com.pyb.bean;

import java.io.*;
import java.util.*;

//channel_info
@SuppressWarnings({"serial"})
public class Channel_info implements Cloneable , Serializable{

    //public static String[] carrays ={"ci_id","ci_name","ui_id","ctime","is_show","ci_type","ci_sort","note"};

    public long ci_id;//bigint(20)    
    public String ci_name="";//varchar(100)    频道名称
    public long ui_id;//bigint(20)    创建人用户ID
    public java.util.Date ctime=new java.util.Date();//datetime    创建时间
    public int is_show;//int(11)    是否显示0:显示1：不显示
    public int ci_type;//int(11)    频道类型:0免费1：收费
    public int ci_sort;//int(11)    排序权重比逆序
    public String note="";//varchar(255)    



    public long getCi_id(){
        return ci_id;
    }

    public void setCi_id(long value){
        this.ci_id= value;
    }

    public String getCi_name(){
        return ci_name;
    }

    public void setCi_name(String value){
    	if(value == null){
           value = "";
        }
        this.ci_name= value;
    }

    public long getUi_id(){
        return ui_id;
    }

    public void setUi_id(long value){
        this.ui_id= value;
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

    public int getIs_show(){
        return is_show;
    }

    public void setIs_show(int value){
        this.is_show= value;
    }

    public int getCi_type(){
        return ci_type;
    }

    public void setCi_type(int value){
        this.ci_type= value;
    }

    public int getCi_sort(){
        return ci_sort;
    }

    public void setCi_sort(int value){
        this.ci_sort= value;
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



    public static Channel_info newChannel_info(long ci_id, String ci_name, long ui_id, java.util.Date ctime, int is_show, int ci_type, int ci_sort, String note) {
        Channel_info ret = new Channel_info();
        ret.setCi_id(ci_id);
        ret.setCi_name(ci_name);
        ret.setUi_id(ui_id);
        ret.setCtime(ctime);
        ret.setIs_show(is_show);
        ret.setCi_type(ci_type);
        ret.setCi_sort(ci_sort);
        ret.setNote(note);
        return ret;    
    }

    public void assignment(Channel_info channel_info) {
        long ci_id = channel_info.getCi_id();
        String ci_name = channel_info.getCi_name();
        long ui_id = channel_info.getUi_id();
        java.util.Date ctime = channel_info.getCtime();
        int is_show = channel_info.getIs_show();
        int ci_type = channel_info.getCi_type();
        int ci_sort = channel_info.getCi_sort();
        String note = channel_info.getNote();

        this.setCi_id(ci_id);
        this.setCi_name(ci_name);
        this.setUi_id(ui_id);
        this.setCtime(ctime);
        this.setIs_show(is_show);
        this.setCi_type(ci_type);
        this.setCi_sort(ci_sort);
        this.setNote(note);

    }

    @SuppressWarnings("unused")
    public static void getChannel_info(Channel_info channel_info ){
        long ci_id = channel_info.getCi_id();
        String ci_name = channel_info.getCi_name();
        long ui_id = channel_info.getUi_id();
        java.util.Date ctime = channel_info.getCtime();
        int is_show = channel_info.getIs_show();
        int ci_type = channel_info.getCi_type();
        int ci_sort = channel_info.getCi_sort();
        String note = channel_info.getNote();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(Channel_info channel_info){
        long ci_id = channel_info.getCi_id();
        String ci_name = channel_info.getCi_name();
        long ui_id = channel_info.getUi_id();
        java.util.Date ctime = channel_info.getCtime();
        int is_show = channel_info.getIs_show();
        int ci_type = channel_info.getCi_type();
        int ci_sort = channel_info.getCi_sort();
        String note = channel_info.getNote();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("ci_id",ci_id);
        _ret.put("ci_name",ci_name);
        _ret.put("ui_id",ui_id);
        _ret.put("ctime",ctime);
        _ret.put("is_show",is_show);
        _ret.put("ci_type",ci_type);
        _ret.put("ci_sort",ci_sort);
        _ret.put("note",note);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Channel_info clone2(){
        try{
            return (Channel_info) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
