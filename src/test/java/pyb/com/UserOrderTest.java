package pyb.com;

import apidoc.jxh.cn.InterfaceUtil;
import com.pyb.mvc.action.v1.pay.param.Param_wx_charge_jsapi;
import com.pyb.mvc.action.v1.weixin.order.param.Param_order;
import com.pyb.mvc.action.v1.weixin.order.param.Param_orderList;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 订单管理
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserOrderTest extends BaseWebTest {
    public String moduleName = "订单管理模块";
    /**
     * 1.0 获取用户订单列表例子：
     * <pre>
     * </pre>
     */
    @Test
    public void A_order_list() throws Exception {
        MultiValueMap<String, String> params = getParams();
        params.add("state","0");//订单状态 0：待付款 1：待发货 2：待收货 3：已完成
        sign(params, "dtype","ui_id");

        MvcResult mvcResult = mockMvc.perform(post("/v1/goods/order_list").params(params))
                .andExpect(status().isOk()).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.err.println(result);
        String path = this.getClass().getResource(".").getPath();
        path = path + "UserOrder.md";
        InterfaceUtil.AddInterfacePred(path, moduleName,
                "获取用户订单列表",
                "dtype+ui_id",
                "/goods/order_list",
                1,
                params,
                Param_orderList.class,
                result);
    }
    /**
     * 1.1 用户取消订单例子：
     * <pre>
     * </pre>
     */
    @Test
    public void B_order_cancel() throws Exception {
        MultiValueMap<String, String> params = getParams();
        params.add("go_id","1");
        params.add("order_id","1");
        sign(params, "ui_id","go_id","order_id");

        MvcResult mvcResult = mockMvc.perform(post("/v1/goods/order_cancel").params(params))
                .andExpect(status().isOk()).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.err.println(result);
        String path = this.getClass().getResource(".").getPath();
        path = path + "UserOrder.md";
        InterfaceUtil.AddInterfacePred(path, moduleName,
                "用户取消订单",
                "ui_id+go_id+order_id",
                "/goods/order_cancel",
                2,
                params,
                Param_order.class,
                result);
    }

    /**
     * 1.2 获取订单详情例子：
     * <pre>
     * </pre>
     */
    @Test
    public void C_order_info() throws Exception {
        MultiValueMap<String, String> params = getParams();
        params.add("go_id","1");
        sign(params, "ui_id","go_id");

        MvcResult mvcResult = mockMvc.perform(post("/v1/goods/order_info").params(params))
                .andExpect(status().isOk()).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.err.println(result);
        String path = this.getClass().getResource(".").getPath();
        path = path + "UserOrder.md";
        InterfaceUtil.AddInterfacePred(path, moduleName,
                "获取订单详情",
                "ui_id+go_id",
                "/goods/order_info",
                3,
                params,
                Param_order.class,
                result);
    }

    /**
     * 1.3 用户商品下单例子：
     * <pre>
     *     {"data":{"nonce_str":"oeuhLzTX5YkNoxe0","appid":"wxebee99b0aba36d8f","sign":"B4A4BBFB7631FCF82801C14AAB0C1B5B","trade_type":"JSAPI","return_msg":"OK","result_code":"SUCCESS","mch_id":"1486469632","return_code":"SUCCESS","prepay_id":"wx2017121019201065d1194b600288348036"},"errorcode":"","errormsg":"微信充值成功","errorno":"0"}
     * </pre>
     */
    @Test
    public void D_weixin_charge_jsapi() throws Exception {
        int type = 0;//是支付 还是 充值  0:订单支付 1：充值
        long t = System.currentTimeMillis();//时间戳ms
        String openid="oA_cb0jLCM68XRZMlQ5Z_VHX5onI";//用户对于微信公众号APPID唯一ID
        /**
         * 商品信息
         */
        Long g_id = 1L;//商品主键ID
        Integer pay_price = 51;//充值金额或者商品价格总计 单位 分
        Integer num = 2;//购买数量
        String clothing = "{\"size\":[ 120,130,140,150],\"color\":[\"黄色\",\"红色\",\"蓝色\"]}";
        /**
         * 收货人信息
         */
        String address = "四川省成都市龙泉驿区十陵灵龙路23号";//收货地址
        String name = "敬小虎";//收货人姓名
        String telephone = "15882345446";//收货人电话号码

        MultiValueMap<String, String> params = getParams();
        params.add("type",type+"");
        params.add("t",t+"");
        params.add("g_id",g_id+"");
        params.add("pay_price",pay_price+"");
        params.add("num",num+"");
        params.add("address",address);
        params.add("name",name);
        params.add("telephone",telephone);
        params.add("openid",openid);
        params.add("clothing",clothing);

        sign(params, "dtype","ui_id","type","pay_price","t","token","g_id","num","telephone");

        MvcResult mvcResult = mockMvc.perform(post("/v1/goods/weixin_charge_jsapi").params(params))
                .andExpect(status().isOk()).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.err.println(result);
        String path = this.getClass().getResource(".").getPath();
        path = path + "UserOrder.md";
        InterfaceUtil.AddInterfacePred(path, moduleName,
                "用户商品下单",
                "dtype+ui_id+type+pay_price+t+token+g_id+num+telephone",
                "/goods/weixin_charge_jsapi",
                4,
                params,
                Param_wx_charge_jsapi.class,
                result);
    }

}
