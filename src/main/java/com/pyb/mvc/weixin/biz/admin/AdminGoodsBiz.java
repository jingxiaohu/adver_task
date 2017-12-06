package com.pyb.mvc.weixin.biz.admin;

import com.pyb.bean.ReturnDataNew;
import com.pyb.bean.Wx_goods;
import com.pyb.mvc.action.v1.weixin.admin.param.Param_AdminGoods;
import com.pyb.mvc.action.v1.weixin.goods.param.Param_search_goods;
import com.pyb.mvc.weixin.biz.BaseWxBiz;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class AdminGoodsBiz extends BaseWxBiz {

    /**
     * 通商品列表
     * @param returnData
     * @param param
     */
    public void  GoodsList(ReturnDataNew returnData, Param_AdminGoods param) {
        try {
            int page = param.getPage();
            int size = param.getSize();
            int start = (page-1)*size;
            String sql = "select *  from wx_goods  order by  g_id desc  limit "+start+","+size;
            List<Wx_goods> list =  getDB().queryListT(sql,Wx_goods.class);
            returnData.setReturnData("0", "获取成功", list);
        } catch (Exception e) {
            log.error("AdminGoodsBiz SearchGoods is error", e);
            returnData.setReturnData(errorcode_systerm, "AdminGoodsBiz GoodsList is error", "");
        }
    }


    /**
     * 通过商品名称查询商品信息
     * @param returnData
     * @param param
     */
    public void  SearchGoods(ReturnDataNew returnData, Param_search_goods param) {
        try {
            String sql = "select *  from wx_goods where 1=1 ";
            if(StringUtils.hasLength(param.getName())){
                    sql += " and name like '%"+param.getName()+"%'";
            }
            List<Wx_goods> list =  getDB().queryListT(sql,Wx_goods.class);
            returnData.setReturnData("0", "获取成功", list);
        } catch (Exception e) {
            log.error("AdminGoodsBiz SearchGoods is error", e);
            returnData.setReturnData(errorcode_systerm, "AdminGoodsBiz SearchGoods is error", "");
        }
    }



}
