package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.dto.enrollmentYear.EnrollmentYearDTO;
import com.hit.curricelumdesign.context.entity.EnrollmentYear;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EnrollmentYearMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnrollmentYear record);

    int insertSelective(EnrollmentYear record);

    EnrollmentYear selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnrollmentYear record);

    int updateByPrimaryKey(EnrollmentYear record);

    EnrollmentYear getEnrollmentYearByEnrollmentYear(Integer enrollmentYear);

    EnrollmentYearDTO selectById(Integer id);

    List<EnrollmentYearDTO> getEnrollmentYearList();
}
