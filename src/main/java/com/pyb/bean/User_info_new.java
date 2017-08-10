package com.pyb.bean;

import java.io.*;
import java.util.*;

//user_info_new
@SuppressWarnings({"serial"})
public class User_info_new implements Cloneable , Serializable{

    //public static String[] carrays ={"ui_id","ui_nd","ui_token","ui_tel","ui_password","ui_sex","ui_avtar","ui_bind_tel","ui_name","ui_zfb","ui_wx","ui_vc","ui_sign","ui_tj","ui_lock","ctime","utime","note","ui_release","ui_task","is_vip","ui_nickname","ui_flag","ui_email","ui_reg_type"};

    public long ui_id;//bigint(20)    主键ID
    public String ui_nd="";//varchar(80)    用户nd
    public String ui_token="";//varchar(80)    用户登陆token
    public String ui_tel="";//varchar(20)    用户账号（手机号码）
    public String ui_password="";//varchar(65)    用户密码
    public int ui_sex;//int(11)    用户性别0:未知1:男2:女
    public String ui_avtar="";//varchar(255)    用户头像
    public String ui_bind_tel="";//varchar(20)    用户绑定手机号码
    public String ui_name="";//varchar(60)    用户真实姓名
    public String ui_zfb="";//varchar(60)    用户支付宝账号
    public String ui_wx="";//varchar(60)    用户微信账号
    public int ui_vc;//int(11)    用户虚拟币
    public int ui_sign;//int(11)    累计签到天数
    public int ui_tj;//int(11)    推荐有效好友数
    public int ui_lock;//int(11)    是否锁定(0:有效用户1:非法用户)
    public java.util.Date ctime=new java.util.Date();//datetime    创建时间
    public java.util.Date utime=new java.util.Date();//datetime    更新时间
    public String note="";//varchar(100)    备注
    public int ui_release;//int(11)    已发任务数
    public int ui_task;//int(11)    已做任务数
    public int is_vip;//int(11)    是否是VIP
    public String ui_nickname="";//varchar(60)    用户昵称
    public int ui_flag;//int(11)    注册来源0:未指定1:web2:android3:ios4:QQ5:微信6:新浪7:阿里
    public String ui_email="";//varchar(100)    保密邮箱
    public int ui_reg_type;//int(11)    注册类型（0:未指定1:邮箱2:手机）



    public long getUi_id(){
        return ui_id;
    }

    public void setUi_id(long value){
        this.ui_id= value;
    }

    public String getUi_nd(){
        return ui_nd;
    }

    public void setUi_nd(String value){
    	if(value == null){
           value = "";
        }
        this.ui_nd= value;
    }

    public String getUi_token(){
        return ui_token;
    }

    public void setUi_token(String value){
    	if(value == null){
           value = "";
        }
        this.ui_token= value;
    }

    public String getUi_tel(){
        return ui_tel;
    }

    public void setUi_tel(String value){
    	if(value == null){
           value = "";
        }
        this.ui_tel= value;
    }

    public String getUi_password(){
        return ui_password;
    }

    public void setUi_password(String value){
    	if(value == null){
           value = "";
        }
        this.ui_password= value;
    }

    public int getUi_sex(){
        return ui_sex;
    }

    public void setUi_sex(int value){
        this.ui_sex= value;
    }

    public String getUi_avtar(){
        return ui_avtar;
    }

    public void setUi_avtar(String value){
    	if(value == null){
           value = "";
        }
        this.ui_avtar= value;
    }

    public String getUi_bind_tel(){
        return ui_bind_tel;
    }

    public void setUi_bind_tel(String value){
    	if(value == null){
           value = "";
        }
        this.ui_bind_tel= value;
    }

    public String getUi_name(){
        return ui_name;
    }

    public void setUi_name(String value){
    	if(value == null){
           value = "";
        }
        this.ui_name= value;
    }

    public String getUi_zfb(){
        return ui_zfb;
    }

    public void setUi_zfb(String value){
    	if(value == null){
           value = "";
        }
        this.ui_zfb= value;
    }

    public String getUi_wx(){
        return ui_wx;
    }

    public void setUi_wx(String value){
    	if(value == null){
           value = "";
        }
        this.ui_wx= value;
    }

    public int getUi_vc(){
        return ui_vc;
    }

    public void setUi_vc(int value){
        this.ui_vc= value;
    }

    public int getUi_sign(){
        return ui_sign;
    }

    public void setUi_sign(int value){
        this.ui_sign= value;
    }

    public int getUi_tj(){
        return ui_tj;
    }

    public void setUi_tj(int value){
        this.ui_tj= value;
    }

    public int getUi_lock(){
        return ui_lock;
    }

