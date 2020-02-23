package com.hit.curricelumdesign.context.enums;

/**
 * 机床;1车床,2铣床,3刨床,4磨床
 */
public enum ToolEnums {

    LATHE(1, "车床"),
    MILLER(2, "铣床"),
    PLANER(3, "刨床"),
    GRINDER(4, "磨床"),
    ;

    private Integer code;
    private String desc;

    ToolEnums(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
