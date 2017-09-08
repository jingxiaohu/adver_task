
package com.pyb.mvc.service;

import com.pyb.bean.Day_news;
import org.apache.commons.codec.digest.DigestUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;

/**
 * spider
* @ClassName: SpiderBiz
* @Description: TODO(这里用一句话描述这个类的作用)
* @author 敬小虎
* @date 2015年3月10日 下午2:40:33
*
 */
@Service
public class SpiderNewsBiz extends BaseBiz{

	public void spiderNews_zz(){
		//所属板块类型(例如：个股评级) 0:看盘消息 1：个股评级  2：机构解析  3：板块解析  4：市场研究 5：行业研究  6：数据资金
		//个股评级
		spiderNews_zz_spider(1,"http://www.cs.com.cn/gppd/tzpj/","个股评级");
		//市场研究
//		spiderNews_zz_spider(4,"http://www.cs.com.cn/gppd/scyj/","市场研究");
		//行业研究
		spiderNews_zz_spider(5,"http://www.cs.com.cn/gppd/hyyj/","行业研究");
		//数据资金
		spiderNews_zz_spider(4,"http://www.cs.com.cn/gppd/sjjj/","数据资金");
		//看盘消息
		spiderNews_zz_spider(0,"http://www.cs.com.cn/ssgs/hyzx/","行业");
	}
	/**
	 * 中国证券报·中证网
	 */
	public void spiderNews_zz_spider(int type,String zz_baseurl,String name){
		try {
			// 从 URL 直接加载 HTML 文档
	        Document doc = Jsoup.connect(zz_baseurl).get();
	        Elements links = doc.select("li a:eq(1)[href*=.html]");
	        System.out.println(links.size()+"条");
	        for (Iterator<?> iterator = links.iterator(); iterator.hasNext();) {
				Element element = (Element) iterator.next();
				 System.out.println(element.text());
				 System.out.println(element.attr("href"));
				 //标题
				 String title = element.text();
				 //URL地址
				 String url_str =zz_baseurl+ element.attr("href");
				 //MD5
				 String md5 = DigestUtils.md5Hex(title+url_str);

				 Day_news day_news =  findDay_news( md5);
				 if(day_news == null){
					 day_news = new Day_news();
					 day_news.setBk_type(1);//类型（0：自己写的内容 1:页面
					 day_news.setContent_or_url(url_str);
					 day_news.setCtime(new Date());
					 day_news.setSource_name("中国证券报·中证网");
					 day_news.setMd5(md5);
					 day_news.setTitle(title);
					 day_news.setType(type);
					 day_news.setNote(name);
					 daoFactory.getDay_newsDao().insert(day_news);
				 }
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("SpiderNewsBiz.spiderNews_zz_spider is error", e);
		}
	}









	/**
	 * http://finance.eastmoney.com/yaowen.html
	 * 东方财富--要闻
	 */
	public void spiderNews_dfcf(){
		try {
			//备用地址
			String zz_baseurl = "http://finance.eastmoney.com/yaowen.html";
//			String zz_baseurl = "http://finance.eastmoney.com/yaowen_czqyw.html";
			 // 从 URL 直接加载 HTML 文档
	        Document doc = Jsoup.connect(zz_baseurl).get();
	        /**
	         * Elements links = doc.select("a[href]"); //带有href属性的a元素
				Elements pngs = doc.select("img[src$=.png]");
				  //扩展名为.png的图片
				Element masthead = doc.select("div.masthead").first();
				  //class等于masthead的div标签
				Elements resultLinks = doc.select("h3.r > a"); //在h3元素之后的a元素
	         */
	        Elements links = doc.select("a[href*=finance.eastmoney.com/news]");
	        System.out.println(links.size()+"条");
	        for (Iterator<?> iterator = links.iterator(); iterator.hasNext();) {
				Element element = (Element) iterator.next();
				 System.out.println(element.text());
				 //http://finance.eastmoney.com/news/czsdc.html  要除开
				 System.out.println(element.attr("href"));
				 //标题
				 String title = element.text();
				 //URL地址
				 String url_str =element.attr("href");
				 if(url_str.indexOf("czsdc.html") != -1){
					 continue;
				 }
				 //MD5
				 String md5 = DigestUtils.md5Hex(title+url_str);
				 Day_news day_news =  findDay_news( md5);
				 if(day_news == null){
					 day_news = new Day_news();
					 day_news.setBk_type(1);//类型（0：自己写的内容 1:页面
					 day_news.setContent_or_url(url_str);
					 day_news.setCtime(new Date());
					 day_news.setSource_name("东方财富网");
					 day_news.setMd5(md5);
					 day_news.setTitle(title);
					 day_news.setType(0);
					 day_news.setNote("要闻");
					 daoFactory.getDay_newsDao().insert(day_news);
				 }

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("SpiderNewsBiz.spiderNews_dfcf is error", e);
		}
	}
	public void spider(){
		//中国证券网
		//spiderNews_zz();
		//东方财富网
		spiderNews_dfcf();
	}

	/**
	 * 查找是否有重复的
	 * @param md5
	 * @return
	 */
	public Day_news findDay_news(String md5){
		try {
			String sql = "select * from day_news where md5=? limit 1";
			return getMySelfService().queryUniqueT(sql, Day_news.class, md5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("findDay_news is error", e);
		}
		return null;
	}
	/********************笑话段子抓取****************************/
public static void main(String[] args) {
		new SpiderNewsBiz().spiderNews_dfcf();
}

}
