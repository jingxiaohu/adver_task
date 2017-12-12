
package com.pyb.mvc.action.v1.weixin.order;

import com.pyb.bean.ReturnDataNew;
import com.pyb.constants.Constants;
import com.pyb.mvc.action.v1.BaseV1Controller;
import com.pyb.mvc.action.v1.weixin.order.param.Param_kdwl;
import com.pyb.mvc.weixin.biz.UserOrderBiz;
import com.pyb.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取订单快递信息列表
 *
 * @author jingxiaohu
 */
@RestController
@RequestMapping(value = "/v1")
public class Read_KDAction extends BaseV1Controller {

  /**
   *
   */
  private static final long serialVersionUID = 6891425545908564737L;

  @Autowired
  UserOrderBiz userOrderBiz;

  /**
   * 获取订单快递信息列表
   */
  @RequestMapping(value = "/goods/kdwl")
  @ResponseBody
  public String kdwl(HttpServletRequest request, HttpServletResponse response, Param_kdwl param) {


    ReturnDataNew returnData = new ReturnDataNew();
    try {
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

      if (RequestUtil.checkObjectBlank(param.getOrder_id())) {
        returnData.setReturnData(errorcode_param, " order_id is null", "");
        sendResp(returnData, response);
        return null;
      }

      //对封装的参数对象中的属性进行 非空等规则验证
      if (RequestUtil.checkObjectBlank(param.sign)) {
        returnData.setReturnData(errorcode_param, " sign is null", "");
        sendResp(returnData, response);
        return null;
      }
      String sign_str = getSignature(Constants.getSystemKey(param.dtype), param.dtype,param.getOrder_id());
      if (!param.sign.equalsIgnoreCase(sign_str)) {
        log.warn("sign=" + param.sign + "  sign_str=" + sign_str);
        returnData.setReturnData(errorcode_param, " sign is not right", null);
        sendResp(returnData, response);
        return null;
      }

      userOrderBiz.GainOrderKDWL(returnData,param);
      sendResp(returnData, response);
      return null;

    } catch (Exception e) {
      log.error("kdwl is error  获取用户订单列表 - P", e);
      returnData.setReturnData(errorcode_systerm, "system is error", "");
    }
    sendResp(returnData, response);
    return null;
  }


}
