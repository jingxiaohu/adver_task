package pyb.com;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class ZFB_PayFaceActionTest extends BaseWebTest{
	  /**
	   * 支付宝当面付例子：
	   * <pre>
	   * </pre>
	   */
	  @Test
	  public void zfb_charge_face() throws Exception {
	    int pay_type = 2;//支付类型 1:支付宝  2：微信  3：银联  4：钱包 5:龙支付 ',
	    int pay_price = 1;//充值金额 单位 分
	    int version = 1;//当前版本编号
	    String subject = "支付宝支付";//商品名称
	    int system_type = 1;//操作系统类型（IOS Android web） 1:android 2:IOS 3:web
	    long t = System.currentTimeMillis();//时间戳ms
	    String token = "559a778edef011aeeaabc210de0e615e";//令牌
	    int type = 1;////是支付 还是 充值  1：充值  2：普通订单支付  3：租赁订单支付
	    //收银台页面上，商品展示的超链接，必填
	    String show_url = "";
	    //页面跳转同步通知页面路径
	    String return_url = "";

	    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
	    params.add("dtype", dtype);
	    params.add("ui_id",1+"" );
	    params.add("pay_type", pay_type + "");
	    params.add("pay_price", pay_price + "");
	    params.add("version", version + "");
	    params.add("subject", subject + "");
	    params.add("system_type", system_type + "");
	    params.add("t", t + "");
	    params.add("token", token);
	    params.add("type", type + "");
	    params.add("show_url", show_url);
	    params.add("return_url", return_url);



	    sign(params, "dtype", "ui_id", "pay_type","pay_price","t","token");

	    MvcResult mvcResult = mockMvc.perform(post("/v1/zfb_charge_face").params(params))
	        .andExpect(status().isOk()).andReturn();
	    System.err.println(mvcResult.getResponse().getContentAsString());
	  }


	/**
	 * 支付宝充值或者支付例子：
	 * <pre>
	 * </pre>
	 */
	@Test
	public void zfb_charge() throws Exception {
		int pay_type = 2;//支付类型 1:支付宝  2：微信  3：银联  4：钱包 5:龙支付 ',
		int pay_price = 1;//充值金额 单位 分
		int version = 1;//当前版本编号
		String subject = "支付宝支付";//商品名称
		int system_type = 1;//操作系统类型（IOS Android web） 1:android 2:IOS 3:web
		long t = System.currentTimeMillis();//时间戳ms
		int type = 1;////是支付 还是 充值  1：充值  2：普通订单支付  3：租赁订单支付
		String orderid="";//付款 订单ID 如果多个 中间逗号分割 例如（a123,b123,c123）

		MultiValueMap<String, String> params = getParams();
		params.add("pay_type", pay_type + "");
		params.add("pay_price", pay_price + "");
		params.add("version", version + "");
		params.add("subject", subject + "");
		params.add("system_type", system_type + "");
		params.add("t", t + "");
		params.add("type", type + "");
		params.add("orderid",orderid);



		sign(params, "dtype", "ui_id", "pay_type","pay_price","t","token");

		MvcResult mvcResult = mockMvc.perform(post("/v1/zfb_charge").params(params))
				.andExpect(status().isOk()).andReturn();
		System.err.println(mvcResult.getResponse().getContentAsString());
	}



	/**
	 * 支付宝充值或者支付例子：
	 * <pre>
	 * </pre>
	 */
	@Test
	public void zfb_charge_pc() throws Exception {
		int pay_type = 2;//支付类型 1:支付宝  2：微信  3：银联  4：钱包 5:龙支付 ',
		int pay_price = 1;//充值金额 单位 分
		int version = 1;//当前版本编号
		String subject = "支付宝支付";//商品名称
		int system_type = 1;//操作系统类型（IOS Android web） 1:android 2:IOS 3:web
		long t = System.currentTimeMillis();//时间戳ms
		int type = 1;////是支付 还是 充值  1：充值  2：普通订单支付  3：租赁订单支付
		String orderid="";//付款 订单ID 如果多个 中间逗号分割 例如（a123,b123,c123）

		MultiValueMap<String, String> params = getParams();
		params.add("pay_type", pay_type + "");
		params.add("pay_price", pay_price + "");
		params.add("version", version + "");
		params.add("subject", subject + "");
		params.add("system_type", system_type + "");
		params.add("t", t + "");
		params.add("type", type + "");
		params.add("orderid",orderid);



		sign(params, "dtype", "ui_id", "pay_type","pay_price","t","token");

		MvcResult mvcResult = mockMvc.perform(post("/v1/zfb_charge_pc").params(params))
				.andExpect(status().isOk()).andReturn();
		System.err.println(mvcResult.getResponse().getContentAsString());
	}
}
