package com.hit.curricelumdesign.context.param.work;

import com.hit.curricelumdesign.context.annotation.EnumField;
import com.hit.curricelumdesign.context.param.BaseListRequestParam;

import javax.validation.constraints.NotNull;

/**
 * @author xbr
 * @Date 2019-12-25
 * @ClassName GetWorkListByStudentIdParam
 * @Description
 */
public class GetWorkListByStudentIdParam extends BaseListRequestParam {

    /**
     * 是否完成 0未完成 1已完成
     */
    @NotNull
    @EnumField(range = "0,1")
    private Integer isDone;

    public Integer getIsDone() {
        return isDone;
    }

    public void setIsDone(Integer isDone) {
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return "GetWorkListByStudentIdParam{" +
                "isDone=" + isDone +
                '}';
    }
}
