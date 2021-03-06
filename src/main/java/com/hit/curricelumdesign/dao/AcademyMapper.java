package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.entity.Academy;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AcademyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Academy record);

    int insertSelective(Academy record);

    Academy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Academy record);

    int updateByPrimaryKey(Academy record);

    Academy getAcademyByName(String name);

    Academy getAcademyById(Integer id);

    List<Academy> getAcademyList();
}
