package com.hit.curricelumdesign.service;

import com.hit.curricelumdesign.context.entity.Admin;
import com.hit.curricelumdesign.context.param.admin.GetAdminParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.manager.admin.AdminManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xbr
 * @Date 2019-12-07
 * @ClassName AdminService
 * @Description
 */
@Service
public class AdminService {

    @Autowired
    private AdminManager adminManager;

    public Result getAdminById(GetAdminParam param) {
        Admin admin = adminManager.getAminById(param.getId());
        return  Result.success(admin);
    }
}
