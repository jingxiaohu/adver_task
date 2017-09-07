package com.pyb.mvc.service;

import com.pyb.bean.Stock_info;
import com.pyb.util.PinyinToolkit;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

/**
 * gain stock code
 * @author jingxiaohu
 *
 */
@Service
public class StockInfoBiz extends BaseBiz{
	Logger log = Logger.getLogger(StockInfoBiz.class);
	public void doIF(){
		for (int i = 0; i < 1000; i++) {
			String str1 = "000";
			doStockInfo(str1, i,"sz");
		}
		for (int i = 0; i < 1000; i++) {
			String str2 = "002";
			doStockInfo(str2, i,"sz");
		}
		for (int i = 0; i < 1000; i++) {
			String str3 = "300";
			doStockInfo(str3, i,"sz");
		}
		for (int i = 0; i < 1000; i++) {
			String str4 = "600";
			doStockInfo(str4, i,"sh");
		}
	}










	public void doStockInfo(String str1,int i,String pre){
		try {
			if(i<10){
				str1 = str1+"00"+i;
			}else if(i >= 10 && i<100){
				str1 = str1+"0"+i;
			}else{
				str1 = str1+i;
			}
			String url = "http://hq.sinajs.cn/list="+pre+str1;
			String tt = doGet( url,null,null);
			if(tt != null && tt.length() > 50){
				Stock_info stockinfo = new Stock_info();
				String name = tt.substring(tt.indexOf("\"")+1, tt.lastIndexOf("\""));
				System.out.println(name);
				String[] dd = name.split(",");
				stockinfo.setCtime(new Date());
				stockinfo.setStock_code(str1);
				stockinfo.setStock_name(dd[0]);
				stockinfo.setStock_pinyin(PinyinToolkit.cn2FirstSpell(dd[0]));
				stockinfo.setStock_t_price(dd[3]);
				stockinfo.setStock_type("sz");
				stockinfo.setStock_y_price(dd[2]);
				int indexid = daoFactory.getStock_infoDao().insert(stockinfo);
				if(indexid > 0){
					System.out.println("插入成功---"+tt);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage(), e);
		}
	}






	/**
	 * 请求头集合
	 * @param url
	 * @param header
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public  String doGet(String url,Map<String, String> header,NameValuePair[] params){
		HttpClient  hc = new HttpClient();
		GetMethod get =  null;
		try{
			hc.setConnectionTimeout(20*1000);
			hc.setTimeout(20*1000);
			get =  new GetMethod(url);
			if(params!= null){
				get.setQueryString(params);
			}
			get.setRequestHeader("Connection", "close");
			get.addRequestHeader("Content-Type", "application/json;charset=utf-8");
			get.addRequestHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			get.addRequestHeader("Accept-Language", "zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3");
			if(header!=null){
				for(String h:header.keySet()){
					get.addRequestHeader(h, header.get(h));
				}
			}
			hc.executeMethod(get);
			if(get.getStatusCode() == 200){
				InputStream resStream = get.getResponseBodyAsStream();
		        BufferedReader br = new BufferedReader(new InputStreamReader(resStream,get.getResponseCharSet()));
		        StringBuffer resBuffer = new StringBuffer();
		        String resTemp = "";
		        while((resTemp = br.readLine()) != null){
		            resBuffer.append(resTemp);
		        }
		        String response = resBuffer.toString();
				//return get.getResponseBodyAsString();
		        return response;
			}else{
				log.error(url+" req error StatusCode:"+get.getStatusCode());
			}
		}catch(Exception e){
			log.error("doGet error", e);
			return null;
		}finally{
			if(get!=null){
				get.releaseConnection();
				//释放链接
				hc.getHttpConnectionManager().closeIdleConnections(0);
			}
		}
		return null;
	}

}
