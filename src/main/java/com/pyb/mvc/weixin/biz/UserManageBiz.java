package com.pyb.mvc.weixin.biz;

import com.alibaba.fastjson.JSON;
import com.pyb.bean.*;
import com.pyb.exception.QzException;
import com.pyb.mvc.action.v1.param.BaseParam;
import com.pyb.mvc.action.v1.user.param.Param_addOrUpdate_Address;
import com.pyb.mvc.action.v1.user.param.Param_del_Address;
import com.pyb.mvc.action.v1.weixin.user.param.Param_user_withdraw;
import com.pyb.mvc.action.v1.weixin.user.param.Param_user_withdraw_complement;
import com.pyb.mvc.action.v1.weixin.user.param.Param_user_withdraw_list;
import com.pyb.mvc.action.v1.weixin.user.param.Param_userinfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * 用户管理
 */
@Service
public class UserManageBiz extends BaseWxBiz {

    /**
     * 获取用户基本信息-openid
     */
    public void GainUserInfoByOpenId(ReturnDataNew returnData, Param_userinfo param) {
        try {
            String sql = "select * from wx_user_info where weixin_id=? limit 1";

            Wx_user_info userinfo = getDB().queryUniqueT(sql,Wx_user_info.class,param.getOpenid());
            returnData.setReturnData("0", "获取用户信息成功", userinfo);
        } catch (Exception e) {
            log.error("UserManageBiz GainUserInfoByOpenId is error", e);
            returnData.setReturnData(errorcode_systerm, "UserManageBiz GainUserInfoByOpenId is error", "");
        }
    }

    /**
     * 获取用户基本信息
     */
    public void GainUserInfo(ReturnDataNew returnData, Param_userinfo param) {
        try {
            Wx_user_info userinfo = daoFactory.getWx_user_infoDao().selectByKey(param.getUi_id());
            returnData.setReturnData("0", "获取用户信息成功", userinfo);
        } catch (Exception e) {
            log.error("UserManageBiz GainUserInfo is error", e);
            returnData.setReturnData(errorcode_systerm, "UserManageBiz GainUserInfo is error", "");
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
            log.error("UserManageBiz ApplyUser is error", e);
            returnData.setReturnData(errorcode_systerm, "UserManageBiz ApplyUser is error", "");
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
            log.error("UserManageBiz GainApplyUser is error", e);
            returnData.setReturnData(errorcode_systerm, "UserManageBiz GainApplyUser is error", "");
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
            log.error("UserManageBiz GainUserAddressList is error", e);
            returnData.setReturnData(errorcode_systerm, "UserManageBiz GainUserAddressList is error", "");
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
            log.error("UserManageBiz GainMyRecommendUser is error", e);
            returnData.setReturnData(errorcode_systerm, "UserManageBiz GainMyRecommendUser is error", "");
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
            log.error("UserManageBiz AddAddress is error", e);
            returnData.setReturnData(errorcode_systerm, "UserManageBiz AddAddress is error", "");
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
            log.error("UserManageBiz upAddress is error", e);
            returnData.setReturnData(errorcode_systerm, "UserManageBiz upAddress is error", "");
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
            log.error("UserManageBiz DelAddress is error", e);
            returnData.setReturnData(errorcode_systerm, "UserManageBiz DelAddress is error", "");
        }
    }

    /**
     * 设置为默认地址
     */
    public void isdefault_address(ReturnDataNew returnData, Param_del_Address param) {
        try {
            Wx_user_address wx_user_address =  FindUserDefaultAddress(param.getUi_id());
            if(wx_user_address != null){
                wx_user_address.setIs_defaut(0);
                int count  = daoFactory.getWx_user_addressDao().updateByKey(wx_user_address);
                if(count != 1){
                    returnData.setReturnData(errorcode_data, "设置为默认地址失败", "");
                    return;
                }
            }

            wx_user_address = daoFactory.getWx_user_addressDao().selectByKey(param.getUa_id());
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
            log.error("UserManageBiz isdefault_address is error", e);
            returnData.setReturnData(errorcode_systerm, "UserManageBiz isdefault_address is error", "");
        }
    }




