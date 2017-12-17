
package com.pyb.mvc.action.v1.weixin.user;

import com.pyb.bean.ReturnDataNew;
import com.pyb.constants.Constants;
import com.pyb.mvc.action.v1.BaseV1Controller;
import com.pyb.mvc.action.v1.user.param.Param_addOrUpdate_Address;
import com.pyb.mvc.action.v1.user.param.Param_del_Address;
import com.pyb.mvc.weixin.biz.UserManageBiz;
import com.pyb.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 新增地址
 *
 * @author jingxiaohu
 */
@RestController
@RequestMapping(value = "/v1")
public class Write_UserAddressAction extends BaseV1Controller {

  /**
   *
   */
  private static final long serialVersionUID = 6891425545908564737L;

  @Autowired
  UserManageBiz userManageBiz;

  /**
   * 新增地址
   */
  @RequestMapping(value = "/goods/add_address")
  @ResponseBody
  public String add_address(HttpServletRequest request, HttpServletResponse response, Param_addOrUpdate_Address param) {


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
      if (RequestUtil.checkObjectBlank(param.getName())) {
        returnData.setReturnData(errorcode_param, " name is null", "");
        sendResp(returnData, response);
        return null;
      }
      if (RequestUtil.checkObjectBlank(param.getTelephone())) {
        returnData.setReturnData(errorcode_param, " telephone is null", "");
        sendResp(returnData, response);
        return null;
      }
      if (RequestUtil.checkObjectBlank(param.getArea())) {
        returnData.setReturnData(errorcode_param, " area is null", "");
        sendResp(returnData, response);
        return null;
      }
      if (RequestUtil.checkObjectBlank(param.getAddress())) {
        returnData.setReturnData(errorcode_param, " address is null", "");
        sendResp(returnData, response);
        return null;
      }

      //对封装的参数对象中的属性进行 非空等规则验证
      if (RequestUtil.checkObjectBlank(param.sign)) {
        returnData.setReturnData(errorcode_param, " sign is null", "");
        sendResp(returnData, response);
        return null;
      }
      String sign_str = getSignature(Constants.getSystemKey(param.dtype), param.ui_id);
      if (!param.sign.equalsIgnoreCase(sign_str)) {
        log.warn("sign=" + param.sign + "  sign_str=" + sign_str);
        returnData.setReturnData(errorcode_param, " sign is not right", null);
        sendResp(returnData, response);
        return null;
      }

      userManageBiz.AddAddress(returnData,param);
      sendResp(returnData, response);
      return null;

    } catch (Exception e) {
      log.error("Write_UserAddressAction.add_address is error  新增地址 - P", e);
      returnData.setReturnData(errorcode_systerm, "system is error", "");
    }
    sendResp(returnData, response);
    return null;
  }
  /**
   * 修改地址
   */
  @RequestMapping(value = "/goods/up_address")
  @ResponseBody
  public String up_address(HttpServletRequest request, HttpServletResponse response, Param_addOrUpdate_Address param) {


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

      if (RequestUtil.checkObjectBlank(param.getUa_id())) {
        returnData.setReturnData(errorcode_param, " ua_id is null", "");
        sendResp(returnData, response);
        return null;
      }

      if (RequestUtil.checkObjectBlank(param.getUi_id())) {
        returnData.setReturnData(errorcode_param, " ui_id is null", "");
        sendResp(returnData, response);
        return null;
      }
      if (RequestUtil.checkObjectBlank(param.getName())) {
        returnData.setReturnData(errorcode_param, " name is null", "");
        sendResp(returnData, response);
        return null;
      }
      if (RequestUtil.checkObjectBlank(param.getTelephone())) {
        returnData.setReturnData(errorcode_param, " telephone is null", "");
        sendResp(returnData, response);
        return null;
      }
      if (RequestUtil.checkObjectBlank(param.getArea())) {
        returnData.setReturnData(errorcode_param, " area is null", "");
        sendResp(returnData, response);
        return null;
      }
      if (RequestUtil.checkObjectBlank(param.getAddress())) {
        returnData.setReturnData(errorcode_param, " address is null", "");
        sendResp(returnData, response);
        return null;
      }

      //对封装的参数对象中的属性进行 非空等规则验证
      if (RequestUtil.checkObjectBlank(param.sign)) {
        returnData.setReturnData(errorcode_param, " sign is null", "");
        sendResp(returnData, response);
        return null;
      }
      String sign_str = getSignature(Constants.getSystemKey(param.dtype), param.ui_id);
      if (!param.sign.equalsIgnoreCase(sign_str)) {
        log.warn("sign=" + param.sign + "  sign_str=" + sign_str);
        returnData.setReturnData(errorcode_param, " sign is not right", null);
        sendResp(returnData, response);
        return null;
      }

      userManageBiz.upAddress(returnData,param);
      sendResp(returnData, response);
      return null;

    } catch (Exception e) {
      log.error("Write_UserAddressAction.upAddress is error  修改地址 - P", e);
      returnData.setReturnData(errorcode_systerm, "system is error", "");
    }
    sendResp(returnData, response);
    return null;
  }

  /**
   * 删除地址
   */
  @RequestMapping(value = "/goods/del_address")
  @ResponseBody
  public String del_address(HttpServletRequest request, HttpServletResponse response, Param_del_Address param) {


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
      if (RequestUtil.checkObjectBlank(param.getUa_id())) {
        returnData.setReturnData(errorcode_param, " ua_id is null", "");
        sendResp(returnData, response);
        return null;
      }
      //对封装的参数对象中的属性进行 非空等规则验证
      if (RequestUtil.checkObjectBlank(param.sign)) {
        returnData.setReturnData(errorcode_param, " sign is null", "");
        sendResp(returnData, response);
        return null;
      }
      String sign_str = getSignature(Constants.getSystemKey(param.dtype), param.ui_id);
      if (!param.sign.equalsIgnoreCase(sign_str)) {
        log.warn("sign=" + param.sign + "  sign_str=" + sign_str);
        returnData.setReturnData(errorcode_param, " sign is not right", null);
        sendResp(returnData, response);
        return null;
      }

      userManageBiz.DelAddress(returnData,param);
      sendResp(returnData, response);
      return null;

    } catch (Exception e) {
      log.error("Write_UserAddressAction.del_address is error 删除地址 - P", e);
      returnData.setReturnData(errorcode_systerm, "system is error", "");
    }
    sendResp(returnData, response);
    return null;
  }




  /**
   * 设置为默认地址
   */
  @RequestMapping(value = "/goods/isdefault_address")
  @ResponseBody
  public String isdefault_address(HttpServletRequest request, HttpServletResponse response, Param_del_Address param) {


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

      if (RequestUtil.checkObjectBlank(param.getUa_id())) {
        returnData.setReturnData(errorcode_param, " ua_id is null", "");
        sendResp(returnData, response);
        return null;
      }

      if (RequestUtil.checkObjectBlank(param.getUi_id())) {
        returnData.setReturnData(errorcode_param, " ui_id is null", "");
        sendResp(returnData, response);
        return null;
      }
      //对封装的参数对象中的属性进行 非空等规则验证
      if (RequestUtil.checkObjectBlank(param.sign)) {
        returnData.setReturnData(errorcode_param, " sign is null", "");
        sendResp(returnData, response);
        return null;
      }
      String sign_str = getSignature(Constants.getSystemKey(param.dtype), param.ui_id);
      if (!param.sign.equalsIgnoreCase(sign_str)) {
        log.warn("sign=" + param.sign + "  sign_str=" + sign_str);
        returnData.setReturnData(errorcode_param, " sign is not right", null);
        sendResp(returnData, response);
        return null;
      }

      userManageBiz.isdefault_address(returnData,param);
      sendResp(returnData, response);
      return null;

    } catch (Exception e) {
      log.error("Write_UserAddressAction.isdefault_address is error  设置默认地址 - P", e);
      returnData.setReturnData(errorcode_systerm, "system is error", "");
    }
    sendResp(returnData, response);
    return null;
  }
}
