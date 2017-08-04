package com.pyb.test.utl;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.MultiValueMap;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author jingxiaohu
 *
 */
public class InterfaceUtil {
	static Logger  log = LoggerFactory.getLogger(InterfaceUtil.class);
	/**
	 * 
	 * @param modeName ：模块名称 例如：1.活动管理模块
	 * @param interfaceName： 接口中文名称：例如：获取优先的活动
	 * @param signIntro：需要进行签名的参数说明 例如：dtype+ui_id
	 * @param url：请求地址 例如：http://app.qc-wbo.com/v1/weight_activity.php
	 * @param num：接口编号 例如：1
	 * @return
	 * @throws Exception 
	 */
	public static void AddInterfacePredAspect(String FileAbpath,String modeName,String interfaceName,String signIntro,String url,int num,MultiValueMap<String, String> params,Class<?> paramBean,String result) throws Exception{
		File file = new File(FileAbpath);
		StringBuffer sb =  null;
		if(sb == null){
			sb = new StringBuffer();
		}
		if(num == 1){
			sb.append("[[_TOC_]]");
			sb.append("\r\n");
			sb.append("### "+modeName+"");
		}
		sb.append("\r\n");
		sb.append("#### "+num+"->"+interfaceName+"");
		sb.append("\r\n");
		sb.append("|参数名称|值描述|是否可空|限制长度|参数类型|举例|");
		sb.append("\r\n");
		sb.append("|--------|-----|----|--------|-------|-----|");
		sb.append("\r\n");
		Map<String,InterfaceParam> map = ReadParamClass(paramBean);
		for (Entry<String, List<String>> entry : params.entrySet()) {  
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
		    InterfaceParam pp =  map.get(entry.getKey());
		    if(pp != null){
		    	pp.VALUE = entry.getValue().get(0);
		    	if(pp.VALUE == null){
		    		pp.VALUE = "";
		    	}
		    	map.put(entry.getKey(),pp);
		    }
		}  
		
		for (Entry<String, InterfaceParam> entry : map.entrySet()) { 
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			InterfaceParam pp =  map.get(entry.getKey());
			String str = "|%s|%s|%s|%s|%s|%s|";
			str = String.format(str, pp.KEY,pp.DESC,pp.ISNULL,pp.LENGTH,pp.TYPE,pp.VALUE);
			sb.append(str);
			sb.append("\r\n");
		}
		
		sb.append("| sign| MD5数字签名("+signIntro.replace("\"", "").replace("\'", "")+")按参数的首字母升序顺序进行组装| 否| 无 |字符串|");
		sb.append("\r\n");
		sb.append("#### 请求路径");
		sb.append("\r\n");
		sb.append("["+url+"]("+url+")");
		sb.append("\r\n");
		sb.append("###### 返回结果");
		sb.append("\r\n");
		sb.append("```json");
		sb.append("\r\n");
		StrToJson(result,sb);
		sb.append("\r\n");
		sb.append("```");
		sb.append("\r\n");


		//这里写文件
		FileUtils.writeStringToFile(file, sb.toString(), "UTF-8", true);
		
	}
	/**
	 * 
	 * @param modeName ：模块名称 例如：1.活动管理模块
	 * @param interfaceName： 接口中文名称：例如：获取优先的活动
	 * @param signIntro：需要进行签名的参数说明 例如：dtype+ui_id
	 * @param url：请求地址 例如：http://app.qc-wbo.com/v1/weight_activity.php
	 * @param num：接口编号 例如：1
	 * @return
	 * @throws Exception 
	 */
	public static void AddInterfacePred(String FileAbpath,String modeName,String interfaceName,String signIntro,String url,int num,MultiValueMap<String, String> params,Class<?> paramBean,String result) throws Exception{
		File file = new File(FileAbpath);
//		StringBuffer sb =  readInterfaceFile2(file);
		StringBuffer sb =  null;
		if(sb == null){
			sb = new StringBuffer();
		}
		if(num == 1){
			sb.append("[[_TOC_]]");
			sb.append("\r\n");
			sb.append("### "+modeName+"");
		}
		sb.append("\r\n");
		sb.append("#### "+num+"->"+interfaceName+"");
		sb.append("\r\n");
		sb.append("|参数名称|值描述|是否可空|限制长度|参数类型|举例|");
		sb.append("\r\n");
		sb.append("|--------|-----|----|--------|-------|-----|");
		sb.append("\r\n");
		Map<String,InterfaceParam> map = ReadParamClass(paramBean);
		for (Entry<String, List<String>> entry : params.entrySet()) {  
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
		    InterfaceParam pp =  map.get(entry.getKey());
		    if(pp != null){
		    	pp.VALUE = entry.getValue().get(0);
		    	if(pp.VALUE == null){
		    		pp.VALUE = "";
		    	}
		    	map.put(entry.getKey(),pp);
		    }
		}  
		
		for (Entry<String, InterfaceParam> entry : map.entrySet()) { 
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			InterfaceParam pp =  map.get(entry.getKey());
			String str = "|%s|%s|%s|%s|%s|%s|";
			str = String.format(str, pp.KEY,pp.DESC,pp.ISNULL,pp.LENGTH,pp.TYPE,pp.VALUE);
			sb.append(str);
			sb.append("\r\n");
		}
		
		sb.append("| sign| MD5数字签名("+signIntro.replace("\"", "").replace("\'", "")+")按参数的首字母升序顺序进行组装| 否| 无 |字符串|");
		sb.append("\r\n");
		sb.append("#### 请求路径");
		sb.append("\r\n");
		sb.append("["+url+"]("+url+")");
		sb.append("\r\n");
		sb.append("###### 返回结果");
		sb.append("\r\n");
		sb.append("```json");
		sb.append("\r\n");
		StrToJson(result,sb);
		sb.append("\r\n");
		sb.append("```");
		sb.append("\r\n");


		//这里写文件
		FileUtils.writeStringToFile(file, sb.toString(), "UTF-8", true);
		
	}
	
