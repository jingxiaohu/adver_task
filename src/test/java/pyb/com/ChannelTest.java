package pyb.com;

import apidoc.jxh.cn.InterfaceUtil;
import com.pyb.mvc.action.v1.channel.param.Param_ChannelList;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 渠道
 */
public class ChannelTest extends BaseWebTest {
    public String moduleName = "渠道管理模块";
    /**
     * 1.0 读取频道信息列表例子：
     * <pre>
     *     {"data":[{"ci_id":4,"ci_name":"每日精选","ui_id":1,"ctime":1464015331000,"is_show":0,"ci_type":1,"ci_sort":100,"note":"","ui_nickname":"小虎","ui_avtar":"http://app.qc-wbo.com/file/img/avatar/2017/head251878350@qq.com_27163.jpg"},{"ci_id":8,"ci_name":"每周精选","ui_id":1,"ctime":1464704677000,"is_show":0,"ci_type":1,"ci_sort":90,"note":"","ui_nickname":"小虎","ui_avtar":"http://app.qc-wbo.com/file/img/avatar/2017/head251878350@qq.com_27163.jpg"},{"ci_id":3,"ci_name":"实时大单","ui_id":1,"ctime":1463469929000,"is_show":0,"ci_type":0,"ci_sort":80,"note":"","ui_nickname":"小虎","ui_avtar":"http://app.qc-wbo.com/file/img/avatar/2017/head251878350@qq.com_27163.jpg"},{"ci_id":1,"ci_name":"实时新闻","ui_id":1,"ctime":1457727689000,"is_show":0,"ci_type":0,"ci_sort":70,"note":"","ui_nickname":"小虎","ui_avtar":"http://app.qc-wbo.com/file/img/avatar/2017/head251878350@qq.com_27163.jpg"},{"ci_id":5,"ci_name":"停复牌提示","ui_id":1,"ctime":1464170190000,"is_show":0,"ci_type":0,"ci_sort":60,"note":"东方财富网抓取","ui_nickname":"小虎","ui_avtar":"http://app.qc-wbo.com/file/img/avatar/2017/head251878350@qq.com_27163.jpg"},{"ci_id":6,"ci_name":"定增增发","ui_id":1,"ctime":1464186308000,"is_show":0,"ci_type":0,"ci_sort":50,"note":"东方财富网抓取","ui_nickname":"小虎","ui_avtar":"http://app.qc-wbo.com/file/img/avatar/2017/head251878350@qq.com_27163.jpg"},{"ci_id":9,"ci_name":"预案分配","ui_id":1,"ctime":1465288307000,"is_show":0,"ci_type":0,"ci_sort":45,"note":"东方财富网抓取","ui_nickname":"小虎","ui_avtar":"http://app.qc-wbo.com/file/img/avatar/2017/head251878350@qq.com_27163.jpg"},{"ci_id":7,"ci_name":"分红转赠","ui_id":1,"ctime":1464186341000,"is_show":0,"ci_type":0,"ci_sort":40,"note":"东方财富网抓取","ui_nickname":"小虎","ui_avtar":"http://app.qc-wbo.com/file/img/avatar/2017/head251878350@qq.com_27163.jpg"}],"errorcode":"","errormsg":"获取成功","errorno":"0"}
     * </pre>
     */
    @Test
    public void channel_list() throws Exception {
        MultiValueMap<String, String> params = getParams();
        sign(params, "dtype","ui_id");

        MvcResult mvcResult = mockMvc.perform(post("/v1/channel_list").params(params))
                .andExpect(status().isOk()).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.err.println(result);
        String path = this.getClass().getResource(".").getPath();
        path = path + "Channel.md";
        InterfaceUtil.AddInterfacePred(path, moduleName,
                "读取频道信息列表",
                "dtype+ui_id",
                "/v1/channel_list",
                1,
                params,
                Param_ChannelList.class,
                result);
    }

}
