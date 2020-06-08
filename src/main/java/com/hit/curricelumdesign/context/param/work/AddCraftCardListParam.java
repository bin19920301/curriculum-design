package com.hit.curricelumdesign.context.param.work;

import com.hit.curricelumdesign.context.annotation.JsonArr;
import com.hit.curricelumdesign.context.param.BaseRequestParam;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author xbr
 * @Date 2019-12-22
 * @ClassName AddCraftCardParam
 * @Description
 */
public class AddCraftCardListParam extends BaseRequestParam {

    /**
     * 工艺卡片列表
     */
    @JsonArr(type = AddCraftCardParam.class, paramName = "list")
    List<AddCraftCardParam> list;

    /**
     * 作业id
     */
    @NotNull
    private Integer workId;

    public List<AddCraftCardParam> getList() {
        return list;
    }

    public void setList(List<AddCraftCardParam> list) {
        this.list = list;
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    @Override
    public String toString() {
        return "AddCraftCardListParam{" +
                "list=" + list +
                ", workId=" + workId +
                '}';
    }
}
