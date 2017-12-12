package com.pyb.mvc.weixin.biz;

import com.pyb.bean.ReturnDataNew;
import com.pyb.bean.Wx_goods_order;
import com.pyb.mvc.action.v1.weixin.order.param.Param_kdwl;
import com.pyb.mvc.action.v1.weixin.order.param.Param_order;
import com.pyb.mvc.action.v1.weixin.order.param.Param_orderList;
import com.pyb.mvc.weixin.util.KdniaoTrackQueryAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户订单管理
 */
@Service
public class UserOrderBiz extends  BaseWxBiz{
    @Autowired
    KdniaoTrackQueryAPI kdniaoTrackQueryAPI;
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
            returnData.setReturnData(errorcode_success, "用户取消订单成功", wx_goods_order);
        } catch (Exception e) {
            log.error("UserOrderBiz GainOrderInfo is error", e);
            returnData.setReturnData(errorcode_systerm, "UserOrderBiz GainOrderInfo is error", "");
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

    /****************************下面是封装的查询方法********************************/

}
