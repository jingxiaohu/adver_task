package com.pyb.mvc.action.v1.weixin.goods.param;

import apidoc.jxh.cn.TargetComment;
import com.pyb.mvc.action.v1.param.BaseParam;

/**
 * 商品信息列表获取
 */
public class Param_goods_list extends BaseParam {
    @TargetComment(value = "查询方式 0：促销商品类型 1：热卖商品类型  2：限时抢购商品类型 3：推荐商品类型 4:卖家包邮商品类型 5:新品上市商品类型", isnull = "否")
    private  Integer type;//查询方式 0：促销商品类型 1：热卖商品类型  2：限时抢购商品类型 3：推荐商品类型 4:卖家包邮商品类型 5:新品上市商品类型


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }



}
