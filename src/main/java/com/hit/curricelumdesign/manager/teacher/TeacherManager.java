package com.hit.curricelumdesign.manager.teacher;

import com.hit.curricelumdesign.context.dto.teacher.TeacherDTO;
import com.hit.curricelumdesign.context.entity.Teacher;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.dao.TeacherMapper;
import com.hit.curricelumdesign.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class TeacherManager {
    @Autowired
    private TeacherMapper teacherMapper;

    public TeacherDTO getTeacherById(Integer id){
        TeacherDTO teacher = teacherMapper.selectByPrimaryKey(id);
        if (null == teacher){
            throw new BaseException(Error.TEACHER_IS_NOT_EXIST);

        }
        return teacher;
    }


    public List<TeacherDTO> getTeacherList(){
        return teacherMapper.getTeacherList();
    }
}