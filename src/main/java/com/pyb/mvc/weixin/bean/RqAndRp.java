package com.pyb.mvc.weixin.bean;

/**
 * 请求信息和消息返回体
 */
public class RqAndRp {
    //回复消息
    private String replyXML;
    //事件类型
    private String Event;
    //消息类型
    private String msgType;
    //推荐人信息
    private String EventKey;

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }


    public String getReplyXML() {
        return replyXML;
    }

    public void setReplyXML(String replyXML) {
        this.replyXML = replyXML;
    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
