package com.hit.curricelumdesign.rule;

import com.hit.curricelumdesign.context.bo.rule.FinishedMethodBO;
import com.hit.curricelumdesign.context.bo.rule.RuleBO;
import com.hit.curricelumdesign.context.bo.rule.WorkCardBO;
import com.hit.curricelumdesign.utils.StringUtil;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author xbr
 * @Date 2020-03-14
 * @ClassName MethodRule
 * @Description
 */
public class MethodRule implements Rule {

    //表面id
    private Integer surfaceId;

    //加工方法
    //加工方法ID：车削-a；铣削-b；刨-c；磨-d；钻-e；铰-f
    //设计出现错误 数据库设计时: 机床;1车床,2铣床,3刨床,4磨床
    private String methodCharacter;

    //RuleBO
    private RuleBO ruleBO;

    public MethodRule(Integer surfaceId, String methodCharacter, RuleBO ruleBO) {
        this.surfaceId = surfaceId;
        this.methodCharacter = methodCharacter;
        this.ruleBO = ruleBO;
    }

    @Override
    public void check(WorkCardBO workCardBO) {
        ArrayList<FinishedMethodBO> finishedMethodBOList = workCardBO.getFinishedMethodBOList();
        //list的非空判断
        if (finishedMethodBOList.isEmpty()){
            return;
        }
        //使用迭代器,可以删除已经判断过的规则
        Iterator<FinishedMethodBO> iterator = finishedMethodBOList.iterator();
        while(iterator.hasNext()){
            FinishedMethodBO finishedMethodBO = iterator.next();
            //找到相同的加工表面id
            if (finishedMethodBO.getSurfaceId() == this.surfaceId){
                //判断加工方法是否正确
                String method = finishedMethodBO.getMethod();
                if (StringUtil.isBlank(method) || !method.equals(methodCharacter)){
                    finishedMethodBO.addErrorMsg(ruleBO.getRuleId(),ruleBO.getRuleString());
                }
                //该工位的加工规则已经判断过了,从集合中移除
                iterator.remove();
            }
        }


    }

    public Integer getSurfaceId() {
        return surfaceId;
    }

    public void setSurfaceId(Integer surfaceId) {
        this.surfaceId = surfaceId;
    }

    public String getMethodCharacter() {
        return methodCharacter;
    }

    public void setMethodCharacter(String methodCharacter) {
        this.methodCharacter = methodCharacter;
    }

    public RuleBO getRuleBO() {
        return ruleBO;
    }

    public void setRuleBO(RuleBO ruleBO) {
        this.ruleBO = ruleBO;
    }
}
