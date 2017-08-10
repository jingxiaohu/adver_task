package com.pyb.mvc.service.common;

import com.pyb.bean.ReturnDataNew;
import com.pyb.bean.User_info_new;
import com.pyb.bean.User_vc_act;
import com.pyb.exception.QzException;
import com.pyb.mvc.service.BaseBiz;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;

/**
 * 用户公用方法
 * @author jingxiaohu
 *
 */
@Service
public class UserPB extends BaseBiz{
	/**
	 * 变更用户钱包金额
	 * @param ui_id
	 * @param ui_nd
	 * @param type 0:新增 1:减少
	 * @param money
	 * @return
	 */
	public User_info_new updateUserMoney(long ui_id, String ui_nd, int type, int money){
		try {
			User_info_new user_info = daoFactory.getUser_info_newDao().selectByKey(ui_id);
			if(user_info == null || money < 1){
				return null;
			}
			if(type == 0){
				//增加
				user_info.setUi_vc(user_info.getUi_vc() + money);
			}else{
				//减少
				if(user_info.getUi_vc() - money >= 0){
					user_info.setUi_vc(user_info.getUi_vc() - money);
				}else{
					return null;
				}
			}
			int count = daoFactory.getUser_info_newDao().updateByKey(user_info);
			if(count < 1){
				return null;
			}
			return user_info;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("UserPB.updateUserMoney 变更用户钱包金额", e);
		}
		return null;
	}
	
	/**
	 * 
	 * @param act_type 用户行为0：订单支付1：充值2:系统返还
	 * @param money
	 * @param order_id
	 * @param order_type
	 * @param ui_id
	 * @param returnData
	 * @param pay_source 支付类型  1:支付宝 2：微信  3：银联  4：钱包   5:龙支付
	 * @param date
	 * @throws QzException
	 */
	public void recordVC(int act_type, int money, String order_id,
			int order_type, long ui_id,
			ReturnDataNew returnData, String act_name, String ui_nd, String tel, int pay_source,
			long upc_id, int discount_type, int discount_money, Date date) throws QzException{
    	try {
			//记录该次用户虚拟币更改记录
			User_vc_act  va = new User_vc_act();
			va.setUpc_id(upc_id);
			va.setDiscount_type(discount_type);
			va.setDiscount_money(discount_money);
			va.setAct_type(act_type);//用户行为  0：订单支付   1：充值  2:系统返还
			if(act_type == 0){
				va.setIs_add(0);//增加还是减少  0：减少  1：增加
			}else{
				va.setIs_add(1);//增加还是减少  0：减少  1：增加
			}
			
			va.setCtime(date);
			va.setMoney(money);//交易金额（单位 分）
			va.setOrder_id(order_id);//订单ID
			va.setOrder_type(order_type);//订单类型 0:普通订单 1：租赁订单
			va.setUi_id(ui_id);
			va.setState(1);//处理状态 0：未处理 1：已处理
			va.setAct_name(act_name);
			va.setTel(tel);//电话号码
			va.setUi_nd(ui_nd);//用户唯一标识符
			va.setPay_source(pay_source);//支付类型  1:支付宝 2：微信  3：银联  4：钱包   5:龙支付
			int count = daoFactory.getUser_vc_actDao().insert(va);
			if(count < 1){
				//更新失败
				returnData.setReturnData(errorcode_data, "缴费失败", "");
				throw new QzException("record_user_vc_act 缴费失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			returnData.setReturnData(errorcode_data, "缴费失败", "");
			throw new QzException("record_user_vc_act 缴费失败",e);
		}
	}
	
	
	
}
