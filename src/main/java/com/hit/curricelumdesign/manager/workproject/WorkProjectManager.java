package com.hit.curricelumdesign.manager.workproject;

import com.hit.curricelumdesign.context.entity.File;
import com.hit.curricelumdesign.dao.WorkProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xbr
 * @Date 2019-12-12
 * @ClassName WorkProjectManager
 * @Description
 */
@Component
public class WorkProjectManager {

    @Autowired
    private WorkProjectMapper workProjectMapper;

}
