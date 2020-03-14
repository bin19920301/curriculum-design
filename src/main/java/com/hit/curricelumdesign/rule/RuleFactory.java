package com.hit.curricelumdesign.rule;

import com.hit.curricelumdesign.context.bo.rule.RuleBO;

import java.util.List;

public interface RuleFactory {
    List<Rule> resolve(RuleBO ruleBO);
}
