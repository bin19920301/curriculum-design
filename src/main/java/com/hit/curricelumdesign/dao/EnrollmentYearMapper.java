package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.entity.EnrollmentYear;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EnrollmentYearMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnrollmentYear record);

    int insertSelective(EnrollmentYear record);

    EnrollmentYear selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnrollmentYear record);

    int updateByPrimaryKey(EnrollmentYear record);
}