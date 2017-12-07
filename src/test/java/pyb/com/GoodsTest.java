package pyb.com;

import apidoc.jxh.cn.InterfaceUtil;
import com.pyb.mvc.action.v1.weixin.goods.param.Param_goodsClassList;
import com.pyb.mvc.action.v1.weixin.goods.param.Param_goods_info;
import com.pyb.mvc.action.v1.weixin.goods.param.Param_goods_list;
import com.pyb.mvc.action.v1.weixin.goods.param.Param_search_goods_class;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 渠道
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GoodsTest extends BaseWebTest {
    public String moduleName = "商品管理模块";
    /**
     * 1.0 获取商品分类列表例子：
     * <pre>
     * </pre>
     */
    @Test
    public void A_goods_class_list() throws Exception {
        MultiValueMap<String, String> params = getParams();
        sign(params, "dtype");

        MvcResult mvcResult = mockMvc.perform(post("/v1/goods/goods_class_list").params(params))
                .andExpect(status().isOk()).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.err.println(result);
        String path = this.getClass().getResource(".").getPath();
        path = path + "Goods.md";
        InterfaceUtil.AddInterfacePred(path, moduleName,
                "获取商品分类列表",
                "dtype",
                "/goods/goods_class_list",
                1,
                params,
                Param_goodsClassList.class,
                result);
    }
    /**
     * 1.1 通过分类获取商品列表例子：
     * <pre>
     * </pre>
     */
    @Test
    public void B_search_goods_class() throws Exception {
        MultiValueMap<String, String> params = getParams();
        params.add("gt_id","1");
        sign(params, "gt_id");

        MvcResult mvcResult = mockMvc.perform(post("/v1/goods/search_goods_class").params(params))
                .andExpect(status().isOk()).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.err.println(result);
        String path = this.getClass().getResource(".").getPath();
        path = path + "Goods.md";
        InterfaceUtil.AddInterfacePred(path, moduleName,
                "通过分类获取商品列表",
                "gt_id",
                "/goods/search_goods_class",
                2,
                params,
                Param_search_goods_class.class,
                result);
    }

    /**
     * 1.2 通过类型获取商品列表例子：
     * <pre>
     * </pre>
     */
    @Test
    public void C_goods_list() throws Exception {
        MultiValueMap<String, String> params = getParams();
        params.add("type","1");
        sign(params, "dtype");

        MvcResult mvcResult = mockMvc.perform(post("/v1/goods/goods_list").params(params))
                .andExpect(status().isOk()).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.err.println(result);
        String path = this.getClass().getResource(".").getPath();
        path = path + "Goods.md";
        InterfaceUtil.AddInterfacePred(path, moduleName,
                "通过类型获取商品列表",
                "dtype",
                "/goods/goods_list",
                3,
                params,
                Param_goods_list.class,
                result);
    }

    /**
     * 1.3 获取商品信息例子：
     * <pre>
     * </pre>
     */
    @Test
    public void D_goods_info() throws Exception {
        MultiValueMap<String, String> params = getParams();
        params.add("g_id","1");
        sign(params, "g_id");

        MvcResult mvcResult = mockMvc.perform(post("/v1/goods/goods_info").params(params))
                .andExpect(status().isOk()).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.err.println(result);
        String path = this.getClass().getResource(".").getPath();
        path = path + "Goods.md";
        InterfaceUtil.AddInterfacePred(path, moduleName,
                "获取商品信息",
                "g_id",
                "/goods/goods_info",
                4,
                params,
                Param_goods_info.class,
                result);
    }
}
