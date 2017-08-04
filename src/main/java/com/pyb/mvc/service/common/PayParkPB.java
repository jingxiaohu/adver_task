package com.pyb.mvc.service.common;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pyb.bean.Pay_park;
import com.pyb.bean.User_pay;
import com.pyb.mvc.service.BaseBiz;

/**
 * 普通订单公用方法
 *
 * @author jingxiaohu
 */
@Service
public class PayParkPB extends BaseBiz {

  @Autowired
  private UserPB userPB;

  /**
   * 通过订单编号获取某条订单详情
   */
  public Pay_park selectOnePayPark(String orderid) {
    try {
      String sql = "SELECT *  FROM pay_park WHERE my_order=? ORDER BY pp_state ASC,ctime DESC LIMIT 1";
      return getMySelfService().queryUniqueT(sql, Pay_park.class, orderid);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      log.error("PayParkUtil.selectOnePayPark 通过订单编号获取某条订单详情错误", e);
    }
    return null;
  }


  /**
   * 用户充值::通过订单编号获取某条用户充值订单详情
   */
  public User_pay selectOneUserPay(String orderid) {
    try {
      String sql = "SELECT *  FROM user_pay WHERE order_id=? LIMIT 1";
      return getMySelfService().queryUniqueT(sql, User_pay.class, orderid);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      log.error("PayParkUtil.selectOneUserPay 用户充值::通过订单编号获取某条用户充值订单详情错误", e);
    }
    return null;
  }

  /**
   * 第三方回调通知 更改普通订单扣款成功
   */
//  public Pay_park upPayParkNotify(String orderid, String other_orderid, long money) {
  public Pay_park upPayParkNotify(User_pay user_pay) {
    try {
      String sql = "SELECT *  FROM pay_park WHERE my_order=? LIMIT 1";
      Pay_park pay_park = getMySelfService()
          .queryUniqueT(sql, Pay_park.class, user_pay.getCar_order_id());
      if (pay_park == null) {
        return null;
      }
        pay_park.setPp_state(1);
        pay_park.setUp_orderid(user_pay.getOrder_id());
        pay_park.setUtime(new Date());
        pay_park.setPay_source(user_pay.getType());
        int count = daoFactory.getPay_parkDao().updateByKey(pay_park);
        if (count == 1) {
          //更新成功  （by jxh 2016-11-24 这里需要给商户账户上面资金增加 这块业务放到 车辆出库的地方处理  ）
          return pay_park;
        }else{
        	return null;
        }
    } catch (Exception e) {
      log.error("PayParkUtil.upPayParkNotify 第三方回调通知::通过订单编号第三方回调通知 更改普通订单扣款成功错误", e);
    }
    return null;
  }




  /**
   * 通过PDA占道停车订单 从第三方支付回调表查询是否支付成功
   */
  public User_pay findByOrderid(String orderid) {
    try {
      String sql = "SELECT * FROM user_pay WHERE car_order_id=? LIMIT 1";
      return getMySelfService().queryUniqueT(sql, User_pay.class, orderid);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      log.error("findByOrderid is error", e);
    }
    return null;
  }
  //by jxh 2017-2-27

  /**
   * 通过PDA占道停车订单 从第三方支付回调表查询是否支付成功
   *
   * @return true:成功 false：失败
   */
  public User_pay isCallPay(String orderid) {
    try {
      String sql = "SELECT * FROM user_pay WHERE car_order_id=? AND state=1 LIMIT 1";
      User_pay user_pay = getMySelfService().queryUniqueT(sql, User_pay.class, orderid);
      if (user_pay != null) {
        return user_pay;
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      log.error("isCallPay is error", e);
    }
    return null;
  }

}
