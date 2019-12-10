package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.dto.folder.FolderDTO;
import com.hit.curricelumdesign.context.entity.Folder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FolderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Folder record);

    int insertSelective(Folder record);

    Folder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Folder record);

    int updateByPrimaryKey(Folder record);

    FolderDTO selectById(Integer id);

    FolderDTO selectByName(String name);

    List<FolderDTO> getFolderDTOList();
}