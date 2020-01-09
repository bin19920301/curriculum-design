package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.dto.teachermessage.TeacherMessageInfoDTO;
import com.hit.curricelumdesign.context.entity.TeacherMessage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeacherMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TeacherMessage record);

    int insertSelective(TeacherMessage record);

    TeacherMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TeacherMessage record);

    int updateByPrimaryKey(TeacherMessage record);

    List<TeacherMessageInfoDTO> listTeacherMessageDTO(Integer startId);
}
