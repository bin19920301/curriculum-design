package com.hit.curricelumdesign.context.response;

import com.hit.curricelumdesign.context.enums.Error;

/**
 * Description: 响应状态
 * ClassName: Status
 * date: 2018年11月11日
 *
 * @author YGC
 * @version
 * @since JDK 1.8
 */
public class Status {

	/**
	 * 状态码
	 */
	private String code;

	/**
	 * 错误描述
	 */
	private String description;

	public Status() {
		this(Error.SUCCESS.getErrorCode(), Error.SUCCESS.getErrorMsg());
	}

	public Status(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Status [code=" + code + ", description=" + description + "]";
	}

}
