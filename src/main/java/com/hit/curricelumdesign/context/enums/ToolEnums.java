package com.hit.curricelumdesign.context.enums;

import com.hit.curricelumdesign.context.exception.BaseException;

/**
 * 机床;1车床,2铣床,3刨床,4磨床,5钻床,6铰床
 */
public enum ToolEnums {

    LATHE(1, "车床", "a"),
    MILLER(2, "铣床", "b"),
    PLANER(3, "刨床", "c"),
    GRINDER(4, "磨床", "d"),
    DRILLING(5, "钻床", "e"),
    REAMING(6, "铰床", "f"),
    ;

    private Integer code;
    private String desc;
    private String type;

    ToolEnums(Integer code, String desc, String type) {
        this.code = code;
        this.desc = desc;
        this.type = type;
    }

    public static String getTypeByCode(int intValue) {
        for (ToolEnums value : ToolEnums.values()) {
            if (value.code == intValue) {
                return value.type;
            }
        }
        return null;
    }
}
