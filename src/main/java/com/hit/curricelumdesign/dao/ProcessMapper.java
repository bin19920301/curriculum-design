package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.dto.process.ProcessDTO;
import com.hit.curricelumdesign.context.entity.Process;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProcessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Process record);

    int insertSelective(Process record);

    Process selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Process record);

    int updateByPrimaryKey(Process record);

    int deleteByCardId(Integer cardId);

    List<ProcessDTO> findByCardId(Integer cardId);
}