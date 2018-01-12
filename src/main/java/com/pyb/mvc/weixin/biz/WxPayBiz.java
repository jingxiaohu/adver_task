package com.pyb.mvc.weixin.biz;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.pyb.bean.*;
import com.pyb.exception.QzException;
import com.pyb.mvc.action.v1.pay.param.Param_wx_charge_jsapi;
import com.pyb.mvc.action.v1.pay.param.Param_wx_charge_jsapi_goods;
import com.pyb.mvc.service.BaseBiz;
import com.pyb.util.XMLBeanUtils;
import com.weixin.config.HttpTool;
import com.weixin.config.WeixinPayConstants;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class WxPayBiz extends BaseBiz {

/*  @Autowired
  private PayTransaction payTransaction;
  @Autowired
  private PayParkPB payParkPB;*/

  private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

  /**
   * 微信 -- 用户充值
   */
  public Wx_goods_order weixin_charge(ReturnDataNew returnData,Param_wx_charge_jsapi param) throws QzException{
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

      //处理返回数据和业务逻辑
      Wx_goods_order wx_goods_order = new Wx_goods_order();
      wx_goods_order.setOrder_id(returnUUID());
      wx_goods_order.setAddress(param.getAddress());
      wx_goods_order.setTelephone(param.getTelephone());
      wx_goods_order.setName(param.getName());

      wx_goods_order.setExpress_info("");
      wx_goods_order.setExpress_time(null);
      wx_goods_order.setStime(null);

      wx_goods_order.setUi_id(param.getUi_id());

      wx_goods_order.setRecommend_id(userinfo.getRecommend_id());//我的推荐人用户ID




      /**
       * 这里进行订单商品关系记录
       */
      int yf = 0;//运费小计
      int money = 0;//实付金额
      List<Param_wx_charge_jsapi_goods> list = JSONArray.parseArray(JSON.parseArray(param.getGoods_list()).toJSONString(),Param_wx_charge_jsapi_goods.class);
//              JSONArray.parseArray(param.getGoods_list().toJSONString(),Param_wx_charge_jsapi_goods.class);

      for (Param_wx_charge_jsapi_goods param_goods : list) {
        if(param_goods.getNum() < 1 ){
          throw new QzException("param_goods.getNum() is zero g_id="+param_goods.getG_id());
        }
        //获取商品信息
        Wx_goods wx_goods = daoFactory.getWx_goodsDao().selectByKey(param_goods.getG_id());
        if(wx_goods == null ){
         throw new QzException("wx_goods == null g_id="+param_goods.getG_id());
        }
        Wx_order_goods order_goods = new Wx_order_goods();
        order_goods.setNum(param_goods.getNum());
        order_goods.setG_id(param_goods.getG_id());//商品主键ID
        order_goods.setG_name(wx_goods.getName());//商品名称
        order_goods.setG_logo_url(wx_goods.getLogo_url());//商品URL
        order_goods.setPrice(wx_goods.getPrice_new());
        order_goods.setSubtotal(wx_goods.getPrice_new()*param_goods.getNum());//总计
        order_goods.setMoney(wx_goods.getPrice_new()*param_goods.getNum());//实付金额
        order_goods.setClothing(param_goods.getClothing());
        order_goods.setGt_id(wx_goods.getGt_id());
        order_goods.setOrder_id(wx_goods_order.getOrder_id());
        order_goods.setUi_id(wx_goods_order.getUi_id());
        order_goods.setCtime(new Date());
        int g_id = daoFactory.getWx_order_goodsDao().insert(order_goods);
        if(g_id  < 1){
          throw new QzException("insert Wx_order_goods is error g_id="+param_goods.getG_id());
        }

        money = money+order_goods.getMoney();
        yf = yf+ wx_goods.getExpress_price();
      }

      wx_goods_order.setFreight_price(yf);//运费 单位分
      wx_goods_order.setMoney(money);
      //新增
      int id = daoFactory.getWx_goods_orderDao().insert(wx_goods_order);
      if(id < 1){
        returnData.setReturnData(errorcode_data, "下单失败", "");
        throw new QzException("insert wx_goods_order is error");
      }
      wx_goods_order.setGo_id(id);




      returnData.setReturnData("0", "下单成功", wx_goods_order);
      return wx_goods_order;
    } catch (Exception e) {
      log.error("WxPayBiz.weixin_charge is error", e);
      returnData.setReturnData(errorcode_data, "下单失败", "");
      throw new QzException("处理用户下单失败",e);
    }
  }



  //weixin_charge_userpay

  /**
   * 微信 -- 用户充值
   */
  public Map<String, String> weixin_charge_userpay(ReturnDataNew returnData, Param_wx_charge_jsapi param
          , String appid, String appsecret, String partner, String subject, String ip , String Notify_url) throws QzException{
    // TODO Auto-generated method stub
    try {
      String out_trade_no  = returnUUID();
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

      //处理返回数据和业务逻辑
      Wx_goods_order wx_goods_order = new Wx_goods_order();
      wx_goods_order.setOrder_id(out_trade_no);
      wx_goods_order.setAddress(param.getAddress());
      wx_goods_order.setTelephone(param.getTelephone());
      wx_goods_order.setName(param.getName());

      wx_goods_order.setExpress_info("");
      wx_goods_order.setExpress_time(null);
      wx_goods_order.setStime(null);

      wx_goods_order.setUi_id(param.getUi_id());

      wx_goods_order.setRecommend_id(userinfo.getRecommend_id());//我的推荐人用户ID




      /**
       * 这里进行订单商品关系记录
       */
      int yf = 0;//运费小计
      int money = 0;//实付金额
      List<Param_wx_charge_jsapi_goods> list = JSONArray.parseArray(JSON.parseArray(param.getGoods_list()).toJSONString(),Param_wx_charge_jsapi_goods.class);
//              JSONArray.parseArray(param.getGoods_list().toJSONString(),Param_wx_charge_jsapi_goods.class);

      for (Param_wx_charge_jsapi_goods param_goods : list) {
        if(param_goods.getNum() < 1 ){
          throw new QzException("param_goods.getNum() is zero g_id="+param_goods.getG_id());
        }
        //获取商品信息
        Wx_goods wx_goods = daoFactory.getWx_goodsDao().selectByKey(param_goods.getG_id());
        if(wx_goods == null ){
          throw new QzException("wx_goods == null g_id="+param_goods.getG_id());
        }
        Wx_order_goods order_goods = new Wx_order_goods();
        order_goods.setNum(param_goods.getNum());
        order_goods.setG_id(param_goods.getG_id());//商品主键ID
        order_goods.setG_name(wx_goods.getName());//商品名称
        order_goods.setG_logo_url(wx_goods.getLogo_url());//商品URL
        order_goods.setPrice(wx_goods.getPrice_new());
        order_goods.setSubtotal(wx_goods.getPrice_new()*param_goods.getNum());//总计
        order_goods.setMoney(wx_goods.getPrice_new()*param_goods.getNum());//实付金额
        order_goods.setClothing(param_goods.getClothing());
        order_goods.setGt_id(wx_goods.getGt_id());
        order_goods.setOrder_id(wx_goods_order.getOrder_id());
        order_goods.setUi_id(wx_goods_order.getUi_id());
        order_goods.setCtime(new Date());
        int g_id = daoFactory.getWx_order_goodsDao().insert(order_goods);
        if(g_id  < 1){
          throw new QzException("insert Wx_order_goods is error g_id="+param_goods.getG_id());
        }

        money = money+order_goods.getMoney();
        yf = yf+ wx_goods.getExpress_price();
      }

      wx_goods_order.setFreight_price(yf);//运费 单位分
      wx_goods_order.setMoney(money);
      //****************************************************微信支付************************************************************//
      Map<String, String> result = null;
      try {
        Map<String, String> params = new HashMap<String, String>();
        params.put("appid", appid);
        params.put("mch_id", partner);
        params.put("attach", String.valueOf(param.type));
        params.put("body", subject);
        params.put("nonce_str", RandomStringUtils.random(32, true, true));
        params.put("out_trade_no", out_trade_no);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 5);
        params.put("time_expire", dateFormat.format(calendar.getTime()));
        params.put("total_fee", String.valueOf(money));
        params.put("spbill_create_ip", ip);
        params.put("notify_url", Notify_url);

        /**
         * 3、交易类型
         JSAPI--公众号支付、NATIVE--原生扫码支付、APP--app支付，统一下单接口trade_type的传参可参考这里
         MICROPAY--刷卡支付，刷卡支付有单独的支付接口，不调用统一下单接口
         */
        params.put("trade_type", "JSAPI");
        params.put("openid",param.openid);
        params.put("product_id", out_trade_no);
        String sign = getSign(params,appsecret);
        //设置SIGN
        params.put("sign", sign);
        //向微信服务器公共下单接口发送请求
        String resultStr = HttpTool
                .sendPost(WeixinPayConstants.createOrderURL, XMLBeanUtils.map2xml(params));
        if (log.isDebugEnabled()) {
          log.debug("微信下单返回结果：" + resultStr);
        }
        //组装返回数据
//        JSONObject obj = new JSONObject();
        result = XMLBeanUtils.xml2Map(resultStr);
        if (result != null && getSign(result,appsecret).equals(result.get("sign")) && "SUCCESS".equals(result.get("return_code")) && "SUCCESS".equals(result.get("result_code"))) {
          //这里对前端的 微信发起H5支付处理
          Date time = new Date();

          // result.put("timeStamp",time.getTime()/1000+"");
          String str = "appid="+result.get("appid")+"&nonceStr="+ result.get("nonce_str")+"&package=prepay_id="+result.get("prepay_id")+"&timeStamp="+time.getTime()/1000+"&key=";
          Map<String,String> wxmap = new HashMap<String,String>();
          wxmap.put("appId",result.get("appid"));
          wxmap.put("nonceStr",result.get("nonce_str"));
          wxmap.put("package","prepay_id="+result.get("prepay_id"));
          wxmap.put("timeStamp",time.getTime()/1000+"");

          result.put("appId",result.get("appid"));
          result.put("nonceStr",result.get("nonce_str"));
          result.put("package","prepay_id="+result.get("prepay_id"));
          result.put("timeStamp",time.getTime()/1000+"");
          result.put("paySign",getSign(wxmap,appsecret));
          //记录到订单某字段
          wx_goods_order.setWx_pay_json(JSON.toJSONString(result));
        }
      } catch (Exception e) {
        throw new QzException("微信支付下单请求调用失败",e);
      }
      //***************************************************************************************************************//
      //新增
      int id = daoFactory.getWx_goods_orderDao().insert(wx_goods_order);
      if(id < 1){
        returnData.setReturnData(errorcode_data, "下单失败", "");
        throw new QzException("insert wx_goods_order is error");
      }
      wx_goods_order.setGo_id(id);
      //这里在Wx_user_pay 表中生成一条支付订单
      Wx_user_pay user_pay = new Wx_user_pay();
      //type  是支付 还是 充值  1：充值  2：普通订单支付  3：租赁订单支付
      //生成订单
      Date date = new Date();
      user_pay.setAct_type(2);//INT    行为类型1：充值2：普通订单支付3：租赁订单支付
      user_pay.setCtime(date);
      user_pay.setEtime(date);
      user_pay.setUtime(date);
      user_pay.setMoney(money);
      user_pay.setOrder_id(out_trade_no);
      user_pay.setReturn_url(callbackurl);
      user_pay.setState(0);//交易状态(0:未支付1：已支付2：支付失败)
      user_pay.setSystem_type(3);//操作系统类型（IOSAndroidweb）1:android2:IOS3:web4:PDA
      user_pay.setTransaction_id("");
      user_pay.setType(2);//支付类型1:支付宝 2：微信 3：银联
      user_pay.setUi_id(param.getUi_id());
//      user_pay.setUi_nd(ui_nd);
//      user_pay.setVersion_code(version);
      user_pay.setCar_order_id(wx_goods_order.getOrder_id());
      user_pay.setSubject("拼一把商品");
//      user_pay.setIp(ip);
      user_pay.setTel(userinfo.getTelephone());

      id = daoFactory.getWx_user_payDao().insert(user_pay);
      if (id < 1) {
        //插入失败
        throw new QzException("下订单失败");
      }
      user_pay.setId(id);
      returnData.setReturnData("0", "下单成功", user_pay);
      return result;

    } catch (Exception e) {
      log.error("WxPayBiz.weixin_charge is error", e);
      returnData.setReturnData(errorcode_data, "下单失败", "");
      throw new QzException("处理用户下单失败",e);
    }
  }

  /**
   * 微信通知监听接口
   */
  @Transactional(rollbackFor = QzException.class)
  public void notify_weixin_userpay(ReturnDataNew returnData, String orderid,
                            String trade_no, String type, long money) throws QzException{
    // TODO Auto-generated method stub
    try {
      Wx_user_pay  wx_user_pay  = selectOneUserPay( orderid);
      if(wx_user_pay == null){
        returnData.setReturnData(errorcode_param, "订单不存在", "");
        return;
      }
      //验证是否金额一致 如果不一致有可能是被抓包  恶意刷我们的钱包
      if (wx_user_pay.getMoney() != money) {
        returnData.setReturnData(errorcode_param, "金额不匹配", "");
        return;
      }
      //判断是 用户充值回调 还是  用户支付回调
      //更新通知状态
      wx_user_pay.setState(1);//交易状态(0:未支付1：已支付2：支付失败)
      wx_user_pay.setTransaction_id(trade_no);//交易事物号
      Date date = new Date();
      wx_user_pay.setUtime(date);
      wx_user_pay.setEtime(date);
      int count = daoFactory.getWx_user_payDao().updateByKey(wx_user_pay);
      if (count < 1) {
        //更新失败
        log.error("更新通知状态失败 type=" + type + "  orderid=" + wx_user_pay.getOrder_id());
        throw new QzException("更新通知状态失败 type=" + type + "  orderid=" + wx_user_pay.getOrder_id());
      }
      //首先根据type进行判断是 支付 还是 充值   是支付 还是 充值  0:订单支付 1：充值
      if("0".equalsIgnoreCase(type) && wx_user_pay.getState() == 1 && StringUtils.hasLength(wx_user_pay.getCar_order_id())){
         String sql = "select * from wx_goods_order where order_id=? and is_del=0 and is_pay=0 limit 1";
         Wx_goods_order wx_goods_order = getDB().queryUniqueT(sql,Wx_goods_order.class,wx_user_pay.getCar_order_id());
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
        count = daoFactory.getWx_goods_orderDao().updateByKey(wx_goods_order);
        if(count == 1){
          /*returnData.setReturnData(errorcode_success, "通知更新成功", wx_goods_order);
          return;*/
          //这里处理该用户的推荐人的收益数据
          sql = "select * from wx_recommend_earnings where ui_id=? and state=1 limit 1";
          Wx_recommend_earnings wx_recommend_earnings = getDB().queryUniqueT(sql, Wx_recommend_earnings.class, wx_goods_order.getRecommend_id());
          if(wx_recommend_earnings != null){
              //待确认收益增加
            wx_recommend_earnings.setEarnings_total(wx_recommend_earnings.getUnconfirmed_receiving()+wx_goods_order.getMoney());
            wx_recommend_earnings.setUtime(new Date());
            count = daoFactory.getWx_recommend_earningsDao().updateByKey(wx_recommend_earnings);
            if(count != 1){
              returnData.setReturnData(errorcode_param, "通知更新失败", "");
              throw new QzException("更新处理该用户的推荐人的收益数据失败 type=" + type + "  orderid=" + wx_user_pay.getOrder_id());
            }
          }
        }else{
          returnData.setReturnData(errorcode_param, "通知更新失败", "");
          throw new QzException("更新处理该用户的推荐人的收益数据失败 type=" + type + "  orderid=" + wx_user_pay.getOrder_id());
        }
      }

      returnData.setReturnData(errorcode_param, "通知更新失败", "");
      return;

    } catch (Exception e) {
      log.error("WxPayBiz.notify_weixin is error", e);
      returnData.setReturnData(errorcode_data, "通知更新失败", "");
      throw new QzException("更新处理该用户的推荐人的收益数据失败" );
    }
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
  /**
   * 用户充值::通过订单编号获取某条用户充值订单详情
   */
  public Wx_user_pay selectOneUserPay(String orderid) {
    try {
      String sql = "SELECT *  FROM wx_user_pay WHERE order_id=? LIMIT 1";
      return getDB().queryUniqueT(sql, Wx_user_pay.class, orderid);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      log.error("selectOneUserPay 用户充值::通过订单编号获取某条用户充值订单详情错误", e);
    }
    return null;
  }

  /**
   * 对支付参数信息进行签名
   *
   * @param params 待签名授权信息
   */
  public String getSign(Map<String, String> params,String appsecret) {
    //获取待签名字符串
    List<String> keys = new ArrayList<>(params.keySet());
    Collections.sort(keys);

    String prestr = "";

    for (int i = 0; i < keys.size(); i++) {
      String key = keys.get(i);
      String value = params.get(key);
      if (value == null || value.equals("") || key.equalsIgnoreCase("sign")) {
        continue;
      }
      if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
        prestr = prestr + key + "=" + value;
      } else {
        prestr = prestr + key + "=" + value + "&";
      }
    }
    //获得签名验证结果
    String stringSignTemp = prestr + "&key=" + appsecret;
    return org.springframework.util.DigestUtils.md5DigestAsHex(stringSignTemp.getBytes())
            .toUpperCase();
  }
}
