package com.hit.curricelumdesign.manager.workmessage;

import com.hit.curricelumdesign.context.entity.WorkMessage;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.dao.WorkMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xbr
 * @Date 2019-12-22
 * @ClassName WorkMessageManager
 * @Description
 */
@Component
public class WorkMessageManager {

    @Autowired
    private WorkMessageMapper workMessageMapper;

    public WorkMessage getWorkMessageById(Integer workMessageId) {
        WorkMessage workMessage = workMessageMapper.selectByPrimaryKey(workMessageId);
        if (null == workMessage) {
            throw new BaseException(Error.WORK_MESSAGE_IS_NOT_EXIST);
        }
        return workMessage;
    }
}
