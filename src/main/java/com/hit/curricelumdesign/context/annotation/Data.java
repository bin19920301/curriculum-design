package com.hit.curricelumdesign.context.annotation;

import java.lang.annotation.*;

/**
 * Description: 自定义参数解析注解
 * ClassName: ReqBody.java
 * date: 2018年11月30日
 *
 * @author xbr
 * @version
 * @since JDK 1.8
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Data {

}
