package com.pyb.mvc.action.v1.weixin.order.param;

import apidoc.jxh.cn.TargetComment;
import com.pyb.mvc.action.v1.param.BaseParam;

/**
 * 订单信息
 */
public class Param_order extends BaseParam{
    @TargetComment(value = "订单主键ID",isnull = "否")
    private  Long go_id;
    @TargetComment(value = "订单编号",isnull = "否")
    private  String order_id;

    public Long getGo_id() {
        return go_id;
    }

    public void setGo_id(Long go_id) {
        this.go_id = go_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }
}
