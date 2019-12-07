package com.hit.curricelumdesign.utils;

/**
 * Description: redis工具类
 * ClassName: RedisUtils
 * date: 2018年11月20日
 *
 * @author xbr
 * @version
 * @since JDK 1.8
 */
public class RedisUtils {

	/**
	 * 判断redis返回的值是否为空(例如：NULL,"null","")
	 *
	 * @param value
	 * @return
	 */
	public static boolean isBlank(String value) {
		if (value == null || "null".equals(value.trim().toLowerCase()) || "".equals(value.trim())) {
			return true;
		}
		return false;
	}

}
