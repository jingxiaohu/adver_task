package com.pyb.mvc.action.v1.weixin.order.param;

import apidoc.jxh.cn.TargetComment;
import com.pyb.mvc.action.v1.param.BaseParam;

public class Param_order_deliver_goods extends BaseParam {
    @TargetComment(value = "订单编号",isnull = "否")
    private  String order_id;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }
}
