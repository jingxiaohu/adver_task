package com.pyb.bean;

import java.io.*;
import java.util.*;

//wx_order_goods
@SuppressWarnings({"serial"})
public class Wx_order_goods implements Cloneable , Serializable{

    //public static String[] carrays ={"og_id","ui_id","order_id","g_id","price","num","subtotal","freight_price","money","g_name","g_logo_url","clothing","gt_id","is_del","ctime","note"};

    public long og_id;//bigint(20)    主键ID
    public long ui_id;//bigint(20)    用户ID
    public String order_id="";//varchar(80)    订单号
    public long g_id;//bigint(20)    商品表主键ID
    public int price;//int(11)    商品单价
    public int num;//int(11)    商品数量
    public int subtotal;//int(11)    商品小计金额单位分
    public int freight_price;//int(11)    运费单位分
    public int money;//int(11)    实付金额（含运费）单位分
    public String g_name="";//varchar(150)    商品名称
    public String g_logo_url="";//varchar(200)    商品logo图片
    public String clothing="";//varchar(255)    服装类商品尺码颜色JSON{"size":[120,130,140,150],"color":["黄色","红色","蓝色"]}
    public long gt_id;//bigint(20)    商品类型ID
    public int is_del;//int(11)    是否逻辑删除:0：不删除1：删除
    public java.util.Date ctime=new java.util.Date();//timestamp    创建时间
    public String note="";//varchar(60)    备注



    public long getOg_id(){
        return og_id;
    }

    public void setOg_id(long value){
        this.og_id= value;
    }

    public long getUi_id(){
        return ui_id;
    }

