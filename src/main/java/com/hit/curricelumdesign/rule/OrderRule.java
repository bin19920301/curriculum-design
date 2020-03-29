package com.hit.curricelumdesign.rule;

import com.hit.curricelumdesign.context.bo.rule.RuleBO;
import com.hit.curricelumdesign.context.bo.rule.SurfaceBO;
import com.hit.curricelumdesign.context.bo.rule.WorkCardBO;
import com.hit.curricelumdesign.context.dto.errormsg.ErrorMsgDTO;

import java.util.*;

/**
 * @author xbr
 * @Date 2020-03-14
 * @ClassName OrderRule
 * @Description
 */
public class OrderRule implements Rule {

    private Set<Integer> preSurfaceIdSet;
    private Integer currentSurface;
    private RuleBO ruleBO;

    public OrderRule(Set<Integer> preSurfaceIdSet, Integer currentSurface, RuleBO ruleBO) {
        this.preSurfaceIdSet = preSurfaceIdSet;
        this.currentSurface = currentSurface;
        this.ruleBO = ruleBO;
    }

    @Override
    public void check(WorkCardBO workCardBO) {
        ArrayList<SurfaceBO> surfaceList = workCardBO.getSurfaceList();
        for (int i = 0; i < surfaceList.size(); i++) {
            SurfaceBO currentBO = surfaceList.get(i);
            if (currentSurface.equals(currentBO.getSurfaceId())) {
                for (int j = i + 1; j < surfaceList.size(); j++) {
                    SurfaceBO targetBO = surfaceList.get(j);
                    if (preSurfaceIdSet.contains(targetBO.getSurfaceId())) {
                        ErrorMsgDTO errorMsgDTO = new ErrorMsgDTO();
                        errorMsgDTO.setSurfaceId(currentBO.getSurfaceId());
                        errorMsgDTO.setRulesType(ruleBO.getType());
                        errorMsgDTO.setRuleDesc(ruleBO.getRuleString());
                        targetBO.addErrorMsg(ruleBO.getRuleId(), errorMsgDTO);
                    }
                }
            }
        }
    }
}
