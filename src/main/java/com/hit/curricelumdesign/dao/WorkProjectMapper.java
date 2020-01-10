package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.dto.workproject.WorkProjectInfoDTO;
import com.hit.curricelumdesign.context.dto.workproject.WorkProjectListDTO;
import com.hit.curricelumdesign.context.entity.WorkProject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WorkProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WorkProject record);

    int insertSelective(WorkProject record);

    WorkProject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkProject record);

    int updateByPrimaryKey(WorkProject record);

    WorkProject getWorkProjectByName(String name);

    List<WorkProjectListDTO> getWorkProjectList();

    WorkProjectInfoDTO getWorkProjectInfoById(Integer workProjectId);

    void reduceOneUseTimes(Integer id);

    void increaseOneUseTimes(Integer id);
}
