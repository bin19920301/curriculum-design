package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.entity.Surface;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SurfaceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Surface record);

    int insertSelective(Surface record);

    Surface selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Surface record);

    int updateByPrimaryKey(Surface record);
}