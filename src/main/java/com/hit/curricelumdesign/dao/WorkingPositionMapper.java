package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.entity.WorkingPosition;

public interface WorkingPositionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WorkingPosition record);

    int insertSelective(WorkingPosition record);

    WorkingPosition selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkingPosition record);

    int updateByPrimaryKey(WorkingPosition record);
}