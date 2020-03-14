package com.hit.curricelumdesign.rule;

/**
 * @author xbr
 * @Date 2020-03-14
 * @ClassName RuleErrorMsg
 * @Description
 */
public class RuleErrorMsg {

    private Integer ruleId;

    private String errorMsg;

    public RuleErrorMsg(Integer ruleId, String errorMsg) {
        this.ruleId = ruleId;
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "RuleErrorMsg{" +
                "ruleId=" + ruleId +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
