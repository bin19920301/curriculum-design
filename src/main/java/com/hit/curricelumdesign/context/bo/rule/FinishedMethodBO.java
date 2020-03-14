package com.hit.curricelumdesign.context.bo.rule;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbr
 * @Date 2020-03-14
 * @ClassName FinishedMethodBO
 * @Description
 */
public class FinishedMethodBO {

    //工位id
    private Integer positionId;

    //加工表面id
    private Integer surfaceId;

    //加工方法
    private String method;
    //<规则id,规则详情>
    private Map<Integer, String> errorMsg;

    public FinishedMethodBO(Integer surfaceId, String method) {
        this.surfaceId = surfaceId;
        this.method = method;
        this.errorMsg = new HashMap<>();
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getSurfaceId() {
        return surfaceId;
    }

    public void setSurfaceId(Integer surfaceId) {
        this.surfaceId = surfaceId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Map<Integer, String> getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(Map<Integer, String> errorMsg) {
        this.errorMsg = errorMsg;
    }

    public void addErrorMsg(Integer ruleId, String ruleDetail) {
        if (!errorMsg.containsKey(ruleId)) {
            errorMsg.put(ruleId, ruleDetail);
        }
    }

    @Override
    public String toString() {
        return "FinishedMethodBO{" +
                "surfaceId=" + surfaceId +
                ", method='" + method + '\'' +
                ", errorMsg=" + errorMsg +
                '}';
    }
}
