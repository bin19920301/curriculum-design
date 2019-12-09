package com.hit.curricelumdesign.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hit.curricelumdesign.context.constant.Constants;
import com.hit.curricelumdesign.context.dto.BaseListDTO;
import com.hit.curricelumdesign.context.dto.academy.AcademyDTO;
import com.hit.curricelumdesign.context.dto.clazz.ClassInfoDTO;
import com.hit.curricelumdesign.context.entity.Academy;
import com.hit.curricelumdesign.context.entity.Class;
import com.hit.curricelumdesign.context.entity.Student;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.context.param.BaseListRequestParam;
import com.hit.curricelumdesign.context.param.academy.AddAcademyParam;
import com.hit.curricelumdesign.context.param.academy.DeleteAcademyParam;
import com.hit.curricelumdesign.context.param.academy.RenameAcademyParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.AcademyMapper;
import com.hit.curricelumdesign.dao.ClassMapper;
import com.hit.curricelumdesign.dao.StudentMapper;
import com.hit.curricelumdesign.dao.TeacherMapper;
import com.hit.curricelumdesign.manager.academy.AcademyManager;
import com.hit.curricelumdesign.manager.clazz.ClassManager;
import com.hit.curricelumdesign.manager.student.StudentManager;
import com.hit.curricelumdesign.manager.teacher.TeacherManager;
import com.hit.curricelumdesign.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author xbr
 * @Date 2019-12-08
 * @ClassName AcademyService
 * @Description
 */
@Service
public class AcademyService {

    @Autowired
    private AcademyManager academyManager;

    @Autowired
    private AcademyMapper academyMapper;

    @Autowired
    private ClassManager classManager;

    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private StudentManager studentManager;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherManager teacherManager;

    @Autowired
    private TeacherMapper teacherMapper;

    /**
     * 添加学院
     *
     * @param param
     * @return
     */
    public Result addAcademy(AddAcademyParam param) {
        Academy academyByName = academyMapper.getAcademyByName(param.getName());
        if (null != academyByName) {
            throw new BaseException(Error.ACADEMY_NAME_IS_EXIST);
        }
        Date now = new Date();
        Academy academy = new Academy();
        academy.setName(param.getName());
        academy.setIsDelete(Constants.Common.IS_NOT);
        academy.setCreateId(0);
        academy.setCreatetime(now);
        academy.setUpdaterId(0);
        academy.setUpdatetime(now);
        academyMapper.insert(academy);

        return Result.success();
    }

    /**
     * 重命名学院
     *
     * @param param
     * @return
     */
    public Result renameAcademy(RenameAcademyParam param) {
        Academy academyByName = academyMapper.getAcademyByName(param.getName());
        Academy academy = academyManager.getAcademyById(param.getId());
        if (null != academyByName && academy.getId().compareTo(academyByName.getId()) != 0) {
            throw new BaseException(Error.ACADEMY_NAME_IS_EXIST);
        }
        academy.setName(param.getName());
        academy.setUpdatetime(new Date());
        //todo id
        academy.setUpdaterId(0);
        academyMapper.updateByPrimaryKey(academy);
        return Result.success();
    }

    /**
     * 学院列表查看
     *
     * @param param
     * @return
     */
    public Result getAcademyList(BaseListRequestParam param) {
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        List<Academy> academyList = academyMapper.getAcademyList();
        PageInfo<Academy> pageInfo = new PageInfo<>(academyList);
        List<AcademyDTO> academyDTOList = new ArrayList<>();
        for (Academy academy : academyList) {
            AcademyDTO dto = new AcademyDTO();
            BeanUtil.copyProperties(academy, dto);
            List<Class> classList = classManager.getClassListByAcademyId(academy.getId());
            List<ClassInfoDTO> classInfoDTOList = new ArrayList<>();
            for (Class aClass : classList) {
                ClassInfoDTO classInfoDTO = new ClassInfoDTO();
                classInfoDTO.setName(aClass.getName());
                classInfoDTO.setId(aClass.getId());
                classInfoDTOList.add(classInfoDTO);
            }
            dto.setClassList(classInfoDTOList);
            academyDTOList.add(dto);
        }
        BaseListDTO<AcademyDTO> baseListDTO = new BaseListDTO<AcademyDTO>(pageInfo.getTotal(), academyDTOList);
        return Result.success(baseListDTO);
    }

    /**
     * 查询全部学院
     *
     * @return
     */
    public Result getAllAcademyList() {
        List<Academy> academyList = academyMapper.getAcademyList();
        List<AcademyDTO> academyDTOList = new ArrayList<>();
        for (Academy academy : academyList) {
            AcademyDTO dto = new AcademyDTO();
            BeanUtil.copyProperties(academy, dto);
            List<Class> classList = classManager.getClassListByAcademyId(academy.getId());
            List<ClassInfoDTO> classInfoDTOList = new ArrayList<>();
            for (Class aClass : classList) {
                ClassInfoDTO classInfoDTO = new ClassInfoDTO();
                classInfoDTO.setName(aClass.getName());
                classInfoDTO.setId(aClass.getId());
                classInfoDTOList.add(classInfoDTO);
            }
            dto.setClassList(classInfoDTOList);
            academyDTOList.add(dto);
        }
        BaseListDTO<AcademyDTO> baseListDTO = new BaseListDTO<AcademyDTO>(academyDTOList.size(), academyDTOList);
        return Result.success(baseListDTO);
    }

    /**
     * 删除学院
     *
     * @param param
     * @return
     */
    public Result deleteAcademy(DeleteAcademyParam param) {
        Academy academy = academyManager.getAcademyById(param.getId());
        Long countClassByAcademyId = classMapper.countClassByAcademyId(academy.getId());
        if (countClassByAcademyId > 0) {
            return Result.failure(Error.ACADEMY_HAS_CLASS, String.format("当前有%d个班级属于该院系，不能完成院系删除。", countClassByAcademyId));
        }
        Long countStudentByAcademyId = studentMapper.countStudentByAcademyId(academy.getId());
        if (countStudentByAcademyId > 0) {
            return Result.failure(Error.ACADEMY_HAS_STUDENT, String.format("当前有%d位学生属于该院系，不能完成院系删除。", countStudentByAcademyId));
        }
        Long countTeacherByAcademyId = teacherMapper.countTeacherByAcademyId(academy.getId());
        if (countTeacherByAcademyId > 0) {
            return Result.failure(Error.ACADEMY_HAS_TEACHER, String.format("当前有%d位老师属于该院系，不能完成院系删除。", countTeacherByAcademyId));
        }
        academy.setIsDelete(Constants.Common.IS_YES);
        // todo id
        academy.setUpdaterId(0);
        academy.setUpdatetime(new Date());
        academyMapper.updateByPrimaryKey(academy);
        return Result.success();
    }
}
