package com.pyb.bean;

import java.io.*;
import java.util.*;

//wx_user_withdraw
@SuppressWarnings({"serial"})
public class Wx_user_withdraw implements Cloneable , Serializable{

    //public static String[] carrays ={"uw_id","ui_id","money","telephone","weixin_no","snap_json","state","is_del","remit_time","ctime","note"};

    public long uw_id;//bigint(20)    主键ID
    public long ui_id;//bigint(20)    用户id
    public int money;//int(11)    提现金额(单位分)
    public String telephone="";//varchar(30)    用户手机号码
    public String weixin_no="";//varchar(60)    用户微信号码
    public String snap_json="";//varchar(1000)    提现前快照JSON字符串
    public int state;//int(11)    打款状态(0:未打款1：打款成功2：打款失败信息不吻合)
    public int is_del;//int(11)    是否逻辑删除(0:不删除1：删除)
    public java.util.Date remit_time=new java.util.Date();//timestamp    打款处理时间
    public java.util.Date ctime=new java.util.Date();//timestamp    创建时间
    public String note="";//varchar(100)    备注



    public long getUw_id(){
        return uw_id;
    }

    public void setUw_id(long value){
        this.uw_id= value;
    }

    public long getUi_id(){
        return ui_id;
    }

    public void setUi_id(long value){
        this.ui_id= value;
    }

    public int getMoney(){
        return money;
    }

    public void setMoney(int value){
        this.money= value;
    }

    public String getTelephone(){
        return telephone;
    }

    public void setTelephone(String value){
    	if(value == null){
           value = "";
        }
        this.telephone= value;
    }

    public String getWeixin_no(){
        return weixin_no;
    }

    public void setWeixin_no(String value){
    	if(value == null){
           value = "";
        }
        this.weixin_no= value;
    }

    public String getSnap_json(){
        return snap_json;
    }

    public void setSnap_json(String value){
    	if(value == null){
           value = "";
        }
        this.snap_json= value;
    }

    public int getState(){
        return state;
    }

    public void setState(int value){
        this.state= value;
    }

    public int getIs_del(){
        return is_del;
    }

    public void setIs_del(int value){
        this.is_del= value;
    }

    public java.util.Date getRemit_time(){
        return remit_time;
    }

    public void setRemit_time(java.util.Date value){
    	if(value == null){
           value = new java.util.Date();
        }
        this.remit_time= value;
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

    public String getNote(){
        return note;
    }

    public void setNote(String value){
    	if(value == null){
           value = "";
        }
        this.note= value;
    }



    public static Wx_user_withdraw newWx_user_withdraw(long uw_id, long ui_id, int money, String telephone, String weixin_no, String snap_json, int state, int is_del, java.util.Date remit_time, java.util.Date ctime, String note) {
        Wx_user_withdraw ret = new Wx_user_withdraw();
        ret.setUw_id(uw_id);
        ret.setUi_id(ui_id);
        ret.setMoney(money);
        ret.setTelephone(telephone);
        ret.setWeixin_no(weixin_no);
        ret.setSnap_json(snap_json);
        ret.setState(state);
        ret.setIs_del(is_del);
        ret.setRemit_time(remit_time);
        ret.setCtime(ctime);
        ret.setNote(note);
        return ret;    
    }

    public void assignment(Wx_user_withdraw wx_user_withdraw) {
        long uw_id = wx_user_withdraw.getUw_id();
        long ui_id = wx_user_withdraw.getUi_id();
        int money = wx_user_withdraw.getMoney();
        String telephone = wx_user_withdraw.getTelephone();
        String weixin_no = wx_user_withdraw.getWeixin_no();
        String snap_json = wx_user_withdraw.getSnap_json();
        int state = wx_user_withdraw.getState();
        int is_del = wx_user_withdraw.getIs_del();
        java.util.Date remit_time = wx_user_withdraw.getRemit_time();
        java.util.Date ctime = wx_user_withdraw.getCtime();
        String note = wx_user_withdraw.getNote();

        this.setUw_id(uw_id);
        this.setUi_id(ui_id);
        this.setMoney(money);
        this.setTelephone(telephone);
        this.setWeixin_no(weixin_no);
        this.setSnap_json(snap_json);
        this.setState(state);
        this.setIs_del(is_del);
        this.setRemit_time(remit_time);
        this.setCtime(ctime);
        this.setNote(note);

    }

    @SuppressWarnings("unused")
    public static void getWx_user_withdraw(Wx_user_withdraw wx_user_withdraw ){
        long uw_id = wx_user_withdraw.getUw_id();
        long ui_id = wx_user_withdraw.getUi_id();
        int money = wx_user_withdraw.getMoney();
        String telephone = wx_user_withdraw.getTelephone();
        String weixin_no = wx_user_withdraw.getWeixin_no();
        String snap_json = wx_user_withdraw.getSnap_json();
        int state = wx_user_withdraw.getState();
        int is_del = wx_user_withdraw.getIs_del();
        java.util.Date remit_time = wx_user_withdraw.getRemit_time();
        java.util.Date ctime = wx_user_withdraw.getCtime();
        String note = wx_user_withdraw.getNote();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(Wx_user_withdraw wx_user_withdraw){
        long uw_id = wx_user_withdraw.getUw_id();
        long ui_id = wx_user_withdraw.getUi_id();
        int money = wx_user_withdraw.getMoney();
        String telephone = wx_user_withdraw.getTelephone();
        String weixin_no = wx_user_withdraw.getWeixin_no();
        String snap_json = wx_user_withdraw.getSnap_json();
        int state = wx_user_withdraw.getState();
        int is_del = wx_user_withdraw.getIs_del();
        java.util.Date remit_time = wx_user_withdraw.getRemit_time();
        java.util.Date ctime = wx_user_withdraw.getCtime();
        String note = wx_user_withdraw.getNote();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("uw_id",uw_id);
        _ret.put("ui_id",ui_id);
        _ret.put("money",money);
        _ret.put("telephone",telephone);
        _ret.put("weixin_no",weixin_no);
        _ret.put("snap_json",snap_json);
        _ret.put("state",state);
        _ret.put("is_del",is_del);
        _ret.put("remit_time",remit_time);
        _ret.put("ctime",ctime);
        _ret.put("note",note);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Wx_user_withdraw clone2(){
        try{
            return (Wx_user_withdraw) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
