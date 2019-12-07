package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.entity.Academy;

public interface AcademyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Academy record);

    int insertSelective(Academy record);

    Academy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Academy record);

    int updateByPrimaryKey(Academy record);
}