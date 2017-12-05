package com.pyb.mvc.action.v1.weixin.goods.param;

import com.pyb.mvc.action.v1.param.BaseParam;

/**
 * 获取商品信息
 * @author jingxiaohu
 *
 */
public class Param_search_goods extends BaseParam {
    //商品名称
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
