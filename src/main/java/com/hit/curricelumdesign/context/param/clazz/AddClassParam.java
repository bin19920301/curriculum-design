package com.hit.curricelumdesign.context.param.clazz;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.NotNull;

/**
 * @author xbr
 * @Date 2019-12-09
 * @ClassName AddClassParam
 * @Description
 */
public class AddClassParam extends BaseRequestParam {

    /**
     * 学院id
     */
    @NotNull
    private Integer academyId;

    /**
     * 班级名称
     */
    @NotNull
    private String name;

    public Integer getAcademyId() {
        return academyId;
    }

    public void setAcademyId(Integer academyId) {
        this.academyId = academyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AddClassParam{" +
                "academyId=" + academyId +
                ", name='" + name + '\'' +
                '}';
    }
}
