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
    public void check(WorkCardBO workCardBO) {
        ArrayList<SurfaceBO> surfaceList = workCardBO.getSurfaceList();
        Map<Integer, Set<SurfaceBO>> surfaceBOMap = new HashMap<>();
        for (SurfaceBO bo : surfaceList) {
            Integer surfaceId = bo.getSurfaceId();
            if (surfaceBOMap.containsKey(surfaceId)) {

            } else {
                Set<SurfaceBO> surfaceBOSet = new HashSet<>();
                surfaceBOSet.add(bo);
                surfaceBOMap.put(surfaceId, surfaceBOSet);
            }

        }
    }
}
