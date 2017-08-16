package com.pyb.bean;

import java.io.*;
import java.util.*;

//wp_posts
@SuppressWarnings({"serial"})
public class Wp_posts implements Cloneable , Serializable{

    //public static String[] carrays ={"ID","post_author","post_date","post_date_gmt","post_content","post_title","post_excerpt","post_status","comment_status","ping_status","post_password","post_name","to_ping","pinged","post_modified","post_modified_gmt","post_content_filtered","post_parent","guid","menu_order","post_type","post_mime_type","comment_count"};

    public long ID;//bigint(20) unsigned    
    public long post_author;//bigint(20) unsigned    
    public java.util.Date post_date=new java.util.Date();//datetime    
    public java.util.Date post_date_gmt=new java.util.Date();//datetime    
    public String post_content="";//longtext    
    public String post_title="";//text    
    public String post_excerpt="";//text    
    public String post_status="";//varchar(20)    
    public String comment_status="";//varchar(20)    
    public String ping_status="";//varchar(20)    
    public String post_password="";//varchar(255)    
    public String post_name="";//varchar(200)    
    public String to_ping="";//text    
    public String pinged="";//text    
    public java.util.Date post_modified=new java.util.Date();//datetime    
    public java.util.Date post_modified_gmt=new java.util.Date();//datetime    
    public String post_content_filtered="";//longtext    
    public long post_parent;//bigint(20) unsigned    
    public String guid="";//varchar(255)    
    public int menu_order;//int(11)    
    public String post_type="";//varchar(20)    
    public String post_mime_type="";//varchar(100)    
    public long comment_count;//bigint(20)    



    public long getID(){
        return ID;
    }

    public void setID(long value){
        this.ID= value;
    }

    public long getPost_author(){
        return post_author;
    }

    public void setPost_author(long value){
        this.post_author= value;
    }

    public java.util.Date getPost_date(){
        return post_date;
    }

    public void setPost_date(java.util.Date value){
    	if(value == null){
           value = new java.util.Date();
        }
        this.post_date= value;
    }

    public java.util.Date getPost_date_gmt(){
        return post_date_gmt;
    }

    public void setPost_date_gmt(java.util.Date value){
    	if(value == null){
           value = new java.util.Date();
        }
        this.post_date_gmt= value;
    }

    public String getPost_content(){
        return post_content;
    }

    public void setPost_content(String value){
    	if(value == null){
           value = "";
        }
        this.post_content= value;
    }

    public String getPost_title(){
        return post_title;
    }

    public void setPost_title(String value){
    	if(value == null){
           value = "";
        }
        this.post_title= value;
    }

    public String getPost_excerpt(){
        return post_excerpt;
    }

    public void setPost_excerpt(String value){
    	if(value == null){
           value = "";
        }
        this.post_excerpt= value;
    }

    public String getPost_status(){
        return post_status;
    }

    public void setPost_status(String value){
    	if(value == null){
           value = "";
        }
        this.post_status= value;
    }

    public String getComment_status(){
        return comment_status;
    }

    public void setComment_status(String value){
    	if(value == null){
           value = "";
        }
        this.comment_status= value;
    }

    public String getPing_status(){
        return ping_status;
    }

    public void setPing_status(String value){
    	if(value == null){
           value = "";
        }
        this.ping_status= value;
    }

    public String getPost_password(){
        return post_password;
    }

    public void setPost_password(String value){
    	if(value == null){
           value = "";
        }
        this.post_password= value;
    }

    public String getPost_name(){
        return post_name;
    }

    public void setPost_name(String value){
    	if(value == null){
           value = "";
        }
        this.post_name= value;
    }

    public String getTo_ping(){
        return to_ping;
    }

    public void setTo_ping(String value){
    	if(value == null){
           value = "";
        }
        this.to_ping= value;
    }

    public String getPinged(){
        return pinged;
    }

    public void setPinged(String value){
    	if(value == null){
           value = "";
        }
        this.pinged= value;
    }

    public java.util.Date getPost_modified(){
        return post_modified;
    }

    public void setPost_modified(java.util.Date value){
    	if(value == null){
           value = new java.util.Date();
        }
        this.post_modified= value;
    }

    public java.util.Date getPost_modified_gmt(){
        return post_modified_gmt;
    }

