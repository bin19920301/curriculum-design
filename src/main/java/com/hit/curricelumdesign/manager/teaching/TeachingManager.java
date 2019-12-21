package com.hit.curricelumdesign.manager.teaching;

import com.hit.curricelumdesign.context.dto.teaching.TeachingDTO;
import com.hit.curricelumdesign.context.entity.Teaching;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.dao.TeachingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeachingManager {

    @Autowired
    private TeachingMapper teachingMapper;

    public Teaching getTeachingById(Integer id) {
        Teaching teaching = teachingMapper.selectByPrimaryKey(id);
        if (null == teaching) {
            throw new BaseException(Error.TEACHING_IS_NOT_EXIST);
        }
        return teaching;
    }

    public TeachingDTO getTeachingDTOById(Integer teachingId){
        TeachingDTO teachingDTO = teachingMapper.selectById(teachingId);
        if (null == teachingDTO){
            throw new BaseException(Error.TEACHING_IS_NOT_EXIST);
        }
        return teachingDTO;
    }
}
