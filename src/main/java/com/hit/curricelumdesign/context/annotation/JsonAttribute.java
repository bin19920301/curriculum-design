package com.hit.curricelumdesign.context.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description: 表明该对象中包含需要进行JSON解析的字段
 * ClassName: JsonAttribute
 * date: 2018年11月9日
 *
 * @author xbr
 * @version
 * @since JDK 1.8
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonAttribute {
}
