package com.pyb.bean;

import java.io.*;
import java.util.*;

//wx_goods_order
@SuppressWarnings({"serial"})
public class Wx_goods_order implements Cloneable , Serializable{

    //public static String[] carrays ={"go_id","order_id","g_id","ui_id","price","num","express_info","express_time","address","name","telephone","subtotal","freight_price","money","ctime","ptime","stime","is_after_sale","is_pay","state","is_send","is_evaluate","note","is_del","recommend_id","g_name","g_logo_url","transaction_id","clothing","gt_id","logistic_code","shipper_name","shipper_code"};

    public long go_id;//bigint(20)    主键ID
    public String order_id="";//varchar(80)    订单号
    public long g_id;//bigint(20)    商品表主键ID
    public long ui_id;//bigint(20)    用户ID
    public int price;//int(11)    商品单价
    public int num;//int(11)    商品数量
    public String express_info="";//varchar(255)    快递信息（例如：已经签收收发室代收投递员：宋李鹏15608194018）
    public java.util.Date express_time=new java.util.Date();//timestamp    快递签收时间（2017-12-0116：49：35）
    public String address="";//varchar(255)    收货地址（四川省成都市青羊区四川省成都市青羊区金丝街22号）
    public String name="";//varchar(30)    收货人姓名
    public String telephone="";//varchar(20)    收货人手机号码
    public int subtotal;//int(11)    商品小计金额单位分
    public int freight_price;//int(11)    运费单位分
    public int money;//int(11)    实付金额（含运费）单位分
    public java.util.Date ctime=new java.util.Date();//timestamp    创建时间
    public java.util.Date ptime=new java.util.Date();//timestamp    支付时间
    public java.util.Date stime=new java.util.Date();//timestamp    发货时间
    public int is_after_sale;//int(11)    是否申请了售后0：没有1：有
    public int is_pay;//int(11)    是否支付成功0：没有1：支付成功
    public int state;//int(11)    订单状态0：待付款1：待发货2：待收货3：已完成
    public int is_send;//int(11)    卖家是否发货0：没有1：已经发货
    public int is_evaluate;//int(11)    是否待评价0：待评价1：已评价
    public String note="";//varchar(60)    备注
    public int is_del;//int(11)    是否逻辑删除:0：不删除1：删除
    public long recommend_id;//bigint(20)    我的推荐人用户ID
    public String g_name="";//varchar(150)    商品名称
    public String g_logo_url="";//varchar(200)    商品logo图片
    public String transaction_id="";//varchar(100)    第三方交易单号
    public String clothing="";//varchar(255)    服装类商品尺码颜色JSON{"size":[120,130,140,150],"color":["黄色","红色","蓝色"]}
    public long gt_id;//bigint(20)    商品类型ID
    public String logistic_code="";//varchar(100)    快递单号
    public String shipper_name="";//varchar(100)    快递公司名称
    public String shipper_code="";//varchar(30)    快鸟-快递公司编码



    public long getGo_id(){
        return go_id;
    }

