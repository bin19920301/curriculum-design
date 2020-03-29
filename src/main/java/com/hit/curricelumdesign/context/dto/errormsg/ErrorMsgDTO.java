package com.hit.curricelumdesign.context.dto.errormsg;


/**
 * @author xbr
 * @Date 2020-03-29
 * @ClassName ErrorMsgDTO
 * @Description
 */
public class ErrorMsgDTO {

    /**
     * 加工表面id
     */
    private Integer surfaceId;

    /**
     * 规则类型;1加工优先级2加工方法
     */
    private Integer rulesType;

    /**
     * 规则详情
     */
    private String ruleDesc;

    public Integer getSurfaceId() {
        return surfaceId;
    }

    public void setSurfaceId(Integer surfaceId) {
        this.surfaceId = surfaceId;
    }

    public Integer getRulesType() {
        return rulesType;
    }

    public void setRulesType(Integer rulesType) {
        this.rulesType = rulesType;
    }

    public String getRuleDesc() {
        return ruleDesc;
    }

    public void setRuleDesc(String ruleDesc) {
        this.ruleDesc = ruleDesc;
    }

    @Override
    public String toString() {
        return "ErrorMsgDTO{" +
                "surfaceId=" + surfaceId +
                ", rulesType=" + rulesType +
                ", ruleDesc='" + ruleDesc + '\'' +
                '}';
    }
}
