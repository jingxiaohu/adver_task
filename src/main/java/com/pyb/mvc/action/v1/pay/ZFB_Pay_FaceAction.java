
package com.pyb.mvc.action.v1.pay;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.alipay.demo.trade.AlipayFace;
import com.alipay.util.SignUtils;
import com.alipay.vo.AlipayAppBean;
import com.pyb.bean.ReturnDataNew;
import com.pyb.bean.User_pay;
import com.pyb.constants.Constants;
import com.pyb.mvc.action.v1.BaseV1Controller;
import com.pyb.mvc.action.v1.notify.Notify_ZFBction;
import com.pyb.mvc.action.v1.pay.param.Param_zfb_charge_face;
import com.pyb.mvc.service.FaceUserPayBiz;
import com.pyb.util.MoneyUtil;
import com.pyb.util.RequestUtil;

/**
 * 支付宝 -- 用户充值
 *
 * @author jingxiaohu
 */
@Controller
@RequestMapping(value = "/v1")
public class ZFB_Pay_FaceAction extends BaseV1Controller {

	@Autowired
	protected FaceUserPayBiz userPayBiz;

  /**
   *
   */
  private static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private static final long serialVersionUID = -4402176190279046970L;
  //	private String notify="http://app.ie-colorful.com/v1/notify_lzf.php";
//  private static String APP_ID = "2016112103042572";
  private static String seller_id = "2088221584479981";
//  private static String APP_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
//  private static String APP_PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAO/iIEFBDFT53Y/AaFrX7SYtgzEsZ+/PWHwwU0M9eemFmfjYb2eBwTSFVDlVTaioqUTA2jfZCfKN/M1LnLRUpTPvgR9sYe/Zs+1cn3MrSgzoQ4wEcOY4XeCQ0G2Tt4k/jYT1txjAQMG9VAPiCrmh7NZXVTD19ZS0DiIiQH2gqNYPAgMBAAECgYEAxQ3wiSoyQyvuwcPA9b8i5JXGi4J67xhZC8t22mmJ2DcTwMOq4FBKsiZEhcR5Qu8p/XyexfnYnhPdc5eFZu2Rtnza7EWmj/3KDLdE8j/O/8jIqHZqyovLGVJFU+vr4a6MOFwYaQEaqOnLX/aCEbYatkySW+aAvQtNQELj+j79aOECQQD/SHEY1vS8EjVJHpy+XBeY2sP7M8yu9M8+sr46xUdt78ST2KksMaYZHZrZAVxiFOrn+MU9uq2/UAJIGsXRfrjVAkEA8I6ce29WA57kXoNcMdhfJH8WNzcfZuFF+48dOWkvpHiSN61gTCmJhaUVZGcKUXRh3Ilwy0krfM5Z5xls2nvFUwJASP46sGKOOdRu/ghNwzRr3t32mbY2+XOwanoLYJyWDv421BtoS+WqW5YWd6Qm+TiH7mo4Y60kDwbekCVvmLZGPQJAVacBsrWu07U0rS5qmljnb5BMsbZP2QrnJy4LAtEgJJjFv0tdWWEE1XA1UL2bn+snmSXa4pcYA+VZf36/EoA1fwJALH6UG+XADLbQws/NNi9lLQ1vEc0Tv9upYzfQfKo1bx1IkUPtiLqHzpRhSfLVviSVp6xNp2QiaFR8XgtNrRRc8Q==";
  public String getNotify_url() throws NoSuchMethodException {
    return ControllerLinkBuilder.linkTo(Notify_ZFBction.class,
        Notify_ZFBction.class.getMethod("notify_zfb", HttpServletRequest.class, HttpServletResponse.class)).withSelfRel().getHref()+ ".php";
  }

