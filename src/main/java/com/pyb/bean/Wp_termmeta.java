package com.pyb.bean;

import java.io.*;
import java.util.*;

//wp_termmeta
@SuppressWarnings({"serial"})
public class Wp_termmeta implements Cloneable , Serializable{

    //public static String[] carrays ={"meta_id","term_id","meta_key","meta_value"};

    public long meta_id;//bigint(20) unsigned    
    public long term_id;//bigint(20) unsigned    
    public String meta_key="";//varchar(255)    
    public String meta_value="";//longtext    



    public long getMeta_id(){
        return meta_id;
    }

    public void setMeta_id(long value){
        this.meta_id= value;
    }

    public long getTerm_id(){
        return term_id;
    }

    public void setTerm_id(long value){
        this.term_id= value;
    }

    public String getMeta_key(){
        return meta_key;
    }

    public void setMeta_key(String value){
    	if(value == null){
           value = "";
        }
        this.meta_key= value;
    }

    public String getMeta_value(){
        return meta_value;
    }

    public void setMeta_value(String value){
    	if(value == null){
           value = "";
        }
        this.meta_value= value;
    }



    public static Wp_termmeta newWp_termmeta(long meta_id, long term_id, String meta_key, String meta_value) {
        Wp_termmeta ret = new Wp_termmeta();
        ret.setMeta_id(meta_id);
        ret.setTerm_id(term_id);
        ret.setMeta_key(meta_key);
        ret.setMeta_value(meta_value);
        return ret;    
    }

    public void assignment(Wp_termmeta wp_termmeta) {
        long meta_id = wp_termmeta.getMeta_id();
        long term_id = wp_termmeta.getTerm_id();
        String meta_key = wp_termmeta.getMeta_key();
        String meta_value = wp_termmeta.getMeta_value();

        this.setMeta_id(meta_id);
        this.setTerm_id(term_id);
        this.setMeta_key(meta_key);
        this.setMeta_value(meta_value);

    }

    @SuppressWarnings("unused")
    public static void getWp_termmeta(Wp_termmeta wp_termmeta ){
        long meta_id = wp_termmeta.getMeta_id();
        long term_id = wp_termmeta.getTerm_id();
        String meta_key = wp_termmeta.getMeta_key();
        String meta_value = wp_termmeta.getMeta_value();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(Wp_termmeta wp_termmeta){
        long meta_id = wp_termmeta.getMeta_id();
        long term_id = wp_termmeta.getTerm_id();
        String meta_key = wp_termmeta.getMeta_key();
        String meta_value = wp_termmeta.getMeta_value();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("meta_id",meta_id);
        _ret.put("term_id",term_id);
        _ret.put("meta_key",meta_key);
        _ret.put("meta_value",meta_value);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Wp_termmeta clone2(){
        try{
            return (Wp_termmeta) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
