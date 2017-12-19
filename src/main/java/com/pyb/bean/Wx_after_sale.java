package com.pyb.bean;

import java.io.*;
import java.util.*;

//wx_after_sale
@SuppressWarnings({"serial"})
public class Wx_after_sale implements Cloneable , Serializable{

    //public static String[] carrays ={"as_id","type","sales_return","sales_return_intro","refund_money","img_urls","notice","allow_refund_money","refund_info","ctime","ui_id","order_id","g_id","dispose_type","dispose_state","note","is_del"};

    public long as_id;//bigint(20)    
    public int type;//int(11)    处理方式0：未指定1：退货退款2：换货3：退款（仅退款不退货）
    public int sales_return;//int(11)    退货原因：0：未指定1：不想要了2：卖家缺货3：拍错了/订单信息错误4:其它
    public String sales_return_intro="";//varchar(500)    退款说明（选填）
    public int refund_money;//int(11)    退款金额单位分
    public String img_urls="";//varchar(600)    上传凭证（图片集）
    public String notice="";//varchar(150)    提示信息（例如：你可以退款的最大金额为41.90）
    public int allow_refund_money;//int(11)    允许退款最大金额单位分
    public String refund_info="";//varchar(500)    退款系统文字提示
    public java.util.Date ctime=new java.util.Date();//timestamp    创建时间
    public long ui_id;//bigint(20)    用户ID
    public String order_id="";//varchar(80)    订单号
    public long g_id;//bigint(20)    商品ID
    public int dispose_type;//int(11)    处理状态：0：未处理1：已经查看不予处理2：已经查看预给予退款处理3：已经查看预给予退款退货处理4：已经看预给予换货处理
    public int dispose_state;//int(11)    处理退款进度：0：无1：已经调用微信支付退款完毕2：已经调用微信支付退款且退货完毕3：已经进行换货处理完毕
    public String note="";//varchar(60)    备注
    public int is_del;//int(11)    是否逻辑删除:0：不删除1：删除



    public long getAs_id(){
        return as_id;
    }

    public void setAs_id(long value){
        this.as_id= value;
    }

    public int getType(){
        return type;
    }

    public void setType(int value){
        this.type= value;
    }

    public int getSales_return(){
        return sales_return;
    }

    public void setSales_return(int value){
        this.sales_return= value;
    }

    public String getSales_return_intro(){
        return sales_return_intro;
    }

    public void setSales_return_intro(String value){
    	if(value == null){
           value = "";
        }
        this.sales_return_intro= value;
    }

    public int getRefund_money(){
        return refund_money;
    }

    public void setRefund_money(int value){
        this.refund_money= value;
    }

    public String getImg_urls(){
        return img_urls;
    }

    public void setImg_urls(String value){
    	if(value == null){
           value = "";
        }
        this.img_urls= value;
    }

    public String getNotice(){
        return notice;
    }

    public void setNotice(String value){
    	if(value == null){
           value = "";
        }
        this.notice= value;
    }

    public int getAllow_refund_money(){
        return allow_refund_money;
    }

    public void setAllow_refund_money(int value){
        this.allow_refund_money= value;
    }

    public String getRefund_info(){
        return refund_info;
    }

