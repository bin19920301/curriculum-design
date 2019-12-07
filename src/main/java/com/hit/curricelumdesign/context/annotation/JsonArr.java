package com.hit.curricelumdesign.context.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description: 表明该字段是JSON字符串，需要解析为List
 * ClassName: JsonArr
 * date: 2018年11月9日
 *
 * @author xbr
 * @version
 * @since JDK 1.8
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonArr {

	/**
	 * 描述信息
	 * @return
	 */
	String message() default "";

	/**
	 * HttpServletRequest中parameter的name
	 * @return
	 */
	String paramName() default "";

	/**
	 * 目标集合中元素类
	 * @return
	 */
	Class<?> type();
}
