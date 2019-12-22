package com.hit.curricelumdesign.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hit.curricelumdesign.context.constant.Constants;
import com.hit.curricelumdesign.context.dto.BaseListDTO;
import com.hit.curricelumdesign.context.dto.workmessage.WorkMessageDTO;
import com.hit.curricelumdesign.context.entity.Teaching;
import com.hit.curricelumdesign.context.entity.Work;
import com.hit.curricelumdesign.context.entity.WorkMessage;
import com.hit.curricelumdesign.context.param.workmessage.AddWorkMessageByStudentParam;
import com.hit.curricelumdesign.context.param.workmessage.AddWorkMessageByTeacherParam;
import com.hit.curricelumdesign.context.param.workmessage.GetStudentMessageParam;
import com.hit.curricelumdesign.context.param.workmessage.GetTeacherMessageParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.WorkMessageMapper;
import com.hit.curricelumdesign.manager.teaching.TeachingManager;
import com.hit.curricelumdesign.manager.work.WorkManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author xbr
 * @Date 2019-12-22
 * @ClassName WorkMessageService
 * @Description
 */
@Service
public class WorkMessageService {


    @Autowired
    private WorkMessageMapper workMessageMapper;

    @Autowired
    private WorkManager workManager;

    @Autowired
    private TeachingManager teachingManager;

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
     *
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

    /**
     * 获取教师消息
     *
     * @param param
     * @return
     */
    public Result getTeacherMessage(GetTeacherMessageParam param) {
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        List<WorkMessageDTO> workMessageDTOList = workMessageMapper.getTeacherMessageDTOByTeacherId(param.getTeacherId(), param.getRead());
        PageInfo<WorkMessageDTO> pageInfo = new PageInfo<>(workMessageDTOList);
        BaseListDTO<WorkMessageDTO> baseListDTO = new BaseListDTO<>(pageInfo.getTotal(), pageInfo.getList());
        return Result.success(baseListDTO);
    }

    /**
     * 获取教师
     *
     * @param param
     * @return
     */
    public Result getStudentMessage(GetStudentMessageParam param) {
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        List<WorkMessageDTO> workMessageDTOList = workMessageMapper.getStudentMessageDTOByStudentId(param.getStudentId(), param.getRead());
        PageInfo<WorkMessageDTO> pageInfo = new PageInfo<>(workMessageDTOList);
        BaseListDTO<WorkMessageDTO> baseListDTO = new BaseListDTO<>(pageInfo.getTotal(), pageInfo.getList());
        return Result.success(baseListDTO);
    }
}
