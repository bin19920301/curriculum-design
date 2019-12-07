package com.hit.curricelumdesign.manager.admin;

import com.hit.curricelumdesign.context.entity.Admin;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.dao.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xbr
 * @Date 2019-12-07
 * @ClassName AdminManager
 * @Description
 */
@Component
public class AdminManager {
    @Autowired
    private AdminMapper adminMapper;

    public Admin getAminById(Integer id) {
        Admin admin = adminMapper.selectByPrimaryKey(id);
        if (null == admin) {
            throw new BaseException(Error._300001);
        }
        return admin;
    }


}
