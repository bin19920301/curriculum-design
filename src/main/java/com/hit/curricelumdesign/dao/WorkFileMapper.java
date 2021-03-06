package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.dto.workfile.WorkFileDTO;
import com.hit.curricelumdesign.context.entity.WorkFile;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface WorkFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WorkFile record);

    int insertSelective(WorkFile record);

    WorkFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkFile record);

    int updateByPrimaryKey(WorkFile record);

    List<WorkFileDTO> getByWorkId(Integer workId);
}
