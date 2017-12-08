package com.pyb.mvc.weixin.biz;

import com.pyb.bean.ReturnDataNew;
import com.pyb.bean.Wx_recommend_earnings;
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

    /**
     * 申请成为推荐合作人
     */
    public void ApplyUser(ReturnDataNew returnData, Param_userinfo param) {
        try {
            String sql = "select * from wx_recommend_earnings where ui_id=? limit 1";
            Wx_recommend_earnings wx_recommend_earnings = getDB().queryUniqueT(sql,Wx_recommend_earnings.class,param.getUi_id());
            if(wx_recommend_earnings != null){
                returnData.setReturnData(errorcode_data, "已经是合作人了", "","1");
                return;
            }
            //推荐合伙人记录没有  构建新的申请记录
            wx_recommend_earnings = new Wx_recommend_earnings();
            Wx_user_info userinfo = daoFactory.getWx_user_infoDao().selectByKey(param.getUi_id());
            wx_recommend_earnings.setUi_id(userinfo.getUi_id());
            wx_recommend_earnings.setWeixin_id(userinfo.getWeixin_id());
            int id = daoFactory.getWx_recommend_earningsDao().insert(wx_recommend_earnings);
            if(id < 1){
                returnData.setReturnData(errorcode_data, "添加申请成为合作人失败", "","2");
                return;
            }
            returnData.setReturnData("0", "添加成功", wx_recommend_earnings);
        } catch (Exception e) {
            log.error("GoodsBiz ApplyUser is error", e);
            returnData.setReturnData(errorcode_systerm, "GoodsBiz ApplyUser is error", "");
        }

        /**
         * 获取合伙人的收益汇总
         */
    public void GainApplyUser(ReturnDataNew returnData, Param_userinfo param) {
        try {
            String sql = "select * from wx_recommend_earnings where ui_id=? and state=1 limit 1";
            Wx_recommend_earnings wx_recommend_earnings = getDB().queryUniqueT(sql,Wx_recommend_earnings.class,param.getUi_id());
            returnData.setReturnData("0", "获取合伙人的收益汇总成功", wx_recommend_earnings);
        } catch (Exception e) {
            log.error("GoodsBiz GainApplyUser is error", e);
            returnData.setReturnData(errorcode_systerm, "GoodsBiz GainApplyUser is error", "");
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
