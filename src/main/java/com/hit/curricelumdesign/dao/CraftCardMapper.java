package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.entity.CraftCard;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CraftCardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CraftCard record);

    int insertSelective(CraftCard record);

    CraftCard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CraftCard record);

    int updateByPrimaryKey(CraftCard record);

    List<CraftCard> getCraftCardListByWorkId(Integer workId);
}
