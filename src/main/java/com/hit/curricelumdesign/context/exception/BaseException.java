
package com.hit.curricelumdesign.context.exception;

import com.hit.curricelumdesign.context.enums.Error;

/**
 * Description: 基础异常类
 * ClassName: BaseException
 * date: 2018年11月11日
 *
 * @author xbr
 * @version
 * @since JDK 1.8
 */
public class BaseException extends RuntimeException {

	private static final long serialVersionUID = -8964389197754846174L;

	private String errorcode;

	private String description;

	public BaseException() {

	}

	public BaseException(String errorcode, String description) {
		super(description);
		this.errorcode = errorcode;
		this.description = description;
	}

	public BaseException(Error error) {
		super(error.getErrorMsg());
		this.errorcode = error.getErrorCode();
		this.description = error.getErrorMsg();
	}

	public String getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
