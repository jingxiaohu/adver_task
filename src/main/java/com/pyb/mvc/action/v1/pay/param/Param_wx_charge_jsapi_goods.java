package com.pyb.mvc.action.v1.pay.param;

import apidoc.jxh.cn.TargetComment;

import java.io.Serializable;

public class Param_wx_charge_jsapi_goods implements Serializable{
    /**
     * 商品信息
     */
    @TargetComment(value = "商品主键ID", isnull = "否")
    public Long g_id;//商品主键ID
    @TargetComment(value = "充值金额或者商品价格总计 单位 分", isnull = "否")
    public Integer pay_price;//充值金额或者商品价格总计 单位 分
    @TargetComment(value = "商品购买数量", isnull = "是")
    public Integer num;//购买数量

    @TargetComment(value = "服装类商品尺码颜色JSON{\"size\":[ 120,130,140,150],\"color\":[\"黄色\",\"红色\",\"蓝色\"]}", isnull = "是")
    public String clothing;//服装类商品尺码颜色JSON{"size":[ 120,130,140,150],"color":["黄色","红色","蓝色"]}

    public Long getG_id() {
        return g_id;
    }

    public void setG_id(Long g_id) {
        this.g_id = g_id;
    }

    public Integer getPay_price() {
        return pay_price;
    }

    public void setPay_price(Integer pay_price) {
        this.pay_price = pay_price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getClothing() {
        return clothing;
    }

    public void setClothing(String clothing) {
        this.clothing = clothing;
    }
}
