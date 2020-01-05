package com.hit.curricelumdesign.context.param.TeacherMessage;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author xbr
 * @Date 2019-12-21
 * @ClassName AddWorkMessageByStudentParam
 * @Description
 */
public class AddTeacherMessageParam extends BaseRequestParam {

    /**
     * 内容
     */
    @NotNull
    @Size(max = 215)
    private String content;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
