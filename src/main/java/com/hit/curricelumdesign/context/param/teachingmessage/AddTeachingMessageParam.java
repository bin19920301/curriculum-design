package com.hit.curricelumdesign.context.param.teachingmessage;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddTeachingMessageParam extends BaseRequestParam {

    /**
     * 内容
     */
    @NotNull
    @Size(max = 215)
    private String content;

    /**
     * 关联的教学id
     */
    private Integer teachingId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getTeachingId() {
        return teachingId;
    }

    public void setTeachingId(Integer teachingId) {
        this.teachingId = teachingId;
    }
}
