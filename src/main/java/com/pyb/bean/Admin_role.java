package com.pyb.bean;

import java.io.*;
import java.util.*;

//admin_role
@SuppressWarnings({"serial"})
public class Admin_role implements Cloneable , Serializable{

    //public static String[] carrays ={"ar_id","ri_id","au_id"};

    public long ar_id;//bigint(20)    
    public long ri_id;//bigint(20)    
    public long au_id;//bigint(20)    



    public long getAr_id(){
        return ar_id;
    }

    public void setAr_id(long value){
        this.ar_id= value;
    }

    public long getRi_id(){
        return ri_id;
    }

    public void setRi_id(long value){
        this.ri_id= value;
    }

    public long getAu_id(){
        return au_id;
    }

    public void setAu_id(long value){
        this.au_id= value;
    }



    public static Admin_role newAdmin_role(long ar_id, long ri_id, long au_id) {
        Admin_role ret = new Admin_role();
        ret.setAr_id(ar_id);
        ret.setRi_id(ri_id);
        ret.setAu_id(au_id);
        return ret;    
    }

    public void assignment(Admin_role admin_role) {
        long ar_id = admin_role.getAr_id();
        long ri_id = admin_role.getRi_id();
        long au_id = admin_role.getAu_id();

        this.setAr_id(ar_id);
        this.setRi_id(ri_id);
        this.setAu_id(au_id);

    }

    @SuppressWarnings("unused")
    public static void getAdmin_role(Admin_role admin_role ){
        long ar_id = admin_role.getAr_id();
        long ri_id = admin_role.getRi_id();
        long au_id = admin_role.getAu_id();
    }

    public Map<String,Object> toMap(){
        return toEnMap(this);
    }

    public static Map<String,Object> toEnMap(Admin_role admin_role){
        long ar_id = admin_role.getAr_id();
        long ri_id = admin_role.getRi_id();
        long au_id = admin_role.getAu_id();
    
        Map<String,Object>  _ret = new HashMap<String,Object>();
        _ret.put("ar_id",ar_id);
        _ret.put("ri_id",ri_id);
        _ret.put("au_id",au_id);
        return _ret;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Admin_role clone2(){
        try{
            return (Admin_role) this.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
