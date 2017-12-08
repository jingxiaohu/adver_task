package com.pyb.mvc.weixin.biz;

import com.pyb.bean.ReturnDataNew;
import com.pyb.bean.Wx_user_info;
import com.pyb.mvc.action.v1.weixin.user.param.Param_userinfo;
import org.springframework.stereotype.Service;

/**
 * 用户管理
 */
@Service
public class UserManageBiz extends  BaseWxBiz{
    /**
     * 获取用户基本信息
     */
    public void GainUserInfo(ReturnDataNew returnData, Param_userinfo param) {
        try {
            Wx_user_info userinfo = daoFactory.getWx_user_infoDao().selectByKey(param.getUi_id());
            returnData.setReturnData("0", "获取用户信息成功", userinfo);
        } catch (Exception e) {
            log.error("GoodsBiz GainUserInfo is error", e);
            returnData.setReturnData(errorcode_systerm, "GoodsBiz GainUserInfo is error", "");
        }
    }
    /****************************下面是封装的查询方法********************************/
    /**
     * 通过weixin_id  获取用户基本信息
     * @param weixin_id
     * @return
     */
    public Wx_user_info FindUserInfoByWeixin_id(String weixin_id){
        try {
            String sql = "select * from wx_user_info where weixin_id=? limit 1";
            Wx_user_info userinfo = getDB().queryUniqueT(sql,Wx_user_info.class,weixin_id);
            return userinfo;
        } catch (Exception e) {
            log.error("FindUserInfoByWeixin_no 查询用户信息失败",e);
        }
        return null;
    }

}
