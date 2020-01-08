package com.hit.curricelumdesign.context.param.academy;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author xbr
 * @Date 2019-12-08
 * @ClassName AddAcademyParam
 * @Description
 */
public class AddAcademyParam extends BaseRequestParam {

    /**
     * 学院名称
     */
    @NotNull
    @Size(min = 0,max = 30 ,message = "学院名称")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AddAcademyParam{" +
                "name='" + name + '\'' +
                '}';
    }
}
