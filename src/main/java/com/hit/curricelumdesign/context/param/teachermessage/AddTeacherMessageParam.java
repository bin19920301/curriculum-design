package com.hit.curricelumdesign.context.param.teachermessage;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddTeacherMessageParam extends BaseRequestParam {

    /**
     * 内容
     */
    @NotNull
    @Size(max = 300)
    private String content;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AddTeacherMessageParam{" +
                "content='" + content + '\'' +
                '}';
    }
}
