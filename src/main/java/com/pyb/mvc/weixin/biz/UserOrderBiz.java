package com.pyb.mvc.weixin.biz;

import com.alibaba.fastjson.JSONObject;
import com.pyb.bean.ReturnDataNew;
import com.pyb.bean.Wx_after_sale;
import com.pyb.bean.Wx_goods_order;
import com.pyb.bean.Wx_order_goods;
import com.pyb.constants.Constants;
import com.pyb.mvc.action.v1.weixin.order.param.Param_kdwl;
import com.pyb.mvc.action.v1.weixin.order.param.Param_order;
import com.pyb.mvc.action.v1.weixin.order.param.Param_orderList;
import com.pyb.mvc.action.v1.weixin.order.param.Param_order_refund;
import com.pyb.mvc.weixin.util.KdniaoTrackQueryAPI;
import com.pyb.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 用户订单管理
 */
@Service
public class UserOrderBiz extends  BaseWxBiz{
    @Autowired
    KdniaoTrackQueryAPI kdniaoTrackQueryAPI;






    /**
     * 获取用户推广明细订单列表
     */
    public void GainRecommendUserOrderList(ReturnDataNew returnData, Param_orderList param) {
        try {
            int page = param.getPage();
            int size = param.getSize();
            int start = (page - 1) * size;

            String sql = "";
            List<Wx_goods_order> list = null;
            if(param.getState() == null){
                //全部查询
                sql = "select * from wx_goods_order where recommend_id=? and is_del=0 order by ctime desc limit " + start + "," + size;
                list = getDB().queryListT(sql,Wx_goods_order.class,param.getUi_id());
            }else{
                //分情况查询
                sql = "select * from wx_goods_order where recommend_id=? and state=? and is_del=0 order by ctime desc limit " + start + "," + size;
                list = getDB().queryListT(sql,Wx_goods_order.class,param.getUi_id(),param.getState());
            }
            returnData.setReturnData(errorcode_success, "获取用户推广明细订单列表成功", list);
        } catch (Exception e) {
            log.error("UserOrderBiz GainRecommendUserOrderList is error", e);
            returnData.setReturnData(errorcode_systerm, "UserOrderBiz GainRecommendUserOrderList is error", "");
        }
    }





