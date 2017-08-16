package com.pyb.bean;

import java.io.*;
import java.util.*;

//wp_terms
@SuppressWarnings({"serial"})
public class Wp_terms implements Cloneable , Serializable{

    //public static String[] carrays ={"term_id","name","slug","term_group"};

    public long term_id;//bigint(20) unsigned    
    public String name="";//varchar(200)    
    public String slug="";//varchar(200)    
    public long term_group;//bigint(10)    



    public long getTerm_id(){
        return term_id;
    }

    public void setTerm_id(long value){
        this.term_id= value;
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

    public String getSlug(){
        return slug;
    }

    public void setSlug(String value){
    	if(value == null){
           value = "";
        }
        this.slug= value;
    }

    public long getTerm_group(){
        return term_group;
    }

    public void setTerm_group(long value){
        this.term_group= value;
    }



    public static Wp_terms newWp_terms(long term_id, String name, String slug, long term_group) {
        Wp_terms ret = new Wp_terms();
        ret.setTerm_id(term_id);
        ret.setName(name);
        ret.setSlug(slug);
        ret.setTerm_group(term_group);
        return ret;    
    }

    public void assignment(Wp_terms wp_terms) {
        long term_id = wp_terms.getTerm_id();
        String name = wp_terms.getName();
        String slug = wp_terms.getSlug();
        long term_group = wp_terms.getTerm_group();

        this.setTerm_id(term_id);
        this.setName(name);
        this.setSlug(slug);
        this.setTerm_group(term_group);

    }

    @SuppressWarnings("unused")
    public static void getWp_terms(Wp_terms wp_terms ){
        long term_id = wp_terms.getTerm_id();
        String name = wp_terms.getName();
        String slug = wp_terms.getSlug();
        long term_group = wp_terms.getTerm_group();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(Wp_terms wp_terms){
        long term_id = wp_terms.getTerm_id();
        String name = wp_terms.getName();
        String slug = wp_terms.getSlug();
        long term_group = wp_terms.getTerm_group();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("term_id",term_id);
        _ret.put("name",name);
        _ret.put("slug",slug);
        _ret.put("term_group",term_group);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Wp_terms clone2(){
        try{
            return (Wp_terms) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
