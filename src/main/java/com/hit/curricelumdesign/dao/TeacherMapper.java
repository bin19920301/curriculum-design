package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.dto.teacher.TeacherDTO;
import com.hit.curricelumdesign.context.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    TeacherDTO selectById(Integer id);

    Teacher selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    List<TeacherDTO> getTeacherList();

    Teacher getTeacherByNumber(String number);
}