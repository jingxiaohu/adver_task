package com.pyb.bean;

import java.io.*;
import java.util.*;

//pay_park
@SuppressWarnings({"serial"})
public class Pay_park implements Cloneable , Serializable{

    //public static String[] carrays ={"id","ui_id","ui_nd","ui_tel","order_type","num","money","pp_state","pay_source","my_order","pp_versioncode","phone_type","allege_state","is_del","ai_id","ai_money","ai_effect","up_orderid","ctime","utime","note"};

    public long id;//bigint(20)    主键ID
    public long ui_id;//bigint(20)    用户ID
    public String ui_nd="";//varchar(100)    用户唯一标识uuid
    public String ui_tel="";//varchar(100)    用户电话号码
    public int order_type;//int(11)    下单类型0:未指定1：每天短线牛股2：中线股
    public int num;//int(11)    股票只数
    public int money;//int(11)    支付金额（单位分）
    public int pp_state;//int(11)    支付状态0:未支付1：已经支付
    public int pay_source;//int(11)    支付类型0：现金支付1:支付宝2：微信3：银联4：钱包5:龙支付6:ETC快捷支付7：扫脸支付
    public String my_order="";//varchar(80)    我们的订单号
    public String pp_versioncode="";//varchar(30)    当前APPSDK版本号（内部升级版本代号）
    public int phone_type;//int(11)    手机类型0:android1：IOS
    public int allege_state;//int(11)    申述状态0:未申述1：申述中2：申述失败3：申述成功
    public int is_del;//int(11)    删除状态0:正常1：假删除
    public long ai_id;//bigint(20)    活动ID
    public int ai_money;//int(11)    活动优惠金额（单位分）
    public int ai_effect;//int(11)    活动优惠是否生效（0：没有1：生效）
    public String up_orderid="";//varchar(80)    第三方支付user_pay中的流水单号(订单支付
    public java.util.Date ctime=new java.util.Date();//datetime    下单时间
    public java.util.Date utime=new java.util.Date();//datetime    更新支付状态时间
    public String note="";//varchar(100)    备注



    public long getId(){
        return id;
    }

