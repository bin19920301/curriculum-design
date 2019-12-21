package com.hit.curricelumdesign.service;

import com.hit.curricelumdesign.context.constant.Constants;
import com.hit.curricelumdesign.context.entity.Work;
import com.hit.curricelumdesign.context.param.work.AddWorkParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.WorkMapper;
import com.hit.curricelumdesign.manager.work.WorkManager;
import com.hit.curricelumdesign.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class WorkService {

    @Autowired
    private WorkMapper workMapper;

    @Autowired
    private WorkManager workManager;


    public Result addWork(AddWorkParam workParam) {
        Work work = new Work();
        BeanUtil.copyProperties(workParam,work);
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
        return Result.success();
    }

    public Result updateWork() {
        return Result.success();
    }

    public Result deleteWork() {
        return Result.success();
    }

    public Result updateStatusForWork() {
        return Result.success();
    }

    public Result setScoreForWork() {
        return Result.success();
    }

    public Result getWorkByWorkProjectId() {
        return Result.success();
    }

    public Result getWorkByStudentId() {
        return Result.success();
    }
}
