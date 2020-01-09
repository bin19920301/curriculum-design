package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.dto.teachingmessage.TeachingMessageInfoDTO;
import com.hit.curricelumdesign.context.entity.TeachingMessage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeachingMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TeachingMessage record);

    int insertSelective(TeachingMessage record);

    TeachingMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TeachingMessage record);

    int updateByPrimaryKey(TeachingMessage record);

    List<TeachingMessageInfoDTO> listByTeachingId(Integer teachingId, Integer startId);
}
