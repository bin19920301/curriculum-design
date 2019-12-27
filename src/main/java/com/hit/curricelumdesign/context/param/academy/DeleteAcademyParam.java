package com.hit.curricelumdesign.context.param.academy;

import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.NotNull;

/**
 * @author xbr
 * @Date 2019-12-08
 * @ClassName DeleteAcademyParam
 * @Description
 */
public class DeleteAcademyParam extends BaseRequestParam {
    /**
     * 学院id
     */
    @NotNull
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DeleteAcademyParam{" +
                "id=" + id +
                '}';
    }
}
