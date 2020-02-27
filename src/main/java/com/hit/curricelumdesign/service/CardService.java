package com.hit.curricelumdesign.service;

import com.hit.curricelumdesign.context.dto.card.CardDTO;
import com.hit.curricelumdesign.context.dto.process.ProcessDTO;
import com.hit.curricelumdesign.context.dto.workingkstep.WorkingStepDTO;
import com.hit.curricelumdesign.context.dto.workingposition.WorkingPositionDTO;
import com.hit.curricelumdesign.context.param.card.CardBaseParam;
import com.hit.curricelumdesign.dao.CardMapper;
import com.hit.curricelumdesign.dao.ProcessMapper;
import com.hit.curricelumdesign.dao.WorkingPositionMapper;
import com.hit.curricelumdesign.dao.WorkingStepMapper;
import com.hit.curricelumdesign.manager.card.CardManager;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public CardDTO getTeacherCardDTOByWorkId(CardBaseParam param){
        //2020-02-22
        //查找工艺卡片
        CardDTO cardDTO = cardMapper.findByWorkId(param.getId());
        //2020-02-27 增加非空判断
        if (null == cardDTO){
            return null;
        }
        //CardDTO cardDTO = cardManager.findByWorkId(param.getId());
        //查找工序
        List<ProcessDTO> processDTOList = processMapper.findByCardId(cardDTO.getId());
        //查找工位
        if (CollectionUtils.isNotEmpty(processDTOList)){
            for (int i = 0; i <processDTOList.size() ; i++) {
                List<WorkingPositionDTO> workingPositionDTOList = workingPositionMapper.findByProcessId(processDTOList.get(i).getId());
                //查找工步
                if(CollectionUtils.isNotEmpty(workingPositionDTOList)){
                    for (int j = 0; j < workingPositionDTOList.size() ; j++) {
                        List<WorkingStepDTO> workingStepDTOList = workingStepMapper.findByWorkingPositionId(workingPositionDTOList.get(j).getId());
                       if(CollectionUtils.isNotEmpty(workingStepDTOList)){
                           //工位中放入工步
                           workingPositionDTOList.get(j).setWorkingStepDTOList(workingStepDTOList);
                       }
                    }
                    //工序中放入工位
                    processDTOList.get(i).setWorkingPositionDTOList(workingPositionDTOList);
                }
            }
            //卡片中放工序
            cardDTO.setProcessDTOList(processDTOList);
        }
        return  cardDTO;
    }

    public CardDTO getStudentCardDTOByWorkId(CardBaseParam param){
        //2020-02-22
        //查找工艺卡片
        CardDTO cardDTO = cardMapper.findByWorkId(param.getId());
        //2020-02-27 增加非空判断
        if (null == cardDTO){
            return null;
        }
        // CardDTO cardDTO = cardManager.findByWorkId(param.getId());
        //查找工序
        List<ProcessDTO> processDTOList = processMapper.findByCardId(cardDTO.getId());
        //查找工位
        if (CollectionUtils.isNotEmpty(processDTOList)){
            for (int i = 0; i <processDTOList.size() ; i++) {
                List<WorkingPositionDTO> workingPositionDTOList = workingPositionMapper.findByProcessId(processDTOList.get(i).getId());
                //查找工步
                if(CollectionUtils.isNotEmpty(workingPositionDTOList)){
                    for (int j = 0; j < workingPositionDTOList.size() ; j++) {
                        List<WorkingStepDTO> workingStepDTOList = workingStepMapper.findByWorkingPositionId(workingPositionDTOList.get(j).getId());
                        if(CollectionUtils.isNotEmpty(workingStepDTOList)){
                            //工位中放入工步
                            workingPositionDTOList.get(j).setWorkingStepDTOList(workingStepDTOList);
                        }
                    }
                    //工序中放入工位
                    processDTOList.get(i).setWorkingPositionDTOList(workingPositionDTOList);
                }
            }
            //卡片中放工序
            cardDTO.setProcessDTOList(processDTOList);
        }
        return  cardDTO;
    }
}
