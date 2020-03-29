package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.dto.workmessage.WorkMessageDTO;
import com.hit.curricelumdesign.context.dto.workmessage.WorkMessageInfoDTO;
import com.hit.curricelumdesign.context.entity.WorkMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WorkMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WorkMessage record);

    int insertSelective(WorkMessage record);

    WorkMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkMessage record);

    int updateByPrimaryKey(WorkMessage record);

    List<WorkMessageDTO> getTeacherMessageDTOByTeacherId(Integer teacherId, Integer read);

    List<WorkMessageDTO> getStudentMessageDTOByStudentId(Integer studentId, Integer read);

    long countTeacherUnreadMessage(Integer teacherId);

    long countStudentUnreadMessage(Integer studentId);

    List<WorkMessageInfoDTO> getWorkMessageInfoDTOByWorkId(Integer workId, Integer startId);

    int readMessage(@Param("userId") Integer userId, @Param("workId") Integer workId, @Param("receiverType") Integer receiverType);

    List<WorkMessageInfoDTO> getStudentLastListMessage(Integer currentWorkMessageId, Integer workId);
}
