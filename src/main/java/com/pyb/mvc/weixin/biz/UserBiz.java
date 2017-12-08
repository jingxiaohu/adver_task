package com.pyb.mvc.weixin.biz;

import com.pyb.bean.ReturnDataNew;
import com.pyb.bean.Wx_goods;
import com.pyb.bean.Wx_user_info;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户管理
 */
@Service
public class UserBiz extends  BaseWxBiz{
    /**
     * 获取用户基本信息
     */
   /* public void GainUserInfo(ReturnDataNew returnData, Param_userinfo param) {
        try {
            String sql = "select *  from wx_goods where gt_id=? order by  g_id desc  limit " + start + "," + size;
            List<Wx_goods> list = getDB().queryListT(sql, Wx_goods.class,param.getGt_id());
            returnData.setReturnData("0", "获取成功", list);
        } catch (Exception e) {
            log.error("GoodsBiz SearchGoodsByClass is error", e);
            returnData.setReturnData(errorcode_systerm, "GoodsBiz SearchGoodsByClass is error", "");
        }
    }*/
    /****************************下面是封装的查询方法********************************/
    /**
     * 通过weixin_no  获取用户基本信息
     * @param weixin_no
     * @return
     */
    public Wx_user_info FindUserInfoByWeixin_no(String weixin_no){
        try {
            String sql = "select * from wx_user_info where weixin_no=? limit 1";
            Wx_user_info userinfo = getDB().queryUniqueT(sql,Wx_user_info.class,weixin_no);
            return userinfo;
        } catch (Exception e) {
            log.error("FindUserInfoByWeixin_no 查询用户信息失败",e);
        }
        return null;
    }

}
