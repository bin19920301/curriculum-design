package com.hit.curricelumdesign.rule;

import java.util.List;

/**
 * @author xbr
 * @Date 2020-03-14
 * @ClassName RuleChain
 * @Description
 */
public class RuleChain {
    List<Rule> chain;

    public List<Rule> getChain() {
        return chain;
    }

    public void setChain(List<Rule> chain) {
        this.chain = chain;
    }

    void check(List<WorkCardBO> workCardBOList) {
        for (Rule rule : chain) {
            rule.check(workCardBOList);
        }
    }

}
