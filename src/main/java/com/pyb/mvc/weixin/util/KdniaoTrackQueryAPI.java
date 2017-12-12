package com.pyb.mvc.weixin.util;

import org.springframework.stereotype.Repository;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 快递鸟物流轨迹即时查询接口
 *
 * @技术QQ群: 456320272
 * @see: http://www.kdniao.com/YundanChaxunAPI.aspx
 * @copyright: 深圳市快金数据技术服务有限公司
 *
 * DEMO中的电商ID与私钥仅限测试使用，正式环境请单独注册账号
 * 单日超过500单查询量，建议接入我方物流轨迹订阅推送接口
 *
 * ID和Key请到官网申请：http://www.kdniao.com/ServiceApply.aspx
 */
@Repository("kdniaoTrackQueryAPI")
public class KdniaoTrackQueryAPI {
    public static Map<String, String> getWLNameMap() {
        if(WLNameMap == null){
            WLNameMap = new HashMap<String,String>();
            WLNameMap.put("顺丰","SF");
            WLNameMap.put("百世快递","HTKY");
            WLNameMap.put("百世快运","BTWL");
            WLNameMap.put("申通","STO");
            WLNameMap.put("中通","ZTO");
            WLNameMap.put("圆通","YTO");
            WLNameMap.put("韵达","YD");
            WLNameMap.put("EMS","EMS");
            WLNameMap.put("宅急送","ZJS");
            WLNameMap.put("德邦","DBL");
            WLNameMap.put("全峰","QFKD");
            WLNameMap.put("如风达","RFD");
            WLNameMap.put("优速快递","UC");
            WLNameMap.put("龙邦","LB");
            WLNameMap.put("增益","ZENY");
            WLNameMap.put("华航快递","HHKD");
            WLNameMap.put("运通快递","YTKD");
            WLNameMap.put("希优特","XYT");
            WLNameMap.put("民邦物流","MB");
            WLNameMap.put("长沙创一","CSCY");
            WLNameMap.put("安能物流","ANE");
            WLNameMap.put("精英速运","JYSY");
            WLNameMap.put("邮政快递","YZPY");
        }
        return WLNameMap;
    }

    public static Map<String,String> WLNameMap = null;

