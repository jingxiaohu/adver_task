package com.pyb.bean;

import java.io.*;
import java.util.*;

//wx_goods
@SuppressWarnings({"serial"})
public class Wx_goods implements Cloneable , Serializable{

    //public static String[] carrays ={"g_id","name","price_new","price_old","express_price","stock_num","dimension","market_num","evaluate_num","hp_num","zp_num","cp_num","st_num","logo_url","banner_urls","intro","src_intro","hp_percent","express","is_bestseller","is_timelimit","is_recommend","is_promotion","is_postage","is_new","gt_id","is_show","is_putaway","order_num","order_pay_num","is_sellout","modify_admin_id","create_admin_id","ctime","utime","note","is_del"};

    public long g_id;//bigint(20)    主键ID
    public String name="";//varchar(60)    商品名称
    public int price_new;//int(11)    商品卖价单位分
    public int price_old;//int(11)    商品原价单位分
    public String express_price="";//varchar(40)    快递费用（区间）
    public int stock_num;//int(11)    商品库存数量
    public String dimension="";//varchar(20)    商品量纲单位
    public int market_num;//int(11)    商品销量
    public int evaluate_num;//int(11)    评价总数量
    public int hp_num;//int(11)    好评数量
    public int zp_num;//int(11)    中评数量
    public int cp_num;//int(11)    差评数量
    public int st_num;//int(11)    晒图数量
    public String logo_url="";//varchar(100)    商品LOGO图片
    public String banner_urls="";//varchar(1000)    商品banner轮播图URL集合逗号分割
    public String intro="";//varchar(500)    商品简介
    public String src_intro="";//varchar(500)    商品来源简介
    public String hp_percent="";//varchar(20)    好评百分比(例如98%)
    public String express="";//varchar(30)    选定快递公司名称
    public int is_bestseller;//int(11)    是否是热卖品0：不是1：是
    public int is_timelimit;//int(11)    是否是限时抢购0：不限时1：限时
    public int is_recommend;//int(11)    是否是推荐商品0：不是1：是
    public int is_promotion;//int(11)    是否是促销商品0：不是1：是
    public int is_postage;//int(11)    是否卖家包邮0：不是1：是
    public int is_new;//int(11)    是否是新品上市0：不是1：是
    public long gt_id;//bigint(20)    商品所属类型表外键ID
    public int is_show;//int(11)    是否显示0：不显示1：显示
    public int is_putaway;//int(11)    是否正式上架购买0：不1：是
    public int order_num;//int(11)    下单数量
    public int order_pay_num;//int(11)    下单且支付数量
    public int is_sellout;//int(11)    是否已售完0：不是1:是
    public long modify_admin_id;//bigint(20)    最后修改人员
    public long create_admin_id;//bigint(20)    商品创建人员
    public java.util.Date ctime=new java.util.Date();//timestamp    创建时间
    public java.util.Date utime=new java.util.Date();//timestamp    修改时间
    public String note="";//varchar(60)    备注
    public int is_del;//int(11)    是否逻辑删除:0：不删除1：删除



    public long getG_id(){
        return g_id;
    }

