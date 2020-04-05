package com.hit.curricelumdesign.rule;

import com.hit.curricelumdesign.context.bo.rule.RuleBO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class RuleChainFactory {

    @Resource(name = "MethodRuleFactory")
    RuleFactory methodRuleFactory;

    @Resource(name = "OrderRuleFactory")
    RuleFactory orderRuleFactory;

    public RuleChain createRuleChain(List<RuleBO> ruleBOList) {
        RuleChain ruleChain = new RuleChain();
        List<Rule> ruleList = new ArrayList<>();
        for (RuleBO ruleBO : ruleBOList) {
            Integer type = ruleBO.getType();
            //规则类型;1加工优先级2加工方法
            if (type == 1) {
                List<Rule> orderRuleList = orderRuleFactory.resolve(ruleBO);
                ruleList.addAll(orderRuleList);
            } else if (type == 2) {
                List<Rule> methodRuleList = methodRuleFactory.resolve(ruleBO);
                ruleList.addAll(methodRuleList);
            }
        }
        ruleChain.setChain(ruleList);
        return ruleChain;
    }
}