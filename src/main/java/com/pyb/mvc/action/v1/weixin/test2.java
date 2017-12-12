package com.pyb.mvc.action.v1.weixin;

import com.alibaba.fastjson.JSONObject;
import com.pyb.mvc.action.v1.BaseV1Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class test2 extends BaseV1Controller {
    @RequestMapping(value = "/index")
    public ModelAndView GainUserOpenId(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index"); //返回的文件名
        mav.addObject("message","hello kitty");
        return mav;
    }
    @RequestMapping(value = "/kuaidi",method = RequestMethod.POST)
    public void kuaidi(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("getQueryString="+request.getQueryString());
        /**
         * 应用级输入参数
         参数名称	类型	说明	必须要求
         EBusinessID	String	用户电商ID	R
         PushTime	String	推送时间	R
         Count	String	推送物流单号轨迹个数	R
         Data	String	推送物流单号轨迹集合	R
         */
        try {
            System.out.println(convertStreamToString(request.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }


        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        JSONObject returnobj = new JSONObject();
        returnobj.put("UpdateTime",sf.format(new Date()));
        returnobj.put("Success",true);
        returnobj.put("Reason","");

        sendRespHtml(returnobj.toJSONString(),response);
    }

    public String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "/n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }

    public   String   inputStream2String2   (InputStream   in)   throws   IOException   {
        StringBuffer   out   =   new   StringBuffer();
        byte[]   b   =   new   byte[4096];
        for   (int   n;   (n   =   in.read(b))   !=   -1;)   {
            out.append(new   String(b,   0,   n));
        }
        return   out.toString();
    }
    public   static   String   inputStream2String3(InputStream   is)   throws IOException {
        ByteArrayOutputStream baos   =   new   ByteArrayOutputStream();
        int   i=-1;
        while((i=is.read())!=-1){
            baos.write(i);
        }
        return   baos.toString();
    }



}

