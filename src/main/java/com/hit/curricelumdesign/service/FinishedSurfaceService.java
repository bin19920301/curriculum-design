package com.hit.curricelumdesign.service;

import com.hit.curricelumdesign.context.constant.Constants;
import com.hit.curricelumdesign.context.dto.BaseListDTO;
import com.hit.curricelumdesign.context.dto.finishedsurface.FinishedSurfaceDTO;
import com.hit.curricelumdesign.context.entity.FinishedSurface;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.context.param.finishedsurface.AddFinishedSurfaceParam;
import com.hit.curricelumdesign.context.param.finishedsurface.DelFinishedSurfaceParam;
import com.hit.curricelumdesign.context.param.finishedsurface.FinishedSurfaceListParam;
import com.hit.curricelumdesign.context.param.finishedsurface.UpdateFinishedSurfaceParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.FinishedSurfaceMapper;
import com.hit.curricelumdesign.utils.BeanUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author xbr
 * @Date 2020-02-23
 * @ClassName FinishedSurfaceService
 * @Description
 */
@Service
public class FinishedSurfaceService {

    @Autowired
    private FinishedSurfaceMapper finishedSurfaceMapper;

    public Result list(FinishedSurfaceListParam param) {
        List<FinishedSurfaceDTO> finishedSurfaceDTOList = finishedSurfaceMapper.selectByWorkProjectId(param.getWorkProjectId());
        BaseListDTO<FinishedSurfaceDTO> listDTO = new BaseListDTO<>(finishedSurfaceDTOList.size(), finishedSurfaceDTOList);
        return Result.success(listDTO);
    }

    public Result add(AddFinishedSurfaceParam param) {
        FinishedSurface finishedSurface = finishedSurfaceMapper.selectBySurfaceId(param.getWorkProjectId(), param.getSurfaceId());
        if (!Objects.isNull(finishedSurface)) {
            throw new BaseException(Error.FINISHED_SURFACE_SURFACE_ID_IS_EXIST);
        }
        finishedSurface = new FinishedSurface();
        BeanUtil.copyProperties(param, finishedSurface);
        Date now = new Date();
        finishedSurface.setIsDelete(Constants.Common.IS_NOT);
        finishedSurface.setCreatetime(now);
        finishedSurface.setCreatorId(param.getLoginTeacherId());
        finishedSurface.setUpdatetime(now);
        finishedSurface.setUpdaterId(param.getLoginTeacherId());
        finishedSurfaceMapper.insertSelective(finishedSurface);
        return Result.success();
    }

    public Result del(DelFinishedSurfaceParam param) {
        FinishedSurface finishedSurface = finishedSurfaceMapper.selectBySurfaceId(param.getWorkProjectId(), param.getSurfaceId());
        if (Objects.isNull(finishedSurface)) {
            throw new BaseException(Error.FINISHED_SURFACE_IS_NOT_EXIST);
        }
        finishedSurface.setIsDelete(Constants.Common.IS_YES);
        finishedSurface.setUpdatetime(new Date());
        finishedSurface.setUpdaterId(param.getLoginTeacherId());
        finishedSurfaceMapper.updateByPrimaryKeySelective(finishedSurface);
        return Result.success();
    }

    public Result update(UpdateFinishedSurfaceParam param) {
        FinishedSurface finishedSurface = finishedSurfaceMapper.selectBySurfaceId(param.getWorkProjectId(), param.getSurfaceId());
        if (Objects.isNull(finishedSurface)) {
            throw new BaseException(Error.FINISHED_SURFACE_IS_NOT_EXIST);
        }
        BeanUtil.copyProperties(param, finishedSurface);
        finishedSurface.setUpdaterId(param.getLoginTeacherId());
        finishedSurface.setUpdatetime(new Date());
        finishedSurfaceMapper.updateByPrimaryKeySelective(finishedSurface);
        return Result.success();
    }
}
