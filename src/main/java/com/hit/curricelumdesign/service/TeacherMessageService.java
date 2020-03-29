package com.hit.curricelumdesign.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hit.curricelumdesign.context.constant.Constants;
import com.hit.curricelumdesign.context.dto.BaseListDTO;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.dto.teachermessage.TeacherMessageInfoDTO;
import com.hit.curricelumdesign.context.entity.TeacherMessage;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.context.param.BaseListRequestParam;
import com.hit.curricelumdesign.context.param.teachermessage.AddTeacherMessageParam;
import com.hit.curricelumdesign.context.param.teachermessage.ListLastTeacherMessageParam;
import com.hit.curricelumdesign.context.param.teachermessage.ListTeacherMessageParam;
import com.hit.curricelumdesign.context.param.teachermessage.TeacherMessageBaseParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.TeacherMessageMapper;
import com.hit.curricelumdesign.manager.teacherMessage.TeacherMessageManager;
import com.hit.curricelumdesign.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TeacherMessageService {

    @Autowired
    private TeacherMessageMapper teacherMessageMapper;
    @Autowired
    private TeacherMessageManager teacherMessageManager;

    public Result addTeacherMessage(AddTeacherMessageParam param) {
        TeacherMessage message = new TeacherMessage();
        BeanUtil.copyProperties(param, message);
        message.setCreatorId(param.getLoginTeacherId());
        //message.setCreatorId(1);
        message.setCreatetime(new Date());
        message.setUpdatetime(new Date());
        message.setIsDelete(Constants.Common.IS_NOT);
        teacherMessageMapper.insert(message);
        return Result.success();
    }

    public Result deleteTeacherMessage(TeacherMessageBaseParam param) {
        TeacherMessage message = teacherMessageManager.getById(param.getId());
        if (param.getLoginTeacherId() != message.getCreatorId()) {
            throw new BaseException(Error.TEACHER_MESSAGE_ONLY_DELETE_BY_SELF);
        }
        message.setIsDelete(Constants.Common.IS_YES);
        message.setUpdatetime(new Date());
        teacherMessageMapper.updateByPrimaryKeySelective(message);
        return Result.success();
    }

    public Result listTeacherMessage(ListTeacherMessageParam param) {
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        List<TeacherMessageInfoDTO> teacherMessageDTOList = teacherMessageMapper.listTeacherMessageDTO(param.getStartId());
        for (TeacherMessageInfoDTO dto : teacherMessageDTOList) {
            if (dto.getCreatorId().compareTo(param.getLoginTeacherId()) == 0) {
                dto.setCanDelete(Constants.Common.YES);
            } else {
                dto.setCanDelete(Constants.Common.NOT);
            }
        }
        PageInfo<TeacherMessageInfoDTO> pageInfo = new PageInfo<>(teacherMessageDTOList);
        BaseListDTO<TeacherMessageInfoDTO> baseListDTO = new BaseListDTO<>(pageInfo.getTotal(), pageInfo.getList());
        return Result.success(baseListDTO);
    }

    public Result listLastTeacherMessage(ListLastTeacherMessageParam param) {
        //获取当前消息,顺便做下id验证
        TeacherMessage currentMessage = teacherMessageManager.getById(param.getLastId());
        List<TeacherMessageInfoDTO> teacherMessageDTOList = teacherMessageMapper.listLastTeacherMessageDTO(currentMessage.getId());
        for (TeacherMessageInfoDTO dto : teacherMessageDTOList) {
            if (dto.getCreatorId().compareTo(param.getLoginTeacherId()) == 0) {
                dto.setCanDelete(Constants.Common.YES);
            } else {
                dto.setCanDelete(Constants.Common.NOT);
            }
        }
        return Result.success(teacherMessageDTOList);
    }
}
