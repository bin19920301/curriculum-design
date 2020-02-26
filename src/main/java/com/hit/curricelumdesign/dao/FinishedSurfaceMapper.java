package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.dto.finishedsurface.FinishedSurfaceDTO;
import com.hit.curricelumdesign.context.entity.FinishedSurface;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FinishedSurfaceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FinishedSurface record);

    int insertSelective(FinishedSurface record);

    FinishedSurface selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FinishedSurface record);

    int updateByPrimaryKey(FinishedSurface record);

    List<FinishedSurfaceDTO> selectByWorkProjectId(@Param("workProjectId") Integer workProjectId);

    FinishedSurface selectBySurfaceId(@Param("workProjectId") Integer workProjectId, @Param("surfaceId") Integer surfaceId);
}
