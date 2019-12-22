package com.hit.curricelumdesign.service;

import com.hit.curricelumdesign.context.constant.Constants;
import com.hit.curricelumdesign.context.entity.CraftCard;
import com.hit.curricelumdesign.context.entity.Teaching;
import com.hit.curricelumdesign.context.entity.Work;
import com.hit.curricelumdesign.context.entity.WorkMessage;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.context.param.work.*;
import com.hit.curricelumdesign.context.param.work.WorkBaseParam;
import com.hit.curricelumdesign.context.param.workmessage.AddWorkMessageByStudentParam;
import com.hit.curricelumdesign.context.param.workmessage.AddWorkMessageByTeacherParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.CraftCardMapper;
import com.hit.curricelumdesign.dao.WorkMapper;
import com.hit.curricelumdesign.dao.WorkMessageMapper;
import com.hit.curricelumdesign.manager.craftcard.CraftCardManager;
import com.hit.curricelumdesign.manager.teaching.TeachingManager;
import com.hit.curricelumdesign.manager.work.WorkManager;
import com.hit.curricelumdesign.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
    private TeachingManager teachingManager;

    @Autowired
    private WorkMessageMapper workMessageMapper;

    @Autowired
    private CraftCardManager craftCardManager;

    @Autowired
    private CraftCardMapper craftCardMapper;


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
        BeanUtil.copyProperties(workParam, work);
        //设置更新时间
        work.setUpdatetime(new Date());
        workMapper.updateByPrimaryKeySelective(work);
        return Result.success();
    }

    public Result deleteWork(WorkBaseParam workParam) {
        Work work = new Work();
        BeanUtil.copyProperties(workParam, work);
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
}
