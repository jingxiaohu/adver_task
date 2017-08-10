package com.pyb.mvc.service;

import com.pyb.bean.ReturnDataNew;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * channel manage
 */
@Service
public class ChannelBiz extends  BaseBiz{

    /**
     * 获取频道列表
     * @param returnData
     * @param dtype
     * @param ui_id
     * @param page
     * @param size
     */
    public void ReturnChannelList(ReturnDataNew returnData, int dtype, long ui_id, int page, int size) {
        // TODO Auto-generated method stub
        try {
            int start = (page-1)*size;
            //首先验证用户是否存在
//			String sql = "select * from channel_info where is_show=0 order by ci_id  asc limit "+start+","+size;
            String sql = "select *  from (select a.* ,b.ui_nickname,ui_avtar from (select * from channel_info where is_show=0 order by ci_sort  desc limit "+start+","+size+") as a LEFT JOIN user_info as b on a.ui_id=b.ui_id) c order by c.ci_sort desc";

            Map<String,Object> paramMap = new HashMap<String,Object>();
            List<Map<String,Object>> list = getMySelfService().queryForList(sql, paramMap);
            returnData.setReturnData("0", "获取成功", list);
            return;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            log.error("LiveBiz ReturnChannelInfo is error", e);
            returnData.setReturnData(errorcode_systerm, "system is error", "");
        }
    }

}
