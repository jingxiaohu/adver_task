package com.pyb.bean;

import java.io.*;
import java.util.*;

//wx_apply_cash
@SuppressWarnings({"serial"})
public class Wx_apply_cash implements Cloneable , Serializable{

    //public static String[] carrays ={"ac_id","ui_id","weixin_no","name","telephone","money","state","money_old","ctime","utime","note"};

    public long ac_id;//bigint(20)    主键ID
    public long ui_id;//bigint(20)    用户id
    public String weixin_no="";//varchar(80)    用户微信号
    public String name="";//varchar(60)    用户真实姓名
    public String telephone="";//varchar(30)    用户手机号码
    public int money;//int(11)    提现金额单位分
    public int state;//int(11)    提现状态：0：待审核1：审核通过待打款2：已打款完毕3：提现失败
    public int money_old;//int(11)    提现前可供提现金额单位分
    public java.util.Date ctime=new java.util.Date();//timestamp    创建时间
    public java.util.Date utime=new java.util.Date();//timestamp    修改时间
    public String note="";//varchar(60)    备注



    public long getAc_id(){
        return ac_id;
    }

    public void setAc_id(long value){
        this.ac_id= value;
    }

    public long getUi_id(){
        return ui_id;
    }

    public void setUi_id(long value){
        this.ui_id= value;
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

    public String getName(){
        return name;
    }

    public void setName(String value){
    	if(value == null){
           value = "";
        }
        this.name= value;
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

    public int getMoney(){
        return money;
    }

    public void setMoney(int value){
        this.money= value;
    }

    public int getState(){
        return state;
    }

    public void setState(int value){
        this.state= value;
    }

    public int getMoney_old(){
        return money_old;
    }

    public void setMoney_old(int value){
        this.money_old= value;
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



    public static Wx_apply_cash newWx_apply_cash(long ac_id, long ui_id, String weixin_no, String name, String telephone, int money, int state, int money_old, java.util.Date ctime, java.util.Date utime, String note) {
        Wx_apply_cash ret = new Wx_apply_cash();
        ret.setAc_id(ac_id);
        ret.setUi_id(ui_id);
        ret.setWeixin_no(weixin_no);
        ret.setName(name);
        ret.setTelephone(telephone);
        ret.setMoney(money);
        ret.setState(state);
        ret.setMoney_old(money_old);
        ret.setCtime(ctime);
        ret.setUtime(utime);
        ret.setNote(note);
        return ret;    
    }

    public void assignment(Wx_apply_cash wx_apply_cash) {
        long ac_id = wx_apply_cash.getAc_id();
        long ui_id = wx_apply_cash.getUi_id();
        String weixin_no = wx_apply_cash.getWeixin_no();
        String name = wx_apply_cash.getName();
        String telephone = wx_apply_cash.getTelephone();
        int money = wx_apply_cash.getMoney();
        int state = wx_apply_cash.getState();
        int money_old = wx_apply_cash.getMoney_old();
        java.util.Date ctime = wx_apply_cash.getCtime();
        java.util.Date utime = wx_apply_cash.getUtime();
        String note = wx_apply_cash.getNote();

        this.setAc_id(ac_id);
        this.setUi_id(ui_id);
        this.setWeixin_no(weixin_no);
        this.setName(name);
        this.setTelephone(telephone);
        this.setMoney(money);
        this.setState(state);
        this.setMoney_old(money_old);
        this.setCtime(ctime);
        this.setUtime(utime);
        this.setNote(note);

    }

    @SuppressWarnings("unused")
    public static void getWx_apply_cash(Wx_apply_cash wx_apply_cash ){
        long ac_id = wx_apply_cash.getAc_id();
        long ui_id = wx_apply_cash.getUi_id();
        String weixin_no = wx_apply_cash.getWeixin_no();
        String name = wx_apply_cash.getName();
        String telephone = wx_apply_cash.getTelephone();
        int money = wx_apply_cash.getMoney();
        int state = wx_apply_cash.getState();
        int money_old = wx_apply_cash.getMoney_old();
        java.util.Date ctime = wx_apply_cash.getCtime();
        java.util.Date utime = wx_apply_cash.getUtime();
        String note = wx_apply_cash.getNote();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(Wx_apply_cash wx_apply_cash){
        long ac_id = wx_apply_cash.getAc_id();
        long ui_id = wx_apply_cash.getUi_id();
        String weixin_no = wx_apply_cash.getWeixin_no();
        String name = wx_apply_cash.getName();
        String telephone = wx_apply_cash.getTelephone();
        int money = wx_apply_cash.getMoney();
        int state = wx_apply_cash.getState();
        int money_old = wx_apply_cash.getMoney_old();
        java.util.Date ctime = wx_apply_cash.getCtime();
        java.util.Date utime = wx_apply_cash.getUtime();
        String note = wx_apply_cash.getNote();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("ac_id",ac_id);
        _ret.put("ui_id",ui_id);
        _ret.put("weixin_no",weixin_no);
        _ret.put("name",name);
        _ret.put("telephone",telephone);
        _ret.put("money",money);
        _ret.put("state",state);
        _ret.put("money_old",money_old);
        _ret.put("ctime",ctime);
        _ret.put("utime",utime);
        _ret.put("note",note);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Wx_apply_cash clone2(){
        try{
            return (Wx_apply_cash) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
