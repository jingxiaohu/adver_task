package com.pyb.mvc.service;

import com.alibaba.fastjson.JSONArray;
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
            String sql = "select *  from (select a.* ,b.ui_nickname,ui_avtar from (select * from channel_info where is_show=0 order by ci_sort  desc limit "+start+","+size+") as a LEFT JOIN user_info_new as b on a.ui_id=b.ui_id) c order by c.ci_sort desc";

            Map<String,Object> paramMap = new HashMap<String,Object>();
            List<Map<String,Object>> list = getDB().queryForList(sql, paramMap);
            returnData.setReturnData("0", "获取成功", list);
            return;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            log.error("LiveBiz ReturnChannelInfo is error", e);
            returnData.setReturnData(errorcode_systerm, "system is error", "");
        }
    }

    /**
     * 获取菜单列表
     * @param returnData
     * @param dtype
     * @param ui_id
     * @param page
     * @param size
     */
    public void ReturnMenuList(ReturnDataNew returnData, int dtype, long ui_id, int page, int size) {
        try {
            int start = (page-1)*size;
            //首先获取一级菜单
            String sql = "SELECT b.* FROM wp_term_taxonomy  a INNER JOIN wp_terms b ON   a.parent=0 and a.taxonomy='category' and a.term_id=b.term_id";
            Map<String,Object> paramMap = new HashMap<String,Object>();
            List<Map<String,Object>> list = getDB().queryForList(sql, paramMap);
            JSONArray array = new JSONArray();
            for (int i = 0; i < list.size(); i++) {
                //http://www.528ads.com/archives/category/bzrd
                //JSONObject object = (JSONObject) JSONObject.toJSON(list.get(i));
                Map<String,Object> map = list.get(i);
                map.put("slug","http://www.528ads.com/archives/category/"+map.get("slug").toString());
                //list.add(i,map);
            }
            returnData.setReturnData("0", "获取成功", list);
            return;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            log.error("ChannelBiz ReturnMenuList is error", e);
            returnData.setReturnData(errorcode_systerm, "system is error", "");
        }
    }

    /**
     * 获取二级菜单
     * @param returnData
     * @param dtype
     * @param ui_id
     * @param term_id
     * @param page
     * @param size
     */
    public void ReturnMenuList2(ReturnDataNew returnData, int dtype, long ui_id, Long term_id,String slug, int page, int size) {
        try {
            int start = (page-1)*size;
            //首先获取一级菜单
            String sql = "SELECT b.* FROM wp_term_taxonomy a INNER JOIN wp_terms b ON a.term_taxonomy_id=b.term_id where a.parent =:term_id";
            Map<String,Object> paramMap = new HashMap<String,Object>();
            paramMap.put("term_id",term_id);
            List<Map<String,Object>> list = getDB().queryForList(sql, paramMap);
            JSONArray array = new JSONArray();
            for (int i = 0; i < list.size(); i++) {
                //http://www.528ads.com/archives/category/bzrd
                //JSONObject object = (JSONObject) JSONObject.toJSON(list.get(i));
                Map<String,Object> map = list.get(i);
                map.put("slug",slug+"/"+map.get("slug").toString());
            }
            returnData.setReturnData("0", "获取成功", list);
            return;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            log.error("ChannelBiz ReturnMenuList2 is error", e);
            returnData.setReturnData(errorcode_systerm, "system is error", "");
        }
    }
}
