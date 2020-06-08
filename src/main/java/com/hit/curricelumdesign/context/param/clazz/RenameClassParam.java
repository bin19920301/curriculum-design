package com.hit.curricelumdesign.context.param.clazz;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author xbr
 * @Date 2019-12-09
 * @ClassName RenameClassParam
 * @Description
 */
public class RenameClassParam extends BaseRequestParam {

    /**
     * 班级id
     */
    @NotNull
    private Integer classId;

    /**
     * 班级名称
     */
    @NotNull
    @Size(min = 0, max = 30, message = "班级名称")
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
