
package com.pyb.mvc.action.v1.pay;

import com.pyb.bean.ReturnDataNew;
import com.pyb.bean.Wx_user_pay;
import com.pyb.constants.Constants;
import com.pyb.mvc.action.v1.BaseV1Controller;
import com.pyb.mvc.action.v1.notify.Notify_WeiXinJsApiction;
import com.pyb.mvc.action.v1.notify.Notify_WeiXinction;
import com.pyb.mvc.action.v1.pay.param.Param_wx_charge_jsapi;
import com.pyb.mvc.weixin.biz.WxPayBiz;
import com.pyb.util.RequestUtil;
import com.pyb.util.XMLBeanUtils;
import com.weixin.config.HttpTool;
import com.weixin.config.WeixinPayConstants;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 微信 -- 用户下单支付
 *
 * @author jingxiaohu
 */
@Controller
@RequestMapping(value = "/v1")
public class Wx_WeiXin_JsApiPayAction2 extends BaseV1Controller {

  /**
   *
   */
  private static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private static final long serialVersionUID = -4402176190279046970L;

  //商户相关资料
  private static String appid = WeixinPayConstants.appid;
  private static String appsecret = WeixinPayConstants.partnerkey;
  private static String partner = WeixinPayConstants.partner;

  @Autowired
  private WxPayBiz wxPayBiz;

  private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

  public String getNotify_url() throws NoSuchMethodException {
    return ControllerLinkBuilder.linkTo(Notify_WeiXinction.class,
            Notify_WeiXinJsApiction.class.getMethod("notify_weixin_jsapi2", HttpServletRequest.class, HttpServletResponse.class)).withSelfRel().getHref()+ ".php";
  }

