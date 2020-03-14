package com.hit.curricelumdesign.rule;

import com.hit.curricelumdesign.utils.StringUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component("OrderRuleFactory")
public class OrderRuleFactory implements RuleFactory {
    @Override
    public List<Rule> resolve(String ruleString) {
        List<Rule> ruleList = new ArrayList<>();

        Rule rule;
        Set<Integer> preSurfaceIdSet;
        Integer currentSurface;
        if (StringUtil.isNotBlank(ruleString)) {
            String[] ruleStringArray = ruleString.split(",");
            for (int i = 1; (ruleStringArray.length > 1) && (i < ruleStringArray.length); i++) {
                int cur = Integer.parseInt(ruleStringArray[i]);
                currentSurface = cur;
                preSurfaceIdSet = new HashSet<>();
                for (int j = 0; j < i; j++) {
                    preSurfaceIdSet.add(Integer.parseInt(ruleStringArray[j]));
                }
                rule = new OrderRule(preSurfaceIdSet, currentSurface);
                ruleList.add(rule);
            }
        }
        return ruleList;
    }

}
