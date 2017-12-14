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
     * 收货人信息
     */
    @TargetComment(value = "收货地址", isnull = "否")
    public String address;//收货地址
    @TargetComment(value = "收货人姓名", isnull = "否")
    public String name;//收货人姓名
    @TargetComment(value = "收货人电话号码", isnull = "否")
    public String telephone;//收货人电话号码

    /**
     * 商品相关
     */
    @TargetComment(value = "商品列表JSONARRAY数组字符串[{\"clothing\":\"{\\\"size\\\":[ 120,130,140,150],\\\"color\\\":[\\\"黄色\\\",\\\"红色\\\",\\\"蓝色\\\"]}\",\"g_id\":1,\"num\":2,\"pay_price\":51}]", isnull = "是")
    String goods_list = null;
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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
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

    public String getGoods_list() {
        return goods_list;
    }

    public void setGoods_list(String goods_list) {
        this.goods_list = goods_list;
    }
}
