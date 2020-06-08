package com.hit.curricelumdesign.manager.clazz;

import com.hit.curricelumdesign.context.entity.Class;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.dao.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xbr
 * @Date 2019-12-08
 * @ClassName ClassManager
 * @Description
 */
@Component
public class ClassManager {

    @Autowired
    private ClassMapper classMapper;

    public List<Class> getClassListByAcademyId(Integer academyId) {
        return classMapper.getClassListByAcademyId(academyId);
    }

    public Class getClassById(Integer classId) {
        Class aClass = classMapper.selectByPrimaryKey(classId);
        if (null == aClass) {
            throw new BaseException(Error.CLASS_IS_NOT_EXIST);
        }
        return aClass;

    }
}
