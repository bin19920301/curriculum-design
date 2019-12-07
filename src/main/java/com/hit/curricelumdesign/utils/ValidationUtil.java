package com.hit.curricelumdesign.utils;

import com.hit.curricelumdesign.context.exception.InvalidParameterException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Description: 校验工具类
 * ClassName: ValidationUtil
 * date: 2018年11月22日
 *
 * @author xbr
 * @version
 * @since JDK 1.8
 */
public class ValidationUtil {

	private static Log logger = LogFactory.getLog(ValidationUtil.class);

	/**
	 * 校验数值空值
	 *
	 * @param number
	 * @param keyName
	 */
	public static void checkNumberNull(Number number, String keyName) {
		if (number == null) {
			logger.error(LogUtils.getCommLog(String.format("数值为空,参数名:%s", keyName)));
			throw new InvalidParameterException(String.format("%s为空", keyName));
		}
	}

	/**
	 * 校验是否数字
	 *
	 * @param string
	 * @param keyName
	 */
	public static void checkNumber(String string, String keyName) {
		if (StringUtil.isNotBlank(string)) {
			boolean valid = RulesVerifyUtil.verifyNumber(string);
			if (!valid) {
				logger.error(LogUtils.getCommLog(String.format("%s不是数字,参数值:%s", keyName, string)));
				throw new InvalidParameterException(String.format("%s不正确", keyName));
			}
		}
	}

	/**
	 * 校验字符空值
	 *
	 * @param string
	 * @param keyName
	 */
	public static void checkStringEmpty(String string, String keyName) {
		if (StringUtil.isEmpty(string)) {
			logger.error(LogUtils.getCommLog(String.format("字符串为空,参数名:%s", keyName)));
			throw new InvalidParameterException(String.format("%s为空", keyName));
		}
	}

	/**
	 * 校验字符空白
	 *
	 * @param string
	 * @param keyName
	 */
	public static void checkStringBlank(String string, String keyName) {
		if (StringUtil.isBlank(string)) {
			logger.error(LogUtils.getCommLog(String.format("字符串为空白,参数名:%s", keyName)));
			throw new InvalidParameterException(String.format("%s为空", keyName));
		}
	}

	/**
	 * 校验字符串长度
	 *
	 * @param string
	 * @param keyName
	 */
	public static void checkStringMaxLength(String string, String keyName, int maxLength) {
		if (StringUtil.isNotBlank(string)) {
			boolean valid = RulesVerifyUtil.verifyCsMaxLength(string, maxLength);
			if (!valid) {
				logger.error(
						LogUtils.getCommLog(String.format("字符串过长,字符串:%s,参数名:%s,限制长度:%d", string, keyName, maxLength)));
				throw new InvalidParameterException(String.format("%s过长,最大值:%s", keyName, maxLength));
			}
		}
	}

	/**
	 * 校验数字非负
	 *
	 * @param number
	 * @param keyName
	 */
	public static void checkNonNegativeNumber(long number, String keyName) {
		if (number < 0) {
			logger.error(LogUtils.getCommLog(String.format("数值为负,数值:%s,参数名:%s", number, keyName)));
			throw new InvalidParameterException(String.format("数值(%s)为负", keyName));
		}
	}

	/**
	 * 校验数字非负
	 *
	 * @param number
	 * @param keyName
	 */
	public static void checkNonNegativeNumber(double number, String keyName) {
		if (number < 0) {
			logger.error(LogUtils.getCommLog(String.format("数值为负,数值:%s,参数名:%s", number, keyName)));
			throw new InvalidParameterException(String.format("数值(%s)为负", keyName));
		}
	}

	/**
	 * 校验参数是否有效
	 *
	 * @param value
	 * @param validValues
	 * @param keyName
	 */
	public static void checkIfValid(int value, List<Integer> validValues, String keyName) {
		if (CollectionUtils.isEmpty(validValues)) {
			return;
		}
		if (!validValues.contains(value)) {
			logger.error(LogUtils.getCommLog(String.format("参数异常,参数值:%s,参数名:%s", value, keyName)));
			throw new InvalidParameterException(String.format("参数(%s)异常", keyName));
		}
	}

