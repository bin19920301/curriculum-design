package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.entity.CraftCardToWork;

public interface CraftCardToWorkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CraftCardToWork record);

    int insertSelective(CraftCardToWork record);

    CraftCardToWork selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CraftCardToWork record);

    int updateByPrimaryKey(CraftCardToWork record);
}