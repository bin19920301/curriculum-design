package com.hit.curricelumdesign.context.param.academy;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

/**
 * @author xbr
 * @Date 2019-12-08
 * @ClassName AddAcademyParam
 * @Description
 */
public class AddAcademyParam {

    /**
     * 学院名称
     */
    @NotNull
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
