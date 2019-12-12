package com.hit.curricelumdesign.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hit.curricelumdesign.context.dto.BaseListDTO;
import com.hit.curricelumdesign.context.dto.student.StudentDTO;
import com.hit.curricelumdesign.context.entity.Student;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.context.param.BaseListRequestParam;
import com.hit.curricelumdesign.context.param.student.*;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.StudentMapper;
import com.hit.curricelumdesign.manager.student.StudentManager;
import com.hit.curricelumdesign.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentManager studentManager;
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 学生信息详情展示
     * @param studentParam
     * @return
     */
    public Result getStudentById(GetStudentParam studentParam) {
        StudentDTO student = studentManager.getStudentById(studentParam.getId());
        return  Result.success(student);
    }

    /**
     * 增加学生信息
     * @param studentParam
     * @return
     */
    public Result addStudent(AddStudentParam studentParam){
        //判断学生编号是否存在
        Student studentByNumber = studentMapper.selectByNumber(studentParam.getNumber());
        if (null != studentByNumber){
            throw new BaseException(Error.STUDENT_NUMBER_IS_EXIST);
        }
        Student student = new Student();
        BeanUtil.copyProperties(studentParam,student);
        student.setIsDelete((byte)0);
        student.setCreatorId(0);
        student.setCreatetime(new Date());
        student.setUpdaterId(0);
        studentMapper.insert(student);
        return Result.success();
    }

    /**
     * 更新学生信息
     * @param studentParam
     * @return
     */
    public Result updateStudent(UpdateStudentParam studentParam){
        Student student = new Student();
        BeanUtil.copyProperties(studentParam,student);
        student.setUpdatetime(new Date());
        studentMapper.updateByPrimaryKeySelective(student);
        return Result.success();
    }

    /**
     * 删除学生信息
     * @param studentParam
     * @return
     */
    public Result deleteStudent(DeleteStudentParam studentParam){
        Student student = new Student();
        BeanUtil.copyProperties(studentParam,student);
        student.setIsDelete((byte)1);
        student.setUpdatetime(new Date());
        studentMapper.updateByPrimaryKeySelective(student);
        return Result.success();
    }

    /**
     * 分页查询学生信息
     * @param param
     * @return
     */
    public Result getStudentList(BaseListRequestParam param){
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        List<StudentDTO> studentList = studentMapper.getStudentDTOList();
        PageInfo<StudentDTO> pageInfo = new PageInfo<>(studentList);

        BaseListDTO<StudentDTO> studentBaseListDTO = new BaseListDTO<>(pageInfo.getTotal(), studentList);
        return Result.success(studentBaseListDTO);
    }

    /**
     * 条件查询学生信息
     * @param param
     * @return
     */
    public Result getStudentByParams(ConditionSearchStudentParam param){
        Integer enrollmentId = param.getEnrollmentId();
        Integer academyId = param.getAcademyId();
        Integer classId = param.getClassId();
        List<StudentDTO> studentDTOListByParams = studentMapper.getStudentDTOListByParams(enrollmentId, academyId, classId);
        BaseListDTO<StudentDTO> studentBaseListDTO = new BaseListDTO<>(studentDTOListByParams.size(),studentDTOListByParams);
        return Result.success(studentBaseListDTO);
    }
}
