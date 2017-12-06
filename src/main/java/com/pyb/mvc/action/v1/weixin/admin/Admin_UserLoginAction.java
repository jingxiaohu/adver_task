
package com.pyb.mvc.action.v1.weixin.admin;

import com.pyb.bean.ReturnDataNew;
import com.pyb.constants.ConstantsAdmin;
import com.pyb.mvc.action.v1.BaseV1Controller;
import com.pyb.mvc.action.v1.weixin.admin.param.Param_AdminUserLogin;
import com.pyb.mvc.weixin.biz.admin.AdminUserBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 后台用户管理
 *
 * @author jingxiaohu
 */
@RestController
@RequestMapping(value = "/v1")
public class Admin_UserLoginAction extends BaseV1Controller {

  /**
   *
   */
  private static final long serialVersionUID = 6891425545908564737L;

  @Autowired
  AdminUserBiz adminUserBiz;

  /**
   * 获取joke分类
   */
  @RequestMapping(value = "/admin/admin_userlogin")
  @ResponseBody
  public ModelAndView admin_userlogin(HttpServletRequest request, HttpServletResponse response,Param_AdminUserLogin param, Model model) {


    ReturnDataNew returnData = new ReturnDataNew();
    try {
      //参数检查
      if (param == null) {
        //参数传递错误
        returnData.setReturnData(errorcode_param, "参数传递错误", "");
        sendResp(returnData, response);
        return null;
      }
      if (!StringUtils.hasLength(param.getLoginname())) {
        returnData.setReturnData(errorcode_param, " loginname is null", "");
        sendResp(returnData, response);
        return null;
      }
      if (!StringUtils.hasLength(param.getPassword())) {
        returnData.setReturnData(errorcode_param, " password is null", "");
        sendResp(returnData, response);
        return null;
      }
      adminUserBiz.AdminLogin(returnData,param);
      if("0".equalsIgnoreCase(returnData.getErrorno())){
        //成功
        request.getSession().setAttribute(ConstantsAdmin.CURRENT_USER, returnData.getData());
        return new ModelAndView("redirect:/admin/goods_list");
      }
    } catch (Exception e) {
      log.error("admin_userlogin is error 用户登录失败", e);
    }
    model.addAttribute("msg", "登陆失败，请重新登陆!");
    return new ModelAndView("login");
  }


}
