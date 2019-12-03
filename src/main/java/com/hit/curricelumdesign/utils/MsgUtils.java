package com.hit.curricelumdesign.utils;

import java.util.Random;
import java.util.UUID;

/**
 * Description: msg工具类
 * ClassName: MsgUtils
 * date: 2018年11月20日
 *
 * @author YGC
 * @version
 * @since JDK 1.8
 */
public class MsgUtils {

	/**
	 * 随机获取一个指定位数的随机字符串，有数字和字母（大小写）组成
	 *
	 * @return
	 */
	public static String generateNoncestr(int length) {
		Random random = new Random(System.currentTimeMillis());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int seed1 = random.nextInt(3);
			switch (seed1) {
			// 大写字符
			case 0:
				sb.append((char) (65 + random.nextInt(26)));
				break;
			// 小写字母
			case 1:
				sb.append((char) (97 + random.nextInt(26)));
				break;
			// 数字
			default:
				sb.append(random.nextInt(10));
				break;
			}
		}
		return sb.toString();
	}

	/**
	 * 随机获取一个指定位数的随机数字字符串
	 *
	 * @param length
	 * @return
	 */
	public static String generateNonceNum(int length) {
		Random random = new Random(System.currentTimeMillis());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(random.nextInt(10));
		}
		return sb.toString();

	}

	/**
	 * 获取uuid字符串
	 *
	 * @return
	 */
	public static String generateUUIDStr() {
		String uuid = generateRawUUIDStr();

		// 去掉“-”符号
		uuid = uuid.replace("-", "");

		return uuid;
	}

	/**
	 * 获取原始uuid字符串
	 *
	 * @return
	 */
	public static String generateRawUUIDStr() {
		UUID uuid = UUID.randomUUID();
		String uuidStr = uuid.toString();
		return uuidStr;
	}

}
