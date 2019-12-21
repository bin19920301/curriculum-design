package com.hit.curricelumdesign.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hit.curricelumdesign.context.bo.work.AddWorkBO;
import com.hit.curricelumdesign.context.dto.BaseListDTO;
import com.hit.curricelumdesign.context.dto.teaching.TeachingDTO;
import com.hit.curricelumdesign.context.entity.Teaching;
import com.hit.curricelumdesign.context.entity.Work;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.context.param.BaseListRequestParam;
import com.hit.curricelumdesign.context.param.teaching.*;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.TeachingMapper;
import com.hit.curricelumdesign.dao.WorkMapper;
import com.hit.curricelumdesign.manager.teaching.TeachingManager;
import com.hit.curricelumdesign.manager.work.WorkManager;
import com.hit.curricelumdesign.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class TeachingService {

    @Autowired
    private TeachingMapper teachingMapper;

    @Autowired
    private TeachingManager teachingManager;

    @Autowired
    private WorkManager workManager;

    @Autowired
    private WorkMapper workMapper;

    /**
     * 教学信息详情展示
     * @param teachingParam
     * @return
     */
    public Result getTeachingById(GetTeachingParam teachingParam) {
        //这里是详情展示的详细操作
        return  Result.success(teachingManager.getTeachingById(teachingParam.getId()));
    }

    /**
     * 增加教学信息
     * @param teachingParam
     * @return
     */
    public Result addTeaching(AddTeachingParam teachingParam){
        if (null != teachingMapper.selectByName(teachingParam.getName())){
            throw new BaseException(Error.TEACHER_REMINDER_OVER_LENGTH);
        }
        if (teachingParam.getTeacherReminder().length() > 500){
            throw new BaseException(Error.TEACHER_REMINDER_OVER_LENGTH);
        }
        Teaching teaching = new Teaching();
        BeanUtil.copyProperties(teachingParam,teaching);
        teaching.setCreatorId(1);
        teaching.setCreatetime(new Date());
        teaching.setTeacherId(1);
        teaching.setUpdaterId(0);
        teaching.setUpdatetime(new Date());
        teaching.setIsDelete(false);
        //获取保存之后的教学Id
        int currentTeachingId = teachingMapper.insert(teaching);
        //这里应该增加保存作业相关操作,未完成
        List<StudentWorkProjectParam> works = teachingParam.getWorks();
        for (int i = 0; i < works.size(); i++) {
            StudentWorkProjectParam studentWorkProjectParam =  works.get(i);
            AddWorkBO workBO = new AddWorkBO();
            //设置教学id
            workBO.setTeachingId(currentTeachingId);
            //设置学生id
            workBO.setStudentId(studentWorkProjectParam.getStudentId());
            //设置作业项目id
            workBO.setWorkProjectId(studentWorkProjectParam.getWorkProjectId());
            //进行作业的保存操作
            workManager.addWork(workBO);
        }
        return Result.success();
    }

    /**
     * 更新教学信息
     * @param teachingParam
     * @return
     */
    public Result updateTeaching(UpdateTeachingParam teachingParam){
        if (null != teachingMapper.selectByName(teachingParam.getName())){
            throw new BaseException(Error.TEACHER_REMINDER_OVER_LENGTH);
        }
        if (teachingParam.getTeacherReminder().length() > 500){
            throw new BaseException(Error.TEACHER_REMINDER_OVER_LENGTH);
        }
        Teaching teaching = new Teaching();
        BeanUtil.copyProperties(teachingParam,teaching);
        teaching.setUpdaterId(2);
        teaching.setUpdatetime(new Date());
        teachingMapper.updateByPrimaryKeySelective(teaching);
        //这里应该有更新作业相关操做，未完成
        Integer currentTeachingId = teachingParam.getId();
        //先查找出没有更新前教学所有的作业项目
        List<Work> oldWorkList = workMapper.selectByParams(currentTeachingId, null, null);
        Iterator<Work> oldListIterator = oldWorkList.iterator();
        //更新时的作业项目
        List<StudentWorkProjectParam> currentWorkList = teachingParam.getWorks();
        //设置新增，修改
        for (int i = 0; i < currentWorkList.size(); i++) {
            StudentWorkProjectParam studentWorkProjectParam =  currentWorkList.get(i);
            //判断未修改，不做操作，从oldWorkList中删除
            List<Work> tempWorks = workMapper.selectByParams(currentTeachingId, studentWorkProjectParam.getStudentId(), studentWorkProjectParam.getWorkProjectId());
            if(tempWorks.size() > 0){
                //说明存在相同的作业
                while (oldListIterator.hasNext()){
                    if (tempWorks.get(0).getId() == oldListIterator.next().getId()){
                        oldListIterator.remove();
                        break;
                    }
                }
            }
            //教学id和学生id相同，说明存在作业，执行更新作业项目的操作
            //List<Work> tempWorks = workMapper.selectByParams(currentTeachingId, studentWorkProjectParam.getStudentId(), studentWorkProjectParam.getWorkProjectId());

        }
        //这只删除

        return Result.success();
    }

    /**
     * 删除教学信息
     * @param teachingParam
     * @return
     */
    public Result deleteTeaching(TeachingBaseParam teachingParam){
        Teaching teaching = new Teaching();
        BeanUtil.copyProperties(teachingParam,teaching);
        teaching.setUpdaterId(3);
        teaching.setUpdatetime(new Date());
        teaching.setIsDelete(true);
        //这里应该有删除作业的相关操作
        teachingMapper.updateByPrimaryKeySelective(teaching);
        return Result.success();
    }

    /**
     * 根据当前登录用户分页查询教学信息
     * @param param
     * @return
     */
    public Result getTeachingList(BaseListRequestParam param){
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        //这里应该是获取到当前登录用户的id
        Integer currentUserId = 1;
        List<TeachingDTO> teachingList =  teachingMapper.getTeachingDTOByCreatorId(currentUserId);
        PageInfo<TeachingDTO> pageInfo = new PageInfo<>(teachingList);
        BaseListDTO<TeachingDTO> teacherBaseListDTO = new BaseListDTO<>(pageInfo.getTotal(), teachingList);
        return Result.success(teacherBaseListDTO);
    }

    /**
     * 根据当前登录用户查询教学信息
     * @param
     * @return
     */
    public Result getTeachingByCreatorId(ConditionTeachingParam teachingParam){
        //这里应该是获取到当前登录用户的id
        Integer currentUserId = 1;
        List<TeachingDTO> teachingList =  teachingMapper.getTeachingDTOByCreatorId(currentUserId);
        return Result.success(teachingList);
    }
}
