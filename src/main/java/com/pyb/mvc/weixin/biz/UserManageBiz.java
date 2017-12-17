package com.pyb.mvc.weixin.biz;

import com.pyb.bean.ReturnDataNew;
import com.pyb.bean.Wx_recommend_earnings;
import com.pyb.bean.Wx_user_address;
import com.pyb.bean.Wx_user_info;
import com.pyb.mvc.action.v1.param.BaseParam;
import com.pyb.mvc.action.v1.user.param.Param_addOrUpdate_Address;
import com.pyb.mvc.action.v1.user.param.Param_del_Address;
import com.pyb.mvc.action.v1.weixin.user.param.Param_userinfo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 用户管理
 */
@Service
public class UserManageBiz extends BaseWxBiz {
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
            Wx_recommend_earnings wx_recommend_earnings = getDB().queryUniqueT(sql, Wx_recommend_earnings.class, param.getUi_id());
            if (wx_recommend_earnings != null) {
                returnData.setReturnData(errorcode_data, "已经是合作人了", "", "1");
                return;
            }
            //推荐合伙人记录没有  构建新的申请记录
            wx_recommend_earnings = new Wx_recommend_earnings();
            Wx_user_info userinfo = daoFactory.getWx_user_infoDao().selectByKey(param.getUi_id());
            if(userinfo == null){
                returnData.setReturnData(errorcode_data, "添加申请成为合作人失败-用户不存在", "", "2");
                return;
            }
            wx_recommend_earnings.setUi_id(userinfo.getUi_id());
            wx_recommend_earnings.setWeixin_id(userinfo.getWeixin_id());
            int id = daoFactory.getWx_recommend_earningsDao().insert(wx_recommend_earnings);
            if (id < 1) {
                returnData.setReturnData(errorcode_data, "添加申请成为合作人失败", "", "3");
                return;
            }
            returnData.setReturnData("0", "添加成功", wx_recommend_earnings);
        } catch (Exception e) {
            log.error("GoodsBiz ApplyUser is error", e);
            returnData.setReturnData(errorcode_systerm, "GoodsBiz ApplyUser is error", "");
        }
    }

    /**
     * 获取合伙人的收益汇总
     */
    public void GainApplyUser(ReturnDataNew returnData, Param_userinfo param) {
        try {
            String sql = "select * from wx_recommend_earnings where ui_id=? and state=1 limit 1";
            Wx_recommend_earnings wx_recommend_earnings = getDB().queryUniqueT(sql, Wx_recommend_earnings.class, param.getUi_id());
            returnData.setReturnData("0", "获取合伙人的收益汇总成功", wx_recommend_earnings);
        } catch (Exception e) {
            log.error("GoodsBiz GainApplyUser is error", e);
            returnData.setReturnData(errorcode_systerm, "GoodsBiz GainApplyUser is error", "");
        }
    }

    /**
     * 获取用户收货地址信息列表
     */
    public void GainUserAddressList(ReturnDataNew returnData, Param_userinfo param) {
        try {
            int page = param.getPage();
            int size = param.getSize();
            int start = (page - 1) * size;

            String sql = "select * from wx_user_address where ui_id =? order by is_defaut desc limit " + start + "," + size;
            List<Wx_user_address> list = getDB().queryListT(sql,Wx_user_address.class,param.getUi_id());
            returnData.setReturnData(errorcode_success, "获取用户收货地址信息列表成功", list);
        } catch (Exception e) {
            log.error("GoodsBiz GainUserAddressList is error", e);
            returnData.setReturnData(errorcode_systerm, "GoodsBiz GainUserAddressList is error", "");
        }
    }

    /**
     * 获取我推荐的人
     */
    public void GainMyRecommendUser(ReturnDataNew returnData, BaseParam param) {
        try {
            String sql = "select * from wx_user_info where recommend_id=?  limit 1";
            List<Wx_user_info> list = getDB().queryListT(sql, Wx_user_info.class, param.getUi_id());
            returnData.setReturnData("0", "获取合伙人的收益汇总成功", list);
        } catch (Exception e) {
            log.error("GoodsBiz GainMyRecommendUser is error", e);
            returnData.setReturnData(errorcode_systerm, "GoodsBiz GainMyRecommendUser is error", "");
        }
    }


    /**
     * 新增地址
     */
    public void AddAddress(ReturnDataNew returnData, Param_addOrUpdate_Address param) {
        try {

            Wx_user_address wx_user_address = new  Wx_user_address();
            wx_user_address.setName(param.getName());
            wx_user_address.setTelephone(param.getTelephone());
            wx_user_address.setArea(param.getArea());
            wx_user_address.setAddress(param.getAddress());
            wx_user_address.setUi_id(param.getUi_id());
            if(param.getIs_defaut() != null){
                wx_user_address.setIs_defaut(param.getIs_defaut());
            }
            int id  = daoFactory.getWx_user_addressDao().insert(wx_user_address);
            if(id < 1){
                //新增失败
                returnData.setReturnData(errorcode_data, "新增地址失败", "");
                return;
            }
            wx_user_address.setUa_id(id);
            returnData.setReturnData(errorcode_success, "新增地址成功", wx_user_address);
        } catch (Exception e) {
            log.error("GoodsBiz AddAddress is error", e);
            returnData.setReturnData(errorcode_systerm, "GoodsBiz AddAddress is error", "");
        }
    }
    /**
     * 修改地址
     */
    public void upAddress(ReturnDataNew returnData, Param_addOrUpdate_Address param) {
        try {
            Wx_user_address wx_user_address = daoFactory.getWx_user_addressDao().selectByKey(param.getUa_id());
            if(wx_user_address == null){
                returnData.setReturnData(errorcode_data, "该地址不存在", "");
                return;
            }
            if(wx_user_address.getUi_id() != param.getUi_id()){
                returnData.setReturnData(errorcode_data, "该地址与用户信息不批对", "");
                return;
            }
            if(StringUtils.hasLength(param.getName())){
                wx_user_address.setName(param.getName());
            }
            if(StringUtils.hasLength(param.getTelephone())){
                wx_user_address.setTelephone(param.getTelephone());
            }
            if(StringUtils.hasLength(param.getArea())){
                wx_user_address.setArea(param.getArea());
            }
            if(StringUtils.hasLength(param.getAddress())){
                wx_user_address.setAddress(param.getAddress());
            }
            if(param.getIs_defaut() != null){
                wx_user_address.setIs_defaut(param.getIs_defaut());
            }
            int count  = daoFactory.getWx_user_addressDao().updateByKey(wx_user_address);
            if(count != 1){
                //新增失败
                returnData.setReturnData(errorcode_data, "修改地址失败", "");
                return;
            }
            returnData.setReturnData(errorcode_success, "修改地址成功", wx_user_address);
        } catch (Exception e) {
            log.error("GoodsBiz upAddress is error", e);
            returnData.setReturnData(errorcode_systerm, "GoodsBiz upAddress is error", "");
        }
    }

    /**
     * 删除地址
     */
    public void DelAddress(ReturnDataNew returnData, Param_del_Address param) {
        try {
           int count =  daoFactory.getWx_user_addressDao().deleteByKey(param.getUa_id());
            if(count != 1){
                //新增失败
                returnData.setReturnData(errorcode_data, "删除地址失败", "");
                return;
            }
            returnData.setReturnData(errorcode_success, "删除地址成功", "");
        } catch (Exception e) {
            log.error("GoodsBiz DelAddress is error", e);
            returnData.setReturnData(errorcode_systerm, "GoodsBiz DelAddress is error", "");
        }
    }

    /**
     * 设置为默认地址
     */
    public void isdefault_address(ReturnDataNew returnData, Param_del_Address param) {
        try {
            Wx_user_address wx_user_address = daoFactory.getWx_user_addressDao().selectByKey(param.getUa_id());
            if(wx_user_address == null){
                returnData.setReturnData(errorcode_data, "该地址不存在", "");
                return;
            }
            if(param.getIs_defaut() != null){
                wx_user_address.setIs_defaut(param.getIs_defaut());
            }

            int count  = daoFactory.getWx_user_addressDao().updateByKey(wx_user_address);
            if(count != 1){
                //新增失败
                returnData.setReturnData(errorcode_data, "设置为默认地址失败", "");
                return;
            }
            returnData.setReturnData(errorcode_success, "设置为默认地址成功", "");
        } catch (Exception e) {
            log.error("GoodsBiz isdefault_address is error", e);
            returnData.setReturnData(errorcode_systerm, "GoodsBiz isdefault_address is error", "");
        }
    }
    /****************************下面是封装的查询方法********************************/
    /**
     * 通过weixin_id  获取用户基本信息
     *
     * @param weixin_id
     * @return
     */
    public Wx_user_info FindUserInfoByWeixin_id(String weixin_id) {
        try {
            String sql = "select * from wx_user_info where weixin_id=? limit 1";
            Wx_user_info userinfo = getDB().queryUniqueT(sql, Wx_user_info.class, weixin_id);
            return userinfo;
        } catch (Exception e) {
            log.error("FindUserInfoByWeixin_no 查询用户信息失败", e);
        }
        return null;
    }

}
