package com.pyb.mvc.action.v1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pyb.bean.ReturnData;
import com.pyb.bean.ReturnDataBase;
import com.pyb.bean.ReturnDataNew;
import com.pyb.constants.Constants;
import com.pyb.interceptor.SpringMVCInterceptor;
import com.pyb.util.HttpUtil;
import com.pyb.util.RequestUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class BaseV1Controller implements Serializable {

 /* @Autowired
  private ServletContext servletContext;*/

  private static final long serialVersionUID = 6182244061803296061L;

  protected Logger log = LoggerFactory.getLogger(getClass());

  protected String SUCCESS = "success";
  protected String ERROR = "error";
  //成功
  public String errorcode_success = "0";
  //系统级错误
  public String errorcode_systerm = "1000";
  //参数级错误
  public String errorcode_param = "1001";
  //逻辑运行错误
  public String errorcode_data = "1002";


  /**
   * 基于@ExceptionHandler异常处理
   */
  @ExceptionHandler
  public String resolveException(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler, Exception e) {
    ReturnDataNew returnData = new ReturnDataNew();
    if (handler != null) {
      log.error("handler=" + handler.toString() + "  resolveException=" + e.getMessage());
    }
    returnData.setReturnData(errorcode_systerm, "systerm exception", "");
    sendResp(returnData, response);
    return null;
  }

  /*********************************下面是公共方法*************************************************/
  /**
   * true：合法请求  false ：非法请求
   */
  public String getSignature(String dev_server_secret, Object... params) {
    StringBuffer signparam = new StringBuffer();
    System.out.println(dev_server_secret.getClass().getName());
	if (params.length == 0) {
      return null;
    }
    List<String> list = new ArrayList<String>();
    for (Object param : params) {
      if (param != null) {
        list.add(param.toString());
      }
    }
    return getSignature(list, dev_server_secret);
  }

  private static org.slf4j.Logger logger = org.slf4j.LoggerFactory
      .getLogger(BaseV1Controller.class);

  /**
   * 签名生成算法
   *
   * @return 签名
   */
  public static String getSignature(Map<String, String> params, String dev_server_secret,
      String separator) {
    // 先将参数以其参数名的字典序升序进行排序
    Map<String, String> sortedParams = new TreeMap<String, String>(params);

    Set<Map.Entry<String, String>> entrys = sortedParams.entrySet();
    // 遍历排序后的字典，将所有参数按"key=value"格式拼接在一起
    StringBuilder basestring = new StringBuilder();
    for (Map.Entry<String, String> param : entrys) {
      basestring.append(param.getKey()).append(param.getValue()).append(separator);
    }
    basestring.append(dev_server_secret);
    logger.info(basestring.toString());
    //对待签名串求签
    return DigestUtils.md5Hex(basestring.toString());
  }

  /**
   * 签名生成算法
   *
   * @return 签名
   */
  public String getSignature(List<String> params, String dev_server_secret) {
    // 先将参数以其参数名的字典序升序进行排序
    Collections.sort(params);
    // 遍历排序后的字典，将所有参数按"key=value"格式拼接在一起
    StringBuilder basestring = new StringBuilder();
    for (Object param : params) {
      basestring.append(param);
    }
    basestring.append(dev_server_secret);
    log.debug("待签名字符：{}", basestring.toString());
    //对待签名串求签
    return DigestUtils.md5Hex(basestring.toString());
  }

  @Autowired(required = false)
  private HttpServletRequest request;

  /**
   * 封装发送响应
   *
   * @param @param returnData    设定文件
   * @return void    返回类型
   * @Title: sendResp
   * @Description: TODO(这里用一句话描述这个方法的作用)
   */
  protected void sendResp(ReturnDataBase returnData, HttpServletResponse response) {
    if (returnData == null) {
      returnData = new ReturnData();
    }
    response.setHeader("Access-Control-Allow-Origin", "*");
    response.setContentType("text/json; charset=utf-8");
    response.setCharacterEncoding("utf-8");
    try {
      String data = JSONObject.toJSONString(returnData);
      request.setAttribute(SpringMVCInterceptor.RESPONSE_DATA, data);
      response.getWriter().write(data);
    } catch (Exception e) {
      log.error("BaseAction.sendResp is error", e);
    }
  }

  /**
   * 封装发送响应
   *
   * @param @param returnData    设定文件
   * @return void    返回类型
   * @Title: sendResp
   * @Description: TODO(这里用一句话描述这个方法的作用)
   */
  protected void sendResp(JSONObject returnData, HttpServletResponse response) {
    if (returnData == null) {
      returnData = new JSONObject();
    }
    response.setContentType("text/json; charset=utf-8");
    response.setCharacterEncoding("utf-8");
    try {
      String data = JSONObject.toJSONString(returnData);
      log.info("返回数据:" + data);
      request.setAttribute(SpringMVCInterceptor.RESPONSE_DATA, data);
      response.getWriter().write(data);
    } catch (Exception e) {
      log.error("BaseAction.sendResp is error", e);
    }
  }

  /**
   * 封装发送响应
   *
   * @param @param returnData    设定文件
   * @return void    返回类型
   * @Title: sendResp
   * @Description: TODO(这里用一句话描述这个方法的作用)
   */
  protected void sendResp(String returnData, HttpServletResponse response) {
    returnData = returnData == null ? "" : returnData;
    response.setContentType("text/json; charset=utf-8");
    response.setCharacterEncoding("utf-8");
    try {
      request.setAttribute(SpringMVCInterceptor.RESPONSE_DATA, returnData);
      response.getWriter().write(returnData);
    } catch (Exception e) {
      log.error("BaseAction.sendResp(String returnData) is error", e);
    }
  }

  /**
   * 封装发送响应
   *
   * @param @param returnData    设定文件
   * @return void    返回类型
   * @Title: sendResp
   * @Description: TODO(这里用一句话描述这个方法的作用)
   */
  protected void sendRespHtml(String returnData, HttpServletResponse response) {
    returnData = returnData == null ? "" : returnData;
    response.setContentType("text/html; charset=utf-8");
    response.setCharacterEncoding("utf-8");
    try {
      request.setAttribute(SpringMVCInterceptor.RESPONSE_DATA, returnData);
      response.getWriter().write(returnData);
    } catch (Exception e) {
      log.error("BaseAction.sendResp(String returnData) is error", e);
    }
  }



  /**
   * 获取IP
   */
  public static String getIpAddr(HttpServletRequest request) {
    String ip = request.getHeader("x-forwarded-for");
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("Proxy-Client-IP");
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("WL-Proxy-Client-IP");
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getRemoteAddr();
    }
    return ip;
  }

  /**
   * @param @param request
   * @param @return 设定文件
   * @return String    返回类型
   * @Title: getQueryString
   * @Description: TODO(request中提供的getQueryString方法只对Get方法才能生效，在我们不知道方法的情况下最好重写getQueryString)
   */
  @SuppressWarnings("rawtypes")
  public String getQueryString(HttpServletRequest request) {
    boolean first = true;
    StringBuffer strbuf = new StringBuffer("");
    Enumeration emParams = request.getParameterNames();
    //do-while
    do {
      if (!emParams.hasMoreElements()) {
        break;
      }

      String sParam = (String) emParams.nextElement();
      String[] sValues = request.getParameterValues(sParam);

      String sValue = "";
      for (int i = 0; i < sValues.length; i++) {
        sValue = sValues[i];
        if (sValue != null && sValue.trim().length() != 0 && first == true) {
          //第一个参数
          first = false;
          strbuf.append(sParam).append("=").append(sValue);
        } else if (sValue != null && sValue.trim().length() != 0 && first == false) {
          strbuf.append("&").append(sParam).append("=").append(sValue);
        }
      }
    } while (true);

    return strbuf.toString();
  }

  /**
   * 对手机设备信息进行解析
   */
