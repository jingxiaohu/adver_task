package com.pyb.mvc.weixin.biz;

import com.alibaba.fastjson.JSONObject;
import com.pyb.bean.*;
import com.pyb.mvc.action.v1.param.BaseParam;
import com.pyb.mvc.action.v1.weixin.goods.param.Param_goodsClassList;
import com.pyb.mvc.action.v1.weixin.goods.param.Param_goods_info;
import com.pyb.mvc.action.v1.weixin.goods.param.Param_goods_list;
import com.pyb.mvc.action.v1.weixin.goods.param.Param_search_goods_class;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class GoodsBiz extends BaseWxBiz {

    /**
     * 商品列表
     *
     * @param returnData
     * @param param
     */
    public void goodsList(ReturnDataNew returnData, Param_goods_list param) {
        try {
            int page = param.getPage();
            int size = param.getSize();
            int start = (page - 1) * size;

            String condition = "";
            if (param.getType() != null) {
                //查询方式 0：促销商品类型 1：热卖商品类型  2：限时抢购商品类型 3：推荐商品类型 4:卖家包邮商品类型 5:新品上市商品类型
                switch (param.getType()) {
                    case 0: {
                        //促销商品类型
                        condition = "  is_promotion=1  ";
                    }
                    break;
                    case 1: {
                        //热卖商品类型
                        condition = "  is_bestseller=1  ";
                    }
                    break;
                    case 2: {
                        //限时抢购商品类型
                        condition = "  is_timelimit=1  ";
                    }
                    break;
                    case 3: {
                        //推荐商品类型
                        condition = "  is_recommend=1  ";
                    }
                    break;
                    case 4: {
                        //卖家包邮商品类型
                        condition = "  is_postage=1  ";
                    }
                    break;
                    case 5: {
                        //新品上市商品类型
                        condition = "  is_new=1  ";
                    }
                    break;
                    default:
                        break;

                }
            }


            String sql = "";
            if(StringUtils.hasLength(condition)){
                sql = "select *  from wx_goods where "+condition+"  order by  g_id desc  limit " + start + "," + size;
            }else{
                sql = "select *  from wx_goods  order by  g_id desc  limit " + start + "," + size;
            }
            List<Wx_goods> list = getDB().queryListT(sql, Wx_goods.class);
            returnData.setReturnData("0", "获取成功", list);
        } catch (Exception e) {
            log.error("GoodsBiz goodsList is error", e);
            returnData.setReturnData(errorcode_systerm, "GoodsBiz goodsList is error", "");
        }
    }


    /**
     * 通过商品类别查询商品信息列表
     *
     * @param returnData
     * @param param
     */
    public void SearchGoodsByClass(ReturnDataNew returnData, Param_search_goods_class param) {
        try {
            int page = param.getPage();
            int size = param.getSize();
            int start = (page - 1) * size;
            String sql = "select *  from wx_goods where gt_id=? order by  g_id desc  limit " + start + "," + size;
            List<Wx_goods> list = getDB().queryListT(sql, Wx_goods.class,param.getGt_id());
            returnData.setReturnData("0", "获取成功", list);
        } catch (Exception e) {
            log.error("GoodsBiz SearchGoodsByClass is error", e);
            returnData.setReturnData(errorcode_systerm, "GoodsBiz SearchGoodsByClass is error", "");
        }
    }


    /**
     * 获取商品类别信息列表
     *
     * @param returnData
     * @param param
     */
    public void goodsClassList(ReturnDataNew returnData, Param_goodsClassList param) {
        try {
            int page = param.getPage();
            int size = param.getSize();
            int start = (page - 1) * size;
            String sql = "select *  from wx_goods_type  order by  gt_id desc  limit " + start + "," + size;
            List<Wx_goods_type> list = getDB().queryListT(sql, Wx_goods_type.class);
            returnData.setReturnData("0", "获取成功", list);
        } catch (Exception e) {
            log.error("GoodsBiz goodsClassList is error", e);
            returnData.setReturnData(errorcode_systerm, "GoodsBiz goodsClassList is error", "");
        }
    }


    /**
     * 通过商品类别查询商品信息列表
     *
     * @param returnData
     * @param param
     */
    public void goodsInfo(ReturnDataNew returnData, Param_goods_info param) {
        try {
            JSONObject obj = new JSONObject();

            String sql = "select *  from wx_goods where g_id=? ";
            Wx_goods wx_goods = getDB().queryUniqueT(sql,Wx_goods.class,param.getG_id());

            sql = "select *  from wx_goods_details where g_id=? ";
            Wx_goods_details wx_goods_details = getDB().queryUniqueT(sql,Wx_goods_details.class,param.getG_id());


            obj.put("goods",wx_goods);
            obj.put("goods_details",wx_goods_details);

            returnData.setReturnData("0", "获取成功", obj);
        } catch (Exception e) {
            log.error("GoodsBiz goodsInfo is error", e);
            returnData.setReturnData(errorcode_systerm, "GoodsBiz goodsInfo is error", "");
        }
    }



    /**
     * 获取首页banner图片列表
     *
     * @param returnData
     * @param param
     */
    public void GainBannerList(ReturnDataNew returnData, BaseParam param) {
        try {
            int page = param.getPage();
            int size = param.getSize();
            int start = (page - 1) * size;
            String sql = "select *  from wx_banner_img  order by  weight desc  limit " + start + "," + size;
            List<Wx_banner_img> list = getDB().queryListT(sql, Wx_banner_img.class);
            returnData.setReturnData("0", "获取成功", list);
        } catch (Exception e) {
            log.error("GoodsBiz goodsClassList is error", e);
            returnData.setReturnData(errorcode_systerm, "GoodsBiz GainBannerList is error", "");
        }
    }
}
