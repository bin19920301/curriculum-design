package com.hit.curricelumdesign.manager.teaching;

import com.hit.curricelumdesign.context.dto.teaching.TeachingInfoDTO;
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

    public TeachingInfoDTO getTeachingDTOById(Integer teachingId){
        TeachingInfoDTO teachingListDTO = teachingMapper.selectById(teachingId);
        if (null == teachingListDTO){
            throw new BaseException(Error.TEACHING_IS_NOT_EXIST);
        }
        return teachingListDTO;
    }
}
