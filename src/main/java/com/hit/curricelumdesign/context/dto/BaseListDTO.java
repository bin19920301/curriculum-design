package com.hit.curricelumdesign.context.dto;

import java.util.List;

/**
 * Description: 列表返回
 * ClassName: BaseListDto
 * date: 2018年11月21日
 *
 * @author YGC
 * @version
 * @param <T>
 * @since JDK 1.8
 */
public class BaseListDTO<T> {

	public BaseListDTO(long total, List<T> list) {
		this.total = total;
		this.list = list;
	}

	/**
	 * 总数量
	 */
	private long total;

	/**
	 * 列表
	 */
	private List<T> list;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "BaseListDTO [total=" + total + ", list=" + list + "]";
	}

}
