package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.dto.teaching.TeachingDTO;
import com.hit.curricelumdesign.context.entity.Teaching;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeachingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Teaching record);

    int insertSelective(Teaching record);

    Teaching selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Teaching record);

    int updateByPrimaryKey(Teaching record);

    // TeachingDTO selectById(Integer id);

    // List<TeachingDTO> getTeachingDTOByCreatorId(Integer id);
}