    //DEMO
    public static void main(String[] args) {
        KdniaoTrackQueryAPI api = new KdniaoTrackQueryAPI();
        try {
           /* String result = api.getOrderTracesByJson(getWLNameMap().get("百世快递"), "70049954752928");
            System.out.print(result);*/
            String result = api.getOrderTracesByJson(getWLNameMap().get("邮政快递"), "9891649961956");
            System.out.print(result);
           /* String result = api.getOrderRecognitionByJson("9891649961956");
            System.out.print(result);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //电商ID
    private String EBusinessID="1315771";
    //电商加密私钥，快递鸟提供，注意保管，不要泄漏
    private String AppKey="c5e15323-d221-442a-ac8e-717303a0c5a3";
    //请求url
    private String ReqURL="http://api.kdniao.cc/Ebusiness/EbusinessOrderHandle.aspx";
    //单号识别服务--测试
    private  String SBurl = "http://testapi.kdniao.cc:8081/Ebusiness/EbusinessOrderHandle.aspx";



    /* 将字符串转化为\\u形式的字符串，如： "U字符" -> "\\u55\\u5b57\\u7b26" ;U字符为字符串中每个字符的16进制信息 */
    public static String to_U_Str(String str)
    {
        String tmp = "";

        for (char C : str.toCharArray())
            // 获取所有字符
            tmp += "\\u" + Integer.toHexString(C);      // 将每个字符的的值，转化为16进制字符串

        return tmp;
    }

    /* 将U字符转化为其表示的字符串, 如： "\\u55\\u5b57\\u7b26" -> "U字符" ;按\\u分割，依次转化为对应字符*/
    public static String UStr_2_Str(String Ustr0)
    {
        String Ustr = Ustr0;

        int S = 0, E = 0;
        String C = "", Value = "";

        while (Ustr.contains("\\u"))
        {
            S = Ustr.indexOf("\\u") + "\\u".length();
            E = Ustr.indexOf("\\u", S);
            if (E == -1) E = Ustr.length();

            if (E > S)
            {
                C = Ustr.substring(S, E);
                if (C.length() > 4) C = C.substring(0, 4);
                Value = (char) Integer.parseInt(C, 16) + "";

                Ustr = Ustr.replace("\\u" + C, Value);
            }
        }

        return Ustr;
    }





    /**
     * Json方式 查询订单物流轨迹
     * @throws Exception
     */
    public String getOrderTracesByJson(String expCode, String expNo) throws Exception{
        String requestData= "{'OrderCode':'','ShipperCode':'" + expCode + "','LogisticCode':'" + expNo + "'}";

        Map<String, String> params = new HashMap<String, String>();
        params.put("RequestData", urlEncoder(requestData, "UTF-8"));
        params.put("EBusinessID", EBusinessID);
        params.put("RequestType", "1002");
        String dataSign=encrypt(requestData, AppKey, "UTF-8");
        params.put("DataSign", urlEncoder(dataSign, "UTF-8"));
        params.put("DataType", "2");

        String result=sendPost(ReqURL, params);

        //根据公司业务处理返回的信息......

        return result;
    }


    /**
     * Json方式 查询订单物流 单号识别
     * @throws Exception
     */
    public String getOrderRecognitionByJson(String expNo) throws Exception{
        String requestData= "{'LogisticCode':'" + expNo + "'}";

        Map<String, String> params = new HashMap<String, String>();
        params.put("RequestData", urlEncoder(requestData, "UTF-8"));
        params.put("EBusinessID", EBusinessID);
        params.put("RequestType", "2002");
        String dataSign=encrypt(requestData, AppKey, "UTF-8");
        params.put("DataSign", urlEncoder(dataSign, "UTF-8"));
        params.put("DataType", "2");

        String result=sendPost(ReqURL, params);

        //根据公司业务处理返回的信息......

        return result;
    }



    /**
     * MD5加密
     * @param str 内容
     * @param charset 编码方式
     * @throws Exception
     */
    @SuppressWarnings("unused")
    private String MD5(String str, String charset) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str.getBytes(charset));
        byte[] result = md.digest();
        StringBuffer sb = new StringBuffer(32);
        for (int i = 0; i < result.length; i++) {
            int val = result[i] & 0xff;
            if (val <= 0xf) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(val));
        }
        return sb.toString().toLowerCase();
    }

    /**
     * base64编码
     * @param str 内容
     * @param charset 编码方式
     * @throws UnsupportedEncodingException
     */
    private String base64(String str, String charset) throws UnsupportedEncodingException{
        String encoded = base64Encode(str.getBytes(charset));
        return encoded;
    }

    @SuppressWarnings("unused")
    private String urlEncoder(String str, String charset) throws UnsupportedEncodingException{
        String result = URLEncoder.encode(str, charset);
        return result;
    }

    /**
     * 电商Sign签名生成
     * @param content 内容
     * @param keyValue Appkey
     * @param charset 编码方式
     * @throws UnsupportedEncodingException ,Exception
     * @return DataSign签名
     */
    @SuppressWarnings("unused")
    private String encrypt (String content, String keyValue, String charset) throws UnsupportedEncodingException, Exception
    {
        if (keyValue != null)
        {
            return base64(MD5(content + keyValue, charset), charset);
        }
        return base64(MD5(content, charset), charset);
    }

    /**
     * 向指定 URL 发送POST方法的请求
     * @param url 发送请求的 URL
     * @param params 请求的参数集合
     * @return 远程资源的响应结果
     */
    @SuppressWarnings("unused")
    private String sendPost(String url, Map<String, String> params) {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn =(HttpURLConnection) realUrl.openConnection();
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // POST方法
            conn.setRequestMethod("POST");
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.connect();
            // 获取URLConnection对象对应的输出流
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            // 发送请求参数
            if (params != null) {
                StringBuilder param = new StringBuilder();
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    if(param.length()>0){
                        param.append("&");
                    }
                    param.append(entry.getKey());
                    param.append("=");
                    param.append(entry.getValue());
                    //System.out.println(entry.getKey()+":"+entry.getValue());
                }
                //System.out.println("param:"+param.toString());
                out.write(param.toString());
            }
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result.toString();
    }


    private static char[] base64EncodeChars = new char[] {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '0', '1', '2', '3',
            '4', '5', '6', '7', '8', '9', '+', '/' };

    public static String base64Encode(byte[] data) {
        StringBuffer sb = new StringBuffer();
        int len = data.length;
        int i = 0;
        int b1, b2, b3;
        while (i < len) {
            b1 = data[i++] & 0xff;
            if (i == len)
            {
                sb.append(base64EncodeChars[b1 >>> 2]);
                sb.append(base64EncodeChars[(b1 & 0x3) << 4]);
                sb.append("==");
                break;
            }
            b2 = data[i++] & 0xff;
            if (i == len)
            {
                sb.append(base64EncodeChars[b1 >>> 2]);
                sb.append(base64EncodeChars[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]);
                sb.append(base64EncodeChars[(b2 & 0x0f) << 2]);
                sb.append("=");
                break;
            }
            b3 = data[i++] & 0xff;
            sb.append(base64EncodeChars[b1 >>> 2]);
            sb.append(base64EncodeChars[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]);
            sb.append(base64EncodeChars[((b2 & 0x0f) << 2) | ((b3 & 0xc0) >>> 6)]);
            sb.append(base64EncodeChars[b3 & 0x3f]);
        }
        return sb.toString();
    }
}
