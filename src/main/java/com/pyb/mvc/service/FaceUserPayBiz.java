package com.pyb.mvc.service;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pyb.bean.Pay_park;
import com.pyb.bean.ReturnDataNew;
import com.pyb.bean.User_info;
import com.pyb.bean.User_pay;
import com.pyb.mvc.service.common.PayParkPB;
import com.pyb.transaction.PayTransaction;
import com.pyb.util.RequestUtil;

@Service
public class FaceUserPayBiz extends BaseBiz {

  @Autowired
  private PayTransaction payTransaction;
  @Autowired
  private PayParkPB payParkPB;

  private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

  /**
   * 支付宝充值下单
   */
  public User_pay zfb_charge(ReturnDataNew returnData, int pay_type,
      long ui_id, long money, int version, int system_type,
      String subject, String ip, String token, int type, String orderid,
      int escape_money, String escape_orderids) {
    // TODO Auto-generated method stub
    try {
      String callbackurl = "";//回调地址
      String uuid = "";
      String tel = "";
      if (system_type != 4) {
        //PDA系统除开
        User_info userinfo = daoFactory.getUser_infoDao().selectByKey(ui_id);
        if (userinfo == null) {
          //用户不存在
          returnData.setReturnData(errorcode_param, "用户不存在", "");
          return null;
        }
        if (!userinfo.getUi_token().equalsIgnoreCase(token)) {
          //用户不合法
          returnData.setReturnData(errorcode_param, "用户未授权", "");
          return null;
        }
        uuid = userinfo.getUi_nd();
        tel = userinfo.getUi_tel();
      } else {
        //如果是PDA 进行的当面付   system_type==4
        //获取订单 查看是否关联了对于的用户
        Pay_park pay_park = payParkPB.selectOnePayPark(orderid);
        if (pay_park == null) {
          returnData.setReturnData(errorcode_data, "本地订单无法在线支付", "");
          return null;
        }
        if (pay_park.pp_state == 1 || payParkPB.isCallPay(pay_park.getMy_order()) != null) {
          returnData.setReturnData(errorcode_data, "订单已支付", "");
          return null;
        }
        if (pay_park != null && !RequestUtil.checkObjectBlank(pay_park.getUi_tel())) {
          ui_id = pay_park.getUi_id();
          uuid = pay_park.getUi_nd();
          tel = pay_park.getUi_tel();
        }

      }
      //处理返回数据和业务逻辑
      User_pay user_pay = payTransaction
          .MakeUserReCharge(ui_id, uuid,
              pay_type, money, version,
              system_type, subject, ip, callbackurl, type, orderid, tel);
      if (user_pay == null) {
        returnData.setReturnData(errorcode_data, "下单失败", "");
        return null;
      }
      returnData.setReturnData("0", "下单成功", user_pay);
      return user_pay;
    } catch (Exception e) {
      log.error("UserPayBiz.zfb_charge is error", e);
      returnData.setReturnData(errorcode_data, "下单失败", "");
      return null;
    }
  }

  /**
   * 微信 -- 用户充值
   */
  public User_pay weixin_charge(ReturnDataNew returnData, int pay_type,
      long ui_id, int money, int version, int system_type,
      String subject, String ip, String token, int type, String orderid) {
    // TODO Auto-generated method stub
    try {
      String callbackurl = "";//回调地址
      String uuid = "";
      String tel = "";
      if (system_type != 4) {
        //PDA系统除开
        User_info userinfo = daoFactory.getUser_infoDao().selectByKey(ui_id);
        if (userinfo == null) {
          //用户不存在
          returnData.setReturnData(errorcode_param, "用户不存在", "");
          return null;
        }
        if (!userinfo.getUi_token().equalsIgnoreCase(token)) {
          //用户不合法
          returnData.setReturnData(errorcode_param, "用户未授权", "");
          return null;
        }
        uuid = userinfo.getUi_nd();
        tel = userinfo.getUi_tel();
      } else {
        //如果是PDA 进行的当面付   system_type==4
        //获取订单 查看是否关联了对于的用户
        Pay_park pay_park = payParkPB.selectOnePayPark(orderid);
        if (pay_park == null) {
          returnData.setReturnData(errorcode_data, "本地订单无法在线支付", "");
          return null;
        }
        if (pay_park.pp_state == 1 || payParkPB.isCallPay(pay_park.getMy_order()) != null) {
          returnData.setReturnData(errorcode_data, "订单已支付", "");
          return null;
        }
        if (pay_park != null && !RequestUtil.checkObjectBlank(pay_park.getUi_tel())) {
          ui_id = pay_park.getUi_id();
          uuid = pay_park.getUi_nd();
          tel = pay_park.getUi_tel();
        }

      }
      //处理返回数据和业务逻辑
      User_pay user_pay = payTransaction
          .MakeUserReCharge(ui_id, uuid,
              pay_type, money, version,
              system_type, subject, ip, callbackurl, type, orderid, tel);
      if (user_pay == null) {
        returnData.setReturnData(errorcode_data, "下单失败", "");
        return null;
      }
      returnData.setReturnData("0", "下单成功", user_pay);
      return user_pay;
    } catch (Exception e) {
      log.error("UserPayBiz.weixin_charge is error", e);
      returnData.setReturnData(errorcode_data, "下单失败", "");
    }
    return null;
  }
  /*****************************************************************************************/
}
