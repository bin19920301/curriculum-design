package com.hit.curricelumdesign.rule;

import com.hit.curricelumdesign.utils.StringUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("OrderRuleFactory")
public class OrderRuleFactory implements RuleFactory {
    @Override
    public List<Rule> resolve(String ruleString) {
        List<Rule> ruleList = new ArrayList<>();

        Rule rule = new OrderRule();
        if (StringUtil.isNotBlank(ruleString)) {

        }
        return ruleList;
    }
}
