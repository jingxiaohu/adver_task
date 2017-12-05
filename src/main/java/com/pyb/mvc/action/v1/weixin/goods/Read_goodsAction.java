
package com.pyb.mvc.action.v1.weixin.goods;

import com.pyb.bean.ReturnDataNew;
import com.pyb.mvc.action.v1.BaseV1Controller;
import com.pyb.mvc.action.v1.weixin.goods.param.Param_search_goods;
import com.pyb.mvc.weixin.biz.AdminGoodsBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取商品信息
 *
 * @author jingxiaohu
 */
@RestController
@RequestMapping(value = "/v1")
public class Read_goodsAction extends BaseV1Controller {

  /**
   *
   */
  private static final long serialVersionUID = 6891425545908564737L;

  @Autowired
  AdminGoodsBiz adminGoodsBiz;

  /**
   * 获取joke分类
   */
  @RequestMapping(value = "/search_goods")
  @ResponseBody
  public String search_goods(HttpServletRequest request, HttpServletResponse response,
                          Param_search_goods param) {


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
      /*if (!param.checkRequest()) {
        returnData.setReturnData(errorcode_param, "没有进行参数签名认证", "");
        sendResp(returnData, response);
        return null;
      }*/
      //对封装的参数对象中的属性进行 非空等规则验证
      //检查是否是合法请求
      /*String ip = getIpAddr(request);
      if (ip.startsWith("192.168") || ip.startsWith("127.0")) {
        ip = null;
      }*/
      /*if (RequestUtil.checkObjectBlank(param.sign)) {
        returnData.setReturnData(errorcode_param, " sign is null", null);
        sendResp(returnData, response);
        return null;
      }*/
      /*if (param.ui_id < 1) {
        returnData.setReturnData(errorcode_param, " ui_id is smaller than zero", null);
        sendResp(returnData, response);
        return null;
      }*/
      /*String sign_str = getSignature(Constants.getSystemKey(param.dtype), param.dtype);
      if (!param.sign.equalsIgnoreCase(sign_str)) {
        log.warn("sign=" + param.sign + "  sign_str=" + sign_str);
        returnData.setReturnData(errorcode_param, " sign is not right", null);
        sendResp(returnData, response);
        return null;
      }*/

      adminGoodsBiz.SearchGoods(returnData,param);
      sendResp(returnData, response);
      return null;

    } catch (Exception e) {
      log.error("search_goods is error  2.21	Read-获取商品基本信息 - P", e);
      returnData.setReturnData(errorcode_systerm, "system is error", "");
    }
    sendResp(returnData, response);
    return null;
  }


}
