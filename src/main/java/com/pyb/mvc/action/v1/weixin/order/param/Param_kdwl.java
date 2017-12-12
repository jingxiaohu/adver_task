package com.pyb.mvc.action.v1.weixin.order.param;

import apidoc.jxh.cn.TargetComment;
import com.pyb.mvc.action.v1.param.BaseParam;

/**
 *  快递物流信息
 */
public class Param_kdwl extends BaseParam{
    /*@TargetComment(value = "快递公司编号",isnull = "否")
    private String expCode;
    @TargetComment(value = "快递单号",isnull = "否")
    private String expNo;*/
    @TargetComment(value = "订单编号",isnull = "否")
    private  String order_id;

    public String getOrder_id() {
        return order_id;
    }



    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }
}
