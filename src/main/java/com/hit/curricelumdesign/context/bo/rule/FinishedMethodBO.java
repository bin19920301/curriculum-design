package com.hit.curricelumdesign.context.bo.rule;

import com.hit.curricelumdesign.context.dto.errormsg.ErrorMsgDTO;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbr
 * @Date 2020-03-14
 * @ClassName FinishedMethodBO
 * @Description
 */
public class FinishedMethodBO {

    /**
     * 工序id
     */
    private Integer processId;

    /**
     * 工位id
     */
    private Integer positionId;

    //工步id
    private Integer stepId;

    //加工表面id
    private Integer surfaceId;

    //加工方法
    private String method;

    //<规则id,规则详情>
    private Map<Integer, ErrorMsgDTO> errorMsg;

    public FinishedMethodBO(Integer processId, Integer positionId, Integer stepId, Integer surfaceId, String method) {
        this.processId = processId;
        this.positionId = positionId;
        this.stepId = stepId;
        this.surfaceId = surfaceId;
        this.method = method;
        this.errorMsg = new HashMap<>();
    }

    public Integer getProcessId() {
        return processId;
    }

    public void setProcessId(Integer processId) {
        this.processId = processId;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getStepId() {
        return stepId;
    }

    public void setStepId(Integer stepId) {
        this.stepId = stepId;
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

    public Map<Integer, ErrorMsgDTO> getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(Map<Integer, ErrorMsgDTO> errorMsg) {
        this.errorMsg = errorMsg;
    }

    public void addErrorMsg(Integer ruleId, ErrorMsgDTO errorMsgDTO) {
        if (!errorMsg.containsKey(ruleId)) {
            errorMsg.put(ruleId, errorMsgDTO);
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