package com.hit.curricelumdesign.manager.student;

import com.hit.curricelumdesign.context.dto.student.StudentDTO;
import com.hit.curricelumdesign.context.dto.teacher.TeacherDTO;
import com.hit.curricelumdesign.context.entity.Academy;
import com.hit.curricelumdesign.context.entity.Class;
import com.hit.curricelumdesign.context.entity.EnrollmentYear;
import com.hit.curricelumdesign.context.entity.Student;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.AcademyMapper;
import com.hit.curricelumdesign.dao.ClassMapper;
import com.hit.curricelumdesign.dao.EnrollmentYearMapper;
import com.hit.curricelumdesign.dao.StudentMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentManager {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private AcademyMapper academyMapper;
    @Autowired
    private ClassMapper classMapper;
    @Autowired
    private EnrollmentYearMapper enrollmentYearMapper;

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
