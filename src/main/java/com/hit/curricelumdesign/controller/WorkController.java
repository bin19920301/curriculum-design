package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.context.annotation.HitApi;
import com.hit.curricelumdesign.context.param.work.AddCraftCardListParam;
import com.hit.curricelumdesign.context.param.work.AddCraftCardParam;
import com.hit.curricelumdesign.context.param.work.ScoreForWorkParam;
import com.hit.curricelumdesign.context.param.work.WorkBaseParam;
import com.hit.curricelumdesign.context.param.workmessage.AddWorkMessageByStudentParam;
import com.hit.curricelumdesign.context.param.workmessage.AddWorkMessageByTeacherParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = "/work/return/", method = RequestMethod.POST)
    @HitApi(checkTeacherLogin = true)
    public Result returnWork(WorkBaseParam param) {
        return workService.returnWork(param);
    }

    @RequestMapping(value = "/work/addcraftcardlist/", method = RequestMethod.POST)
    @HitApi(checkStudentLogin = true)
    public Result addCraftCardList(@RequestBody AddCraftCardListParam param) {
        return workService.addCraftCardList(param);
    }


}
