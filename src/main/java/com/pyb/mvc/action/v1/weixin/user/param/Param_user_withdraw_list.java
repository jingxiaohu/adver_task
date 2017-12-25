package com.pyb.mvc.action.v1.weixin.user.param;

import apidoc.jxh.cn.TargetComment;
import com.pyb.mvc.action.v1.param.BaseParam;

/**
 * 获取用户提现明细列表
 */
public class Param_user_withdraw_list extends BaseParam {

    @TargetComment(value = "打款状态(0:未打款 1：打款成功 2：打款失败信息不吻合)",isnull = "是")
    private  Integer  state;//打款状态(0:未打款 1：打款成功 2：打款失败信息不吻合)

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
