package com.hit.curricelumdesign.context.bo.rule;

import com.hit.curricelumdesign.context.dto.errormsg.ErrorMsgDTO;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbr
 * @Date 2020-03-14
 * @ClassName SurfaceBO
 * @Description
 */
public class SurfaceBO {

    //工序id
    private Integer processId;

    //表面id
    private Integer surfaceId;

    //<规则id,规则详情>
    private Map<Integer, ErrorMsgDTO> errorMsg;

    public SurfaceBO(Integer processId, Integer surfaceId) {
        this.processId = processId;
        this.surfaceId = surfaceId;
        this.errorMsg = new HashMap<>();
    }

    public Integer getProcessId() {
        return processId;
    }

    public void setProcessId(Integer processId) {
        this.processId = processId;
    }

    public Integer getSurfaceId() {
        return surfaceId;
    }

    public void setSurfaceId(Integer surfaceId) {
        this.surfaceId = surfaceId;
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
        return "SurfaceBO{" +
                "processId=" + processId +
                ", surfaceId=" + surfaceId +
                ", errorMsg=" + errorMsg +
                '}';
    }
}


