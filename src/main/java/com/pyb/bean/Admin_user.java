package com.pyb.bean;

import java.io.*;
import java.util.*;

//admin_user
@SuppressWarnings({"serial"})
public class Admin_user implements Cloneable , Serializable{

    //public static String[] carrays ={"au_id","au_nickname","au_loginname","au_password","au_state"};

    public long au_id;//bigint(20)    
    public String au_nickname="";//varchar(20)    
    public String au_loginname="";//varchar(30)    目标对象关联user_info表里面的用户uuid
    public String au_password="";//varchar(50)    信息创建时间
    public int au_state;//int(11)    



    public long getAu_id(){
        return au_id;
    }

    public void setAu_id(long value){
        this.au_id= value;
    }

    public String getAu_nickname(){
        return au_nickname;
    }

    public void setAu_nickname(String value){
    	if(value == null){
           value = "";
        }
        this.au_nickname= value;
    }

    public String getAu_loginname(){
        return au_loginname;
    }

    public void setAu_loginname(String value){
    	if(value == null){
           value = "";
        }
        this.au_loginname= value;
    }

    public String getAu_password(){
        return au_password;
    }

    public void setAu_password(String value){
    	if(value == null){
           value = "";
        }
        this.au_password= value;
    }

    public int getAu_state(){
        return au_state;
    }

    public void setAu_state(int value){
        this.au_state= value;
    }



    public static Admin_user newAdmin_user(long au_id, String au_nickname, String au_loginname, String au_password, int au_state) {
        Admin_user ret = new Admin_user();
        ret.setAu_id(au_id);
        ret.setAu_nickname(au_nickname);
        ret.setAu_loginname(au_loginname);
        ret.setAu_password(au_password);
        ret.setAu_state(au_state);
        return ret;    
    }

    public void assignment(Admin_user admin_user) {
        long au_id = admin_user.getAu_id();
        String au_nickname = admin_user.getAu_nickname();
        String au_loginname = admin_user.getAu_loginname();
        String au_password = admin_user.getAu_password();
        int au_state = admin_user.getAu_state();

        this.setAu_id(au_id);
        this.setAu_nickname(au_nickname);
        this.setAu_loginname(au_loginname);
        this.setAu_password(au_password);
        this.setAu_state(au_state);

    }

    @SuppressWarnings("unused")
    public static void getAdmin_user(Admin_user admin_user ){
        long au_id = admin_user.getAu_id();
        String au_nickname = admin_user.getAu_nickname();
        String au_loginname = admin_user.getAu_loginname();
        String au_password = admin_user.getAu_password();
        int au_state = admin_user.getAu_state();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(Admin_user admin_user){
        long au_id = admin_user.getAu_id();
        String au_nickname = admin_user.getAu_nickname();
        String au_loginname = admin_user.getAu_loginname();
        String au_password = admin_user.getAu_password();
        int au_state = admin_user.getAu_state();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("au_id",au_id);
        _ret.put("au_nickname",au_nickname);
        _ret.put("au_loginname",au_loginname);
        _ret.put("au_password",au_password);
        _ret.put("au_state",au_state);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Admin_user clone2(){
        try{
            return (Admin_user) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
