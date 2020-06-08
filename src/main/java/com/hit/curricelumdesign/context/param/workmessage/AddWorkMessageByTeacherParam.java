package com.hit.curricelumdesign.context.param.workmessage;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author xbr
 * @Date 2019-12-21
 * @ClassName AddWorkMessageByTeacherParam
 * @Description
 */
public class AddWorkMessageByTeacherParam extends BaseRequestParam {

    /**
     * 作业id
     */
    @NotNull
    private Integer workId;

    /**
     * 内容
     */
    @NotNull
    @Size(max = 215)
    private String content;

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AddWorkMessageByTeacherParam{" +
                "workId=" + workId +
                ", content='" + content + '\'' +
                '}';
    }
}
