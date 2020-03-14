package com.hit.curricelumdesign.rule;

import com.hit.curricelumdesign.context.bo.rule.WorkCardBO;

/**
 * @author xbr
 * @Date 2020-03-14
 * @ClassName Rule
 * @Description
 */
public interface Rule {
    void check(WorkCardBO workCardBO);
}
