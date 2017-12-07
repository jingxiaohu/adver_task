package com.pyb.mvc.action.v1.weixin.goods.param;

import apidoc.jxh.cn.TargetComment;
import com.pyb.mvc.action.v1.param.BaseParam;

/**
 * 商品详细信息
 */
public class Param_goods_info extends BaseParam {

    @TargetComment(value = "商品ID", isnull = "否")
    private Long g_id;

    public Long getG_id() {
        return g_id;
    }

    public void setG_id(Long g_id) {
        this.g_id = g_id;
    }
}
