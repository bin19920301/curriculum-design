package com.hit.curricelumdesign.context.param;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Description: 基础分页入参类
 * ClassName: BaseListRequestParam
 * date: 2018年11月11日
 *
 * @author xbr
 * @version
 * @since JDK 1.8
 */
public class BaseListRequestParam extends BaseRequestParam {

	/**
	* 分页序号
	*/
	@NotNull(message = "分页序号")
	@Min(value = 1, message = "分页序号")
	private Integer pageNum;

	/**
	 * 分页大小
	 */
	@NotNull(message = "分页大小")
	@Min(value = 1, message = "分页大小")
	private Integer pageSize;

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "BaseListRequestParam [pageNum=" + pageNum + ", pageSize=" + pageSize + "]";
	}

}
