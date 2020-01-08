package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.entity.WorkProjectFile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WorkProjectFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WorkProjectFile record);

    int insertList(@Param("list") List<WorkProjectFile> list);

    int insertSelective(WorkProjectFile record);

    WorkProjectFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkProjectFile record);

    int updateByPrimaryKey(WorkProjectFile record);

    int deleteByWorkProjectId(Integer workProjectId);
}
