package pyb.com;

import apidoc.jxh.cn.InterfaceUtil;
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
}