    /**
     * 获取我的订单列表
     */
    public void GainUserOrderList(ReturnDataNew returnData, Param_orderList param) {
        try {
            int page = param.getPage();
            int size = param.getSize();
            int start = (page - 1) * size;

            String sql = "";
            List<Wx_goods_order> list = null;
            if(param.getState() == null){
                //全部查询
                sql = "select * from wx_goods_order where ui_id=? and is_del=0 order by ctime desc limit " + start + "," + size;
                list = getDB().queryListT(sql,Wx_goods_order.class,param.getUi_id());
            }else{
                //分情况查询
                sql = "select * from wx_goods_order where ui_id=? and state=? and is_del=0 order by ctime desc limit " + start + "," + size;
                list = getDB().queryListT(sql,Wx_goods_order.class,param.getUi_id(),param.getState());
            }

            /*if(list != null && list.size() > 0){
                //遍历订单列表 获取 订单对应的商品数据



            }*/



            returnData.setReturnData(errorcode_success, "获取我的订单列表成功", list);
        } catch (Exception e) {
            log.error("UserOrderBiz GainUserOrderList is error", e);
            returnData.setReturnData(errorcode_systerm, "UserOrderBiz GainUserOrderList is error", "");
        }
    }
    /**
     * 用户获取订单详情
     */
    public void GainOrderInfo(ReturnDataNew returnData, Param_order param) {
        try {
            String sql = "select * from wx_goods_order where go_id=?  and ui_id=? limit 1";
            Wx_goods_order wx_goods_order = getDB().queryUniqueT(sql,Wx_goods_order.class,param.getGo_id(),param.getUi_id());
            returnData.setReturnData(errorcode_success, "用户获取订单详情成功", wx_goods_order);
        } catch (Exception e) {
            log.error("UserOrderBiz GainOrderInfo is error", e);
            returnData.setReturnData(errorcode_systerm, "UserOrderBiz GainOrderInfo is error", "");
        }
    }
    /**
     * 获取用户订单对应商品列表
     */
    public void GainOrderInfoGoods(ReturnDataNew returnData, Param_order param) {
        try {
            JSONObject obj = new JSONObject();
            obj.put("order_info","");//订单信息
            obj.put("order_goods","");//订单信息对应的商品列表

            String sql = "select * from wx_goods_order where go_id=?  and ui_id=? limit 1";
            Wx_goods_order wx_goods_order = getDB().queryUniqueT(sql,Wx_goods_order.class,param.getGo_id(),param.getUi_id());
            if(wx_goods_order == null){
                obj.put("order_info","");//订单信息
            }else{
                obj.put("order_info",wx_goods_order);//订单信息
            }
            sql = "select * from wx_order_goods where  order_id=?";
            List<Wx_order_goods> list = getDB().queryListT(sql,Wx_order_goods.class,wx_goods_order.getOrder_id());
            if(list == null){
                obj.put("order_goods","");//订单信息对应的商品列表
            }else{
                obj.put("order_goods",list);//订单信息对应的商品列表
            }
            returnData.setReturnData(errorcode_success, "获取用户订单对应商品列表成功", obj);
        } catch (Exception e) {
            log.error("UserOrderBiz GainOrderInfoGoods is error", e);
            returnData.setReturnData(errorcode_systerm, "UserOrderBiz GainOrderInfoGoods is error", "");
        }
    }
    /**
     * 用户取消订单
     */
    public void UserCancelOrder(ReturnDataNew returnData, Param_order param) {
        try {
            String sql = "select * from wx_goods_order where go_id=? and order_id=? and ui_id=? limit 1";
            Wx_goods_order wx_goods_order = getDB().queryUniqueT(sql,Wx_goods_order.class,param.getGo_id(),param.getOrder_id(),param.getUi_id());
            if(wx_goods_order == null){
                returnData.setReturnData(errorcode_data, "订单不存在", "","1");
                return;
            }
            wx_goods_order.setIs_del(1);
            int count = daoFactory.getWx_goods_orderDao().updateByKey(wx_goods_order);
            if(count != 1){
                returnData.setReturnData(errorcode_data, "订单取消失败", "","2");
                return;
            }
            returnData.setReturnData(errorcode_success, "用户取消订单成功", "");
        } catch (Exception e) {
            log.error("UserOrderBiz UserCancelOrder is error", e);
            returnData.setReturnData(errorcode_systerm, "UserOrderBiz UserCancelOrder is error", "");
        }
    }


    /**
     * 用户获取订单快递物流情况
     */
    public void GainOrderKDWL(ReturnDataNew returnData, Param_kdwl param) {
        try {
            String sql = "select * from wx_goods_order where order_id=? limit 1";
            Wx_goods_order wx_goods_order = getDB().queryUniqueT(sql,Wx_goods_order.class,param.getOrder_id());
            if(wx_goods_order == null){
                returnData.setReturnData(errorcode_data, "订单不存在", "","1");
                return;
            }
            String str = kdniaoTrackQueryAPI.getOrderTracesByJson(wx_goods_order.getShipper_code(),wx_goods_order.getLogistic_code());
            returnData.setReturnData(errorcode_success, "用户获取订单快递物流情况成功", str);
        } catch (Exception e) {
            log.error("UserOrderBiz GainOrderKDWL is error", e);
            returnData.setReturnData(errorcode_systerm, "UserOrderBiz GainOrderKDWL is error", "");
        }
    }



