package com.hit.curricelumdesign.rule;

import java.util.List;

public interface RuleFactory {
    List<Rule> resolve(String ruleString);
}
