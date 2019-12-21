package com.hit.curricelumdesign.service;

import com.hit.curricelumdesign.context.constant.Constants;
import com.hit.curricelumdesign.context.entity.Teaching;
import com.hit.curricelumdesign.context.entity.Work;
import com.hit.curricelumdesign.context.entity.WorkMessage;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.context.param.work.ScoreForWorkParam;
import com.hit.curricelumdesign.context.param.work.AddWorkParam;
import com.hit.curricelumdesign.context.param.work.UpdateWorkParam;
import com.hit.curricelumdesign.context.param.work.WorkBaseParam;
import com.hit.curricelumdesign.context.param.work.WorkBaseParam;
import com.hit.curricelumdesign.context.param.workmessage.AddWorkMessageByStudentParam;
import com.hit.curricelumdesign.context.param.workmessage.AddWorkMessageByTeacherParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.WorkMapper;
import com.hit.curricelumdesign.dao.WorkMessageMapper;
import com.hit.curricelumdesign.manager.teaching.TeachingManager;
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

    @Autowired
    private TeachingManager teachingManager;

    @Autowired
    private WorkMessageMapper workMessageMapper;


    public Result addWork(AddWorkParam workParam) {
        Work work = new Work();
        BeanUtil.copyProperties(workParam, work);
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

    public Result updateWork(UpdateWorkParam workParam) {
        //目前只存在一种情况，即更新作业中的作业项目
        Work work = new Work();
        BeanUtil.copyProperties(workParam,work);
        //设置更新时间
        work.setUpdatetime(new Date());
        workMapper.updateByPrimaryKeySelective(work);
        return Result.success();
    }

    public Result deleteWork(WorkBaseParam workParam) {
        Work work = new Work();
        BeanUtil.copyProperties(workParam,work);
        //设置删除标志位
        work.setIsDelete(Constants.Common.IS_YES);
        //设置更新时间
        work.setUpdatetime(new Date());
        workMapper.updateByPrimaryKeySelective(work);
        return Result.success();
    }

    /**
     * 评分
     *
     * @param param
     * @return
     */
    public Result score(ScoreForWorkParam param) {
        Work work = workManager.getWorkerById(param.getId());
        if (work.getStatus().compareTo(Constants.Work.WorkStatus.SUBMIT.getStatus()) != 0) {
            throw new BaseException(Error.WORK_IS_NOT_SUBMIT);
        }
        work.setStatus(Constants.Work.WorkStatus.DONE.getStatus());
        work.setScore(param.getScore());
        work.setUpdatetime(new Date());
        workMapper.updateByPrimaryKey(work);
        return Result.success();
    }

    public Result getWorkByWorkProjectId() {
        return Result.success();
    }

    public Result getWorkByStudentId() {
        return Result.success();
    }

    /**
     * 退回作业
     *
     * @param param
     * @return
     */
    public Result returnWork(WorkBaseParam param) {
        Work work = workManager.getWorkerById(param.getId());
        if (work.getStatus().compareTo(Constants.Work.WorkStatus.SUBMIT.getStatus()) != 0) {
            throw new BaseException(Error.WORK_IS_NOT_SUBMIT);
        }
        work.setStatus(Constants.Work.WorkStatus.RETURN.getStatus());
        work.setUpdatetime(new Date());
        workMapper.updateByPrimaryKey(work);
        return Result.success();
    }

    /**
     * 教师添加作业消息
     *
     * @param param
     * @return
     */
    public Result addMessageByTeacher(AddWorkMessageByTeacherParam param) {
        Work work = workManager.getWorkerById(param.getWorkId());
        Teaching teaching = teachingManager.getTeachingById(work.getTeachingId());
        WorkMessage msg = new WorkMessage();
        msg.setTeachingId(teaching.getId());
        msg.setWorkId(work.getId());
        msg.setContent(param.getContent());
        msg.setIsRead(Constants.Common.IS_NOT);
        msg.setSenderId(teaching.getTeacherId());
        msg.setSenderType(Constants.WorkMessage.SENDER_TYPE_TEACHER);
        msg.setReceiverId(work.getStudentId());
        msg.setReceiverType(Constants.WorkMessage.RECEIVER_TYPE_STUDENT);
        Date now = new Date();
        msg.setCreatetime(now);
        msg.setUpdatetime(now);
        msg.setIsDelete(Constants.Common.IS_NOT);
        workMessageMapper.insert(msg);
        return Result.success();
    }

    /**
     * 学生添加作业消息
     * @param param
     * @return
     */
    public Result addMessageByStudent(AddWorkMessageByStudentParam param) {
        Work work = workManager.getWorkerById(param.getWorkId());
        Teaching teaching = teachingManager.getTeachingById(work.getTeachingId());
        WorkMessage msg = new WorkMessage();
        msg.setTeachingId(teaching.getId());
        msg.setWorkId(work.getId());
        msg.setContent(param.getContent());
        msg.setIsRead(Constants.Common.IS_NOT);
        msg.setSenderId(work.getStudentId());
        msg.setSenderType(Constants.WorkMessage.SENDER_TYPE_STUDENT);
        msg.setReceiverId(teaching.getTeacherId());
        msg.setReceiverType(Constants.WorkMessage.RECEIVER_TYPE_TEACHER);
        Date now = new Date();
        msg.setCreatetime(now);
        msg.setUpdatetime(now);
        msg.setIsDelete(Constants.Common.IS_NOT);
        workMessageMapper.insert(msg);
        return Result.success();
    }
}