  @RequestMapping(value = "/zfb_charge_face")
  @ResponseBody
  public String zfb_charge_face(HttpServletRequest request, HttpServletResponse response,
      Param_zfb_charge_face param) {

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
    if (System.currentTimeMillis() - param.t > 3 * 60 * 1000) {
      //如果请求超出120秒则认为是 废弃请求
      returnData.setReturnData(errorcode_param, "是 废弃请求", "");
      sendResp(returnData, response);
      return null;
    }
    if (param.type < 1) {
      //type必须大于0
      returnData.setReturnData(errorcode_param, "type必须大于0", "");
      sendResp(returnData, response);
      return null;
    }
    if (param.pay_price < 1 && param.escape_money == 0) {
      //pay_price必须大于0
      returnData.setReturnData(errorcode_param, "pay_price必须大于0", "");
      sendResp(returnData, response);
      return null;
    }
    if (RequestUtil.checkObjectBlank(param.token)) {
      //token不能为空
      returnData.setReturnData(errorcode_param, "token不能为空", "");
      sendResp(returnData, response);
      return null;
    }
    //MD5验证
    if (param.sign != null) {
      String sign_str = getSignature(Constants.SYSTEM_KEY, param.dtype, param.ui_id, param.pay_type,
          param.pay_price, param.t, param.token);
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
//      if (ip == null || "".equals(ip) || ip.startsWith("192.168")) {
//        return null;
//      }
      //元 转变成分
      int pay_price_fen = param.pay_price;
      param.subject = "吾泊扫码支付";
      User_pay user_pay = userPayBiz
          .zfb_charge(returnData, param.pay_type, param.ui_id, pay_price_fen, param.version,
              param.system_type, param.subject, ip, param.token, param.type, param.orderid,param.escape_money,param.escape_orderids);

      if (returnData != null && "0".equalsIgnoreCase(returnData.getErrorno())) {
        long money = user_pay.getMoney();
        JSONObject obj = (JSONObject) JSONObject.toJSON(returnData.getData());
        if (money == 0) {
          returnData.setData(obj);
          sendResp(returnData, response);
          return null;
        }
        String out_trade_no = obj.getString("order_id");
        String qr_img = AlipayFace
            .trade_precreate(out_trade_no, param.subject,
                MoneyUtil.toYun(money).toString(),
                param.type + "", getNotify_url());
        String timestamp = sf.format(new Date());
        obj.put("orderInfo", qr_img == null ? "" : qr_img);
        obj.put("sign", "");
        obj.put("timestamp", timestamp);
        returnData.setData(obj);
        sendResp(returnData, response);
        return null;
      }
      sendResp(returnData, response);
      return null;

    } catch (Throwable e) {
      log.error("ZFB_Pay_faceAction.zfb_charge_face is error 用户支付宝充值", e);
      returnData.setReturnData("1", "-1", "");
    }
    sendResp(returnData, response);
    return null;
  }

  /**
   * 构造支付订单参数列表
   */
  public static Map<String, String> buildOrderParamMap(String app_id, AlipayAppBean appbean,
      String timestamp, String notify_url, int type, int system_type) {
    Map<String, String> keyValues = new HashMap<String, String>();

    keyValues.put("app_id", app_id);

    keyValues.put("biz_content", JSONObject.toJSONString(appbean));

    keyValues.put("charset", "utf-8");
    if (system_type == 4) {
      keyValues.put("method", "alipay.trade.precreate");
    } else {
      keyValues.put("method", "alipay.trade.app.pay");
    }

    keyValues.put("sign_type", "RSA");

    keyValues.put("timestamp", timestamp);

    keyValues.put("version", "1.0");

    keyValues.put("notify_url", notify_url);
    //设置透传参数
    keyValues.put("passback_params", type + "");
    return keyValues;
  }

  /**
   * 构造支付订单参数信息
   *
   * @param map 支付订单参数
   */
  public static String buildOrderParam(Map<String, String> map) {
    List<String> keys = new ArrayList<String>(map.keySet());
    Collections.sort(keys);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < keys.size() - 1; i++) {
      String key = keys.get(i);
      String value = map.get(key);
      sb.append(buildKeyValue(key, value, true));
      sb.append("&");
    }

    String tailKey = keys.get(keys.size() - 1);
    String tailValue = map.get(tailKey);
    sb.append(buildKeyValue(tailKey, tailValue, true));

    return sb.toString();
  }

  /**
   * 拼接键值对
   */
  private static String buildKeyValue(String key, String value, boolean isEncode) {
    StringBuilder sb = new StringBuilder();
    sb.append(key);
    sb.append("=");
    if (isEncode) {
      try {
        sb.append(URLEncoder.encode(value, "UTF-8"));
      } catch (UnsupportedEncodingException e) {
        sb.append(value);
      }
    } else {
      sb.append(value);
    }
    return sb.toString();
  }

  /**
   * 对支付参数信息进行签名
   *
   * @param map 待签名授权信息
   */
  public static String getSign(Map<String, String> map, String rsaKey) {
    List<String> keys = new ArrayList<String>(map.keySet());
    // key排序
    Collections.sort(keys);

    StringBuilder authInfo = new StringBuilder();
    for (int i = 0; i < keys.size() - 1; i++) {
      String key = keys.get(i);
      String value = map.get(key);
      authInfo.append(buildKeyValue(key, value, false));
      authInfo.append("&");
    }

    String tailKey = keys.get(keys.size() - 1);
    String tailValue = map.get(tailKey);
    authInfo.append(buildKeyValue(tailKey, tailValue, false));

    String oriSign = SignUtils.sign(authInfo.toString(), rsaKey);
    String encodedSign = "";

    try {
      encodedSign = URLEncoder.encode(oriSign, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return "sign=" + encodedSign;
  }
  /*public static void main(String[] args) throws Exception {
    Map<String, String> params = new HashMap<String,String>();
		params.put("a", "123");
		String sign = AlipaySignature.rsaSign(params, APP_PRIVATE_KEY, "UTF-8");
		params.put("sign", sign);
		System.out.println(AlipaySignature.rsaCheckV2(params, APP_PUBLIC_KEY, "UTF-8"));
	}*/
}
