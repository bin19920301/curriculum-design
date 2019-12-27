package com.hit.curricelumdesign.service;

import com.github.pagehelper.PageHelper;
import com.hit.curricelumdesign.context.constant.Constants;
import com.hit.curricelumdesign.context.dto.BaseListDTO;
import com.hit.curricelumdesign.context.dto.craftcard.CraftCardInfoDTO;
import com.hit.curricelumdesign.context.dto.file.FileListDTO;
import com.hit.curricelumdesign.context.dto.student.StudentDTO;
import com.hit.curricelumdesign.context.dto.teacher.TeacherDTO;
import com.hit.curricelumdesign.context.dto.teaching.WorkTeachingDTO;
import com.hit.curricelumdesign.context.dto.work.WorkInfoDTO;
import com.hit.curricelumdesign.context.dto.work.WorkInfoListDTO;
import com.hit.curricelumdesign.context.dto.workmessage.WorkMessageInfoDTO;
import com.hit.curricelumdesign.context.dto.workproject.WorkProjectInfoDTO;
import com.hit.curricelumdesign.context.entity.*;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.context.param.work.*;
import com.hit.curricelumdesign.context.param.work.WorkBaseParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.*;
import com.hit.curricelumdesign.manager.craftcard.CraftCardManager;
import com.hit.curricelumdesign.manager.student.StudentManager;
import com.hit.curricelumdesign.manager.teacher.TeacherManager;
import com.hit.curricelumdesign.manager.work.WorkManager;
import com.hit.curricelumdesign.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class WorkService {

    @Autowired
    private WorkMapper workMapper;

    @Autowired
    private WorkManager workManager;

    @Autowired
    private WorkMessageMapper workMessageMapper;

    @Autowired
    private CraftCardManager craftCardManager;

    @Autowired
    private CraftCardMapper craftCardMapper;

    @Autowired
    private TeachingMapper teachingMapper;

    @Autowired
    private WorkProjectMapper workProjectMapper;

    @Autowired
    private FileMapper fileMapper;

    @Autowired
    private TeacherManager teacherManager;

    @Autowired
    private StudentManager studentManager;


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
     * 添加工艺卡片列表
     *
     * @param param
     * @return
     */
    @Transactional
    public Result addCraftCardList(AddCraftCardListParam param) {
        Integer workId = param.getWorkId();
        Work work = workManager.getWorkerById(workId);
        List<AddCraftCardParam> paramList = param.getList();
        List<CraftCard> newCraftCardList = new ArrayList<>();
        List<CraftCard> updateCraftCardList = new ArrayList<>();
        List<CraftCard> deleteCraftCardList = new ArrayList<>();

        List<CraftCard> oldCraftCardList = craftCardMapper.getCraftCardListByWorkId(param.getWorkId());

        for (int i = 0; i < paramList.size(); i++) {
            AddCraftCardParam addCraftCardParam = paramList.get(i);
            if (null == addCraftCardParam.getCraftCardId()) {
                newCraftCardList.add(buildCraftCard(addCraftCardParam, workId));
                continue;
            } else {
                if (oldCraftCardList.isEmpty()) {
                    newCraftCardList.add(buildCraftCard(addCraftCardParam, workId));
                    break;
                }
                for (int j = 0; j < oldCraftCardList.size(); j++) {
                    CraftCard craftCard = oldCraftCardList.get(j);
                    if (addCraftCardParam.getCraftCardId().compareTo(craftCard.getId()) == 0) {
                        BeanUtil.copyProperties(addCraftCardParam, craftCard);
                        craftCard.setUpdatetime(new Date());
                        updateCraftCardList.add(craftCard);
                        oldCraftCardList.remove(j);
                        break;
                    }
                    if (j == (oldCraftCardList.size() - 1)) {
                        //如果有匹配的旧的工艺卡片,则添加新的
                        newCraftCardList.add(buildCraftCard(addCraftCardParam, workId));
                    }
                }
            }
        }
        deleteCraftCardList.addAll(oldCraftCardList);

        for (CraftCard craftCard : deleteCraftCardList) {
            craftCard.setIsDelete(Constants.Common.IS_YES);
            craftCard.setUpdatetime(new Date());
        }

        //保存新的工艺卡片
        Long i = craftCardManager.insertCraftCardList(newCraftCardList);
        //更新工艺卡片
        craftCardManager.updateCraftCardList(updateCraftCardList);
        //删除工艺卡片
        craftCardManager.updateCraftCardList(deleteCraftCardList);


        return Result.success();
    }

    private CraftCard buildCraftCard(AddCraftCardParam addCraftCardParam, Integer workId) {
        CraftCard craftCard = new CraftCard();
        craftCard.setWorkId(workId);
        BeanUtil.copyProperties(addCraftCardParam, craftCard);
        craftCard.setIsDelete(Constants.Common.IS_NOT);
        craftCard.setCreatorId(0);
        craftCard.setUpdaterId(0);
        Date now = new Date();
        craftCard.setCreatetime(now);
        craftCard.setUpdatetime(now);
        return craftCard;
    }

    /**
     * 提交作业
     *
     * @param param
     * @return
     */
    public Result submitWork(WorkBaseParam param) {
        Work work = workManager.getWorkerById(param.getId());
        if (work.getStatus().compareTo(Constants.Work.WorkStatus.SUBMIT.getStatus()) == 0) {
            throw new BaseException(Error.WORK_IS_SUBMIT);
        }
        if (work.getStatus().compareTo(Constants.Work.WorkStatus.DONE.getStatus()) == 0) {
            throw new BaseException(Error.WORK_IS_DONE);
        }
        work.setStatus(Constants.Work.WorkStatus.SUBMIT.getStatus());
        work.setUpdatetime(new Date());
        workMapper.updateByPrimaryKey(work);
        return Result.success();
    }

    /**
     * 获取作业详情
     *
     * @param param
     * @return
     */
    public Result getWorkInfoById(WorkBaseParam param) {
        WorkInfoDTO workInfoDTO = new WorkInfoDTO();

        Work work = workManager.getWorkerById(param.getId());
        workInfoDTO.setWorkId(work.getId());
        workInfoDTO.setStatus(work.getStatus());
        WorkTeachingDTO workTeachingDTO = teachingMapper.getWorkTeachingDTOById(work.getTeachingId());
        if (null == workTeachingDTO) {
            throw new BaseException(Error.TEACHING_IS_NOT_EXIST);
        }

        WorkProjectInfoDTO workProjectInfoDTO = workProjectMapper.getWorkProjectInfoById(work.getWorkProjectId());
        if (null == workProjectInfoDTO) {
            throw new BaseException(Error.WORK_PROJECT_IS_NOT_EXIST);
        }

        List<FileListDTO> fileListDTOList = fileMapper.getFileListDTOByWorkProjectId(workProjectInfoDTO.getId());
        workProjectInfoDTO.setFilelist(fileListDTOList);

        workInfoDTO.setTeaching(workTeachingDTO);

        workInfoDTO.setWorkProjectInfoDTO(workProjectInfoDTO);

        List<CraftCardInfoDTO> craftCardInfoDTOList = craftCardMapper.getCraftCardInfoDTOListByWorkId(work.getId());
        workInfoDTO.setCraftCardInfoDTOList(craftCardInfoDTOList);
        TeacherDTO teacher = teacherManager.getTeacherById(workTeachingDTO.getTeacherId());
        StudentDTO student = studentManager.getStudentById(work.getStudentId());
        workInfoDTO.setStudentName(student.getName());
        List<WorkMessageInfoDTO> workMessageInfoDTOList = workMessageMapper.getWorkMessageInfoDTOByWorkId(work.getId());
        for (WorkMessageInfoDTO message : workMessageInfoDTOList) {
            if (message.getSenderType().compareTo(Constants.WorkMessage.SENDER_TYPE_STUDENT) == 0) {
                message.setSenderName(student.getName());
            } else if (message.getSenderType().compareTo(Constants.WorkMessage.SENDER_TYPE_TEACHER) == 0) {
                message.setSenderName(teacher.getName());
            }

        }
        workInfoDTO.setWorkMessageInfoDTOList(workMessageInfoDTOList);

        return Result.success(workInfoDTO);
    }

    /**
     * 根据学生id查询作业列表
     *
     * @param param
     * @return
     */
    public Result getWorkListByStudentId(GetWorkListByStudentIdParam param) {
        PageHelper.startPage(param.getPageNum(), param.getPageSize(), " f_createtime desc");

        List<Work> workList = workMapper.selectByParams(null, param.getLoginStudentId(), null, param.getIsDone());

        List<WorkInfoListDTO> workInfoListDTOList = new ArrayList<>();

        for (Work work : workList) {
            WorkInfoListDTO workInfoListDTO = new WorkInfoListDTO();
            workInfoListDTO.setWorkId(work.getId());
            workInfoListDTO.setStatus(work.getStatus());
            WorkTeachingDTO workTeachingDTO = teachingMapper.getWorkTeachingDTOById(work.getTeachingId());
            workInfoListDTO.setWorkTeachingDTO(workTeachingDTO);
            workInfoListDTOList.add(workInfoListDTO);
        }

        BaseListDTO<WorkInfoListDTO> workInfoListDTOBaseListDTO = new BaseListDTO<WorkInfoListDTO>(workList.size(), workInfoListDTOList);

        return Result.success(workInfoListDTOBaseListDTO);
    }
}
