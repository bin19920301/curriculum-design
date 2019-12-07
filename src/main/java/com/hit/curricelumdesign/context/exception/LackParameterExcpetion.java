package com.hit.curricelumdesign.context.exception;

import com.hit.curricelumdesign.context.enums.Error;

/**
 * Description: 缺少参数异常类
 * ClassName: BaseException
 * date: 2018年11月11日
 *
 * @author YGC
 * @version
 * @since JDK 1.8
 */
public class LackParameterExcpetion extends BaseException {

	private static final long serialVersionUID = -7305673475606021068L;

	public LackParameterExcpetion(String description) {
		super(Error._200101.getErrorCode(), description);
	}
}
