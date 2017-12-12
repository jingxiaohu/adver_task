package com.pyb.mvc.action.v1.weixin;

import com.pyb.mvc.action.v1.BaseV1Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class test2 extends BaseV1Controller {
    @RequestMapping(value = "/index")
    public ModelAndView GainUserOpenId(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index"); //返回的文件名
        mav.addObject("message","hello kitty");
        return mav;
    }
    @RequestMapping(value = "/kuaidi")
    public void kuaidi(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getQueryString());
        sendRespHtml("SUCCESS",response);
    }
}

