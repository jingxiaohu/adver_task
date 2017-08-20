package com.pyb.bean;

import java.io.*;
import java.util.*;

//wp_term_jxh
@SuppressWarnings({"serial"})
public class Wp_term_jxh implements Cloneable , Serializable{

    //public static String[] carrays ={"id","category_id","category_code","name","url","fatherurl","ctime","noe"};

    public long id;//bigint(20)    
    public long category_id;//bigint(20)    分类目录主键ID
    public String category_code="";//varchar(100)    分类代码
    public String name="";//varchar(100)    分类目录的抓取时候名称(标题)
    public String url="";//varchar(255)    分类目录抓取的URL
    public String fatherurl="";//varchar(255)    抓取的上级来源URL
    public java.util.Date ctime=new java.util.Date();//datetime    创建时间
    public String noe="";//varchar(255)    备注



    public long getId(){
        return id;
    }

    public void setId(long value){
        this.id= value;
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

    public String getName(){
        return name;
    }

    public void setName(String value){
    	if(value == null){
           value = "";
        }
        this.name= value;
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

    public String getFatherurl(){
        return fatherurl;
    }

    public void setFatherurl(String value){
    	if(value == null){
           value = "";
        }
        this.fatherurl= value;
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

    public String getNoe(){
        return noe;
    }

    public void setNoe(String value){
    	if(value == null){
           value = "";
        }
        this.noe= value;
    }



    public static Wp_term_jxh newWp_term_jxh(long id, long category_id, String category_code, String name, String url, String fatherurl, java.util.Date ctime, String noe) {
        Wp_term_jxh ret = new Wp_term_jxh();
        ret.setId(id);
        ret.setCategory_id(category_id);
        ret.setCategory_code(category_code);
        ret.setName(name);
        ret.setUrl(url);
        ret.setFatherurl(fatherurl);
        ret.setCtime(ctime);
        ret.setNoe(noe);
        return ret;    
    }

    public void assignment(Wp_term_jxh wp_term_jxh) {
        long id = wp_term_jxh.getId();
        long category_id = wp_term_jxh.getCategory_id();
        String category_code = wp_term_jxh.getCategory_code();
        String name = wp_term_jxh.getName();
        String url = wp_term_jxh.getUrl();
        String fatherurl = wp_term_jxh.getFatherurl();
        java.util.Date ctime = wp_term_jxh.getCtime();
        String noe = wp_term_jxh.getNoe();

        this.setId(id);
        this.setCategory_id(category_id);
        this.setCategory_code(category_code);
        this.setName(name);
        this.setUrl(url);
        this.setFatherurl(fatherurl);
        this.setCtime(ctime);
        this.setNoe(noe);

    }

    @SuppressWarnings("unused")
    public static void getWp_term_jxh(Wp_term_jxh wp_term_jxh ){
        long id = wp_term_jxh.getId();
        long category_id = wp_term_jxh.getCategory_id();
        String category_code = wp_term_jxh.getCategory_code();
        String name = wp_term_jxh.getName();
        String url = wp_term_jxh.getUrl();
        String fatherurl = wp_term_jxh.getFatherurl();
        java.util.Date ctime = wp_term_jxh.getCtime();
        String noe = wp_term_jxh.getNoe();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(Wp_term_jxh wp_term_jxh){
        long id = wp_term_jxh.getId();
        long category_id = wp_term_jxh.getCategory_id();
        String category_code = wp_term_jxh.getCategory_code();
        String name = wp_term_jxh.getName();
        String url = wp_term_jxh.getUrl();
        String fatherurl = wp_term_jxh.getFatherurl();
        java.util.Date ctime = wp_term_jxh.getCtime();
        String noe = wp_term_jxh.getNoe();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("id",id);
        _ret.put("category_id",category_id);
        _ret.put("category_code",category_code);
        _ret.put("name",name);
        _ret.put("url",url);
        _ret.put("fatherurl",fatherurl);
        _ret.put("ctime",ctime);
        _ret.put("noe",noe);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Wp_term_jxh clone2(){
        try{
            return (Wp_term_jxh) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
