package com.pyb.mvc.action.v1.weixin.user.param;

import apidoc.jxh.cn.TargetComment;
import com.pyb.mvc.action.v1.param.BaseParam;

/**
 * 合作人提现
 */
public class Param_user_withdraw extends BaseParam {
    @TargetComment(value = "提现金额 单位分",isnull = "否")
    private  Integer  money;//提现金额 单位分

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