    /**
     * 合作人提现
     */
    @Transactional(rollbackFor = QzException.class)
    public void UserWithDraw(ReturnDataNew returnData, Param_user_withdraw param) throws QzException{
        try {
            Date date = new Date();

            //获取用户信息
            Wx_user_info wx_user_info = daoFactory.getWx_user_infoDao().selectByKey(param.getUi_id());
            if(wx_user_info == null){
                returnData.setReturnData(errorcode_data,"该用户不存在","");
                return;
            }
            if(!StringUtils.hasLength(wx_user_info.getTelephone())){
                //用户没有绑定手机号码
                returnData.setReturnData(errorcode_data,"亲，你还没有绑定手机号码","1");
                return;
            }
            if(!StringUtils.hasLength(wx_user_info.getUser_weixin())){
                //用户没有绑定微信号码
                returnData.setReturnData(errorcode_data,"亲，你还没有绑定微信号码","1");
                return;
            }

            String sql = "select * from wx_recommend_earnings where ui_id=? and state=1 limit 1";
            Wx_recommend_earnings wx_recommend_earnings = getDB().queryUniqueT(sql, Wx_recommend_earnings.class, param.getUi_id());
            if(wx_recommend_earnings == null){
                returnData.setReturnData(errorcode_data,"非法请求","");
                return;
            }

            if(wx_recommend_earnings.getAllow_drawings() - param.getMoney() < 0){
                returnData.setReturnData(errorcode_data,"你没有那么多钱可提现,亲","","2");
                return;
            }

            String snap_json = JSON.toJSONString(wx_recommend_earnings);

            wx_recommend_earnings.setAllow_drawings(wx_recommend_earnings.getAllow_drawings() - param.getMoney());//可提现收益
            wx_recommend_earnings.setDrawings(wx_recommend_earnings.getDrawings()+param.getMoney());//提现收益
            wx_recommend_earnings.setUtime(date);
            int count = daoFactory.getWx_recommend_earningsDao().updateByKey(wx_recommend_earnings);
            if(count != 1){
                returnData.setReturnData(errorcode_data,"提现失败","","3");
                throw new QzException("提现失败 daoFactory.getWx_recommend_earningsDao().updateByKey ui_id="+param.getUi_id());
            }

            Wx_user_withdraw wx_user_withdraw = new Wx_user_withdraw();
            wx_user_withdraw.setCtime(date);
            wx_user_withdraw.setMoney(param.getMoney());
            wx_user_withdraw.setSnap_json(snap_json);
            wx_user_withdraw.setTelephone(wx_user_info.getTelephone());
            wx_user_withdraw.setWeixin_no(wx_user_info.getUser_weixin());
            wx_user_withdraw.setUi_id(param.getUi_id());
            int id = daoFactory.getWx_user_withdrawDao().insert(wx_user_withdraw);
            if(id < 1){
                returnData.setReturnData(errorcode_data,"提现失败","","3");
                throw new QzException("提现失败 daoFactory.getWx_user_withdrawDao().insert(wx_user_withdraw) ui_id="+param.getUi_id());
            }
            returnData.setReturnData(errorcode_success, "提现申请成功","");
        } catch (Exception e) {
            log.error("UserManageBiz UserWithDraw is error", e);
            returnData.setReturnData(errorcode_systerm, "UserManageBiz UserWithDraw is error", "");
            throw new QzException("提现失败 ui_id="+param.getUi_id(),e);
        }
    }



    /**
     * 合作人完善个人提现信息
     */
    public void UserWithDrawComplement(ReturnDataNew returnData, Param_user_withdraw_complement param){
        try {
            Date date = new Date();

            //获取用户信息
            Wx_user_info wx_user_info = daoFactory.getWx_user_infoDao().selectByKey(param.getUi_id());
            if(wx_user_info == null){
                returnData.setReturnData(errorcode_data,"该用户不存在","");
                return;
            }
            if(!StringUtils.hasLength(wx_user_info.getTelephone())){
                //用户没有绑定手机号码
                wx_user_info.setTelephone(param.getTelephone());
            }
            if(!StringUtils.hasLength(wx_user_info.getUser_weixin())){
                //用户没有绑定微信号码
                wx_user_info.setUser_weixin(param.getUser_weixin());
            }
            wx_user_info.setUtime(date);
            int count = daoFactory.getWx_user_infoDao().updateByKey(wx_user_info);
            if(count != 1){
                returnData.setReturnData(errorcode_data,"合作人完善个人提现信息失败","");
                return ;
            }
            returnData.setReturnData(errorcode_success, "合作人完善个人提现信息成功","");
        } catch (Exception e) {
            log.error("UserManageBiz UserWithDrawComplement is error", e);
            returnData.setReturnData(errorcode_systerm, "UserManageBiz UserWithDrawComplement is error", "");
        }
    }


    /**
     * 获取用户提现明细列表
     */
    public void GainUserWithDrawList(ReturnDataNew returnData, Param_user_withdraw_list param) {
        try {
            int page = param.getPage();
            int size = param.getSize();
            int start = (page - 1) * size;
            if(param.getState() == null){
                String sql = "select * from wx_user_withdraw where ui_id =? and is_del=0 order by ctime desc  limit " + start + "," + size;
                List<Wx_user_withdraw> list = getDB().queryListT(sql,Wx_user_withdraw.class,param.getUi_id());
                returnData.setReturnData(errorcode_success, "获取用户提现明细列表成功", list);
            }else{
                String sql = "select * from wx_user_withdraw where ui_id =? and state=? and is_del=0 order by ctime desc limit " + start + "," + size;
                List<Wx_user_withdraw> list = getDB().queryListT(sql,Wx_user_withdraw.class,param.getUi_id(),param.getState());
                returnData.setReturnData(errorcode_success, "获取用户提现明细列表成功", list);
            }

        } catch (Exception e) {
            log.error("UserManageBiz GainUserWithDrawList is error", e);
            returnData.setReturnData(errorcode_systerm, "UserManageBiz GainUserWithDrawList is error", "");
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

    /**
     * 查找是否已经有设置为默认地址的了 如果有则不允许设置
     */
    public  Wx_user_address FindUserDefaultAddress(long ui_id){

        try {
            String sql = "select * from wx_user_address where ui_id=? and is_defaut=1 limit 1";
            Wx_user_address wx_user_address = getDB().queryUniqueT(sql, Wx_user_address.class, ui_id);
            return wx_user_address;
        } catch (Exception e) {
            log.error("FindUserDefaultAddress 查找是否已经有设置为默认地址失败", e);
        }
        return null;
    }
}
