package com.hit.curricelumdesign.utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Map;

/**
 * Description: JSON工具类,使用的是google的JSON
 * ClassName: GsonUtils.java
 * date: 2018年12月3日
 *
 * @author YGC
 * @version
 * @since JDK 1.8
 */
public class GsonUtils {

	private final static Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

	public static Gson getInstace() {
		return gson;
	}

	private static Gson lowerCaseUnderscoresgson = new GsonBuilder().serializeNulls()
			.setDateFormat("yyyy-MM-dd HH:mm:ss").setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
			.create();

	public static Gson getLowerCaseUnderscoresgson() {
		return lowerCaseUnderscoresgson;
	}

	/**
	 * 转成json
	 *
	 * @param object
	 * @return
	 */
	public static String GsonString(Object object) {
		String gsonString = null;
		if (gson != null) {
			gsonString = gson.toJson(object);
		}
		return gsonString;
	}

	/**
	 * 转成bean
	 *
	 * @param gsonString
	 * @param cls
	 * @return
	 */
	public static <T> T GsonToBean(String gsonString, Class<T> cls) {
		T t = null;
		if (gson != null) {
			t = gson.fromJson(gsonString, cls);
		}
		return t;
	}

	/**
	 * 转成list
	 *
	 * @param gsonString
	 * @param cls
	 * @return
	 */
	public static <T> List<T> GsonToList(String gsonString, Class<T> cls) {
		List<T> list = null;
		if (gson != null) {
			list = gson.fromJson(gsonString, new TypeToken<List<T>>() {
			}.getType());
		}
		return list;
	}

	/**
	 * 转成list中有map的
	 *
	 * @param gsonString
	 * @return
	 */
	public static <T> List<Map<String, T>> GsonToListMaps(String gsonString) {
		List<Map<String, T>> list = null;
		if (gson != null) {
			list = gson.fromJson(gsonString, new TypeToken<List<Map<String, T>>>() {
			}.getType());
		}
		return list;
	}

	/**
	 * 转成map的
	 *
	 * @param gsonString
	 * @return
	 */
	public static <T> Map<String, T> GsonToMaps(String gsonString) {
		Map<String, T> map = null;
		if (gson != null) {
			map = gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
			}.getType());
		}
		return map;
	}

	/**
	 * 转成json
	 *
	 * @param object
	 * @return
	 */
	public static String toJson(Object object) {
		String json = null;
		if (gson != null) {
			json = gson.toJson(object);
		}
		return json;
	}

}