    public void setUi_id(long value){
        this.ui_id= value;
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

    public long getG_id(){
        return g_id;
    }

    public void setG_id(long value){
        this.g_id= value;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int value){
        this.price= value;
    }

    public int getNum(){
        return num;
    }

    public void setNum(int value){
        this.num= value;
    }

    public int getSubtotal(){
        return subtotal;
    }

    public void setSubtotal(int value){
        this.subtotal= value;
    }

    public int getFreight_price(){
        return freight_price;
    }

    public void setFreight_price(int value){
        this.freight_price= value;
    }

    public int getMoney(){
        return money;
    }

    public void setMoney(int value){
        this.money= value;
    }

    public String getG_name(){
        return g_name;
    }

    public void setG_name(String value){
    	if(value == null){
           value = "";
        }
        this.g_name= value;
    }

    public String getG_logo_url(){
        return g_logo_url;
    }

    public void setG_logo_url(String value){
    	if(value == null){
           value = "";
        }
        this.g_logo_url= value;
    }

    public String getClothing(){
        return clothing;
    }

    public void setClothing(String value){
    	if(value == null){
           value = "";
        }
        this.clothing= value;
    }

    public long getGt_id(){
        return gt_id;
    }

    public void setGt_id(long value){
        this.gt_id= value;
    }

    public int getIs_del(){
        return is_del;
    }

    public void setIs_del(int value){
        this.is_del= value;
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



    public static Wx_order_goods newWx_order_goods(long og_id, long ui_id, String order_id, long g_id, int price, int num, int subtotal, int freight_price, int money, String g_name, String g_logo_url, String clothing, long gt_id, int is_del, java.util.Date ctime, String note) {
        Wx_order_goods ret = new Wx_order_goods();
        ret.setOg_id(og_id);
        ret.setUi_id(ui_id);
        ret.setOrder_id(order_id);
        ret.setG_id(g_id);
        ret.setPrice(price);
        ret.setNum(num);
        ret.setSubtotal(subtotal);
        ret.setFreight_price(freight_price);
        ret.setMoney(money);
        ret.setG_name(g_name);
        ret.setG_logo_url(g_logo_url);
        ret.setClothing(clothing);
        ret.setGt_id(gt_id);
        ret.setIs_del(is_del);
        ret.setCtime(ctime);
        ret.setNote(note);
        return ret;    
    }

    public void assignment(Wx_order_goods wx_order_goods) {
        long og_id = wx_order_goods.getOg_id();
        long ui_id = wx_order_goods.getUi_id();
        String order_id = wx_order_goods.getOrder_id();
        long g_id = wx_order_goods.getG_id();
        int price = wx_order_goods.getPrice();
        int num = wx_order_goods.getNum();
        int subtotal = wx_order_goods.getSubtotal();
        int freight_price = wx_order_goods.getFreight_price();
        int money = wx_order_goods.getMoney();
        String g_name = wx_order_goods.getG_name();
        String g_logo_url = wx_order_goods.getG_logo_url();
        String clothing = wx_order_goods.getClothing();
        long gt_id = wx_order_goods.getGt_id();
        int is_del = wx_order_goods.getIs_del();
        java.util.Date ctime = wx_order_goods.getCtime();
        String note = wx_order_goods.getNote();

        this.setOg_id(og_id);
        this.setUi_id(ui_id);
        this.setOrder_id(order_id);
        this.setG_id(g_id);
        this.setPrice(price);
        this.setNum(num);
        this.setSubtotal(subtotal);
        this.setFreight_price(freight_price);
        this.setMoney(money);
        this.setG_name(g_name);
        this.setG_logo_url(g_logo_url);
        this.setClothing(clothing);
        this.setGt_id(gt_id);
        this.setIs_del(is_del);
        this.setCtime(ctime);
        this.setNote(note);

    }

    @SuppressWarnings("unused")
    public static void getWx_order_goods(Wx_order_goods wx_order_goods ){
        long og_id = wx_order_goods.getOg_id();
        long ui_id = wx_order_goods.getUi_id();
        String order_id = wx_order_goods.getOrder_id();
        long g_id = wx_order_goods.getG_id();
        int price = wx_order_goods.getPrice();
        int num = wx_order_goods.getNum();
        int subtotal = wx_order_goods.getSubtotal();
        int freight_price = wx_order_goods.getFreight_price();
        int money = wx_order_goods.getMoney();
        String g_name = wx_order_goods.getG_name();
        String g_logo_url = wx_order_goods.getG_logo_url();
        String clothing = wx_order_goods.getClothing();
        long gt_id = wx_order_goods.getGt_id();
        int is_del = wx_order_goods.getIs_del();
        java.util.Date ctime = wx_order_goods.getCtime();
        String note = wx_order_goods.getNote();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(Wx_order_goods wx_order_goods){
        long og_id = wx_order_goods.getOg_id();
        long ui_id = wx_order_goods.getUi_id();
        String order_id = wx_order_goods.getOrder_id();
        long g_id = wx_order_goods.getG_id();
        int price = wx_order_goods.getPrice();
        int num = wx_order_goods.getNum();
        int subtotal = wx_order_goods.getSubtotal();
        int freight_price = wx_order_goods.getFreight_price();
        int money = wx_order_goods.getMoney();
        String g_name = wx_order_goods.getG_name();
        String g_logo_url = wx_order_goods.getG_logo_url();
        String clothing = wx_order_goods.getClothing();
        long gt_id = wx_order_goods.getGt_id();
        int is_del = wx_order_goods.getIs_del();
        java.util.Date ctime = wx_order_goods.getCtime();
        String note = wx_order_goods.getNote();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("og_id",og_id);
        _ret.put("ui_id",ui_id);
        _ret.put("order_id",order_id);
        _ret.put("g_id",g_id);
        _ret.put("price",price);
        _ret.put("num",num);
        _ret.put("subtotal",subtotal);
        _ret.put("freight_price",freight_price);
        _ret.put("money",money);
        _ret.put("g_name",g_name);
        _ret.put("g_logo_url",g_logo_url);
        _ret.put("clothing",clothing);
        _ret.put("gt_id",gt_id);
        _ret.put("is_del",is_del);
        _ret.put("ctime",ctime);
        _ret.put("note",note);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Wx_order_goods clone2(){
        try{
            return (Wx_order_goods) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
