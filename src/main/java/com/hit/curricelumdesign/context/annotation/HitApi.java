package com.hit.curricelumdesign.context.annotation;

import java.lang.annotation.*;

/**
 * Description: 接口属性
 * ClassName: OssApi
 * date: 2018年11月20日
 *
 * @author YGC
 * @version
 * @since JDK 1.8
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HitApi {

	/**
	 * 是否需要登录校验
	 */
	boolean checkLogin() default false;

	/**
	 * 是否需要校验权限
	 */
	boolean checkPrivilege() default false;

	/**
	 * 指定校验权限接口名(默认为接口自身，可以指定为其他接口)
	 */
	String privilegeApiName() default "";
}
