
package com.pyb.mvc.action.v1.weixin.user;

import com.pyb.bean.ReturnDataNew;
import com.pyb.constants.Constants;
import com.pyb.mvc.action.v1.BaseV1Controller;
import com.pyb.mvc.action.v1.weixin.user.param.Param_user_withdraw;
import com.pyb.mvc.action.v1.weixin.user.param.Param_user_withdraw_complement;
import com.pyb.mvc.weixin.biz.UserManageBiz;
import com.pyb.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 合作人提现
 *
 * @author jingxiaohu
 */
@RestController
@RequestMapping(value = "/v1")
public class Write_UserWithdrawAction extends BaseV1Controller {

  /**
   *
   */
  private static final long serialVersionUID = 6891425545908564737L;

  @Autowired
  UserManageBiz userManageBiz;

  /**
   * 合作人提现
   */
  @RequestMapping(value = "/goods/user_withdraw")
  @ResponseBody
  public String user_withdraw(HttpServletRequest request, HttpServletResponse response, Param_user_withdraw param) {


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
      if (RequestUtil.checkObjectBlank(param.getMoney())) {
        returnData.setReturnData(errorcode_param, " money is null", "");
        sendResp(returnData, response);
        return null;
      }else{
        if(param.getMoney() < 5000){
          //小于50元钱不允许提现
          returnData.setReturnData(errorcode_param, " 提现最小金额要50元以上", "");
          sendResp(returnData, response);
          return null;
        }
      }

      //对封装的参数对象中的属性进行 非空等规则验证
      if (RequestUtil.checkObjectBlank(param.sign)) {
        returnData.setReturnData(errorcode_param, " sign is null", "");
        sendResp(returnData, response);
        return null;
      }
      String sign_str = getSignature(Constants.getSystemKey(param.dtype), param.ui_id,param.getMoney());
      if (!param.sign.equalsIgnoreCase(sign_str)) {
        log.warn("sign=" + param.sign + "  sign_str=" + sign_str);
        returnData.setReturnData(errorcode_param, " sign is not right", null);
        sendResp(returnData, response);
        return null;
      }

      userManageBiz.UserWithDraw(returnData,param);
      sendResp(returnData, response);
      return null;

    } catch (Exception e) {
      log.error("Write_UserWithdrawAction.user_withdraw is error  合作人提现 - P", e);
      returnData.setReturnData(errorcode_systerm, "system is error", "");
    }
    sendResp(returnData, response);
    return null;
  }

  /**
   * 合作人完善个人提现信息
   */
  @RequestMapping(value = "/goods/user_withdraw_complement")
  @ResponseBody
  public String user_withdraw_complement(HttpServletRequest request, HttpServletResponse response, Param_user_withdraw_complement param) {


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
      if (RequestUtil.checkObjectBlank(param.getTelephone())) {
        returnData.setReturnData(errorcode_param, " telephone is null", "");
        sendResp(returnData, response);
        return null;
      }else{
        if(!isMobileNO(param.getTelephone())){
          //不是正确的电话号码
          returnData.setReturnData(errorcode_param, " telephone is not right", "");
          sendResp(returnData, response);
          return null;
        }
      }
      if (RequestUtil.checkObjectBlank(param.getUser_weixin())) {
        returnData.setReturnData(errorcode_param, " user_weixin is null", "");
        sendResp(returnData, response);
        return null;
      }
      //对封装的参数对象中的属性进行 非空等规则验证
      if (RequestUtil.checkObjectBlank(param.sign)) {
        returnData.setReturnData(errorcode_param, " sign is null", "");
        sendResp(returnData, response);
        return null;
      }
      String sign_str = getSignature(Constants.getSystemKey(param.dtype), param.ui_id,param.getTelephone(),param.getUser_weixin());
      if (!param.sign.equalsIgnoreCase(sign_str)) {
        log.warn("sign=" + param.sign + "  sign_str=" + sign_str);
        returnData.setReturnData(errorcode_param, " sign is not right", null);
        sendResp(returnData, response);
        return null;
      }

      userManageBiz.UserWithDrawComplement(returnData,param);
      sendResp(returnData, response);
      return null;

    } catch (Exception e) {
      log.error("Write_UserWithdrawAction.user_withdraw_complement is error  合作人完善个人提现信息 - P", e);
      returnData.setReturnData(errorcode_systerm, "system is error", "");
    }
    sendResp(returnData, response);
    return null;
  }


}
