package com.hit.curricelumdesign.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hit.curricelumdesign.context.bo.work.AddWorkBO;
import com.hit.curricelumdesign.context.bo.work.UpdateWorkBO;
import com.hit.curricelumdesign.context.constant.Constants;
import com.hit.curricelumdesign.context.dto.BaseListDTO;
import com.hit.curricelumdesign.context.dto.teaching.TeachingInfoDTO;
import com.hit.curricelumdesign.context.dto.teaching.TeachingListDTO;
import com.hit.curricelumdesign.context.dto.work.WorkForTeacherDTO;
import com.hit.curricelumdesign.context.entity.Teaching;
import com.hit.curricelumdesign.context.entity.Work;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.context.param.teaching.*;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.TeachingMapper;
import com.hit.curricelumdesign.dao.WorkMapper;
import com.hit.curricelumdesign.dao.WorkProjectMapper;
import com.hit.curricelumdesign.manager.teaching.TeachingManager;
import com.hit.curricelumdesign.manager.work.WorkManager;
import com.hit.curricelumdesign.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Autowired
    private WorkProjectMapper workProjectMapper;

    /**
     * 教学信息详情展示
     *
     * @param teachingParam
     * @return
     */
    public Result getTeachingById(GetTeachingParam teachingParam) {
        //这里是详情展示的详细操作
        TeachingInfoDTO infoDTO = teachingManager.getTeachingDTOById(teachingParam.getId());
        return Result.success(this.setStatusDescribeAndStudentCountAndWorkStatus(infoDTO));
    }

    /**
     * 增加教学信息
     *
     * @param teachingParam
     * @return
     */
    public Result addTeaching(AddTeachingParam teachingParam) {
        if (null != teachingMapper.selectByName(teachingParam.getName())) {
            throw new BaseException(Error.TEACHING_NAME_IS_EXIST);
        }
        if (teachingParam.getTeacherReminder().length() > 500) {
            throw new BaseException(Error.TEACHER_REMINDER_OVER_LENGTH);
        }
        Teaching teaching = new Teaching();
        BeanUtil.copyProperties(teachingParam, teaching);
        teaching.setCreatorId(teachingParam.getLoginTeacherId());
        teaching.setCreatetime(new Date());
        teaching.setTeacherId(teachingParam.getLoginTeacherId());
        teaching.setUpdaterId(teachingParam.getLoginTeacherId());
        teaching.setUpdatetime(new Date());
        teaching.setIsDelete(false);
        //设置教学状态
        teaching.setStatus(0);
        //获取保存之后的教学Id
        teachingMapper.insert(teaching);
        int currentTeachingId = teaching.getId();
        //这里应该增加保存作业相关操作,未完成
        List<StudentWorkProjectParam> works = teachingParam.getWorks();
        for (int i = 0; i < works.size(); i++) {
            StudentWorkProjectParam studentWorkProjectParam = works.get(i);
            AddWorkBO workBO = new AddWorkBO();
            //设置教学id
            workBO.setTeachingId(currentTeachingId);
            //设置学生id
            workBO.setStudentId(studentWorkProjectParam.getWorkStudentId());
            //设置作业项目id
            workBO.setWorkProjectId(studentWorkProjectParam.getWorkProjectId());
            //进行作业的保存操作
            workManager.addWork(workBO);
        }
        return Result.success();
    }

    /**
     * 更新教学信息
     *
     * @param teachingParam
     * @return
     */
    public Result updateTeaching(UpdateTeachingParam teachingParam) {
        if (teachingParam.getTeacherReminder().length() > 500) {
            throw new BaseException(Error.TEACHER_REMINDER_OVER_LENGTH);
        }
        Teaching teaching = new Teaching();
        BeanUtil.copyProperties(teachingParam, teaching);
        teaching.setUpdaterId(2);
        teaching.setUpdatetime(new Date());
        teachingMapper.updateByPrimaryKeySelective(teaching);
        //这里应该有更新作业相关操做，未完成
        Integer currentTeachingId = teachingParam.getId();
        //先查找出没有更新前教学所有的作业项目
        List<Work> oldWorkList = workMapper.selectByParams(currentTeachingId, null, null, null);
        Iterator<Work> oldListIterator = oldWorkList.iterator();
        //更新时的作业项目
        List<StudentWorkProjectParam> currentWorkList = teachingParam.getWorks();
        //设置新增，修改
        for (int i = 0; i < currentWorkList.size(); i++) {
            StudentWorkProjectParam studentWorkProjectParam = currentWorkList.get(i);
            //获取老的作业项目
            Work oldWork = null;
            if (oldListIterator.hasNext()) {
                oldWork = oldListIterator.next();
            }
            //判断未修改，不做操作，从oldWorkList中删除
            List<Work> tempWorksForSame = workMapper.selectByParams(currentTeachingId, studentWorkProjectParam.getWorkStudentId(), studentWorkProjectParam.getWorkProjectId(), null);
            List<Work> tempWorksForUpdate = workMapper.selectByParams(currentTeachingId, studentWorkProjectParam.getWorkStudentId(), null, null);
            if (tempWorksForSame.size() > 0) {
                //说明存在相同的作业
                if (null != oldWork) {
                    if (tempWorksForSame.get(0).getId() == oldWork.getId() && oldWork.getWorkProjectId() == studentWorkProjectParam.getWorkProjectId()) {
                        oldListIterator.remove();
                    }
                }
            }
            //教学id和学生id相同，说明存在作业，执行更新作业项目的操作
            else if (tempWorksForUpdate.size() > 0) {
                //说明存在需要更新的作业
                if (null != oldWork) {
                    if (tempWorksForUpdate.get(0).getId() == oldWork.getId()) {
                        UpdateWorkBO updateWorkBO = new UpdateWorkBO();
                        updateWorkBO.setId(oldWork.getId());
                        updateWorkBO.setLoginStudentId(studentWorkProjectParam.getWorkStudentId());
                        updateWorkBO.setWorkProjectId(studentWorkProjectParam.getWorkProjectId());
                        //原先的作业项目,需要减少一次使用次数
                        workProjectMapper.reduceOneUseTimes(oldWork.getWorkProjectId());
                        //现在的作业项目,需要增加一次使用次数
                        workProjectMapper.increaseOneUseTimes(studentWorkProjectParam.getWorkProjectId());
                        workManager.updateWork(updateWorkBO);
                        oldListIterator.remove();
                    }
                }
                continue;
            } else {
                //这里是新增操作
                AddWorkBO addWorkBO = new AddWorkBO();
                addWorkBO.setTeachingId(currentTeachingId);
                addWorkBO.setStudentId(studentWorkProjectParam.getWorkStudentId());
                //新增作业时,需要增加作业项目的使用次数,已经在mapper增加作业的方法中进行了增加,这里不需要处理
                addWorkBO.setWorkProjectId(studentWorkProjectParam.getWorkProjectId());
                workManager.addWork(addWorkBO);
            }


        }
        //这里是删除弃用的作业
        for (int i = 0; i < oldWorkList.size(); i++) {
            Work next = oldWorkList.get(i);
            next.setIsDelete(Constants.Common.IS_YES);
            next.setUpdatetime(new Date());
            //弃用的作业,需要减少一次作业项目
            workProjectMapper.reduceOneUseTimes(next.getWorkProjectId());
            workMapper.updateByPrimaryKeySelective(next);
        }
        return Result.success();
    }

    /**
     * 根据当前登录用户查询教学信息,目前教师的id是传送过来的
     *
     * @param
     * @return
     */
    public Result getTeachingByCreatorId(ConditionTeachingParam teachingParam) {
        PageHelper.startPage(teachingParam.getPageNum(), teachingParam.getPageSize());
        //这里应该是获取到当前登录用户的id
        Integer currentUserId = teachingParam.getLoginTeacherId();
        Integer status = teachingParam.getStatus();
        List<TeachingListDTO> teachingList = teachingMapper.getTeachingDTOByCreatorIdAndStatus(currentUserId, status);
        //这里设置教学当前的状态和教学涉及到的教学人数,以及更新作业的状态
        List<TeachingListDTO> newTeachingList = new ArrayList<>();
        for (int i = 0; i < teachingList.size(); i++) {
            newTeachingList.add(this.setStatusDescribeAndStudentCount(teachingList.get(i)));
        }
        PageInfo<TeachingListDTO> pageInfo = new PageInfo<>(newTeachingList);
        BaseListDTO<TeachingListDTO> newTeachingDTOList = new BaseListDTO<>(pageInfo.getTotal(), newTeachingList);
        return Result.success(newTeachingDTOList);
    }

    private TeachingListDTO setStatusDescribeAndStudentCount(TeachingListDTO teachingListDTO) {
        //设置教学中参与学生人数
        Long studentCount = workMapper.countStudentsByTeachingId(teachingListDTO.getId());
        teachingListDTO.setStudentCount(studentCount);
        //设置教学状体
        teachingListDTO.setStatusDescribe(Constants.Teaching.TeachingStatus.getDescByStat(teachingListDTO.getStatus()));
        //设置作业状态
   /*     List<WorkForTeacherDTO> workForTeacherDTOList = teachingListDTO.getWorkForTeacherDTOList();
        List<WorkForTeacherDTO> newWorkList = new ArrayList<>();
        for (int i = 0; i < workForTeacherDTOList.size(); i++) {
            WorkForTeacherDTO currentWorkDTO = workForTeacherDTOList.get(i);
            currentWorkDTO.setStatusDescribe(Constants.Work.WorkStatus.getDescByStat(workForTeacherDTOList.get(i).getStatus()));
            newWorkList.add(currentWorkDTO);
        }
        teachingListDTO.setWorkForTeacherDTOList(newWorkList);*/
        return teachingListDTO;
    }

    private TeachingInfoDTO setStatusDescribeAndStudentCountAndWorkStatus(TeachingInfoDTO teachingInfoDTO) {
        //设置教学中参与学生人数
        Long studentCount = workMapper.countStudentsByTeachingId(teachingInfoDTO.getId());
        teachingInfoDTO.setStudentCount(studentCount);
        //设置教学状体
        teachingInfoDTO.setStatusDescribe(Constants.Teaching.TeachingStatus.getDescByStat(teachingInfoDTO.getStatus()));
        //设置作业状态
        List<WorkForTeacherDTO> workForTeacherDTOList = teachingInfoDTO.getWorkForTeacherDTOList();
        List<WorkForTeacherDTO> newWorkList = new ArrayList<>();
        for (int i = 0; i < workForTeacherDTOList.size(); i++) {
            WorkForTeacherDTO currentWorkDTO = workForTeacherDTOList.get(i);
            currentWorkDTO.setStatusDescribe(Constants.Work.WorkStatus.getDescByStat(workForTeacherDTOList.get(i).getStatus()));
            newWorkList.add(currentWorkDTO);
        }
        teachingInfoDTO.setWorkForTeacherDTOList(newWorkList);
        return teachingInfoDTO;
    }


    @Scheduled(cron = "0 0 0 * * ? ")
    public void scanTeachingAndUpdateStatus(){
        //每天执行一次
        //查找所有状态时批阅中的教学
        //比对截至时间，进行状态修改
        List<Teaching> teachingInChecking = teachingMapper.getunFinishedTeaching();
        for (int i = 0; i < teachingInChecking.size(); i++) {
            Teaching teaching = teachingInChecking.get(i);
            //获取到教学的截至时间
            long deadLinTime = teaching.getDeadlineTime().getTime();
            //获取到当前的系统时间
            long currentTime = new Date().getTime();
            //判断是否进行状态变更
            if (currentTime >= deadLinTime){
                //更改状态
                teaching.setStatus(Constants.Teaching.TeachingStatus.CHECKED.getStatus());
                //执行更新
                teachingMapper.updateByPrimaryKeySelective(teaching);
            }
        }
    }
}
