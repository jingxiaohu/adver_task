package com.pyb.bean;

import java.io.*;
import java.util.*;

//day_news
@SuppressWarnings({"serial"})
public class Day_news implements Cloneable , Serializable{

    //public static String[] carrays ={"dn_id","title","content_or_url","bk_type","is_show","ctime","read_count","bk_zan","bk_sort","note","source_name","md5","type"};

    public long dn_id;//bigint(20)    
    public String title="";//varchar(255)    标题
    public String content_or_url="";//text    内容或者URL
    public int bk_type;//int(11)    类型（0：自己写的内容1：页面）
    public int is_show;//int(11)    是否显示（0：显示1：不显示）
    public java.util.Date ctime=new java.util.Date();//datetime    创建时间
    public long read_count;//bigint(20)    浏览次数
    public long bk_zan;//bigint(20)    点赞次数
    public long bk_sort;//bigint(20)    权重比
    public String note="";//varchar(255)    备注.
    public String source_name="";//varchar(200)    来源名称
    public String md5="";//varchar(100)    md5
    public int type;//int(11)    所属板块类型(例如：个股评级)0:看盘消息1：个股评级2：机构解析3：板块解析4：市场研究5：行业研究6：数据资金



    public long getDn_id(){
        return dn_id;
    }

    public void setDn_id(long value){
        this.dn_id= value;
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

    public String getContent_or_url(){
        return content_or_url;
    }

    public void setContent_or_url(String value){
    	if(value == null){
           value = "";
        }
        this.content_or_url= value;
    }

    public int getBk_type(){
        return bk_type;
    }

    public void setBk_type(int value){
        this.bk_type= value;
    }

    public int getIs_show(){
        return is_show;
    }

    public void setIs_show(int value){
        this.is_show= value;
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

    public long getRead_count(){
        return read_count;
    }

    public void setRead_count(long value){
        this.read_count= value;
    }

    public long getBk_zan(){
        return bk_zan;
    }

    public void setBk_zan(long value){
        this.bk_zan= value;
    }

    public long getBk_sort(){
        return bk_sort;
    }

    public void setBk_sort(long value){
        this.bk_sort= value;
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

    public String getSource_name(){
        return source_name;
    }

    public void setSource_name(String value){
    	if(value == null){
           value = "";
        }
        this.source_name= value;
    }

    public String getMd5(){
        return md5;
    }

    public void setMd5(String value){
    	if(value == null){
           value = "";
        }
        this.md5= value;
    }

    public int getType(){
        return type;
    }

    public void setType(int value){
        this.type= value;
    }



    public static Day_news newDay_news(long dn_id, String title, String content_or_url, int bk_type, int is_show, java.util.Date ctime, long read_count, long bk_zan, long bk_sort, String note, String source_name, String md5, int type) {
        Day_news ret = new Day_news();
        ret.setDn_id(dn_id);
        ret.setTitle(title);
        ret.setContent_or_url(content_or_url);
        ret.setBk_type(bk_type);
        ret.setIs_show(is_show);
        ret.setCtime(ctime);
        ret.setRead_count(read_count);
        ret.setBk_zan(bk_zan);
        ret.setBk_sort(bk_sort);
        ret.setNote(note);
        ret.setSource_name(source_name);
        ret.setMd5(md5);
        ret.setType(type);
        return ret;    
    }

    public void assignment(Day_news day_news) {
        long dn_id = day_news.getDn_id();
        String title = day_news.getTitle();
        String content_or_url = day_news.getContent_or_url();
        int bk_type = day_news.getBk_type();
        int is_show = day_news.getIs_show();
        java.util.Date ctime = day_news.getCtime();
        long read_count = day_news.getRead_count();
        long bk_zan = day_news.getBk_zan();
        long bk_sort = day_news.getBk_sort();
        String note = day_news.getNote();
        String source_name = day_news.getSource_name();
        String md5 = day_news.getMd5();
        int type = day_news.getType();

        this.setDn_id(dn_id);
        this.setTitle(title);
        this.setContent_or_url(content_or_url);
        this.setBk_type(bk_type);
        this.setIs_show(is_show);
        this.setCtime(ctime);
        this.setRead_count(read_count);
        this.setBk_zan(bk_zan);
        this.setBk_sort(bk_sort);
        this.setNote(note);
        this.setSource_name(source_name);
        this.setMd5(md5);
        this.setType(type);

    }

    @SuppressWarnings("unused")
    public static void getDay_news(Day_news day_news ){
        long dn_id = day_news.getDn_id();
        String title = day_news.getTitle();
        String content_or_url = day_news.getContent_or_url();
        int bk_type = day_news.getBk_type();
        int is_show = day_news.getIs_show();
        java.util.Date ctime = day_news.getCtime();
        long read_count = day_news.getRead_count();
        long bk_zan = day_news.getBk_zan();
        long bk_sort = day_news.getBk_sort();
        String note = day_news.getNote();
        String source_name = day_news.getSource_name();
        String md5 = day_news.getMd5();
        int type = day_news.getType();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(Day_news day_news){
        long dn_id = day_news.getDn_id();
        String title = day_news.getTitle();
        String content_or_url = day_news.getContent_or_url();
        int bk_type = day_news.getBk_type();
        int is_show = day_news.getIs_show();
        java.util.Date ctime = day_news.getCtime();
        long read_count = day_news.getRead_count();
        long bk_zan = day_news.getBk_zan();
        long bk_sort = day_news.getBk_sort();
        String note = day_news.getNote();
        String source_name = day_news.getSource_name();
        String md5 = day_news.getMd5();
        int type = day_news.getType();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("dn_id",dn_id);
        _ret.put("title",title);
        _ret.put("content_or_url",content_or_url);
        _ret.put("bk_type",bk_type);
        _ret.put("is_show",is_show);
        _ret.put("ctime",ctime);
        _ret.put("read_count",read_count);
        _ret.put("bk_zan",bk_zan);
        _ret.put("bk_sort",bk_sort);
        _ret.put("note",note);
        _ret.put("source_name",source_name);
        _ret.put("md5",md5);
        _ret.put("type",type);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Day_news clone2(){
        try{
            return (Day_news) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
