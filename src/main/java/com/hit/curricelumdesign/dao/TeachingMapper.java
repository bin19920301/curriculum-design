package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.dto.teaching.TeachingInfoDTO;
import com.hit.curricelumdesign.context.dto.teaching.TeachingListDTO;
import com.hit.curricelumdesign.context.dto.teaching.WorkTeachingDTO;
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

    TeachingInfoDTO selectById(Integer id);

    List<TeachingListDTO> getTeachingDTOByCreatorIdAndStatus(Integer creatorId, Integer status);

    TeachingListDTO selectByName(String name);

    WorkTeachingDTO getWorkTeachingDTOById(Integer teachingId);

    List<Teaching> getTeachingByStatus(Integer status);

    List<Teaching> getunFinishedTeaching();

}