    public void setRefund_info(String value){
    	if(value == null){
           value = "";
        }
        this.refund_info= value;
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

    public int getDispose_type(){
        return dispose_type;
    }

    public void setDispose_type(int value){
        this.dispose_type= value;
    }

    public int getDispose_state(){
        return dispose_state;
    }

    public void setDispose_state(int value){
        this.dispose_state= value;
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



    public static Wx_after_sale newWx_after_sale(long as_id, int type, int sales_return, String sales_return_intro, int refund_money, String img_urls, String notice, int allow_refund_money, String refund_info, java.util.Date ctime, long ui_id, String order_id, long g_id, int dispose_type, int dispose_state, String note, int is_del) {
        Wx_after_sale ret = new Wx_after_sale();
        ret.setAs_id(as_id);
        ret.setType(type);
        ret.setSales_return(sales_return);
        ret.setSales_return_intro(sales_return_intro);
        ret.setRefund_money(refund_money);
        ret.setImg_urls(img_urls);
        ret.setNotice(notice);
        ret.setAllow_refund_money(allow_refund_money);
        ret.setRefund_info(refund_info);
        ret.setCtime(ctime);
        ret.setUi_id(ui_id);
        ret.setOrder_id(order_id);
        ret.setG_id(g_id);
        ret.setDispose_type(dispose_type);
        ret.setDispose_state(dispose_state);
        ret.setNote(note);
        ret.setIs_del(is_del);
        return ret;    
    }

    public void assignment(Wx_after_sale wx_after_sale) {
        long as_id = wx_after_sale.getAs_id();
        int type = wx_after_sale.getType();
        int sales_return = wx_after_sale.getSales_return();
        String sales_return_intro = wx_after_sale.getSales_return_intro();
        int refund_money = wx_after_sale.getRefund_money();
        String img_urls = wx_after_sale.getImg_urls();
        String notice = wx_after_sale.getNotice();
        int allow_refund_money = wx_after_sale.getAllow_refund_money();
        String refund_info = wx_after_sale.getRefund_info();
        java.util.Date ctime = wx_after_sale.getCtime();
        long ui_id = wx_after_sale.getUi_id();
        String order_id = wx_after_sale.getOrder_id();
        long g_id = wx_after_sale.getG_id();
        int dispose_type = wx_after_sale.getDispose_type();
        int dispose_state = wx_after_sale.getDispose_state();
        String note = wx_after_sale.getNote();
        int is_del = wx_after_sale.getIs_del();

        this.setAs_id(as_id);
        this.setType(type);
        this.setSales_return(sales_return);
        this.setSales_return_intro(sales_return_intro);
        this.setRefund_money(refund_money);
        this.setImg_urls(img_urls);
        this.setNotice(notice);
        this.setAllow_refund_money(allow_refund_money);
        this.setRefund_info(refund_info);
        this.setCtime(ctime);
        this.setUi_id(ui_id);
        this.setOrder_id(order_id);
        this.setG_id(g_id);
        this.setDispose_type(dispose_type);
        this.setDispose_state(dispose_state);
        this.setNote(note);
        this.setIs_del(is_del);

    }

    @SuppressWarnings("unused")
    public static void getWx_after_sale(Wx_after_sale wx_after_sale ){
        long as_id = wx_after_sale.getAs_id();
        int type = wx_after_sale.getType();
        int sales_return = wx_after_sale.getSales_return();
        String sales_return_intro = wx_after_sale.getSales_return_intro();
        int refund_money = wx_after_sale.getRefund_money();
        String img_urls = wx_after_sale.getImg_urls();
        String notice = wx_after_sale.getNotice();
        int allow_refund_money = wx_after_sale.getAllow_refund_money();
        String refund_info = wx_after_sale.getRefund_info();
        java.util.Date ctime = wx_after_sale.getCtime();
        long ui_id = wx_after_sale.getUi_id();
        String order_id = wx_after_sale.getOrder_id();
        long g_id = wx_after_sale.getG_id();
        int dispose_type = wx_after_sale.getDispose_type();
        int dispose_state = wx_after_sale.getDispose_state();
        String note = wx_after_sale.getNote();
        int is_del = wx_after_sale.getIs_del();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(Wx_after_sale wx_after_sale){
        long as_id = wx_after_sale.getAs_id();
        int type = wx_after_sale.getType();
        int sales_return = wx_after_sale.getSales_return();
        String sales_return_intro = wx_after_sale.getSales_return_intro();
        int refund_money = wx_after_sale.getRefund_money();
        String img_urls = wx_after_sale.getImg_urls();
        String notice = wx_after_sale.getNotice();
        int allow_refund_money = wx_after_sale.getAllow_refund_money();
        String refund_info = wx_after_sale.getRefund_info();
        java.util.Date ctime = wx_after_sale.getCtime();
        long ui_id = wx_after_sale.getUi_id();
        String order_id = wx_after_sale.getOrder_id();
        long g_id = wx_after_sale.getG_id();
        int dispose_type = wx_after_sale.getDispose_type();
        int dispose_state = wx_after_sale.getDispose_state();
        String note = wx_after_sale.getNote();
        int is_del = wx_after_sale.getIs_del();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("as_id",as_id);
        _ret.put("type",type);
        _ret.put("sales_return",sales_return);
        _ret.put("sales_return_intro",sales_return_intro);
        _ret.put("refund_money",refund_money);
        _ret.put("img_urls",img_urls);
        _ret.put("notice",notice);
        _ret.put("allow_refund_money",allow_refund_money);
        _ret.put("refund_info",refund_info);
        _ret.put("ctime",ctime);
        _ret.put("ui_id",ui_id);
        _ret.put("order_id",order_id);
        _ret.put("g_id",g_id);
        _ret.put("dispose_type",dispose_type);
        _ret.put("dispose_state",dispose_state);
        _ret.put("note",note);
        _ret.put("is_del",is_del);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Wx_after_sale clone2(){
        try{
            return (Wx_after_sale) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
