
package com.pyb.mvc.action.v1.weixin.order;

import com.pyb.bean.ReturnDataNew;
import com.pyb.constants.Constants;
import com.pyb.mvc.action.v1.BaseV1Controller;
import com.pyb.mvc.action.v1.weixin.order.param.Param_order;
import com.pyb.mvc.weixin.biz.UserOrderBiz;
import com.pyb.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户取消订单  用户下单
 *
 * @author jingxiaohu
 */
@RestController
@RequestMapping(value = "/v1")
public class Write_userOrderAction extends BaseV1Controller {

  /**
   *
   */
  private static final long serialVersionUID = 6891425545908564737L;

  @Autowired
  UserOrderBiz userOrderBiz;

  /**
   * 用户取消订单
   */
  @RequestMapping(value = "/goods/order_cancel")
  @ResponseBody
  public String order_cancel(HttpServletRequest request, HttpServletResponse response, Param_order param) {


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
      if (RequestUtil.checkObjectBlank(param.getUi_id())) {
        returnData.setReturnData(errorcode_param, " ui_id is null", "");
        sendResp(returnData, response);
        return null;
      }
      if (RequestUtil.checkObjectBlank(param.getGo_id())) {
        returnData.setReturnData(errorcode_param, " go_id is null", "");
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
      String sign_str = getSignature(Constants.getSystemKey(param.dtype),param.getUi_id(),param.getGo_id(),param.getOrder_id());
      if (!param.sign.equalsIgnoreCase(sign_str)) {
        log.warn("sign=" + param.sign + "  sign_str=" + sign_str);
        returnData.setReturnData(errorcode_param, " sign is not right", null);
        sendResp(returnData, response);
        return null;
      }

      userOrderBiz.UserCancelOrder(returnData,param);
      sendResp(returnData, response);
      return null;

    } catch (Exception e) {
      log.error("order_cancel is error  用户取消订单 - P", e);
      returnData.setReturnData(errorcode_systerm, "system is error", "");
    }
    sendResp(returnData, response);
    return null;
  }


}