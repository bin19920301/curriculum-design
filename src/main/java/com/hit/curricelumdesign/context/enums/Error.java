package com.hit.curricelumdesign.context.enums;

/**
 * Description: 响应结果
 * 错误编码说明：错误编码共六位，前两位表示错误级别，中间两位为模块，后两位为错误错误编码
 * 错误级别：10:系统级别，20：服务级别  30:业务级别
 * <p>
 * ClassName: Result
 * date: 2018年11月11日
 *
 * @author xbr
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
    LOGIN_STUDENT_NAME_OR_NUMBER_ERROR("200209", "学生姓名或学号错误"),

    //----------------------------------------管理员
    ADMIN_IS_NOT_EXIST("300001", "管理员不存在"),
    ADMIN_NUMBER_IS_EXIST("300002", "管理员编号已存在"),
    ADMIN_PASSWORD_CHECKED_FAIL("300003", "管理员密码校验失败"),
    ADMIN_ONLY_UPDATE_PASSWORD_BY_SELF("300004", "只能本人修改密码"),

    //----------------------------------------学院管理
    ACADEMY_NAME_IS_EXIST("300201", "学院名称已经存在"),
    ACADEMY_IS_NOT_EXIST("300202", "学院不存在"),
    ACADEMY_HAS_STUDENT("300203", "学院下有学生"),
    ACADEMY_HAS_TEACHER("300204", "学院下有老师"),
    ACADEMY_HAS_CLASS("300205", "学院下有班级"),
    CLASS_NAME_IS_EXIST("300206", "班级名称已经存在"),
    CLASS_IS_NOT_EXIST("300207", "班级不存在"),
    CLASS_HAS_STUDENT("300208", "班级下有学生"),
    ENROLLMENTYEAR_IS_EXIST("300209", "入学年份已存在"),
    ENROLLMENTYEAR_IS_NOT_EXIST("300210", "入学年份不存在"),


    //----------------------------------------教师
    TEACHER_IS_NOT_EXIST("300301", "教师信息不存在"),
    TEACHER_ADD_FAILURE("300302", "添加教师信息失败"),
    TEACHER_UPDATE_FAILURE("300303", "更新教师信息失败"),
    TEACHER_DELETE_FAILURE("300304", "删除教师信息失败"),
    TEACHER_RESET_PASSWORD_FAILURE("300305", "重置教师密码失败"),
    TEACHER_NUMBER_IS_EXIST("300306", "教师编号已存在"),
    TEACHER_TEMPLATE_NAME_ERROR("300307", "请使用学生批量导入的默认模板"),
    TEACHER_TEMPLATE_HAS_EMPTY_CELL("300308", "学生模板存在空属性,第%d行"),
    TEACHER_ONLY_UPDATE_PASSWORD_BY_SELF("300309", "只能本人修改密码"),
    TEACHER_PASSWORD_CHECKED_FAIL("300310", "教师密码校验失败"),
	//2020-01-11
	TEACHER_IMPORT_NUMBER_IS_EXIST("300311", "导入教师模板,教师编号%s已存在"),
	TEACHER_IMPORT_ACADEMY_IS_NOT_EXIST("300312", "导入教师模板,学院%s不存在"),
    TEACHER_IMPORT_ERROR("300313", "导入教师信息发生系统错误"),
    TEACHER_TEMPLATE_IS_EMPTY("300314", "导入教师模板为空"),

    //----------------------------------------学生
    STUDENT_IS_NOT_EXIST("300401", "学生信息不存在"),
    STUDENT_ADD_FAILURE("300402", "添加学生信息失败"),
    STUDENT_UPDATE_FAILURE("300403", "更新学生信息失败"),
    STUDENT_DELETE_FAILURE("300404", "删除学生信息失败"),
    STUDENT_NUMBER_IS_EXIST("300405", "学生编号已存在"),
    STUDENT_TEMPLATE_NAME_ERROR("300406", "请使用学生批量导入的默认模板"),
    STUDENT_TEMPLATE_HAS_EMPTY_CELL("300407", "学生模板存在空属性,第%d行"),
    STUDENT_IMPORT_NUMBER_IS_EXIST("300408", "导入学生模板,学生编号%s已存在"),
    STUDENT_IMPORT_CLASS_IS_NOT_BELONG_ACADEMY("300409", "导入学生模板,班级%s不在学院%s下"),
    STUDENT_IMPORT_ENROLLMENT_YEAR_IS_NOT_EXIST("300410", "导入学生模板,入学年份%s不存在"),
    STUDENT_IMPORT_ACADEMY_IS_NOT_EXIST("300411", "导入学生模板,学院%s不存在"),
    STUDENT_IMPORT_CLASS_IS_NOT_EXIST("300412", "导入学生模板,班级%s不存在"),
    STUDENT_IMPORT_ERROR("300413", "导入学生信息发生系统错误"),
    STUDENT_TEMPLATE_IS_EMPTY("300414", "导入学生模板为空"),

    //----------------------------------------文件夹
    FOLDER_NAME_IS_EXIST("300501", "文件夹名称已存在"),
    FOLDER_IS_NOT_EXIST("300502", "文件夹不存在"),
    FOLDER_HAS_FILES("300503", "文件夹下存在文件，不可删除"),

    //----------------------------------------文件
    FILE_UPLOAD_FAILURE("300601", "文件上传失败"),
    FILE_DOWNLOAD_FAILURE("300602", "文件下载失败"),
    FILE_IS_NOT_EXIST("300603", "文件不存在"),

    //----------------------------------------作业项目
    WORK_PROJECT_NAME_IS_EXIST("300701", "作业项目名称已经存在"),
    WORK_PROJECT_NEED_ASSOCIATE_FILE("300702", "作业项目的资料不能为空"),
    WORK_PROJECT_ASSOCIATE_FILE_HAS_NOT_EXIST("300703", "作业项目关联了不存在的资料"),
    WORK_PROJECT_IS_NOT_EXIST("300704", "作业项目不存在"),
    WORK_CAN_NOT_DELETE_IN_USING("300705", "该作业项目已使用,请勿删除"),
    FINISHED_SURFACE_SURFACE_ID_IS_EXIST("300706","表面id已存在"),
    FINISHED_SURFACE_IS_NOT_EXIST("300707","表面不存在"),

    //----------------------------------------教学
    TEACHER_REMINDER_OVER_LENGTH("300801", "教师提示超长，应不超过500字"),
    TEACHING_NAME_IS_EXIST("300802", "教学名称已存在"),
    TEACHING_IS_NOT_EXIST("300806", "教学不存在"),

    //----------------------------------------作业
    WORK_IS_NOT_EXIST("300901", "作业不存在"),
    WORK_IS_NOT_SUBMIT("300902", "作业不是提交状态"),
    WORK_IS_SUBMIT("300903", "作业已提交"),
    WORK_IS_RETURN("300904", "作业已退回"),
    WORK_IS_DONE("300905", "作业已完成"),


    //----------------------------------------作业消息
    WORK_MESSAGE_IS_NOT_EXIST("3010001", "作业消息不存在"),

    //----------------------------------------教师消息
    TEACHER_MESSAGE_IS_NOT_EXIST("3011001", "教师消息不存在"),
    TEACHER_MESSAGE_ONLY_DELETE_BY_SELF("3011002", "教师信息只能由本人删除"),

    //----------------------------------------教学消息
    TEACHING_MESSAGE_IS_NOT_EXIST("3012001", "教学消息不存在"),
    TEACHING_MESSAGE_ONLY_DELETE_BY_SELF("3012002", "教学信息只能由本人删除"),

    //----------------------------------------工艺卡片
    CARD_IS_NOT_EXIST("3013001", "工艺卡片不存在"),


    //----------------------------------------加工机床ID转换
    TOOL_CODE_ERROR("3014001", "加工机床id不在1~26之间"),
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

    public static String code(String name) {
        return Error.valueOf(name).errorCode;
    }


    public String getErrorMsg() {
        return errorMsg;
    }

    public static String msg(String name) {
        return Error.valueOf(name).errorMsg;
    }

}
