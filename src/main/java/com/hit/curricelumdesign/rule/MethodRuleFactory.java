package com.hit.curricelumdesign.rule;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xbr
 * @Date 2020-03-14
 * @ClassName MethodRuleFactory
 * @Description
 */
@Component("MethodRuleFactory")
public class MethodRuleFactory implements RuleFactory {
    @Override
    public List<Rule> resolve(String ruleString) {
        return null;
    }
}
