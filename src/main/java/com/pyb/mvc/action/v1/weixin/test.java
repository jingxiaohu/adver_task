package com.pyb.mvc.action.v1.weixin;

import com.pyb.mvc.action.v1.BaseV1Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping(value = "/v1")
public class test extends BaseV1Controller {
    @RequestMapping(value = "/goods/test")
    @ResponseBody
    public void user_info(HttpServletRequest request, HttpServletResponse response) {
        try {
            String str = request.getQueryString();
            System.out.println("str=" + str);
            PrintWriter out = response.getWriter();
            out.print(str);
            out.close();
            out = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