	/**
	 * 文件读取
	 * @throws Exception 
	 */
	public static StringBuffer readInterfaceFile(String FileAbpath) throws Exception{
		File file = new File(FileAbpath);
		if(!file.exists() || !file.canRead()){
			log.info("FileAbpath={}文件不存在",FileAbpath); 
			log.info("创建文件{}",FileAbpath); 
			boolean flag = file.mkdirs();
			if(!flag){
				log.error("文件{}生成失败", FileAbpath); 
				return null;
			}
		}
		List<String>	list  = FileUtils.readLines(file, "UTF-8");
		if(list == null || list.size() == 0){
			log.error("FileAbpath={}文件内容为空",FileAbpath); 
		}
		StringBuffer sb = new StringBuffer();
		for (String str : list) {
			sb.append(str);
		}
		return sb;
		
	}
	
	/**
	 * 文件读取
	 * @throws Exception 
	 */
	public static StringBuffer readInterfaceFile2(File file) throws Exception{
		
		if(!file.exists() || !file.canRead()){
			log.info("FileAbpath={}文件不存在",file.getAbsolutePath()); 
			log.info("创建文件{}",file.getAbsolutePath()); 
			boolean flag = file.createNewFile();
			if(!flag){
				log.error("文件{}生成失败", file.getAbsolutePath()); 
				return null;
			}
		}
		List<String>	list  = FileUtils.readLines(file, "UTF-8");
		if(list == null || list.size() == 0){
			log.error("FileAbpath={}文件内容为空",file.getAbsolutePath()); 
		}
		StringBuffer sb = new StringBuffer();
		for (String str : list) {
			sb.append(str);
		}
		return sb;
		
	}
	
