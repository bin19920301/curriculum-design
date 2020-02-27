package com.hit.curricelumdesign.context.dto.work;

import com.hit.curricelumdesign.context.dto.card.CardDTO;
import com.hit.curricelumdesign.context.dto.craftcard.CraftCardInfoDTO;
import com.hit.curricelumdesign.context.dto.teaching.WorkTeachingDTO;
import com.hit.curricelumdesign.context.dto.workfile.WorkFileDTO;
import com.hit.curricelumdesign.context.dto.workmessage.WorkMessageInfoDTO;
import com.hit.curricelumdesign.context.dto.workproject.WorkProjectInfoDTO;
import com.hit.curricelumdesign.context.entity.WorkFile;

import java.util.List;

/**
 * @author xbr
 * @Date 2019-12-23
 * @ClassName WorkInfoDTO
 * @Description
 */
public class WorkInfoDTO {

    private Integer workId;

    private Integer status;

    private String studentName;

    private WorkTeachingDTO teaching;

    private WorkProjectInfoDTO workProjectInfoDTO;

    //private List<CraftCardInfoDTO> craftCardInfoDTOList;

    private List<WorkFileDTO> workFileDTOList;

    //2020-02-23 注释掉上面两行LIST属性,新的属性包含在cardDTO中
    //2020-02-23 新增card接口,这里不再需要card信息
    //private CardDTO cardDTO;


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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public WorkTeachingDTO getTeaching() {
        return teaching;
    }

    public void setTeaching(WorkTeachingDTO teaching) {
        this.teaching = teaching;
    }

    public WorkProjectInfoDTO getWorkProjectInfoDTO() {
        return workProjectInfoDTO;
    }

    public void setWorkProjectInfoDTO(WorkProjectInfoDTO workProjectInfoDTO) {
        this.workProjectInfoDTO = workProjectInfoDTO;
    }

    public List<WorkFileDTO> getWorkFileDTOList() {
        return workFileDTOList;
    }

    public void setWorkFileDTOList(List<WorkFileDTO> workFileDTOList) {
        this.workFileDTOList = workFileDTOList;
    }

    @Override
    public String toString() {
        return "WorkInfoDTO{" +
                "workId=" + workId +
                ", status=" + status +
                ", studentName='" + studentName + '\'' +
                ", teaching=" + teaching +
                ", workProjectInfoDTO=" + workProjectInfoDTO +
                ", workFileDTOList=" + workFileDTOList +
                '}';
    }
}
