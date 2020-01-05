package com.hit.curricelumdesign.manager.teachingmessage;

import com.hit.curricelumdesign.context.entity.TeachingMessage;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.dao.TeachingMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeachingMessageManager {
    @Autowired
    private TeachingMessageMapper teachingMessageMapper;

    public TeachingMessage getById(Integer id){
        TeachingMessage teachingMessage = teachingMessageMapper.selectByPrimaryKey(id);
        if (null == teachingMessage){
            throw new BaseException(Error.TEACHING_MESSAGE_IS_NOT_EXIST);
        }
        return teachingMessage;
    }
}
