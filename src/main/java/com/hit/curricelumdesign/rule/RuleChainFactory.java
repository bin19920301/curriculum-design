package com.hit.curricelumdesign.rule;

import java.util.ArrayList;
import java.util.List;

public class RuleChainFactory {
    RuleFactory methodRuleFactory;
    RuleFactory orderRuleFactory;

    public RuleChainFactory(RuleFactory methodRuleFactory, RuleFactory orderRuleFactory) {
        this.methodRuleFactory = methodRuleFactory;
        this.orderRuleFactory = orderRuleFactory;
    }

    RuleChain createRuleChain(List<RuleBO> ruleBOList) {
        RuleChain ruleChain = new RuleChain();
        List<Rule> ruleList = new ArrayList<>();
        for (RuleBO ruleBO : ruleBOList) {
            Integer type = ruleBO.getType();
            //规则类型;1加工优先级2加工方法
            if (type == 1) {
                List<Rule> orderRuleList = orderRuleFactory.resolve(ruleBO.getRuleString());
                ruleList.addAll(orderRuleList);
            } else if (type == 2) {
                List<Rule> methodRuleList = methodRuleFactory.resolve(ruleBO.getRuleString());
                ruleList.addAll(methodRuleList);
            }
        }
        ruleChain.setChain(ruleList);
        return ruleChain;
    }
}
