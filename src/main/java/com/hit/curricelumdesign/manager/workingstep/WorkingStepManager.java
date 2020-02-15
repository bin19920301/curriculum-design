package com.hit.curricelumdesign.manager.workingstep;


import com.hit.curricelumdesign.dao.WorkingStepMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkingStepManager {

    @Autowired
    private WorkingStepMapper workingStepMapper;

    public int deleteByCardId(Integer cardId){
        return workingStepMapper.deleteByCardId(cardId);
    }
}
