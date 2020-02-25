package com.hit.curricelumdesign.service;

import com.github.pagehelper.PageHelper;
import com.hit.curricelumdesign.context.dto.procedurerules.ProcedureRulesDTO;
import com.hit.curricelumdesign.context.entity.ProcedureRules;
import com.hit.curricelumdesign.context.param.procedurerules.AddProcedureRulesParam;
import com.hit.curricelumdesign.context.param.procedurerules.DeleteProcedureRulesParam;
import com.hit.curricelumdesign.context.param.procedurerules.ListProcedureRulesByProjectIdParam;
import com.hit.curricelumdesign.context.param.procedurerules.UpdateProcedureRulesParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.ProcedureRulesMapper;
import com.hit.curricelumdesign.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ProcedureRulesService {

    @Autowired
    private ProcedureRulesMapper procedureRulesMapper;

    public Result addProcessRules(AddProcedureRulesParam param){
        ProcedureRules procedureRules = new ProcedureRules();
        BeanUtil.copyProperties(param,procedureRules);
        //设置属性
        procedureRules.setCreatetime(new Date());
        procedureRules.setCreatorId(param.getLoginTeacherId());
        procedureRules.setIsDelete(false);
        procedureRules.setUpdatetime(new Date());
        procedureRules.setUpdaterId(param.getLoginTeacherId());
        //保存属性
        procedureRulesMapper.insert(procedureRules);
        return Result.success();
    }

    public Result updateProcessRules(UpdateProcedureRulesParam param){
        ProcedureRules procedureRules = new ProcedureRules();
        BeanUtil.copyProperties(param,procedureRules);
        // 设置属性
        procedureRules.setUpdatetime(new Date());
        procedureRules.setUpdaterId(param.getLoginTeacherId());
        // 更新属性
        procedureRulesMapper.updateByPrimaryKeySelective(procedureRules);
        return Result.success();
    }

    public Result deleteProcessRules(DeleteProcedureRulesParam param){
        ProcedureRules procedureRules = procedureRulesMapper.selectByPrimaryKey(param.getId());
        // 设置属性
        procedureRules.setIsDelete(true);
        procedureRules.setUpdatetime(new Date());
        procedureRules.setUpdaterId(param.getLoginTeacherId());
        // 保存属性
        procedureRulesMapper.updateByPrimaryKeySelective(procedureRules);
        return Result.success();
    }

    public Result listProcessResults(ListProcedureRulesByProjectIdParam param){
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        List<ProcedureRulesDTO> procedureRules = procedureRulesMapper.findByProjectId(param.getProjectId());
        return  Result.success(procedureRules);
    }
}