    public void setPost_modified_gmt(java.util.Date value){
    	if(value == null){
           value = new java.util.Date();
        }
        this.post_modified_gmt= value;
    }

    public String getPost_content_filtered(){
        return post_content_filtered;
    }

    public void setPost_content_filtered(String value){
    	if(value == null){
           value = "";
        }
        this.post_content_filtered= value;
    }

    public long getPost_parent(){
        return post_parent;
    }

    public void setPost_parent(long value){
        this.post_parent= value;
    }

    public String getGuid(){
        return guid;
    }

    public void setGuid(String value){
    	if(value == null){
           value = "";
        }
        this.guid= value;
    }

    public int getMenu_order(){
        return menu_order;
    }

    public void setMenu_order(int value){
        this.menu_order= value;
    }

    public String getPost_type(){
        return post_type;
    }

    public void setPost_type(String value){
    	if(value == null){
           value = "";
        }
        this.post_type= value;
    }

    public String getPost_mime_type(){
        return post_mime_type;
    }

    public void setPost_mime_type(String value){
    	if(value == null){
           value = "";
        }
        this.post_mime_type= value;
    }

    public long getComment_count(){
        return comment_count;
    }

    public void setComment_count(long value){
        this.comment_count= value;
    }



    public static Wp_posts newWp_posts(long ID, long post_author, java.util.Date post_date, java.util.Date post_date_gmt, String post_content, String post_title, String post_excerpt, String post_status, String comment_status, String ping_status, String post_password, String post_name, String to_ping, String pinged, java.util.Date post_modified, java.util.Date post_modified_gmt, String post_content_filtered, long post_parent, String guid, int menu_order, String post_type, String post_mime_type, long comment_count) {
        Wp_posts ret = new Wp_posts();
        ret.setID(ID);
        ret.setPost_author(post_author);
        ret.setPost_date(post_date);
        ret.setPost_date_gmt(post_date_gmt);
        ret.setPost_content(post_content);
        ret.setPost_title(post_title);
        ret.setPost_excerpt(post_excerpt);
        ret.setPost_status(post_status);
        ret.setComment_status(comment_status);
        ret.setPing_status(ping_status);
        ret.setPost_password(post_password);
        ret.setPost_name(post_name);
        ret.setTo_ping(to_ping);
        ret.setPinged(pinged);
        ret.setPost_modified(post_modified);
        ret.setPost_modified_gmt(post_modified_gmt);
        ret.setPost_content_filtered(post_content_filtered);
        ret.setPost_parent(post_parent);
        ret.setGuid(guid);
        ret.setMenu_order(menu_order);
        ret.setPost_type(post_type);
        ret.setPost_mime_type(post_mime_type);
        ret.setComment_count(comment_count);
        return ret;    
    }

    public void assignment(Wp_posts wp_posts) {
        long ID = wp_posts.getID();
        long post_author = wp_posts.getPost_author();
        java.util.Date post_date = wp_posts.getPost_date();
        java.util.Date post_date_gmt = wp_posts.getPost_date_gmt();
        String post_content = wp_posts.getPost_content();
        String post_title = wp_posts.getPost_title();
        String post_excerpt = wp_posts.getPost_excerpt();
        String post_status = wp_posts.getPost_status();
        String comment_status = wp_posts.getComment_status();
        String ping_status = wp_posts.getPing_status();
        String post_password = wp_posts.getPost_password();
        String post_name = wp_posts.getPost_name();
        String to_ping = wp_posts.getTo_ping();
        String pinged = wp_posts.getPinged();
        java.util.Date post_modified = wp_posts.getPost_modified();
        java.util.Date post_modified_gmt = wp_posts.getPost_modified_gmt();
        String post_content_filtered = wp_posts.getPost_content_filtered();
        long post_parent = wp_posts.getPost_parent();
        String guid = wp_posts.getGuid();
        int menu_order = wp_posts.getMenu_order();
        String post_type = wp_posts.getPost_type();
        String post_mime_type = wp_posts.getPost_mime_type();
        long comment_count = wp_posts.getComment_count();

        this.setID(ID);
        this.setPost_author(post_author);
        this.setPost_date(post_date);
        this.setPost_date_gmt(post_date_gmt);
        this.setPost_content(post_content);
        this.setPost_title(post_title);
        this.setPost_excerpt(post_excerpt);
        this.setPost_status(post_status);
        this.setComment_status(comment_status);
        this.setPing_status(ping_status);
        this.setPost_password(post_password);
        this.setPost_name(post_name);
        this.setTo_ping(to_ping);
        this.setPinged(pinged);
        this.setPost_modified(post_modified);
        this.setPost_modified_gmt(post_modified_gmt);
        this.setPost_content_filtered(post_content_filtered);
        this.setPost_parent(post_parent);
        this.setGuid(guid);
        this.setMenu_order(menu_order);
        this.setPost_type(post_type);
        this.setPost_mime_type(post_mime_type);
        this.setComment_count(comment_count);

    }

