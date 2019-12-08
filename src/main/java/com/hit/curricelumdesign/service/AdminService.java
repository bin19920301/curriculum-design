package com.hit.curricelumdesign.service;

import com.hit.curricelumdesign.context.dto.AdminDTO;
import com.hit.curricelumdesign.context.entity.Admin;
import com.hit.curricelumdesign.context.param.admin.GetAdminListParam;
import com.hit.curricelumdesign.context.param.admin.GetAdminParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.manager.admin.AdminManager;
import com.hit.curricelumdesign.utils.BeanUtil;
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

    /**
     * 根据id查询
     *
     * @param param
     * @return
     */
    public Result getAdminById(GetAdminParam param) {
        Admin admin = adminManager.getAminById(param.getId());
        AdminDTO dto = new AdminDTO();
        BeanUtil.copyProperties(admin, dto);
        return Result.success(dto);
    }

    /**
     * 查询
     *
     * @param param
     * @return
     */
    public Result getAdminList(GetAdminListParam param) {
        return null;
    }
}
