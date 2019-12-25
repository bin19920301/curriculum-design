package com.hit.curricelumdesign.context.dto.work;

import com.hit.curricelumdesign.context.dto.teaching.WorkTeachingDTO;

/**
 * @author xbr
 * @Date 2019-12-25
 * @ClassName WorkInfoListDTO
 * @Description
 */
public class WorkInfoListDTO {


    private Integer workId;

    private Integer status;

    private WorkTeachingDTO workTeachingDTO;

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public WorkTeachingDTO getWorkTeachingDTO() {
        return workTeachingDTO;
    }

    public void setWorkTeachingDTO(WorkTeachingDTO workTeachingDTO) {
        this.workTeachingDTO = workTeachingDTO;
    }

    @Override
    public String toString() {
        return "WorkInfoListDTO{" +
                "workId=" + workId +
                ", status=" + status +
                ", workTeachingDTO=" + workTeachingDTO +
                '}';
    }
}