	/**
	 * 读取参数bean类 中的参数和注释
	 */
	public static Map<String,InterfaceParam> ReadParamClass(Class<?> c){
		Map<String,InterfaceParam> map = new HashMap<String,InterfaceParam>();
		
		
        Field [] field = c.getDeclaredFields();  
        for (Field f : field) {  
        	InterfaceParam pp = new InterfaceParam();
        	pp.KEY = f.getName();
        	pp.TYPE = f.getGenericType().toString();
        	pp.VALUE = "";
            TargetComment t = (TargetComment) f.getAnnotation(TargetComment.class);  
            pp.ISNULL = t.isnull();
            pp.DESC = t.value();
            pp.LENGTH = t.lenth();
            map.put(pp.KEY,pp);
        }  
		return map;
	}
	
	
	/**
	 * 解析JSON字符串 然后进行组装
	 */
	public static void StrToJson(String result,StringBuffer sb){
		int suojin = 1;
	    if(result == null){
	    	return ;
	    }
	    sb.append("{");sb.append("\r\n");
	    
		JSONObject obj_json = JSONObject.parseObject(result);
		Set<String> set = obj_json.keySet();
		TreeSet<String> ss = new TreeSet<String>();
		ss.addAll(set);
		for (String key : ss) {
			 if(key == null){
				 continue;
			 }
			 Object value = obj_json.get(key);
			 if(value == null || "".equalsIgnoreCase(value.toString())){
				 value = "";
				 isString( key, value.toString(), sb,suojin);
			 }else{
				 if(value instanceof JSONObject){
					 SuoJin(suojin,sb); 
					 sb.append(key)
					    .append(":");
						isJSONObject( obj_json.getJSONObject(key), sb,suojin,false); 
				 }else if(value instanceof JSONArray){
					 SuoJin(suojin,sb); 
					 sb.append(key)
					    .append(":");
						isJSONArray( obj_json.getJSONArray(key), sb,suojin); 
				 }else{
					 isString( key, value.toString(), sb,suojin);
				 }
			 }
		 }
		 sb.append("}");sb.append("\r\n");
	}
	
	
	/**
	 * 解析JSON字符串 然后进行组装----递归使用
	 */
	public static void isJSONObject(JSONObject obj_json,StringBuffer sb,int suojin,boolean douhao){ 
		if(obj_json == null){
			obj_json = new JSONObject() ; 
	    }
		int temp = suojin;
		if(suojin > 0){
			suojin++;
		}
		SuoJin(temp,sb);
	    sb.append("{");sb.append("\r\n");
	    
		Set<String> set = obj_json.keySet();
		TreeSet<String> ss = new TreeSet<String>();
		ss.addAll(set);
		 for (String key2 : ss) { 
			 if(key2 == null){
				 continue;
			 }
			 Object value = obj_json.get(key2);
			 if(value == null){ 
				 value = "";
			 }
			 if(value instanceof JSONObject){
				 isJSONObject( obj_json.getJSONObject(key2), sb,suojin,false); 
			 }else if(value instanceof JSONArray){
				 isJSONArray( obj_json.getJSONArray(key2), sb,suojin); 
			 }else{
				 isString( key2, value.toString(), sb,suojin);
			 }
		 }
		 SuoJin(temp,sb);
		 sb.append("}");
		 if(douhao){
			 sb.append(",");
		 }
		 sb.append("\r\n");
	}
	/**
	 * 解析JSON字符串 然后进行组装----递归使用
	 */
	public static void isJSONArray(JSONArray obj_array,StringBuffer sb,int suojin){ 
		if(obj_array == null){
			obj_array = new JSONArray() ;  
	    }
		int temp = suojin;
		if(suojin > 0){
			suojin++;
		}
	    sb.append("[");sb.append("\r\n");
	    
	    for (int i = 0; i < obj_array.size(); i++) {
	    	JSONObject obj = obj_array.getJSONObject(i);
	    	if(obj == null){
	    		obj = new JSONObject();
	    	}
	    	if(i == obj_array.size()-1){
	    		isJSONObject(obj, sb,suojin,false);
	    	}else{
	    		isJSONObject(obj, sb,suojin,true);
	    	}
		}
	    SuoJin(temp,sb);
	    sb.append("]");sb.append("\r\n");
	}
	
	
	/**
	 * 如果KEY 对应的值是字符串
	 */
	public static void isString(String key,String value,StringBuffer sb,int suojin){ 
		if(value == null){
			value = "";
	    }
		SuoJin(suojin,sb);
	    sb.append(key)
	    .append(":")
	    .append("\"").
		append(value)
		.append("\"")
		.append("\r\n");
   }
	
   /**
    * 字符缩进
    * @author jingxiaohu
    * @param num : 缩进的table键个数
    */
	public static void SuoJin(int num,StringBuffer sb){
		for (int i = 0; i < num; i++) {
			sb.append("	");
		}
	}
	class MyComparator implements Comparator<String>{  
		  
	    @Override  
	    public int compare(String o1, String o2) {  
	          
	        return o2.compareTo(o1);//降序排列  
	    }  
	      
	}  
}