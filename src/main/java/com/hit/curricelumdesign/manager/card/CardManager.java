package com.hit.curricelumdesign.manager.card;

import com.hit.curricelumdesign.context.dto.card.CardDTO;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.dao.CardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CardManager {

    @Autowired
    private CardMapper cardMapper;

    public CardDTO findByWorkId(Integer workId){
        CardDTO cardDTO = cardMapper.findByWorkId(workId);
        if (null == cardDTO){
            throw new BaseException(Error.CARD_IS_NOT_EXIST);
        }
        return cardDTO;
    }

    }
