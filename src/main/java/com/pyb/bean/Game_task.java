package com.pyb.bean;

import java.io.*;
import java.util.*;

//game_task
@SuppressWarnings({"serial"})
public class Game_task implements Cloneable , Serializable{

    //public static String[] carrays ={"gt_id","gt_nd","gt_type","gt_name","gt_money","gt_seller","gt_log_url","gt_rebate","gt_server","gt_detail_url","gt_people","gt_browse","gt_order","gt_real_money","endtime","gt_open","ctime","note"};

    public long gt_id;//bigint(20)    主键ID
    public String gt_nd="";//varchar(80)    唯一标识ND
    public int gt_type;//int(11)    游戏类型(0:未知1:网页游戏2::手游3:棋牌游戏)
    public String gt_name="";//varchar(100)    游戏名称
    public int gt_money;//int(11)    试玩可获取金额（单位分）
    public String gt_seller="";//varchar(80)    游戏运营商家名称
    public String gt_log_url="";//varchar(255)    log缩略图URL
    public int gt_rebate;//int(11)    充值返利百分比（整数例如18就是百分之18）
    public String gt_server="";//varchar(100)    所在服名称（例如：5服或者专区）
    public String gt_detail_url="";//varchar(255)    游戏试玩详情页面URL
    public int gt_people;//int(11)    参与人数
    public int gt_browse;//int(11)    浏览人数
    public int gt_order;//int(11)    权重比
    public int gt_real_money;//int(11)    接游戏金额单位分（自己看）
    public java.util.Date endtime=new java.util.Date();//datetime    结束投放时间
    public int gt_open;//int(11)    是否开启（0:不开启1:开启）
    public java.util.Date ctime=new java.util.Date();//datetime    创建时间
    public String note="";//varchar(100)    备注



    public long getGt_id(){
        return gt_id;
    }

    public void setGt_id(long value){
        this.gt_id= value;
    }

    public String getGt_nd(){
        return gt_nd;
    }

    public void setGt_nd(String value){
    	if(value == null){
           value = "";
        }
        this.gt_nd= value;
    }

    public int getGt_type(){
        return gt_type;
    }

    public void setGt_type(int value){
        this.gt_type= value;
    }

    public String getGt_name(){
        return gt_name;
    }

    public void setGt_name(String value){
    	if(value == null){
           value = "";
        }
        this.gt_name= value;
    }

    public int getGt_money(){
        return gt_money;
    }

    public void setGt_money(int value){
        this.gt_money= value;
    }

    public String getGt_seller(){
        return gt_seller;
    }

    public void setGt_seller(String value){
    	if(value == null){
           value = "";
        }
        this.gt_seller= value;
    }

    public String getGt_log_url(){
        return gt_log_url;
    }

    public void setGt_log_url(String value){
    	if(value == null){
           value = "";
        }
        this.gt_log_url= value;
    }

    public int getGt_rebate(){
        return gt_rebate;
    }

    public void setGt_rebate(int value){
        this.gt_rebate= value;
    }

    public String getGt_server(){
        return gt_server;
    }

    public void setGt_server(String value){
    	if(value == null){
           value = "";
        }
        this.gt_server= value;
    }

    public String getGt_detail_url(){
        return gt_detail_url;
    }

    public void setGt_detail_url(String value){
    	if(value == null){
           value = "";
        }
        this.gt_detail_url= value;
    }

    public int getGt_people(){
        return gt_people;
    }

    public void setGt_people(int value){
        this.gt_people= value;
    }

    public int getGt_browse(){
        return gt_browse;
    }

    public void setGt_browse(int value){
        this.gt_browse= value;
    }

    public int getGt_order(){
        return gt_order;
    }

    public void setGt_order(int value){
        this.gt_order= value;
    }

    public int getGt_real_money(){
        return gt_real_money;
    }

    public void setGt_real_money(int value){
        this.gt_real_money= value;
    }

    public java.util.Date getEndtime(){
        return endtime;
    }

    public void setEndtime(java.util.Date value){
    	if(value == null){
           value = new java.util.Date();
        }
        this.endtime= value;
    }

    public int getGt_open(){
        return gt_open;
    }

