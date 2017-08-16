package com.pyb.bean;

import java.io.*;
import java.util.*;

//wp_post_jxh
@SuppressWarnings({"serial"})
public class Wp_post_jxh implements Cloneable , Serializable{

    //public static String[] carrays ={"id","post_id","category_id","category_code","url","title","date_time","url_status","content","father_url"};

    public long id;//bigint(11) unsigned    
    public long post_id;//bigint(11) unsigned    
    public long category_id;//bigint(11) unsigned    
    public String category_code="";//varchar(60)    分类英文代码
    public String url="";//varchar(1000)    
    public String title="";//varchar(255)    标题
    public java.util.Date date_time=new java.util.Date();//datetime    时间
    public int url_status;//int(11)    发布状态0：还没有发布1：已经发布2：删除
    public String content="";//longtext    内容
    public String father_url="";//varchar(1000)    上级的URL



    public long getId(){
        return id;
    }

    public void setId(long value){
        this.id= value;
    }

    public long getPost_id(){
        return post_id;
    }

    public void setPost_id(long value){
        this.post_id= value;
    }

    public long getCategory_id(){
        return category_id;
    }

    public void setCategory_id(long value){
        this.category_id= value;
    }

    public String getCategory_code(){
        return category_code;
    }

    public void setCategory_code(String value){
    	if(value == null){
           value = "";
        }
        this.category_code= value;
    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String value){
    	if(value == null){
           value = "";
        }
        this.url= value;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String value){
    	if(value == null){
           value = "";
        }
        this.title= value;
    }

    public java.util.Date getDate_time(){
        return date_time;
    }

    public void setDate_time(java.util.Date value){
    	if(value == null){
           value = new java.util.Date();
        }
        this.date_time= value;
    }

    public int getUrl_status(){
        return url_status;
    }

    public void setUrl_status(int value){
        this.url_status= value;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String value){
    	if(value == null){
           value = "";
        }
        this.content= value;
    }

    public String getFather_url(){
        return father_url;
    }

    public void setFather_url(String value){
    	if(value == null){
           value = "";
        }
        this.father_url= value;
    }



    public static Wp_post_jxh newWp_post_jxh(long id, long post_id, long category_id, String category_code, String url, String title, java.util.Date date_time, int url_status, String content, String father_url) {
        Wp_post_jxh ret = new Wp_post_jxh();
        ret.setId(id);
        ret.setPost_id(post_id);
        ret.setCategory_id(category_id);
        ret.setCategory_code(category_code);
        ret.setUrl(url);
        ret.setTitle(title);
        ret.setDate_time(date_time);
        ret.setUrl_status(url_status);
        ret.setContent(content);
        ret.setFather_url(father_url);
        return ret;    
    }

    public void assignment(Wp_post_jxh wp_post_jxh) {
        long id = wp_post_jxh.getId();
        long post_id = wp_post_jxh.getPost_id();
        long category_id = wp_post_jxh.getCategory_id();
        String category_code = wp_post_jxh.getCategory_code();
        String url = wp_post_jxh.getUrl();
        String title = wp_post_jxh.getTitle();
        java.util.Date date_time = wp_post_jxh.getDate_time();
        int url_status = wp_post_jxh.getUrl_status();
        String content = wp_post_jxh.getContent();
        String father_url = wp_post_jxh.getFather_url();

        this.setId(id);
        this.setPost_id(post_id);
        this.setCategory_id(category_id);
        this.setCategory_code(category_code);
        this.setUrl(url);
        this.setTitle(title);
        this.setDate_time(date_time);
        this.setUrl_status(url_status);
        this.setContent(content);
        this.setFather_url(father_url);

    }

    @SuppressWarnings("unused")
    public static void getWp_post_jxh(Wp_post_jxh wp_post_jxh ){
        long id = wp_post_jxh.getId();
        long post_id = wp_post_jxh.getPost_id();
        long category_id = wp_post_jxh.getCategory_id();
        String category_code = wp_post_jxh.getCategory_code();
        String url = wp_post_jxh.getUrl();
        String title = wp_post_jxh.getTitle();
        java.util.Date date_time = wp_post_jxh.getDate_time();
        int url_status = wp_post_jxh.getUrl_status();
        String content = wp_post_jxh.getContent();
        String father_url = wp_post_jxh.getFather_url();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(Wp_post_jxh wp_post_jxh){
        long id = wp_post_jxh.getId();
        long post_id = wp_post_jxh.getPost_id();
        long category_id = wp_post_jxh.getCategory_id();
        String category_code = wp_post_jxh.getCategory_code();
        String url = wp_post_jxh.getUrl();
        String title = wp_post_jxh.getTitle();
        java.util.Date date_time = wp_post_jxh.getDate_time();
        int url_status = wp_post_jxh.getUrl_status();
        String content = wp_post_jxh.getContent();
        String father_url = wp_post_jxh.getFather_url();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("id",id);
        _ret.put("post_id",post_id);
        _ret.put("category_id",category_id);
        _ret.put("category_code",category_code);
        _ret.put("url",url);
        _ret.put("title",title);
        _ret.put("date_time",date_time);
        _ret.put("url_status",url_status);
        _ret.put("content",content);
        _ret.put("father_url",father_url);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Wp_post_jxh clone2(){
        try{
            return (Wp_post_jxh) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
