package com.pyb.task;


import com.pyb.jsoup.article.ZzUtil;
import com.pyb.mvc.service.SpiderBiz;
import com.pyb.mvc.service.SpiderNewsBiz;
import com.pyb.mvc.service.StockInfoBiz;
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
	/**
	 * 调度抓取新闻的数据
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
	@Scheduled(cron = "0 0 0/3 * * ?")
	public void zzUtil(){
		try{
			log.info("------------Channel1Task-------zzUtil---------is start---");
			zzUtil.DoWithRecursion();
		}catch (Throwable e) {
			log.error("Channel1Task.zzUtil is error", e);
		}

	}

	/**
	 * 调度抓取实盘大单的数据
	 */
	@Scheduled(cron = "0/10 * * * * ?")
	public void dospiderstocklist(){
		try{
				log.info("------------Channel3Task----------------is start---");
				spiderBiz.spiderChannel_3();
				spiderNewsBiz.spider();
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
//	@Scheduled(cron = "0 14 12 * * ?")
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



}
