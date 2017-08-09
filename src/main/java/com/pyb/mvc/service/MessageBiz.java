package com.pyb.mvc.service;

import com.pyb.bean.Live_info;
import com.pyb.bean.Message_info;
import com.pyb.bean.ReturnDataNew;
import com.pyb.util.RequestUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 消息管理
 *
 * @author jingxiaohu
 */
@Service
public class MessageBiz extends BaseBiz {



  /**
   * 获取直播信息
   * @param returnData
   * @param dtype
   */
  public void ReturnLiveInfo(ReturnDataNew returnData, int dtype,String ci_id,String mi_id,int page,int size,int type) {
    // TODO Auto-generated method stub
    try {
      if(page <  1){
        page = 1;
      }
      int start = (page-1)*size;
      List<Live_info> list = null;
      if(RequestUtil.checkObjectBlank(mi_id)){
        String	sql = "select * from live_info where ci_id=?  order by mi_id desc limit "+start+","+size;
        list = getMySelfService().queryListT(sql, Live_info.class, ci_id);
      }else{
        if(type == 0){
          String	sql = "select * from live_info where ci_id=? and mi_id>? order by mi_id desc limit "+start+","+size;
          list = getMySelfService().queryListT(sql, Live_info.class, ci_id,mi_id);
        }else{
          String	sql = "select * from live_info where ci_id=? and mi_id<? order by mi_id desc limit "+start+","+size;
          list = getMySelfService().queryListT(sql, Live_info.class, ci_id,mi_id);
        }

      }


      if(list == null || list.size() < 1){
        returnData.setReturnData(errorcode_systerm, "没有数据", "");
        return;
      }
      returnData.setReturnData("0", "", list);
      return;

    } catch (Exception e) {
      // TODO Auto-generated catch block
      log.error("LiveBiz ReturnLiveInfo is error", e);
      returnData.setReturnData(errorcode_systerm, "system is error", "");
    }

  }


  /**
   * messageinfo read my message 获取我自己的原创消息
   * @param returnData
   * @param dtype
   * @param ui_id
   * @param page
   * @param size
   */
  public void ReturnMyMessageList(ReturnDataNew returnData, int dtype, long ui_id, int page,int size) {
    // TODO Auto-generated method stub
    try {
      int start = (page-1)*size;

      String sql = "select * from message_info where ui_id=? and mi_link_id=0 order by mi_id desc limit "+start+","+size;

      List<Message_info> list = getMySelfService().queryListT(sql, Message_info.class, ui_id);
      returnData.setReturnData("0", "", list);
      return;

    } catch (Exception e) {
      // TODO Auto-generated catch block
      log.error("LiveBiz ReturnMyMessageList is error", e);
      returnData.setReturnData(errorcode_systerm, "system is error", "");
    }
  }
}
