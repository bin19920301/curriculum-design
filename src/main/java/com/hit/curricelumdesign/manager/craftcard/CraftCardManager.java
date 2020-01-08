package com.hit.curricelumdesign.manager.craftcard;

import com.hit.curricelumdesign.context.entity.CraftCard;
import com.hit.curricelumdesign.dao.CraftCardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xbr
 * @Date 2019-12-22
 * @ClassName CraftCardManager
 * @Description
 */
@Component
public class CraftCardManager {

    @Autowired
    private CraftCardMapper craftCardMapper;

    @Transactional
    public Long insertCraftCardList(List<CraftCard> craftCardList) {
        for (CraftCard craftCard : craftCardList) {
            craftCardMapper.insert(craftCard);
        }
        return Integer.valueOf(craftCardList.size()).longValue();
    }

    @Transactional
    public Long updateCraftCardList(List<CraftCard> craftCardList) {
        for (CraftCard craftCard : craftCardList) {
            craftCardMapper.updateByPrimaryKey(craftCard);
        }
        return Integer.valueOf(craftCardList.size()).longValue();
    }

}
