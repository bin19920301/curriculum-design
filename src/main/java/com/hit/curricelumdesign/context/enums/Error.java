package com.hit.curricelumdesign.context.enums;

/**
 * Description: 响应结果
 * 				错误编码说明：错误编码共六位，前两位表示错误级别，中间两位为模块，后两位为错误错误编码
 * 				错误级别：10:系统级别，20：服务级别  30:业务级别
 *
 * ClassName: Result
 * date: 2018年11月11日
 *
 * @author YGC
 * @version
 * @since JDK 1.8
 */
public enum Error {

	//----------------------------------------成功
	SUCCESS("0", "success"),

	//----------------------------------------系统
	_100001("100001", "系统错误！"),
	_100002("100002", "未知类型错误！"),
	_100003("100003", "资源未找到！"),
	_100004("100004", "参数校验失败！"),
	_100005("100005", "非法请求！"),
	_100006("100006", "权限校验失败！"),

	//----------------------------------------查询模块
	_200001("200001", "查询数据失败！"),
	_200002("200002", "查询数据无结果！"),
	_200003("200003", "统计数据失败！"),
	_200004("200004", "统计数据无结果！"),
	_200005("200005", "没有权限！"),
	_200006("200006", "SQL语句错误！"),

	//----------------------------------------维护模块
	_200101("200101", "参数为空！"),
	_200102("200102", "参数长度超长，最大:"),
	_200103("200103", "查询无结果！"),
	_200104("200104", "更新失败！"),
	_200105("200105", "删除失败！"),
	_200106("200106", "请输入数字！"),
	_200107("200107", "不能小于1！"),
	_200108("200108", "不能大于100！"),
	_200109("200109", "操作成功！"),
	_200110("200110", "操作失败！"),
	_200111("200111", "添加失败！"),
	_200112("200112", "上传失败！"),
	_200113("200113", "请选择图片！"),
	_200114("200114", "上传图片最大为5M！"),
	_200115("200115", "服务调用失败！"),

	//----------------------------------------用户登录模块
	_200201("200201", "未登录或登录已超时！"),
	_200202("200202", "账号不存在，请重新输入账号"),
	_200203("200203", "密码错误，请重新输入密码"),
	_200204("200204", "登录失败"),
	_200205("200205", "登出失败"),
	_200206("200206", "下线当前登录用户失败"),
	_200207("200207", "原密码错误，请重新输入"),
	_200208("200208", "修改密码失败"),

	//----------------------------------------管理员
	_300001("300001","管理员不存在");

	;



	/**
	 * 错误编码
	 */
	private String errorCode;

	/**
	 * 错误信息
	 */
	private String errorMsg;

	private Error(String errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public static String code(String name){
		return Error.valueOf(name).errorCode;
	}


	public String getErrorMsg() {
		return errorMsg;
	}

	public static String msg(String name){
		return Error.valueOf(name).errorMsg;
	}

}
