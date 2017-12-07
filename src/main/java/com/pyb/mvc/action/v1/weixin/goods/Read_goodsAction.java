
package com.pyb.mvc.action.v1.weixin.goods;

import com.pyb.bean.ReturnDataNew;
import com.pyb.constants.Constants;
import com.pyb.mvc.action.v1.BaseV1Controller;
import com.pyb.mvc.action.v1.weixin.goods.param.Param_goods_info;
import com.pyb.mvc.action.v1.weixin.goods.param.Param_goods_list;
import com.pyb.mvc.action.v1.weixin.goods.param.Param_search_goods_class;
import com.pyb.mvc.weixin.biz.GoodsBiz;
import com.pyb.util.RequestUtil;
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
  GoodsBiz goodsBiz;

  /**
   * 1.1 通过分类获取商品列表
   */
  @RequestMapping(value = "/goods/search_goods_class")
  @ResponseBody
  public String search_goods_class(HttpServletRequest request, HttpServletResponse response, Param_search_goods_class param) {


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
      //对封装的参数对象中的属性进行 非空等规则验证
      if (RequestUtil.checkObjectBlank(param.sign)) {
        returnData.setReturnData(errorcode_param, " sign is null", "");
        sendResp(returnData, response);
        return null;
      }
      if (param.getGt_id() == null) {
        returnData.setReturnData(errorcode_param, " gt_id is null", "");
        sendResp(returnData, response);
        return null;
      }
      String sign_str = getSignature(Constants.getSystemKey(param.dtype), param.getGt_id());
      if (!param.sign.equalsIgnoreCase(sign_str)) {
        log.warn("sign=" + param.sign + "  sign_str=" + sign_str);
        returnData.setReturnData(errorcode_param, " sign is not right", null);
        sendResp(returnData, response);
        return null;
      }

      goodsBiz.SearchGoodsByClass(returnData,param);
      sendResp(returnData, response);
      return null;

    } catch (Exception e) {
      log.error("search_goods_class is error  通过分类获取商品列表 - P", e);
      returnData.setReturnData(errorcode_systerm, "system is error", "");
    }
    sendResp(returnData, response);
    return null;
  }


  /**
   * 1.2 通过类型获取商品列表
   */
  @RequestMapping(value = "/goods/goods_list")
  @ResponseBody
  public String goods_list(HttpServletRequest request, HttpServletResponse response, Param_goods_list param) {


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
      //对封装的参数对象中的属性进行 非空等规则验证
      if (RequestUtil.checkObjectBlank(param.sign)) {
        returnData.setReturnData(errorcode_param, " sign is null", "");
        sendResp(returnData, response);
        return null;
      }
      String sign_str = getSignature(Constants.getSystemKey(param.dtype), param.dtype);
      if (!param.sign.equalsIgnoreCase(sign_str)) {
        log.warn("sign=" + param.sign + "  sign_str=" + sign_str);
        returnData.setReturnData(errorcode_param, " sign is not right", null);
        sendResp(returnData, response);
        return null;
      }

      goodsBiz.goodsList(returnData,param);
      sendResp(returnData, response);
      return null;

    } catch (Exception e) {
      log.error("goods_list is error  通过分类获取商品列表 - P", e);
      returnData.setReturnData(errorcode_systerm, "system is error", "");
    }
    sendResp(returnData, response);
    return null;
  }



  /**
   * 1.3 获取商品信息
   */
  @RequestMapping(value = "/goods/goods_info")
  @ResponseBody
  public String goods_info(HttpServletRequest request, HttpServletResponse response, Param_goods_info param) {


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
      //对封装的参数对象中的属性进行 非空等规则验证
      if (RequestUtil.checkObjectBlank(param.sign)) {
        returnData.setReturnData(errorcode_param, " sign is null", "");
        sendResp(returnData, response);
        return null;
      }
      if (param.getG_id() == null) {
        returnData.setReturnData(errorcode_param, " g_id is null", "");
        sendResp(returnData, response);
        return null;
      }
      String sign_str = getSignature(Constants.getSystemKey(param.dtype), param.getG_id());
      if (!param.sign.equalsIgnoreCase(sign_str)) {
        log.warn("sign=" + param.sign + "  sign_str=" + sign_str);
        returnData.setReturnData(errorcode_param, " sign is not right", null);
        sendResp(returnData, response);
        return null;
      }

      goodsBiz.goodsInfo(returnData,param);
      sendResp(returnData, response);
      return null;

    } catch (Exception e) {
      log.error("goods_info is error  获取商品详情信息 - P", e);
      returnData.setReturnData(errorcode_systerm, "system is error", "");
    }
    sendResp(returnData, response);
    return null;
  }
}
