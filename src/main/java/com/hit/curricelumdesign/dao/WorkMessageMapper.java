package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.entity.WorkMessage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WorkMessage record);

    int insertSelective(WorkMessage record);

    WorkMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkMessage record);

    int updateByPrimaryKey(WorkMessage record);
}