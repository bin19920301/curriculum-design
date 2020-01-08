package com.hit.curricelumdesign.context.param.clazz;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.NotNull;

/**
 * @author xbr
 * @Date 2019-12-09
 * @ClassName GetClassByAcademyIdParam
 * @Description
 */
public class GetClassByAcademyIdParam extends BaseRequestParam {

    /**
     * 学院id
     */
    @NotNull
    private Integer academyId;

    public Integer getAcademyId() {
        return academyId;
    }

    public void setAcademyId(Integer academyId) {
        this.academyId = academyId;
    }

    @Override
    public String toString() {
        return "GetClassByAcademyIdParam{" +
                "academyId=" + academyId +
                '}';
    }
}
