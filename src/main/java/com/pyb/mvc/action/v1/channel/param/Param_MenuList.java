package com.pyb.mvc.action.v1.channel.param;

import apidoc.jxh.cn.TargetComment;
import com.pyb.mvc.action.v1.param.BaseParam;

/**
 * 获取菜单列表
 * @author jingxiaohu
 *
 */
public class Param_MenuList extends BaseParam {


    @TargetComment(isnull = "否",value = "菜单主键ID")
    public   Long term_id;
    @TargetComment(isnull = "否",value = "菜单英文名称")
    public  String slug;

    public Long getTerm_id() {
        return term_id;
    }

    public void setTerm_id(Long term_id) {
        this.term_id = term_id;
    }
    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
