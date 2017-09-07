package com.pyb.bean;

import java.io.*;
import java.util.*;

//joke_segment
@SuppressWarnings({"serial"})
public class Joke_segment implements Cloneable , Serializable{

    //public static String[] carrays ={"js_id","jc_id","content","is_show","title","js_type","is_title","is_spider","ctime","js_zan","read_count","note"};

    public long js_id;//bigint(20)    
    public long jc_id;//bigint(20)    笑话分类ID
    public String content="";//text    段子内容
    public int is_show;//int(11)    是否显示(0:显示1：不显示)
    public String title="";//varchar(255)    段子标题
    public int js_type;//int(11)    段子类型(0:爆笑男女1:冷笑话)
    public int is_title;//int(11)    是否有标题(0:没有1：有)
    public int is_spider;//int(11)    是否是抓取的段子(0:抓取1：自己添加)
    public java.util.Date ctime=new java.util.Date();//datetime    创建时间
    public long js_zan;//bigint(20)    点赞数
    public long read_count;//bigint(20)    浏览次数
    public String note="";//varchar(255)    备注



    public long getJs_id(){
        return js_id;
    }

    public void setJs_id(long value){
        this.js_id= value;
    }

    public long getJc_id(){
        return jc_id;
    }

    public void setJc_id(long value){
        this.jc_id= value;
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

    public int getIs_show(){
        return is_show;
    }

    public void setIs_show(int value){
        this.is_show= value;
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

    public int getJs_type(){
        return js_type;
    }

    public void setJs_type(int value){
        this.js_type= value;
    }

    public int getIs_title(){
        return is_title;
    }

    public void setIs_title(int value){
        this.is_title= value;
    }

    public int getIs_spider(){
        return is_spider;
    }

    public void setIs_spider(int value){
        this.is_spider= value;
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

    public long getJs_zan(){
        return js_zan;
    }

    public void setJs_zan(long value){
        this.js_zan= value;
    }

    public long getRead_count(){
        return read_count;
    }

    public void setRead_count(long value){
        this.read_count= value;
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



    public static Joke_segment newJoke_segment(long js_id, long jc_id, String content, int is_show, String title, int js_type, int is_title, int is_spider, java.util.Date ctime, long js_zan, long read_count, String note) {
        Joke_segment ret = new Joke_segment();
        ret.setJs_id(js_id);
        ret.setJc_id(jc_id);
        ret.setContent(content);
        ret.setIs_show(is_show);
        ret.setTitle(title);
        ret.setJs_type(js_type);
        ret.setIs_title(is_title);
        ret.setIs_spider(is_spider);
        ret.setCtime(ctime);
        ret.setJs_zan(js_zan);
        ret.setRead_count(read_count);
        ret.setNote(note);
        return ret;    
    }

    public void assignment(Joke_segment joke_segment) {
        long js_id = joke_segment.getJs_id();
        long jc_id = joke_segment.getJc_id();
        String content = joke_segment.getContent();
        int is_show = joke_segment.getIs_show();
        String title = joke_segment.getTitle();
        int js_type = joke_segment.getJs_type();
        int is_title = joke_segment.getIs_title();
        int is_spider = joke_segment.getIs_spider();
        java.util.Date ctime = joke_segment.getCtime();
        long js_zan = joke_segment.getJs_zan();
        long read_count = joke_segment.getRead_count();
        String note = joke_segment.getNote();

        this.setJs_id(js_id);
        this.setJc_id(jc_id);
        this.setContent(content);
        this.setIs_show(is_show);
        this.setTitle(title);
        this.setJs_type(js_type);
        this.setIs_title(is_title);
        this.setIs_spider(is_spider);
        this.setCtime(ctime);
        this.setJs_zan(js_zan);
        this.setRead_count(read_count);
        this.setNote(note);

    }

    @SuppressWarnings("unused")
    public static void getJoke_segment(Joke_segment joke_segment ){
        long js_id = joke_segment.getJs_id();
        long jc_id = joke_segment.getJc_id();
        String content = joke_segment.getContent();
        int is_show = joke_segment.getIs_show();
        String title = joke_segment.getTitle();
        int js_type = joke_segment.getJs_type();
        int is_title = joke_segment.getIs_title();
        int is_spider = joke_segment.getIs_spider();
        java.util.Date ctime = joke_segment.getCtime();
        long js_zan = joke_segment.getJs_zan();
        long read_count = joke_segment.getRead_count();
        String note = joke_segment.getNote();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(Joke_segment joke_segment){
        long js_id = joke_segment.getJs_id();
        long jc_id = joke_segment.getJc_id();
        String content = joke_segment.getContent();
        int is_show = joke_segment.getIs_show();
        String title = joke_segment.getTitle();
        int js_type = joke_segment.getJs_type();
        int is_title = joke_segment.getIs_title();
        int is_spider = joke_segment.getIs_spider();
        java.util.Date ctime = joke_segment.getCtime();
        long js_zan = joke_segment.getJs_zan();
        long read_count = joke_segment.getRead_count();
        String note = joke_segment.getNote();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("js_id",js_id);
        _ret.put("jc_id",jc_id);
        _ret.put("content",content);
        _ret.put("is_show",is_show);
        _ret.put("title",title);
        _ret.put("js_type",js_type);
        _ret.put("is_title",is_title);
        _ret.put("is_spider",is_spider);
        _ret.put("ctime",ctime);
        _ret.put("js_zan",js_zan);
        _ret.put("read_count",read_count);
        _ret.put("note",note);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Joke_segment clone2(){
        try{
            return (Joke_segment) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
