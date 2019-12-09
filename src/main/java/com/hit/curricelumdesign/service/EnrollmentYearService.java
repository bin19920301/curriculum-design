package com.hit.curricelumdesign.service;

import com.hit.curricelumdesign.context.constant.Constants;
import com.hit.curricelumdesign.context.entity.EnrollmentYear;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.context.param.enrollmentyear.AddEnrollmentYearParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.EnrollmentYearMapper;
import com.hit.curricelumdesign.manager.enrollmentyear.EnrollmentYearManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author xbr
 * @Date 2019-12-09
 * @ClassName EnrollmentYearService
 * @Description
 */
@Service
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
        // todo id
        enrollmentYear.setCreatorId(0);
        enrollmentYear.setCreatetime(now);
        enrollmentYear.setUpdaterId(0);
        enrollmentYear.setUpdatetime(now);
        enrollmentYearMapper.insert(enrollmentYear);
        return Result.success();
    }
}
