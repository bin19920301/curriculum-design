package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.entity.ProcessFile;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProcessFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProcessFile record);

    int insertSelective(ProcessFile record);

    ProcessFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProcessFile record);

    int updateByPrimaryKey(ProcessFile record);
}