  @RequestMapping(value = "/goods/weixin_charge_jsapi2")
  @ResponseBody
  public String weixin_charge_jsapi(HttpServletRequest request, HttpServletResponse response,Param_wx_charge_jsapi param) {

    ReturnDataNew returnData = new ReturnDataNew();
    //参数检查
    if (param == null) {
      //参数传递错误 
      returnData.setReturnData(errorcode_param, "参数传递错误", "");
      sendResp(returnData, response);
      return null;
    }
    //检查是否进行了参数签名认证
    if (!param.checkRequest()) {
      returnData.setReturnData(errorcode_param, "没有进行参数签名认证", "");
      sendResp(returnData, response);
      return null;
    }
    //对封装的参数对象中的属性进行 非空等规则验证
    //非空验证
    if (param.ui_id < 1) {
      //ui_id必须大于0
      returnData.setReturnData(errorcode_param, "ui_id is null", "");
      sendResp(returnData, response);
      return null;

    }
    if (param.type == null) {
      returnData.setReturnData(errorcode_param, "type is null", "");
      sendResp(returnData, response);
      return null;

    }
    if (System.currentTimeMillis() - param.t > 3 * 60 * 1000) {
      //如果请求超出120秒则认为是 废弃请求
      returnData.setReturnData(errorcode_param, "是 废弃请求", "");
      sendResp(returnData, response);
      return null;
    }
    if (param.getGoods_list() == null ) {
      returnData.setReturnData(errorcode_param, "Goods_list is null", "");
      sendResp(returnData, response);
      return null;

    }

    if (RequestUtil.checkObjectBlank(param.token)) {
      //token不能为空
      returnData.setReturnData(errorcode_param, "token不能为空", "");
      sendResp(returnData, response);
      return null;
    }
    if (RequestUtil.checkObjectBlank(param.openid)) {
      //openid不能为空
      returnData.setReturnData(errorcode_param, "openid不能为空", "");
      sendResp(returnData, response);
      return null;
    }
/*    if (RequestUtil.checkObjectBlank(param.g_id)) {
      returnData.setReturnData(errorcode_param, "g_id不能为空", "");
      sendResp(returnData, response);
      return null;
    }
    if (RequestUtil.checkObjectBlank(param.num)) {
      //token不能为空
      returnData.setReturnData(errorcode_param, "num不能为空", "");
      sendResp(returnData, response);
      return null;
    }
    if(param.num < 1){
      returnData.setReturnData(errorcode_param, "num必须大于0", "");
      sendResp(returnData, response);
      return null;
    }
    if(param.pay_price < 1 ){
      //pay_price必须大于0
      returnData.setReturnData(errorcode_param, "pay_price必须大于0", "");
      sendResp(returnData, response);
      return null;
    }*/
    if (RequestUtil.checkObjectBlank(param.address)) {
      returnData.setReturnData(errorcode_param, "address不能为空", "");
      sendResp(returnData, response);
      return null;
    }
    if (RequestUtil.checkObjectBlank(param.name)) {
      returnData.setReturnData(errorcode_param, "name不能为空", "");
      sendResp(returnData, response);
      return null;
    }
    if (RequestUtil.checkObjectBlank(param.telephone)) {
      returnData.setReturnData(errorcode_param, "telephone不能为空", "");
      sendResp(returnData, response);
      return null;
    }
    //MD5验证
    if (param.sign != null) {
      String sign_str = getSignature(Constants.getSystemKey(param.dtype),
              param.dtype,
              param.ui_id,
              param.type,
              param.t,
              param.token,
              param.telephone
              );
      //MD5散列(pay_type+uid+pay_price+t+token+app_key）
      if (!param.sign.equalsIgnoreCase(sign_str)) {
        log.warn("sign=" + param.sign + "  sign_str=" + sign_str);
        returnData.setReturnData(errorcode_param, " sign is not right", null);
        sendResp(returnData, response);
        return null;
      }
    }
    try {
      String ip = getIpAddr(request);
      if (ip.contains(",")) {
        ip = ip.split(",")[0].trim();
      }
//      if (ip == null || "".equals(ip) || ip.startsWith("192.168")) {
//        return null;
//      }
      //元 转变成分
//      int pay_price_fen = param.pay_price;
      String subject = "拼一把商品";//商品名称
/*      Wx_goods_order wx_goods_order = wxPayBiz.weixin_charge(returnData,param);

      if (wx_goods_order != null && returnData != null && "0".equalsIgnoreCase(returnData.getErrorno())) {
        long money = wx_goods_order.getMoney();*/
      Wx_user_pay user_pay = null;
//              wxPayBiz.weixin_charge_userpay(returnData,param);

      if (user_pay != null && returnData != null && "0".equalsIgnoreCase(returnData.getErrorno())) {
        int money = user_pay.getMoney();
//        subject = wx_goods_order.getG_name();
//        JSONObject obj = (JSONObject) JSONObject.toJSON(returnData.getData());
        if (money == 0) {
          returnData.setReturnData(errorcode_data, "微信充值失败", "");
          sendResp(returnData, response);
          return null;
        }
        String out_trade_no = user_pay.getCar_order_id();
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
        params.put("notify_url", getNotify_url());

        /**
         * 3、交易类型
         JSAPI--公众号支付、NATIVE--原生扫码支付、APP--app支付，统一下单接口trade_type的传参可参考这里
         MICROPAY--刷卡支付，刷卡支付有单独的支付接口，不调用统一下单接口
         */
        params.put("trade_type", "JSAPI");
        params.put("openid",param.openid);
        params.put("product_id", out_trade_no);
        String sign = getSign(params);
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
        Map<String, String> result = XMLBeanUtils.xml2Map(resultStr);
        if (result != null && getSign(result).equals(result.get("sign")) && "SUCCESS".equals(result.get("return_code")) && "SUCCESS".equals(result.get("result_code"))) {
          /*obj.put("orderInfo", result.get("code_url"));
          obj.put("sign", "");
          obj.put("timestamp", sf.format(new Date()));*/
          //记录到订单某字段




          returnData.setReturnData(errorcode_success, "微信充值成功", result);
          sendResp(returnData, response);
          return null;
        }
      }
      sendResp(returnData, response);
      return null;

    } catch (Throwable e) {
      log.error("Wx_WeiXin_JsApiPayAction.weixin_charge_face is error 用户微信充值", e);
      returnData.setReturnData(errorcode_systerm, "systerm is error", "");
    }
    sendResp(returnData, response);
    return null;
  }


  /**
   * 对支付参数信息进行签名
   *
   * @param params 待签名授权信息
   */
  public String getSign(Map<String, String> params) {
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
