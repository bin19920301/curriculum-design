package com.hit.curricelumdesign.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hit.curricelumdesign.context.constant.Constants;
import com.hit.curricelumdesign.context.dto.BaseListDTO;
import com.hit.curricelumdesign.context.dto.teachingmessage.TeachingMessageInfoDTO;
import com.hit.curricelumdesign.context.dto.teachingmessage.TeachingMessageListDTO;
import com.hit.curricelumdesign.context.entity.TeachingMessage;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.context.param.teachingmessage.AddTeachingMessageParam;
import com.hit.curricelumdesign.context.param.teachingmessage.ListByTeachingIdParam;
import com.hit.curricelumdesign.context.param.teachingmessage.TeachingMessageBaseParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.TeachingMapper;
import com.hit.curricelumdesign.dao.TeachingMessageMapper;
import com.hit.curricelumdesign.dao.WorkMapper;
import com.hit.curricelumdesign.manager.teachingmessage.TeachingMessageManager;
import com.hit.curricelumdesign.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TeachingMessageService {

    @Autowired
    private TeachingMessageManager teachingMessageManager;
    @Autowired
    private TeachingMessageMapper teachingMessageMapper;
    @Autowired
    private WorkMapper workMapper;

    public Result addTeacherMessage(AddTeachingMessageParam param) {
        TeachingMessage message = new TeachingMessage();
        BeanUtil.copyProperties(param, message);
        message.setSenderId(param.getLoginTeacherId());
        //message.setSenderId(1);
        message.setSenderType(Constants.TeachingMessage.SENDER_TYPE_TEACHER);
        message.setCreatetime(new Date());
        message.setUpdatetime(new Date());
        message.setIsDelete(Constants.Common.IS_NOT);
        teachingMessageMapper.insert(message);
        return Result.success();
    }

    public Result addStudentMessage(AddTeachingMessageParam param) {
        TeachingMessage message = new TeachingMessage();
        BeanUtil.copyProperties(param, message);
        message.setSenderId(param.getLoginStudentId());
        //message.setSenderId(1);
        message.setSenderType(Constants.TeachingMessage.SENDER_TYPE_STUDENT);
        message.setCreatetime(new Date());
        message.setUpdatetime(new Date());
        message.setIsDelete(Constants.Common.IS_NOT);
        teachingMessageMapper.insert(message);
        return Result.success();
    }

    public Result deleteTeacherMessage(TeachingMessageBaseParam param) {
        TeachingMessage message = teachingMessageManager.getById(param.getId());
        if (!param.getLoginTeacherId().equals(message.getSenderId()) || Constants.TeachingMessage.SENDER_TYPE_TEACHER.equals(message.getSenderType())) {
            throw new BaseException(Error.TEACHING_MESSAGE_ONLY_DELETE_BY_SELF);
        }
        message.setUpdatetime(new Date());
        message.setIsDelete(Constants.Common.IS_YES);
        teachingMessageMapper.updateByPrimaryKeySelective(message);
        return Result.success();
    }

    public Result deleteStudentMessage(TeachingMessageBaseParam param) {
        TeachingMessage message = teachingMessageManager.getById(param.getId());
        if (!param.getLoginStudentId().equals(message.getSenderId()) || Constants.TeachingMessage.SENDER_TYPE_STUDENT.equals(message.getSenderType())) {
            throw new BaseException(Error.TEACHING_MESSAGE_ONLY_DELETE_BY_SELF);
        }
        message.setUpdatetime(new Date());
        message.setIsDelete(Constants.Common.IS_YES);
        teachingMessageMapper.updateByPrimaryKeySelective(message);
        return Result.success();
    }

    public Result teacherListTeachingMessageByTeachingId(ListByTeachingIdParam param) {
        PageHelper.startPage(param.getPageNum(), param.getPageSize(), " f_createtime asc ");
        List<TeachingMessageInfoDTO> teachingMessageInfoDTOList = teachingMessageMapper.listByTeachingId(param.getTeachingId());
        for (TeachingMessageInfoDTO dto : teachingMessageInfoDTOList) {
            if (dto.getSenderType().compareTo(Constants.WorkMessage.SENDER_TYPE_STUDENT) == 0) {
                dto.setCanDelete(Constants.Common.NOT);
            } else if (dto.getSenderType().compareTo(Constants.WorkMessage.SENDER_TYPE_TEACHER) == 0) {
                dto.setCanDelete(Constants.Common.YES);
            }
        }
        PageInfo<TeachingMessageInfoDTO> pageInfo = new PageInfo<>(teachingMessageInfoDTOList);
        BaseListDTO<TeachingMessageInfoDTO> baseListDTO = new BaseListDTO<>(pageInfo.getTotal(), pageInfo.getList());
        TeachingMessageListDTO teachingMessageListDTO = new TeachingMessageListDTO();
        teachingMessageListDTO.setTeachingMessageInfoDTOBaseListDTO(baseListDTO);
        teachingMessageListDTO.setStudentCount(workMapper.countStudentsByTeachingId(param.getTeachingId()));
        return Result.success(teachingMessageListDTO);
    }

    public Result studentListTeachingMessageByTeachingId(ListByTeachingIdParam param) {
        PageHelper.startPage(param.getPageNum(), param.getPageSize(), " f_createtime asc ");
        List<TeachingMessageInfoDTO> teachingMessageInfoDTOList = teachingMessageMapper.listByTeachingId(param.getTeachingId());
        for (TeachingMessageInfoDTO dto : teachingMessageInfoDTOList) {
            if (dto.getSenderType().compareTo(Constants.WorkMessage.SENDER_TYPE_STUDENT) == 0) {
                dto.setCanDelete(Constants.Common.YES);
            } else if (dto.getSenderType().compareTo(Constants.WorkMessage.SENDER_TYPE_TEACHER) == 0) {
                dto.setCanDelete(Constants.Common.NOT);
            }
        }
        PageInfo<TeachingMessageInfoDTO> pageInfo = new PageInfo<>(teachingMessageInfoDTOList);
        BaseListDTO<TeachingMessageInfoDTO> baseListDTO = new BaseListDTO<>(pageInfo.getTotal(), pageInfo.getList());
        TeachingMessageListDTO teachingMessageListDTO = new TeachingMessageListDTO();
        teachingMessageListDTO.setTeachingMessageInfoDTOBaseListDTO(baseListDTO);
        teachingMessageListDTO.setStudentCount(workMapper.countStudentsByTeachingId(param.getTeachingId()));
        return Result.success(teachingMessageListDTO);
    }
}
