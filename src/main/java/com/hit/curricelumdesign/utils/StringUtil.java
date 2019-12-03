package com.hit.curricelumdesign.utils;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description: String工具
 * ClassName: StringUtil
 * date: 2018年11月11日
 *
 * @author YGC
 * @version
 * @since JDK 1.8
 */
public class StringUtil extends StringUtils {

	public static final String EMPTY = "";
	public static final String SPACE = " ";
	public static final String TAB = "	";

	public static final String ACUTE = "`";
	public static final String TILDE = "~";
	public static final String EXCLAMATION = "!";
	public static final String AT = "@";
	public static final String NUMBER = "#";
	public static final String DOLLAR = "$";
	public static final String PERCENT = "%";
	public static final String CARET = "^";
	public static final String AND = "&";
	public static final String STAR = "*";
	public static final String LEFT_PARENTHESIS = "(";
	public static final String RIGHT_PARENTHESIS = ")";
	public static final String HYPHEN = "-";
	public static final String UNDERSCORE = "_";
	public static final String EQUALS = "=";
	public static final String PLUS = "+";

	public static final String LEFT_SQUARE_BRACKET = "[";
	public static final String RIGHT_SQUARE_BRACKET = "]";
	public static final String LEFT_CURLY_BRACE = "{";
	public static final String RIGHT_CURLY_BRACE = "}";
	public static final String BACKSLASH = "\\";
	public static final String VERTICAL_BAR = "|";
	public static final String SEMI_COLON = ";";
	public static final String COLON = ":";
	public static final String SINGLE_QUOTATION = "'";
	public static final String DOUBLE_QUOTATION = "\"";
	public static final String COMMA = ",";
	public static final String DOT = ".";
	public static final String LEFT_ANGLE_BRACKET = "<";
	public static final String RIGHT_ANGLE_BRACKET = ">";
	public static final String SLASH = "/";
	public static final String QUESTION = "?";

	public static final String[] CHINESE_NUMBER = { "〇", "一", "二", "三", "四", "五", "六", "七", "八", "九", "十" };

	public static Double parseDouble(String doubleStr) {
		try {
			return Double.parseDouble(doubleStr);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	public static Float parseFloat(String floatStr) {
		try {
			return Float.parseFloat(floatStr);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	public static Long parseLong(String longStr) {
		try {
			return Long.parseLong(longStr);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	public static Integer parseInt(String intStr) {
		try {
			return Integer.parseInt(intStr);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	/**
	 * 将string转为long类型，若string为null、空，或者无法解析为数字，则返回给定的默认值
	 *
	 * @param longStr
	 * @param defaultValue
	 * @return
	 */
	public static long parseLong(String longStr, long defaultValue) {
		try {
			return Long.parseLong(longStr);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	/**
	 * 将string转为int类型，若string为null、空，或者无法解析为数字，则返回给定的默认值
	 *
	 * @param intStr
	 * @param defaultValue
	 * @return
	 */
	public static int parseInt(String intStr, int defaultValue) {
		try {
			return Integer.parseInt(intStr);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	/**
	 * redis值是否为空
	 *
	 * @param cs
	 * @return
	 */
	public static boolean isRedisBlank(String cs) {
		if (isBlank(cs) || "null".equals(cs.trim())) {
			return true;
		}
		return false;
	}

	/**
	 * 根据指定的正则表达式，对字符串进行校验
	 *
	 * @param cs
	 * @param regex
	 * @return
	 */
	public static boolean verifyString(String cs, String regex) throws NullPointerException {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(cs);
		return matcher.matches();
	}

	/**
	 * 判断两个字符串的值是否相等，包括null
	 *
	 * @return
	 */
	public static boolean isStringEquals(String str1, String str2) {
		if (str1 == null) {
			return str2 == null;
		} else {
			return str1.equals(str2);
		}
	}

	/**
	 * 格式化手机号
	 *
	 * @param phone
	 * @return
	 */
	public static String formatPhone(String phone) {
		if (phone == null) {
			return null;
		}
		return formatStr(phone, 3, 4, 4, "$1****$2");
	}

	/**
	 * 格式化身份证号
	 * @param idNo
	 * @return
	 */
	public static String formatIdNo(String idNo) {
		if (idNo == null) {
			return null;
		}
		return formatStr(idNo, 6, idNo.length() - 6 - 3, 3, "$1*********$2");
	}

	public static String formatStr(String src, int pre, int medium, int last, String replace) {
		if (src == null || pre + last >= src.length()) {
			return src;
		}

		String result = src.replaceAll("(\\d{" + pre + "})\\d{" + medium + "}(\\d{" + last + "})", replace);
		return result;
	}

	/**
	 * 获取中文数字
	 */
	public static String getChineseNumber(int num) {

		int numberLength = CHINESE_NUMBER.length;

		String chineseNum = null;
		if (num >= 0 && num < numberLength) {
			chineseNum = CHINESE_NUMBER[num];
		} else {
			chineseNum = StringUtil.QUESTION;
		}

		return chineseNum;
	}

	/**
	 * 获取连接字符串
	 * @param stringList
	 * @param separator
	 * @return
	 */
	public static String getJoinedStr(List<String> stringList, String separator) {
		if (CollectionUtils.isEmpty(stringList)) {
			return null;
		}

		String[] array = stringList.toArray(new String[0]);
		String joinedStr = StringUtil.join(array, separator);

		return joinedStr;
	}

	/**
	 * 获取分隔字符串
	 */
	public static List<String> getSeparatedStrList(String string, String separator) {
		if (StringUtil.isEmpty(string)) {
			return null;
		}

		List<String> separatedStrList = new ArrayList<String>();

		StringTokenizer st = new StringTokenizer(string, separator);
		while (st.hasMoreTokens()) {
			String token = st.nextToken().trim();
			separatedStrList.add(token);
		}

		return separatedStrList;
	}

	public static String blankIfNull(String value) {
		if (StringUtil.isBlank(value)) {
			return "";
		}
		return value;

	}

	/**
	 * 获取uuid字符串
	 *
	 * @return
	 */
	public static String generateUUIDStr() {
		String uuid = UUID.randomUUID().toString();

		// 去掉“-”符号
		uuid = uuid.replace("-", "");

		return uuid;
	}

	/**
	 * 获取随机字符串
	 * @param length  想要获取的位数
	 */
	public static String getRandomString(int length){
		String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random=new Random();
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<length;i++){
			int number=random.nextInt(62);
			sb.append(str.charAt(number));
		}
		return DateUtil.formatCurrentSystemDate() + sb.toString();
	}
}
