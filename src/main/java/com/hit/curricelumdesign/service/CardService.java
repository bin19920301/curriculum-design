package com.hit.curricelumdesign.service;

import com.hit.curricelumdesign.context.bo.rule.FinishedMethodBO;
import com.hit.curricelumdesign.context.bo.rule.RuleBO;
import com.hit.curricelumdesign.context.bo.rule.SurfaceBO;
import com.hit.curricelumdesign.context.bo.rule.WorkCardBO;
import com.hit.curricelumdesign.context.dto.card.CardDTO;
import com.hit.curricelumdesign.context.dto.errormsg.ErrorMsgDTO;
import com.hit.curricelumdesign.context.dto.procedurerules.ProcedureRulesDTO;
import com.hit.curricelumdesign.context.dto.process.ProcessDTO;
import com.hit.curricelumdesign.context.dto.workingkstep.WorkingStepDTO;
import com.hit.curricelumdesign.context.dto.workingposition.WorkingPositionDTO;
import com.hit.curricelumdesign.context.entity.Work;
import com.hit.curricelumdesign.context.enums.ToolEnums;
import com.hit.curricelumdesign.context.param.card.CardBaseParam;
import com.hit.curricelumdesign.dao.*;
import com.hit.curricelumdesign.manager.card.CardManager;
import com.hit.curricelumdesign.manager.work.WorkManager;
import com.hit.curricelumdesign.rule.RuleChain;
import com.hit.curricelumdesign.rule.RuleChainFactory;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class CardService {

    @Autowired
    private CardMapper cardMapper;

    @Autowired
    private ProcessMapper processMapper;

    @Autowired
    private WorkingPositionMapper workingPositionMapper;

    @Autowired
    private WorkingStepMapper workingStepMapper;

    @Autowired
    private CardManager cardManager;

    @Autowired
    private RuleChainFactory ruleChainFactory;

    @Autowired
    private ProcedureRulesMapper procedureRulesMapper;

    @Autowired
    private WorkManager workManager;

    public CardDTO getTeacherCardDTOByWorkId(CardBaseParam param) {
        Work work = workManager.getWorkerById(param.getId());
        //2020-02-22
        //查找工艺卡片
        CardDTO cardDTO = cardMapper.findByWorkId(param.getId());
        List<Integer> errorRuleIdSet = new ArrayList<>();
        //2020-02-27 增加非空判断
        if (null == cardDTO) {
            return null;
        }
        //CardDTO cardDTO = cardManager.findByWorkId(param.getId());
        //查找工序
        List<ProcessDTO> processDTOList = processMapper.findByCardId(cardDTO.getCardId());
        //查找工位
        if (CollectionUtils.isNotEmpty(processDTOList)) {
            for (int i = 0; i < processDTOList.size(); i++) {
                List<WorkingPositionDTO> workingPositionDTOList = workingPositionMapper.findByProcessId(processDTOList.get(i).getProcessId());
                //查找工步
                if (CollectionUtils.isNotEmpty(workingPositionDTOList)) {
                    for (int j = 0; j < workingPositionDTOList.size(); j++) {
                        List<WorkingStepDTO> workingStepDTOList = workingStepMapper.findByWorkingPositionId(workingPositionDTOList.get(j).getWorkingPositionId());
                        if (CollectionUtils.isNotEmpty(workingStepDTOList)) {
                            //工位中放入工步
                            workingPositionDTOList.get(j).setWorkingStepList(workingStepDTOList);
                        }
                    }
                    //工序中放入工位
                    processDTOList.get(i).setWorkingPositionList(workingPositionDTOList);
                }
            }
            //卡片中放工序
            cardDTO.setProcessList(processDTOList);
        }

        List<ProcedureRulesDTO> rulesDTOList = procedureRulesMapper.findByProjectId(work.getWorkProjectId());
        List<RuleBO> ruleBOList = new ArrayList<>();
        for (ProcedureRulesDTO dto : rulesDTOList) {
            RuleBO bo = new RuleBO();
            bo.setRuleId(dto.getId());
            bo.setType(dto.getRulesType());
            bo.setRuleString(dto.getRulesDetails());
            ruleBOList.add(bo);
        }

        ArrayList<SurfaceBO> surfaceList = new ArrayList<>();
        ArrayList<FinishedMethodBO> finishedMethodBOList = new ArrayList<>();
        Collections.sort(processDTOList);
        for (ProcessDTO processDTO : processDTOList) {
            if (!Objects.isNull(processDTO.getSurfaceId())) {
                SurfaceBO surfaceBO = new SurfaceBO(processDTO.getProcessId(), processDTO.getSurfaceId());
                surfaceList.add(surfaceBO);
                for (WorkingPositionDTO workingPositionDTO : processDTO.getWorkingPositionList()) {
                    for (WorkingStepDTO workingStepDTO : workingPositionDTO.getWorkingStepList()) {
                        if (!Objects.isNull(workingStepDTO.getTool())) {
                            //2020-03-14组装加工方法规则 加工表面id从工序中获取,加工方法从公布中获取
                            FinishedMethodBO finishedMethodBO = new FinishedMethodBO(processDTO.getProcessId(),
                                    workingPositionDTO.getWorkingPositionId(),
                                    workingStepDTO.getWorkingStepId(),
                                    processDTO.getSurfaceId(),
                                    ToolEnums.getTypeByCode(workingStepDTO.getTool()));
                            //填入list中
                            finishedMethodBOList.add(finishedMethodBO);
                        }
                    }
                }
            }
        }
        WorkCardBO workCardBO = new WorkCardBO(surfaceList, finishedMethodBOList);
        RuleChain ruleChain = ruleChainFactory.createRuleChain(ruleBOList);
        ruleChain.check(workCardBO);
        for (SurfaceBO surfaceBO : surfaceList) {
            Collection<ErrorMsgDTO> errorMsgDTOS = surfaceBO.getErrorMsg().values();
            if (CollectionUtils.isNotEmpty(errorMsgDTOS)) {
                errorRuleIdSet.addAll(surfaceBO.getErrorMsg().keySet());
                for (ProcessDTO processDTO : processDTOList) {
                    if (surfaceBO.getProcessId().equals(processDTO.getProcessId())) {
                        List<ErrorMsgDTO> errorMsgDTOList = new ArrayList<>();
                        for (ErrorMsgDTO errorMsgDTO : errorMsgDTOS) {
                            errorMsgDTOList.add(errorMsgDTO);
                        }
                        processDTO.setErrorMsg(errorMsgDTOList);
                    }
                }
            }
        }
        for (FinishedMethodBO finishedMethodBO : finishedMethodBOList) {
            Collection<ErrorMsgDTO> errorMsgDTOS = finishedMethodBO.getErrorMsg().values();
            if (CollectionUtils.isNotEmpty(errorMsgDTOS)) {
                errorRuleIdSet.addAll(finishedMethodBO.getErrorMsg().keySet());
                for (ProcessDTO processDTO : processDTOList) {
                    if (processDTO.getProcessId().equals(finishedMethodBO.getProcessId())) {
                        for (WorkingPositionDTO workingPositionDTO : processDTO.getWorkingPositionList()) {
                            if (workingPositionDTO.getWorkingPositionId().equals(finishedMethodBO.getPositionId())) {
                                for (WorkingStepDTO workingStepDTO : workingPositionDTO.getWorkingStepList()) {
                                    if (workingStepDTO.getWorkingStepId().equals(finishedMethodBO.getStepId())) {
                                        List<ErrorMsgDTO> errorMsgList = new ArrayList<>();
                                        for (ErrorMsgDTO errorMsgDTO : errorMsgDTOS) {
                                            errorMsgList.add(errorMsgDTO);
                                        }
                                        workingStepDTO.setErrorMsg(errorMsgList);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        cardDTO.setErrorNum(errorRuleIdSet.size());
        return cardDTO;
    }

    public CardDTO getStudentCardDTOByWorkId(CardBaseParam param) {
        //2020-02-22
        //查找工艺卡片
        CardDTO cardDTO = cardMapper.findByWorkId(param.getId());
        //2020-02-27 增加非空判断
        if (null == cardDTO) {
            return null;
        }
        // CardDTO cardDTO = cardManager.findByWorkId(param.getId());
        //查找工序
        List<ProcessDTO> processDTOList = processMapper.findByCardId(cardDTO.getCardId());
        //查找工位
        if (CollectionUtils.isNotEmpty(processDTOList)) {
            for (int i = 0; i < processDTOList.size(); i++) {
                List<WorkingPositionDTO> workingPositionDTOList = workingPositionMapper.findByProcessId(processDTOList.get(i).getProcessId());
                //查找工步
                if (CollectionUtils.isNotEmpty(workingPositionDTOList)) {
                    for (int j = 0; j < workingPositionDTOList.size(); j++) {
                        List<WorkingStepDTO> workingStepDTOList = workingStepMapper.findByWorkingPositionId(workingPositionDTOList.get(j).getWorkingPositionId());
                        if (CollectionUtils.isNotEmpty(workingStepDTOList)) {
                            //工位中放入工步
                            workingPositionDTOList.get(j).setWorkingStepList(workingStepDTOList);
                        }
                    }
                    //工序中放入工位
                    processDTOList.get(i).setWorkingPositionList(workingPositionDTOList);
                }
            }
            //卡片中放工序
            cardDTO.setProcessList(processDTOList);
        }
        return cardDTO;
    }
}