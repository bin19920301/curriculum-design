package com.hit.curricelumdesign.service;

import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.WorkMapper;
import com.hit.curricelumdesign.manager.work.WorkManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WorkService {

    @Autowired
    private WorkMapper workMapper;

    @Autowired
    private WorkManager workManager;


    public Result addWork() {
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
