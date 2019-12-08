package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.context.annotation.HitApi;
import com.hit.curricelumdesign.context.param.BaseListRequestParam;
import com.hit.curricelumdesign.context.param.admin.GetAdminParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xbr
 * @Date 2019-12-07
 * @ClassName AdminController
 * @Description
 */
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;


    @RequestMapping(value = "/admin/getadminbyid/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result getAdmin(GetAdminParam param) {
        return adminService.getAdminById(param);
    }


    @RequestMapping(value = "/admin/getadminlist/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result getAdminList(BaseListRequestParam param) {
        return adminService.getAdminList(param);
    }
}
