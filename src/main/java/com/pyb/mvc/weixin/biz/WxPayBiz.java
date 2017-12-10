package com.pyb.mvc.weixin.biz;

import com.pyb.bean.ReturnDataNew;
import com.pyb.bean.Wx_goods;
import com.pyb.bean.Wx_goods_order;
import com.pyb.bean.Wx_user_info;
import com.pyb.mvc.action.v1.pay.param.Param_wx_charge_jsapi;
import com.pyb.mvc.service.BaseBiz;
import com.pyb.mvc.service.common.PayParkPB;
import com.pyb.transaction.PayTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class WxPayBiz extends BaseBiz {

  @Autowired
  private PayTransaction payTransaction;
  @Autowired
  private PayParkPB payParkPB;

  private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

  /**
   * 微信 -- 用户充值
   */
  public Wx_goods_order weixin_charge(ReturnDataNew returnData,Param_wx_charge_jsapi param) {
    // TODO Auto-generated method stub
    try {
      String callbackurl = "";//回调地址
      String uuid = "";
      String tel = "";
      //PDA系统除开
      Wx_user_info userinfo = daoFactory.getWx_user_infoDao().selectByKey(param.getUi_id());
      if (userinfo == null) {
        //用户不存在
        returnData.setReturnData(errorcode_param, "用户不存在", "");
        return null;
      }
      if (!userinfo.getToken().equalsIgnoreCase(param.getToken())) {
        //用户不合法
        returnData.setReturnData(errorcode_param, "用户未授权", "");
        return null;
      }
      tel = userinfo.getTelephone();

      //获取商品信息
      Wx_goods wx_goods = daoFactory.getWx_goodsDao().selectByKey(param.getG_id());
      if(wx_goods == null ){
        returnData.setReturnData(errorcode_param, "该商品不存在", "");
        return null;
      }

      //处理返回数据和业务逻辑
      Wx_goods_order wx_goods_order = new Wx_goods_order();
      wx_goods_order.setOrder_id(returnUUID());
      wx_goods_order.setAddress(param.getAddress());
      wx_goods_order.setTelephone(param.getTelephone());
      wx_goods_order.setName(param.getName());
      wx_goods_order.setNum(param.getNum());
      wx_goods_order.setExpress_info("");
      wx_goods_order.setExpress_time(null);
      wx_goods_order.setStime(null);
      wx_goods_order.setFreight_price(wx_goods.getExpress_price());//运费 单位分
      wx_goods_order.setUi_id(param.getUi_id());

      wx_goods_order.setRecommend_id(userinfo.getRecommend_id());//我的推荐人用户ID
      wx_goods_order.setG_id(param.getG_id());//商品主键ID
      wx_goods_order.setG_name(wx_goods.getName());//商品名称
      wx_goods_order.setG_logo_url(wx_goods.getLogo_url());//商品URL
      wx_goods_order.setMoney(param.getPay_price());
      wx_goods_order.setPrice(wx_goods.getPrice_new());
      wx_goods_order.setClothing(param.getClothing());
      wx_goods_order.setGt_id(wx_goods.getGt_id());

      //新增
      int id = daoFactory.getWx_goods_orderDao().insert(wx_goods_order);
      if(id < 1){
        returnData.setReturnData(errorcode_data, "下单失败", "");
        return null;
      }
      wx_goods_order.setGo_id(id);
      returnData.setReturnData("0", "下单成功", wx_goods_order);
      return wx_goods_order;
    } catch (Exception e) {
      log.error("WxPayBiz.weixin_charge is error", e);
      returnData.setReturnData(errorcode_data, "下单失败", "");
    }
    return null;
  }



  /**
   * 微信通知监听接口
   */
//  @Transactional(rollbackFor = QzException.class)
  public void notify_weixin(ReturnDataNew returnData, String orderid,
                            String trade_no, String type, long money) {
    // TODO Auto-generated method stub
    try {
      //首先根据type进行判断是 支付 还是 充值   是支付 还是 充值  0:订单支付 1：充值
      if("0".equalsIgnoreCase(type)){
        String sql = "select * from wx_goods_order where order_id=? and is_del=0 and is_pay=0 limit 1";
        Wx_goods_order wx_goods_order = getDB().queryUniqueT(sql,Wx_goods_order.class,orderid);
        if(wx_goods_order == null){
          returnData.setReturnData(errorcode_param, "订单不存在", "");
          return;
        }
        //验证是否金额一致 如果不一致有可能是被抓包  恶意刷我们的钱包
        if (wx_goods_order.getMoney() != money) {
          returnData.setReturnData(errorcode_param, "金额不匹配", "");
          return;
        }
        wx_goods_order.setIs_pay(1);//支付成功
        wx_goods_order.setTransaction_id(trade_no);//交易事物号
        wx_goods_order.setState(1);//订单状态 0：待付款 1：待发货 2：待收货 3：已完成
        wx_goods_order.setPtime(new Date());//支付时间
        int count = daoFactory.getWx_goods_orderDao().updateByKey(wx_goods_order);
        if(count == 1){
          returnData.setReturnData(errorcode_success, "通知更新成功", wx_goods_order);
          return;
        }else{
          returnData.setReturnData(errorcode_param, "通知更新失败", "");
          return;
        }
      }

      returnData.setReturnData(errorcode_param, "通知更新失败", "");
      return;

    } catch (Exception e) {
      log.error("WxPayBiz.notify_weixin is error", e);
      returnData.setReturnData(errorcode_data, "通知更新失败", "");
      return;
    }
  }
  /*****************************************************************************************/

}
