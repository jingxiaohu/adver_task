
package com.pyb.mvc.action.v1.channel;

import com.pyb.bean.ReturnDataNew;
import com.pyb.constants.Constants;
import com.pyb.mvc.action.v1.BaseV1Controller;
import com.pyb.mvc.action.v1.channel.param.Param_MenuList;
import com.pyb.mvc.service.ChannelBiz;
import com.pyb.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 读取频道信息列表
 *
 * @author jingxiaohu
 */
@Controller
@RequestMapping(value = "/v1")
public class Read_menuAction extends BaseV1Controller {

  /**
   *
   */
  private static final long serialVersionUID = 6891425545908564737L;

  @Autowired
  private ChannelBiz channelBiz;

  /**
   * 读取频道信息列表
   */
  @RequestMapping(value = "/menu_list")
  @ResponseBody
  public String menu_list(HttpServletRequest request, HttpServletResponse response,
                          Param_MenuList param) {

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
      //检查是否是合法请求
      String ip = getIpAddr(request);
      if (ip.startsWith("192.168") || ip.startsWith("127.0")) {
        ip = null;
      }
      if (RequestUtil.checkObjectBlank(param.sign)) {
        returnData.setReturnData(errorcode_param, " sign is null", "");
        sendResp(returnData, response);
        return null;
      }
      if (param.ui_id < 1) {
        returnData.setReturnData(errorcode_param, " ui_id is smaller than zero", "");
        sendResp(returnData, response);
        return null;
      }

      String sign_str = getSignature(Constants.getSystemKey(param.dtype), param.dtype,param.ui_id);
      if (!param.sign.equalsIgnoreCase(sign_str)) {
        log.warn("sign=" + param.sign + "  sign_str=" + sign_str);
        returnData.setReturnData(errorcode_param, " sign is not right", null);
        sendResp(returnData, response);
        return null;
      }
      channelBiz.ReturnMenuList(returnData, param.dtype,param.ui_id,param.page,param.size);
      sendResp(returnData, response);
      return null;

    } catch (Exception e) {
      log.error(
          "Read_menuAction.ReturnMenuList is error  2.21	Read-读取菜单列表 (APPSDK-JAVA)- P", e);
      returnData.setReturnData(errorcode_systerm, "system is error", "");
    }
    sendResp(returnData, response);
    return null;
  }

  /**
   * 读取频道信息列表
   */
  @RequestMapping(value = "/menu_list2")
  @ResponseBody
  public String menu_list2(HttpServletRequest request, HttpServletResponse response,
                          Param_MenuList param) {

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
      //检查是否是合法请求
      String ip = getIpAddr(request);
      if (ip.startsWith("192.168") || ip.startsWith("127.0")) {
        ip = null;
      }
      if (RequestUtil.checkObjectBlank(param.sign)) {
        returnData.setReturnData(errorcode_param, " sign is null", "");
        sendResp(returnData, response);
        return null;
      }
      if (param.ui_id < 1) {
        returnData.setReturnData(errorcode_param, " ui_id is smaller than zero", "");
        sendResp(returnData, response);
        return null;
      }
      if (RequestUtil.checkObjectBlank(param.term_id)) {
        returnData.setReturnData(errorcode_param, " term_id is null", "");
        sendResp(returnData, response);
        return null;
      }
      if (RequestUtil.checkObjectBlank(param.slug)) {
        returnData.setReturnData(errorcode_param, " slug is null", "");
        sendResp(returnData, response);
        return null;
      }
      String sign_str = getSignature(Constants.getSystemKey(param.dtype), param.dtype,param.ui_id,param.term_id,param.slug);
      if (!param.sign.equalsIgnoreCase(sign_str)) {
        log.warn("sign=" + param.sign + "  sign_str=" + sign_str);
        returnData.setReturnData(errorcode_param, " sign is not right", null);
        sendResp(returnData, response);
        return null;
      }
      channelBiz.ReturnMenuList2(returnData, param.dtype,param.ui_id,param.term_id,param.slug,param.page,param.size);
      sendResp(returnData, response);
      return null;

    } catch (Exception e) {
      log.error(
              "Read_menuAction.ReturnMenuList2 is error  2.21	Read-读取菜单列表 (APPSDK-JAVA)- P", e);
      returnData.setReturnData(errorcode_systerm, "system is error", "");
    }
    sendResp(returnData, response);
    return null;
  }
}
