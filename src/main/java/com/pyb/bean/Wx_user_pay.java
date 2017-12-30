package com.pyb.bean;

import java.io.*;
import java.util.*;

//wx_user_pay
@SuppressWarnings({"serial"})
public class Wx_user_pay implements Cloneable , Serializable{

    //public static String[] carrays ={"id","order_id","transaction_id","type","version_code","system_type","return_url","ui_id","ui_nd","tel","money","act_type","ctime","utime","etime","state","ip","referer","subject","car_order_id","note","is_del"};

    public long id;//bigint(20)    主键ID
    public String order_id="";//varchar(100)    我的订单
    public String transaction_id="";//varchar(100)    第三方事物单号
    public int type;//int(11)    支付类型1:支付宝2：微信3：银联4：钱包5:龙支付
    public int version_code;//int(11)    当前手机APP版本号
    public int system_type;//int(11)    操作系统类型（IOSAndroidweb）1:android2:IOS3:web4:PDA
    public String return_url="";//varchar(255)    前置页面跳转URL
    public long ui_id;//bigint(20)    
    public String ui_nd="";//varchar(100)    
    public String tel="";//varchar(20)    用户电话号码
    public int money;//int(11)    
    public int act_type;//int(11)    行为类型1：充值2：普通订单支付3：租赁订单支付
    public java.util.Date ctime=new java.util.Date();//timestamp    创建时间
    public java.util.Date utime=new java.util.Date();//timestamp    第三方回调时间
    public java.util.Date etime=new java.util.Date();//timestamp    订单失效时间
    public int state;//int(11)    交易状态(0:未支付1：已支付2：支付失败)
    public String ip="";//varchar(100)    IP地址
    public String referer="";//varchar(255)    第三方回调referer
    public String subject="";//varchar(200)    商品名称
    public String car_order_id="";//text    停车订单号如果多个中间逗号分割例如（a123,b123,c123）
    public String note="";//varchar(100)    备注
    public int is_del;//int(11)    是否逻辑删除（0：不删除1：删除）



    public long getId(){
        return id;
    }

    public void setId(long value){
        this.id= value;
    }

    public String getOrder_id(){
        return order_id;
    }

    public void setOrder_id(String value){
    	if(value == null){
           value = "";
        }
        this.order_id= value;
    }

    public String getTransaction_id(){
        return transaction_id;
    }

    public void setTransaction_id(String value){
    	if(value == null){
           value = "";
        }
        this.transaction_id= value;
    }

    public int getType(){
        return type;
    }

    public void setType(int value){
        this.type= value;
    }

    public int getVersion_code(){
        return version_code;
    }

    public void setVersion_code(int value){
        this.version_code= value;
    }

    public int getSystem_type(){
        return system_type;
    }

    public void setSystem_type(int value){
        this.system_type= value;
    }

    public String getReturn_url(){
        return return_url;
    }

    public void setReturn_url(String value){
    	if(value == null){
           value = "";
        }
        this.return_url= value;
    }

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

    public String getTel(){
        return tel;
    }

    public void setTel(String value){
    	if(value == null){
           value = "";
        }
        this.tel= value;
    }

    public int getMoney(){
        return money;
    }

    public void setMoney(int value){
        this.money= value;
    }

    public int getAct_type(){
        return act_type;
    }

