package com.pyb.bean;

import java.io.*;
import java.util.*;

//message_info
@SuppressWarnings({"serial"})
public class Message_info implements Cloneable , Serializable{

    //public static String[] carrays ={"mi_id","ui_id","mi_title","mi_link_id","mi_content","mi_type","mi_image","mi_pl_count","mi_read_count","mi_zan","mi_latlng","mi_flag","mi_gis","mi_model","mi_address","mi_app","mi_createtime","mi_uptime","mi_area","mi_order","note"};

    public long mi_id;//bigint(20)    
    public long ui_id;//bigint(20)    创建用户
    public String mi_title="";//varchar(300)    消息标题
    public long mi_link_id;//bigint(20)    关联消息ID如果是评论则为原文的ID如果是转播则为原文的ID如果-1，则表示源消息已经被删除
    public String mi_content="";//text    消息内容
    public String mi_type="";//varchar(10)    标记消息类型0:原创1:评论2：回复
    public String mi_image="";//varchar(250)    消息图片
    public long mi_pl_count;//bigint(20)    
    public long mi_read_count;//bigint(20)    
    public long mi_zan;//bigint(20)    
    public String mi_latlng="";//varchar(50)    
    public int mi_flag;//int(11)    信息来源的标记0Web1Android2Iphone3PC客服端4新浪5腾讯6人人
    public String mi_gis="";//varchar(250)    
    public String mi_model="";//varchar(150)    设备型号
    public String mi_address="";//varchar(250)    
    public int mi_app;//int(11)    0股票项目1音频项目
    public long mi_createtime;//bigint(20)    创建时间
    public long mi_uptime;//bigint(20)    最后评论时间
    public int mi_area;//int(11)    帖子发送目标地方：0自己看1：广播
    public long mi_order;//bigint(20)    帖子权重比:越大权重比越高
    public String note="";//varchar(255)    



    public long getMi_id(){
        return mi_id;
    }

    public void setMi_id(long value){
        this.mi_id= value;
    }

    public long getUi_id(){
        return ui_id;
    }

    public void setUi_id(long value){
        this.ui_id= value;
    }

    public String getMi_title(){
        return mi_title;
    }

    public void setMi_title(String value){
    	if(value == null){
           value = "";
        }
        this.mi_title= value;
    }

    public long getMi_link_id(){
        return mi_link_id;
    }

    public void setMi_link_id(long value){
        this.mi_link_id= value;
    }

    public String getMi_content(){
        return mi_content;
    }

    public void setMi_content(String value){
    	if(value == null){
           value = "";
        }
        this.mi_content= value;
    }

    public String getMi_type(){
        return mi_type;
    }

    public void setMi_type(String value){
    	if(value == null){
           value = "";
        }
        this.mi_type= value;
    }

    public String getMi_image(){
        return mi_image;
    }

    public void setMi_image(String value){
    	if(value == null){
           value = "";
        }
        this.mi_image= value;
    }

    public long getMi_pl_count(){
        return mi_pl_count;
    }

    public void setMi_pl_count(long value){
        this.mi_pl_count= value;
    }

    public long getMi_read_count(){
        return mi_read_count;
    }

    public void setMi_read_count(long value){
        this.mi_read_count= value;
    }

    public long getMi_zan(){
        return mi_zan;
    }

    public void setMi_zan(long value){
        this.mi_zan= value;
    }

    public String getMi_latlng(){
        return mi_latlng;
    }

    public void setMi_latlng(String value){
    	if(value == null){
           value = "";
        }
        this.mi_latlng= value;
    }

    public int getMi_flag(){
        return mi_flag;
    }

    public void setMi_flag(int value){
        this.mi_flag= value;
    }

    public String getMi_gis(){
        return mi_gis;
    }

    public void setMi_gis(String value){
    	if(value == null){
           value = "";
        }
        this.mi_gis= value;
    }

    public String getMi_model(){
        return mi_model;
    }

    public void setMi_model(String value){
    	if(value == null){
           value = "";
        }
        this.mi_model= value;
    }

    public String getMi_address(){
        return mi_address;
    }

    public void setMi_address(String value){
    	if(value == null){
           value = "";
        }
        this.mi_address= value;
    }

    public int getMi_app(){
        return mi_app;
    }

    public void setMi_app(int value){
        this.mi_app= value;
    }

    public long getMi_createtime(){
        return mi_createtime;
    }

    public void setMi_createtime(long value){
        this.mi_createtime= value;
    }

    public long getMi_uptime(){
        return mi_uptime;
    }

    public void setMi_uptime(long value){
        this.mi_uptime= value;
    }

    public int getMi_area(){
        return mi_area;
    }

    public void setMi_area(int value){
        this.mi_area= value;
    }

    public long getMi_order(){
        return mi_order;
    }

