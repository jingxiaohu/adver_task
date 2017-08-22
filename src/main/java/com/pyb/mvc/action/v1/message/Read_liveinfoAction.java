
package com.pyb.mvc.action.v1.message;

import com.pyb.bean.ReturnDataNew;
import com.pyb.constants.Constants;
import com.pyb.mvc.action.v1.BaseV1Controller;
import com.pyb.mvc.action.v1.message.param.Param_liveinfo;
import com.pyb.mvc.service.MessageBiz;
import com.pyb.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取直播消息
 *
 * @author jingxiaohu
 */
@Controller
@RequestMapping(value = "/v1")
public class Read_liveinfoAction extends BaseV1Controller {

  /**
   *
   */
  private static final long serialVersionUID = 6891425545908564737L;

  @Autowired
  private MessageBiz messageBiz;

  /**
   * 获取直播消息
   */
  @RequestMapping(value = "/live_info")
  @ResponseBody
  public String live_info(HttpServletRequest request, HttpServletResponse response,
                            Param_liveinfo param) {

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
        returnData.setReturnData(errorcode_param, " sign is null", null);
        sendResp(returnData, response);
        return null;
      }
      /*if (param.ui_id < 1) {
        returnData.setReturnData(errorcode_param, " ui_id is smaller than zero", null);
        sendResp(returnData, response);
        return null;
      }*/
      if(RequestUtil.checkObjectBlank(param.ci_id)){
        returnData.setReturnData(errorcode_param, " ci_id is null", null);
        sendResp(returnData,response);
        return null;
      }

      String sign_str = getSignature(Constants.getSystemKey(param.dtype), param.dtype,param.ci_id);
      if (!param.sign.equalsIgnoreCase(sign_str)) {
        log.warn("sign=" + param.sign + "  sign_str=" + sign_str);
        returnData.setReturnData(errorcode_param, " sign is not right", null);
        sendResp(returnData, response);
        return null;
      }

      messageBiz.ReturnLiveInfo(returnData, param.dtype,param.ci_id,param.mi_id,param.page,param.size,param.type);
      sendResp(returnData, response);
      return null;

    } catch (Exception e) {
      log.error(
          "Read_userinfoAction.ReturnReadMyInfo is error  2.21	Read-获取我的基本信息 (APPSDK-JAVA)- P", e);
      returnData.setReturnData(errorcode_systerm, "system is error", "");
    }
    sendResp(returnData, response);
    return null;
  }

  /********************接收参数区*************************/

  /************************get set 方法区****************************/


}