package com.pyb.bean;

import java.io.*;
import java.util.*;

//wx_goods_details
@SuppressWarnings({"serial"})
public class Wx_goods_details implements Cloneable , Serializable{

    //public static String[] carrays ={"gd_id","g_id","goods_desc","img_urls","ctime","utime","note","is_del"};

    public long gd_id;//bigint(20)    主键ID
    public long g_id;//bigint(20)    商品表主键ID
    public String goods_desc="";//text    详情介绍
    public String img_urls="";//varchar(800)    详情图片URL逗号分割
    public java.util.Date ctime=new java.util.Date();//timestamp    创建时间
    public java.util.Date utime=new java.util.Date();//timestamp    更新时间
    public String note="";//varchar(60)    备注
    public int is_del;//int(11)    是否逻辑删除:0：不删除1：删除



    public long getGd_id(){
        return gd_id;
    }

    public void setGd_id(long value){
        this.gd_id= value;
    }

    public long getG_id(){
        return g_id;
    }

    public void setG_id(long value){
        this.g_id= value;
    }

    public String getGoods_desc(){
        return goods_desc;
    }

    public void setGoods_desc(String value){
    	if(value == null){
           value = "";
        }
        this.goods_desc= value;
    }

    public String getImg_urls(){
        return img_urls;
    }

    public void setImg_urls(String value){
    	if(value == null){
           value = "";
        }
        this.img_urls= value;
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

    public java.util.Date getUtime(){
        return utime;
    }

    public void setUtime(java.util.Date value){
    	if(value == null){
           value = new java.util.Date();
        }
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

    public int getIs_del(){
        return is_del;
    }

    public void setIs_del(int value){
        this.is_del= value;
    }



    public static Wx_goods_details newWx_goods_details(long gd_id, long g_id, String goods_desc, String img_urls, java.util.Date ctime, java.util.Date utime, String note, int is_del) {
        Wx_goods_details ret = new Wx_goods_details();
        ret.setGd_id(gd_id);
        ret.setG_id(g_id);
        ret.setGoods_desc(goods_desc);
        ret.setImg_urls(img_urls);
        ret.setCtime(ctime);
        ret.setUtime(utime);
        ret.setNote(note);
        ret.setIs_del(is_del);
        return ret;    
    }

    public void assignment(Wx_goods_details wx_goods_details) {
        long gd_id = wx_goods_details.getGd_id();
        long g_id = wx_goods_details.getG_id();
        String goods_desc = wx_goods_details.getGoods_desc();
        String img_urls = wx_goods_details.getImg_urls();
        java.util.Date ctime = wx_goods_details.getCtime();
        java.util.Date utime = wx_goods_details.getUtime();
        String note = wx_goods_details.getNote();
        int is_del = wx_goods_details.getIs_del();

        this.setGd_id(gd_id);
        this.setG_id(g_id);
        this.setGoods_desc(goods_desc);
        this.setImg_urls(img_urls);
        this.setCtime(ctime);
        this.setUtime(utime);
        this.setNote(note);
        this.setIs_del(is_del);

    }

    @SuppressWarnings("unused")
    public static void getWx_goods_details(Wx_goods_details wx_goods_details ){
        long gd_id = wx_goods_details.getGd_id();
        long g_id = wx_goods_details.getG_id();
        String goods_desc = wx_goods_details.getGoods_desc();
        String img_urls = wx_goods_details.getImg_urls();
        java.util.Date ctime = wx_goods_details.getCtime();
        java.util.Date utime = wx_goods_details.getUtime();
        String note = wx_goods_details.getNote();
        int is_del = wx_goods_details.getIs_del();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(Wx_goods_details wx_goods_details){
        long gd_id = wx_goods_details.getGd_id();
        long g_id = wx_goods_details.getG_id();
        String goods_desc = wx_goods_details.getGoods_desc();
        String img_urls = wx_goods_details.getImg_urls();
        java.util.Date ctime = wx_goods_details.getCtime();
        java.util.Date utime = wx_goods_details.getUtime();
        String note = wx_goods_details.getNote();
        int is_del = wx_goods_details.getIs_del();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("gd_id",gd_id);
        _ret.put("g_id",g_id);
        _ret.put("goods_desc",goods_desc);
        _ret.put("img_urls",img_urls);
        _ret.put("ctime",ctime);
        _ret.put("utime",utime);
        _ret.put("note",note);
        _ret.put("is_del",is_del);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Wx_goods_details clone2(){
        try{
            return (Wx_goods_details) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