/*	 @SuppressWarnings("static-access")
  public Client_device returnClientDeviceID(HttpServletRequest request){
		 try {
			String c_device =  request.getParameter(Constants.ClientDeviceParamKey);
			 if(!RequestUtil.checkObjectBlank(c_device)){
				 //URL编码
				 c_device = returnUrlDecode(c_device);
				 //非空
				 JSONObject obj =  JSONObject.fromObject(c_device);
				 if(obj != null && !obj.isNullObject()){
					 //进行解析手机端的设备信息
					 Client_device clientDevice = (Client_device) obj.toBean(obj, Client_device.class);
					 return clientDevice;
				 }

			 }
		} catch (Exception e) {
			log.error("returnClientDeviceID is error", e);
		}
		return null;
	 }*/


  /**
   * URL解码
   *
   * @param @param value
   * @param @return 设定文件
   * @return String    返回类型
   * @Title: returnUrlDecode
   * @Description: TODO(这里用一句话描述这个方法的作用)
   */
  public String returnUrlDecode(String value) {
    if (RequestUtil.checkObjectBlank(value)) {
      return value;
    }
    try {
      return URLDecoder.decode(value, Constants.SYSTEM_CHARACTER);
    } catch (UnsupportedEncodingException e) {
      log.error("returnUrlDecode is error", e);
    }

    return value;
  }

  //判断，返回布尔值
  public static boolean isMobileNO(String mobiles) {
//			Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,1,3,5-9])|(17[0,1,3,5-9]))\\d{8}$");
    Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9])|(17[0-9]))\\d{8}$");
    Matcher m = p.matcher(mobiles);
    return m.matches();
  }

  //判断，返回布尔值
  public static boolean isBankNO(String bankno) {
    Pattern p = Pattern.compile("^([1-9]{1})(\\d{14}|\\d{18})$");
    Matcher m = p.matcher(bankno);
    return m.matches();
  }

  //判断，返回布尔值
  public static boolean isEmail(String email) {
    //String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");//复杂匹配
    Matcher m = p.matcher(email);
    return m.matches();
  }

  /**
   * 判断IP地址的合法性，这里采用了正则表达式的方法来判断
   * return true，合法
   * */
  public static boolean isIpAddress(String text) {
      if (text != null && !text.isEmpty()) {
          // 定义正则表达式
          String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."+
          "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."+
                    "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."+
                    "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
          // 判断ip地址是否与正则表达式匹配
          if (text.matches(regex)) {
              // 返回判断信息
              return true;
          } else {
              // 返回判断信息
              return false;
          }
      }
      return false;
  }

  //刷新 access_token
  public JSONObject RefeshAccessToken(){
      //获取access_token
      String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxebee99b0aba36d8f&secret=a4a6df2df45185cf4746a381155cf0fa";
      String jsondata = HttpUtil.doGet(url,null,null);
      if(jsondata != null){
        JSONObject oob = JSON.parseObject(jsondata);
        if(oob != null){
//          WeiXinAccessToken = oob.getString("access_token");
//          String expires_in = oob.getString("expires_in");
          return oob;
        }
      }
      return  null;
  }


}
