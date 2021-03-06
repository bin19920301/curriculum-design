package com.hit.curricelumdesign.manager.teacher;

import com.hit.curricelumdesign.context.dto.teacher.TeacherDTO;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeacherManager {
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private AcademyMapper academyMapper;
    @Autowired
    private ClassMapper classMapper;
    @Autowired
    private EnrollmentYearMapper enrollmentYearMapper;
    @Autowired
    private StudentMapper studentMapper;

    public TeacherDTO getTeacherById(Integer id){
        TeacherDTO teacher = teacherMapper.selectById(id);
        if (null == teacher){
            throw new BaseException(Error.TEACHER_IS_NOT_EXIST);

        }
        return teacher;
    }


    public List<TeacherDTO> getTeacherList(){
        return teacherMapper.getTeacherList();
    }


}
