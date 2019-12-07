package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.entity.Folder;

public interface FolderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Folder record);

    int insertSelective(Folder record);

    Folder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Folder record);

    int updateByPrimaryKey(Folder record);
}