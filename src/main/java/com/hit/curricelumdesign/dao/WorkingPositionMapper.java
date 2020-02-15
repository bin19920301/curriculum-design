package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.entity.WorkingPosition;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface WorkingPositionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WorkingPosition record);

    int insertSelective(WorkingPosition record);

    WorkingPosition selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkingPosition record);

    int updateByPrimaryKey(WorkingPosition record);

    int deleteByCardId(Integer cardId);
}