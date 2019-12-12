package com.hit.curricelumdesign.service;

import com.hit.curricelumdesign.context.param.BaseListRequestParam;
import com.hit.curricelumdesign.context.param.teaching.AddTeachingParam;
import com.hit.curricelumdesign.context.param.teaching.GetTeachingParam;
import com.hit.curricelumdesign.context.param.teaching.TeachingBaseParam;
import com.hit.curricelumdesign.context.param.teaching.UpdateTeachingParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.TeachingMapper;
import com.hit.curricelumdesign.manager.teaching.TeachingManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TeachingService {

    @Autowired
    private TeachingMapper teachingMapper;

    @Autowired
    private TeachingManager teachingManager;

    /**
     * 教学信息详情展示
     * @param teachingParam
     * @return
     */
    public Result getTeachingById(GetTeachingParam teachingParam) {
        return  Result.success();
    }

    /**
     * 增加教学信息
     * @param teachingParam
     * @return
     */
    public Result addTeaching(AddTeachingParam teachingParam){
        return Result.success();
    }

    /**
     * 更新教学信息
     * @param teachingParam
     * @return
     */
    public Result updateTeaching(UpdateTeachingParam teachingParam){
        return Result.success();
    }

    /**
     * 删除教学信息
     * @param teachingParam
     * @return
     */
    public Result deleteTeaching(TeachingBaseParam teachingParam){
        return Result.success();
    }

    /**
     * 分页查询教学信息
     * @param param
     * @return
     */
    public Result getTeachingList(BaseListRequestParam param){
        return Result.success();
    }

    /**
     * 查询所有教学信息
     * @param
     * @return
     */
    public Result getTeachingByCreatorId(){
        return Result.success();
    }
}
