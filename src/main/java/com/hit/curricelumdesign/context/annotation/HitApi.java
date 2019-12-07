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
	 * 是否需要登录管理员端校验
	 */
	boolean checkAdminLogin() default false;

	/**
	 * 是否需要登录教师端校验
	 */
	boolean checkTeacherLogin() default false;

	/**
	 * 是否需要登录学生端校验
	 */
	boolean checkStudentLogin() default false;


	/**
	 * 指定校验权限接口名(默认为接口自身，可以指定为其他接口)
	 */
	String privilegeApiName() default "";
}
