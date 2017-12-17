package com.pyb.mvc.action.v1.user.param;

import apidoc.jxh.cn.TargetComment;
import com.pyb.mvc.action.v1.param.BaseParam;

/**
 * 删除地址
 */
public class Param_del_Address extends BaseParam{
    @TargetComment(value = "主键ID",isnull = "是")
    private Long ua_id;//主键ID
    @TargetComment(value = "是否设置为默认地址 0：不是  1:是",isnull = "是")
    private  Integer is_defaut;//是否设置为默认地址 0：不是  1:是


    public Long getUa_id() {
        return ua_id;
    }

    public void setUa_id(Long ua_id) {
        this.ua_id = ua_id;
    }

    public Integer getIs_defaut() {
        return is_defaut;
    }

    public void setIs_defaut(Integer is_defaut) {
        this.is_defaut = is_defaut;
    }
}