    public void setAct_type(int value){
        this.act_type= value;
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

    public java.util.Date getEtime(){
        return etime;
    }

    public void setEtime(java.util.Date value){
    	if(value == null){
           value = new java.util.Date();
        }
        this.etime= value;
    }

    public int getState(){
        return state;
    }

    public void setState(int value){
        this.state= value;
    }

    public String getIp(){
        return ip;
    }

    public void setIp(String value){
    	if(value == null){
           value = "";
        }
        this.ip= value;
    }

    public String getReferer(){
        return referer;
    }

    public void setReferer(String value){
    	if(value == null){
           value = "";
        }
        this.referer= value;
    }

    public String getSubject(){
        return subject;
    }

    public void setSubject(String value){
    	if(value == null){
           value = "";
        }
        this.subject= value;
    }

    public String getCar_order_id(){
        return car_order_id;
    }

    public void setCar_order_id(String value){
    	if(value == null){
           value = "";
        }
        this.car_order_id= value;
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

    public int getIs_del(){
        return is_del;
    }

    public void setIs_del(int value){
        this.is_del= value;
    }



    public static Wx_user_pay newWx_user_pay(long id, String order_id, String transaction_id, int type, int version_code, int system_type, String return_url, long ui_id, String ui_nd, String tel, int money, int act_type, java.util.Date ctime, java.util.Date utime, java.util.Date etime, int state, String ip, String referer, String subject, String car_order_id, String note, int is_del) {
        Wx_user_pay ret = new Wx_user_pay();
        ret.setId(id);
        ret.setOrder_id(order_id);
        ret.setTransaction_id(transaction_id);
        ret.setType(type);
        ret.setVersion_code(version_code);
        ret.setSystem_type(system_type);
        ret.setReturn_url(return_url);
        ret.setUi_id(ui_id);
        ret.setUi_nd(ui_nd);
        ret.setTel(tel);
        ret.setMoney(money);
        ret.setAct_type(act_type);
        ret.setCtime(ctime);
        ret.setUtime(utime);
        ret.setEtime(etime);
        ret.setState(state);
        ret.setIp(ip);
        ret.setReferer(referer);
        ret.setSubject(subject);
        ret.setCar_order_id(car_order_id);
        ret.setNote(note);
        ret.setIs_del(is_del);
        return ret;    
    }

    public void assignment(Wx_user_pay wx_user_pay) {
        long id = wx_user_pay.getId();
        String order_id = wx_user_pay.getOrder_id();
        String transaction_id = wx_user_pay.getTransaction_id();
        int type = wx_user_pay.getType();
        int version_code = wx_user_pay.getVersion_code();
        int system_type = wx_user_pay.getSystem_type();
        String return_url = wx_user_pay.getReturn_url();
        long ui_id = wx_user_pay.getUi_id();
        String ui_nd = wx_user_pay.getUi_nd();
        String tel = wx_user_pay.getTel();
        int money = wx_user_pay.getMoney();
        int act_type = wx_user_pay.getAct_type();
        java.util.Date ctime = wx_user_pay.getCtime();
        java.util.Date utime = wx_user_pay.getUtime();
        java.util.Date etime = wx_user_pay.getEtime();
        int state = wx_user_pay.getState();
        String ip = wx_user_pay.getIp();
        String referer = wx_user_pay.getReferer();
        String subject = wx_user_pay.getSubject();
        String car_order_id = wx_user_pay.getCar_order_id();
        String note = wx_user_pay.getNote();
        int is_del = wx_user_pay.getIs_del();

        this.setId(id);
        this.setOrder_id(order_id);
        this.setTransaction_id(transaction_id);
        this.setType(type);
        this.setVersion_code(version_code);
        this.setSystem_type(system_type);
        this.setReturn_url(return_url);
        this.setUi_id(ui_id);
        this.setUi_nd(ui_nd);
        this.setTel(tel);
        this.setMoney(money);
        this.setAct_type(act_type);
        this.setCtime(ctime);
        this.setUtime(utime);
        this.setEtime(etime);
        this.setState(state);
        this.setIp(ip);
        this.setReferer(referer);
        this.setSubject(subject);
        this.setCar_order_id(car_order_id);
        this.setNote(note);
        this.setIs_del(is_del);

    }

    @SuppressWarnings("unused")
    public static void getWx_user_pay(Wx_user_pay wx_user_pay ){
        long id = wx_user_pay.getId();
        String order_id = wx_user_pay.getOrder_id();
        String transaction_id = wx_user_pay.getTransaction_id();
        int type = wx_user_pay.getType();
        int version_code = wx_user_pay.getVersion_code();
        int system_type = wx_user_pay.getSystem_type();
        String return_url = wx_user_pay.getReturn_url();
        long ui_id = wx_user_pay.getUi_id();
        String ui_nd = wx_user_pay.getUi_nd();
        String tel = wx_user_pay.getTel();
        int money = wx_user_pay.getMoney();
        int act_type = wx_user_pay.getAct_type();
        java.util.Date ctime = wx_user_pay.getCtime();
        java.util.Date utime = wx_user_pay.getUtime();
        java.util.Date etime = wx_user_pay.getEtime();
        int state = wx_user_pay.getState();
        String ip = wx_user_pay.getIp();
        String referer = wx_user_pay.getReferer();
        String subject = wx_user_pay.getSubject();
        String car_order_id = wx_user_pay.getCar_order_id();
        String note = wx_user_pay.getNote();
        int is_del = wx_user_pay.getIs_del();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(Wx_user_pay wx_user_pay){
        long id = wx_user_pay.getId();
        String order_id = wx_user_pay.getOrder_id();
        String transaction_id = wx_user_pay.getTransaction_id();
        int type = wx_user_pay.getType();
        int version_code = wx_user_pay.getVersion_code();
        int system_type = wx_user_pay.getSystem_type();
        String return_url = wx_user_pay.getReturn_url();
        long ui_id = wx_user_pay.getUi_id();
        String ui_nd = wx_user_pay.getUi_nd();
        String tel = wx_user_pay.getTel();
        int money = wx_user_pay.getMoney();
        int act_type = wx_user_pay.getAct_type();
        java.util.Date ctime = wx_user_pay.getCtime();
        java.util.Date utime = wx_user_pay.getUtime();
        java.util.Date etime = wx_user_pay.getEtime();
        int state = wx_user_pay.getState();
        String ip = wx_user_pay.getIp();
        String referer = wx_user_pay.getReferer();
        String subject = wx_user_pay.getSubject();
        String car_order_id = wx_user_pay.getCar_order_id();
        String note = wx_user_pay.getNote();
        int is_del = wx_user_pay.getIs_del();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("id",id);
        _ret.put("order_id",order_id);
        _ret.put("transaction_id",transaction_id);
        _ret.put("type",type);
        _ret.put("version_code",version_code);
        _ret.put("system_type",system_type);
        _ret.put("return_url",return_url);
        _ret.put("ui_id",ui_id);
        _ret.put("ui_nd",ui_nd);
        _ret.put("tel",tel);
        _ret.put("money",money);
        _ret.put("act_type",act_type);
        _ret.put("ctime",ctime);
        _ret.put("utime",utime);
        _ret.put("etime",etime);
        _ret.put("state",state);
        _ret.put("ip",ip);
        _ret.put("referer",referer);
        _ret.put("subject",subject);
        _ret.put("car_order_id",car_order_id);
        _ret.put("note",note);
        _ret.put("is_del",is_del);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Wx_user_pay clone2(){
        try{
            return (Wx_user_pay) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
