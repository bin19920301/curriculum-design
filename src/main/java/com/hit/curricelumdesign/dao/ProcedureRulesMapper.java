package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.entity.ProcedureRules;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProcedureRulesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProcedureRules record);

    int insertSelective(ProcedureRules record);

    ProcedureRules selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProcedureRules record);

    int updateByPrimaryKey(ProcedureRules record);

    int deleteByCardId(Integer cardId);
}