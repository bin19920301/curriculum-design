package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.context.annotation.HitApi;
import com.hit.curricelumdesign.context.param.finishedsurface.AddFinishedSurfaceParam;
import com.hit.curricelumdesign.context.param.finishedsurface.DelFinishedSurfaceParam;
import com.hit.curricelumdesign.context.param.finishedsurface.FinishedSurfaceListParam;
import com.hit.curricelumdesign.context.param.finishedsurface.UpdateFinishedSurfaceParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.service.FinishedSurfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xbr
 * @Date 2020-02-23
 * @ClassName FinishedSurfaceController
 * @Description
 */
@RestController
public class FinishedSurfaceController {

    @Autowired
    private FinishedSurfaceService finishedSurfaceService;

    @RequestMapping(value = "/finishedsurface/list/", method = RequestMethod.POST)
    public Result list(FinishedSurfaceListParam param) {
        return finishedSurfaceService.list(param);
    }
    @RequestMapping(value = "/finishedsurface/add/", method = RequestMethod.POST)
    @HitApi(checkTeacherLogin = true)
    public Result add(AddFinishedSurfaceParam param) {
        return finishedSurfaceService.add(param);
    }
    @RequestMapping(value = "/finishedsurface/del/", method = RequestMethod.POST)
    @HitApi(checkTeacherLogin = true)
    public Result del(DelFinishedSurfaceParam param) {
        return finishedSurfaceService.del(param);
    }
    @RequestMapping(value = "/finishedsurface/update/", method = RequestMethod.POST)
    @HitApi(checkTeacherLogin = true)
    public Result update(UpdateFinishedSurfaceParam param) {
        return finishedSurfaceService.update(param);
    }
}
