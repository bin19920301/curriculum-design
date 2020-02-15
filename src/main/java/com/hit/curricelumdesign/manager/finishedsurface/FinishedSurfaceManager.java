package com.hit.curricelumdesign.manager.finishedsurface;

import com.hit.curricelumdesign.dao.FinishedSurfaceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FinishedSurfaceManager {

    @Autowired
    private FinishedSurfaceMapper finishedSurfaceMapper;

    public int deleteByCardId(Integer cardId){
        return finishedSurfaceMapper.deleteByCardId(cardId);
    }
}
