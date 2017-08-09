package com.pyb.mvc.action.v1.message.param;

import apidoc.jxh.cn.TargetComment;
import com.pyb.mvc.action.v1.param.BaseParam;

/**
 * 获取直播信息
 * @author jingxiaohu
 *
 */
public class Param_liveinfo extends BaseParam {
	/********************接收参数区*************************/
	@TargetComment(value = "直播频道ID",isnull = "否")
	public String ci_id;
	@TargetComment(value = "直播消息ID",isnull = "是")
	public String mi_id;
	@TargetComment(value = "0:表示向上取 1：表示向下取",isnull = "是")
	public int type;
	/************************get set 方法区****************************/
	public String getCi_id() {
		return ci_id;
	}

	public void setCi_id(String ci_id) {
		this.ci_id = ci_id;
	}

	public String getMi_id() {
		return mi_id;
	}

	public void setMi_id(String mi_id) {
		this.mi_id = mi_id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
