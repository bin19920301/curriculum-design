package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.dto.card.CardDTO;
import com.hit.curricelumdesign.context.entity.Card;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Card record);

    int insertSelective(Card record);

    Card selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Card record);

    int updateByPrimaryKey(Card record);

    CardDTO findByWorkId(Integer workId);
}