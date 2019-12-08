package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.entity.ProcessingMethod;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProcessingMethodMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProcessingMethod record);

    int insertSelective(ProcessingMethod record);

    ProcessingMethod selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProcessingMethod record);

    int updateByPrimaryKey(ProcessingMethod record);
}