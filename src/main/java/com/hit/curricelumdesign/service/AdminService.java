package com.hit.curricelumdesign.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hit.curricelumdesign.context.constant.Constants;
import com.hit.curricelumdesign.context.dto.BaseListDTO;
import com.hit.curricelumdesign.context.dto.admin.AdminDTO;
import com.hit.curricelumdesign.context.dto.admin.AdminListDTO;
import com.hit.curricelumdesign.context.entity.Admin;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.context.param.BaseListRequestParam;
import com.hit.curricelumdesign.context.param.admin.*;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.AdminMapper;
import com.hit.curricelumdesign.manager.admin.AdminManager;
import com.hit.curricelumdesign.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private AdminMapper adminMapper;

    @Value("${hit.curricelumdesign.admin.password.default}")
    private String adminPasswordDefault;

    public Result addAdmin(AddAdminParam param) {
        Admin adminByNumber = adminMapper.getAdminByNumber(param.getNumber());
        if (null != adminByNumber) {
            throw new BaseException(Error._300002);
        }
        Date now = new Date();
        Admin admin = new Admin();
        BeanUtil.copyProperties(param, admin);
        admin.setIsDelete(Constants.Common.NOT);
        admin.setCreatetime(now);
        // todo id
        admin.setCreatorId(0);
        admin.setUpdatetime(now);
        admin.setUpdaterId(0);
        adminMapper.insert(admin);
        return Result.success();
    }

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

    /**
     * 修改管理员
     *
     * @param param
     * @return
     */
    public Result updateAdmin(UpdateAdminParam param) {
        Admin admin = adminManager.getAminById(param.getId());
        BeanUtil.copyProperties(param, admin);
        admin.setUpdatetime(new Date());
        // todo id
        admin.setUpdaterId(0);
        adminMapper.updateByPrimaryKey(admin);
        return Result.success();
    }


    /**
     * 充值管理员密码
     *
     * @param param
     * @return
     */
    public Result resetAdminPassword(ResetAdminPasswordParam param) {
        Admin admin = adminManager.getAminById(param.getId());
        admin.setPassword(adminPasswordDefault);
        admin.setUpdatetime(new Date());
        // todo id
        admin.setUpdaterId(0);
        adminMapper.updateByPrimaryKey(admin);
        return Result.success();
    }

    /**
     * 删除管理员
     *
     * @param param
     * @return
     */
    public Result deleteAdmin(DeleteAdminParam param) {
        Admin admin = adminManager.getAminById(param.getId());
        admin.setIsDelete(Constants.Common.YES);
        //todo id
        admin.setUpdaterId(0);
        admin.setUpdatetime(new Date());
        adminMapper.updateByPrimaryKey(admin);
        return Result.success();
    }
}
