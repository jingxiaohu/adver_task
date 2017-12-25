package com.pyb.bean;

import java.io.*;
import java.util.*;

//wx_recommend_earnings
@SuppressWarnings({"serial"})
public class Wx_recommend_earnings implements Cloneable , Serializable{

    //public static String[] carrays ={"re_id","earnings_total","allow_drawings","drawings","unconfirmed_receiving","ctime","utime","note","ui_id","state","weixin_id","re_type","wait_account"};

    public long re_id;//bigint(20)    主键ID
    public int earnings_total;//int(11)    推荐人总累积收益
    public int allow_drawings;//int(11)    可提现收益
    public int drawings;//int(11)    成功提现收益
    public int unconfirmed_receiving;//int(11)    待收货未经确认收益
    public java.util.Date ctime=new java.util.Date();//timestamp    创建时间
    public java.util.Date utime=new java.util.Date();//timestamp    修改时间
    public String note="";//varchar(60)    备注
    public long ui_id;//bigint(20)    推荐合伙人用户ID
    public int state;//int(11)    是否审核通过0：申请中待审核1：审核通过2：审核不通过
    public String weixin_id="";//varchar(80)    推荐合伙人对公众平台微信IDweixin_id
    public int re_type;//int(11)    合伙人类型：0：普通推荐合伙人1：中级推荐合伙人2：高级推荐合伙人
    public int wait_account;//int(11)    待结算收益



    public long getRe_id(){
        return re_id;
    }

    public void setRe_id(long value){
        this.re_id= value;
    }

    public int getEarnings_total(){
        return earnings_total;
    }

    public void setEarnings_total(int value){
        this.earnings_total= value;
    }

    public int getAllow_drawings(){
        return allow_drawings;
    }

    public void setAllow_drawings(int value){
        this.allow_drawings= value;
    }

    public int getDrawings(){
        return drawings;
    }

    public void setDrawings(int value){
        this.drawings= value;
    }

    public int getUnconfirmed_receiving(){
        return unconfirmed_receiving;
    }

    public void setUnconfirmed_receiving(int value){
        this.unconfirmed_receiving= value;
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

    public long getUi_id(){
        return ui_id;
    }

    public void setUi_id(long value){
        this.ui_id= value;
    }

    public int getState(){
        return state;
    }

    public void setState(int value){
        this.state= value;
    }

    public String getWeixin_id(){
        return weixin_id;
    }

    public void setWeixin_id(String value){
    	if(value == null){
           value = "";
        }
        this.weixin_id= value;
    }

    public int getRe_type(){
        return re_type;
    }

    public void setRe_type(int value){
        this.re_type= value;
    }

    public int getWait_account(){
        return wait_account;
    }

    public void setWait_account(int value){
        this.wait_account= value;
    }



    public static Wx_recommend_earnings newWx_recommend_earnings(long re_id, int earnings_total, int allow_drawings, int drawings, int unconfirmed_receiving, java.util.Date ctime, java.util.Date utime, String note, long ui_id, int state, String weixin_id, int re_type, int wait_account) {
        Wx_recommend_earnings ret = new Wx_recommend_earnings();
        ret.setRe_id(re_id);
        ret.setEarnings_total(earnings_total);
        ret.setAllow_drawings(allow_drawings);
        ret.setDrawings(drawings);
        ret.setUnconfirmed_receiving(unconfirmed_receiving);
        ret.setCtime(ctime);
        ret.setUtime(utime);
        ret.setNote(note);
        ret.setUi_id(ui_id);
        ret.setState(state);
        ret.setWeixin_id(weixin_id);
        ret.setRe_type(re_type);
        ret.setWait_account(wait_account);
        return ret;    
    }

    public void assignment(Wx_recommend_earnings wx_recommend_earnings) {
        long re_id = wx_recommend_earnings.getRe_id();
        int earnings_total = wx_recommend_earnings.getEarnings_total();
        int allow_drawings = wx_recommend_earnings.getAllow_drawings();
        int drawings = wx_recommend_earnings.getDrawings();
        int unconfirmed_receiving = wx_recommend_earnings.getUnconfirmed_receiving();
        java.util.Date ctime = wx_recommend_earnings.getCtime();
        java.util.Date utime = wx_recommend_earnings.getUtime();
        String note = wx_recommend_earnings.getNote();
        long ui_id = wx_recommend_earnings.getUi_id();
        int state = wx_recommend_earnings.getState();
        String weixin_id = wx_recommend_earnings.getWeixin_id();
        int re_type = wx_recommend_earnings.getRe_type();
        int wait_account = wx_recommend_earnings.getWait_account();

        this.setRe_id(re_id);
        this.setEarnings_total(earnings_total);
        this.setAllow_drawings(allow_drawings);
        this.setDrawings(drawings);
        this.setUnconfirmed_receiving(unconfirmed_receiving);
        this.setCtime(ctime);
        this.setUtime(utime);
        this.setNote(note);
        this.setUi_id(ui_id);
        this.setState(state);
        this.setWeixin_id(weixin_id);
        this.setRe_type(re_type);
        this.setWait_account(wait_account);

    }

    @SuppressWarnings("unused")
    public static void getWx_recommend_earnings(Wx_recommend_earnings wx_recommend_earnings ){
        long re_id = wx_recommend_earnings.getRe_id();
        int earnings_total = wx_recommend_earnings.getEarnings_total();
        int allow_drawings = wx_recommend_earnings.getAllow_drawings();
        int drawings = wx_recommend_earnings.getDrawings();
        int unconfirmed_receiving = wx_recommend_earnings.getUnconfirmed_receiving();
        java.util.Date ctime = wx_recommend_earnings.getCtime();
        java.util.Date utime = wx_recommend_earnings.getUtime();
        String note = wx_recommend_earnings.getNote();
        long ui_id = wx_recommend_earnings.getUi_id();
        int state = wx_recommend_earnings.getState();
        String weixin_id = wx_recommend_earnings.getWeixin_id();
        int re_type = wx_recommend_earnings.getRe_type();
        int wait_account = wx_recommend_earnings.getWait_account();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(Wx_recommend_earnings wx_recommend_earnings){
        long re_id = wx_recommend_earnings.getRe_id();
        int earnings_total = wx_recommend_earnings.getEarnings_total();
        int allow_drawings = wx_recommend_earnings.getAllow_drawings();
        int drawings = wx_recommend_earnings.getDrawings();
        int unconfirmed_receiving = wx_recommend_earnings.getUnconfirmed_receiving();
        java.util.Date ctime = wx_recommend_earnings.getCtime();
        java.util.Date utime = wx_recommend_earnings.getUtime();
        String note = wx_recommend_earnings.getNote();
        long ui_id = wx_recommend_earnings.getUi_id();
        int state = wx_recommend_earnings.getState();
        String weixin_id = wx_recommend_earnings.getWeixin_id();
        int re_type = wx_recommend_earnings.getRe_type();
        int wait_account = wx_recommend_earnings.getWait_account();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("re_id",re_id);
        _ret.put("earnings_total",earnings_total);
        _ret.put("allow_drawings",allow_drawings);
        _ret.put("drawings",drawings);
        _ret.put("unconfirmed_receiving",unconfirmed_receiving);
        _ret.put("ctime",ctime);
        _ret.put("utime",utime);
        _ret.put("note",note);
        _ret.put("ui_id",ui_id);
        _ret.put("state",state);
        _ret.put("weixin_id",weixin_id);
        _ret.put("re_type",re_type);
        _ret.put("wait_account",wait_account);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Wx_recommend_earnings clone2(){
        try{
            return (Wx_recommend_earnings) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
