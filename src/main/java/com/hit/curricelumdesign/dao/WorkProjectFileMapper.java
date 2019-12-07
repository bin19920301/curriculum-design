package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.entity.WorkProjectFile;

public interface WorkProjectFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WorkProjectFile record);

    int insertSelective(WorkProjectFile record);

    WorkProjectFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkProjectFile record);

    int updateByPrimaryKey(WorkProjectFile record);
}