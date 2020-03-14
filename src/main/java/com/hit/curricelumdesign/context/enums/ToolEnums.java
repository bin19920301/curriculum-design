package com.hit.curricelumdesign.context.enums;

import com.hit.curricelumdesign.context.exception.BaseException;

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

    public static Character intToChar(int intValue){
        if (intValue <1 || intValue >26 ){
            throw new BaseException(Error.TOOL_CODE_ERROR);
        }
        return (char)(intValue + 96);
    }
}