	/**
	 * 校验参数是否有效
	 *
	 * @param value
	 * @param validValues
	 * @param keyName
	 */
	public static void checkIfValid(String value, List<String> validValues, String keyName) {
		if (CollectionUtils.isEmpty(validValues)) {
			return;
		}
		if (!validValues.contains(value)) {
			logger.error(LogUtils.getCommLog(String.format("参数异常,参数值:%s,参数名:%s", value, keyName)));
			throw new InvalidParameterException(String.format("参数(%s)异常", keyName));
		}
	}

	/**
	 * 校验集合为空
	 * @param collections
	 * @param keyName
	 */
	public static <T> void checkCollectionEmpty(Collection<T> collections, String keyName) {
		if (CollectionUtils.isEmpty(collections)) {
			logger.error(LogUtils.getCommLog(String.format("集合为空,参数名:%s", keyName)));
			throw new InvalidParameterException(String.format("%s为空", keyName));
		}
	}

	/**
	 * 校验集合最大数量
	 * @param collections
	 * @param keyName
	 */
	public static <T> void checkCollectionMaxSize(Collection<T> collections, int maxSize, String keyName) {
		if (CollectionUtils.isNotEmpty(collections)) {
			int size = collections.size();
			if (size > maxSize) {
				logger.error(
						LogUtils.getCommLog(String.format("集合数量超过限制,参数名:%s,集合数量:%s,最大值:%s", keyName, size, maxSize)));
				throw new InvalidParameterException(String.format("%s数量超过限制,最大值:%s", keyName, maxSize));
			}
		}
	}

	/**
	 * 校验时间区间
	 *
	 * @param start
	 * @param end
	 */
	public static void checkDateRegion(Date start, Date end, String startKey, String endKey) {
		if (start == null || end == null) {
			return;
		}
		if (end.before(start)) {
			logger.error(LogUtils.getCommLog(String.format("参数异常:%s/%s,起始时间不能晚于结束时间, 起始时间:%s, 结束时间:%s", startKey,
					endKey, DateUtil.formatDateTime(start), DateUtil.formatDateTime(end))));
			throw new InvalidParameterException(String.format("起始时间(%s)不能晚于结束时间(%s)", startKey, endKey));
		}
	}

	/**
	 * 校验时间空值
	 *
	 * @param date
	 * @param keyName
	 */
	public static void checkDateEmpty(Date date, String keyName) {
		if (date == null) {
			logger.error(LogUtils.getCommLog(String.format("日期为空,参数名:%s", keyName)));
			throw new InvalidParameterException(String.format("%s为空", keyName));
		}
	}

	/**
	 * 校验手机号
	 *
	 * @param string
	 * @param keyName
	 */
	public static void checkPhone(String string, String keyName) {
		if (StringUtil.isNotBlank(string)) {
			boolean valid = RulesVerifyUtil.verifyPhone(string);
			if (!valid) {
				logger.error(LogUtils.getCommLog(String.format("%s不正确,手机号码:%s", keyName, string)));
				throw new InvalidParameterException(String.format("%s不正确", keyName));
			}
		}
	}

	/**
	 * 校验手机号+座机电话
	 * @param string
	 * @param keyName
	 */
	public static void checkContact(String string, String keyName) {
		if (StringUtil.isNotBlank(string)) {
			boolean valid = RulesVerifyUtil.verifyPhone(string) || RulesVerifyUtil.verifyTel(string);
			if (!valid) {
				logger.error(LogUtils.getCommLog(String.format("%s不正确,电话号码:%s", keyName, string)));
				throw new InvalidParameterException(String.format("%s不正确", keyName));
			}
		}
	}

	/**
	 * 校验身份证号
	 *
	 * @param string
	 * @param keyName
	 */
	public static void checkIdNo(String string, String keyName) {
		if (StringUtil.isNotBlank(string)) {
			boolean valid = RulesVerifyUtil.verifyIdNo(string);
			if (!valid) {
				logger.error(LogUtils.getCommLog(String.format("%s不正确,身份证号:%s", keyName, string)));
				throw new InvalidParameterException(String.format("%s不正确", keyName));
			}
		}
	}

