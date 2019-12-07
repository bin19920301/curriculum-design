package com.hit.curricelumdesign.context.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description: 表明该字段是日期字符串，需要解析为java Date对象
 * ClassName: DateObj
 * date: 2018年11月9日
 *
 * @author xbr
 * @version
 * @since JDK 1.8
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DateObj {

	/**
	 * 描述信息
	 * @return
	 */
	String message() default "";
}
