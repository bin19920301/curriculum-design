package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.context.annotation.HitApi;
import com.hit.curricelumdesign.context.param.work.ScoreForWorkParam;
import com.hit.curricelumdesign.context.param.workproject.AddWorkProjectParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xbr
 * @Date 2019-12-21
 * @ClassName WorkController
 * @Description
 */
@RestController
public class WorkController {

    @Autowired
    private WorkService workService;

    @RequestMapping(value = "/work/score/", method = RequestMethod.POST)
    @HitApi(checkTeacherLogin = true)
    public Result score(ScoreForWorkParam param) {
        return workService.score(param);
    }
}
