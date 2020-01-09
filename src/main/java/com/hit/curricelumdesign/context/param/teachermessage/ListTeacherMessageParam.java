package com.hit.curricelumdesign.context.param.teachermessage;

import com.hit.curricelumdesign.context.param.BaseListRequestParam;

/**
 * @author xbr
 * @Date 2020-01-08
 * @ClassName ListTeacherMessageParam
 * @Description
 */
public class ListTeacherMessageParam extends BaseListRequestParam {

    /**
     * 起始id
     */
    private Integer startId;

    public Integer getStartId() {
        return startId;
    }

    public void setStartId(Integer startId) {
        this.startId = startId;
    }

    @Override
    public String toString() {
        return "ListTeacherMessageParam{" +
                "startId=" + startId +
                '}';
    }
}
