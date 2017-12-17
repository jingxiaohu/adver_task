package com.pyb.mvc.action.v1.user.param;

import apidoc.jxh.cn.TargetComment;
import com.pyb.mvc.action.v1.param.BaseParam;

/**
 * 添加地址
 */
public class Param_addOrUpdate_Address extends BaseParam{
    @TargetComment(value = "主键ID",isnull = "是")
    private Long ua_id;//主键ID
    @TargetComment(value = "用户名字",isnull = "否")
    private  String name;//用户名字
    @TargetComment(value = "电话号码",isnull = "否")
    private  String telephone;//电话号码
    @TargetComment(value = "所在地区（四川省 成都市  龙泉驿区）",isnull = "否")
    private  String area;//所在地区（四川省 成都市  龙泉驿区）
    @TargetComment(value = "详细地址",isnull = "否")
    private  String address;//详细地址
    @TargetComment(value = "是否设置为默认地址 0：不是  1:是",isnull = "是")
    private  Integer is_defaut;//是否设置为默认地址 0：不是  1:是

    public Long getUa_id() {
        return ua_id;
    }

    public void setUa_id(Long ua_id) {
        this.ua_id = ua_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getIs_defaut() {
        return is_defaut;
    }

    public void setIs_defaut(Integer is_defaut) {
        this.is_defaut = is_defaut;
    }
}
