package com.pyb.task;


import com.pyb.jsoup.article.EastMoneyUtil;
import com.pyb.jsoup.article.Nfcj_singleStock_Spider;
import com.pyb.jsoup.article.ZzUtil;
import com.pyb.mvc.service.SpiderBiz;
import com.pyb.mvc.service.SpiderNewsBiz;
import com.pyb.mvc.service.StockInfoBiz;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Channel1Task {
	private Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private SpiderBiz spiderBiz;
	@Autowired
	private StockInfoBiz stockInfoBiz ;
	@Autowired
	private SpiderNewsBiz spiderNewsBiz;
	@Autowired  //自动注入,默认按名称
	private ZzUtil zzUtil;
	@Autowired  //自动注入,默认按名称
	private EastMoneyUtil eastMoneyUtil;
	@Autowired  //自动注入,默认按名称
	private Nfcj_singleStock_Spider nfcj_singleStock_Spider;
	/**
	 * 调度抓取新闻的数据
	 * http://www.528ads.com/jxh_publish.php?type=1&ids=5620
	 */
	@Scheduled(cron = "0 0/10 * * * ?")
	public void dospider(){
		try{
				log.info("------------Channel1Task----------------is start---");
				spiderBiz.spiderChannel_1();
		}catch (Throwable e) {
			log.error("Channel1Task.dospider is error", e);
		}

	}
	/**
	 * 调度抓取新闻的数据
	 */
	@Scheduled(cron = "0 0 0/2 * * ?")
	public void zzUtil(){
		try{
			log.info("------------Channel1Task-------zzUtil---------is start---");
			zzUtil.DoWithRecursion();
			//抓取个股信息
			nfcj_singleStock_Spider.executeSpider();
			//发布信息
			doRequestPHP();
		}catch (Throwable e) {
			log.error("Channel1Task.zzUtil is error", e);
		}

	}

	/**
	 * 调度抓取实盘大单的数据
	 */
	@Scheduled(cron = "0 0/30 * * * ?")
	public void dospiderstocklist(){
		try{
				log.info("------------Channel3Task----------------is start---");
				spiderBiz.spiderChannel_3();
				//spiderNewsBiz.spider();
			    eastMoneyUtil.DoWithRecursion();
			//发布信息
			doRequestPHP();
		}catch (Throwable e) {
			log.error("Channel3Task.dospider is error", e);
		}

	}

	/**
	 * 每三小时抓取一次 停复牌提示
	 */
	@Scheduled(cron = "0 0 0/1 * * ?")
	public void dospiderDFCF(){
		try{
				log.info("------------Channel567Task----------------is start---");
				spiderBiz.spiderChannel_5();
				spiderBiz.spiderChannel_6();
				spiderBiz.spiderChannel_7();
				spiderBiz.spiderChannel_9();
		}catch (Throwable e) {
			log.error("Channel567Task.dospiderDFCF is error", e);
		}

	}
	/**
	 * 抓取 新股 插入股票总池里
	 */
	@Scheduled(cron = "0 14 12 * * ?")
	public void dospiderStockinfo(){
		try{
				log.info("------------dospiderStockinfo----------------is start---");
				stockInfoBiz.doIF();
		}catch (Throwable e) {
			log.error("ChannelTask.dospiderStockinfo is error", e);
		}

	}


	/**
	 * 调度抓取笑话的数据
	 */
//	@Scheduled(cron = "0 37 16 * * ?")
	public void dospider2(){
		try{
				log.info("------------spiderJoke----------------is start---");
				//spiderBiz.doSpiderJokeClass();
		}catch (Throwable e) {
			log.error("Channel1Task.spiderJoke is error", e);
		}

	}



	public void doRequestPHP(){
		try {
			String url = "http://www.528ads.com/jxh_publish.php?type=100";
			HttpGet get = new HttpGet(url);
			CloseableHttpClient httpclient = HttpClients.createDefault();
			CloseableHttpResponse repose = httpclient.execute(get);
			System.out.println(repose.getStatusLine().getStatusCode());
		} catch (Exception e) {
			log.error("doRequestPHP is error",e);
		}
	}

}
