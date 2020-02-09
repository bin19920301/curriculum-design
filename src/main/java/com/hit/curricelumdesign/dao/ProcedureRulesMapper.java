package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.entity.ProcedureRules;

public interface ProcedureRulesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProcedureRules record);

    int insertSelective(ProcedureRules record);

    ProcedureRules selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProcedureRules record);

    int updateByPrimaryKey(ProcedureRules record);
}