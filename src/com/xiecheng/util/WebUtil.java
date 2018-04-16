package com.xiecheng.util;

import java.util.HashMap;
import java.util.Map;







public class WebUtil {


	public static String mapToJson(HashMap<String,String> map){
		StringBuffer json=new StringBuffer();
		json.append("{");
		for(Map.Entry<String,String> entry:map.entrySet()){//循环遍历  构造json
			json.append("\"");
			json.append(entry.getKey());
			json.append("\":\"");
			json.append(entry.getValue());
			json.append("\",");
		}
		json.append("\"1\":\"1\"}");//由于结尾会多一个逗号，所以多加一行
		System.out.println(json);
		return json.toString();
	}
}