    public void setGt_open(int value){
        this.gt_open= value;
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



    public static Game_task newGame_task(long gt_id, String gt_nd, int gt_type, String gt_name, int gt_money, String gt_seller, String gt_log_url, int gt_rebate, String gt_server, String gt_detail_url, int gt_people, int gt_browse, int gt_order, int gt_real_money, java.util.Date endtime, int gt_open, java.util.Date ctime, String note) {
        Game_task ret = new Game_task();
        ret.setGt_id(gt_id);
        ret.setGt_nd(gt_nd);
        ret.setGt_type(gt_type);
        ret.setGt_name(gt_name);
        ret.setGt_money(gt_money);
        ret.setGt_seller(gt_seller);
        ret.setGt_log_url(gt_log_url);
        ret.setGt_rebate(gt_rebate);
        ret.setGt_server(gt_server);
        ret.setGt_detail_url(gt_detail_url);
        ret.setGt_people(gt_people);
        ret.setGt_browse(gt_browse);
        ret.setGt_order(gt_order);
        ret.setGt_real_money(gt_real_money);
        ret.setEndtime(endtime);
        ret.setGt_open(gt_open);
        ret.setCtime(ctime);
        ret.setNote(note);
        return ret;    
    }

    public void assignment(Game_task game_task) {
        long gt_id = game_task.getGt_id();
        String gt_nd = game_task.getGt_nd();
        int gt_type = game_task.getGt_type();
        String gt_name = game_task.getGt_name();
        int gt_money = game_task.getGt_money();
        String gt_seller = game_task.getGt_seller();
        String gt_log_url = game_task.getGt_log_url();
        int gt_rebate = game_task.getGt_rebate();
        String gt_server = game_task.getGt_server();
        String gt_detail_url = game_task.getGt_detail_url();
        int gt_people = game_task.getGt_people();
        int gt_browse = game_task.getGt_browse();
        int gt_order = game_task.getGt_order();
        int gt_real_money = game_task.getGt_real_money();
        java.util.Date endtime = game_task.getEndtime();
        int gt_open = game_task.getGt_open();
        java.util.Date ctime = game_task.getCtime();
        String note = game_task.getNote();

        this.setGt_id(gt_id);
        this.setGt_nd(gt_nd);
        this.setGt_type(gt_type);
        this.setGt_name(gt_name);
        this.setGt_money(gt_money);
        this.setGt_seller(gt_seller);
        this.setGt_log_url(gt_log_url);
        this.setGt_rebate(gt_rebate);
        this.setGt_server(gt_server);
        this.setGt_detail_url(gt_detail_url);
        this.setGt_people(gt_people);
        this.setGt_browse(gt_browse);
        this.setGt_order(gt_order);
        this.setGt_real_money(gt_real_money);
        this.setEndtime(endtime);
        this.setGt_open(gt_open);
        this.setCtime(ctime);
        this.setNote(note);

    }

    @SuppressWarnings("unused")
    public static void getGame_task(Game_task game_task ){
        long gt_id = game_task.getGt_id();
        String gt_nd = game_task.getGt_nd();
        int gt_type = game_task.getGt_type();
        String gt_name = game_task.getGt_name();
        int gt_money = game_task.getGt_money();
        String gt_seller = game_task.getGt_seller();
        String gt_log_url = game_task.getGt_log_url();
        int gt_rebate = game_task.getGt_rebate();
        String gt_server = game_task.getGt_server();
        String gt_detail_url = game_task.getGt_detail_url();
        int gt_people = game_task.getGt_people();
        int gt_browse = game_task.getGt_browse();
        int gt_order = game_task.getGt_order();
        int gt_real_money = game_task.getGt_real_money();
        java.util.Date endtime = game_task.getEndtime();
        int gt_open = game_task.getGt_open();
        java.util.Date ctime = game_task.getCtime();
        String note = game_task.getNote();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(Game_task game_task){
        long gt_id = game_task.getGt_id();
        String gt_nd = game_task.getGt_nd();
        int gt_type = game_task.getGt_type();
        String gt_name = game_task.getGt_name();
        int gt_money = game_task.getGt_money();
        String gt_seller = game_task.getGt_seller();
        String gt_log_url = game_task.getGt_log_url();
        int gt_rebate = game_task.getGt_rebate();
        String gt_server = game_task.getGt_server();
        String gt_detail_url = game_task.getGt_detail_url();
        int gt_people = game_task.getGt_people();
        int gt_browse = game_task.getGt_browse();
        int gt_order = game_task.getGt_order();
        int gt_real_money = game_task.getGt_real_money();
        java.util.Date endtime = game_task.getEndtime();
        int gt_open = game_task.getGt_open();
        java.util.Date ctime = game_task.getCtime();
        String note = game_task.getNote();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("gt_id",gt_id);
        _ret.put("gt_nd",gt_nd);
        _ret.put("gt_type",gt_type);
        _ret.put("gt_name",gt_name);
        _ret.put("gt_money",gt_money);
        _ret.put("gt_seller",gt_seller);
        _ret.put("gt_log_url",gt_log_url);
        _ret.put("gt_rebate",gt_rebate);
        _ret.put("gt_server",gt_server);
        _ret.put("gt_detail_url",gt_detail_url);
        _ret.put("gt_people",gt_people);
        _ret.put("gt_browse",gt_browse);
        _ret.put("gt_order",gt_order);
        _ret.put("gt_real_money",gt_real_money);
        _ret.put("endtime",endtime);
        _ret.put("gt_open",gt_open);
        _ret.put("ctime",ctime);
        _ret.put("note",note);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Game_task clone2(){
        try{
            return (Game_task) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
