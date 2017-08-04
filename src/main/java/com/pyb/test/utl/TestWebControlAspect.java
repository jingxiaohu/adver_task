//package com.pyb.test.utl;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
//import org.springframework.aop.framework.ReflectiveMethodInvocation;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.stereotype.Component;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.context.request.RequestAttributes;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import pyb.com.BaseWebTest;
//
///**
// * 定义SpringMvc 的单元测试
// *
// * @author zhijun
// */
//@Component
//@Aspect
//public class TestWebControlAspect {
//  public static String RESPONSE_DATA = "RESPONSE_DATA";
//  public static String SIGN_METHOD = "getSignature";
//  static Logger log = LoggerFactory.getLogger(TestWebControlAspect.class);
//
//  @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
//  public void pointCut() {
//  }
//  @After("pointCut()")
//  public void doAfter(JoinPoint joinPoint) {
//    try {
//    	String FileAbpath=BaseWebTest.basepath+"User.md";
//    	String modeName="用户管理模块";
//    	String interfaceName="";
//    	String signIntro="";
//    	String url = "";
//    	int num = 0;
//    	MultiValueMap<String, String> params= null;
//    	Class<?> paramBean = null;
//    	String reponsedata_str = "";
//    	
//    	RequestAttributes ra = RequestContextHolder.getRequestAttributes();
//        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
//        HttpServletRequest request = sra.getRequest();
//        url = request.getRequestURL().toString();
//        String methodName1 = request.getMethod();
//        String uri = request.getRequestURI();
//        Object reponsedata = request.getAttribute(RESPONSE_DATA);
//        reponsedata_str = reponsedata == null ?"":reponsedata.toString();
//        
//        log.error("请求开始, 各个参数, url: {}, method: {}, uri: {}, reponsedata_str: {}", url, methodName1, uri, reponsedata_str);
//    	if (joinPoint == null) {
//            return;
//        }
//    	
//          MethodInvocationProceedingJoinPoint methodPoint = (MethodInvocationProceedingJoinPoint) joinPoint;
//          Field proxy = methodPoint.getClass().getDeclaredField("methodInvocation");
//          proxy.setAccessible(true);
//          ReflectiveMethodInvocation j = (ReflectiveMethodInvocation) proxy.get(methodPoint);
//          Method method = j.getMethod();
//          
//          if (method.isAnnotationPresent(RequestMapping.class)) {
//        	  RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
//            if (requestMapping != null) {
//            	//方法汉字名称
//            	String methodName = requestMapping.name();
//            	//请求方法的路径
//            	String requestUrl = requestMapping.value()[0];
//            	//请求参数
//            }
//          }
//          
//          Class<?>[] paramTypeList = method.getParameterTypes();// 方法的参数列表
//          for (Class<?> paramType : paramTypeList) {
//        	 /**
//        	   *  interface javax.servlet.http.HttpServletRequest
//				  interface javax.servlet.http.HttpServletResponse
//				  class com.pyb.mvc.action.v1.user.param.Param_sendcode
//        	  */
//              System.out.println("  " + paramType);// 参数类型
//              if(paramType.toString().indexOf("param") != -1){
//            	  System.out.println("--- 接口参数----paramType="+paramType);
//            	  
//              }
//          }
//          
//    	
//    	
//    } catch (Exception e) {
//      // TODO Auto-generated catch block
//      log.error("doAfter(JoinPoint joinPoint) is error", e);
//    }
//  }
//    
//
//
//}  
//