	/**
	 * 校验金额
	 *
	 * @param string
	 * @param keyName
	 */
	public static void checkMoney(String string, String keyName) {
		if (StringUtil.isNotBlank(string)) {
			boolean valid = RulesVerifyUtil.verifyMoney(string);
			if (!valid) {
				logger.error(LogUtils.getCommLog(String.format("%s不正确,金额:%s", keyName, string)));
				throw new InvalidParameterException(String.format("%s不正确", keyName));
			}
		}
	}

	/**
	 * 校验账号(不能包含中文)
	 * @param string
	 * @param keyName
	 */
	public static void checkAccountNo(String string, String keyName) {
		if (StringUtil.isNotBlank(string)) {
			boolean valid = RulesVerifyUtil.verifyChinese(string);
			if (valid) {
				logger.error(LogUtils.getCommLog(String.format("%s不正确,账号:%s", keyName, string)));
				throw new InvalidParameterException(String.format("请输入正确%s", keyName));
			}
		}
	}

	/**
	 * 校验图片地址
	 *
	 * @param imgPath
	 * @param keyName
	 */
	public static void checkImgPath(String imgPath, String keyName) {
		List<String> imgs = StringUtil.getSeparatedStrList(imgPath, StringUtil.COMMA);
		if (CollectionUtils.isNotEmpty(imgs)) {
			for (String img : imgs) {
				if (StringUtils.isBlank(img)) {
					continue;
				}
				boolean valid = RulesVerifyUtil.verifyHttpUrl(img);
				if (!valid) {
					logger.error(LogUtils.getCommLog(String.format("%s不正确,图片地址:%s", keyName, img)));
					throw new InvalidParameterException(String.format("%s有误", keyName));
				}
			}
		}
	}

	/**
	 * 校验图片地址
	 *
	 * @param imgs
	 * @param keyName
	 */
	public static void checkImgPath(List<String> imgs, String keyName) {
		if (CollectionUtils.isNotEmpty(imgs)) {
			for (String img : imgs) {
				if (StringUtils.isBlank(img)) {
					continue;
				}
				boolean valid = RulesVerifyUtil.verifyHttpUrl(img);
				if (!valid) {
					logger.error(LogUtils.getCommLog(String.format("%s不正确,图片地址:%s", keyName, img)));
					throw new InvalidParameterException(String.format("%s有误", keyName));
				}
			}
		}
	}

	/**
	 * 校验单个图片地址
	 *
	 * @param img
	 * @param keyName
	 */
	public static void checkOneImgPath(String img, String keyName) {
		if (StringUtils.isNotBlank(img)) {
			boolean valid = RulesVerifyUtil.verifyHttpUrl(img);
			if (!valid) {
				logger.error(LogUtils.getCommLog(String.format("%s不正确,图片地址:%s", keyName, img)));
				throw new InvalidParameterException(String.format("%s有误", keyName));
			}
		}
	}

	/**
	 * 校验字符串中只有汉字英文字母
	 *
	 * @param str
	 * @param keyName
	 */
	public static void checkOnlyChineseAndEnglishAndNum(String str, String keyName) {

		if (StringUtils.isNotBlank(str)) {
			boolean valid = RulesVerifyUtil.verifyChineseAndEnglishAndNum(str);
			if (!valid) {
				logger.error(LogUtils.getCommLog(String.format("%s不正确,参数:%s", keyName, str)));
				throw new InvalidParameterException(String.format("%s有误", keyName));
			}
		}
	}

	/**
	 * 校验营业执照号
	 *
	 * @param str
	 * @param keyName
	 */
	public static void checkOnlyEnglishAndNum(String str, String keyName) {

		if (StringUtils.isNotBlank(str)) {
			boolean valid = RulesVerifyUtil.verifyEnglishAndNum(str);
			if (!valid) {
				logger.error(LogUtils.getCommLog(String.format("%s不正确,参数:%s", keyName, str)));
				throw new InvalidParameterException(String.format("%s有误", keyName));
			}
		}
	}

	/**
	 * 校验姓名
	 *
	 * @param str
	 * @param keyName
	 */
	public static void checkPeopleName(String str, String keyName) {
		if (StringUtils.isNotBlank(str)) {
			boolean valid = RulesVerifyUtil.verifyUserName(str);
			if (!valid) {
				logger.error(LogUtils.getCommLog(String.format("%s不正确,参数:%s", keyName, str)));
				throw new InvalidParameterException(String.format("%s有误", keyName));
			}
		}
	}

}
