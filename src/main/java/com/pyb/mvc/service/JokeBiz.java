package com.pyb.mvc.service;

import com.pyb.bean.ReturnDataNew;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * joke 管理
 */
@Service
public class JokeBiz extends  BaseBiz{
    public void ReturnJokeclassList(ReturnDataNew returnData, int dtype,
                                    long ui_id, int page, int size) {
        // TODO Auto-generated method stub
        try {
            int start = (page-1)*size;
            String sql  = "";
            sql = "select * from joke_class where  is_show=1 order by jc_id asc limit "+start+","+size;
            Map<String,Object> paramMap = new HashMap<String,Object>();
            List<Map<String,Object>> list = getDB().queryForList(sql, paramMap);
            returnData.setReturnData("0", "", list);
            return;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            log.error("LiveBiz ReturnJokeclassList is error", e);
            returnData.setReturnData(errorcode_systerm, "system is error", null);
        }
    }
    /**
     *获取jokesegment列表
     * @param returnData
     * @param dtype
     * @param ui_id
     * @param jc_id
     * @param type
     * @param page
     * @param size
     */
    public void ReturnJokesegment_list(ReturnDataNew returnData, int dtype,
                                       long ui_id, long jc_id, int type, int page, int size) {
        // TODO Auto-generated method stub
        try {
            int start = (page-1)*size;

            String sql  = "";
            String condition = "";
            //0：浏览次数排序  1：按点赞次数排序
            if(type == 0){
                //0：浏览次数排序
                condition = ",read_count desc";
            }else{
                //1：按点赞次数排序
                condition = ",js_zan desc";
            }
            sql = "select * from joke_segment where  jc_id=:jc_id and is_show=0 order by jc_id asc"+condition+" limit "+start+","+size;
            Map<String,Object> paramMap = new HashMap<String,Object>();
            paramMap.put("jc_id", jc_id);
            List<Map<String,Object>> list = getDB().queryForList(sql, paramMap);
            returnData.setReturnData("0", null, list);
            return;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            log.error("LiveBiz ReturnJokesegment_list is error", e);
            returnData.setReturnData(errorcode_systerm, "system is error", null);
        }
    }
}
