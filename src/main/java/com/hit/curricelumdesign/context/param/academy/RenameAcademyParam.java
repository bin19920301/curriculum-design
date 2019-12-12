package com.hit.curricelumdesign.context.param.academy;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author xbr
 * @Date 2019-12-08
 * @ClassName RenameAcademyParam
 * @Description
 */
public class RenameAcademyParam {

    /**
     * 学院id
     */
    @NotNull
    private Integer id;

    /**
     * 学院名称
     */
    @NotNull
    @Size(min = 0,max = 30 ,message = "学院名称")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RenameAcademyParam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
