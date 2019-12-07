package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.entity.WorkProject;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WorkProject record);

    int insertSelective(WorkProject record);

    WorkProject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkProject record);

    int updateByPrimaryKey(WorkProject record);
}