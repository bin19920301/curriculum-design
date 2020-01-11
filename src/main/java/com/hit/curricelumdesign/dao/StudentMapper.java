package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.dto.student.StudentDTO;
import com.hit.curricelumdesign.context.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    Student selectByNumber(String number);

    StudentDTO selectById(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<StudentDTO> getStudentDTOList();

    Long countStudentByAcademyId(Integer academyId);

    List<StudentDTO> getStudentDTOListByParams(Integer enrollmentId, Integer academyId, Integer classId);

    Long countStudentByClassId(Integer classId);

    Long countStudentByEnrollmentId(Integer enrollmentId);

    Student getStudentByNameAndNumber(String name, String number);

    int insertList(@Param("studentList") List<Student> studentList);

}
