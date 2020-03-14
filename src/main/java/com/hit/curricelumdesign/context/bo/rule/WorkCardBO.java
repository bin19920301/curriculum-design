package com.hit.curricelumdesign.context.bo.rule;

import java.util.ArrayList;

/**
 * @author xbr
 * @Date 2020-03-14
 * @ClassName WorkCardBO
 * @Description
 */
public class WorkCardBO {

    ArrayList<SurfaceBO> surfaceList;
    ArrayList<FinishedMethodBO> finishedMethodBOList;

    public WorkCardBO(ArrayList<SurfaceBO> surfaceList, ArrayList<FinishedMethodBO> finishedMethodBOList) {
        this.surfaceList = surfaceList;
        this.finishedMethodBOList = finishedMethodBOList;
    }

    public ArrayList<SurfaceBO> getSurfaceList() {
        return surfaceList;
    }

    public void setSurfaceList(ArrayList<SurfaceBO> surfaceList) {
        this.surfaceList = surfaceList;
    }

    public ArrayList<FinishedMethodBO> getFinishedMethodBOList() {
        return finishedMethodBOList;
    }

    public void setFinishedMethodBOList(ArrayList<FinishedMethodBO> finishedMethodBOList) {
        this.finishedMethodBOList = finishedMethodBOList;
    }

    @Override
    public String toString() {
        return "WorkCardBO{" +
                "surfaceList=" + surfaceList +
                ", finishedMethodBOList=" + finishedMethodBOList +
                '}';
    }
}
