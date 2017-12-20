package pyb.com;

import apidoc.jxh.cn.InterfaceUtil;
import com.pyb.mvc.action.v1.param.BaseParam;
import com.pyb.mvc.action.v1.user.param.Param_addOrUpdate_Address;
import com.pyb.mvc.action.v1.user.param.Param_del_Address;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 用户收货地址管理
 *
 * @author Peter Wu
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WxUserAddressTest extends BaseWebTest {
	public String moduleName = "收货地址管理模块";

  /**
   * 新增地址例子：
   * <pre>
   * </pre>
   */
  @Test
  public void A_add_address() throws Exception {
      MultiValueMap<String, String> params = getParams();
      params.add("name","敬小虎");
      params.add("telephone","15882345446");
      params.add("area","四川省成都市龙泉驿区");
      params.add("address","十陵灵龙路218号");
//      params.add("is_defaut","1");
      sign(params, "ui_id");

      MvcResult mvcResult = mockMvc.perform(post("/v1/goods/add_address").params(params))
              .andExpect(status().isOk()).andReturn();
      String result = mvcResult.getResponse().getContentAsString();
      System.err.println(result);
      String path = this.getClass().getResource(".").getPath();
      path = path + "WxUserAddress.md";
      InterfaceUtil.AddInterfacePredAspect(path, moduleName,
              "新增地址",
              "ui_id",
              "/goods/add_address",
              1,
              params,
              Param_addOrUpdate_Address.class,
              result);
  }


    /**
     * 修改地址例子：
     * <pre>
     * </pre>
     */
    @Test
    public void B_up_address() throws Exception {
        MultiValueMap<String, String> params = getParams();
        params.add("ua_id","1");
        params.add("name","敬小虎");
        params.add("telephone","15882345446");
        params.add("area","四川省成都市龙泉驿区");
        params.add("address","十陵灵龙路218号");
        params.add("is_defaut","1");
        sign(params, "ui_id");

        MvcResult mvcResult = mockMvc.perform(post("/v1/goods/up_address").params(params))
                .andExpect(status().isOk()).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.err.println(result);
        String path = this.getClass().getResource(".").getPath();
        path = path + "WxUserAddress.md";
        InterfaceUtil.AddInterfacePred(path, moduleName,
                "修改地址",
                "ui_id",
                "/goods/up_address",
                2,
                params,
                Param_addOrUpdate_Address.class,
                result);
    }

    /**
     * 设置为默认地址例子：
     * <pre>
     * </pre>
     */
    @Test
    public void C_isdefault_address() throws Exception {
        MultiValueMap<String, String> params = getParams();
        params.add("ua_id","1");
        params.add("is_defaut","1");
        sign(params, "ui_id");

        MvcResult mvcResult = mockMvc.perform(post("/v1/goods/isdefault_address").params(params))
                .andExpect(status().isOk()).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.err.println(result);
        String path = this.getClass().getResource(".").getPath();
        path = path + "WxUserAddress.md";
        InterfaceUtil.AddInterfacePred(path, moduleName,
                "设置为默认地址",
                "ui_id",
                "/goods/isdefault_address",
                3,
                params,
                Param_del_Address.class,
                result);
    }

    /**
     * 删除地址例子：
     * <pre>
     * </pre>
     */
    @Test
    public void D_del_address() throws Exception {
        MultiValueMap<String, String> params = getParams();
        params.add("ua_id","1");
        sign(params, "ui_id");

        MvcResult mvcResult = mockMvc.perform(post("/v1/goods/del_address").params(params))
                .andExpect(status().isOk()).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.err.println(result);
        String path = this.getClass().getResource(".").getPath();
        path = path + "WxUserAddress.md";
        InterfaceUtil.AddInterfacePred(path, moduleName,
                "删除地址",
                "ui_id",
                "/goods/del_address",
                4,
                params,
                Param_del_Address.class,
                result);
    }
    /**
     * 获取用户收货地址信息列表例子：
     * <pre>
     * </pre>
     */
    @Test
    public void E_address_list() throws Exception {
        MultiValueMap<String, String> params = getParams();
        sign(params, "ui_id");

        MvcResult mvcResult = mockMvc.perform(post("/v1/goods/address_list").params(params))
                .andExpect(status().isOk()).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.err.println(result);
        String path = this.getClass().getResource(".").getPath();
        path = path + "WxUserAddress.md";
        InterfaceUtil.AddInterfacePred(path, moduleName,
                "获取用户收货地址信息列表",
                "ui_id",
                "/goods/address_list",
                5,
                params,
                BaseParam.class,
                result);
    }


}
