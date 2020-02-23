package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.context.annotation.HitApi;
import com.hit.curricelumdesign.context.param.admin.GetAdminParam;
import com.hit.curricelumdesign.context.response.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xbr
 * @Date 2019-12-08
 * @ClassName TestController
 * @Description
 */
@RestController
public class TestController {

    @RequestMapping(value = "/test/", method = RequestMethod.POST)
    public Result getAdmin(GetAdminParam param) {
        return Result.success();
    }
}
