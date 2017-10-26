package pyb.com;

import apidoc.jxh.cn.InterfaceUtil;
import com.pyb.mvc.action.v1.channel.param.Param_MenuList;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 渠道
 */
public class MenuTest extends BaseWebTest {
    public String moduleName = "菜单管理模块";
    /**
     * 1.0 读取一级菜单列表例子：
     * <pre>
     *     {"data":[{"term_id":1,"name":"最新资讯","slug":"http://www.528ads.com/archives/category/news","term_group":0},{"term_id":3,"name":"股市笑话","slug":"http://www.528ads.com/archives/category/gsxh","term_group":0},{"term_id":4,"name":"本周热点","slug":"http://www.528ads.com/archives/category/bzrd","term_group":0},{"term_id":5,"name":"个股雷达","slug":"http://www.528ads.com/archives/category/ggld","term_group":0},{"term_id":7,"name":"赏善罚恶","slug":"http://www.528ads.com/archives/category/ssfe","term_group":0},{"term_id":8,"name":"解套心灵咨询","slug":"http://www.528ads.com/archives/category/jtxlzx","term_group":0},{"term_id":10,"name":"技术学习","slug":"http://www.528ads.com/archives/category/study","term_group":0}],"errorcode":"","errormsg":"获取成功","errorno":"0"}
     * </pre>
     */
    @Test
    public void menu_list() throws Exception {
        MultiValueMap<String, String> params = getParams();
        sign(params, "dtype","ui_id");

        MvcResult mvcResult = mockMvc.perform(post("/v1/menu_list").params(params))
                .andExpect(status().isOk()).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.err.println(result);
        String path = this.getClass().getResource(".").getPath();
        path = path + "Menu.md";
        InterfaceUtil.AddInterfacePred(path, moduleName,
                "读取一级菜单列表",
                "dtype+ui_id",
                "/v1/menu_list",
                1,
                params,
                Param_MenuList.class,
                result);
    }

    /**
     * 1.1 读取二级菜单列表例子：
     * <pre>
     *     {"data":[{"term_id":90,"name":"行业研究","slug":"bzrd/hyyj","term_group":0},{"term_id":91,"name":"数据资金","slug":"bzrd/sjzj","term_group":0},{"term_id":92,"name":"证券要闻","slug":"bzrd/zqyw","term_group":0},{"term_id":93,"name":"国内经济","slug":"bzrd/cgnjj","term_group":0}],"errorcode":"","errormsg":"获取成功","errorno":"0"}
     * </pre>
     */
    @Test
    public void menu_list2() throws Exception {
        MultiValueMap<String, String> params = getParams();
        params.add("term_id","4");
        params.add("slug","bzrd");

        sign(params, "dtype","ui_id","term_id","slug");

        MvcResult mvcResult = mockMvc.perform(post("/v1/menu_list2").params(params))
                .andExpect(status().isOk()).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.err.println(result);
        String path = this.getClass().getResource(".").getPath();
        path = path + "Menu.md";
        InterfaceUtil.AddInterfacePred(path, moduleName,
                "读取一级菜单列表",
                "dtype+ui_id+term_id+slug",
                "/v1/menu_list2",
                2,
                params,
                Param_MenuList.class,
                result);
    }
}
