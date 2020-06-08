package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.context.dto.processingmethod.ProcessingMethodDTO;
import com.hit.curricelumdesign.context.dto.surface.SurfaceDTO;
import com.hit.curricelumdesign.context.entity.ProcessingMethod;
import com.hit.curricelumdesign.context.entity.Surface;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.SurfaceMapper;
import com.hit.curricelumdesign.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbr
 * @Date 2019-12-21
 * @ClassName SurfaceController
 * @Description
 */
@RestController
public class SurfaceController {

    @Autowired
    private SurfaceMapper surfaceMapper;

    /**
     * 查询所有加工形式
     *
     * @return
     */
    @RequestMapping(value = "/surface/getallsurface/", method = RequestMethod.POST)
    public Result getAllSurface() {
        List<Surface> surfaceList = surfaceMapper.getAllSurface();
        List<SurfaceDTO> dtoList = new ArrayList<>();
        for (Surface surface : surfaceList) {
            SurfaceDTO dto = new SurfaceDTO();
            BeanUtil.copyProperties(surface, dto);
            dtoList.add(dto);
        }
        return Result.success(dtoList);
    }
}
