package com.pyb.bean;

import java.io.*;
import java.util.*;

//wx_banner_img
@SuppressWarnings({"serial"})
public class Wx_banner_img implements Cloneable , Serializable{

    //public static String[] carrays ={"bi_id","img_name","img_url","img_intro","ctime","note","weight","jump_url"};

    public long bi_id;//bigint(20)    主键ID
    public String img_name="";//varchar(80)    图片名称
    public String img_url="";//varchar(200)    图片URL
    public String img_intro="";//varchar(255)    图片功能简介
    public java.util.Date ctime=new java.util.Date();//timestamp    创建时间
    public String note="";//varchar(60)    备注
    public int weight;//int(11)    权重
    public String jump_url="";//varchar(200)    跳转的目的地链接



    public long getBi_id(){
        return bi_id;
    }

    public void setBi_id(long value){
        this.bi_id= value;
    }

    public String getImg_name(){
        return img_name;
    }

    public void setImg_name(String value){
    	if(value == null){
           value = "";
        }
        this.img_name= value;
    }

    public String getImg_url(){
        return img_url;
    }

    public void setImg_url(String value){
    	if(value == null){
           value = "";
        }
        this.img_url= value;
    }

    public String getImg_intro(){
        return img_intro;
    }

    public void setImg_intro(String value){
    	if(value == null){
           value = "";
        }
        this.img_intro= value;
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

    public int getWeight(){
        return weight;
    }

    public void setWeight(int value){
        this.weight= value;
    }

    public String getJump_url(){
        return jump_url;
    }

    public void setJump_url(String value){
    	if(value == null){
           value = "";
        }
        this.jump_url= value;
    }



    public static Wx_banner_img newWx_banner_img(long bi_id, String img_name, String img_url, String img_intro, java.util.Date ctime, String note, int weight, String jump_url) {
        Wx_banner_img ret = new Wx_banner_img();
        ret.setBi_id(bi_id);
        ret.setImg_name(img_name);
        ret.setImg_url(img_url);
        ret.setImg_intro(img_intro);
        ret.setCtime(ctime);
        ret.setNote(note);
        ret.setWeight(weight);
        ret.setJump_url(jump_url);
        return ret;    
    }

    public void assignment(Wx_banner_img wx_banner_img) {
        long bi_id = wx_banner_img.getBi_id();
        String img_name = wx_banner_img.getImg_name();
        String img_url = wx_banner_img.getImg_url();
        String img_intro = wx_banner_img.getImg_intro();
        java.util.Date ctime = wx_banner_img.getCtime();
        String note = wx_banner_img.getNote();
        int weight = wx_banner_img.getWeight();
        String jump_url = wx_banner_img.getJump_url();

        this.setBi_id(bi_id);
        this.setImg_name(img_name);
        this.setImg_url(img_url);
        this.setImg_intro(img_intro);
        this.setCtime(ctime);
        this.setNote(note);
        this.setWeight(weight);
        this.setJump_url(jump_url);

    }

    @SuppressWarnings("unused")
    public static void getWx_banner_img(Wx_banner_img wx_banner_img ){
        long bi_id = wx_banner_img.getBi_id();
        String img_name = wx_banner_img.getImg_name();
        String img_url = wx_banner_img.getImg_url();
        String img_intro = wx_banner_img.getImg_intro();
        java.util.Date ctime = wx_banner_img.getCtime();
        String note = wx_banner_img.getNote();
        int weight = wx_banner_img.getWeight();
        String jump_url = wx_banner_img.getJump_url();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(Wx_banner_img wx_banner_img){
        long bi_id = wx_banner_img.getBi_id();
        String img_name = wx_banner_img.getImg_name();
        String img_url = wx_banner_img.getImg_url();
        String img_intro = wx_banner_img.getImg_intro();
        java.util.Date ctime = wx_banner_img.getCtime();
        String note = wx_banner_img.getNote();
        int weight = wx_banner_img.getWeight();
        String jump_url = wx_banner_img.getJump_url();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("bi_id",bi_id);
        _ret.put("img_name",img_name);
        _ret.put("img_url",img_url);
        _ret.put("img_intro",img_intro);
        _ret.put("ctime",ctime);
        _ret.put("note",note);
        _ret.put("weight",weight);
        _ret.put("jump_url",jump_url);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Wx_banner_img clone2(){
        try{
            return (Wx_banner_img) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
