/**
 * @Title: TT.java
 * @Package com.intimes.biz
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 敬小虎
 * @date 2015年3月20日 下午1:32:43
 * @version V1.0
 */
package com.pyb.transaction;

import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pyb.bean.Pay_park;
import com.pyb.bean.ReturnDataNew;
import com.pyb.bean.User_info;
import com.pyb.bean.User_pay;
import com.pyb.exception.QzException;
import com.pyb.mvc.service.BaseBiz;
import com.pyb.mvc.service.common.PayParkPB;
import com.pyb.mvc.service.common.UserPB;
import com.pyb.type.PayTypeEnum;
import com.pyb.util.RequestUtil;

/**
 * @author 敬小虎
 * @ClassName: TT
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2015年3月20日 下午1:32:43
 */
@Transactional(rollbackFor = QzException.class)
@Service
public class PayTransaction extends BaseBiz {

    @Autowired
    private UserPB userPB;
    @Autowired
    protected PayParkPB payParkPB;

    /**
     * 用户支付通知：修改用户钱包金额、更改订单状态
     */
    public User_pay NotifyUserPay(User_pay user_pay) throws QzException {
        // TODO Auto-generated method stub
        try {
            if (user_pay == null) {
                return user_pay;
            }

            //更新订单第三方支付相关ID
            up_orderid(user_pay);

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

            if (type == 1) {
                //充值
                //钱包增加金额
                User_info user_info = userPB.updateUserMoney(user_pay.getUi_id(), user_pay.getUi_nd(), 0, (int)user_pay.getMoney());
                if (user_info == null) {
                    //更新充值金额失败
                    log.error("更新用户充值金额失败 orderid=" + user_pay.getOrder_id());
                    throw new QzException("更新用户充值金额失败 orderid=" + user_pay.getOrder_id());
                }


            } else if (type == 2) {
                //2：普通订单支付
                Pay_park pay_park = payParkPB.upPayParkNotify(user_pay);
                if (pay_park == null) {
                    //更新失败
                    log.error(
                            "更新--普通订单支付--用户支付状态失败user_pay.orderid=" + user_pay.getOrder_id() + "car_order_id="
                                    + user_pay.getCar_order_id());
                    throw new QzException(
                            "更新--普通订单支付--用户支付状态失败user_pay.orderid=" + user_pay.getOrder_id() + "car_order_id="
                                    + user_pay.getCar_order_id());
                }
            }

            /**
             * 记录充值或者支付
             */
            ReturnDataNew returnData = new ReturnDataNew();
            if (user_pay.getAct_type() == 1) {
                //充值
                String act_name = PayTypeEnum.returnObj(user_pay.getType()) + "充值";
                userPB.recordVC(1, (int) user_pay.getMoney(), user_pay.getOrder_id(), 0, user_pay.getUi_id(),
                                returnData, act_name, user_pay.getUi_nd(), user_pay.getTel(), user_pay.getType(), 0,
                                0, 0, date);
                /*try {
                    //2.	充值到账：您充值的XX元电子劵已经到账，可以在吾泊电子钱包明细处查询。
                    *//**
                     * 这里进行推送
                     *//*
                    JPushMessageBean jPushMessageBean = new JPushMessageBean();
                    jPushMessageBean.setType(0);
                    jPushMessageBean
                            .setMessage("您充值" + (int) user_pay.getMoney() / 100 + "元人民币已经到账，可以在电子钱包明细处查询。");
                    jPushMessageBean.setImgurl(Constants.JPUSH_LOGO);
                    jPushMessageBean.setTitle("充值到账");
                    jPushMessageBean.setDate(date);
                    User_info userinfo = daoFactory.getUser_infoDao().selectByKey(user_pay.getUi_id());
                    if (userinfo != null) {
                        asyncJpushTask.doAppJpush(jPushMessageBean, userinfo.getUi_nd());
                    }

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    log.error("充值到账 推送出现错误", e);
                }*/
            } else {
                //属于支付
                String act_name = PayTypeEnum.returnObj(user_pay.getType()) + "支付";
                userPB.recordVC(0, (int) user_pay.getMoney(), user_pay.getCar_order_id(), order_type,
                        user_pay.getUi_id(), returnData, act_name, user_pay.getUi_nd(), user_pay.getTel(),
                        user_pay.getType()
                        , upc_id, discount_type, discount_money, date);
            }
            return user_pay;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            throw new QzException("更新用户充值状态失败 orderid=" + user_pay.getOrder_id());
        }
    }

    /**
     * 更新订单第三方支付相关ID
     */
    private void up_orderid(User_pay user_pay) {
        try {
	            //行为类型 1：充值  2：普通订单支付  
	            int type = user_pay.getAct_type();
	            if (type == 2) {
	                getMySelfService().update(
	                        "UPDATE pay_park SET up_orderid=? WHERE my_order=?",
	                        user_pay.getOrder_id(), user_pay.getCar_order_id());
	            }
           } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
    /**
     * 插入用户充值订单表
     *
     * @@有事务处理
     */
    public User_pay MakeUserReCharge(long ui_id, String ui_nd, int pay_type, long money, int version,
        int system_type, String subject,
        String ip, String callbackurl, int type, String orderid, String tel) throws QzException {
      try {
        User_pay user_pay = new User_pay();
        //type  是支付 还是 充值  1：充值  2：普通订单支付  3：租赁订单支付
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
          subject = "股掌充值";
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
