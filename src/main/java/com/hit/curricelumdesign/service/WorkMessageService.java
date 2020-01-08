package com.hit.curricelumdesign.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hit.curricelumdesign.context.constant.Constants;
import com.hit.curricelumdesign.context.dto.BaseListDTO;
import com.hit.curricelumdesign.context.dto.student.StudentDTO;
import com.hit.curricelumdesign.context.dto.teacher.TeacherDTO;
import com.hit.curricelumdesign.context.dto.workmessage.WorkMessageDTO;
import com.hit.curricelumdesign.context.dto.workmessage.WorkMessageInfoDTO;
import com.hit.curricelumdesign.context.entity.Teaching;
import com.hit.curricelumdesign.context.entity.Work;
import com.hit.curricelumdesign.context.entity.WorkMessage;
import com.hit.curricelumdesign.context.param.BaseRequestParam;
import com.hit.curricelumdesign.context.param.workmessage.*;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.WorkMessageMapper;
import com.hit.curricelumdesign.manager.student.StudentManager;
import com.hit.curricelumdesign.manager.teacher.TeacherManager;
import com.hit.curricelumdesign.manager.teaching.TeachingManager;
import com.hit.curricelumdesign.manager.work.WorkManager;
import com.hit.curricelumdesign.manager.workmessage.WorkMessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private WorkMessageManager workMessageManager;

    @Autowired
    private WorkManager workManager;

    @Autowired
    private TeachingManager teachingManager;

    @Autowired
    private StudentManager studentManager;

    @Autowired
    private TeacherManager teacherManager;

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
        msg.setSenderId(param.getLoginTeacherId());
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
        msg.setSenderId(param.getLoginStudentId());
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
        List<WorkMessageDTO> workMessageDTOList = workMessageMapper.getTeacherMessageDTOByTeacherId(param.getLoginTeacherId(), param.getRead());
        PageInfo<WorkMessageDTO> pageInfo = new PageInfo<>(workMessageDTOList);
        BaseListDTO<WorkMessageDTO> baseListDTO = new BaseListDTO<>(pageInfo.getTotal(), pageInfo.getList());
        return Result.success(baseListDTO);
    }

    /**
     * 获取学生消息
     *
     * @param param
     * @return
     */
    public Result getStudentMessage(GetStudentMessageParam param) {
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        List<WorkMessageDTO> workMessageDTOList = workMessageMapper.getStudentMessageDTOByStudentId(param.getLoginStudentId(), param.getRead());
        PageInfo<WorkMessageDTO> pageInfo = new PageInfo<>(workMessageDTOList);
        BaseListDTO<WorkMessageDTO> baseListDTO = new BaseListDTO<>(pageInfo.getTotal(), pageInfo.getList());
        return Result.success(baseListDTO);
    }

    /**
     * 获取教师未读消息总数
     *
     * @param param
     * @return
     */
    public Result countTeacherUnreadMessage(BaseRequestParam param) {
        long total = workMessageMapper.countTeacherUnreadMessage(param.getLoginTeacherId());
        Map<String, Long> result = new HashMap<>();
        result.put("total", total);
        return Result.success(result);
    }

    /**
     * 获取学生未读消息总数
     *
     * @param param
     * @return
     */
    public Result countStudentUnreadMessage(BaseRequestParam param) {
        long total = workMessageMapper.countStudentUnreadMessage(param.getLoginStudentId());
        Map<String, Long> result = new HashMap<>();
        result.put("total", total);
        return Result.success(result);
    }

    /**
     * 删除教师消息
     *
     * @param param
     * @return
     */
    public Result deleteTeahcerMessage(WorkMessageBaseParam param) {
        WorkMessage workMessage = workMessageManager.getWorkMessageById(param.getId());
        workMessage.setIsDelete(Constants.Common.IS_YES);
        workMessage.setUpdatetime(new Date());
        workMessageMapper.updateByPrimaryKey(workMessage);
        return Result.success();
    }

    /**
     * 删除学生消息
     *
     * @param param
     * @return
     */
    public Result deleteStudentMessage(WorkMessageBaseParam param) {
        WorkMessage workMessage = workMessageManager.getWorkMessageById(param.getId());
        workMessage.setIsDelete(Constants.Common.IS_YES);
        workMessage.setUpdatetime(new Date());
        workMessageMapper.updateByPrimaryKey(workMessage);
        return Result.success();
    }

    /**
     * 获取作业消息列表
     *
     * @param param
     * @return
     */
    public Result listWorkMessage(WorkMessageListParam param) {
        Work work = workManager.getWorkerById(param.getWorkId());
        StudentDTO student = studentManager.getStudentById(param.getLoginStudentId());
        Teaching teaching = teachingManager.getTeachingById(work.getTeachingId());
        TeacherDTO teacher = teacherManager.getTeacherById(teaching.getTeacherId());
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        List<WorkMessageInfoDTO> workMessageInfoDTOList = workMessageMapper.getWorkMessageInfoDTOByWorkId(work.getId());
        for (WorkMessageInfoDTO message : workMessageInfoDTOList) {
            if (message.getSenderType().compareTo(Constants.WorkMessage.SENDER_TYPE_STUDENT) == 0) {
                message.setSenderName(student.getName());
            } else if (message.getSenderType().compareTo(Constants.WorkMessage.SENDER_TYPE_TEACHER) == 0) {
                message.setSenderName(teacher.getName());
            }
        }
        PageInfo<WorkMessageInfoDTO> pageInfo = new PageInfo<>(workMessageInfoDTOList);

        BaseListDTO<WorkMessageInfoDTO> baseListDTO = new BaseListDTO<>(pageInfo.getTotal(), pageInfo.getList());
        return Result.success(baseListDTO);
    }
}
