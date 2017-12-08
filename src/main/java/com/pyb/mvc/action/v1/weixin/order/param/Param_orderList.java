package com.pyb.mvc.action.v1.weixin.order.param;

import apidoc.jxh.cn.TargetComment;
import com.pyb.mvc.action.v1.param.BaseParam;

/**
 * 获取用户订单列表
 */
public class Param_orderList extends BaseParam{
    @TargetComment(value = "订单状态 0：待付款 1：待发货 2：待收货 3：已完成",isnull = "是")
    private Integer state;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
