package com.pyb.mvc.action.v1.pay.param;

import apidoc.jxh.cn.TargetComment;
import com.pyb.mvc.action.v1.param.BaseParam;

/**
 * 用户充值/商品下单支付
 *
 * @author jingxiaohu
 */
public class Param_wx_charge_jsapi extends BaseParam {
    /********************接收参数区*************************/
    @TargetComment(value = "时间戳ms", isnull = "否")
    public long t;//时间戳ms
    @TargetComment(value = "用户token", isnull = "否")
    public String token;//令牌 用户token
    @TargetComment(value = "用户token", isnull = "是")
    public Integer type;//是支付 还是 充值  0:订单支付 1：充值
    @TargetComment(value = "用户对于微信公众号APPID唯一ID", isnull = "是")
    public String openid;//用户对于微信公众号APPID唯一ID
    /**
     * 商品信息
     */
    @TargetComment(value = "商品主键ID", isnull = "否")
    public Long g_id;//商品主键ID
    @TargetComment(value = "充值金额或者商品价格总计 单位 分", isnull = "否")
    public Integer pay_price;//充值金额或者商品价格总计 单位 分
    @TargetComment(value = "商品购买数量", isnull = "是")
    public Integer num;//购买数量
    /**
     * 收货人信息
     */
    @TargetComment(value = "收货地址", isnull = "否")
    public String address;//收货地址
    @TargetComment(value = "收货人姓名", isnull = "否")
    public String name;//收货人姓名
    @TargetComment(value = "收货人电话号码", isnull = "否")
    public String telephone;//收货人电话号码

    /************************get set 方法区****************************/


    public long getT() {
        return t;
    }

    public void setT(long t) {
        this.t = t;
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public void setToken(String token) {
        this.token = token;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
