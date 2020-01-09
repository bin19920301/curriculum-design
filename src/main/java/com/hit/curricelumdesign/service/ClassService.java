package com.hit.curricelumdesign.service;

import com.hit.curricelumdesign.context.constant.Constants;
import com.hit.curricelumdesign.context.dto.BaseListDTO;
import com.hit.curricelumdesign.context.dto.clazz.ClassInfoDTO;
import com.hit.curricelumdesign.context.entity.Academy;
import com.hit.curricelumdesign.context.entity.Class;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.context.param.clazz.AddClassParam;
import com.hit.curricelumdesign.context.param.clazz.DeleteClassParam;
import com.hit.curricelumdesign.context.param.clazz.GetClassByAcademyIdParam;
import com.hit.curricelumdesign.context.param.clazz.RenameClassParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.ClassMapper;
import com.hit.curricelumdesign.dao.StudentMapper;
import com.hit.curricelumdesign.manager.academy.AcademyManager;
import com.hit.curricelumdesign.manager.clazz.ClassManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author xbr
 * @Date 2019-12-09
 * @ClassName ClassService
 * @Description
 */
@Service
public class ClassService {

    @Autowired
    private ClassManager classManager;

    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private AcademyManager academyManager;

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 添加班级
     *
     * @param param
     * @return
     */
    public Result addClass(AddClassParam param) {
        Academy academy = academyManager.getAcademyById(param.getAcademyId());
        Class classByName = classMapper.getClassByName(param.getName());
        if (null != classByName) {
            throw new BaseException(Error.CLASS_NAME_IS_EXIST);
        }
        Date now = new Date();
        Class aClass = new Class();
        aClass.setAcademyId(academy.getId());
        aClass.setName(param.getName());
        aClass.setIsDelete(Constants.Common.IS_NOT);
        aClass.setCreatorId(param.getLoginAdminId());
        aClass.setCreatetime(now);
        aClass.setUpdaterId(param.getLoginAdminId());
        aClass.setUpdatetime(now);
        classMapper.insert(aClass);
        return Result.success();
    }

    /**
     * 重命名班级
     *
     * @param param
     * @return
     */
    public Result renameClass(RenameClassParam param) {
        Class aClass = classManager.getClassById(param.getClassId());
        Class classByName = classMapper.getClassByName(param.getName());
        if (null != classByName && aClass.getId().compareTo(classByName.getId()) != 0) {
            throw new BaseException(Error.CLASS_NAME_IS_EXIST);
        }

        aClass.setName(param.getName());
        aClass.setUpdaterId(param.getLoginAdminId());
        aClass.setUpdatetime(new Date());
        classMapper.updateByPrimaryKeySelective(aClass);
        return Result.success();
    }


    /**
     * 删除班级
     *
     * @param param
     * @return
     */
    public Result deleteClass(DeleteClassParam param) {
        Class aClass = classManager.getClassById(param.getId());
        Long countStudentByClassId = studentMapper.countStudentByClassId(param.getId());
        if (countStudentByClassId > 0) {
            return Result.failure(Error.CLASS_HAS_STUDENT, String.format("当前有%d位学生属于该班级，不能完成班级删除。", countStudentByClassId));
        }
        aClass.setIsDelete(Constants.Common.IS_YES);
        aClass.setUpdatetime(new Date());
        aClass.setUpdaterId(param.getLoginAdminId());
        classMapper.updateByPrimaryKeySelective(aClass);
        return Result.success();
    }

    /**
     * 根据学院id查询班级
     *
     * @param param
     * @return
     */
    public Result getClassByAcademyId(GetClassByAcademyIdParam param) {
        Academy academy = academyManager.getAcademyById(param.getAcademyId());
        List<Class> classList = classManager.getClassListByAcademyId(academy.getId());
        List<ClassInfoDTO> classInfoDTOList = new ArrayList<>();
        for (Class aClass : classList) {
            ClassInfoDTO classInfoDTO = new ClassInfoDTO();
            classInfoDTO.setName(aClass.getName());
            classInfoDTO.setId(aClass.getId());
            classInfoDTOList.add(classInfoDTO);
        }
        BaseListDTO<ClassInfoDTO> baseListDTO = new BaseListDTO<>(classInfoDTOList.size(), classInfoDTOList);
        return Result.success(baseListDTO);
    }
}