    public void setMi_order(long value){
        this.mi_order= value;
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



    public static Message_info newMessage_info(long mi_id, long ui_id, String mi_title, long mi_link_id, String mi_content, String mi_type, String mi_image, long mi_pl_count, long mi_read_count, long mi_zan, String mi_latlng, int mi_flag, String mi_gis, String mi_model, String mi_address, int mi_app, long mi_createtime, long mi_uptime, int mi_area, long mi_order, String note) {
        Message_info ret = new Message_info();
        ret.setMi_id(mi_id);
        ret.setUi_id(ui_id);
        ret.setMi_title(mi_title);
        ret.setMi_link_id(mi_link_id);
        ret.setMi_content(mi_content);
        ret.setMi_type(mi_type);
        ret.setMi_image(mi_image);
        ret.setMi_pl_count(mi_pl_count);
        ret.setMi_read_count(mi_read_count);
        ret.setMi_zan(mi_zan);
        ret.setMi_latlng(mi_latlng);
        ret.setMi_flag(mi_flag);
        ret.setMi_gis(mi_gis);
        ret.setMi_model(mi_model);
        ret.setMi_address(mi_address);
        ret.setMi_app(mi_app);
        ret.setMi_createtime(mi_createtime);
        ret.setMi_uptime(mi_uptime);
        ret.setMi_area(mi_area);
        ret.setMi_order(mi_order);
        ret.setNote(note);
        return ret;    
    }

    public void assignment(Message_info message_info) {
        long mi_id = message_info.getMi_id();
        long ui_id = message_info.getUi_id();
        String mi_title = message_info.getMi_title();
        long mi_link_id = message_info.getMi_link_id();
        String mi_content = message_info.getMi_content();
        String mi_type = message_info.getMi_type();
        String mi_image = message_info.getMi_image();
        long mi_pl_count = message_info.getMi_pl_count();
        long mi_read_count = message_info.getMi_read_count();
        long mi_zan = message_info.getMi_zan();
        String mi_latlng = message_info.getMi_latlng();
        int mi_flag = message_info.getMi_flag();
        String mi_gis = message_info.getMi_gis();
        String mi_model = message_info.getMi_model();
        String mi_address = message_info.getMi_address();
        int mi_app = message_info.getMi_app();
        long mi_createtime = message_info.getMi_createtime();
        long mi_uptime = message_info.getMi_uptime();
        int mi_area = message_info.getMi_area();
        long mi_order = message_info.getMi_order();
        String note = message_info.getNote();

        this.setMi_id(mi_id);
        this.setUi_id(ui_id);
        this.setMi_title(mi_title);
        this.setMi_link_id(mi_link_id);
        this.setMi_content(mi_content);
        this.setMi_type(mi_type);
        this.setMi_image(mi_image);
        this.setMi_pl_count(mi_pl_count);
        this.setMi_read_count(mi_read_count);
        this.setMi_zan(mi_zan);
        this.setMi_latlng(mi_latlng);
        this.setMi_flag(mi_flag);
        this.setMi_gis(mi_gis);
        this.setMi_model(mi_model);
        this.setMi_address(mi_address);
        this.setMi_app(mi_app);
        this.setMi_createtime(mi_createtime);
        this.setMi_uptime(mi_uptime);
        this.setMi_area(mi_area);
        this.setMi_order(mi_order);
        this.setNote(note);

    }

    @SuppressWarnings("unused")
    public static void getMessage_info(Message_info message_info ){
        long mi_id = message_info.getMi_id();
        long ui_id = message_info.getUi_id();
        String mi_title = message_info.getMi_title();
        long mi_link_id = message_info.getMi_link_id();
        String mi_content = message_info.getMi_content();
        String mi_type = message_info.getMi_type();
        String mi_image = message_info.getMi_image();
        long mi_pl_count = message_info.getMi_pl_count();
        long mi_read_count = message_info.getMi_read_count();
        long mi_zan = message_info.getMi_zan();
        String mi_latlng = message_info.getMi_latlng();
        int mi_flag = message_info.getMi_flag();
        String mi_gis = message_info.getMi_gis();
        String mi_model = message_info.getMi_model();
        String mi_address = message_info.getMi_address();
        int mi_app = message_info.getMi_app();
        long mi_createtime = message_info.getMi_createtime();
        long mi_uptime = message_info.getMi_uptime();
        int mi_area = message_info.getMi_area();
        long mi_order = message_info.getMi_order();
        String note = message_info.getNote();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(Message_info message_info){
        long mi_id = message_info.getMi_id();
        long ui_id = message_info.getUi_id();
        String mi_title = message_info.getMi_title();
        long mi_link_id = message_info.getMi_link_id();
        String mi_content = message_info.getMi_content();
        String mi_type = message_info.getMi_type();
        String mi_image = message_info.getMi_image();
        long mi_pl_count = message_info.getMi_pl_count();
        long mi_read_count = message_info.getMi_read_count();
        long mi_zan = message_info.getMi_zan();
        String mi_latlng = message_info.getMi_latlng();
        int mi_flag = message_info.getMi_flag();
        String mi_gis = message_info.getMi_gis();
        String mi_model = message_info.getMi_model();
        String mi_address = message_info.getMi_address();
        int mi_app = message_info.getMi_app();
        long mi_createtime = message_info.getMi_createtime();
        long mi_uptime = message_info.getMi_uptime();
        int mi_area = message_info.getMi_area();
        long mi_order = message_info.getMi_order();
        String note = message_info.getNote();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("mi_id",mi_id);
        _ret.put("ui_id",ui_id);
        _ret.put("mi_title",mi_title);
        _ret.put("mi_link_id",mi_link_id);
        _ret.put("mi_content",mi_content);
        _ret.put("mi_type",mi_type);
        _ret.put("mi_image",mi_image);
        _ret.put("mi_pl_count",mi_pl_count);
        _ret.put("mi_read_count",mi_read_count);
        _ret.put("mi_zan",mi_zan);
        _ret.put("mi_latlng",mi_latlng);
        _ret.put("mi_flag",mi_flag);
        _ret.put("mi_gis",mi_gis);
        _ret.put("mi_model",mi_model);
        _ret.put("mi_address",mi_address);
        _ret.put("mi_app",mi_app);
        _ret.put("mi_createtime",mi_createtime);
        _ret.put("mi_uptime",mi_uptime);
        _ret.put("mi_area",mi_area);
        _ret.put("mi_order",mi_order);
        _ret.put("note",note);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Message_info clone2(){
        try{
            return (Message_info) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
