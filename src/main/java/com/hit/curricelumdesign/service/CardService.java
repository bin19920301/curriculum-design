package com.hit.curricelumdesign.service;

import com.hit.curricelumdesign.context.bo.rule.FinishedMethodBO;
import com.hit.curricelumdesign.context.bo.rule.RuleBO;
import com.hit.curricelumdesign.context.bo.rule.SurfaceBO;
import com.hit.curricelumdesign.context.bo.rule.WorkCardBO;
import com.hit.curricelumdesign.context.dto.card.CardDTO;
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
import com.hit.curricelumdesign.rule.Rule;
import com.hit.curricelumdesign.rule.RuleChainFactory;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        for (ProcessDTO processDTO : processDTOList) {
            if (!Objects.isNull(processDTO.getSurfaceId())) {
                SurfaceBO surfaceBO = new SurfaceBO(processDTO.getProcessId(), processDTO.getSurfaceId());
                surfaceList.add(surfaceBO);
                for (WorkingPositionDTO workingPositionDTO : processDTO.getWorkingPositionList()) {
                    for (WorkingStepDTO workingStepDTO : workingPositionDTO.getWorkingStepList()) {
                        if (!Objects.isNull(workingStepDTO.getTool())) {
                            //2020-03-14组装加工方法规则 加工表面id从工序中获取,加工方法从公布中获取
                            FinishedMethodBO finishedMethodBO = new FinishedMethodBO(processDTO.getSurfaceId(), ToolEnums.intToChar(workingStepDTO.getTool()).toString());
                            //填入list中
                            finishedMethodBOList.add(finishedMethodBO);
                        }
                    }
                }
            }
        }
        WorkCardBO workCardBO = new WorkCardBO(surfaceList, finishedMethodBOList);

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
