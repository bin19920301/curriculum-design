package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.entity.TeachingMessage;

public interface TeachingMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TeachingMessage record);

    int insertSelective(TeachingMessage record);

    TeachingMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TeachingMessage record);

    int updateByPrimaryKey(TeachingMessage record);
}