    public void setUi_lock(int value){
        this.ui_lock= value;
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

    public int getUi_release(){
        return ui_release;
    }

    public void setUi_release(int value){
        this.ui_release= value;
    }

    public int getUi_task(){
        return ui_task;
    }

    public void setUi_task(int value){
        this.ui_task= value;
    }

    public int getIs_vip(){
        return is_vip;
    }

    public void setIs_vip(int value){
        this.is_vip= value;
    }

    public String getUi_nickname(){
        return ui_nickname;
    }

    public void setUi_nickname(String value){
    	if(value == null){
           value = "";
        }
        this.ui_nickname= value;
    }

    public int getUi_flag(){
        return ui_flag;
    }

    public void setUi_flag(int value){
        this.ui_flag= value;
    }

    public String getUi_email(){
        return ui_email;
    }

    public void setUi_email(String value){
    	if(value == null){
           value = "";
        }
        this.ui_email= value;
    }

    public int getUi_reg_type(){
        return ui_reg_type;
    }

    public void setUi_reg_type(int value){
        this.ui_reg_type= value;
    }



    public static User_info_new newUser_info_new(long ui_id, String ui_nd, String ui_token, String ui_tel, String ui_password, int ui_sex, String ui_avtar, String ui_bind_tel, String ui_name, String ui_zfb, String ui_wx, int ui_vc, int ui_sign, int ui_tj, int ui_lock, java.util.Date ctime, java.util.Date utime, String note, int ui_release, int ui_task, int is_vip, String ui_nickname, int ui_flag, String ui_email, int ui_reg_type) {
        User_info_new ret = new User_info_new();
        ret.setUi_id(ui_id);
        ret.setUi_nd(ui_nd);
        ret.setUi_token(ui_token);
        ret.setUi_tel(ui_tel);
        ret.setUi_password(ui_password);
        ret.setUi_sex(ui_sex);
        ret.setUi_avtar(ui_avtar);
        ret.setUi_bind_tel(ui_bind_tel);
        ret.setUi_name(ui_name);
        ret.setUi_zfb(ui_zfb);
        ret.setUi_wx(ui_wx);
        ret.setUi_vc(ui_vc);
        ret.setUi_sign(ui_sign);
        ret.setUi_tj(ui_tj);
        ret.setUi_lock(ui_lock);
        ret.setCtime(ctime);
        ret.setUtime(utime);
        ret.setNote(note);
        ret.setUi_release(ui_release);
        ret.setUi_task(ui_task);
        ret.setIs_vip(is_vip);
        ret.setUi_nickname(ui_nickname);
        ret.setUi_flag(ui_flag);
        ret.setUi_email(ui_email);
        ret.setUi_reg_type(ui_reg_type);
        return ret;    
    }

    public void assignment(User_info_new user_info_new) {
        long ui_id = user_info_new.getUi_id();
        String ui_nd = user_info_new.getUi_nd();
        String ui_token = user_info_new.getUi_token();
        String ui_tel = user_info_new.getUi_tel();
        String ui_password = user_info_new.getUi_password();
        int ui_sex = user_info_new.getUi_sex();
        String ui_avtar = user_info_new.getUi_avtar();
        String ui_bind_tel = user_info_new.getUi_bind_tel();
        String ui_name = user_info_new.getUi_name();
        String ui_zfb = user_info_new.getUi_zfb();
        String ui_wx = user_info_new.getUi_wx();
        int ui_vc = user_info_new.getUi_vc();
        int ui_sign = user_info_new.getUi_sign();
        int ui_tj = user_info_new.getUi_tj();
        int ui_lock = user_info_new.getUi_lock();
        java.util.Date ctime = user_info_new.getCtime();
        java.util.Date utime = user_info_new.getUtime();
        String note = user_info_new.getNote();
        int ui_release = user_info_new.getUi_release();
        int ui_task = user_info_new.getUi_task();
        int is_vip = user_info_new.getIs_vip();
        String ui_nickname = user_info_new.getUi_nickname();
        int ui_flag = user_info_new.getUi_flag();
        String ui_email = user_info_new.getUi_email();
        int ui_reg_type = user_info_new.getUi_reg_type();

        this.setUi_id(ui_id);
        this.setUi_nd(ui_nd);
        this.setUi_token(ui_token);
        this.setUi_tel(ui_tel);
        this.setUi_password(ui_password);
        this.setUi_sex(ui_sex);
        this.setUi_avtar(ui_avtar);
        this.setUi_bind_tel(ui_bind_tel);
        this.setUi_name(ui_name);
        this.setUi_zfb(ui_zfb);
        this.setUi_wx(ui_wx);
        this.setUi_vc(ui_vc);
        this.setUi_sign(ui_sign);
        this.setUi_tj(ui_tj);
        this.setUi_lock(ui_lock);
        this.setCtime(ctime);
        this.setUtime(utime);
        this.setNote(note);
        this.setUi_release(ui_release);
        this.setUi_task(ui_task);
        this.setIs_vip(is_vip);
        this.setUi_nickname(ui_nickname);
        this.setUi_flag(ui_flag);
        this.setUi_email(ui_email);
        this.setUi_reg_type(ui_reg_type);

    }

    @SuppressWarnings("unused")
    public static void getUser_info_new(User_info_new user_info_new ){
        long ui_id = user_info_new.getUi_id();
        String ui_nd = user_info_new.getUi_nd();
        String ui_token = user_info_new.getUi_token();
        String ui_tel = user_info_new.getUi_tel();
        String ui_password = user_info_new.getUi_password();
        int ui_sex = user_info_new.getUi_sex();
        String ui_avtar = user_info_new.getUi_avtar();
        String ui_bind_tel = user_info_new.getUi_bind_tel();
        String ui_name = user_info_new.getUi_name();
        String ui_zfb = user_info_new.getUi_zfb();
        String ui_wx = user_info_new.getUi_wx();
        int ui_vc = user_info_new.getUi_vc();
        int ui_sign = user_info_new.getUi_sign();
        int ui_tj = user_info_new.getUi_tj();
        int ui_lock = user_info_new.getUi_lock();
        java.util.Date ctime = user_info_new.getCtime();
        java.util.Date utime = user_info_new.getUtime();
        String note = user_info_new.getNote();
        int ui_release = user_info_new.getUi_release();
        int ui_task = user_info_new.getUi_task();
        int is_vip = user_info_new.getIs_vip();
        String ui_nickname = user_info_new.getUi_nickname();
        int ui_flag = user_info_new.getUi_flag();
        String ui_email = user_info_new.getUi_email();
        int ui_reg_type = user_info_new.getUi_reg_type();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(User_info_new user_info_new){
        long ui_id = user_info_new.getUi_id();
        String ui_nd = user_info_new.getUi_nd();
        String ui_token = user_info_new.getUi_token();
        String ui_tel = user_info_new.getUi_tel();
        String ui_password = user_info_new.getUi_password();
        int ui_sex = user_info_new.getUi_sex();
        String ui_avtar = user_info_new.getUi_avtar();
        String ui_bind_tel = user_info_new.getUi_bind_tel();
        String ui_name = user_info_new.getUi_name();
        String ui_zfb = user_info_new.getUi_zfb();
        String ui_wx = user_info_new.getUi_wx();
        int ui_vc = user_info_new.getUi_vc();
        int ui_sign = user_info_new.getUi_sign();
        int ui_tj = user_info_new.getUi_tj();
        int ui_lock = user_info_new.getUi_lock();
        java.util.Date ctime = user_info_new.getCtime();
        java.util.Date utime = user_info_new.getUtime();
        String note = user_info_new.getNote();
        int ui_release = user_info_new.getUi_release();
        int ui_task = user_info_new.getUi_task();
        int is_vip = user_info_new.getIs_vip();
        String ui_nickname = user_info_new.getUi_nickname();
        int ui_flag = user_info_new.getUi_flag();
        String ui_email = user_info_new.getUi_email();
        int ui_reg_type = user_info_new.getUi_reg_type();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("ui_id",ui_id);
        _ret.put("ui_nd",ui_nd);
        _ret.put("ui_token",ui_token);
        _ret.put("ui_tel",ui_tel);
        _ret.put("ui_password",ui_password);
        _ret.put("ui_sex",ui_sex);
        _ret.put("ui_avtar",ui_avtar);
        _ret.put("ui_bind_tel",ui_bind_tel);
        _ret.put("ui_name",ui_name);
        _ret.put("ui_zfb",ui_zfb);
        _ret.put("ui_wx",ui_wx);
        _ret.put("ui_vc",ui_vc);
        _ret.put("ui_sign",ui_sign);
        _ret.put("ui_tj",ui_tj);
        _ret.put("ui_lock",ui_lock);
        _ret.put("ctime",ctime);
        _ret.put("utime",utime);
        _ret.put("note",note);
        _ret.put("ui_release",ui_release);
        _ret.put("ui_task",ui_task);
        _ret.put("is_vip",is_vip);
        _ret.put("ui_nickname",ui_nickname);
        _ret.put("ui_flag",ui_flag);
        _ret.put("ui_email",ui_email);
        _ret.put("ui_reg_type",ui_reg_type);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public User_info_new clone2(){
        try{
            return (User_info_new) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
