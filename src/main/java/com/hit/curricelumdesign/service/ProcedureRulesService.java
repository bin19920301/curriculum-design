package com.hit.curricelumdesign.service;

import com.github.pagehelper.PageHelper;
import com.hit.curricelumdesign.context.dto.finishedsurface.FinishedSurfaceDTO;
import com.hit.curricelumdesign.context.dto.procedurerules.ProcedureRulesDTO;
import com.hit.curricelumdesign.context.entity.FinishedSurface;
import com.hit.curricelumdesign.context.entity.ProcedureRules;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.context.param.procedurerules.AddProcedureRulesParam;
import com.hit.curricelumdesign.context.param.procedurerules.DeleteProcedureRulesParam;
import com.hit.curricelumdesign.context.param.procedurerules.ListProcedureRulesByProjectIdParam;
import com.hit.curricelumdesign.context.param.procedurerules.UpdateProcedureRulesParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.FinishedSurfaceMapper;
import com.hit.curricelumdesign.dao.ProcedureRulesMapper;
import com.hit.curricelumdesign.manager.finishedsurface.FinishedSurfaceManager;
import com.hit.curricelumdesign.utils.BeanUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProcedureRulesService {

    @Autowired
    private ProcedureRulesMapper procedureRulesMapper;

    @Autowired
    private FinishedSurfaceMapper finishedSurfaceMapper;

    public Result addProcessRules(AddProcedureRulesParam param) {
        List<Integer> surfaceIdList = new ArrayList<>();
        if (1 == param.getRulesType()) {
            surfaceIdList = getOrderSurfaceIdList(param.getRulesDetails());

        } else if (2 == param.getRulesType()) {
            surfaceIdList = getMethodSurfaceIdList(param.getRulesDetails());
        }
        verifySurface(param.getWorkProjectId(), surfaceIdList);

        ProcedureRules procedureRules = new ProcedureRules();
        BeanUtil.copyProperties(param, procedureRules);
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

    /**
     * 获取加工方式表面id列表
     *
     * @param rulesDetails
     * @return
     */
    private List<Integer> getMethodSurfaceIdList(String rulesDetails) {
        List<Integer> surfaceIdList = new ArrayList<>();
        String[] split = rulesDetails.split(";");
        for (String ruleString : split) {
            String[] ruleSplit = ruleString.split("-");
            surfaceIdList.add(Integer.parseInt(ruleSplit[0]));
        }
        return surfaceIdList;
    }

    /**
     * 获取排序表面id列表
     *
     * @param rulesDetails
     * @return
     */
    private List<Integer> getOrderSurfaceIdList(String rulesDetails) {
        List<Integer> surfaceIdList = new ArrayList<>();
        String[] split = rulesDetails.split(",");
        for (String s : split) {
            surfaceIdList.add(Integer.parseInt(s));
        }
        return surfaceIdList;
    }

    public Result updateProcessRules(UpdateProcedureRulesParam param) {
        List<Integer> surfaceIdList = new ArrayList<>();
        if (1 == param.getRulesType()) {
            surfaceIdList = getOrderSurfaceIdList(param.getRulesDetails());

        } else if (2 == param.getRulesType()) {
            surfaceIdList = getMethodSurfaceIdList(param.getRulesDetails());
        }
        verifySurface(param.getWorkProjectId(), surfaceIdList);

        ProcedureRules procedureRules = new ProcedureRules();
        BeanUtil.copyProperties(param, procedureRules);
        // 设置属性
        procedureRules.setUpdatetime(new Date());
        procedureRules.setUpdaterId(param.getLoginTeacherId());
        // 更新属性
        procedureRulesMapper.updateByPrimaryKeySelective(procedureRules);
        return Result.success();
    }

    public Result deleteProcessRules(DeleteProcedureRulesParam param) {
        ProcedureRules procedureRules = procedureRulesMapper.selectByPrimaryKey(param.getId());
        // 设置属性
        procedureRules.setIsDelete(true);
        procedureRules.setUpdatetime(new Date());
        procedureRules.setUpdaterId(param.getLoginTeacherId());
        // 保存属性
        procedureRulesMapper.updateByPrimaryKeySelective(procedureRules);
        return Result.success();
    }

    public Result listProcessResults(ListProcedureRulesByProjectIdParam param) {
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        List<ProcedureRulesDTO> procedureRules = procedureRulesMapper.findByProjectId(param.getProjectId());
        return Result.success(procedureRules);
    }

    private void verifySurface(Integer workProjectId, List<Integer> surfaceIdList) {

        List<FinishedSurfaceDTO> finishedSurfaceDTOS = finishedSurfaceMapper.selectByWorkProjectId(workProjectId);
        if (CollectionUtils.isNotEmpty(finishedSurfaceDTOS)) {
            List<Integer> existSurfaceIdList = finishedSurfaceDTOS.stream().map(FinishedSurfaceDTO::getSurfaceId).collect(Collectors.toList());
            for (Integer surfaceId : surfaceIdList) {
                if (!existSurfaceIdList.contains(surfaceId)) {
                    throw new BaseException(Error.RULE_CONTAINS_NON_EXISTENT_SURFACE_ERROR);
                }
            }
        }
    }
}
