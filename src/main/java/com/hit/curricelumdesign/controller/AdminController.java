package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.context.annotation.HitApi;
import com.hit.curricelumdesign.context.param.BaseListRequestParam;
import com.hit.curricelumdesign.context.param.BaseRequestParam;
import com.hit.curricelumdesign.context.param.admin.*;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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


    @RequestMapping(value = "/admin/addadmin/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result addAdmin(AddAdminParam param) {
        return adminService.addAdmin(param);
    }

    @RequestMapping(value = "/admin/updateadmin/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result updateAdmin(UpdateAdminParam param) {
        return adminService.updateAdmin(param);
    }

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

    @RequestMapping(value = "/admin/resetadminpassword/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result resetAdminPassword(ResetAdminPasswordParam param) {
        return adminService.resetAdminPassword(param);
    }

    @RequestMapping(value = "/admin/deleteadmin/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result deleteAdmin(DeleteAdminParam param) {
        return adminService.deleteAdmin(param);
    }

    @RequestMapping(value = "/admin/login/", method = RequestMethod.POST)
    public Result adminLogin(AdminLoginParam param) {
        return adminService.adminLogin(param);
    }
    @RequestMapping(value = "/admin/logout/", method = RequestMethod.POST)
    public Result adminLogout(BaseRequestParam param) {
        return adminService.adminLogout(param);
    }

}
