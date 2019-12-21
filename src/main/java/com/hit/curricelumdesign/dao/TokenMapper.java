package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.entity.Token;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TokenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Token record);

    int insertSelective(Token record);

    Token selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Token record);

    int updateByPrimaryKey(Token record);

    Token getByToken(String token);

    Token getByTokenAndType(String token, int type);
}
