package pyb.com;

import apidoc.jxh.cn.InterfaceUtil;
import com.pyb.mvc.action.v1.channel.param.Param_ChannelList;
import com.pyb.mvc.action.v1.joke.param.Param_jokeClass;
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
                "获取笑话分类列表",
                "dtype+ui_id",
                "/v1/channel_list",
                1,
                params,
                Param_ChannelList.class,
                result);
    }
    /**
     * 2.0 获取jokesegment列表例子：
     * <pre>
     *     {"data":[{"js_id":256,"jc_id":1,"content":"老公:\"老婆，对不起，我现在上厕所，都需要扶墙，可能不行了！\"老婆:\"少装蒜，谁脚崴了，上厕所都扶墙，今晚老娘在上面。\"","is_show":0,"title":"段子531462798603634","js_type":0,"is_title":1,"is_spider":0,"ctime":1462798603000,"js_zan":0,"read_count":0,"note":"抓取过来的乱弄的标题"},{"js_id":512,"jc_id":1,"content":"同学a帮同学b买一本答案之书，背景介绍完，然后同学a心血来潮，特虔诚的问了一下我为什么没有女朋友，一翻书....说好的答案呢……","is_show":0,"title":"段子91462798631108","js_type":0,"is_title":1,"is_spider":0,"ctime":1462798631000,"js_zan":0,"read_count":0,"note":"抓取过来的乱弄的标题"},{"js_id":768,"jc_id":1,"content":"這樣也行 看起來很爽哦！ 有點似懂非懂滴","is_show":0,"title":"段子651462798658079","js_type":0,"is_title":1,"is_spider":0,"ctime":1462798658000,"js_zan":0,"read_count":0,"note":"抓取过来的乱弄的标题"},{"js_id":1536,"jc_id":1,"content":"谁有我糗？高中时谈了个恋爱，然后经常带着她和兄弟一起出去玩，后来分手后她跟我兄弟在一起了，下礼拜结婚，然后老家习俗结婚要找当初介绍认识的人当媒人，然后今天他们来找我去，因为我介绍他们认识的，我应不应该去？？？","is_show":0,"title":"段子331462798741420","js_type":0,"is_title":1,"is_spider":0,"ctime":1462798741000,"js_zan":0,"read_count":0,"note":"抓取过来的乱弄的标题"},{"js_id":1792,"jc_id":1,"content":"真事，前两天在网上买了一瓶药，一百多，赠了一个面膜特别特别好用，然后去找客服说这个面膜怎么卖？客服说这是非卖品，我说，这么好用的东西，怎么不卖。客服说你要是真想要就再买两瓶药吧。 卧槽，计谋啊！","is_show":0,"title":"段子891462798768152","js_type":0,"is_title":1,"is_spider":0,"ctime":1462798768000,"js_zan":0,"read_count":0,"note":"抓取过来的乱弄的标题"},{"js_id":2048,"jc_id":1,"content":"国际巨星爆尸荒野。公安部门已介入调查。","is_show":0,"title":"段子451462798795005","js_type":0,"is_title":1,"is_spider":0,"ctime":1462798795000,"js_zan":0,"read_count":0,"note":"抓取过来的乱弄的标题"},{"js_id":2304,"jc_id":1,"content":"看了一新闻，一公交车特别拥挤，人上不去，司机就上去帮忙，用脚踹人往里塞，我就感叹，这年头公交车是真不能坐了，谁知店里一员工，听后双眼放光，流着口水，在那嘿嘿傻笑！痴痴的说：挤......挤......挤......公交.......","is_show":0,"title":"段子11462798820171","js_type":0,"is_title":1,"is_spider":0,"ctime":1462798820000,"js_zan":0,"read_count":0,"note":"抓取过来的乱弄的标题"},{"js_id":2560,"jc_id":1,"content":"闺蜜约我去看她小男友飙车，我说“飙车犯法，还是不去了吧”，闺蜜软磨硬泡 最终没忍住好奇 跟着闺蜜上车，闺蜜说到了，下车后 我咬牙切齿的 从牙缝里挤出八个字“你 特 么 的 逗我玩呢”霓虹大招牌上写着电玩城！！！","is_show":0,"title":"段子571462798847119","js_type":0,"is_title":1,"is_spider":0,"ctime":1462798847000,"js_zan":0,"read_count":0,"note":"抓取过来的乱弄的标题"},{"js_id":3072,"jc_id":1,"content":"15年前，被初恋给甩了，各种伤心，各种绝望，上火上到牙都掉了一颗。多年来，一直骗自己说已经放下了，其实，一直没有放下。就刚才，有一个看着有些面熟的胖女人迎面走过，竟然是她！时光真是把杀猪刀啊，我多年的心魔也被它给砍跑了。","is_show":0,"title":"段子691462798900707","js_type":0,"is_title":1,"is_spider":0,"ctime":1462798900000,"js_zan":0,"read_count":0,"note":"抓取过来的乱弄的标题"},{"js_id":4352,"jc_id":1,"content":"你是我的小贰畐 怒抢2楼 晴天也下雨， 什么jb玩意 孤独的小GG 傻逼审帖的 这都让过了 尼玛逼让狗日了 尿床的男子汉 寓言 阿拉是狗屁屁 还不如叫东京日 从此,节操是陌人 煞笔贴 *请叫我伟哥* 应该是精东插","is_show":0,"title":"段子491462799037046","js_type":0,"is_title":1,"is_spider":0,"ctime":1462799037000,"js_zan":0,"read_count":0,"note":"抓取过来的乱弄的标题"},{"js_id":4608,"jc_id":1,"content":"甩卖菊花 你真敢那么说鸡鸡短的性无能 楼下的楼上是SB 2l 你比lz还丑吧？ 风里来，余力去 2楼威武","is_show":0,"title":"段子51462799063293","js_type":0,"is_title":1,"is_spider":0,"ctime":1462799063000,"js_zan":0,"read_count":0,"note":"抓取过来的乱弄的标题"},{"js_id":4864,"jc_id":1,"content":"爸爸:小明你能指出来告诉我那个是燕子那个是喜鹊吗？ 小明:爸爸，我不能指出来但我能说出来。 爸爸:说说看。 小明:燕子旁边是喜鹊，喜鹊旁边是燕子。 爸爸:……","is_show":0,"title":"段子611462799090446","js_type":0,"is_title":1,"is_spider":0,"ctime":1462799090000,"js_zan":0,"read_count":0,"note":"抓取过来的乱弄的标题"},{"js_id":6144,"jc_id":1,"content":"一男子在树下睡觉，因鼾声太大像野猪被猎人射杀","is_show":0,"title":"段子411462799233823","js_type":0,"is_title":1,"is_spider":0,"ctime":1462799233000,"js_zan":0,"read_count":0,"note":"抓取过来的乱弄的标题"},{"js_id":6400,"jc_id":1,"content":"上大二的时候，晚上通宵打刀塔，第二天睡觉没去上课……听到有人进宿舍声很大，我很迷离的做起来对他吼了一句，你个代笔，滚……稍微看了下是班主任，当时我那个反应机智的不行不行的……接着就说了一句，别挤我，别挤我，倒头继续睡……他默默的关上们走了","is_show":0,"title":"段子971462799261599","js_type":0,"is_title":1,"is_spider":0,"ctime":1462799261000,"js_zan":0,"read_count":0,"note":"抓取过来的乱弄的标题"},{"js_id":6656,"jc_id":1,"content":"小明上厕所时，看见有许多蚂蚁，回来跟老师报告，老师想到蚂蚁这个单词刚刚教过，于是 便问他：“蚂蚁怎么说？”小明愣了愣，奇怪的看着老师，说：“蚂蚁什么","is_show":0,"title":"段子531462799288395","js_type":0,"is_title":1,"is_spider":0,"ctime":1462799288000,"js_zan":0,"read_count":0,"note":"抓取过来的乱弄的标题"},{"js_id":6912,"jc_id":1,"content":"吃薯片被呛着了，当时急死我了，一直咳，终于咳出来了，结果被面前的电风扇给吹回来了，薯片渣子一脸都是…… 够糗么 ？（第一次发，能过吗？）","is_show":0,"title":"段子91462799315343","js_type":0,"is_title":1,"is_spider":0,"ctime":1462799315000,"js_zan":0,"read_count":0,"note":"抓取过来的乱弄的标题"},{"js_id":8448,"jc_id":1,"content":"奶奶去世一个月了 父一辈请了好多道士给过五七 晚上同道士结完账 光工资5800 为头的道士忽然想起来什么 指着一个蛇皮袋说：这里的经文是帮你家老母亲来还上辈子欠的债 经文1800，你们看是要还 还是不还？父一辈的一阵凌乱！","is_show":0,"title":"段子451462799491253","js_type":0,"is_title":1,"is_spider":0,"ctime":1462799491000,"js_zan":0,"read_count":0,"note":"抓取过来的乱弄的标题"},{"js_id":8960,"jc_id":1,"content":"小王:“爸爸，你这一整天干啥去了，都不带着我。”老王:“我去给你造小弟弟去了。”小王:“可我喜欢小妹妹啊！”老王听后一愣，没想到儿子小小年纪就有如此抱负，于是欣慰的回道:“那就看你的命了。”","is_show":0,"title":"段子571462799546684","js_type":0,"is_title":1,"is_spider":0,"ctime":1462799546000,"js_zan":0,"read_count":0,"note":"抓取过来的乱弄的标题"},{"js_id":9216,"jc_id":1,"content":"他们是切瓷砖的工人，每天抵着噪音和大太阳工作，每天到十二点都来我家仓库休息一小时，一开始他们害羞不敢进来，我那天直接跟他们说，没事来我这里坐睡，吹空调，帮我增加人气，那些还在抱怨生活的，多像他们学习吧。","is_show":0,"title":"段子131462799576083","js_type":0,"is_title":1,"is_spider":0,"ctime":1462799576000,"js_zan":0,"read_count":0,"note":"抓取过来的乱弄的标题"},{"js_id":9472,"jc_id":1,"content":"军需处长找到司令员：报告！士兵们说现在是冬天了！应该发被子了！　　司令员大怒：难道你不知道我们的后勤路线被敌人切断了吗？　　军需处长说道：士兵们说，如果没有被子，就发个姑娘给他们！　　司令员考虑了一下：恩，这个兵荒马乱时代，哪找的那么多姑娘？　　军需处长又说道：士兵们说，一个士兵宿舍发一个姑娘就行！　　司令员考虑了好久才说道：我记得你老婆今天来看你还没走是吧？","is_show":0,"title":"段子691462799604284","js_type":0,"is_title":1,"is_spider":0,"ctime":1462799604000,"js_zan":0,"read_count":0,"note":"抓取过来的乱弄的标题"}],"errorcode":"","errorno":"0"}
     * </pre>
     */
    @Test
    public void jokesegment_list() throws Exception {
        MultiValueMap<String, String> params = getParams();
        long jc_id = 1;
        int type = 0;
        params.add("jc_id",jc_id+"");
        params.add("type",type+"");
        sign(params, "dtype","jc_id");

        MvcResult mvcResult = mockMvc.perform(post("/v1/jokesegment_list").params(params))
                .andExpect(status().isOk()).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.err.println(result);
        String path = this.getClass().getResource(".").getPath();
        path = path + "Joke.md";
        InterfaceUtil.AddInterfacePred(path, moduleName,
                "获取笑话分类列表",
                "dtype+ui_id",
                "/v1/jokesegment_list",
                2,
                params,
                Param_jokeClass.class,
                result);
    }

}
