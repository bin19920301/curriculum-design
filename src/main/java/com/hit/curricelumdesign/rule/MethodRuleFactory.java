package com.hit.curricelumdesign.rule;

import com.hit.curricelumdesign.context.bo.rule.RuleBO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
    public List<Rule> resolve(RuleBO ruleBO) {
        String ruleString = ruleBO.getRuleString();
        List<Rule> ruleList = new ArrayList<>();

        Rule rule;
        if (!StringUtils.isBlank(ruleString)){
            //分解出每一组<表面id,加工方法>
            String[] ruleStringArray = ruleString.split(";");
            for (String  untreatedRuleString: ruleStringArray) {
                String[] ruleArray = untreatedRuleString.split(",");
                //组装成加工方法得规则
                MethodRule methodRule = new MethodRule(Integer.valueOf(ruleArray[0]), ruleArray[1], ruleBO);
                //组装规则list
                ruleList.add(methodRule);
            }
        }
        return ruleList;
    }

}
