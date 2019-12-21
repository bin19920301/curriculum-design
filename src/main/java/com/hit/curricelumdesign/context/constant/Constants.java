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

    /**
     * 登录token
     */
    public static class Token {
        //类型
        public static final int TYPE_ADMIN = 1;//管理员
        public static final int TYPE_TEACHER = 2;//教师
        public static final int TYPE_STUDENT = 3;//学生
    }

    /**
     * 作业
     */
    public static class Work {

        /**
         * 作业状态
         */
        public enum WorkStatus {
            NOT_SUBMIT(0, "未提交"),
            SUBMIT(1, "已提交"),
            RETURN(2, "已退回"),
            DONE(3, "已完成"),
            ;

            /**
             * 状态
             */
            private Integer status;

            /**
             * 描述
             */
            private String desc;

            private WorkStatus(Integer status, String desc) {
                this.status = status;
                this.desc = desc;
            }

            private WorkStatus() {
            }

            public Integer getStatus() {
                return status;
            }

            public void setStatus(Integer status) {
                this.status = status;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }
        }
    }

    public static class WorkMessage {

        //发送者类型
        //学生
        public static final Integer SENDER_TYPE_STUDENT = 1;
        //教师
        public static final Integer SENDER_TYPE_TEACHER = 2;

        //接受者类型
        //学生
        public static final Integer RECEIVER_TYPE_STUDENT = 1;
        //老师
        public static final Integer RECEIVER_TYPE_TEACHER = 2;
    }

}
