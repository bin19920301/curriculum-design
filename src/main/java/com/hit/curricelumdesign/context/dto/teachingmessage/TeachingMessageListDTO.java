package com.hit.curricelumdesign.context.dto.teachingmessage;

import com.hit.curricelumdesign.context.dto.BaseListDTO;

public class TeachingMessageListDTO {

    /**
     * 教学消息DTO集合
     */
    private BaseListDTO<TeachingMessageInfoDTO> teachingMessageInfoDTOBaseListDTO;

    /**
     * 该教学下的学生人数
     */
    private Long studentCount;

    public BaseListDTO<TeachingMessageInfoDTO> getTeachingMessageInfoDTOBaseListDTO() {
        return teachingMessageInfoDTOBaseListDTO;
    }

    public void setTeachingMessageInfoDTOBaseListDTO(BaseListDTO<TeachingMessageInfoDTO> teachingMessageInfoDTOBaseListDTO) {
        this.teachingMessageInfoDTOBaseListDTO = teachingMessageInfoDTOBaseListDTO;
    }

    public Long getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(Long studentCount) {
        this.studentCount = studentCount;
    }

    @Override
    public String toString() {
        return "TeachingMessageListDTO{" +
                "teachingMessageInfoDTOBaseListDTO=" + teachingMessageInfoDTOBaseListDTO +
                ", studentCount=" + studentCount +
                '}';
    }
}
