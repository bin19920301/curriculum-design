package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.entity.WorkingStep;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WorkingStepMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WorkingStep record);

    int insertSelective(WorkingStep record);

    WorkingStep selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkingStep record);

    int updateByPrimaryKey(WorkingStep record);

    int deleteByCardId(Integer cardId);

    List<WorkingStep> selectByCardId(@Param("cardId") Integer cardId);

    void deleteWorkingStepByCardId(@Param("cardId") Integer cardId);
}
