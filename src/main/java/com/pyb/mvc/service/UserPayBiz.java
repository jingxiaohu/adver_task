package com.pyb.mvc.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.pyb.bean.ReturnDataNew;
import com.pyb.bean.User_pay;
import com.pyb.exception.QzException;

@Service
public class UserPayBiz extends BaseBiz {


  private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

  /**
   * 建设银行龙支付通知   验证成功  更新该订单的支付状态 并把对应的金额添加给用户
   */
  public void notify_lzf(ReturnDataNew returnData, String orderid, String type, long money) {
    try {
      // type 是支付 还是 充值  1：充值  2：普通订单支付  3：租赁订单支付
      //首先检查该条订单是否存在
      User_pay user_pay = null;//selectOneUserPay(orderid);
      if (user_pay == null) {
        //订单不存在
        returnData.setReturnData(errorcode_param, "订单不存在", "");
        return;
      }
      //避免第三方多次回调
      if (user_pay.getState() == 1) {
        returnData.setReturnData(errorcode_success, "通知更新成功", user_pay);
        return;
      }
      //验证是否金额一致 如果不一致有可能是被抓包  恶意刷我们的钱包
      if (user_pay.getMoney() != money) {
        returnData.setReturnData(errorcode_param, "金额不匹配", "");
        return;
      }

      try {
        /**
         * 为了防止龙支付 回调多次引起数据重复 这里再次进行检查是否已经处理了
         */
        //首先检查该条订单是否存在
        user_pay = selectOneUserPay(orderid);
        if (user_pay == null) {
          //订单不存在
          returnData.setReturnData(errorcode_param, "订单不存在", "");
          return;
        }
        //避免第三方多次回调
        if (user_pay.getState() == 1) {
          returnData.setReturnData(errorcode_success, "通知更新成功", user_pay);
          return;
        }
        //首先检查该条订单是否存在
        user_pay = selectOneUserPay(orderid);
        if (user_pay == null) {
          //订单不存在
          returnData.setReturnData(errorcode_param, "订单不存在", "");
          return;
        }
        //避免第三方多次回调
        if (user_pay.getState() == 1) {
          returnData.setReturnData(errorcode_success, "通知更新成功", user_pay);
          return;
        }

        //建行龙支付用户充值通知：修改用户钱包金额、更改订单状态
        user_pay = NotifyUserPay(user_pay);
      } catch (Exception e) {
        // TODO Auto-generated catch block
        log.error("通知更新失败 NotifyUserPay(user_pay)", e);
      }
      returnData.setReturnData("0", "通知更新成功", user_pay);
      return;
    } catch (Exception e) {
      log.error("UserPayBiz.lzf_charge is error", e);
      returnData.setReturnData(errorcode_data, "通知更新失败", "");
      return;
    }
  }


  /**
   * 支付宝通知   验证成功  更新该订单的支付状态 并把对应的金额添加给用户
   */
  public void notify_zfb(ReturnDataNew returnData, String orderid, String trade_no, String type,
      long money) {
    // TODO Auto-generated method stub
    try {
      //是支付 还是 充值  1：充值  2：普通订单支付  3：租赁订单支付
      //首先检查该条订单是否存在
      User_pay user_pay = selectOneUserPay(orderid);
      if (user_pay == null) {
        //订单不存在
        returnData.setReturnData(errorcode_param, "订单不存在", "");
        return;
      }
      //避免第三方多次回调
      if (user_pay.getState() == 1) {
        returnData.setReturnData(errorcode_success, "通知更新成功", user_pay);
        return;
      }

      //支付宝用户充值通知：修改用户钱包金额、更改订单状态
      user_pay.setTransaction_id(trade_no);

      if (user_pay.getAct_type() == 1) {
        //充值
        //验证是否金额一致 如果不一致有可能是被抓包  恶意刷我们的钱包
        if (user_pay.getMoney() != money) {
          returnData.setReturnData(errorcode_param, "金额不匹配", "");
          return;
        }
      }
      try {
        user_pay = NotifyUserPay(user_pay);
      } catch (Exception e) {
        // TODO Auto-generated catch block
        log.error("通知更新失败 NotifyUserPay(user_pay)", e);
      }

      returnData.setReturnData(errorcode_success, "通知更新成功", user_pay);
      return;

    } catch (Exception e) {
      log.error("UserPayBiz.notify_zfb is error", e);
      returnData.setReturnData(errorcode_data, "通知更新失败", "");
      return;
    }
  }


