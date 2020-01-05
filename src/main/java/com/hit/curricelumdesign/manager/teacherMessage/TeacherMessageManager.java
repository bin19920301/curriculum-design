package com.hit.curricelumdesign.manager.teacherMessage;

import com.hit.curricelumdesign.context.entity.TeacherMessage;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.dao.TeacherMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeacherMessageManager {
    @Autowired
    private TeacherMessageMapper teacherMessageMapper;

    public TeacherMessage getById(Integer teacherMessageId){
        TeacherMessage message = teacherMessageMapper.selectByPrimaryKey(teacherMessageId);
        if (null == message){
            throw new BaseException(Error.TEACHER_MESSAGE_IS_NOT_EXIST);
        }
        return message;
    }
}
