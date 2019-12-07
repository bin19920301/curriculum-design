package com.hit.curricelumdesign.aop;

import com.hit.curricelumdesign.context.annotation.EnumField;
import com.hit.curricelumdesign.context.annotation.IfNotNull;
import com.hit.curricelumdesign.context.annotation.MoreThan;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.context.exception.LackParameterExcpetion;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.utils.BeanUtil;
import com.hit.curricelumdesign.utils.DateUtil;
import com.hit.curricelumdesign.utils.LogUtils;
import com.hit.curricelumdesign.utils.StringUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.validation.constraints.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;

/**
 * Description: 入参校验AOP
 * ClassName: ParamValidationAop
 * date: 2018年11月11日
 *
 * @author xbr
 * @version
 * @since JDK 1.8
 */
@Aspect
@Order(3)
@Component
public class ParamValidationAop {

	private static Log logger = LogFactory.getLog(ParamValidationAop.class);

	@Pointcut("execution(public * com.hit.curricelumdesign..controller..*.*(..))")
	public void paramValidation() {

	}

	@Around("paramValidation()")
	public Result handle(ProceedingJoinPoint pjp) throws Throwable {
		Object[] args = pjp.getArgs();
		if (args != null && args.length > 0) {
			for (Object arg : args) {
				logger.info(LogUtils.getCommLog(String.format("param:%s", arg)));
				// 获取需要校验的类
				List<Class<?>> clazzs = BeanUtil.getSuperClasses(arg.getClass());

				// 分别校验各个类中加有注解的字段
				if (CollectionUtils.isNotEmpty(clazzs)) {
					for (int i = 0; i < clazzs.size(); i++) {
						varify(arg, clazzs.get(i));
					}
				}
			}
		}
		return (Result) pjp.proceed();
	}

	/**
	 * 获取属性对用的getter
	 *
	 * @param fieldName
	 * @param clazz
	 * @return
	 * @throws NoSuchMethodException
	 */
	private Method getMethodByFieldName(String fieldName, Class<?> clazz) throws NoSuchMethodException {
		String charAtFirst = fieldName.substring(0, 1);
		String methodName = "get" + fieldName.replaceFirst(charAtFirst, charAtFirst.toUpperCase());
		return clazz.getDeclaredMethod(methodName);
	}

