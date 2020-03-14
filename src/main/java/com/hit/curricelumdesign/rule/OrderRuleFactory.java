package com.hit.curricelumdesign.rule;

import org.springframework.stereotype.Component;

import java.util.List;

@Component("OrderRuleFactory")
public class OrderRuleFactory implements RuleFactory {
    @Override
    public List<Rule> resolve(String ruleString) {
        return null;
    }
}
