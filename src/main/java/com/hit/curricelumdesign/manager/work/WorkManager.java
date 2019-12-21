package com.hit.curricelumdesign.manager.work;

import com.hit.curricelumdesign.context.bo.work.AddWorkBO;
import com.hit.curricelumdesign.context.bo.work.UpdateWorkBO;
import com.hit.curricelumdesign.context.constant.Constants;
import com.hit.curricelumdesign.context.entity.Work;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.dao.WorkMapper;
import com.hit.curricelumdesign.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

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

    /**
     * 新增作业
     * @param workBO
     */
    public void addWork(AddWorkBO workBO){
        Work work = new Work( );
        BeanUtil.copyProperties(workBO,work);
        //设置分数
        work.setScore(0);
        //设置状态
        work.setStatus(0);
        //设置未删除
        work.setIsDelete(Constants.Common.IS_NOT);
        //设置创建时间
        work.setCreatetime(new Date());
        //设置修改时间
        work.setUpdatetime(new Date());
        workMapper.insert(work);
    }

    /**
     * 更新作业
     * @param workBO
     */
    public void updateWork(UpdateWorkBO workBO){
        //目前只存在一种情况，即更新作业中的作业项目
        Work work = new Work();
        BeanUtil.copyProperties(workBO,work);
        //设置更新时间
        work.setUpdatetime(new Date());
        workMapper.updateByPrimaryKeySelective(work);
    }

    /**
     * 删除作业
     * @param workId
     */
    public void deleteWork(Integer workId){
        Work work = new Work();
        work.setId(workId);
        //设置删除标志位
        work.setIsDelete(Constants.Common.IS_YES);
        //设置更新时间
        work.setUpdatetime(new Date());
        workMapper.updateByPrimaryKeySelective(work);
    }
}
