package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.entity.Teaching;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TeachingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Teaching record);

    int insertSelective(Teaching record);

    Teaching selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Teaching record);

    int updateByPrimaryKey(Teaching record);
}