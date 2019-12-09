package com.hit.curricelumdesign.manager.student;

import com.hit.curricelumdesign.context.dto.student.StudentDTO;
import com.hit.curricelumdesign.context.dto.teacher.TeacherDTO;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.dao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentManager {
    @Autowired
    private StudentMapper studentMapper;

    public StudentDTO getStudentById(Integer id){
        StudentDTO studentDTO = studentMapper.selectById(id);
        if (null == studentDTO){
            throw new BaseException(Error.STUDENT_IS_NOT_EXIST);
        }
        return studentDTO;
    }

    public List<StudentDTO> getTeacherList(){
        return studentMapper.getStudentDTOList();
    }


}
