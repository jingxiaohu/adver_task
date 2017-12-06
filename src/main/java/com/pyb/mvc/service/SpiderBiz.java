
package com.pyb.mvc.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pyb.bean.Joke_segment;
import com.pyb.bean.Live_info;
import com.pyb.bean.Stock_hand;
import com.pyb.util.RequestUtil;
import com.pyb.util.SpiderJokeUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * spider
* @ClassName: SpiderBiz
* @Description: TODO(这里用一句话描述这个类的作用)
* @author 敬小虎
* @date 2015年3月10日 下午2:40:33
*
 */
@Service
public class SpiderBiz extends BaseBiz{
	//备用地址
	protected String url_ajax = "http://api.wallstreetcn.com/v2/livenews/realtime?limit=3&callback=jQuery21306829673898680092_1458012957042&min_updated=1458013182&_=1458012957110";
	protected String url_app = "http://api.wallstreetcn.com/v2/livenews/realtime?limit=3";
	private long ui_id= 1;//
	/**
	 * spider api.wallstreetcn.com
	 * {
    "paginator": null,
    "results": [
        {
            "id": "320702",
            "status": "published",
            "title": "日本央行：日本央行委员会以7:2的投票结果维持负利率不变。日本央行委员会以8:1的投票结果维持货币基础年增幅目标不变。将对货币储备基金免于实施负利率。需要关注物价趋势风险。如有必要，将会进一步宽松政策...",
            "type": "news",
            "codeType": "markdown",
            "importance": "2",
            "createdAt": 1458013025,
            "updatedAt": 1458013555,
            "imageCount": "0",
            "image": "",
            "videoCount": "0",
            "video": null,
            "viewCount": "0",
            "shareCount": "0",
            "commentCount": "0",
            "commentStatus": "open",
            "contentHtml": "<p>日本央行：日本央行委员会以7:2的投票结果维持负利率不变。</p><p>日本央行委员会以8:1的投票结果维持货币基础年增幅目标不变。</p><p><strong>将对货币储备基金免于实施负利率。</strong></p><p>需要关注物价趋势风险。</p><p>如有必要，将会进一步宽松政策。</p><p>全球金融市场依旧不稳定。</p><p>日本经济已在继续温和复苏。</p><p>通胀预期近来减弱。</p><p>近来出口增长陷于停滞。</p><p>将对货币储备基金免于实施负利率，信托银行的MRFs规模计算入宏观加算余额部分。</p><p>木内登英委员称，负利率有损日本国债市场的稳定性。</p><p>从4月份起，ETFs年度购买规模按计划增加至3.3万亿日元。</p>",
            "data": null,
            "sourceName": "",
            "sourceUrl": "",
            "userId": "860514",
            "categorySet": "12,5",
            "hasMore": 0,
            "detailPost": null,
            "channelSet": "1",
            "text": {
                "contentExtra": "",
                "contentFollowup": "",
                "contentAnalysis": ""
            }
        },
	 */
	public void spiderChannel_1(){
		try {
			log.info("spiderChannel_1 spider is start..............");
			long ci_id= 1;//渠道ID
			long time = 0;
			String sql = "select *  from live_info where ci_id=? order by uptime desc  limit 1 ";
			Live_info live_info = getDB().queryUniqueT(sql, Live_info.class,ci_id);
			if(live_info == null){
				time = System.currentTimeMillis()/1000-3000;
			}else{
				if(!RequestUtil.checkObjectBlank(live_info.getNote())){
					time  = Long.parseLong(live_info.getNote());
				}else{
					time = System.currentTimeMillis()/1000-3000;
				}
			}
			String url = url_app+"&min_updated="+time;
			String str = doGet(url, null, null);
			if(ERROR_RESP.equalsIgnoreCase(str)){
				return;
			}
			JSONObject obj = JSONObject.parseObject(str);
			JSONArray array = obj.getJSONArray("results");
			if(array == null){
				return;
			}
			if(array.size() > 0){
				for (int i = 0; i < array.size(); i++) {
					JSONObject ct = array.getJSONObject(i);
					String title = ct.getString("contentHtml");
					String content = ct.getString("contentHtml");
					String updatedAt = ct.getString("updatedAt");
					int length = content.length();
					String md5_str = "";
					if(length >0 && length <= 20){
						md5_str = content.substring(0, 10);
					}else{
						md5_str = content.substring(0, 20);
					}

					String md5 = DigestUtils.md5Hex(md5_str);
					sql = "select *  from live_info where ci_id=? and title_md5=?  limit 1";
					live_info = getDB().queryUniqueT(sql, Live_info.class,ci_id,md5);
					if(live_info == null){
						title = title.replace("<p>", "").replace("</p>", "");
						content = content.replace("<p>", "").replace("</p>", "");
						Date date = new Date();
						live_info = new Live_info();
						live_info.setCi_id(ci_id);
						live_info.setMi_content(content);
						live_info.setMi_createtime(date);
						live_info.setMi_area(1);
						live_info.setMi_day(sf_yyyy_mm_dd.format(date));
						live_info.setMi_flag(0);
						live_info.setMi_title(title);
						live_info.setUptime(updatedAt);
						live_info.setUi_id(ui_id);
						live_info.setTitle_md5(md5);
						try {
							log.info("spiderChannel_1 spider insert is do..............");
							daoFactory.getLive_infoDao().insert(live_info);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							log.error("spider daoFactory.getLive_infoDao().insert is error", e);
						}
					}
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("SpiderBiz.spiderChannel_1 is error", e);
		}
	}



	/********************笑话段子抓取****************************/
	public static void main(String[] args) {
		new SpiderBiz().spiderJoke();
	}
	public void spiderJoke(){
		try {
			for (int j = 0; j < 500; j++) {
				String url = "http://api.1-blog.com/biz/bizserver/xiaohua/list.do?page="+j+"&size=100";
				String str = doGet(url, null, null);
				if(ERROR_RESP.equalsIgnoreCase(str)){
					return;
				}
				JSONObject obj = JSONObject.parseObject(str);
				JSONArray array = obj.getJSONArray("detail");
				if(array == null){
					return;
				}
				if(array.size() > 0){
					for (int i = 0; i < array.size(); i++) {
						JSONObject ct = array.getJSONObject(i);
						String title = "段子"+i+""+System.currentTimeMillis();
						String content = ct.getString("content");
						String sql = "select *  from joke_segment where title=? limit 1 ";
						Joke_segment joke_segment = getDB().queryUniqueT(sql, Joke_segment.class,title);
						if(joke_segment == null){
							Date date = new Date();
							joke_segment = new Joke_segment();
							joke_segment.setTitle(title);
							joke_segment.setContent(content);
							joke_segment.setCtime(date);
							joke_segment.setIs_show(0);//是否显示(0:显示 1：不显示)
							joke_segment.setIs_spider(0);//是否是抓取的段子(0:抓取 1：自己添加)
							joke_segment.setIs_title(1);//是否有标题(0:没有 1：有)
							joke_segment.setJc_id(1);//爆笑男女
							joke_segment.setNote("抓取过来的乱弄的标题");
							try {
								daoFactory.getJoke_segmentDao().insert(joke_segment);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								log.error("spider daoFactory.getJoke_segmentDao().insert is error", e);
							}
						}
					}
				}
			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("SpiderBiz.spiderJoke is error", e);
		}
	}

	/**
	 * 冷笑话抓取
	 */
	public void doSpiderJokeClass(){
		//19099
		List<Joke_segment> list = SpiderJokeUtil.do_pengfu_joke_xiaoyuan(1,3000);
		if(list != null && list.size()>0){
			for (Joke_segment joke_segment : list) {
				spiderJokeInsert2(joke_segment);
			}
		}

		list = SpiderJokeUtil.do_pengfu_joke_xiaoyuan(3001,8000);
		if(list != null && list.size()>0){
			for (Joke_segment joke_segment : list) {
				spiderJokeInsert2(joke_segment);
			}
		}



		list = SpiderJokeUtil.do_pengfu_joke_xiaoyuan(8001,13000);
		if(list != null && list.size()>0){
			for (Joke_segment joke_segment : list) {
				spiderJokeInsert2(joke_segment);
			}
		}



		list = SpiderJokeUtil.do_pengfu_joke_xiaoyuan(13001,19099);
		if(list != null && list.size()>0){
			for (Joke_segment joke_segment : list) {
				spiderJokeInsert2(joke_segment);
			}
		}

	}
	/********分离出来的方法***********/
	public void spiderJokeInsert(String title,String content,String note,long jc_id){
		try {
						String sql = "select *  from joke_segment where title=? limit 1 ";
						Joke_segment joke_segment = getDB().queryUniqueT(sql, Joke_segment.class,title);
						if(joke_segment == null){
							Date date = new Date();
							joke_segment = new Joke_segment();
							joke_segment.setTitle(title);
							joke_segment.setContent(content);
							joke_segment.setCtime(date);
							joke_segment.setIs_show(0);//是否显示(0:显示 1：不显示)
							joke_segment.setIs_spider(0);//是否是抓取的段子(0:抓取 1：自己添加)
							joke_segment.setIs_title(1);//是否有标题(0:没有 1：有)
							joke_segment.setJc_id(jc_id);
							joke_segment.setNote(note);
							try {
								daoFactory.getJoke_segmentDao().insert(joke_segment);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								log.error("spider daoFactory.getJoke_segmentDao().spiderJokeInsert is error", e);
							}
						}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("SpiderBiz.spiderJoke is error", e);
		}
	}
	public void spiderJokeInsert2(Joke_segment joke_segment){
		try {
						String sql = "select *  from joke_segment where title=? limit 1 ";
						Joke_segment joke_segment2 = getDB().queryUniqueT(sql, Joke_segment.class,joke_segment.getTitle());
						if(joke_segment2 == null){
							try {
								int indexid = daoFactory.getJoke_segmentDao().insert(joke_segment);
								if(indexid > 0){
//									System.out.println("indexid===="+indexid);
								}
							} catch (Exception e) {
								// TODO Auto-generated catch block
								log.error("spider daoFactory.getJoke_segmentDao().spiderJokeInsert2 is error", e);
							}
						}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("SpiderBiz.spiderJoke is error", e);
		}
	}

 /**
  * 获取limiji
  * var vLATEST={t:'latest',d:'09001515',data:'13:57:54~sz300431~暴风科技~61.99~大卖单~847^13:57:39~sz300247~乐金健康~8.12~封涨停板~48714^13:57:39~sz300247~乐金健康~8.12~封涨停板~28062^13:57:36~sz300247~乐金健康~8.12~大买单~9690^13:57:36~sz300247~乐金健康~8.12~快速上涨~3.44^13:57:17~sz002070~众和股份~26.57~大单成交~1994^13:56:57~sz002673~西部证券~22.42~大卖单~2237^13:56:57~sz002176~江特电机~13.60~大卖单~5307^13:56:56~sz002176~江特电机~13.60~大卖单~5307^13:56:54~sz300288~朗玛信息~35.22~大卖单~2002^'};
  */
 public  void spiderChannel_3(){
	 try {
		 if(isUpgrade()){
			 return;
		 }

		 long ci_id= 3;//渠道ID  实时大单
		 String url = "http://stock.gtimg.cn/data/index.php?appn=radar&t=latest&v=vLATEST";
		 String str = doGet(url, null, null);
		 str = new String(str.getBytes("ISO-8859-1"),"GBK");
		 str = str.substring(str.indexOf("{"),str.lastIndexOf("}")+1);
		 if(ERROR_RESP.equalsIgnoreCase(str)){
			return;
		 }
		 JSONObject sf = JSONObject.parseObject(str);
		 String data = sf.getString("data");
		 //时间 代码  名称 价格  异动 类型 手数
		 String[] dd = data.replace("^", "@").split("@");
		 if(dd != null){
			 Date date = new Date();
			 for (int i = 0; i < dd.length; i++) {
				 String title = dd[i];
			     String content = dd[i].replace("~", " ");
			     String md5 = DigestUtils.md5Hex(title);
//				System.out.println(dd[i]);
				try {

					String[] mm  = dd[i].split("~");
					if(mm != null && mm.length > 0){
						String code = mm[1].replace("sz", "").replace("sh", "");
						String sql = "select *  from stock_hand where s_code=? and md5_str=?  limit 1";
						Stock_hand stock_hand = getDB().queryUniqueT(sql, Stock_hand.class,code,md5);
						if(stock_hand == null){
							stock_hand = new Stock_hand();
							stock_hand.setS_time(mm[0]);
							stock_hand.setS_code(code);
							stock_hand.setS_name(mm[2]);
							stock_hand.setS_price(mm[3]);
							if(mm[4].indexOf("买") != -1){
								stock_hand.setS_type("buy");
							}else{
								stock_hand.setS_type("sell");
							}
							stock_hand.setS_hand(Integer.parseInt(mm[5]));
							stock_hand.setCtime(date);
							stock_hand.setMd5_str(md5);
							stock_hand.setNote("");
							daoFactory.getStock_handDao().insert(stock_hand);
						}

					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					log.error("SpiderBiz.spiderChannel_3 Stock_hand is error", e);
				}

				String updatedAt = dd[i].substring(0,dd[i].indexOf("~"));
				String sql = "select *  from live_info where ci_id=? and title_md5=?  limit 1";
				Live_info live_info = getDB().queryUniqueT(sql, Live_info.class,ci_id,md5);
				if(live_info == null){
					live_info = new Live_info();
					live_info.setCi_id(ci_id);
					live_info.setMi_content(content);
					live_info.setMi_createtime(date);
					live_info.setMi_area(1);
					live_info.setMi_day(sf_yyyy_mm_dd.format(date));
					live_info.setMi_flag(0);
					live_info.setMi_title(title);
					live_info.setUptime(updatedAt);
					live_info.setUi_id(ui_id);
					live_info.setTitle_md5(md5);
					try {
						daoFactory.getLive_infoDao().insert(live_info);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						log.error("SpiderBiz.spiderChannel_3 live_info is error", e);
					}
			}

		   }
		 }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

 }


 /**
	 * 如果晚上15点---第二天的早上9点30  这之间不进行版本升级
	 * @return
	 */
	private boolean isUpgrade() {
		// TODO Auto-generated method stub
		Date date = new Date();

		Calendar cl = Calendar.getInstance(Locale.CHINESE);
		int year = cl.get(Calendar.YEAR);     //获取年份
		int month = cl.get(Calendar.MONTH);     //获取月份
		int day = cl.get(Calendar.DATE);     //获取日期
		cl.set(year, month, day, 15, 0,0);
//		System.out.println(sf.format(cl.getTime()));


		Calendar cl2 = Calendar.getInstance(Locale.CHINESE);
		int year2 = cl2.get(Calendar.YEAR);     //获取年份
		int month2 = cl2.get(Calendar.MONTH);     //获取月份
		int day2 = cl2.get(Calendar.DATE);     //获取日期
		cl2.set(year2, month2, day2, 9, 30,0);
//		System.out.println(sf.format(cl2.getTime()));

		long timenn = date.getTime();
		if(timenn >= cl.getTime().getTime() || timenn <= cl2.getTime().getTime()){
			return true;
		}

		return false;
	}


	/****
	 * 抓取东方财富
	 */
   public String returnDFCF(String url){
	   try {
		String str = doGet(url, null, null);
		if(StringUtils.isNotEmpty(str)){
			   return str;
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		log.error("returnDFCF(String url) is error url="+url,e);
	}
	   return null;
   }


   /**
    * 获取复盘时间
    */
   public void spiderChannel_5(){
	   try {
		long ci_id=5;
		   String time_str = sf_yyyy_mm_dd.format(new Date());
		   String url = "http://datainterface.eastmoney.com/EM_DataCenter/JS.aspx?type=FD&sty=SRB&st=0&sr=1&mkt=1&fd="+time_str+"&p=1&ps=10";
		   String str =  returnDFCF(url);
		   if(str != null){
			   if(str != null){
				   str = str.replace("([", "").replace("])", "");
				   String[] arry = str.split("\",\"");

				   for (int i = 0; i < arry.length; i++) {
					   str = arry[i].replace("\"", "");
					   if(str.endsWith(",")){
						   str = str.substring(0,str.lastIndexOf(","));
					   }
					   String item[] = str.split(",");
					   /*if(item.length < 9){
						   str = item[1]+" "+item[0]+" 停牌时间:"+item[2]+" 预计复牌时间:暂无"+" 停牌原因:"+item[5];
					   }else{
						   str = item[1]+" "+item[0]+" 停牌时间:"+item[2]+" 预计复牌时间:"+item[item.length-1]+" 停牌原因:"+item[5];
					   }*/
					   if(item.length == 9 ){
						   str = item[1]+" "+item[0]+" 停牌时间:"+item[2]+" 预计复牌时间:"+item[item.length-1]+" 停牌原因:"+item[5];
						    String title = "停复牌提示-"+item[1];
							String content = str;
							String updatedAt = "";
							String md5 = DigestUtils.md5Hex(content);
							String sql = "select *  from live_info where ci_id=? and title_md5=?  limit 1";
							Live_info live_info = getDB().queryUniqueT(sql, Live_info.class,ci_id,md5);
							if(live_info == null){
								Date date = new Date();
								live_info = new Live_info();
								live_info.setCi_id(ci_id);
								live_info.setMi_content(content);
								live_info.setMi_createtime(date);
								live_info.setMi_area(1);
								live_info.setMi_day(sf_yyyy_mm_dd.format(date));
								live_info.setMi_flag(0);
								live_info.setMi_title(title);
								live_info.setUptime(updatedAt);
								live_info.setUi_id(ui_id);
								live_info.setTitle_md5(md5);
								try {
									daoFactory.getLive_infoDao().insert(live_info);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									log.error("spider daoFactory.getLive_infoDao().insert is error", e);
								}
							}
					   }


				   }
			   }

		   }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		log.error("spiderChannel_5(String url) is error ",e);
	}
   }

   /**
    * 预案分配
    */
   public void spiderChannel_6(){
	   try {
		long ci_id=6;
		   String time_str = sf_yyyy_mm_dd.format(new Date());
		   String url = "http://datainterface.eastmoney.com/EM_DataCenter/JS.aspx?type=GSRL&sty=GSRL&stat=13&fd="+time_str+"&sr=2&p=1&ps=50";
		   String str =  returnDFCF(url);
		   if(str != null){
			   if(str != null){
				   str = str.replace("(", "").replace(")", "");
				   JSONObject ooj = new JSONObject();
				   ooj.put("data", str);
				   JSONArray array = ooj.getJSONArray("data");

				   for (int i = 0; i < array.size(); i++) {
					   JSONObject obj = array.getJSONObject(i);
					   //董事会预案公告日期
					   String DIRECTORSDATE = obj.getString("DIRECTORSDATE");
					   //股东决议公告日
					   String HOLDERSDECISIONDATE = obj.getString("HOLDERSDECISIONDATE");
					   //增发获批公告日
					   String HOLDERSAPROVEDDATE = obj.getString("HOLDERSAPROVEDDATE");
					   //发行规模(股)
					   String SHAREISSUE = obj.getString("SHAREISSUE");
					   //预计募集资金(元)
					   String SUMFINA = obj.getString("SUMFINA");
					   //预计增发价
					   String PRICINGMETHOD = obj.getString("PRICINGMETHOD");
					   //最新价NEW
					   String NEW = obj.getString("NEW");
					   //简称
					   String SECURITYSHORTNAME = obj.getString("SECURITYSHORTNAME");
					   //代码
					   String SECUCODE = obj.getString("SECUCODE");
					   str = SECURITYSHORTNAME+" "+SECUCODE+" 最新价:"+NEW+" 发行规模(股):"+SHAREISSUE+" 预计募集资金(元):"+SUMFINA+" 董事会预案公告日期:"+DIRECTORSDATE+
						" 股东决议公告日:"+HOLDERSDECISIONDATE+" 增发获批公告日:"+HOLDERSAPROVEDDATE+	" @预计增发价:"+PRICINGMETHOD;
						    String title = "预案分配-"+SECURITYSHORTNAME;
							String content = str;
							String updatedAt = "";
							String md5 = DigestUtils.md5Hex(content);
							String sql = "select *  from live_info where ci_id=? and title_md5=?  limit 1";
							Live_info live_info = getDB().queryUniqueT(sql, Live_info.class,ci_id,md5);
							if(live_info == null){
								Date date = new Date();
								live_info = new Live_info();
								live_info.setCi_id(ci_id);
								live_info.setMi_content(content);
								live_info.setMi_createtime(date);
								live_info.setMi_area(1);
								live_info.setMi_day(sf_yyyy_mm_dd.format(date));
								live_info.setMi_flag(0);
								live_info.setMi_title(title);
								live_info.setUptime(updatedAt);
								live_info.setUi_id(ui_id);
								live_info.setTitle_md5(md5);
								try {
									daoFactory.getLive_infoDao().insert(live_info);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									log.error("spider daoFactory.getLive_infoDao().insert is error", e);
								}
							}


				   }
			   }

		   }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		log.error("spiderChannel_6(String url) is error ",e);
	}
   }

   /**
    * 分红转赠
    * {
    "DATE": "2016-05-25",
    "SECURITYSHORTNAME": "新朋股份",
    "CONTENT": "10派0.45元(含税,扣税后0.405元)",
    "TYPE": "分红转增红利发放日",
    "SECUCODE": "002328.SZ"
}
    */
   public void spiderChannel_7(){
	   try {
		long ci_id=7;
		   String time_str = sf_yyyy_mm_dd.format(new Date());
		   String url = "http://datainterface.eastmoney.com/EM_DataCenter/JS.aspx?type=GSRL&sty=GSRL&stat=8&fd="+time_str+"&p=1&ps=1000";
		   String str =  returnDFCF(url);
		   if(str != null){
			   if(str != null){
				   str = str.replace("(", "").replace(")", "");
				   JSONObject ooj = new JSONObject();
				   ooj.put("data", str);
				   JSONArray array = ooj.getJSONArray("data");

				   for (int i = 0; i < array.size(); i++) {
					   JSONObject obj = array.getJSONObject(i);
					   //日期
					   String DATE = obj.getString("DATE");
					   //事件内容
					   String CONTENT = obj.getString("CONTENT");
					   //事件类型
					   String TYPE = obj.getString("TYPE");
					   //简称
					   String SECURITYSHORTNAME = obj.getString("SECURITYSHORTNAME");
					   //代码
					   String SECUCODE = obj.getString("SECUCODE");
					   str = DATE+" "+SECURITYSHORTNAME+" "+SECUCODE+" 事件类型:"+TYPE+" 事件内容:"+CONTENT;
						    String title = "增发配股-"+SECURITYSHORTNAME;
							String content = str;
							String updatedAt = "";
							String md5 = DigestUtils.md5Hex(content);
							String sql = "select *  from live_info where ci_id=? and title_md5=?  limit 1";
							Live_info live_info = getDB().queryUniqueT(sql, Live_info.class,ci_id,md5);
							if(live_info == null){
								Date date = new Date();
								live_info = new Live_info();
								live_info.setCi_id(ci_id);
								live_info.setMi_content(content);
								live_info.setMi_createtime(date);
								live_info.setMi_area(1);
								live_info.setMi_day(sf_yyyy_mm_dd.format(date));
								live_info.setMi_flag(0);
								live_info.setMi_title(title);
								live_info.setUptime(updatedAt);
								live_info.setUi_id(ui_id);
								live_info.setTitle_md5(md5);
								try {
									daoFactory.getLive_infoDao().insert(live_info);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									log.error("spider daoFactory.getLive_infoDao().insert is error", e);
								}
							}


				   }
			   }

		   }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		log.error("spiderChannel_7(String url) is error ",e);
	}
   }

   /**
    * http://datainterface.eastmoney.com/EM_DataCenter/JS.aspx?type=GSRL&sty=GSRL&stat=20&fd=2016-06-07&sr=2&p=1&ps=50
    *     {
        "SECUCODE": "000018.SZ",
        "EXDIVIDENDDATE": "2016-06-07",
        "EXECUTECONTENT": "10转28.00",
        "PROGRESS": "实施分配",
        "LEADERSPUBLISHCONTENT": "",
        "DIVIPAYDATE": "",
        "SECURITYSHORTNAME": "神州长城",
        "HOLDERSPUBLISHCONTENT": "10转28.00",
        "HOLDERSPUBLISHDATE": "2016-04-15",
        "PAYYEAR": "2015-12-31",
        "EXECUTEDATE": "2016-06-01",
        "LEADERSPUBLISHDATE": "",
        "RIGHTREGDATE": "2016-06-06"
    },
    */
   public void spiderChannel_9(){
	   try {
		long ci_id=9;
		   String time_str = sf_yyyy_mm_dd.format(new Date());
		   String url = "http://datainterface.eastmoney.com/EM_DataCenter/JS.aspx?type=GSRL&sty=GSRL&stat=20&fd="+time_str+"&sr=2&p=1&ps=1000";
		   String str =  returnDFCF(url);
		   if(str != null){
			   if(str != null){
				   str = str.replace("(", "").replace(")", "");
				   JSONObject ooj = new JSONObject();
				   ooj.put("data", str);
				   JSONArray array = ooj.getJSONArray("data");

				   for (int i = 0; i < array.size(); i++) {
					   JSONObject obj = array.getJSONObject(i);
					   //实施方案 公告日期
					   String EXECUTEDATE = obj.getString("EXECUTEDATE");
					   //股东大会预 案公告日期
					   String HOLDERSPUBLISHDATE = obj.getString("HOLDERSPUBLISHDATE");
					   //股权登记日
					   String RIGHTREGDATE = obj.getString("RIGHTREGDATE");
					   //除权除息日
					   String EXDIVIDENDDATE = obj.getString("EXDIVIDENDDATE");
					   //派息转股日
					   String DIVIPAYDATE = obj.getString("DIVIPAYDATE");
					   //事件内容
					   String EXECUTECONTENT = obj.getString("EXECUTECONTENT");
					   //事件类型
					   String PROGRESS = obj.getString("PROGRESS");
					   //简称
					   String SECURITYSHORTNAME = obj.getString("SECURITYSHORTNAME");
					   //代码
					   String SECUCODE = obj.getString("SECUCODE");
					   str = SECURITYSHORTNAME+" "+SECUCODE+" "+PROGRESS+" "+EXECUTECONTENT+" 股东大会预案公告日期:"+HOLDERSPUBLISHDATE
							   +"  实施方案公告日期:"+EXECUTEDATE+" 股权登记日:"+RIGHTREGDATE+" 除权除息日:"+EXDIVIDENDDATE+" 派息转股日:"+DIVIPAYDATE;
						    String title = "分红转赠-"+SECURITYSHORTNAME;
							String content = str;
							String updatedAt = "";
							String md5 = DigestUtils.md5Hex(content);
							String sql = "select *  from live_info where ci_id=? and title_md5=?  limit 1";
							Live_info live_info = getDB().queryUniqueT(sql, Live_info.class,ci_id,md5);
							if(live_info == null){
								Date date = new Date();
								live_info = new Live_info();
								live_info.setCi_id(ci_id);
								live_info.setMi_content(content);
								live_info.setMi_createtime(date);
								live_info.setMi_area(1);
								live_info.setMi_day(sf_yyyy_mm_dd.format(date));
								live_info.setMi_flag(0);
								live_info.setMi_title(title);
								live_info.setUptime(updatedAt);
								live_info.setUi_id(ui_id);
								live_info.setTitle_md5(md5);
								try {
									daoFactory.getLive_infoDao().insert(live_info);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									log.error("spider daoFactory.getLive_infoDao().insert is error", e);
								}
							}


				   }
			   }

		   }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		log.error("spiderChannel_9(String url) is error ",e);
	}
   }
}
