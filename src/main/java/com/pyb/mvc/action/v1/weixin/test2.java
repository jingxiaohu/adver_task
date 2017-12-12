package com.pyb.mvc.action.v1.weixin;

import com.alibaba.fastjson.JSONObject;
import com.pyb.mvc.action.v1.BaseV1Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

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
    public void kuaidi(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, Object> map
    ) {
        System.out.println("getQueryString="+request.getQueryString());
        /**
         * 应用级输入参数
         参数名称	类型	说明	必须要求
         EBusinessID	String	用户电商ID	R
         PushTime	String	推送时间	R
         Count	String	推送物流单号轨迹个数	R
         Data	String	推送物流单号轨迹集合	R
         */
//        System.out.println("EBusinessID="+EBusinessID+" PushTime="+PushTime+" count="+count);
        if(map != null){
            System.out.println("map="+map.toString());
        }



        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        JSONObject returnobj = new JSONObject();
        returnobj.put("UpdateTime",sf.format(new Date()));
        returnobj.put("Success",true);
        returnobj.put("Reason","");

        sendRespHtml(returnobj.toJSONString(),response);
    }
}

