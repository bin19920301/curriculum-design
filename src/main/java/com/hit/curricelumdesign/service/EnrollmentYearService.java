package com.hit.curricelumdesign.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hit.curricelumdesign.context.constant.Constants;
import com.hit.curricelumdesign.context.dto.BaseListDTO;
import com.hit.curricelumdesign.context.dto.enrollmentYear.EnrollmentYearDTO;
import com.hit.curricelumdesign.context.dto.student.StudentDTO;
import com.hit.curricelumdesign.context.entity.EnrollmentYear;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.context.param.BaseListRequestParam;
import com.hit.curricelumdesign.context.param.enrollmentyear.AddEnrollmentYearParam;
import com.hit.curricelumdesign.context.param.enrollmentyear.EnrollmentYearBaseParam;
import com.hit.curricelumdesign.context.param.enrollmentyear.UpdateEnrollmentYearParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.EnrollmentYearMapper;
import com.hit.curricelumdesign.manager.enrollmentyear.EnrollmentYearManager;
import com.hit.curricelumdesign.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author xbr
 * @Date 2019-12-09
 * @ClassName EnrollmentYearService
 * @Description
 */
@Service
@Transactional
public class EnrollmentYearService {

    @Autowired
    private EnrollmentYearMapper enrollmentYearMapper;

    @Autowired
    private EnrollmentYearManager enrollmentYearManager;


    /**
     * 新建入学年份
     *
     * @param param
     * @return
     */
    public Result addEnrollmentYear(AddEnrollmentYearParam param) {
        EnrollmentYear enrollmentYear = enrollmentYearMapper.getEnrollmentYearByEnrollmentYear(param.getEnrollmentYear());
        if (null != enrollmentYear) {
            throw new BaseException(Error.ENROLLMENTYEAR_IS_EXIST);
        }
        Date now = new Date();
        enrollmentYear = new EnrollmentYear();
        enrollmentYear.setEnrollmentYear(param.getEnrollmentYear());
        enrollmentYear.setIsDelete(Constants.Common.IS_NOT);
        enrollmentYear.setCreatorId(param.getAdminId());
        enrollmentYear.setCreatetime(now);
        enrollmentYear.setUpdaterId(param.getAdminId());
        enrollmentYear.setUpdatetime(now);
        enrollmentYearMapper.insert(enrollmentYear);
        return Result.success();
    }

    /**
     * 删除入学年份
     *
     * @param param
     * @return
     */
    public Result deleteEnrollmentYear(EnrollmentYearBaseParam param) {
        EnrollmentYear enrollmentYear = new EnrollmentYear();
        BeanUtil.copyProperties(param, enrollmentYear);
        enrollmentYear.setIsDelete(Constants.Common.IS_YES);
        enrollmentYear.setUpdatetime(new Date());
        enrollmentYear.setUpdaterId(param.getAdminId());
        enrollmentYearMapper.updateByPrimaryKeySelective(enrollmentYear);
        return Result.success();
    }

    /**
     * 更新入学年份
     *
     * @param param
     * @return
     */
    public Result updateEnrollmentYear(UpdateEnrollmentYearParam param) {
        EnrollmentYear enrollmentYear = enrollmentYearMapper.getEnrollmentYearByEnrollmentYear(param.getEnrollmentYear());
        if (null != enrollmentYear) {
            throw new BaseException(Error.ENROLLMENTYEAR_IS_EXIST);
        }
        enrollmentYear = new EnrollmentYear();
        BeanUtil.copyProperties(param, enrollmentYear);
        enrollmentYear.setUpdaterId(param.getAdminId());
        enrollmentYear.setUpdatetime(new Date());
        enrollmentYearMapper.updateByPrimaryKeySelective(enrollmentYear);
        return Result.success();
    }

    /**
     * 查询详情
     *
     * @param param
     * @return
     */
    public Result getEnrollmentYearById(EnrollmentYearBaseParam param) {
        EnrollmentYearDTO enrollmentYearDTO = enrollmentYearMapper.selectById(param.getId());
        return Result.success(enrollmentYearDTO);
    }

    /**
     * 查询列表分页
     *
     * @param param
     * @return
     */
    public Result getEnrollmentYearList(BaseListRequestParam param) {
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        List<EnrollmentYearDTO> enrollmentYearList = enrollmentYearMapper.getEnrollmentYearList();
        PageInfo<EnrollmentYearDTO> pageInfo = new PageInfo<>(enrollmentYearList);

        BaseListDTO<EnrollmentYearDTO> enrollmentBaseListDTO = new BaseListDTO<>(pageInfo.getTotal(), enrollmentYearList);
        return Result.success(enrollmentBaseListDTO);
    }

    /**
     * 查询所有入学年份
     *
     * @param param
     * @return
     */
    public Result getAllEnrollmentYear() {
        List<EnrollmentYearDTO> enrollmentYearList = enrollmentYearMapper.getEnrollmentYearList();
        BaseListDTO<EnrollmentYearDTO> enrollmentBaseListDTO = new BaseListDTO<>(enrollmentYearList.size(), enrollmentYearList);
        return Result.success(enrollmentBaseListDTO);
    }

}
