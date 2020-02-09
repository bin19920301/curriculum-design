package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.entity.FinishedSurface;

public interface FinishedSurfaceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FinishedSurface record);

    int insertSelective(FinishedSurface record);

    FinishedSurface selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FinishedSurface record);

    int updateByPrimaryKey(FinishedSurface record);
}