package com.pyb.task;


import com.pyb.mvc.weixin.biz.UserOrderBiz;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * 处理订单支付超时进行关闭
 */
@Component
public class OrderPayTask {
	private Logger log = Logger.getLogger(this.getClass());
	@Autowired
	UserOrderBiz userOrderBiz;
	/**
	 * 调度检查哪些订单支持下单超时
	 */
	@Scheduled(cron = "0 0/10 * * * ?")
	public void checkOrderTimeOut(){
		try{
				log.info("------------Task--checkOrderTimeOut--------------is start---");
			    userOrderBiz.checkOrderTimeOut();
		}catch (Throwable e) {
			log.error("OrderPayTask.checkOrderTimeOut is error", e);
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
