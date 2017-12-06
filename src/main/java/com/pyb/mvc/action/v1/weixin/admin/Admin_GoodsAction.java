
package com.pyb.mvc.action.v1.weixin.admin;

import com.pyb.bean.ReturnDataNew;
import com.pyb.mvc.action.v1.BaseV1Controller;
import com.pyb.mvc.action.v1.weixin.admin.param.Param_AdminGoods;
import com.pyb.mvc.weixin.biz.admin.AdminGoodsBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 后台商品管理
 *
 * @author jingxiaohu
 */
@RestController
@RequestMapping(value = "/v1")
public class Admin_GoodsAction extends BaseV1Controller {

  /**
   *
   */
  private static final long serialVersionUID = 6891425545908564737L;

  @Autowired
  AdminGoodsBiz adminGoodsBiz;

  /**
   * 获取joke分类
   */
  @RequestMapping(value = "/admin/goods_list", method = RequestMethod.POST)
  @ResponseBody
  public String goods_list(HttpServletRequest request, HttpServletResponse response, Param_AdminGoods param, Model model) {


    ReturnDataNew returnData = new ReturnDataNew();
    try {
      //参数检查
      if (param == null) {
        //参数传递错误
        returnData.setReturnData(errorcode_param, "参数传递错误", "");
        sendResp(returnData, response);
        return null;
      }
      adminGoodsBiz.GoodsList(returnData,param);
      if("0".equalsIgnoreCase(returnData.getErrorno())){
        //成功
        model.addAttribute("goodslist",returnData.getData());
        return "/pages/goodslist.jsp";
      }
    } catch (Exception e) {
      log.error("admin_userlogin is error 用户登录失败", e);
    }
    model.addAttribute("msg", "错误请求!");
    return "/pages/error.jsp";
  }


}
