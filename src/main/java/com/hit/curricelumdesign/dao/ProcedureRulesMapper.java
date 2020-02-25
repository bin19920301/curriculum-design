package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.dto.procedurerules.ProcedureRulesDTO;
import com.hit.curricelumdesign.context.entity.ProcedureRules;
import com.hit.curricelumdesign.context.param.procedurerules.UpdateProcedureRulesParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProcedureRulesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProcedureRules record);

    int insertSelective(ProcedureRules record);

    ProcedureRules selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProcedureRules record);

    int updateByPrimaryKey(ProcedureRules record);

    List<ProcedureRulesDTO> findByProjectId(Integer workProjectId);

}