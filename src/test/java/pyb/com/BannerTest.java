package pyb.com;

import apidoc.jxh.cn.InterfaceUtil;
import com.pyb.mvc.action.v1.param.BaseParam;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 轮播图管理
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BannerTest extends BaseWebTest {
    public String moduleName = "轮播图管理模块";
    /**
     * 1.0 获取首页banner图片列表例子：
     * <pre>
     * </pre>
     */
    @Test
    public void A_banner_list() throws Exception {
        MultiValueMap<String, String> params = getParams();
        sign(params, "dtype");

        MvcResult mvcResult = mockMvc.perform(post("/v1/goods/banner_list").params(params))
                .andExpect(status().isOk()).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.err.println(result);
        String path = this.getClass().getResource(".").getPath();
        path = path + "Banner.md";
        InterfaceUtil.AddInterfacePred(path, moduleName,
                "获取首页banner图片列表",
                "dtype",
                "/goods/banner_list",
                1,
                params,
                BaseParam.class,
                result);
    }

}
