package com.pyb.util;

import com.pyb.bean.Joke_segment;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 抓取冷笑话
 * @author jingxiaohu
 *
 */
public class SpiderJokeUtil {
	static Logger log = Logger.getLogger(SpiderJokeUtil.class);
	
	/*******抓取冷笑话******http://www.3jy.com/tag/6/2.html**/
	public static List<Joke_segment> do_3jy_joke(){
		List<Joke_segment> list = new ArrayList<Joke_segment>();
		try {
			//冷笑话
			for (int i = 1; i < 384; i++) {
				String url = "http://www.3jy.com/tag/6/"+i+".html";
				Document doc = Jsoup.connect(url).timeout(60000).get();
//				System.out.println(doc.toString());
				Elements elements = doc.body().select("div[class=listbox]");
				for (Element element : elements) {
					 Elements titles = element.select(".sc");
					 String str = titles.get(0).toString();
					 String reg = "[^\u4e00-\u9fa5]";
				     Pattern pat = Pattern.compile(reg);  
				     Matcher mat=pat.matcher(str); 
				     String title = mat.replaceAll("");
				     
				     Elements contents = element.select("p");
				     StringBuffer content = new StringBuffer();
				     for (Element e_content : contents) {
				    	 content.append(e_content.text()).append("\n\r");
					}
				    System.out.println(content.toString());
				     Date date = new Date();
				     Joke_segment joke_segment = new Joke_segment();
					 joke_segment.setTitle(title);
					joke_segment.setContent(content.toString());
					joke_segment.setCtime(date);
					joke_segment.setIs_show(0);//是否显示(0:显示 1：不显示)
					joke_segment.setIs_spider(0);//是否是抓取的段子(0:抓取 1：自己添加)
					joke_segment.setIs_title(1);//是否有标题(0:没有 1：有)
					joke_segment.setJc_id(2);
					joke_segment.setNote("冷笑话-抓取");
					list.add(joke_segment);
					System.out.println("--------------------------");
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			log.error("SpiderBiz.do_3jy_joke is error", e);
		}
		return list;
	}

	
	
	/*******抓取内涵笑话******http://www.3jy.com/tag/8/2.html**/
	public static List<Joke_segment> do_3jy_joke_xiaoyuan(){
		List<Joke_segment> list = new ArrayList<Joke_segment>();
		try {
			//冷笑话
			for (int i = 1; i < 751; i++) {
				String url = null;
				if(i==1){
					 url = "http://www.3jy.com/tag/8/";
				}else{
					 url = "http://www.3jy.com/tag/8/"+i+".html";
				}
				
				Document doc = Jsoup.connect(url).timeout(60000).get();
//				System.out.println(doc.toString());
				Elements elements = doc.body().select("div[class=listbox]");
				for (Element element : elements) {
					 try {
						Elements titles = element.select(".sc");
						 String str = titles.get(0).toString();
						 String reg = "[^\u4e00-\u9fa5]";
						 Pattern pat = Pattern.compile(reg);  
						 Matcher mat=pat.matcher(str); 
						 String title = mat.replaceAll("");
						  /**
						   * <div class="main_text"> 
   <a href="http://m.3jy.com/youmo/39/347639.html"> 高三毕业晚会上，男的西装异服，女的低胸露背。<p></p>班主任批评道：“你们这些女生，现在急着脱去校服装成熟，以后你们就都想穿回校服扮嫩。”<p></p>以后是这样吗？<p></p> </a> 
  </div>
						   */
						 Elements contents = element.select(".main_text");
						 url = contents.get(0).getElementsByTag("a").attr("href");
						 doc = Jsoup.connect(url).timeout(60000).get();
						 
						 contents = doc.select(".show_text").get(0).select("p");;
						 StringBuffer content = new StringBuffer();
						 for (Element e_content : contents) {
							 content.append(e_content.text()).append("\n\r");
						}
						System.out.println(content.toString());
						 Date date = new Date();
						 Joke_segment joke_segment = new Joke_segment();
						 joke_segment.setTitle(title);
						joke_segment.setContent(content.toString());
						joke_segment.setCtime(date);
						joke_segment.setIs_show(0);//是否显示(0:显示 1：不显示)
						joke_segment.setIs_spider(0);//是否是抓取的段子(0:抓取 1：自己添加)
						joke_segment.setIs_title(1);//是否有标题(0:没有 1：有)
						joke_segment.setJc_id(9);
						joke_segment.setNote("内涵笑话-抓取");
						list.add(joke_segment);
						System.out.println("--------------------------");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						log.error("SpiderBiz.do_3jy_joke is error", e);
					}
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			log.error("SpiderBiz.do_3jy_joke is error", e);
		}
		return list;
	}
	
	
	
	
	/*******抓取内涵笑话******http://www.pengfu.com/xiaohua_19098.html**/
	public static List<Joke_segment> do_pengfu_joke_xiaoyuan(int start,int end){
		List<Joke_segment> list = new ArrayList<Joke_segment>();
		try {
			//冷笑话
			for (int i = start; i < end; i++) {
				String url = "http://www.pengfu.com/xiaohua_"+i+".html";
				Document doc = Jsoup.connect(url).timeout(60000).get();
				Elements elements = doc.body().select(".contFont");
				for (Element element : elements) {
					 try {
						 //获取标题
						 String title = element.select(".tieTitle").get(0).getElementsByTag("a").get(0).text();
						 System.out.println(title);
						 String content =  element.select(".humordatacontent").get(0).text();
						 System.out.println(content); 
						 
						Date date = new Date();
						Joke_segment joke_segment = new Joke_segment();
						joke_segment.setTitle(title);
						joke_segment.setContent(content.toString());
						joke_segment.setCtime(date);
						joke_segment.setIs_show(0);//是否显示(0:显示 1：不显示)
						joke_segment.setIs_spider(0);//是否是抓取的段子(0:抓取 1：自己添加)
						joke_segment.setIs_title(1);//是否有标题(0:没有 1：有)
						joke_segment.setJc_id(10);
						joke_segment.setNote("捧腹段子-抓取");
						list.add(joke_segment);
						System.out.println("--------------------------");
					 } catch (Exception e) {
							// TODO Auto-generated catch block
							log.error("SpiderBiz.do_pengfu_joke_xiaoyuan is error", e);
					 }
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			log.error("SpiderBiz.do_pengfu_joke_xiaoyuan is error", e);
		}
		return list;
	}
	
}
