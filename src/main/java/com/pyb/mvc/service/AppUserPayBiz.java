package com.pyb.mvc.service;

import com.pyb.bean.Pay_park;
import com.pyb.bean.ReturnDataNew;
import com.pyb.bean.User_info;
import com.pyb.bean.User_pay;
import com.pyb.exception.QzException;
import com.pyb.mvc.service.common.PayParkPB;
import com.pyb.util.RequestUtil;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppUserPayBiz extends BaseBiz {


  @Autowired
  private PayParkPB payParkPB;



  private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");


  /**
   * 支付宝充值下单
   */
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = QzException.class)
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
        if (pay_park != null && !RequestUtil.checkObjectBlank(pay_park.getUi_tel())) {
          ui_id = pay_park.getUi_id();
          uuid = pay_park.getUi_nd();
          tel = pay_park.getUi_tel();
        }
      }
      //处理返回数据和业务逻辑
      User_pay user_pay = MakeUserReCharge(ui_id, uuid,
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
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = QzException.class)
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
        /*if (!userinfo.getUi_token().equalsIgnoreCase(token)) {
          //用户不合法
          returnData.setReturnData(errorcode_param, "用户未授权", "");
          return null;
        }*/
        uuid = userinfo.getUi_nd();
        tel = userinfo.getUi_tel();
      } else {
        //如果是PDA 进行的当面付   system_type==4
        //获取订单 查看是否关联了对于的用户
        Pay_park pay_park = payParkPB.selectOnePayPark(orderid);
        if (pay_park != null && !RequestUtil.checkObjectBlank(pay_park.getUi_tel())) {
          ui_id = pay_park.getUi_id();
          uuid = pay_park.getUi_nd();
          tel = pay_park.getUi_tel();
        }
      }
        //处理返回数据和业务逻辑
        User_pay user_pay = MakeUserReCharge(ui_id, uuid,
            pay_type, money, version,
            system_type, subject, ip, callbackurl, type, orderid, tel);
        if (user_pay == null) {
          returnData.setReturnData(errorcode_data, "下单失败", "");
          return null;
        }
        returnData.setReturnData("0", "下单成功", user_pay);
        return user_pay;
      } catch(Exception e){
        log.error("UserPayBiz.weixin_charge is error", e);
        returnData.setReturnData(errorcode_data, "下单失败", "");
      }
      return null;
    }


    /**
     * 用户充值订单和停车支付订单流水表
     *
     * @@有事务处理
     */
  public User_pay MakeUserReCharge(long ui_id, String ui_nd, int pay_type, long money, int version,
      int system_type, String subject,
      String ip, String callbackurl, int type, String orderid, String tel) throws QzException {
    try {
      User_pay user_pay = new User_pay();
      //type  是支付 还是 充值  1：充值  2：普通订单支付  3：租赁订单支付   4：租赁订单续约支付
      //生成订单
      Date date = new Date();
      user_pay.setAct_type(type);//INT    行为类型（1：用户充值）
      user_pay.setCtime(date);
      user_pay.setEtime(date);
      user_pay.setUtime(date);
      user_pay.setMoney(money);
      user_pay.setOrder_id(returnUUID());
      user_pay.setReturn_url(callbackurl);
      user_pay.setState(0);//交易状态(0:未支付1：已支付2：支付失败)
      user_pay.setSystem_type(system_type);
      user_pay.setTransaction_id("");
      user_pay.setType(pay_type);//支付类型1:支付宝 2：微信 3：银联
      user_pay.setUi_id(ui_id);
      user_pay.setUi_nd(ui_nd);
      user_pay.setVersion_code(version);
      user_pay.setCar_order_id(orderid);
      if (RequestUtil.checkObjectBlank(subject)) {
        subject = "吾泊充值";
      }
      user_pay.setSubject(subject);
      user_pay.setIp(ip);
      user_pay.setTel(tel);

      int id = daoFactory.getUser_payDao().insert(user_pay);
      if (id < 1) {
        //插入失败
        throw new QzException("下订单失败");
      }
      user_pay.setId(id);
      return user_pay;
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      throw new QzException("下订单失败", e);
    }
  }

}
