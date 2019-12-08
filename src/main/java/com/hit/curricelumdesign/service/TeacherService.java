package com.hit.curricelumdesign.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hit.curricelumdesign.context.dto.BaseListDTO;
import com.hit.curricelumdesign.context.dto.teacher.TeacherDTO;
import com.hit.curricelumdesign.context.entity.Teacher;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.context.param.BaseListRequestParam;
import com.hit.curricelumdesign.context.param.teacher.*;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.TeacherMapper;
import com.hit.curricelumdesign.manager.teacher.TeacherManager;
import com.hit.curricelumdesign.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherManager teacherManager;
    @Autowired
    private TeacherMapper teacherMapper;

    @Value("${hit.curricelumdesign.admin.password.default}")
    private String teacherPasswordDefault;


    /**
     * 教师信息详情展示
     * @param teacherParam
     * @return
     */
    public Result getTeacherById(GetTeacherParam teacherParam) {
        TeacherDTO teacher = teacherManager.getTeacherById(teacherParam.getId());
        return  Result.success(teacher);
    }

    /**
     * 增加教师信息
     * @param teacherParam
     * @return
     */
    public Result addTeacher(AddTeacherParam teacherParam){
        //判断教师编号是否存在
        Teacher teacherByNumber = teacherMapper.getTeacherByNumber(teacherParam.getNumber());
        if (null != teacherByNumber){
            throw new BaseException(Error.TEACHER_NUMBER_IS_EXIST);
        }
        Teacher teacher = new Teacher();
        BeanUtil.copyProperties(teacherParam,teacher);
        teacher.setIsDelete(false);
        teacher.setCreatorId(0);
        teacher.setCreatetime(new Date());
        teacher.setUpdaterId(0);
        teacher.setPassword(teacherPasswordDefault);
        teacherMapper.insert(teacher);
        return Result.success();
    }

    /**
     * 更新教师信息
     * @param teacherParam
     * @return
     */
    public Result updateTeacher(UpdateTeacherParam teacherParam){
        Teacher teacher = new Teacher();
        BeanUtil.copyProperties(teacherParam,teacher);
        BeanUtil.copyProperties(teacherParam,teacher,"password");
        System.out.println("新的密码；"+teacher.getPassword());;
        teacher.setUpdatetime(new Date());
        teacherMapper.updateByPrimaryKeySelective(teacher);
        return Result.success();
    }

    /**
     * 删除教师信息
     * @param teacherParam
     * @return
     */
    public Result deleteTeacher(DeleteTeacherParam teacherParam){
        Teacher teacher = new Teacher();
        BeanUtil.copyProperties(teacherParam,teacher);
        teacher.setIsDelete(Boolean.TRUE);
        teacher.setUpdatetime(new Date());
        teacherMapper.updateByPrimaryKeySelective(teacher);
        return Result.success();
    }

    /**
     * 重置教师密码
     * @param teacherParam
     * @return
     */
    public Result resetTeacherPassword(ResetPasswordParam teacherParam){
        TeacherDTO dto = teacherMapper.selectByPrimaryKey(teacherParam.getId());
        Teacher teacher = new Teacher();
        BeanUtil.copyProperties(dto,teacher);
        teacher.setPassword(teacherPasswordDefault);
        //更新操作者的id
        teacher.setUpdaterId(0);
        teacher.setUpdatetime(new Date());
        teacherMapper.updateByPrimaryKeySelective(teacher);
        return Result.success();
    }

    /**
     * 分页查询教师信息
     * @param param
     * @return
     */
    public Result getTeacherList(BaseListRequestParam param){
        PageHelper.startPage(param.getPageNum() , param.getPageSize());
        List<TeacherDTO> teacherList = teacherManager.getTeacherList();
        PageInfo<TeacherDTO> pageInfo = new PageInfo<>(teacherList);

        BaseListDTO<TeacherDTO> teacherBaseListDTO = new BaseListDTO<>(pageInfo.getTotal(), teacherList);
        return Result.success(teacherBaseListDTO);
    }
}
