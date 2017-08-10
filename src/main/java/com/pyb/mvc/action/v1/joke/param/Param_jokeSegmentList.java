package com.pyb.mvc.action.v1.joke.param;

import apidoc.jxh.cn.TargetComment;
import com.pyb.mvc.action.v1.param.BaseParam;

/**
 * 获取joke 某个分类里面的段子信息
 * @author jingxiaohu
 *
 */
public class Param_jokeSegmentList extends BaseParam {
    @TargetComment(value = "joke 分类ID",isnull = "否")
    public long jc_id;
//    public long js_id;//joke_segment ID
    @TargetComment(value = "0：浏览次数排序  1：按点赞次数排序",isnull = "是")
    public int type;

    public long getJc_id() {
        return jc_id;
    }

    public void setJc_id(long jc_id) {
        this.jc_id = jc_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
