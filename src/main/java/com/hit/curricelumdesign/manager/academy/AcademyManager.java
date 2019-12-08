package com.hit.curricelumdesign.manager.academy;

import com.google.common.annotations.GwtCompatible;
import com.hit.curricelumdesign.context.entity.Academy;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.dao.AcademyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xbr
 * @Date 2019-12-08
 * @ClassName AcademyManager
 * @Description
 */
@Component
public class AcademyManager {

    @Autowired
    private AcademyMapper academyMapper;

    public Academy getAcademyById(Integer id) {
        Academy academy = academyMapper.getAcademyById(id);
        if (null == academy) {
            throw new BaseException(Error.ACADEMY_IS_NOT_EXIST);
        }
        return academy;
    }

}
