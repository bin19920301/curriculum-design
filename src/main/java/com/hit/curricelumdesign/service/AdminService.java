package com.hit.curricelumdesign.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hit.curricelumdesign.context.dto.BaseListDTO;
import com.hit.curricelumdesign.context.dto.admin.AdminDTO;
import com.hit.curricelumdesign.context.dto.admin.AdminListDTO;
import com.hit.curricelumdesign.context.entity.Admin;
import com.hit.curricelumdesign.context.param.BaseListRequestParam;
import com.hit.curricelumdesign.context.param.admin.GetAdminParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.manager.admin.AdminManager;
import com.hit.curricelumdesign.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public Result getAdminList(BaseListRequestParam param) {
        PageHelper.startPage(param.getPageNum() - 1, param.getPageSize());
        List<Admin> adminList = adminManager.getAdminList();
        PageInfo<Admin> pageInfo = new PageInfo<>(adminList);
        List<AdminListDTO> dtoList = new ArrayList<>();
        for (Admin admin : adminList) {
            AdminListDTO dto = new AdminListDTO();
            BeanUtil.copyProperties(admin, dto);
            dtoList.add(dto);
        }
        BaseListDTO<AdminListDTO> adminBaseListDTO = new BaseListDTO<>(pageInfo.getTotal(), dtoList);
        return Result.success(adminBaseListDTO);
    }
}
