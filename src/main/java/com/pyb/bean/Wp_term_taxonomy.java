package com.pyb.bean;

import java.io.*;
import java.util.*;

//wp_term_taxonomy
@SuppressWarnings({"serial"})
public class Wp_term_taxonomy implements Cloneable , Serializable{

    //public static String[] carrays ={"term_taxonomy_id","term_id","taxonomy","description","parent","count"};

    public long term_taxonomy_id;//bigint(20) unsigned    
    public long term_id;//bigint(20) unsigned    
    public String taxonomy="";//varchar(32)    
    public String description="";//longtext    
    public long parent;//bigint(20) unsigned    
    public long count;//bigint(20)    



    public long getTerm_taxonomy_id(){
        return term_taxonomy_id;
    }

    public void setTerm_taxonomy_id(long value){
        this.term_taxonomy_id= value;
    }

    public long getTerm_id(){
        return term_id;
    }

    public void setTerm_id(long value){
        this.term_id= value;
    }

    public String getTaxonomy(){
        return taxonomy;
    }

    public void setTaxonomy(String value){
    	if(value == null){
           value = "";
        }
        this.taxonomy= value;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String value){
    	if(value == null){
           value = "";
        }
        this.description= value;
    }

    public long getParent(){
        return parent;
    }

    public void setParent(long value){
        this.parent= value;
    }

    public long getCount(){
        return count;
    }

    public void setCount(long value){
        this.count= value;
    }



    public static Wp_term_taxonomy newWp_term_taxonomy(long term_taxonomy_id, long term_id, String taxonomy, String description, long parent, long count) {
        Wp_term_taxonomy ret = new Wp_term_taxonomy();
        ret.setTerm_taxonomy_id(term_taxonomy_id);
        ret.setTerm_id(term_id);
        ret.setTaxonomy(taxonomy);
        ret.setDescription(description);
        ret.setParent(parent);
        ret.setCount(count);
        return ret;    
    }

    public void assignment(Wp_term_taxonomy wp_term_taxonomy) {
        long term_taxonomy_id = wp_term_taxonomy.getTerm_taxonomy_id();
        long term_id = wp_term_taxonomy.getTerm_id();
        String taxonomy = wp_term_taxonomy.getTaxonomy();
        String description = wp_term_taxonomy.getDescription();
        long parent = wp_term_taxonomy.getParent();
        long count = wp_term_taxonomy.getCount();

        this.setTerm_taxonomy_id(term_taxonomy_id);
        this.setTerm_id(term_id);
        this.setTaxonomy(taxonomy);
        this.setDescription(description);
        this.setParent(parent);
        this.setCount(count);

    }

    @SuppressWarnings("unused")
    public static void getWp_term_taxonomy(Wp_term_taxonomy wp_term_taxonomy ){
        long term_taxonomy_id = wp_term_taxonomy.getTerm_taxonomy_id();
        long term_id = wp_term_taxonomy.getTerm_id();
        String taxonomy = wp_term_taxonomy.getTaxonomy();
        String description = wp_term_taxonomy.getDescription();
        long parent = wp_term_taxonomy.getParent();
        long count = wp_term_taxonomy.getCount();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(Wp_term_taxonomy wp_term_taxonomy){
        long term_taxonomy_id = wp_term_taxonomy.getTerm_taxonomy_id();
        long term_id = wp_term_taxonomy.getTerm_id();
        String taxonomy = wp_term_taxonomy.getTaxonomy();
        String description = wp_term_taxonomy.getDescription();
        long parent = wp_term_taxonomy.getParent();
        long count = wp_term_taxonomy.getCount();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("term_taxonomy_id",term_taxonomy_id);
        _ret.put("term_id",term_id);
        _ret.put("taxonomy",taxonomy);
        _ret.put("description",description);
        _ret.put("parent",parent);
        _ret.put("count",count);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Wp_term_taxonomy clone2(){
        try{
            return (Wp_term_taxonomy) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
