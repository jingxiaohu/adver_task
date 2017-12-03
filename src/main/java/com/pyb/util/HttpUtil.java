package com.pyb.util;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

public class HttpUtil {
	static Logger log = LoggerFactory.getLogger(HttpUtil.class);

	/**
	 * 执行post或者get方法
	 * 
	 * @param method
	 *            post/get方法
	 * @throws IOException
	 * @throws HttpException
	 */
	public static void executeHttpClient(HttpMethod method)
			throws HttpException, IOException {
		HttpClient httpclient = new HttpClient(new HttpClientParams(),
				new SimpleHttpConnectionManager(true));
		httpclient.executeMethod(method);

	}

	/**
	 * 无返回值执行post方法
	 * 
	 * @param url
	 *            url地址
	 * @throws IOException
	 * @throws HttpException
	 */
	public static void executePost(String url, String eventName,
			String value1, String value2, String value3, String value4)
			throws HttpException, IOException {
		PostMethod post = new PostMethod(url);
		post.addParameter("miName", eventName);
		post.addParameter("make","353179ABC");

		if (!RequestUtil.checkObjectBlank(value1)) {
			post.addParameter("miParmOne", value1);
		}

		if (!RequestUtil.checkObjectBlank(value1)) {
			post.addParameter("miParmTwo", value2);
		}

		if (!RequestUtil.checkObjectBlank(value1)) {
			post.addParameter("miParmThe", value3);
		}

		if (!RequestUtil.checkObjectBlank(value4)) {
			post.addParameter("miParmFor", value1);
		}

		HttpUtil.executeHttpClient(post);

		post.releaseConnection();

	}

	/**
	 * 将文件流的转换为指定字符流
	 * 
	 * @param ins
	 *            inputstream
	 * @param charset
	 *            编码
	 * @return 字符流
	 * @throws IOException
	 */
	public static String getStream2String(InputStream ins, String charset)
			throws IOException {
		String line = null;

		StringBuilder sb = new StringBuilder();
		BufferedReader isr = new BufferedReader(new InputStreamReader(ins,
				charset));

		while ((line = isr.readLine()) != null) {
			sb.append(line);
		}
		line = sb.toString();

		return line;
	}

	/**
	 *
	 * @param url
	 * @param header
	 * @param params
	 * @return
	 */
	public static String doGet(String url, Map<String, String> header, NameValuePair[] params) {
		HttpClient hc = new HttpClient();
		GetMethod get = null;
		try {
			hc.setConnectionTimeout(20 * 1000);
			hc.setTimeout(20 * 1000);
			get = new GetMethod(url);
			if (params != null) {
				get.setQueryString(params);
			}
			get.setRequestHeader("Connection", "close");
			get.addRequestHeader("Content-Type", "application/json;charset=utf-8");
			get.addRequestHeader("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			get.addRequestHeader("Accept-Language", "zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3");
			if (header != null) {
				for (String h : header.keySet()) {
					get.addRequestHeader(h, header.get(h));
				}
			}
			hc.executeMethod(get);
			if (get.getStatusCode() == 200) {
				InputStream resStream = get.getResponseBodyAsStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(resStream));
				StringBuffer resBuffer = new StringBuffer();
				String resTemp = "";
				while ((resTemp = br.readLine()) != null) {
					resBuffer.append(resTemp);
				}
				String response = resBuffer.toString();
				//return get.getResponseBodyAsString();
				return response;
			} else {
				log.error(url + " req error StatusCode:" + get.getStatusCode());
			}
		} catch (Exception e) {
			log.error("doGet error", e);
			return "error";
		} finally {
			if (get != null) {
				get.releaseConnection();
				//释放链接
				hc.getHttpConnectionManager().closeIdleConnections(0);
			}
		}
		return "error";
	}
}
