package com.hit.curricelumdesign.manager.process;

import com.hit.curricelumdesign.dao.ProcessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessManager {
    @Autowired
    private ProcessMapper processMapper;

    public int deleteByCardId(Integer cardId){
        return processMapper.deleteByCardId(cardId);
    }
}