  /**
   * 微信通知监听接口
   */
  public void notify_weixin(ReturnDataNew returnData, String orderid,
      String trade_no, String type, long money) {
    // TODO Auto-generated method stub
    try {
      //是支付 还是 充值  1：充值  2：普通订单支付  3：租赁订单支付
      //首先检查该条订单是否存在
      User_pay user_pay = selectOneUserPay(orderid);
      if (user_pay == null) {
        //订单不存在
        returnData.setReturnData(errorcode_param, "订单不存在", "");
        return;
      }
      //避免第三方多次回调
      if (user_pay.getState() == 1) {
        returnData.setReturnData(errorcode_success, "通知更新成功", user_pay);
        return;
      }

      //支付宝用户充值通知：修改用户钱包金额、更改订单状态
      user_pay.setTransaction_id(trade_no);

      if (user_pay.getAct_type() == 1) {
        //充值
        //验证是否金额一致 如果不一致有可能是被抓包  恶意刷我们的钱包
        if (user_pay.getMoney() != money) {
          returnData.setReturnData(errorcode_param, "金额不匹配", "");
          return;
        }
      }
      try {
        user_pay = NotifyUserPay(user_pay);
      } catch (Exception e) {
        // TODO Auto-generated catch block
        log.error("通知更新失败 NotifyUserPay(user_pay)", e);
      }

      returnData.setReturnData(errorcode_success, "通知更新成功", user_pay);
      return;

    } catch (Exception e) {
      log.error("UserPayBiz.notify_weixin is error", e);
      returnData.setReturnData(errorcode_data, "通知更新失败", "");
      return;
    }
  }

  
  /**
   * 用户充值::通过订单编号获取某条用户充值订单详情
   */
  public User_pay selectOneUserPay(String orderid) {
    try {
      String sql = "SELECT *  FROM user_pay WHERE order_id=? LIMIT 1";
      return getDB().queryUniqueT(sql, User_pay.class, orderid);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      log.error("PayParkUtil.selectOneUserPay 用户充值::通过订单编号获取某条用户充值订单详情错误", e);
    }
    return null;
  }
  
  /**
   * 用户充值通知：修改用户钱包金额、更改订单状态
   */
  public User_pay NotifyUserPay(User_pay user_pay) throws QzException {
    // TODO Auto-generated method stub
    try {
      if (user_pay == null) {
        return user_pay;
      }

      //更新订单第三方支付相关ID
//      up_orderid(user_pay);

      int order_type = 0;//int(11)    下单类型0:普通下单1：预约下单2：租赁包月订单
      int discount_money = 0;//int(11)    抵扣优惠金额（单位分）
      int discount_type = 0;//int(11)    优惠券类型0:金额券1：折扣券
      long upc_id = 0;//bigint(20)    用户优惠券表主键ID
      //判断是 用户充值回调 还是  用户支付回调
      //行为类型 1：充值  2：普通订单支付  3：租赁订单支付
      int type = user_pay.getAct_type();
      //更新通知状态
      user_pay.setState(1);//交易状态(0:未支付1：已支付2：支付失败)
      Date date = new Date();
      user_pay.setUtime(date);
      user_pay.setEtime(date);
      int count = daoFactory.getUser_payDao().updateByKey(user_pay);
      if (count < 1) {
        //更新失败
        log.error("更新通知状态失败 type=" + type + "  orderid=" + user_pay.getOrder_id());
        throw new QzException("更新通知状态失败 type=" + type + "  orderid=" + user_pay.getOrder_id());
      }
      return user_pay;
    } catch (Exception e) {
      // TODO Auto-generated catch block
      throw new QzException("更新用户充值状态失败 orderid=" + user_pay.getOrder_id());
    }
  }

}
