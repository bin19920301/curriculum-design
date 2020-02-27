package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.dto.workingposition.WorkingPositionDTO;
import com.hit.curricelumdesign.context.entity.WorkingPosition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    List<WorkingPositionDTO> findByProcessId(Integer processId);

    List<WorkingPosition> selectByCardId(@Param("cardId") Integer cardId);

    void deleteWorkingPositionByCardId(@Param("cardId") Integer cardId);
}