    @SuppressWarnings("unused")
    public static void getWp_posts(Wp_posts wp_posts ){
        long ID = wp_posts.getID();
        long post_author = wp_posts.getPost_author();
        java.util.Date post_date = wp_posts.getPost_date();
        java.util.Date post_date_gmt = wp_posts.getPost_date_gmt();
        String post_content = wp_posts.getPost_content();
        String post_title = wp_posts.getPost_title();
        String post_excerpt = wp_posts.getPost_excerpt();
        String post_status = wp_posts.getPost_status();
        String comment_status = wp_posts.getComment_status();
        String ping_status = wp_posts.getPing_status();
        String post_password = wp_posts.getPost_password();
        String post_name = wp_posts.getPost_name();
        String to_ping = wp_posts.getTo_ping();
        String pinged = wp_posts.getPinged();
        java.util.Date post_modified = wp_posts.getPost_modified();
        java.util.Date post_modified_gmt = wp_posts.getPost_modified_gmt();
        String post_content_filtered = wp_posts.getPost_content_filtered();
        long post_parent = wp_posts.getPost_parent();
        String guid = wp_posts.getGuid();
        int menu_order = wp_posts.getMenu_order();
        String post_type = wp_posts.getPost_type();
        String post_mime_type = wp_posts.getPost_mime_type();
        long comment_count = wp_posts.getComment_count();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(Wp_posts wp_posts){
        long ID = wp_posts.getID();
        long post_author = wp_posts.getPost_author();
        java.util.Date post_date = wp_posts.getPost_date();
        java.util.Date post_date_gmt = wp_posts.getPost_date_gmt();
        String post_content = wp_posts.getPost_content();
        String post_title = wp_posts.getPost_title();
        String post_excerpt = wp_posts.getPost_excerpt();
        String post_status = wp_posts.getPost_status();
        String comment_status = wp_posts.getComment_status();
        String ping_status = wp_posts.getPing_status();
        String post_password = wp_posts.getPost_password();
        String post_name = wp_posts.getPost_name();
        String to_ping = wp_posts.getTo_ping();
        String pinged = wp_posts.getPinged();
        java.util.Date post_modified = wp_posts.getPost_modified();
        java.util.Date post_modified_gmt = wp_posts.getPost_modified_gmt();
        String post_content_filtered = wp_posts.getPost_content_filtered();
        long post_parent = wp_posts.getPost_parent();
        String guid = wp_posts.getGuid();
        int menu_order = wp_posts.getMenu_order();
        String post_type = wp_posts.getPost_type();
        String post_mime_type = wp_posts.getPost_mime_type();
        long comment_count = wp_posts.getComment_count();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("ID",ID);
        _ret.put("post_author",post_author);
        _ret.put("post_date",post_date);
        _ret.put("post_date_gmt",post_date_gmt);
        _ret.put("post_content",post_content);
        _ret.put("post_title",post_title);
        _ret.put("post_excerpt",post_excerpt);
        _ret.put("post_status",post_status);
        _ret.put("comment_status",comment_status);
        _ret.put("ping_status",ping_status);
        _ret.put("post_password",post_password);
        _ret.put("post_name",post_name);
        _ret.put("to_ping",to_ping);
        _ret.put("pinged",pinged);
        _ret.put("post_modified",post_modified);
        _ret.put("post_modified_gmt",post_modified_gmt);
        _ret.put("post_content_filtered",post_content_filtered);
        _ret.put("post_parent",post_parent);
        _ret.put("guid",guid);
        _ret.put("menu_order",menu_order);
        _ret.put("post_type",post_type);
        _ret.put("post_mime_type",post_mime_type);
        _ret.put("comment_count",comment_count);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Wp_posts clone2(){
        try{
            return (Wp_posts) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
