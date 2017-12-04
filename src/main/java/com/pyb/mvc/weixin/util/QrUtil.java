package com.pyb.mvc.weixin.util;

import com.alibaba.fastjson.JSONObject;

/**
 * 临时二维码请求说明

 http请求方式: POST
 URL: https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKENPOST数据格式：json
 POST数据例子：{"expire_seconds": 604800, "action_name": "QR_SCENE", "action_info": {"scene": {"scene_id": 123}}}



 或者也可以使用以下POST数据创建字符串形式的二维码参数：
 {"expire_seconds": 604800, "action_name": "QR_STR_SCENE", "action_info": {"scene": {"scene_str": "test"}}}

 永久二维码请求说明

 http请求方式: POST
 URL: https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKENPOST数据格式：json
 POST数据例子：{"action_name": "QR_LIMIT_SCENE", "action_info": {"scene": {"scene_id": 123}}}


 或者也可以使用以下POST数据创建字符串形式的二维码参数：
 {"action_name": "QR_LIMIT_STR_SCENE", "action_info": {"scene": {"scene_str": "test"}}}
 */
public class QrUtil {
    private String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=%s";
    private String TicketUrl = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=%s";

    private  String access_token = "cNHgc0oNOrpQrV6tPIMYe6i05a1RvxFMweBkCkbelR3l_dcD10TBywV1AWGWrj9c00z9PF_0TRaRAfSa-cDY9Ah40ZuZHn-prNQDvgcrm4CvCRZtzj9DS2P7M_z1isoNEWIbAJAOGS";

    /**
     *
     * 生成临时二维码
     * http请求方式: POST
     URL: https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKENPOST数据格式：json
     POST数据例子：{"expire_seconds": 604800, "action_name": "QR_SCENE", "action_info": {"scene": {"scene_id": 123}}}
     或者也可以使用以下POST数据创建字符串形式的二维码参数：
     {"expire_seconds": 604800, "action_name": "QR_STR_SCENE", "action_info": {"scene": {"scene_str": "test"}}}
     * @param access_token
     * @param expire_seconds
     * @param weixin_no
     * @return  正确的Json返回结果:

    {"ticket":"gQH47joAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL2taZ2Z3TVRtNzJXV1Brb3ZhYmJJAAIEZ23sUwMEmm

    3sUw==","expire_seconds":60,"url":"http:\/\/weixin.qq.com\/q\/kZgfwMTm72WWPkovabbI"}

    参数	说明
    ticket	获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
    expire_seconds	该二维码有效时间，以秒为单位。 最大不超过2592000（即30天）。
    url	二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片
     */
    public JSONObject MakeQrTemp(String access_token,int expire_seconds,String weixin_no){
            String str = "{\"expire_seconds\": %s, \"action_name\": \"QR_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \"%s\"}}}";
            str = String.format(str, expire_seconds,weixin_no);
            String url_now  = String.format(url,access_token);
            JSONObject jsonObject = WeixinUtil.httpRequest(url_now, "POST", str);
            System.out.println("jsonObject="+jsonObject.toJSONString());
            return jsonObject;
    }



    /**
     * 生成永久二维码 每个公众号最多10万个
     * http请求方式: POST
     URL: https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKENPOST数据格式：json
     POST数据例子：{"action_name": "QR_LIMIT_SCENE", "action_info": {"scene": {"scene_id": 123}}}
     或者也可以使用以下POST数据创建字符串形式的二维码参数：
     {"action_name": "QR_LIMIT_STR_SCENE", "action_info": {"scene": {"scene_str": "test"}}}

     @return  正确的Json返回结果:

     {"ticket":"gQH47joAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL2taZ2Z3TVRtNzJXV1Brb3ZhYmJJAAIEZ23sUwMEmm

     3sUw==","expire_seconds":60,"url":"http:\/\/weixin.qq.com\/q\/kZgfwMTm72WWPkovabbI"}

     参数	说明
     ticket	获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
     expire_seconds	该二维码有效时间，以秒为单位。 最大不超过2592000（即30天）。
     url	二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片
     */
    public String MakeQrLong(String access_token,int expire_seconds,String weixin_no){
        String str = "{\"expire_seconds\": %s, \"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \"%s\"}}}";
        str = String.format(str, expire_seconds,weixin_no);
        String url_now  = String.format(url,access_token);
        JSONObject jsonObject = WeixinUtil.httpRequest(url_now, "POST", str);
        System.out.println("jsonObject="+jsonObject.toJSONString());
        return null;
    }

    /**
     * 通过ticket换取二维码
     获取二维码ticket后，开发者可用ticket换取二维码图片。请注意，本接口无须登录态即可调用。
     请求说明
     HTTP GET请求（请使用https协议）https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET提醒：TICKET记得进行UrlEncode
     返回说明
     ticket正确情况下，http 返回码是200，是一张图片，可以直接展示或者下载。
     * @return
     */
    public String  ExchangeImage(String ticket){
        String url_now  = String.format(TicketUrl,ticket);
        System.out.println("url_now="+url_now);
        String ticket_imge = WeixinUtil.httpRequest2(url_now,"GET",null);
        if(ticket_imge != null){
            System.out.println("ticket_imge="+ticket_imge);
        }
        return null;
    }

    public static void main(String[] args) {
        QrUtil qrUtil =  new QrUtil();
        JSONObject obj = qrUtil.MakeQrTemp(qrUtil.access_token, 2592000,"20171204154909-18205228126080618");
        if(obj != null){
            String  ticket = obj.getString("ticket");
            qrUtil.ExchangeImage(ticket);
        }

    }

}
