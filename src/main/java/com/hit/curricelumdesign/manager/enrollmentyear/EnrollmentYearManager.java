package com.hit.curricelumdesign.manager.enrollmentyear;

import com.hit.curricelumdesign.dao.EnrollmentYearMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xbr
 * @Date 2019-12-09
 * @ClassName EnrollmentYearManager
 * @Description
 */
@Component
public class EnrollmentYearManager {

    @Autowired
    private EnrollmentYearMapper enrollmentYearMapper;
}
