package com.hit.curricelumdesign.service;

import com.github.pagehelper.PageHelper;
import com.hit.curricelumdesign.context.constant.Constants;
import com.hit.curricelumdesign.context.dto.BaseListDTO;
import com.hit.curricelumdesign.context.dto.file.FileListDTO;
import com.hit.curricelumdesign.context.dto.student.StudentDTO;
import com.hit.curricelumdesign.context.dto.teacher.TeacherDTO;
import com.hit.curricelumdesign.context.dto.teaching.WorkTeachingDTO;
import com.hit.curricelumdesign.context.dto.work.WorkInfoDTO;
import com.hit.curricelumdesign.context.dto.work.WorkInfoForStudentDTO;
import com.hit.curricelumdesign.context.dto.work.WorkInfoListDTO;
import com.hit.curricelumdesign.context.dto.workfile.WorkFileDTO;
import com.hit.curricelumdesign.context.dto.workproject.WorkProjectInfoDTO;
import com.hit.curricelumdesign.context.dto.workproject.WorkProjectInfoForStudentDTO;
import com.hit.curricelumdesign.context.entity.*;
import com.hit.curricelumdesign.context.entity.Process;
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
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

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

    @Autowired
    private WorkFileMapper workFileMapper;

    @Autowired
    private CardMapper cardMapper;

    @Autowired
    private ProcessMapper processMapper;

    @Autowired
    private WorkingPositionMapper workingPositionMapper;

    @Autowired
    private WorkingStepMapper workingStepMapper;

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
        workMapper.updateByPrimaryKeySelective(work);
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
        workMapper.updateByPrimaryKeySelective(work);
        return Result.success();
    }


    /**
     * 添加工艺卡片列表
     *
     * @param param
     * @return
     */
    @Transactional
    public Result addCard(AddCardParam param) {
        Integer workId = param.getWorkId();
        Integer studentId = param.getLoginStudentId();
        Work work = workManager.getWorkerById(workId);
        Card card = null;
        Date now = new Date();
        Integer cardId = null;
        if (!Objects.isNull(param.getWorkId())) {
            card = cardMapper.selectByWorkId(param.getWorkId());
        }

        //添加工艺卡片
        if (Objects.isNull(card)) {
            card = getNewCard(param, workId, studentId, now);
            cardId = card.getId();
        } else {
            BeanUtil.copyProperties(param, card);
            cardMapper.updateByPrimaryKeySelective(card);
            cardId = card.getId();
        }
        List<Process> processExistList = processMapper.selectByCardId(cardId);
        Map<Integer, Process> processExistIdMap = new HashMap<>();
        if (CollectionUtils.isNotEmpty(processExistList)) {
            processExistIdMap = processExistList.stream().collect(Collectors.toMap(process -> process.getId(), process -> process, (v1, v2) -> v2));
        }
        List<WorkingPosition> workingPositionExistList = workingPositionMapper.selectByCardId(cardId);
        Map<Integer, WorkingPosition> workingPositionExistIdMap = new HashMap<>();
        if (CollectionUtils.isNotEmpty(workingPositionExistList)) {
            workingPositionExistIdMap = workingPositionExistList.stream().collect(Collectors.toMap(workingPosition -> workingPosition.getId(), workingPosition -> workingPosition, (v1, v2) -> v2));
        }
        List<WorkingStep> workingStepExistList = workingStepMapper.selectByCardId(cardId);
        Map<Integer, WorkingStep> workingStepExistIdMap = new HashMap<>();
        if (CollectionUtils.isNotEmpty(workingStepExistList)) {
            workingStepExistIdMap = workingStepExistList.stream().collect(Collectors.toMap(workingStep -> workingStep.getId(), workingStep -> workingStep, (v1, v2) -> v2));
        }

        //添加工序
        List<ProcessParam> processParamList = param.getProcessList();
        if (CollectionUtils.isNotEmpty(processParamList)) {
            for (ProcessParam processParam : processParamList) {
                Process process = null;
                if (Objects.isNull(processParam.getProcessId())) {
                    process = getNewProcess(studentId, now, cardId, processParam);
                } else {
                    if (processExistIdMap.containsKey(processParam.getProcessId())) {
                        process = processExistIdMap.get(processParam.getProcessId());
                        BeanUtil.copyProperties(processParam, process);
                        process.setUpdatetime(now);
                        processMapper.updateByPrimaryKeySelective(process);
                        processExistList.remove(process);
                    } else {
                        process = getNewProcess(studentId, now, cardId, processParam);
                    }
                }
                List<WorkingPositionParam> workingPositionParamList = processParam.getWorkingPositionList();
                if (CollectionUtils.isNotEmpty(workingPositionParamList)) {
                    for (WorkingPositionParam workingPositionParam : workingPositionParamList) {
                        WorkingPosition workingPosition = null;
                        //添加工位
                        if (Objects.isNull(workingPositionParam.getWorkingPositionId())) {
                            workingPosition = getNewWorkingPosition(studentId, now, cardId, process, workingPositionParam);
                        } else {
                            if (workingPositionExistIdMap.containsKey(workingPositionParam.getWorkingPositionId())) {
                                workingPosition = workingPositionExistIdMap.get(workingPositionParam.getWorkingPositionId());
                                BeanUtil.copyProperties(workingPositionParam, workingPosition);
                                workingPosition.setUpdatetime(now);
                                workingPositionMapper.updateByPrimaryKeySelective(workingPosition);
                                workingPositionExistList.remove(workingPosition);
                            } else {
                                workingPosition = getNewWorkingPosition(studentId, now, cardId, process, workingPositionParam);
                            }
                        }
                        //添加工步
                        List<WorkingStepParam> workingStepParamList = workingPositionParam.getWorkingStepList();
                        if (CollectionUtils.isNotEmpty(workingStepParamList)) {
                            for (WorkingStepParam workingStepParam : workingStepParamList) {
                                if (workingStepExistIdMap.containsKey(workingStepParam.getWorkingStepId())) {
                                    WorkingStep workingStep = workingStepExistIdMap.get(workingStepParam.getWorkingStepId());
                                    BeanUtil.copyProperties(workingStepParam, workingStep);
                                    workingStepMapper.updateByPrimaryKeySelective(workingStep);
                                    workingStepExistList.remove(workingStep);
                                } else {
                                    getNewWorkingStep(studentId, now, cardId, workingPosition, workingStepParam);
                                }
                            }
                        }
                    }
                }
            }
        }
        //删除不需要的工序 工位 工步
        if (CollectionUtils.isNotEmpty(processExistList)) {
            for (Process process : processExistList) {
                process.setIsDelete(Constants.Common.IS_YES);
                process.setUpdatetime(now);
                processMapper.updateByPrimaryKeySelective(process);
            }
        }
        if (CollectionUtils.isNotEmpty(workingPositionExistList)) {
            for (WorkingPosition workingPosition : workingPositionExistList) {
                workingPosition.setIsDelete(Constants.Common.IS_YES);
                workingPosition.setUpdatetime(now);
                workingPositionMapper.updateByPrimaryKeySelective(workingPosition);
            }
        }
        if (CollectionUtils.isNotEmpty(workingStepExistList)) {
            for (WorkingStep workingStep : workingStepExistList) {
                workingStep.setIsDelete(Constants.Common.IS_YES);
                workingStep.setUpdatetime(now);
                workingStepMapper.updateByPrimaryKeySelective(workingStep);
            }
        }

        return Result.success();
    }

    private WorkingStep getNewWorkingStep(Integer studentId, Date now, Integer cardId, WorkingPosition workingPosition, WorkingStepParam workingStepParam) {
        WorkingStep workingStep = new WorkingStep();
        workingStep.setCardId(cardId);
        workingStep.setPositionId(workingPosition.getId());
        BeanUtil.copyProperties(workingStepParam, workingStep);
        workingStep.setIsDelete(Constants.Common.IS_NOT);
        workingStep.setCreatetime(now);
        workingStep.setCreatorId(studentId);
        workingStep.setUpdatetime(now);
        workingStep.setUpdaterId(studentId);
        workingStepMapper.insertSelective(workingStep);
        return workingStep;
    }

    private WorkingPosition getNewWorkingPosition(Integer studentId, Date now, Integer cardId, Process process, WorkingPositionParam workingPositionParam) {
        WorkingPosition workingPosition = new WorkingPosition();
        workingPosition.setCardId(cardId);
        workingPosition.setProcessId(process.getId());
        workingPosition.setSort(workingPositionParam.getSort());
        workingPosition.setIsDelete(Constants.Common.IS_NOT);
        workingPosition.setCreatetime(now);
        workingPosition.setCreatorId(studentId);
        workingPosition.setUpdatetime(now);
        workingPosition.setUpdaterId(studentId);
        workingPositionMapper.insertSelective(workingPosition);
        return workingPosition;
    }

    private Process getNewProcess(Integer studentId, Date now, Integer cardId, ProcessParam processParam) {
        Process process = new Process();
        process.setCardId(cardId);
        BeanUtil.copyProperties(processParam, process);
        process.setIsDelete(Constants.Common.IS_NOT);
        process.setCreatetime(now);
        process.setCreatorId(studentId);
        process.setUpdatetime(now);
        process.setUpdaterId(studentId);
        processMapper.insertSelective(process);
        return process;
    }

    private Card getNewCard(AddCardParam param, Integer workId, Integer studentId, Date now) {
        Card card;
        card = new Card();
        card.setWorkId(workId);
        BeanUtil.copyProperties(param, card);
        card.setCreatetime(now);
        card.setCreatorId(studentId);
        card.setUpdatetime(now);
        card.setUpdaterId(studentId);
        card.setIsDelete(Constants.Common.IS_NOT);
        cardMapper.insertSelective(card);
        return card;
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
        workMapper.updateByPrimaryKeySelective(work);
        return Result.success();
    }


    /**
     * 教师获取作业详情
     *
     * @param param
     * @return
     */
    public Result getTeacherWorkInfoById(WorkBaseParam param) {
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

        //2020-02-23区分资料和参考资料
        //List<FileListDTO> fileListDTOList = fileMapper.getFileListDTOByWorkProjectId(workProjectInfoDTO.getId());
        //workProjectInfoDTO.setFilelist(fileListDTOList);
        //获取资料文件
        List<FileListDTO> fileListDTOList = fileMapper.getFileListDTOByWorkProjectIdAndType(workProjectInfoDTO.getId(), Constants.File.FileTypes.INFORMATION.getStatus());
        workProjectInfoDTO.setFilelist(fileListDTOList);
        //获取参考方案文件
        List<FileListDTO> referenceSolutionListDTOList = fileMapper.getFileListDTOByWorkProjectIdAndType(workProjectInfoDTO.getId(), Constants.File.FileTypes.REFERENCE_SOLUTION.getStatus());
        workProjectInfoDTO.setReferenceSolutionList(referenceSolutionListDTOList);

        workInfoDTO.setTeaching(workTeachingDTO);

        workInfoDTO.setWorkProjectInfoDTO(workProjectInfoDTO);

     /*   //2020-02-22
        //查找工艺卡片
        CardDTO cardDTO = cardMapper.findByWorkId(workInfoDTO.getWorkId());
        //查找工序
        List<ProcessDTO> processDTOList = processMapper.findByCardId(cardDTO.getId());
        //查找工位
        for (int i = 0; i <processDTOList.size() ; i++) {
            List<WoekingPositionDTO> workingPositionDTOList = workingPositionMapper.findByProcessId(processDTOList.get(i).getId());
            //查找工步
            for (int j = 0; j < workingPositionDTOList.size() ; j++) {
                List<WorkingStepDTO> workingStepDTOList = workingStepMapper.findByWorkingPositionId(workingPositionDTOList.get(j).getId());
                //工位中放入工步
                workingPositionDTOList.get(j).setWorkingStepDTOList(workingStepDTOList);
            }
            //工序中放入工位
            processDTOList.get(i).setWoekingPositionDTOList(workingPositionDTOList);
        }
        //卡片中放工序
        cardDTO.setProcessDTOList(processDTOList);

        //作业中放入卡片
        workInfoDTO.setCardDTO(cardDTO);*/

        //2020-02-22屏蔽掉之前的工艺卡片
        //List<CraftCardInfoDTO> craftCardInfoDTOList = craftCardMapper.getCraftCardInfoDTOListByWorkId(work.getId());
        //workInfoDTO.setCraftCardInfoDTOList(craftCardInfoDTOList);
        StudentDTO student = studentManager.getStudentById(work.getStudentId());
        workInfoDTO.setStudentName(student.getName());

        //2020-01-06增加作业文件
        List<WorkFileDTO> workFileDTOList = workFileMapper.getByWorkId(workInfoDTO.getWorkId());
        workInfoDTO.setWorkFileDTOList(workFileDTOList);

        workMessageMapper.readMessage(param.getLoginTeacherId(), work.getId(), Constants.WorkMessage.RECEIVER_TYPE_TEACHER);

        return Result.success(workInfoDTO);
    }


    /**
     * 学生获取作业详情
     *
     * @param param
     * @return
     */
    public Result getStudentWorkInfoById(WorkBaseParam param) {
        WorkInfoForStudentDTO workInfoDTO = new WorkInfoForStudentDTO();

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
        WorkProjectInfoForStudentDTO workProjectInfoForStudentDTO = new WorkProjectInfoForStudentDTO();
        BeanUtil.copyProperties(workProjectInfoDTO, workProjectInfoForStudentDTO);

        //2020-02-23区分资料和参考资料
        //List<FileListDTO> fileListDTOList = fileMapper.getFileListDTOByWorkProjectId(workProjectInfoDTO.getId());
        //workProjectInfoDTO.setFilelist(fileListDTOList);
        //获取资料文件
        List<FileListDTO> fileListDTOList = fileMapper.getFileListDTOByWorkProjectIdAndType(workProjectInfoDTO.getId(), Constants.File.FileTypes.INFORMATION.getStatus());
        workProjectInfoForStudentDTO.setFilelist(fileListDTOList);

        workInfoDTO.setTeaching(workTeachingDTO);

        workInfoDTO.setWorkProjectInfoDTO(workProjectInfoForStudentDTO);

 /*       //2020-02-22
        //查找工艺卡片
        CardDTO cardDTO = cardMapper.findByWorkId(workInfoDTO.getWorkId());
        //查找工序
        List<ProcessDTO> processDTOList = processMapper.findByCardId(cardDTO.getId());
        //查找工位
        for (int i = 0; i <processDTOList.size() ; i++) {
            List<WoekingPositionDTO> workingPositionDTOList = workingPositionMapper.findByProcessId(processDTOList.get(i).getId());
            //查找工步
            for (int j = 0; j < workingPositionDTOList.size() ; j++) {
                List<WorkingStepDTO> workingStepDTOList = workingStepMapper.findByWorkingPositionId(workingPositionDTOList.get(j).getId());
                //工位中放入工步
                workingPositionDTOList.get(j).setWorkingStepDTOList(workingStepDTOList);
            }
            //工序中放入工位
            processDTOList.get(i).setWoekingPositionDTOList(workingPositionDTOList);
        }
        //卡片中放工序
        cardDTO.setProcessDTOList(processDTOList);

        //作业中放入卡片
        workInfoDTO.setCardDTO(cardDTO);*/

        //2020-02-22屏蔽掉之前的工艺卡片
        //List<CraftCardInfoDTO> craftCardInfoDTOList = craftCardMapper.getCraftCardInfoDTOListByWorkId(work.getId());
        //workInfoDTO.setCraftCardInfoDTOList(craftCardInfoDTOList);
        TeacherDTO teacher = teacherManager.getTeacherById(workTeachingDTO.getTeacherId());
        StudentDTO student = studentManager.getStudentById(work.getStudentId());
        workInfoDTO.setStudentName(student.getName());

        //2020-01-06增加作业文件
        List<WorkFileDTO> workFileDTOList = workFileMapper.getByWorkId(workInfoDTO.getWorkId());
        workInfoDTO.setWorkFileDTOList(workFileDTOList);

        workMessageMapper.readMessage(param.getLoginStudentId(), work.getId(), Constants.WorkMessage.RECEIVER_TYPE_STUDENT);

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
