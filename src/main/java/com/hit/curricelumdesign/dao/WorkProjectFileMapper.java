package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.entity.WorkProjectFile;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkProjectFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WorkProjectFile record);

    int insertSelective(WorkProjectFile record);

    WorkProjectFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkProjectFile record);

    int updateByPrimaryKey(WorkProjectFile record);
}