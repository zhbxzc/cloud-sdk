package com.love.life.sdk;

import java.util.Map;
import java.util.Set;

/**
 * 消息工具类
 * 
 * 
 */
public class MessageUtil {
	
	/**
	 * 获取ams网站接口参数
	 * @param map 参数列表
	 * @param isSign 是否加密
	 * @param signValue 加密的value
	 * @return
	 */
	public static String getParameter(Map<String, Object> map) {
			String result = "";
			if (map == null||map.isEmpty()) {
				return result;
			}
			
			Set<String> keys = map.keySet();
			for (String key : keys) {
				if(map.get(key) != null) {
					if(result != null && !"".equals(result)) {
						result = result + "&";
					}
					result = result + "" + key +"=" + map.get(key);
				}
			}
			return result;
		
	}
	


}
