package com.pyb.mvc.action.v1.weixin.order.param;

import apidoc.jxh.cn.TargetComment;
import com.pyb.mvc.action.v1.param.BaseParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 用户退货
 */
public class Param_order_refund extends BaseParam{
    @TargetComment(value = "订单编号",isnull = "否")
    private  String order_id;

    @TargetComment(value = "处理方式0：未指定1：退货退款2：换货3：退款（仅退款不退货）",isnull = "否")
    private  Integer type;//int(11)    处理方式0：未指定1：退货退款2：换货3：退款（仅退款不退货）
    @TargetComment(value = "退货原因：0：未指定1：不想要了2：卖家缺货3：拍错了/订单信息错误4:其它",isnull = "否")
    private Integer sales_return;//int(11)    退货原因：0：未指定1：不想要了2：卖家缺货3：拍错了/订单信息错误4:其它
    @TargetComment(value = "退款说明（选填）",isnull = "是")
    private String sales_return_intro="";//varchar(500)    退款说明（选填）
    @TargetComment(value = "退款金额单位分",isnull = "是")
    private Integer refund_money;//int(11)    退款金额单位分

    @TargetComment(value = "提示信息（例如：你可以退款的最大金额为41.90）",isnull = "是")
    private String notice="";//varchar(150)    提示信息（例如：你可以退款的最大金额为41.90）

    @TargetComment(value = "允许退款最大金额单位分",isnull = "是")
    private Integer allow_refund_money;//int(11)    允许退款最大金额单位分

    @TargetComment(value = "退款系统文字提示",isnull = "是")
    private String refund_info="";//varchar(500)    退款系统文字提示

    public MultipartFile[] multipartfiles;//上传凭证（图片集）

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSales_return() {
        return sales_return;
    }

    public void setSales_return(Integer sales_return) {
        this.sales_return = sales_return;
    }

    public String getSales_return_intro() {
        return sales_return_intro;
    }

    public void setSales_return_intro(String sales_return_intro) {
        this.sales_return_intro = sales_return_intro;
    }

    public Integer getRefund_money() {
        return refund_money;
    }

    public void setRefund_money(Integer refund_money) {
        this.refund_money = refund_money;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public Integer getAllow_refund_money() {
        return allow_refund_money;
    }

    public void setAllow_refund_money(Integer allow_refund_money) {
        this.allow_refund_money = allow_refund_money;
    }

    public String getRefund_info() {
        return refund_info;
    }

    public void setRefund_info(String refund_info) {
        this.refund_info = refund_info;
    }

    public MultipartFile[] getMultipartfiles() {
        return multipartfiles;
    }

    public void setMultipartfiles(MultipartFile[] multipartfiles) {
        this.multipartfiles = multipartfiles;
    }
}
