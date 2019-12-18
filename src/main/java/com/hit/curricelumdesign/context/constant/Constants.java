package com.hit.curricelumdesign.context.constant;

/**
 * Description: 常量类
 * ClassName: Constants
 * date: 2018年11月11日
 *
 * @author xbr
 * @since JDK 1.8
 */
public class Constants {
    /**
     * 通用参数
     */
    public static class Common {

        public static final String DEFAULT_CHARSET_NAME = "UTF-8"; // 默认字符集

        public static final int NOT = 0; // 否

        public static final int YES = 1; // 是

        public static final Boolean IS_NOT = false; // 否

        public static final Boolean IS_YES = true; // 是
    }

    public static class Token {
        //类型
        public static final int TYPE_ADMIN = 1;//管理员
        public static final int TYPE_TEACHER = 2;//教师
        public static final int TYPE_STUDENT = 3;//学生
    }
}
