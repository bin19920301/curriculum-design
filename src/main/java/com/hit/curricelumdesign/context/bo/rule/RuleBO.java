package com.hit.curricelumdesign.context.bo.rule;

/**
 * @author xbr
 * @Date 2020-03-14
 * @ClassName RuleBo
 * @Description
 */
public class RuleBO {
    //规则id
    private Integer ruleId;
    //规则类型
    private Integer type;
    //规则
    private String ruleString;

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRuleString() {
        return ruleString;
    }

    public void setRuleString(String ruleString) {
        this.ruleString = ruleString;
    }

    @Override
    public String toString() {
        return "RuleBo{" +
                "ruleId=" + ruleId +
                ", type=" + type +
                ", ruleString='" + ruleString + '\'' +
                '}';
    }
}

