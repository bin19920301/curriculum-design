package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.entity.WorkingStep;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface WorkingStepMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WorkingStep record);

    int insertSelective(WorkingStep record);

    WorkingStep selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkingStep record);

    int updateByPrimaryKey(WorkingStep record);
}