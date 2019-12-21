package com.hit.curricelumdesign.manager.work;

import com.hit.curricelumdesign.context.entity.Work;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.dao.WorkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkManager {

    @Autowired
    private WorkMapper workMapper;

    /**
     * 根据作业id查询作业
     * @param workId
     * @return
     */
    public Work getWorkerById(Integer workId) {
        Work work = workMapper.selectByPrimaryKey(workId);
        if (null == work) {
            throw new BaseException(Error.WORK_IS_NOT_EXIST);
        }
        return work;
    }
}
