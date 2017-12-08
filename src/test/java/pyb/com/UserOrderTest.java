package pyb.com;

import apidoc.jxh.cn.InterfaceUtil;
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
                "用户取消订单",
                "ui_id+go_id",
                "/goods/order_info",
                3,
                params,
                Param_order.class,
                result);
    }


}