    public void setG_id(long value){
        this.g_id= value;
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

    public int getPrice_new(){
        return price_new;
    }

    public void setPrice_new(int value){
        this.price_new= value;
    }

    public int getPrice_old(){
        return price_old;
    }

    public void setPrice_old(int value){
        this.price_old= value;
    }

    public String getExpress_price(){
        return express_price;
    }

    public void setExpress_price(String value){
    	if(value == null){
           value = "";
        }
        this.express_price= value;
    }

    public int getStock_num(){
        return stock_num;
    }

    public void setStock_num(int value){
        this.stock_num= value;
    }

    public String getDimension(){
        return dimension;
    }

    public void setDimension(String value){
    	if(value == null){
           value = "";
        }
        this.dimension= value;
    }

    public int getMarket_num(){
        return market_num;
    }

    public void setMarket_num(int value){
        this.market_num= value;
    }

    public int getEvaluate_num(){
        return evaluate_num;
    }

    public void setEvaluate_num(int value){
        this.evaluate_num= value;
    }

    public int getHp_num(){
        return hp_num;
    }

    public void setHp_num(int value){
        this.hp_num= value;
    }

    public int getZp_num(){
        return zp_num;
    }

    public void setZp_num(int value){
        this.zp_num= value;
    }

    public int getCp_num(){
        return cp_num;
    }

    public void setCp_num(int value){
        this.cp_num= value;
    }

    public int getSt_num(){
        return st_num;
    }

    public void setSt_num(int value){
        this.st_num= value;
    }

    public String getLogo_url(){
        return logo_url;
    }

    public void setLogo_url(String value){
    	if(value == null){
           value = "";
        }
        this.logo_url= value;
    }

    public String getBanner_urls(){
        return banner_urls;
    }

    public void setBanner_urls(String value){
    	if(value == null){
           value = "";
        }
        this.banner_urls= value;
    }

    public String getIntro(){
        return intro;
    }

    public void setIntro(String value){
    	if(value == null){
           value = "";
        }
        this.intro= value;
    }

    public String getSrc_intro(){
        return src_intro;
    }

    public void setSrc_intro(String value){
    	if(value == null){
           value = "";
        }
        this.src_intro= value;
    }

    public String getHp_percent(){
        return hp_percent;
    }

    public void setHp_percent(String value){
    	if(value == null){
           value = "";
        }
        this.hp_percent= value;
    }

    public String getExpress(){
        return express;
    }

    public void setExpress(String value){
    	if(value == null){
           value = "";
        }
        this.express= value;
    }

    public int getIs_bestseller(){
        return is_bestseller;
    }

    public void setIs_bestseller(int value){
        this.is_bestseller= value;
    }

    public int getIs_timelimit(){
        return is_timelimit;
    }

    public void setIs_timelimit(int value){
        this.is_timelimit= value;
    }

    public int getIs_recommend(){
        return is_recommend;
    }

    public void setIs_recommend(int value){
        this.is_recommend= value;
    }

    public int getIs_promotion(){
        return is_promotion;
    }

    public void setIs_promotion(int value){
        this.is_promotion= value;
    }

    public int getIs_postage(){
        return is_postage;
    }

    public void setIs_postage(int value){
        this.is_postage= value;
    }

    public int getIs_new(){
        return is_new;
    }

    public void setIs_new(int value){
        this.is_new= value;
    }

    public long getGt_id(){
        return gt_id;
    }

    public void setGt_id(long value){
        this.gt_id= value;
    }

    public int getIs_show(){
        return is_show;
    }

    public void setIs_show(int value){
        this.is_show= value;
    }

    public int getIs_putaway(){
        return is_putaway;
    }

    public void setIs_putaway(int value){
        this.is_putaway= value;
    }

    public int getOrder_num(){
        return order_num;
    }

    public void setOrder_num(int value){
        this.order_num= value;
    }

    public int getOrder_pay_num(){
        return order_pay_num;
    }

    public void setOrder_pay_num(int value){
        this.order_pay_num= value;
    }

    public int getIs_sellout(){
        return is_sellout;
    }

    public void setIs_sellout(int value){
        this.is_sellout= value;
    }

    public long getModify_admin_id(){
        return modify_admin_id;
    }

    public void setModify_admin_id(long value){
        this.modify_admin_id= value;
    }

    public long getCreate_admin_id(){
        return create_admin_id;
    }

    public void setCreate_admin_id(long value){
        this.create_admin_id= value;
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

    public int getIs_del(){
        return is_del;
    }

    public void setIs_del(int value){
        this.is_del= value;
    }



    public static Wx_goods newWx_goods(long g_id, String name, int price_new, int price_old, String express_price, int stock_num, String dimension, int market_num, int evaluate_num, int hp_num, int zp_num, int cp_num, int st_num, String logo_url, String banner_urls, String intro, String src_intro, String hp_percent, String express, int is_bestseller, int is_timelimit, int is_recommend, int is_promotion, int is_postage, int is_new, long gt_id, int is_show, int is_putaway, int order_num, int order_pay_num, int is_sellout, long modify_admin_id, long create_admin_id, java.util.Date ctime, java.util.Date utime, String note, int is_del) {
        Wx_goods ret = new Wx_goods();
        ret.setG_id(g_id);
        ret.setName(name);
        ret.setPrice_new(price_new);
        ret.setPrice_old(price_old);
        ret.setExpress_price(express_price);
        ret.setStock_num(stock_num);
        ret.setDimension(dimension);
        ret.setMarket_num(market_num);
        ret.setEvaluate_num(evaluate_num);
        ret.setHp_num(hp_num);
        ret.setZp_num(zp_num);
        ret.setCp_num(cp_num);
        ret.setSt_num(st_num);
        ret.setLogo_url(logo_url);
        ret.setBanner_urls(banner_urls);
        ret.setIntro(intro);
        ret.setSrc_intro(src_intro);
        ret.setHp_percent(hp_percent);
        ret.setExpress(express);
        ret.setIs_bestseller(is_bestseller);
        ret.setIs_timelimit(is_timelimit);
        ret.setIs_recommend(is_recommend);
        ret.setIs_promotion(is_promotion);
        ret.setIs_postage(is_postage);
        ret.setIs_new(is_new);
        ret.setGt_id(gt_id);
        ret.setIs_show(is_show);
        ret.setIs_putaway(is_putaway);
        ret.setOrder_num(order_num);
        ret.setOrder_pay_num(order_pay_num);
        ret.setIs_sellout(is_sellout);
        ret.setModify_admin_id(modify_admin_id);
        ret.setCreate_admin_id(create_admin_id);
        ret.setCtime(ctime);
        ret.setUtime(utime);
        ret.setNote(note);
        ret.setIs_del(is_del);
        return ret;    
    }

    public void assignment(Wx_goods wx_goods) {
        long g_id = wx_goods.getG_id();
        String name = wx_goods.getName();
        int price_new = wx_goods.getPrice_new();
        int price_old = wx_goods.getPrice_old();
        String express_price = wx_goods.getExpress_price();
        int stock_num = wx_goods.getStock_num();
        String dimension = wx_goods.getDimension();
        int market_num = wx_goods.getMarket_num();
        int evaluate_num = wx_goods.getEvaluate_num();
        int hp_num = wx_goods.getHp_num();
        int zp_num = wx_goods.getZp_num();
        int cp_num = wx_goods.getCp_num();
        int st_num = wx_goods.getSt_num();
        String logo_url = wx_goods.getLogo_url();
        String banner_urls = wx_goods.getBanner_urls();
        String intro = wx_goods.getIntro();
        String src_intro = wx_goods.getSrc_intro();
        String hp_percent = wx_goods.getHp_percent();
        String express = wx_goods.getExpress();
        int is_bestseller = wx_goods.getIs_bestseller();
        int is_timelimit = wx_goods.getIs_timelimit();
        int is_recommend = wx_goods.getIs_recommend();
        int is_promotion = wx_goods.getIs_promotion();
        int is_postage = wx_goods.getIs_postage();
        int is_new = wx_goods.getIs_new();
        long gt_id = wx_goods.getGt_id();
        int is_show = wx_goods.getIs_show();
        int is_putaway = wx_goods.getIs_putaway();
        int order_num = wx_goods.getOrder_num();
        int order_pay_num = wx_goods.getOrder_pay_num();
        int is_sellout = wx_goods.getIs_sellout();
        long modify_admin_id = wx_goods.getModify_admin_id();
        long create_admin_id = wx_goods.getCreate_admin_id();
        java.util.Date ctime = wx_goods.getCtime();
        java.util.Date utime = wx_goods.getUtime();
        String note = wx_goods.getNote();
        int is_del = wx_goods.getIs_del();

        this.setG_id(g_id);
        this.setName(name);
        this.setPrice_new(price_new);
        this.setPrice_old(price_old);
        this.setExpress_price(express_price);
        this.setStock_num(stock_num);
        this.setDimension(dimension);
        this.setMarket_num(market_num);
        this.setEvaluate_num(evaluate_num);
        this.setHp_num(hp_num);
        this.setZp_num(zp_num);
        this.setCp_num(cp_num);
        this.setSt_num(st_num);
        this.setLogo_url(logo_url);
        this.setBanner_urls(banner_urls);
        this.setIntro(intro);
        this.setSrc_intro(src_intro);
        this.setHp_percent(hp_percent);
        this.setExpress(express);
        this.setIs_bestseller(is_bestseller);
        this.setIs_timelimit(is_timelimit);
        this.setIs_recommend(is_recommend);
        this.setIs_promotion(is_promotion);
        this.setIs_postage(is_postage);
        this.setIs_new(is_new);
        this.setGt_id(gt_id);
        this.setIs_show(is_show);
        this.setIs_putaway(is_putaway);
        this.setOrder_num(order_num);
        this.setOrder_pay_num(order_pay_num);
        this.setIs_sellout(is_sellout);
        this.setModify_admin_id(modify_admin_id);
        this.setCreate_admin_id(create_admin_id);
        this.setCtime(ctime);
        this.setUtime(utime);
        this.setNote(note);
        this.setIs_del(is_del);

    }

    @SuppressWarnings("unused")
    public static void getWx_goods(Wx_goods wx_goods ){
        long g_id = wx_goods.getG_id();
        String name = wx_goods.getName();
        int price_new = wx_goods.getPrice_new();
        int price_old = wx_goods.getPrice_old();
        String express_price = wx_goods.getExpress_price();
        int stock_num = wx_goods.getStock_num();
        String dimension = wx_goods.getDimension();
        int market_num = wx_goods.getMarket_num();
        int evaluate_num = wx_goods.getEvaluate_num();
        int hp_num = wx_goods.getHp_num();
        int zp_num = wx_goods.getZp_num();
        int cp_num = wx_goods.getCp_num();
        int st_num = wx_goods.getSt_num();
        String logo_url = wx_goods.getLogo_url();
        String banner_urls = wx_goods.getBanner_urls();
        String intro = wx_goods.getIntro();
        String src_intro = wx_goods.getSrc_intro();
        String hp_percent = wx_goods.getHp_percent();
        String express = wx_goods.getExpress();
        int is_bestseller = wx_goods.getIs_bestseller();
        int is_timelimit = wx_goods.getIs_timelimit();
        int is_recommend = wx_goods.getIs_recommend();
        int is_promotion = wx_goods.getIs_promotion();
        int is_postage = wx_goods.getIs_postage();
        int is_new = wx_goods.getIs_new();
        long gt_id = wx_goods.getGt_id();
        int is_show = wx_goods.getIs_show();
        int is_putaway = wx_goods.getIs_putaway();
        int order_num = wx_goods.getOrder_num();
        int order_pay_num = wx_goods.getOrder_pay_num();
        int is_sellout = wx_goods.getIs_sellout();
        long modify_admin_id = wx_goods.getModify_admin_id();
        long create_admin_id = wx_goods.getCreate_admin_id();
        java.util.Date ctime = wx_goods.getCtime();
        java.util.Date utime = wx_goods.getUtime();
        String note = wx_goods.getNote();
        int is_del = wx_goods.getIs_del();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(Wx_goods wx_goods){
        long g_id = wx_goods.getG_id();
        String name = wx_goods.getName();
        int price_new = wx_goods.getPrice_new();
        int price_old = wx_goods.getPrice_old();
        String express_price = wx_goods.getExpress_price();
        int stock_num = wx_goods.getStock_num();
        String dimension = wx_goods.getDimension();
        int market_num = wx_goods.getMarket_num();
        int evaluate_num = wx_goods.getEvaluate_num();
        int hp_num = wx_goods.getHp_num();
        int zp_num = wx_goods.getZp_num();
        int cp_num = wx_goods.getCp_num();
        int st_num = wx_goods.getSt_num();
        String logo_url = wx_goods.getLogo_url();
        String banner_urls = wx_goods.getBanner_urls();
        String intro = wx_goods.getIntro();
        String src_intro = wx_goods.getSrc_intro();
        String hp_percent = wx_goods.getHp_percent();
        String express = wx_goods.getExpress();
        int is_bestseller = wx_goods.getIs_bestseller();
        int is_timelimit = wx_goods.getIs_timelimit();
        int is_recommend = wx_goods.getIs_recommend();
        int is_promotion = wx_goods.getIs_promotion();
        int is_postage = wx_goods.getIs_postage();
        int is_new = wx_goods.getIs_new();
        long gt_id = wx_goods.getGt_id();
        int is_show = wx_goods.getIs_show();
        int is_putaway = wx_goods.getIs_putaway();
        int order_num = wx_goods.getOrder_num();
        int order_pay_num = wx_goods.getOrder_pay_num();
        int is_sellout = wx_goods.getIs_sellout();
        long modify_admin_id = wx_goods.getModify_admin_id();
        long create_admin_id = wx_goods.getCreate_admin_id();
        java.util.Date ctime = wx_goods.getCtime();
        java.util.Date utime = wx_goods.getUtime();
        String note = wx_goods.getNote();
        int is_del = wx_goods.getIs_del();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("g_id",g_id);
        _ret.put("name",name);
        _ret.put("price_new",price_new);
        _ret.put("price_old",price_old);
        _ret.put("express_price",express_price);
        _ret.put("stock_num",stock_num);
        _ret.put("dimension",dimension);
        _ret.put("market_num",market_num);
        _ret.put("evaluate_num",evaluate_num);
        _ret.put("hp_num",hp_num);
        _ret.put("zp_num",zp_num);
        _ret.put("cp_num",cp_num);
        _ret.put("st_num",st_num);
        _ret.put("logo_url",logo_url);
        _ret.put("banner_urls",banner_urls);
        _ret.put("intro",intro);
        _ret.put("src_intro",src_intro);
        _ret.put("hp_percent",hp_percent);
        _ret.put("express",express);
        _ret.put("is_bestseller",is_bestseller);
        _ret.put("is_timelimit",is_timelimit);
        _ret.put("is_recommend",is_recommend);
        _ret.put("is_promotion",is_promotion);
        _ret.put("is_postage",is_postage);
        _ret.put("is_new",is_new);
        _ret.put("gt_id",gt_id);
        _ret.put("is_show",is_show);
        _ret.put("is_putaway",is_putaway);
        _ret.put("order_num",order_num);
        _ret.put("order_pay_num",order_pay_num);
        _ret.put("is_sellout",is_sellout);
        _ret.put("modify_admin_id",modify_admin_id);
        _ret.put("create_admin_id",create_admin_id);
        _ret.put("ctime",ctime);
        _ret.put("utime",utime);
        _ret.put("note",note);
        _ret.put("is_del",is_del);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Wx_goods clone2(){
        try{
            return (Wx_goods) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
