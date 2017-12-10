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
  /*****************************************************************************************/

}
