package com.pyb.mvc.service;

import com.pyb.bean.Day_news;
import com.pyb.bean.ReturnDataNew;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 新闻管理
 *
 * @author jingxiaohu
 */
@Service
public class DayNewsBiz extends BaseBiz {


  /**
   * 获取news
   * @param returnData
   * @param dtype
   * @param ui_id
   * @param page
   * @param size
   */
  public void ReturnDayNews_list(ReturnDataNew returnData, int dtype,
                                 long ui_id, int page, int size) {
    // TODO Auto-generated method stub
    try {
      int start = (page-1)*size;
      String sql  = "";
      sql = "select * from day_news where  is_show=0 order by ctime desc limit "+start+","+size;
      List<Day_news> list = getMySelfService().queryListT(sql, Day_news.class);
      returnData.setReturnData(errorcode_success, "获取成功", list);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      log.error("DayNewsBiz ReturnDayNews_list is error", e);
      returnData.setReturnData(errorcode_systerm, "system is error", null);
    }
  }
}
