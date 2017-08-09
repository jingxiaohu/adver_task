package pyb.com;

import apidoc.jxh.cn.InterfaceUtil;
import com.pyb.mvc.action.v1.message.param.Param_liveinfo;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 消息测试
 *
 * @author Peter Wu
 */
public class MessageTest extends BaseWebTest {
    public String moduleName = "消息管理模块";

    /**
     * 获取直播消息例子：
     * <pre>
     *     {"data":[{"ci_id":1,"mi_area":1,"mi_content":"据中证登数据，中国股市截至8月4日当周新增投资者数量32.06万，环比增加4.6%。","mi_createtime":1502264882000,"mi_day":"2017-08-09","mi_flag":0,"mi_id":904515,"mi_image":"","mi_title":"据中证登数据，中国股市截至8月4日当周新增投资者数量32.06万，环比增加4.6%。","mi_type":"","note":"","title_md5":"f4261e94e544869ac21998772c1c2348","ui_id":1,"uptime":"1502264747"},{"ci_id":1,"mi_area":1,"mi_content":"中国股市截至8月4日当周新增投资者数量32.06万，环比增加4.6%。","mi_createtime":1502264703000,"mi_day":"2017-08-09","mi_flag":0,"mi_id":904514,"mi_image":"","mi_title":"中国股市截至8月4日当周新增投资者数量32.06万，环比增加4.6%。","mi_type":"","note":"","title_md5":"da85864d17c2600273dc6e870f766bb5","ui_id":1,"uptime":"1502264644"},{"ci_id":1,"mi_area":1,"mi_content":"沙特油长发推文称，将与伊拉克油长讨论共同努力稳定油市。","mi_createtime":1502264522000,"mi_day":"2017-08-09","mi_flag":0,"mi_id":904513,"mi_image":"","mi_title":"沙特油长发推文称，将与伊拉克油长讨论共同努力稳定油市。","mi_type":"","note":"","title_md5":"9051c7535c555ec42a3fe25e5924ef15","ui_id":1,"uptime":"1502264495"},{"ci_id":1,"mi_area":1,"mi_content":"市场消息：沙特及伊朗油长将在周四举行新闻发布会。","mi_createtime":1502264166000,"mi_day":"2017-08-09","mi_flag":0,"mi_id":904512,"mi_image":"","mi_title":"市场消息：沙特及伊朗油长将在周四举行新闻发布会。","mi_type":"","note":"","title_md5":"ba2bd1cfd78c5b3e221fca15519dc5c5","ui_id":1,"uptime":"1502264041"},{"ci_id":1,"mi_area":1,"mi_content":"市场消息：沙特及伊拉克油长将在周四举行新闻发布会。","mi_createtime":1502264164000,"mi_day":"2017-08-09","mi_flag":0,"mi_id":904511,"mi_image":"","mi_title":"市场消息：沙特及伊拉克油长将在周四举行新闻发布会。","mi_type":"","note":"","title_md5":"5df60ab8bb1683a74a2df045cf0bfe6a","ui_id":1,"uptime":"1502264067"},{"ci_id":1,"mi_area":1,"mi_content":"发改委印发《社会领域产业专项债券发行指引》，涉及健康、养老、教育培训、文化、体育、旅游等产业。","mi_createtime":1502264163000,"mi_day":"2017-08-09","mi_flag":0,"mi_id":904510,"mi_image":"","mi_title":"发改委印发《社会领域产业专项债券发行指引》，涉及健康、养老、教育培训、文化、体育、旅游等产业。","mi_type":"","note":"","title_md5":"b672e2eed2db153ccf6423ecdb5aeb7e","ui_id":1,"uptime":"1502264154"},{"ci_id":1,"mi_area":1,"mi_content":"现货白银涨幅扩大，现报16.65美元/盎司，日内涨1.17%。","mi_createtime":1502263622000,"mi_day":"2017-08-09","mi_flag":0,"mi_id":904509,"mi_image":"","mi_title":"现货白银涨幅扩大，现报16.65美元/盎司，日内涨1.17%。","mi_type":"","note":"","title_md5":"dcb074ea509b4e3c21e80b212b9d2048","ui_id":1,"uptime":"1502263475"},{"ci_id":1,"mi_area":1,"mi_content":"猫眼电影数据显示，《战狼2》上映第14天，票房突破37亿元。","mi_createtime":1502263082000,"mi_day":"2017-08-09","mi_flag":0,"mi_id":904508,"mi_image":"","mi_title":"猫眼电影数据显示，《战狼2》上映第14天，票房突破37亿元。","mi_type":"","note":"","title_md5":"949025f6957c9c706e0bc0a9814da763","ui_id":1,"uptime":"1502263040"},{"ci_id":1,"mi_area":1,"mi_content":"外管局：二季度境外投资者对境内金融机构直接投资净流入20.83亿美元。二季度境内金融机构对境外直接投资净流出4.55亿美元。","mi_createtime":1502262724000,"mi_day":"2017-08-09","mi_flag":0,"mi_id":904507,"mi_image":"","mi_title":"外管局：二季度境外投资者对境内金融机构直接投资净流入20.83亿美元。二季度境内金融机构对境外直接投资净流出4.55亿美元。","mi_type":"","note":"","title_md5":"de1b25b3949f88123843f75380104649","ui_id":1,"uptime":"1502262640"},{"ci_id":1,"mi_area":1,"mi_content":"在岸人民币兑美元大涨244点升破6.68关口，创近10个半月新高。","mi_createtime":1502262369000,"mi_day":"2017-08-09","mi_flag":0,"mi_id":904506,"mi_image":"","mi_title":"在岸人民币兑美元大涨244点升破6.68关口，创近10个半月新高。","mi_type":"","note":"","title_md5":"80b8ce336fef20b7f213f3481b463821","ui_id":1,"uptime":"1502262186"},{"ci_id":1,"mi_area":1,"mi_content":"在岸人民币兑美元升破6.68关口，创近10个半月新高，较上一日夜盘收盘涨近300点。","mi_createtime":1502262364000,"mi_day":"2017-08-09","mi_flag":0,"mi_id":904505,"mi_image":"","mi_title":"在岸人民币兑美元升破6.68关口，创近10个半月新高，较上一日夜盘收盘涨近300点。","mi_type":"","note":"","title_md5":"fc253311ce1355cadc6280326daa4418","ui_id":1,"uptime":"1502262320"},{"ci_id":1,"mi_area":1,"mi_content":"【杭州建立全国首个智慧住房租赁平台：所有房源全部纳入】8月9日，杭州住保房管局与阿里巴巴集团、蚂蚁金服集团在杭州市人民政府会议中心就合作搭建智慧住房租赁监管服务平台举行签约仪式。这标志着杭州加快培育和发展住房租赁市场试点工作向前迈出了重要一步。建成后的杭州住房租赁监管服务平台，将实现租赁环节、租赁房源、租赁信息“三个全”的目标。（澎湃）","mi_createtime":1502262362000,"mi_day":"2017-08-09","mi_flag":0,"mi_id":904504,"mi_image":"","mi_title":"【杭州建立全国首个智慧住房租赁平台：所有房源全部纳入】8月9日，杭州住保房管局与阿里巴巴集团、蚂蚁金服集团在杭州市人民政府会议中心就合作搭建智慧住房租赁监管服务平台举行签约仪式。这标志着杭州加快培育和发展住房租赁市场试点工作向前迈出了重要一步。建成后的杭州住房租赁监管服务平台，将实现租赁环节、租赁房源、租赁信息“三个全”的目标。（澎湃）","mi_type":"","note":"","title_md5":"00c740ac9400ccea9d4b9af803b93ffa","ui_id":1,"uptime":"1502262360"},{"ci_id":1,"mi_area":1,"mi_content":"【沪铝期货主力全天强势收涨5%，焦煤、硅铁收涨逾4%】沪镍、沪锌、橡胶、焦炭、沪铅、鸡蛋收涨逾3%，沥青、玻璃、螺纹钢涨超2%，热卷、锰硅、郑煤、沪银、沪铜涨超1%，郑棉、铁矿石、沪金收涨。白糖、沪锡收跌。","mi_createtime":1502262184000,"mi_day":"2017-08-09","mi_flag":0,"mi_id":904503,"mi_image":"","mi_title":"【沪铝期货主力全天强势收涨5%，焦煤、硅铁收涨逾4%】沪镍、沪锌、橡胶、焦炭、沪铅、鸡蛋收涨逾3%，沥青、玻璃、螺纹钢涨超2%，热卷、锰硅、郑煤、沪银、沪铜涨超1%，郑棉、铁矿石、沪金收涨。白糖、沪锡收跌。","mi_type":"","note":"","title_md5":"2c0f519640101a735e6a11b2ff8b205e","ui_id":1,"uptime":"1502262070"},{"ci_id":1,"mi_area":1,"mi_content":"【指数午后窄幅震荡，煤炭、稀土涨势凶猛】沪指收报3275.57点，跌0.19%，成交额2378亿。深成指收报10544.59点，涨0.46%，成交额2595亿。创业板收报1763.05点，涨0.04%，成交额667亿。","mi_createtime":1502262182000,"mi_day":"2017-08-09","mi_flag":0,"mi_id":904502,"mi_image":"","mi_title":"【指数午后窄幅震荡，煤炭、稀土涨势凶猛】沪指收报3275.57点，跌0.19%，成交额2378亿。深成指收报10544.59点，涨0.46%，成交额2595亿。创业板收报1763.05点，涨0.04%，成交额667亿。","mi_type":"","note":"","title_md5":"0d191295d617f45deea6f65c4cfb54c1","ui_id":1,"uptime":"1502262149"},{"ci_id":1,"mi_area":1,"mi_content":"京东宣布年内开设300余家零售体验店。","mi_createtime":1502261464000,"mi_day":"2017-08-09","mi_flag":0,"mi_id":904399,"mi_image":"","mi_title":"京东宣布年内开设300余家零售体验店。","mi_type":"","note":"","title_md5":"d1c152f85351aebf0cd484fe06fa076d","ui_id":1,"uptime":"1502261284"},{"ci_id":1,"mi_area":1,"mi_content":"【环保督查刚开始，四川水泥已涨50元/吨】8月7日中央第四批环保督察工作全面启动，第五环保督察组率先进川进行为期一个月的督察工作。川中成德绵及周边地区多数熟料线以及水泥磨机陆续停产，相关商混站、矿山、砂石开采以及码头运输等行业同步整顿，市场需求下滑明显，不同企业销量下降4-6成左右。水泥价格方面，受停窑限产供给减少影响，7-8日成都部分大厂开始通知上调袋装水泥价格50元/吨，散装上调30元/吨左右。（中国水泥网）","mi_createtime":1502261463000,"mi_day":"2017-08-09","mi_flag":0,"mi_id":904398,"mi_image":"","mi_title":"【环保督查刚开始，四川水泥已涨50元/吨】8月7日中央第四批环保督察工作全面启动，第五环保督察组率先进川进行为期一个月的督察工作。川中成德绵及周边地区多数熟料线以及水泥磨机陆续停产，相关商混站、矿山、砂石开采以及码头运输等行业同步整顿，市场需求下滑明显，不同企业销量下降4-6成左右。水泥价格方面，受停窑限产供给减少影响，7-8日成都部分大厂开始通知上调袋装水泥价格50元/吨，散装上调30元/吨左右。（中国水泥网）","mi_type":"","note":"","title_md5":"b0da4665797d8816ccf69b6082f1052e","ui_id":1,"uptime":"1502261319"},{"ci_id":1,"mi_area":1,"mi_content":"【14点前后钢铁股全线走高，多只钢铁股涨停】安阳钢铁、凌钢股份、柳钢股份均涨停。此前据经济通消息，中钢协今日邀集工信部、中证监、上海期货交易所以及钢企高管，开会讨论钢价问题。","mi_createtime":1502260923000,"mi_day":"2017-08-09","mi_flag":0,"mi_id":904297,"mi_image":"","mi_title":"【14点前后钢铁股全线走高，多只钢铁股涨停】安阳钢铁、凌钢股份、柳钢股份均涨停。此前据经济通消息，中钢协今日邀集工信部、中证监、上海期货交易所以及钢企高管，开会讨论钢价问题。","mi_type":"","note":"","title_md5":"38f9261654aa933e8f6c40e57a475e86","ui_id":1,"uptime":"1502260918"},{"ci_id":1,"mi_area":1,"mi_content":"韩国首尔综指收跌1.05%。","mi_createtime":1502260385000,"mi_day":"2017-08-09","mi_flag":0,"mi_id":904197,"mi_image":"","mi_title":"韩国首尔综指收跌1.05%。","mi_type":"","note":"","title_md5":"33246c6d5ddf3fee0fb793cb9a58e9fe","ui_id":1,"uptime":"1502260219"},{"ci_id":1,"mi_area":1,"mi_content":"中国商务部：从全年来看，我国外贸发展面临的不确定、不稳定因素仍然较多。全球经济复苏的基础还不稳固，“逆全球化”思潮抬头，贸易保护主义升温，国内综合要素成本不断上涨，订单和产业转移仍然较快，我出口仍然面临诸多困难和挑战，保持进出口回稳向好势头的任务仍然艰巨。","mi_createtime":1502260384000,"mi_day":"2017-08-09","mi_flag":0,"mi_id":904195,"mi_image":"","mi_title":"中国商务部：从全年来看，我国外贸发展面临的不确定、不稳定因素仍然较多。全球经济复苏的基础还不稳固，“逆全球化”思潮抬头，贸易保护主义升温，国内综合要素成本不断上涨，订单和产业转移仍然较快，我出口仍然面临诸多困难和挑战，保持进出口回稳向好势头的任务仍然艰巨。","mi_type":"","note":"","title_md5":"4ff4912c5789ea88890d548c5d17fdb8","ui_id":1,"uptime":"1502260261"},{"ci_id":1,"mi_area":1,"mi_content":"中国商务部：出口仍然面临诸多困难和挑战。全年外贸发展面临的不确定、不稳定因素仍然较多。保持进出口回稳向好势头的任务仍然艰巨。将进一步提高贸易便利水平。","mi_createtime":1502260203000,"mi_day":"2017-08-09","mi_flag":0,"mi_id":904158,"mi_image":"","mi_title":"中国商务部：出口仍然面临诸多困难和挑战。全年外贸发展面临的不确定、不稳定因素仍然较多。保持进出口回稳向好势头的任务仍然艰巨。将进一步提高贸易便利水平。","mi_type":"","note":"","title_md5":"eaed873506fae74f1b9fab9a00866f4a","ui_id":1,"uptime":"1502260166"}],"errorcode":"","errormsg":"","errorno":"0"}
     * </pre>
     */
    @Test
    public void live_info() throws Exception {
        // @TargetComment(value = "直播频道ID",isnull = "否")
        String ci_id = "1";
        // @TargetComment(value = "直播消息ID",isnull = "是")
        String mi_id = "1";
        //@TargetComment(value = "0:表示向上取 1：表示向下取",isnull = "是")
        int type = 0;
        MultiValueMap<String, String> params = getParams();
        params.add("ci_id", ci_id);
        params.add("mi_id", mi_id);//固定参数：1：注册 2：重置密码 3:重置绑定电话号码  4：绑定银行卡
        params.add("type", type + "");//类型（0:未指定 1:邮箱 2:手机）

        sign(params, "dtype", "ci_id");

        MvcResult mvcResult = mockMvc.perform(post("/v1/live_info").params(params))
                .andExpect(status().isOk()).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.err.println(result);
        String path = this.getClass().getResource(".").getPath();
        path = path + "Message.md";
        InterfaceUtil.AddInterfacePred(path, moduleName, "获取直播消息",
                "dtype+ci_id", "/v1/sendcode", 1,
                params, Param_liveinfo.class, result);
    }


}
