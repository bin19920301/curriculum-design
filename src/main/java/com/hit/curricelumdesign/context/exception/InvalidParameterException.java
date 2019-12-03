package com.hit.curricelumdesign.context.exception;

import com.hit.curricelumdesign.context.enums.Error;

/**
 * Description: 非法参数异常
 * ClassName: BaseException
 * date: 2018年11月11日
 *
 * @author YGC
 * @version
 * @since JDK 1.8
 */
public class InvalidParameterException extends BaseException {

	private static final long serialVersionUID = -3883814863434936445L;

	public InvalidParameterException(String msg) {
		super(Error._06410004.getErrorCode(), msg);
	}
}