    /**
     * 用户确认收货
     */
    public void UserOrderSure(ReturnDataNew returnData, Param_order param) {
        try {
            String sql = "select * from wx_goods_order where go_id=? and order_id=? and ui_id=? limit 1";
            Wx_goods_order wx_goods_order = getDB().queryUniqueT(sql,Wx_goods_order.class,param.getGo_id(),param.getOrder_id(),param.getUi_id());
            if(wx_goods_order == null){
                returnData.setReturnData(errorcode_data, "订单不存在", "","1");
                return;
            }
            //订单状态 0：待付款 1：待发货 2：待收货 3：已完成
            if(wx_goods_order.getState() == 3){
                returnData.setReturnData(errorcode_data, "你已经确认过了", "","2");
                return;
            }
            wx_goods_order.setState(3);
            int count = daoFactory.getWx_goods_orderDao().updateByKey(wx_goods_order);
            if(count != 1){
                returnData.setReturnData(errorcode_data, "用户确认收货失败", "","3");
                return;
            }
            returnData.setReturnData(errorcode_success, "用户确认收货成功", "");
        } catch (Exception e) {
            log.error("UserOrderBiz UserOrderSure is error", e);
            returnData.setReturnData(errorcode_systerm, "UserOrderBiz UserOrderSure is error", "");
        }
    }
    /**
     * 用户退货或者退款
     */
    public void order_refund(ReturnDataNew returnData, Param_order_refund param) {
        try {
            String sql = "select * from wx_after_sale where order_id=? and ui_id=? and is_del=0 limit 1";
            Wx_goods_order wx_goods_order = getDB().queryUniqueT(sql,Wx_goods_order.class,param.getOrder_id(),param.getUi_id());
            if(wx_goods_order != null){
                returnData.setReturnData(errorcode_data, "该笔订单已经申诉过了", "","1");
                return;
            }

            Wx_after_sale after_sale = new Wx_after_sale();
            after_sale.setUi_id(param.getUi_id());
            after_sale.setOrder_id(param.getOrder_id());
            after_sale.setType(param.getType());
            after_sale.setSales_return(param.getSales_return());

            if(param.getAllow_refund_money() != null){
                //允许退款最大金额单位分
                after_sale.setAllow_refund_money(param.getAllow_refund_money());
            }
            if(param.getNotice() != null){
                after_sale.setNotice(param.getNotice());
            }
            if(param.getRefund_info() != null){
                after_sale.setRefund_info(param.getRefund_info());
            }
            if(param.getRefund_money() != null){
                after_sale.setRefund_money(param.getRefund_money());
            }
            if(param.getSales_return_intro() != null){
                after_sale.setSales_return_intro(param.getSales_return_intro());
            }
            if(param.getMultipartfiles() != null){
                StringBuffer sb = new StringBuffer();
                //图片进行轮询 获取
                MultipartFile[] multipartfiles = param.getMultipartfiles();
                for (MultipartFile multipartfile : multipartfiles) {
                    String fileName =  multipartfile.getOriginalFilename();
                    //上传文件
                    String url = FileUtil.uploadScaleAvatarImage(multipartfile, fileName, Constants.IMG_ADVER,
                            Constants.CARD_HIGHT, Constants.CARD_HIGHT, null);
                    if (url == null) {
                        returnData.setReturnData(errorcode_data, "上传退款图片错误", "","1");
                        return;
                    }
                    sb.append(url).append(",");
                }
                if(sb.length() > 0){
                    after_sale.setImg_urls(sb.substring(0,sb.lastIndexOf(",")));
                }
            }
            int id = daoFactory.getWx_after_saleDao().insert(after_sale);
            if(id < 1){
                returnData.setReturnData(errorcode_data, "用户退货或者退款失败", "","2");
                return;
            }
            returnData.setReturnData(errorcode_success, "用户退货或者退款成功", "");
        } catch (Exception e) {
            log.error("UserOrderBiz order_refund is error", e);
            returnData.setReturnData(errorcode_systerm, "UserOrderBiz UserOrderSure is error", "");
        }
    }
    /****************************下面是封装的查询方法********************************/

}
