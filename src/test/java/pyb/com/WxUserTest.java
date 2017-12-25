package pyb.com;

import apidoc.jxh.cn.InterfaceUtil;
import com.pyb.mvc.action.v1.param.BaseParam;
import com.pyb.mvc.action.v1.weixin.user.param.Param_user_withdraw;
import com.pyb.mvc.action.v1.weixin.user.param.Param_user_withdraw_complement;
import com.pyb.mvc.action.v1.weixin.user.param.Param_user_withdraw_list;
import com.pyb.mvc.action.v1.weixin.user.param.Param_userinfo;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 获取用户个人信息
 *
 * @author Peter Wu
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WxUserTest extends BaseWebTest {
	public String moduleName = "用户管理模块";

  /**
   * 获取用户基本信息例子：
   * <pre>
   * </pre>
   */
  @Test
  public void A_user_info() throws Exception {
      MultiValueMap<String, String> params = getParams();
      sign(params, "ui_id");

      MvcResult mvcResult = mockMvc.perform(post("/v1/goods/user_info").params(params))
              .andExpect(status().isOk()).andReturn();
      String result = mvcResult.getResponse().getContentAsString();
      System.err.println(result);
      String path = this.getClass().getResource(".").getPath();
      path = path + "WxUser.md";
      InterfaceUtil.AddInterfacePred(path, moduleName,
              "取用户基本信息",
              "ui_id",
              "/goods/user_info",
              1,
              params,
              Param_userinfo.class,
              result);
  }

    /**
     * 申请成为推荐合作人例子：
     * <pre>
     * </pre>
     */
    @Test
    public void B_apply_user() throws Exception {
        MultiValueMap<String, String> params = getParams();
        sign(params, "ui_id");

        MvcResult mvcResult = mockMvc.perform(post("/v1/goods/apply_user").params(params))
                .andExpect(status().isOk()).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.err.println(result);
        String path = this.getClass().getResource(".").getPath();
        path = path + "WxUser.md";
        InterfaceUtil.AddInterfacePred(path, moduleName,
                "申请成为推荐合作人",
                "ui_id",
                "/goods/apply_user",
                2,
                params,
                Param_userinfo.class,
                result);
    }


    /**
     * 获取推荐合作人例子：
     * <pre>
     * </pre>
     */
    @Test
    public void C_read_cooperator() throws Exception {
        MultiValueMap<String, String> params = getParams();
        sign(params, "ui_id");

        MvcResult mvcResult = mockMvc.perform(post("/v1/goods/read_cooperator").params(params))
                .andExpect(status().isOk()).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.err.println(result);
        String path = this.getClass().getResource(".").getPath();
        path = path + "WxUser.md";
        InterfaceUtil.AddInterfacePred(path, moduleName,
                "获取推荐合作人",
                "ui_id",
                "/goods/read_cooperator",
                3,
                params,
                Param_userinfo.class,
                result);
    }

    /**
     * 获取我推荐的人例子：
     * <pre>
     * </pre>
     */
    @Test
    public void D_read_cooperator() throws Exception {
        MultiValueMap<String, String> params = getParams();
        sign(params, "ui_id");

        MvcResult mvcResult = mockMvc.perform(post("/v1/goods/read_my_tj").params(params))
                .andExpect(status().isOk()).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.err.println(result);
        String path = this.getClass().getResource(".").getPath();
        path = path + "WxUser.md";
        InterfaceUtil.AddInterfacePred(path, moduleName,
                "获取我推荐的人",
                "ui_id",
                "/goods/read_my_tj",
                4,
                params,
                BaseParam.class,
                result);
    }




    /**
     * 获取用户个人信息-openid例子：
     * <pre>
     * </pre>
     */
    @Test
    public void E_user_info_openid() throws Exception {
        MultiValueMap<String, String> params = getParams();
        params.add("openid","oA_cb0jLCM68XRZMlQ5Z_VHX5onI");
        sign(params, "openid");

        MvcResult mvcResult = mockMvc.perform(post("/v1/goods/user_info_openid").params(params))
                .andExpect(status().isOk()).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.err.println(result);
        String path = this.getClass().getResource(".").getPath();
        path = path + "WxUser.md";
        InterfaceUtil.AddInterfacePred(path, moduleName,
                "获取用户个人信息-openid",
                "openid",
                "/goods/user_info_openid",
                5,
                params,
                Param_userinfo.class,
                result);
    }

    /**
     * 合作人完善个人提现信息例子：
     * <pre>
     * </pre>
     */
    @Test
    public void F_user_withdraw_complement() throws Exception {
        MultiValueMap<String, String> params = getParams();
        params.add("telephone","15882345446");
        params.add("user_weixin","j251878350");
        sign(params, "ui_id","telephone","user_weixin");

        MvcResult mvcResult = mockMvc.perform(post("/v1/goods/user_withdraw_complement").params(params))
                .andExpect(status().isOk()).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.err.println(result);
        String path = this.getClass().getResource(".").getPath();
        path = path + "WxUser.md";
        InterfaceUtil.AddInterfacePred(path, moduleName,
                "合作人完善个人提现信息",
                "ui_id+telephone+user_weixin",
                "/goods/user_withdraw_complement",
                6,
                params,
                Param_user_withdraw_complement.class,
                result);
    }


    /**
     * 合作人提现例子：
     * <pre>
     * </pre>
     */
    @Test
    public void G_user_withdraw() throws Exception {
        MultiValueMap<String, String> params = getParams();
        params.add("money","5000");
        sign(params, "ui_id","money");

        MvcResult mvcResult = mockMvc.perform(post("/v1/goods/user_withdraw").params(params))
                .andExpect(status().isOk()).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.err.println(result);
        String path = this.getClass().getResource(".").getPath();
        path = path + "WxUser.md";
        InterfaceUtil.AddInterfacePred(path, moduleName,
                "合作人提现",
                "ui_id+money",
                "/goods/user_withdraw",
                7,
                params,
                Param_user_withdraw.class,
                result);
    }


    /**
     * 获取用户提现明细列表例子：
     * <pre>
     * </pre>
     */
    @Test
    public void H_user_withdraw_list() throws Exception {
        MultiValueMap<String, String> params = getParams();
        params.add("state","0");
        sign(params, "ui_id");

        MvcResult mvcResult = mockMvc.perform(post("/v1/goods/user_withdraw_list").params(params))
                .andExpect(status().isOk()).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.err.println(result);
        String path = this.getClass().getResource(".").getPath();
        path = path + "WxUser.md";
        InterfaceUtil.AddInterfacePred(path, moduleName,
                "获取用户提现明细列表",
                "ui_id",
                "/goods/user_withdraw_list",
                8,
                params,
                Param_user_withdraw_list.class,
                result);
    }
}
