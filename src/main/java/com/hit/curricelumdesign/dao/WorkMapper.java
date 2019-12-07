package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.entity.Work;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Work record);

    int insertSelective(Work record);

    Work selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);
}