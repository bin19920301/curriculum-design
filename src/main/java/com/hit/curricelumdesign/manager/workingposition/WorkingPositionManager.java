package com.hit.curricelumdesign.manager.workingposition;

import com.hit.curricelumdesign.dao.WorkingPositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkingPositionManager {

    @Autowired
    private WorkingPositionMapper workingPositionMapper;

    public int deteleByCardId(Integer cardId){
        return workingPositionMapper.deleteByCardId(cardId);
    }

}