    public void setId(long value){
        this.id= value;
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

    public String getUi_tel(){
        return ui_tel;
    }

    public void setUi_tel(String value){
    	if(value == null){
           value = "";
        }
        this.ui_tel= value;
    }

    public int getOrder_type(){
        return order_type;
    }

    public void setOrder_type(int value){
        this.order_type= value;
    }

    public int getNum(){
        return num;
    }

    public void setNum(int value){
        this.num= value;
    }

    public int getMoney(){
        return money;
    }

    public void setMoney(int value){
        this.money= value;
    }

    public int getPp_state(){
        return pp_state;
    }

    public void setPp_state(int value){
        this.pp_state= value;
    }

    public int getPay_source(){
        return pay_source;
    }

    public void setPay_source(int value){
        this.pay_source= value;
    }

    public String getMy_order(){
        return my_order;
    }

    public void setMy_order(String value){
    	if(value == null){
           value = "";
        }
        this.my_order= value;
    }

    public String getPp_versioncode(){
        return pp_versioncode;
    }

    public void setPp_versioncode(String value){
    	if(value == null){
           value = "";
        }
        this.pp_versioncode= value;
    }

    public int getPhone_type(){
        return phone_type;
    }

    public void setPhone_type(int value){
        this.phone_type= value;
    }

    public int getAllege_state(){
        return allege_state;
    }

    public void setAllege_state(int value){
        this.allege_state= value;
    }

    public int getIs_del(){
        return is_del;
    }

    public void setIs_del(int value){
        this.is_del= value;
    }

    public long getAi_id(){
        return ai_id;
    }

    public void setAi_id(long value){
        this.ai_id= value;
    }

    public int getAi_money(){
        return ai_money;
    }

    public void setAi_money(int value){
        this.ai_money= value;
    }

    public int getAi_effect(){
        return ai_effect;
    }

    public void setAi_effect(int value){
        this.ai_effect= value;
    }

    public String getUp_orderid(){
        return up_orderid;
    }

    public void setUp_orderid(String value){
    	if(value == null){
           value = "";
        }
        this.up_orderid= value;
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



    public static Pay_park newPay_park(long id, long ui_id, String ui_nd, String ui_tel, int order_type, int num, int money, int pp_state, int pay_source, String my_order, String pp_versioncode, int phone_type, int allege_state, int is_del, long ai_id, int ai_money, int ai_effect, String up_orderid, java.util.Date ctime, java.util.Date utime, String note) {
        Pay_park ret = new Pay_park();
        ret.setId(id);
        ret.setUi_id(ui_id);
        ret.setUi_nd(ui_nd);
        ret.setUi_tel(ui_tel);
        ret.setOrder_type(order_type);
        ret.setNum(num);
        ret.setMoney(money);
        ret.setPp_state(pp_state);
        ret.setPay_source(pay_source);
        ret.setMy_order(my_order);
        ret.setPp_versioncode(pp_versioncode);
        ret.setPhone_type(phone_type);
        ret.setAllege_state(allege_state);
        ret.setIs_del(is_del);
        ret.setAi_id(ai_id);
        ret.setAi_money(ai_money);
        ret.setAi_effect(ai_effect);
        ret.setUp_orderid(up_orderid);
        ret.setCtime(ctime);
        ret.setUtime(utime);
        ret.setNote(note);
        return ret;    
    }

    public void assignment(Pay_park pay_park) {
        long id = pay_park.getId();
        long ui_id = pay_park.getUi_id();
        String ui_nd = pay_park.getUi_nd();
        String ui_tel = pay_park.getUi_tel();
        int order_type = pay_park.getOrder_type();
        int num = pay_park.getNum();
        int money = pay_park.getMoney();
        int pp_state = pay_park.getPp_state();
        int pay_source = pay_park.getPay_source();
        String my_order = pay_park.getMy_order();
        String pp_versioncode = pay_park.getPp_versioncode();
        int phone_type = pay_park.getPhone_type();
        int allege_state = pay_park.getAllege_state();
        int is_del = pay_park.getIs_del();
        long ai_id = pay_park.getAi_id();
        int ai_money = pay_park.getAi_money();
        int ai_effect = pay_park.getAi_effect();
        String up_orderid = pay_park.getUp_orderid();
        java.util.Date ctime = pay_park.getCtime();
        java.util.Date utime = pay_park.getUtime();
        String note = pay_park.getNote();

        this.setId(id);
        this.setUi_id(ui_id);
        this.setUi_nd(ui_nd);
        this.setUi_tel(ui_tel);
        this.setOrder_type(order_type);
        this.setNum(num);
        this.setMoney(money);
        this.setPp_state(pp_state);
        this.setPay_source(pay_source);
        this.setMy_order(my_order);
        this.setPp_versioncode(pp_versioncode);
        this.setPhone_type(phone_type);
        this.setAllege_state(allege_state);
        this.setIs_del(is_del);
        this.setAi_id(ai_id);
        this.setAi_money(ai_money);
        this.setAi_effect(ai_effect);
        this.setUp_orderid(up_orderid);
        this.setCtime(ctime);
        this.setUtime(utime);
        this.setNote(note);

    }

    @SuppressWarnings("unused")
    public static void getPay_park(Pay_park pay_park ){
        long id = pay_park.getId();
        long ui_id = pay_park.getUi_id();
        String ui_nd = pay_park.getUi_nd();
        String ui_tel = pay_park.getUi_tel();
        int order_type = pay_park.getOrder_type();
        int num = pay_park.getNum();
        int money = pay_park.getMoney();
        int pp_state = pay_park.getPp_state();
        int pay_source = pay_park.getPay_source();
        String my_order = pay_park.getMy_order();
        String pp_versioncode = pay_park.getPp_versioncode();
        int phone_type = pay_park.getPhone_type();
        int allege_state = pay_park.getAllege_state();
        int is_del = pay_park.getIs_del();
        long ai_id = pay_park.getAi_id();
        int ai_money = pay_park.getAi_money();
        int ai_effect = pay_park.getAi_effect();
        String up_orderid = pay_park.getUp_orderid();
        java.util.Date ctime = pay_park.getCtime();
        java.util.Date utime = pay_park.getUtime();
        String note = pay_park.getNote();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(Pay_park pay_park){
        long id = pay_park.getId();
        long ui_id = pay_park.getUi_id();
        String ui_nd = pay_park.getUi_nd();
        String ui_tel = pay_park.getUi_tel();
        int order_type = pay_park.getOrder_type();
        int num = pay_park.getNum();
        int money = pay_park.getMoney();
        int pp_state = pay_park.getPp_state();
        int pay_source = pay_park.getPay_source();
        String my_order = pay_park.getMy_order();
        String pp_versioncode = pay_park.getPp_versioncode();
        int phone_type = pay_park.getPhone_type();
        int allege_state = pay_park.getAllege_state();
        int is_del = pay_park.getIs_del();
        long ai_id = pay_park.getAi_id();
        int ai_money = pay_park.getAi_money();
        int ai_effect = pay_park.getAi_effect();
        String up_orderid = pay_park.getUp_orderid();
        java.util.Date ctime = pay_park.getCtime();
        java.util.Date utime = pay_park.getUtime();
        String note = pay_park.getNote();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("id",id);
        _ret.put("ui_id",ui_id);
        _ret.put("ui_nd",ui_nd);
        _ret.put("ui_tel",ui_tel);
        _ret.put("order_type",order_type);
        _ret.put("num",num);
        _ret.put("money",money);
        _ret.put("pp_state",pp_state);
        _ret.put("pay_source",pay_source);
        _ret.put("my_order",my_order);
        _ret.put("pp_versioncode",pp_versioncode);
        _ret.put("phone_type",phone_type);
        _ret.put("allege_state",allege_state);
        _ret.put("is_del",is_del);
        _ret.put("ai_id",ai_id);
        _ret.put("ai_money",ai_money);
        _ret.put("ai_effect",ai_effect);
        _ret.put("up_orderid",up_orderid);
        _ret.put("ctime",ctime);
        _ret.put("utime",utime);
        _ret.put("note",note);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Pay_park clone2(){
        try{
            return (Pay_park) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