    public void setGo_id(long value){
        this.go_id= value;
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

    public long getUi_id(){
        return ui_id;
    }

    public void setUi_id(long value){
        this.ui_id= value;
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

    public String getExpress_info(){
        return express_info;
    }

    public void setExpress_info(String value){
    	if(value == null){
           value = "";
        }
        this.express_info= value;
    }

    public java.util.Date getExpress_time(){
        return express_time;
    }

    public void setExpress_time(java.util.Date value){
    	if(value == null){
           value = new java.util.Date();
        }
        this.express_time= value;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String value){
    	if(value == null){
           value = "";
        }
        this.address= value;
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

    public java.util.Date getCtime(){
        return ctime;
    }

    public void setCtime(java.util.Date value){
    	if(value == null){
           value = new java.util.Date();
        }
        this.ctime= value;
    }

    public java.util.Date getPtime(){
        return ptime;
    }

    public void setPtime(java.util.Date value){
    	if(value == null){
           value = new java.util.Date();
        }
        this.ptime= value;
    }

    public java.util.Date getStime(){
        return stime;
    }

    public void setStime(java.util.Date value){
    	if(value == null){
           value = new java.util.Date();
        }
        this.stime= value;
    }

    public int getIs_after_sale(){
        return is_after_sale;
    }

    public void setIs_after_sale(int value){
        this.is_after_sale= value;
    }

    public int getIs_pay(){
        return is_pay;
    }

    public void setIs_pay(int value){
        this.is_pay= value;
    }

    public int getState(){
        return state;
    }

    public void setState(int value){
        this.state= value;
    }

    public int getIs_send(){
        return is_send;
    }

    public void setIs_send(int value){
        this.is_send= value;
    }

    public int getIs_evaluate(){
        return is_evaluate;
    }

    public void setIs_evaluate(int value){
        this.is_evaluate= value;
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

    public long getRecommend_id(){
        return recommend_id;
    }

    public void setRecommend_id(long value){
        this.recommend_id= value;
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

    public String getTransaction_id(){
        return transaction_id;
    }

    public void setTransaction_id(String value){
    	if(value == null){
           value = "";
        }
        this.transaction_id= value;
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

    public String getLogistic_code(){
        return logistic_code;
    }

    public void setLogistic_code(String value){
    	if(value == null){
           value = "";
        }
        this.logistic_code= value;
    }

    public String getShipper_name(){
        return shipper_name;
    }

    public void setShipper_name(String value){
    	if(value == null){
           value = "";
        }
        this.shipper_name= value;
    }

    public String getShipper_code(){
        return shipper_code;
    }

    public void setShipper_code(String value){
    	if(value == null){
           value = "";
        }
        this.shipper_code= value;
    }



    public static Wx_goods_order newWx_goods_order(long go_id, String order_id, long g_id, long ui_id, int price, int num, String express_info, java.util.Date express_time, String address, String name, String telephone, int subtotal, int freight_price, int money, java.util.Date ctime, java.util.Date ptime, java.util.Date stime, int is_after_sale, int is_pay, int state, int is_send, int is_evaluate, String note, int is_del, long recommend_id, String g_name, String g_logo_url, String transaction_id, String clothing, long gt_id, String logistic_code, String shipper_name, String shipper_code) {
        Wx_goods_order ret = new Wx_goods_order();
        ret.setGo_id(go_id);
        ret.setOrder_id(order_id);
        ret.setG_id(g_id);
        ret.setUi_id(ui_id);
        ret.setPrice(price);
        ret.setNum(num);
        ret.setExpress_info(express_info);
        ret.setExpress_time(express_time);
        ret.setAddress(address);
        ret.setName(name);
        ret.setTelephone(telephone);
        ret.setSubtotal(subtotal);
        ret.setFreight_price(freight_price);
        ret.setMoney(money);
        ret.setCtime(ctime);
        ret.setPtime(ptime);
        ret.setStime(stime);
        ret.setIs_after_sale(is_after_sale);
        ret.setIs_pay(is_pay);
        ret.setState(state);
        ret.setIs_send(is_send);
        ret.setIs_evaluate(is_evaluate);
        ret.setNote(note);
        ret.setIs_del(is_del);
        ret.setRecommend_id(recommend_id);
        ret.setG_name(g_name);
        ret.setG_logo_url(g_logo_url);
        ret.setTransaction_id(transaction_id);
        ret.setClothing(clothing);
        ret.setGt_id(gt_id);
        ret.setLogistic_code(logistic_code);
        ret.setShipper_name(shipper_name);
        ret.setShipper_code(shipper_code);
        return ret;    
    }

    public void assignment(Wx_goods_order wx_goods_order) {
        long go_id = wx_goods_order.getGo_id();
        String order_id = wx_goods_order.getOrder_id();
        long g_id = wx_goods_order.getG_id();
        long ui_id = wx_goods_order.getUi_id();
        int price = wx_goods_order.getPrice();
        int num = wx_goods_order.getNum();
        String express_info = wx_goods_order.getExpress_info();
        java.util.Date express_time = wx_goods_order.getExpress_time();
        String address = wx_goods_order.getAddress();
        String name = wx_goods_order.getName();
        String telephone = wx_goods_order.getTelephone();
        int subtotal = wx_goods_order.getSubtotal();
        int freight_price = wx_goods_order.getFreight_price();
        int money = wx_goods_order.getMoney();
        java.util.Date ctime = wx_goods_order.getCtime();
        java.util.Date ptime = wx_goods_order.getPtime();
        java.util.Date stime = wx_goods_order.getStime();
        int is_after_sale = wx_goods_order.getIs_after_sale();
        int is_pay = wx_goods_order.getIs_pay();
        int state = wx_goods_order.getState();
        int is_send = wx_goods_order.getIs_send();
        int is_evaluate = wx_goods_order.getIs_evaluate();
        String note = wx_goods_order.getNote();
        int is_del = wx_goods_order.getIs_del();
        long recommend_id = wx_goods_order.getRecommend_id();
        String g_name = wx_goods_order.getG_name();
        String g_logo_url = wx_goods_order.getG_logo_url();
        String transaction_id = wx_goods_order.getTransaction_id();
        String clothing = wx_goods_order.getClothing();
        long gt_id = wx_goods_order.getGt_id();
        String logistic_code = wx_goods_order.getLogistic_code();
        String shipper_name = wx_goods_order.getShipper_name();
        String shipper_code = wx_goods_order.getShipper_code();

        this.setGo_id(go_id);
        this.setOrder_id(order_id);
        this.setG_id(g_id);
        this.setUi_id(ui_id);
        this.setPrice(price);
        this.setNum(num);
        this.setExpress_info(express_info);
        this.setExpress_time(express_time);
        this.setAddress(address);
        this.setName(name);
        this.setTelephone(telephone);
        this.setSubtotal(subtotal);
        this.setFreight_price(freight_price);
        this.setMoney(money);
        this.setCtime(ctime);
        this.setPtime(ptime);
        this.setStime(stime);
        this.setIs_after_sale(is_after_sale);
        this.setIs_pay(is_pay);
        this.setState(state);
        this.setIs_send(is_send);
        this.setIs_evaluate(is_evaluate);
        this.setNote(note);
        this.setIs_del(is_del);
        this.setRecommend_id(recommend_id);
        this.setG_name(g_name);
        this.setG_logo_url(g_logo_url);
        this.setTransaction_id(transaction_id);
        this.setClothing(clothing);
        this.setGt_id(gt_id);
        this.setLogistic_code(logistic_code);
        this.setShipper_name(shipper_name);
        this.setShipper_code(shipper_code);

    }

    @SuppressWarnings("unused")
    public static void getWx_goods_order(Wx_goods_order wx_goods_order ){
        long go_id = wx_goods_order.getGo_id();
        String order_id = wx_goods_order.getOrder_id();
        long g_id = wx_goods_order.getG_id();
        long ui_id = wx_goods_order.getUi_id();
        int price = wx_goods_order.getPrice();
        int num = wx_goods_order.getNum();
        String express_info = wx_goods_order.getExpress_info();
        java.util.Date express_time = wx_goods_order.getExpress_time();
        String address = wx_goods_order.getAddress();
        String name = wx_goods_order.getName();
        String telephone = wx_goods_order.getTelephone();
        int subtotal = wx_goods_order.getSubtotal();
        int freight_price = wx_goods_order.getFreight_price();
        int money = wx_goods_order.getMoney();
        java.util.Date ctime = wx_goods_order.getCtime();
        java.util.Date ptime = wx_goods_order.getPtime();
        java.util.Date stime = wx_goods_order.getStime();
        int is_after_sale = wx_goods_order.getIs_after_sale();
        int is_pay = wx_goods_order.getIs_pay();
        int state = wx_goods_order.getState();
        int is_send = wx_goods_order.getIs_send();
        int is_evaluate = wx_goods_order.getIs_evaluate();
        String note = wx_goods_order.getNote();
        int is_del = wx_goods_order.getIs_del();
        long recommend_id = wx_goods_order.getRecommend_id();
        String g_name = wx_goods_order.getG_name();
        String g_logo_url = wx_goods_order.getG_logo_url();
        String transaction_id = wx_goods_order.getTransaction_id();
        String clothing = wx_goods_order.getClothing();
        long gt_id = wx_goods_order.getGt_id();
        String logistic_code = wx_goods_order.getLogistic_code();
        String shipper_name = wx_goods_order.getShipper_name();
        String shipper_code = wx_goods_order.getShipper_code();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(Wx_goods_order wx_goods_order){
        long go_id = wx_goods_order.getGo_id();
        String order_id = wx_goods_order.getOrder_id();
        long g_id = wx_goods_order.getG_id();
        long ui_id = wx_goods_order.getUi_id();
        int price = wx_goods_order.getPrice();
        int num = wx_goods_order.getNum();
        String express_info = wx_goods_order.getExpress_info();
        java.util.Date express_time = wx_goods_order.getExpress_time();
        String address = wx_goods_order.getAddress();
        String name = wx_goods_order.getName();
        String telephone = wx_goods_order.getTelephone();
        int subtotal = wx_goods_order.getSubtotal();
        int freight_price = wx_goods_order.getFreight_price();
        int money = wx_goods_order.getMoney();
        java.util.Date ctime = wx_goods_order.getCtime();
        java.util.Date ptime = wx_goods_order.getPtime();
        java.util.Date stime = wx_goods_order.getStime();
        int is_after_sale = wx_goods_order.getIs_after_sale();
        int is_pay = wx_goods_order.getIs_pay();
        int state = wx_goods_order.getState();
        int is_send = wx_goods_order.getIs_send();
        int is_evaluate = wx_goods_order.getIs_evaluate();
        String note = wx_goods_order.getNote();
        int is_del = wx_goods_order.getIs_del();
        long recommend_id = wx_goods_order.getRecommend_id();
        String g_name = wx_goods_order.getG_name();
        String g_logo_url = wx_goods_order.getG_logo_url();
        String transaction_id = wx_goods_order.getTransaction_id();
        String clothing = wx_goods_order.getClothing();
        long gt_id = wx_goods_order.getGt_id();
        String logistic_code = wx_goods_order.getLogistic_code();
        String shipper_name = wx_goods_order.getShipper_name();
        String shipper_code = wx_goods_order.getShipper_code();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("go_id",go_id);
        _ret.put("order_id",order_id);
        _ret.put("g_id",g_id);
        _ret.put("ui_id",ui_id);
        _ret.put("price",price);
        _ret.put("num",num);
        _ret.put("express_info",express_info);
        _ret.put("express_time",express_time);
        _ret.put("address",address);
        _ret.put("name",name);
        _ret.put("telephone",telephone);
        _ret.put("subtotal",subtotal);
        _ret.put("freight_price",freight_price);
        _ret.put("money",money);
        _ret.put("ctime",ctime);
        _ret.put("ptime",ptime);
        _ret.put("stime",stime);
        _ret.put("is_after_sale",is_after_sale);
        _ret.put("is_pay",is_pay);
        _ret.put("state",state);
        _ret.put("is_send",is_send);
        _ret.put("is_evaluate",is_evaluate);
        _ret.put("note",note);
        _ret.put("is_del",is_del);
        _ret.put("recommend_id",recommend_id);
        _ret.put("g_name",g_name);
        _ret.put("g_logo_url",g_logo_url);
        _ret.put("transaction_id",transaction_id);
        _ret.put("clothing",clothing);
        _ret.put("gt_id",gt_id);
        _ret.put("logistic_code",logistic_code);
        _ret.put("shipper_name",shipper_name);
        _ret.put("shipper_code",shipper_code);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Wx_goods_order clone2(){
        try{
            return (Wx_goods_order) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
