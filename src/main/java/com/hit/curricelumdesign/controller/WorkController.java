package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.context.annotation.HitApi;
import com.hit.curricelumdesign.context.param.work.*;
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

    @RequestMapping(value = "/work/submit/", method = RequestMethod.POST)
    @HitApi(checkStudentLogin = true)
    public Result submitWork(WorkBaseParam param) {
        return workService.submitWork(param);
    }

    @RequestMapping(value = "/work/addcraftcardlist/", method = RequestMethod.POST)
    @HitApi(checkStudentLogin = true)
    public Result addCraftCardList(@RequestBody AddCraftCardListParam param) {
        return workService.addCraftCardList(param);
    }


    @RequestMapping(value = "/work/getteacherworkinfobyid/", method = RequestMethod.POST)
    @HitApi(checkTeacherLogin = true)
    public Result getTeacherWorkInfoById(WorkBaseParam param) {
        return workService.getTeacherWorkInfoById(param);
    }

    @RequestMapping(value = "/work/getstudentworkinfobyid/", method = RequestMethod.POST)
    @HitApi(checkStudentLogin = true)
    public Result getStudentWorkInfoById(WorkBaseParam param) {
        return workService.getStudentWorkInfoById(param);
    }

    @RequestMapping(value = "/work/getworklistbystudentid/", method = RequestMethod.POST)
    @HitApi(checkStudentLogin = true)
    public Result getWorkListByStudentId(GetWorkListByStudentIdParam param) {
        return workService.getWorkListByStudentId(param);
    }



}
