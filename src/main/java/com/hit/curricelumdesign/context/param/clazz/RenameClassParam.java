package com.hit.curricelumdesign.context.param.clazz;

import javax.validation.constraints.NotNull;

/**
 * @author xbr
 * @Date 2019-12-09
 * @ClassName RenameClassParam
 * @Description
 */
public class RenameClassParam {

    /**
     * 班级id
     */
    @NotNull
    private Integer classId;

    /**
     * 班级名称
     */
    @NotNull
    private String name;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RenameClassParam{" +
                "classId=" + classId +
                ", name='" + name + '\'' +
                '}';
    }
}
