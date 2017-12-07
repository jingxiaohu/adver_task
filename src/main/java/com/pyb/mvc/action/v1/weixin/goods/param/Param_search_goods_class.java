package com.pyb.mvc.action.v1.weixin.goods.param;

import apidoc.jxh.cn.TargetComment;
import com.pyb.mvc.action.v1.param.BaseParam;

/**
 * 获取商品信息
 *
 * @author jingxiaohu
 */
public class Param_search_goods_class extends BaseParam {

    //商品类型ID
    @TargetComment(value = "商品类型ID", isnull = "否")
    private Long gt_id;

    public Long getGt_id() {
        return gt_id;
    }

    public void setGt_id(Long gt_id) {
        this.gt_id = gt_id;
    }


}
