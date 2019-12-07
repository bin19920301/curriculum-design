package com.hit.curricelumdesign.context.exception;

import com.hit.curricelumdesign.context.enums.Error;

/**
 * Description: 服务调用异常类
 * ClassName: BaseException
 * date: 2018年11月11日
 *
 * @author YGC
 * @version
 * @since JDK 1.8
 */
public class ServiceInvokeFailException extends BaseException {

	private static final long serialVersionUID = -7305673475606021068L;

	public ServiceInvokeFailException() {
		super(Error._200115.getErrorCode(), Error._200115.getErrorMsg());
	}

	public ServiceInvokeFailException(String description) {
		super(Error._200115.getErrorCode(), description);
	}
}
