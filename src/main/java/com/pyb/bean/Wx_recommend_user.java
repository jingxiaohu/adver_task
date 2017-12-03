package com.pyb.bean;

import java.io.*;
import java.util.*;

//wx_recommend_user
@SuppressWarnings({"serial"})
public class Wx_recommend_user implements Cloneable , Serializable{

    //public static String[] carrays ={"ru_id","recommend_id","recommended_id","recommended_nickname","avatar","money","ctime","is_del","note"};

    public long ru_id;//bigint(20)    主键ID
    public long recommend_id;//bigint(20)    推荐人用户ID
    public long recommended_id;//bigint(20)    被推荐人用户ID
    public String recommended_nickname="";//varchar(60)    被推荐人用户昵称
    public String avatar="";//varchar(200)    被推荐人头像
    public int money;//int(11)    被推荐人贡献给推荐人收益单位分
    public java.util.Date ctime=new java.util.Date();//timestamp    创建时间
    public int is_del;//int(11)    是否逻辑删除0：不1：是
    public String note="";//varchar(60)    备注



    public long getRu_id(){
        return ru_id;
    }

    public void setRu_id(long value){
        this.ru_id= value;
    }

    public long getRecommend_id(){
        return recommend_id;
    }

    public void setRecommend_id(long value){
        this.recommend_id= value;
    }

    public long getRecommended_id(){
        return recommended_id;
    }

    public void setRecommended_id(long value){
        this.recommended_id= value;
    }

    public String getRecommended_nickname(){
        return recommended_nickname;
    }

    public void setRecommended_nickname(String value){
    	if(value == null){
           value = "";
        }
        this.recommended_nickname= value;
    }

    public String getAvatar(){
        return avatar;
    }

    public void setAvatar(String value){
    	if(value == null){
           value = "";
        }
        this.avatar= value;
    }

    public int getMoney(){
        return money;
    }

    public void setMoney(int value){
        this.money= value;
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

    public int getIs_del(){
        return is_del;
    }

    public void setIs_del(int value){
        this.is_del= value;
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



    public static Wx_recommend_user newWx_recommend_user(long ru_id, long recommend_id, long recommended_id, String recommended_nickname, String avatar, int money, java.util.Date ctime, int is_del, String note) {
        Wx_recommend_user ret = new Wx_recommend_user();
        ret.setRu_id(ru_id);
        ret.setRecommend_id(recommend_id);
        ret.setRecommended_id(recommended_id);
        ret.setRecommended_nickname(recommended_nickname);
        ret.setAvatar(avatar);
        ret.setMoney(money);
        ret.setCtime(ctime);
        ret.setIs_del(is_del);
        ret.setNote(note);
        return ret;    
    }

    public void assignment(Wx_recommend_user wx_recommend_user) {
        long ru_id = wx_recommend_user.getRu_id();
        long recommend_id = wx_recommend_user.getRecommend_id();
        long recommended_id = wx_recommend_user.getRecommended_id();
        String recommended_nickname = wx_recommend_user.getRecommended_nickname();
        String avatar = wx_recommend_user.getAvatar();
        int money = wx_recommend_user.getMoney();
        java.util.Date ctime = wx_recommend_user.getCtime();
        int is_del = wx_recommend_user.getIs_del();
        String note = wx_recommend_user.getNote();

        this.setRu_id(ru_id);
        this.setRecommend_id(recommend_id);
        this.setRecommended_id(recommended_id);
        this.setRecommended_nickname(recommended_nickname);
        this.setAvatar(avatar);
        this.setMoney(money);
        this.setCtime(ctime);
        this.setIs_del(is_del);
        this.setNote(note);

    }

    @SuppressWarnings("unused")
    public static void getWx_recommend_user(Wx_recommend_user wx_recommend_user ){
        long ru_id = wx_recommend_user.getRu_id();
        long recommend_id = wx_recommend_user.getRecommend_id();
        long recommended_id = wx_recommend_user.getRecommended_id();
        String recommended_nickname = wx_recommend_user.getRecommended_nickname();
        String avatar = wx_recommend_user.getAvatar();
        int money = wx_recommend_user.getMoney();
        java.util.Date ctime = wx_recommend_user.getCtime();
        int is_del = wx_recommend_user.getIs_del();
        String note = wx_recommend_user.getNote();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(Wx_recommend_user wx_recommend_user){
        long ru_id = wx_recommend_user.getRu_id();
        long recommend_id = wx_recommend_user.getRecommend_id();
        long recommended_id = wx_recommend_user.getRecommended_id();
        String recommended_nickname = wx_recommend_user.getRecommended_nickname();
        String avatar = wx_recommend_user.getAvatar();
        int money = wx_recommend_user.getMoney();
        java.util.Date ctime = wx_recommend_user.getCtime();
        int is_del = wx_recommend_user.getIs_del();
        String note = wx_recommend_user.getNote();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("ru_id",ru_id);
        _ret.put("recommend_id",recommend_id);
        _ret.put("recommended_id",recommended_id);
        _ret.put("recommended_nickname",recommended_nickname);
        _ret.put("avatar",avatar);
        _ret.put("money",money);
        _ret.put("ctime",ctime);
        _ret.put("is_del",is_del);
        _ret.put("note",note);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Wx_recommend_user clone2(){
        try{
            return (Wx_recommend_user) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
