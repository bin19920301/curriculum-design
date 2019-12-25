package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.dto.work.WorkForTeacherDTO;
import com.hit.curricelumdesign.context.dto.work.WorkInfoListDTO;
import com.hit.curricelumdesign.context.entity.Work;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WorkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Work record);

    int insertSelective(Work record);

    Work selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);

    List<Work> selectByParams(Integer teachingId, Integer studentId, Integer workProjectId, Integer isDone);

    List<WorkForTeacherDTO> selectByTeachingId(Integer teachingId);

    Long countStudentsByTeachingId(Integer teachingId);

}
