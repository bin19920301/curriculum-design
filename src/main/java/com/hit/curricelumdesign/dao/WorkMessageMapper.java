package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.entity.WorkMessage;

public interface WorkMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WorkMessage record);

    int insertSelective(WorkMessage record);

    WorkMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkMessage record);

    int updateByPrimaryKey(WorkMessage record);
}