	/**
	 * 校验
	 *
	 * @param arg
	 * @param clazz
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws NoSuchFieldException
	 */
	private void varify(Object arg, Class<?> clazz)
			throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			varifyNotNull(arg, field, clazz);
			varifyIfNotNull(arg, field, clazz);
			varifyNotBlank(arg, field, clazz);
			varifyNotEmpty(arg, field, clazz);
			varifySize(arg, field, clazz);
			varifyNumberRange(arg, field, clazz);
			varifyEnum(arg, field, clazz);
			varifyComparation(arg, field, clazz);
			varifyPattren(arg, field, clazz);
		}
	}

	/**
	 * 对象非空校验
	 *
	 * @param arg
	 * @param clazz
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 */
	private void varifyNotNull(Object arg, Field field, Class<?> clazz)
			throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
		// 非空校验
		if (field.isAnnotationPresent(NotNull.class)) {
			Method method = getMethodByFieldName(field.getName(), clazz);
			Object obj = method.invoke(arg);
			if (obj == null) {
				throw new LackParameterExcpetion("缺少参数:" + field.getName());
			}
		}
	}

	/**
	 * 如果对象非空校验
	 *
	 * @param arg
	 * @param clazz
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 */
	private void varifyIfNotNull(Object arg, Field field, Class<?> clazz)
			throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException {
		// 如果对象非空校验
		if (field.isAnnotationPresent(IfNotNull.class)) {
			Class<?> type = field.getType();
			field.setAccessible(true);

			if (field.get(arg) != null) {
				varify(field.get(arg), type);
			}
		}
	}

	/**
	 * 字符串非空校验
	 *
	 * @param arg
	 * @param clazz
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 */
	private void varifyNotBlank(Object arg, Field field, Class<?> clazz)
			throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
		// 非空校验
		if (field.isAnnotationPresent(NotBlank.class)) {
			Method method = getMethodByFieldName(field.getName(), clazz);
			Object obj = method.invoke(arg);
			if ((obj == null) || (obj instanceof String && StringUtil.isBlank((String) obj))) {
				throw new LackParameterExcpetion("缺少参数:" + field.getName());
			}
		}
	}

	/**
	 * 对象内容非空校验
	 *
	 * @param arg
	 * @param clazz
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 */
	private void varifyNotEmpty(Object arg, Field field, Class<?> clazz)
			throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException {
		// 非空校验
		if (field.isAnnotationPresent(NotEmpty.class)) {
			Method method = getMethodByFieldName(field.getName(), clazz);
			Object obj = method.invoke(arg);
			if (obj != null && obj instanceof List) {
				List<?> list = (List<?>) obj;
				if (CollectionUtils.isNotEmpty(list)) {
					for (Object element : list) {
						List<Class<?>> classes = BeanUtil.getSuperClasses(element.getClass());
						for (Class<?> aClass : classes) {
							varify(element, aClass);
						}
					}
				}
			}
		}
	}

	/**
	 * 长度校验
	 *
	 * @param arg
	 * @param clazz
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	private void varifySize(Object arg, Field field, Class<?> clazz)
			throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		if (field.isAnnotationPresent(Size.class)) {
			Method method = getMethodByFieldName(field.getName(), clazz);
			Size size = field.getAnnotation(Size.class);
			int max = size.max();
			int min = size.min();
			Object obj = method.invoke(arg);
			if (obj != null) {
				if (obj instanceof String) {
					String value = (String) obj;
					if (value.length() > max) {
						throw new BaseException(Error._100004.getErrorCode(),
								size.message() + "超出最长" + max + "字符长度限制");
					}
					if (value.trim().length() < min) {
						throw new BaseException(Error._100004.getErrorCode(),
								size.message() + "小于最小" + min + "字符长度限制");
					}
				}
				if (obj instanceof List) {
					List<?> list = (List<?>) obj;
					if (list.size() > max) {
						throw new BaseException(Error._100004.getErrorCode(), size.message() + "超出最长" + max + "长度限制");
					}

					if (list.size() < min) {
						throw new BaseException(Error._100004.getErrorCode(), size.message() + "小于最小" + min + "长度限制");
					}
				}
				if (obj instanceof String[]) {
					String[] array = (String[]) obj;
					if (array.length > max) {
						throw new BaseException(Error._100004.getErrorCode(), size.message() + "超出最多" + max + "张限制");
					}

					if (array.length < min) {
						throw new BaseException(Error._100004.getErrorCode(), size.message() + "小于最少" + min + "张限制");
					}
				}

				if (obj instanceof Long[]) {
					Long[] array = (Long[]) obj;
					if (array.length > max) {
						throw new BaseException(Error._100004.getErrorCode(), size.message() + "超出最多" + max + "个限制");
					}

					if (array.length < min) {
						throw new BaseException(Error._100004.getErrorCode(), size.message() + "小于最少" + min + "个限制");
					}
				}
			}
		}
	}

	/**
	 * 数值范围校验
	 *
	 * @param arg
	 * @param clazz
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	private void varifyNumberRange(Object arg, Field field, Class<?> clazz)
			throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		if (field.isAnnotationPresent(Max.class)) {
			Method method = getMethodByFieldName(field.getName(), clazz);
			Max max = field.getAnnotation(Max.class);
			long maxValue = max.value();
			Number value = (Number) method.invoke(arg);
			if (value != null && value.doubleValue() > maxValue) {
				throw new BaseException(Error._100004.getErrorCode(), max.message() + "大于" + maxValue);
			}
		}
		if (field.isAnnotationPresent(Min.class)) {
			Method method = getMethodByFieldName(field.getName(), clazz);
			Min min = field.getAnnotation(Min.class);
			long minValue = min.value();
			Number value = (Number) method.invoke(arg);
			if (value != null && value.doubleValue() < minValue) {
				throw new BaseException(Error._100004.getErrorCode(), min.message() + "小于" + minValue);
			}
		}
	}

	/**
	 * 枚举值校验
	 *
	 * @param arg
	 * @param clazz
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	private void varifyEnum(Object arg, Field field, Class<?> clazz)
			throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		if (field.isAnnotationPresent(EnumField.class)) {
			Method method = getMethodByFieldName(field.getName(), clazz);
			EnumField enumField = field.getAnnotation(EnumField.class);
			String range = enumField.range();
			if (StringUtil.isNotBlank(range)) {
				Integer value = (Integer) method.invoke(arg);
				String[] values = range.split(",");
				List<String> valueList = Arrays.asList(values);
				if (value != null && !valueList.contains(value.toString())) {
					throw new BaseException(Error._100004.getErrorCode(), field.getName() + "参数不合法");
				}
			}
		}
	}

	/**
	 * 大小值比较校验,只能比较数值类型和日期类型
	 *
	 * @param arg
	 * @param clazz
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	private void varifyComparation(Object arg, Field field, Class<?> clazz)
			throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
		if (field.isAnnotationPresent(MoreThan.class)) {
			Method method = getMethodByFieldName(field.getName(), clazz);
			MoreThan target = field.getAnnotation(MoreThan.class);
			String targetFieldName = target.target();
			if (StringUtil.isNotBlank(targetFieldName)) {
				Class<?> type = field.getType();
				if (Number.class.isAssignableFrom(type)) {
					Number num = (Number) method.invoke(arg);
					Field targetField = clazz.getDeclaredField(targetFieldName);
					targetField.setAccessible(true);
					Number targetNum = (Number) targetField.get(arg);
					if (num != null && targetNum != null && num.doubleValue() < targetNum.doubleValue()) {
						throw new BaseException(Error._100004.getErrorCode(),
								target.message() + "不能小于" + target.targetMessage());
					}
				}
				if (Date.class.isAssignableFrom(type)) {
					Date date = (Date) method.invoke(arg);
					Field targetField = clazz.getDeclaredField(targetFieldName);
					targetField.setAccessible(true);
					Date targetDate = (Date) targetField.get(arg);
					if (date != null && targetDate != null && DateUtil.afterInDay(targetDate, date)) {
						throw new BaseException(Error._100004.getErrorCode(),
								target.message() + "不能早于" + target.targetMessage());
					}
				}
				if (String.class.isAssignableFrom(type)) {
					String num = (String) method.invoke(arg);
					Field targetField = clazz.getDeclaredField(targetFieldName);
					targetField.setAccessible(true);
					String targetNum = (String) targetField.get(arg);
					if (num != null && targetNum != null) {
						Double d1, d2;
						try {
							d1 = Double.valueOf(num);
						} catch (NumberFormatException e) {
							logger.info(LogUtils.getCommLog(String.format("@MoreThan不支持该数据：%s", num)));
							return;
						}

						try {
							d2 = Double.valueOf(targetNum);
						} catch (NumberFormatException e) {
							logger.info(LogUtils.getCommLog(String.format("@MoreThan不支持该数据：%s", targetNum)));
							return;
						}

						if (d1 < d2) {
							throw new BaseException(Error._100004.getErrorCode(),
									target.message() + "不能小于" + target.targetMessage());
						}
					}
				}
			}
		}
	}

	/**
	 * 正则校验
	 *
	 * @param arg
	 * @param clazz
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */

	private void varifyPattren(Object arg, Field field, Class<?> clazz)
			throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		if (field.isAnnotationPresent(Pattern.class)) {
			Method method = getMethodByFieldName(field.getName(), clazz);
			Object obj = method.invoke(arg);
			String str = (String) obj;
			if (StringUtil.isNotEmpty(str)) {
				if (String.class.isAssignableFrom(obj.getClass())) {
					Pattern pattern = field.getAnnotation(Pattern.class);
					String regexp = pattern.regexp();
					java.util.regex.Pattern p = java.util.regex.Pattern.compile(regexp);
					Matcher m = p.matcher(str);
					boolean isMatch = m.matches();
					if (!isMatch) {
						throw new BaseException(Error._100004.getErrorCode(), str + pattern.message());
					}
				}
			}

		}
	}
}
