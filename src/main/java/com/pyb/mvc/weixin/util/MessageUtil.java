package com.pyb.mvc.weixin.util;

import com.pyb.mvc.weixin.replyMessageBean.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类名: MessageUtil </br>
 * 描述: 消息处理工具类</br>
 * 开发人员： souvc </br>
 * 创建时间：  2015-9-30 </br>
 * 发布版本：V1.0  </br>
 */
public class MessageUtil {
    static Logger log = LoggerFactory.getLogger(MessageUtil.class);
    //客服消息发送 URL
    public static final String CustomUrl = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=";




    // 请求消息类型：文本
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";
    // 请求消息类型：图片
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";
    // 请求消息类型：语音
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";
    // 请求消息类型：视频
    public static final String REQ_MESSAGE_TYPE_VIDEO = "video";
    // 请求消息类型：小视频
    public static final String REQ_MESSAGE_TYPE_SHORTVIDEO = "shortvideo";
    // 请求消息类型：地理位置
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";
    // 请求消息类型：链接
    public static final String REQ_MESSAGE_TYPE_LINK = "link";

    // 请求消息类型：事件推送
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";

    // 事件类型：subscribe(订阅)
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
    // 事件类型：unsubscribe(取消订阅)
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
    // 事件类型：scan(用户已关注时的扫描带参数二维码)
    public static final String EVENT_TYPE_SCAN = "scan";
    // 事件类型：LOCATION(上报地理位置)
    public static final String EVENT_TYPE_LOCATION = "LOCATION";
    // 事件类型：CLICK(自定义菜单)
    public static final String EVENT_TYPE_CLICK = "CLICK";

    // 响应消息类型：文本
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";
    // 响应消息类型：图片
    public static final String RESP_MESSAGE_TYPE_IMAGE = "image";
    // 响应消息类型：语音
    public static final String RESP_MESSAGE_TYPE_VOICE = "voice";
    // 响应消息类型：视频
    public static final String RESP_MESSAGE_TYPE_VIDEO = "video";
    // 响应消息类型：音乐
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";
    // 响应消息类型：图文
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";

    /**
     * 解析微信发来的请求（XML）
     *
     * @param request
     * @return Map<String, String>
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {
        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap<String, String>();

        // 从request中取得输入流
        InputStream inputStream = request.getInputStream();
        // 读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();

        // 遍历所有子节点
        for (Element e : elementList)
            map.put(e.getName(), e.getText());

        // 释放资源
        inputStream.close();
        inputStream = null;

        return map;
    }

    /**
     * 扩展xstream使其支持CDATA
     */
    private static XStream xstream = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // 对所有xml节点的转换都增加CDATA标记
                boolean cdata = true;

                @SuppressWarnings("unchecked")
                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                }

                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });

    /**
     * 文本消息对象转换成xml
     *
     * @param textMessage 文本消息对象
     * @return xml
     */
    public static String messageToXml(TextMessage textMessage) {
        xstream.alias("xml", textMessage.getClass());
        return xstream.toXML(textMessage);
    }

    /**
     * 图片消息对象转换成xml
     *
     * @param imageMessage 图片消息对象
     * @return xml
     */
    public static String messageToXml(ImageMessage imageMessage) {
        xstream.alias("xml", imageMessage.getClass());
        return xstream.toXML(imageMessage);
    }

    /**
     * 语音消息对象转换成xml
     *
     * @param voiceMessage 语音消息对象
     * @return xml
     */
    public static String messageToXml(VoiceMessage voiceMessage) {
        xstream.alias("xml", voiceMessage.getClass());
        return xstream.toXML(voiceMessage);
    }

    /**
     * 视频消息对象转换成xml
     *
     * @param videoMessage 视频消息对象
     * @return xml
     */
    public static String messageToXml(VideoMessage videoMessage) {
        xstream.alias("xml", videoMessage.getClass());
        return xstream.toXML(videoMessage);
    }

    /**
     * 音乐消息对象转换成xml
     *
     * @param musicMessage 音乐消息对象
     * @return xml
     */
    public static String messageToXml(MusicMessage musicMessage) {
        xstream.alias("xml", musicMessage.getClass());
        return xstream.toXML(musicMessage);
    }

    /**
     * 图文消息对象转换成xml
     *
     * @param newsMessage 图文消息对象
     * @return xml
     */
    public static String messageToXml(NewsMessage newsMessage) {
        xstream.alias("xml", newsMessage.getClass());
        xstream.alias("item", new Article().getClass());
        return xstream.toXML(newsMessage);
    }


    public static String makeTextCustomMessage(String openId,String content){
        content.replace("\"", "\\\"");
        String jsonMsg="{\"touser\":\"%s\",\"msgtype\":\"text\",\"text\":{\"content\":\"%s\"}}";
        return String.format(jsonMsg, openId,content);

    }

    /**
     * 主动发送客服消息给关注了公众号的用户
     */
    public static boolean SendMessageToUser(String user_openid,String content,String accesstoken){
        HttpClient httpUtil = new HttpClient();
        PostMethod post = new UTF8PostMethod(CustomUrl+accesstoken);
        try {
            /*BaseSendMessage xx = new BaseSendMessage();
            xx.setTouser(user_openid);
            xx.setMsgtype("text");
            JSONObject obj = new JSONObject();
            obj.put("content",content);
            xx.setText(JSON.toJSONString(obj));
            post.setRequestBody(JSON.toJSONString(xx));
            */
            String content_temp = makeTextCustomMessage( user_openid, content);
            post.setRequestBody(content_temp);
            int state = httpUtil.executeMethod(post);
            if(state == 200){
                System.out.println(post.getResponseBodyAsString());
                return  true;
            }else{
                log.error(post.getResponseBodyAsString());
            }
        } catch (IOException e) {
            log.error("SendMessageToUser(String user_openid,String content,String accesstoken) is error",e);
        }finally {
            if (post != null) {
                post.releaseConnection();
                //释放链接
                httpUtil.getHttpConnectionManager().closeIdleConnections(0);
            }
        }
        return false;
    }
    public static class UTF8PostMethod extends PostMethod {
        public UTF8PostMethod(String url){
            super(url);
        }
        @Override
        public String getRequestCharSet() {
            //return super.getRequestCharSet();
            return "utf-8";
        }
    }

    public static void main(String[] args) {
        String accesstoken ="6_qvq9pdo44oxjXtQgZBLBPzsxLBsq22eQT0fwyLBwS0WgAdKoK0UTuvxd9mdLeVa9I6T3VPUOjnvb2XqVcMS04M4TwFc_BfXhYIB51EEq133zjOw3wnyZ0x3wb2-1ImkrwCTSD0Ld2RYPndEoODFaACARGI";
        String content= "吾泊停车提醒您，注意安全";
        String user_openid="oqbOkwf-uZhUxBKBHteCcbsTTsgs";
        SendMessageToUser( user_openid, content, accesstoken);
    }
}
