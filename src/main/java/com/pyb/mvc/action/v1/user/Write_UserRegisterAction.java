
package com.pyb.mvc.action.v1.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pyb.bean.ReturnDataNew;
import com.pyb.constants.Constants;
import com.pyb.mvc.action.v1.BaseV1Controller;
import com.pyb.mvc.action.v1.user.param.Param_reg;
import com.pyb.mvc.service.UserBiz;
import com.pyb.util.RequestUtil;

/**
 * 用户注册
 *
 * @author jingxiaohu
 */
@Controller
@RequestMapping(value = "/v1")
public class Write_UserRegisterAction extends BaseV1Controller {

  @Autowired
  private UserBiz userBiz;
  /**
   * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
   */
  private static final long serialVersionUID = -3599663972160625263L;

  @RequestMapping(value = "/reg")
  @ResponseBody
  public String UserRegister(HttpServletRequest request, HttpServletResponse response,Param_reg param) {
    ReturnDataNew returnData = new ReturnDataNew();
    try {
      //检查是否是合法请求
      String ip = getIpAddr(request);
      if (ip.startsWith("192.168") || ip.startsWith("127.0")) {
        ip = null;
      }
      //参数检查
      if(!checkParam( returnData, param)){
    	  sendResp(returnData, response);
          return null;
      }

      String sign_str = getSignature(Constants.getSystemKey(param.dtype), param.dtype, param.tel,
          param.verify_code,
          param.verify_list, param.vclass, param.password);
      if (!param.sign.equalsIgnoreCase(sign_str)) {
        log.warn("sign=" + param.sign + "  sign_str=" + sign_str);
        returnData.setReturnData(errorcode_param, " sign is not right", "");
        sendResp(returnData, response);
        return null;
      }

      userBiz.ReturnUserRegister(returnData, param.dtype, param.tel, param.verify_code,
          param.verify_list, param.vclass, param.password,param.reg_type);
      sendResp(returnData, response);
      return null;

    } catch (Exception e) {
      log.error("UserRegister is error  2.21	Read-注册 (APPSDK-JAVA)- P", e);
      returnData.setReturnData(errorcode_systerm, "system is error", "");
    }
    sendResp(returnData, response);
    return null;
  }

  /**
   * 参数检查
   */
  public boolean checkParam(ReturnDataNew returnData,Param_reg param){
      if (param == null) {
          //参数传递错误
          returnData.setReturnData(errorcode_param, "参数传递错误", "");
          return false;
        }
        //检查是否进行了参数签名认证
        if (!param.checkRequest()) {
          returnData.setReturnData(errorcode_param, "没有进行参数签名认证", "");
          return false;
        }
        //对封装的参数对象中的属性进行 非空等规则验证
        if (RequestUtil.checkObjectBlank(param.tel)) {
          returnData.setReturnData(errorcode_param, " tel is null", "");
          return false;
        }
        if(param.reg_type == 2){
        	  if (!isMobileNO(param.tel)) {
                 returnData.setReturnData(errorcode_param, "请输入正确的电话号码,亲", "");
                 return false;
               }
        }else{
      	  if (!isEmail(param.tel)) {
    	        returnData.setReturnData(errorcode_param, " 邮箱格式不正确,亲", "");
    	        return false;
    	    }
        }
       
        if (RequestUtil.checkObjectBlank(param.verify_code)) {
          returnData.setReturnData(errorcode_param, " verify_code is null", "");
          return false;
        }
        if (RequestUtil.checkObjectBlank(param.verify_list)) {
          returnData.setReturnData(errorcode_param, " verify_list is null", "");
          return false;
        }
        if (RequestUtil.checkObjectBlank(param.vclass)) {
          returnData.setReturnData(errorcode_param, " vclass is null", "");
          return false;
        }
        if (RequestUtil.checkObjectBlank(param.password)) {
          returnData.setReturnData(errorcode_param, " password is null", "");
          return false;
        }
        if (param.password.length() < 6 && param.password.length() > 16) {
          returnData.setReturnData(errorcode_param, "密码必须大于5位小于17位", "");
          return false;
        }
        
        if(param.getReg_type() == null){
        	 returnData.setReturnData(errorcode_param, " reg_type is null", "");
             return false;
        }
	  
	  return true;
  }
  
}
