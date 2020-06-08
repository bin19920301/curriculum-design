package com.hit.curricelumdesign.context.param.workmessage;

import com.hit.curricelumdesign.context.annotation.EnumField;
import com.hit.curricelumdesign.context.param.BaseListRequestParam;
import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.NotNull;

/**
 * @author xbr
 * @Date 2019-12-22
 * @ClassName GetStudentMessageParam
 * @Description
 */
public class GetStudentMessageParam extends BaseListRequestParam {

    /**
     * 是否阅读 0:否 1:是
     */
    @NotNull
    @EnumField(range = "0,1")
    private Integer read;

    public Integer getRead() {
        return read;
    }

    public void setRead(Integer read) {
        this.read = read;
    }

    @Override
    public String toString() {
        return "GetStudentMessageParam{" +
                "read=" + read +
                '}';
    }
}
