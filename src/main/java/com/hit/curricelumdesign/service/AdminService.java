package com.hit.curricelumdesign.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hit.curricelumdesign.context.constant.Constants;
import com.hit.curricelumdesign.context.dto.BaseListDTO;
import com.hit.curricelumdesign.context.dto.admin.AdminDTO;
import com.hit.curricelumdesign.context.dto.admin.AdminListDTO;
import com.hit.curricelumdesign.context.entity.Admin;
import com.hit.curricelumdesign.context.entity.Teacher;
import com.hit.curricelumdesign.context.entity.Token;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.context.param.BaseListRequestParam;
import com.hit.curricelumdesign.context.param.BaseRequestParam;
import com.hit.curricelumdesign.context.param.admin.*;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.AdminMapper;
import com.hit.curricelumdesign.dao.TokenMapper;
import com.hit.curricelumdesign.manager.admin.AdminManager;
import com.hit.curricelumdesign.utils.BeanUtil;
import com.hit.curricelumdesign.utils.MsgUtils;
import com.hit.curricelumdesign.utils.TokenUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Autowired
    private TokenMapper tokenMapper;

    @Value("${hit.curricelumdesign.password.md5.pre}")
    private String md5Pre;

    public Result addAdmin(AddAdminParam param) {
        Admin adminByNumber = adminMapper.getAdminByNumber(param.getNumber());
        if (null != adminByNumber) {
            throw new BaseException(Error.ADMIN_NUMBER_IS_EXIST);
        }
        Date now = new Date();
        Admin admin = new Admin();
        BeanUtil.copyProperties(param, admin, "password");
        admin.setPassword(DigestUtils.md5Hex(md5Pre + param.getPassword()));
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
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
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
        Admin adminByNumber = adminMapper.getAdminByNumber(param.getNumber());
        if (null != adminByNumber && admin.getId().compareTo(adminByNumber.getId()) != 0) {
            throw new BaseException(Error.ADMIN_NUMBER_IS_EXIST);
        }
        BeanUtil.copyProperties(param, admin, "password");
        admin.setPassword(DigestUtils.md5Hex(md5Pre + param.getPassword()));
        admin.setUpdatetime(new Date());
        // todo id
        admin.setUpdaterId(0);
        adminMapper.updateByPrimaryKey(admin);
        return Result.success();
    }


    /**
     * 重置管理员密码
     *
     * @param param
     * @return
     */
    public Result resetAdminPassword(ResetAdminPasswordParam param) {
        Admin admin = adminManager.getAminById(param.getId());
        admin.setPassword(DigestUtils.md5Hex(md5Pre + adminPasswordDefault));
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

    /**
     * 管理员登录
     *
     * @param param
     * @return
     */
    public Result adminLogin(AdminLoginParam param) {
        Admin admin = adminMapper.getAdminByNumber(param.getNumber());
        if (null == admin) {
            throw new BaseException(Error._200202);
        }
        String password = param.getPassword();
        String md5Password = DigestUtils.md5Hex(md5Pre + password);
        if (!StringUtils.equals(md5Password, admin.getPassword())) {
            throw new BaseException(Error._200203);
        }
        String tokenStr = TokenUtils.getToken(admin.getId(), admin.getName(), admin.getNumber(), MsgUtils.generateUUIDStr());
        Token token = new Token();
        token.setToken(tokenStr);
        token.setType(Constants.Token.TYPE_ADMIN);
        token.setUserId(admin.getId());
        token.setIsDelete(Constants.Common.IS_NOT);
        Date now = new Date();
        token.setCreatetime(now);
        token.setUpdatetime(now);
        tokenMapper.insert(token);
        Map<String, String> result = new HashMap<>();
        result.put("token", tokenStr);
        result.put("adminId", admin.getId().toString());
        result.put("adminName", admin.getName());
        return Result.success(result);
    }

    /**
     * 管理员登出
     *
     * @param param
     * @return
     */
    public Result adminLogout(BaseRequestParam param) {
        String adminToken = param.getAdminToken();
        if (StringUtils.isBlank(adminToken)) {
            throw new BaseException(Error._200201);
        }
        Token token = tokenMapper.getByTokenAndType(adminToken, Constants.Token.TYPE_ADMIN);
        if (null != token) {
            token.setIsDelete(Constants.Common.IS_YES);
            token.setUpdatetime(new Date());
            tokenMapper.updateByPrimaryKey(token);
        }
        return Result.success();
    }
}
