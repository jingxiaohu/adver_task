package com.pyb.bean;

import java.io.*;
import java.util.*;

//live_info
@SuppressWarnings({"serial"})
public class Live_info implements Cloneable , Serializable{

    //public static String[] carrays ={"mi_id","ui_id","mi_title","mi_content","mi_type","mi_image","mi_flag","mi_day","mi_createtime","mi_area","ci_id","title_md5","uptime","note"};

    public long mi_id;//bigint(20)    
    public long ui_id;//bigint(20)    创建用户
    public String mi_title="";//varchar(300)    消息标题
    public String mi_content="";//text    消息内容
    public String mi_type="";//varchar(10)    标记消息类型0:原创1:评论
    public String mi_image="";//varchar(250)    消息图片
    public int mi_flag;//int(11)    信息来源的标记0Web1Android2Iphone3PC客服端4新浪5腾讯6人人
    public String mi_day="";//varchar(30)    年月日：2016-03-01
    public java.util.Date mi_createtime=new java.util.Date();//datetime    创建时间
    public int mi_area;//int(11)    帖子发送目标地方：0自己看1：广播
    public long ci_id;//bigint(20)    房间号
    public String title_md5="";//varchar(200)    标题的MD5
    public String uptime="";//varchar(60)    抓取的更新时间
    public String note="";//varchar(255)    



    public long getMi_id(){
        return mi_id;
    }

    public void setMi_id(long value){
        this.mi_id= value;
    }

    public long getUi_id(){
        return ui_id;
    }

    public void setUi_id(long value){
        this.ui_id= value;
    }

    public String getMi_title(){
        return mi_title;
    }

    public void setMi_title(String value){
    	if(value == null){
           value = "";
        }
        this.mi_title= value;
    }

    public String getMi_content(){
        return mi_content;
    }

    public void setMi_content(String value){
    	if(value == null){
           value = "";
        }
        this.mi_content= value;
    }

    public String getMi_type(){
        return mi_type;
    }

    public void setMi_type(String value){
    	if(value == null){
           value = "";
        }
        this.mi_type= value;
    }

    public String getMi_image(){
        return mi_image;
    }

    public void setMi_image(String value){
    	if(value == null){
           value = "";
        }
        this.mi_image= value;
    }

    public int getMi_flag(){
        return mi_flag;
    }

    public void setMi_flag(int value){
        this.mi_flag= value;
    }

    public String getMi_day(){
        return mi_day;
    }

    public void setMi_day(String value){
    	if(value == null){
           value = "";
        }
        this.mi_day= value;
    }

    public java.util.Date getMi_createtime(){
        return mi_createtime;
    }

    public void setMi_createtime(java.util.Date value){
    	if(value == null){
           value = new java.util.Date();
        }
        this.mi_createtime= value;
    }

    public int getMi_area(){
        return mi_area;
    }

    public void setMi_area(int value){
        this.mi_area= value;
    }

    public long getCi_id(){
        return ci_id;
    }

    public void setCi_id(long value){
        this.ci_id= value;
    }

    public String getTitle_md5(){
        return title_md5;
    }

    public void setTitle_md5(String value){
    	if(value == null){
           value = "";
        }
        this.title_md5= value;
    }

    public String getUptime(){
        return uptime;
    }

    public void setUptime(String value){
    	if(value == null){
           value = "";
        }
        this.uptime= value;
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



    public static Live_info newLive_info(long mi_id, long ui_id, String mi_title, String mi_content, String mi_type, String mi_image, int mi_flag, String mi_day, java.util.Date mi_createtime, int mi_area, long ci_id, String title_md5, String uptime, String note) {
        Live_info ret = new Live_info();
        ret.setMi_id(mi_id);
        ret.setUi_id(ui_id);
        ret.setMi_title(mi_title);
        ret.setMi_content(mi_content);
        ret.setMi_type(mi_type);
        ret.setMi_image(mi_image);
        ret.setMi_flag(mi_flag);
        ret.setMi_day(mi_day);
        ret.setMi_createtime(mi_createtime);
        ret.setMi_area(mi_area);
        ret.setCi_id(ci_id);
        ret.setTitle_md5(title_md5);
        ret.setUptime(uptime);
        ret.setNote(note);
        return ret;    
    }

    public void assignment(Live_info live_info) {
        long mi_id = live_info.getMi_id();
        long ui_id = live_info.getUi_id();
        String mi_title = live_info.getMi_title();
        String mi_content = live_info.getMi_content();
        String mi_type = live_info.getMi_type();
        String mi_image = live_info.getMi_image();
        int mi_flag = live_info.getMi_flag();
        String mi_day = live_info.getMi_day();
        java.util.Date mi_createtime = live_info.getMi_createtime();
        int mi_area = live_info.getMi_area();
        long ci_id = live_info.getCi_id();
        String title_md5 = live_info.getTitle_md5();
        String uptime = live_info.getUptime();
        String note = live_info.getNote();

        this.setMi_id(mi_id);
        this.setUi_id(ui_id);
        this.setMi_title(mi_title);
        this.setMi_content(mi_content);
        this.setMi_type(mi_type);
        this.setMi_image(mi_image);
        this.setMi_flag(mi_flag);
        this.setMi_day(mi_day);
        this.setMi_createtime(mi_createtime);
        this.setMi_area(mi_area);
        this.setCi_id(ci_id);
        this.setTitle_md5(title_md5);
        this.setUptime(uptime);
        this.setNote(note);

    }

    @SuppressWarnings("unused")
    public static void getLive_info(Live_info live_info ){
        long mi_id = live_info.getMi_id();
        long ui_id = live_info.getUi_id();
        String mi_title = live_info.getMi_title();
        String mi_content = live_info.getMi_content();
        String mi_type = live_info.getMi_type();
        String mi_image = live_info.getMi_image();
        int mi_flag = live_info.getMi_flag();
        String mi_day = live_info.getMi_day();
        java.util.Date mi_createtime = live_info.getMi_createtime();
        int mi_area = live_info.getMi_area();
        long ci_id = live_info.getCi_id();
        String title_md5 = live_info.getTitle_md5();
        String uptime = live_info.getUptime();
        String note = live_info.getNote();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(Live_info live_info){
        long mi_id = live_info.getMi_id();
        long ui_id = live_info.getUi_id();
        String mi_title = live_info.getMi_title();
        String mi_content = live_info.getMi_content();
        String mi_type = live_info.getMi_type();
        String mi_image = live_info.getMi_image();
        int mi_flag = live_info.getMi_flag();
        String mi_day = live_info.getMi_day();
        java.util.Date mi_createtime = live_info.getMi_createtime();
        int mi_area = live_info.getMi_area();
        long ci_id = live_info.getCi_id();
        String title_md5 = live_info.getTitle_md5();
        String uptime = live_info.getUptime();
        String note = live_info.getNote();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("mi_id",mi_id);
        _ret.put("ui_id",ui_id);
        _ret.put("mi_title",mi_title);
        _ret.put("mi_content",mi_content);
        _ret.put("mi_type",mi_type);
        _ret.put("mi_image",mi_image);
        _ret.put("mi_flag",mi_flag);
        _ret.put("mi_day",mi_day);
        _ret.put("mi_createtime",mi_createtime);
        _ret.put("mi_area",mi_area);
        _ret.put("ci_id",ci_id);
        _ret.put("title_md5",title_md5);
        _ret.put("uptime",uptime);
        _ret.put("note",note);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Live_info clone2(){
        try{
            return (Live_info) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
