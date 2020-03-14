package com.hit.curricelumdesign.rule;

import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

/**
 * @author xbr
 * @Date 2020-03-14
 * @ClassName OrderRule
 * @Description
 */
public class OrderRule implements Rule {

    private Set<Integer> preSurfaceIdSet;
    private Integer currentSurface;

    @Override
    public String toString() {
        return "OrderRule{" +
                "preSurfaceIdSet=" + preSurfaceIdSet +
                ", currentSurface=" + currentSurface +
                '}';
    }

    public OrderRule(Set<Integer> preSurfaceIdSet, Integer currentSurface) {
        this.preSurfaceIdSet = preSurfaceIdSet;
        this.currentSurface = currentSurface;
    }

    @Override
    public void check(WorkCardBO workCardBO) {
        ArrayList<SurfaceBO> surfaceList = workCardBO.getSurfaceList();
        for (int i = 0; i < surfaceList.size(); i++) {
            SurfaceBO bo = surfaceList.get(i);
            if (currentSurface.equals(bo.getSurfaceId())) {

                preSurfaceIdSet.containsAll(null);
            }
        }
    }
}
