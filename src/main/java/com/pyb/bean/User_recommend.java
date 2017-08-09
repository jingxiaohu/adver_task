package com.pyb.bean;

import java.io.*;
import java.util.*;

//user_recommend
@SuppressWarnings({"serial"})
public class User_recommend implements Cloneable , Serializable{

    //public static String[] carrays ={"ur_id","ur_time","ur_time_str","ui_id","ur_friend_id","ur_desc"};

    public long ur_id;//bigint(20)    
    public long ur_time;//bigint(20)    
    public String ur_time_str="";//varchar(60)    
    public long ui_id;//bigint(20)    
    public long ur_friend_id;//bigint(20)    
    public String ur_desc="";//varchar(100)    



    public long getUr_id(){
        return ur_id;
    }

    public void setUr_id(long value){
        this.ur_id= value;
    }

    public long getUr_time(){
        return ur_time;
    }

    public void setUr_time(long value){
        this.ur_time= value;
    }

    public String getUr_time_str(){
        return ur_time_str;
    }

    public void setUr_time_str(String value){
    	if(value == null){
           value = "";
        }
        this.ur_time_str= value;
    }

    public long getUi_id(){
        return ui_id;
    }

    public void setUi_id(long value){
        this.ui_id= value;
    }

    public long getUr_friend_id(){
        return ur_friend_id;
    }

    public void setUr_friend_id(long value){
        this.ur_friend_id= value;
    }

    public String getUr_desc(){
        return ur_desc;
    }

    public void setUr_desc(String value){
    	if(value == null){
           value = "";
        }
        this.ur_desc= value;
    }



    public static User_recommend newUser_recommend(long ur_id, long ur_time, String ur_time_str, long ui_id, long ur_friend_id, String ur_desc) {
        User_recommend ret = new User_recommend();
        ret.setUr_id(ur_id);
        ret.setUr_time(ur_time);
        ret.setUr_time_str(ur_time_str);
        ret.setUi_id(ui_id);
        ret.setUr_friend_id(ur_friend_id);
        ret.setUr_desc(ur_desc);
        return ret;    
    }

    public void assignment(User_recommend user_recommend) {
        long ur_id = user_recommend.getUr_id();
        long ur_time = user_recommend.getUr_time();
        String ur_time_str = user_recommend.getUr_time_str();
        long ui_id = user_recommend.getUi_id();
        long ur_friend_id = user_recommend.getUr_friend_id();
        String ur_desc = user_recommend.getUr_desc();

        this.setUr_id(ur_id);
        this.setUr_time(ur_time);
        this.setUr_time_str(ur_time_str);
        this.setUi_id(ui_id);
        this.setUr_friend_id(ur_friend_id);
        this.setUr_desc(ur_desc);

    }

    @SuppressWarnings("unused")
    public static void getUser_recommend(User_recommend user_recommend ){
        long ur_id = user_recommend.getUr_id();
        long ur_time = user_recommend.getUr_time();
        String ur_time_str = user_recommend.getUr_time_str();
        long ui_id = user_recommend.getUi_id();
        long ur_friend_id = user_recommend.getUr_friend_id();
        String ur_desc = user_recommend.getUr_desc();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(User_recommend user_recommend){
        long ur_id = user_recommend.getUr_id();
        long ur_time = user_recommend.getUr_time();
        String ur_time_str = user_recommend.getUr_time_str();
        long ui_id = user_recommend.getUi_id();
        long ur_friend_id = user_recommend.getUr_friend_id();
        String ur_desc = user_recommend.getUr_desc();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("ur_id",ur_id);
        _ret.put("ur_time",ur_time);
        _ret.put("ur_time_str",ur_time_str);
        _ret.put("ui_id",ui_id);
        _ret.put("ur_friend_id",ur_friend_id);
        _ret.put("ur_desc",ur_desc);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public User_recommend clone2(){
        try{
            return (User_recommend) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
