package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.entity.WorkProject;

public interface WorkProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WorkProject record);

    int insertSelective(WorkProject record);

    WorkProject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkProject record);

    int updateByPrimaryKey(WorkProject record);
}