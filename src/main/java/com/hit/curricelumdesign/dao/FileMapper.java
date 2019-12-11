package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.dto.file.FileDTO;
import com.hit.curricelumdesign.context.entity.File;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(File record);

    int insertSelective(File record);

    File selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(File record);

    int updateByPrimaryKey(File record);

    List<FileDTO> getListByFolderId(Integer folderId);

    Long countFileByFolderId(Integer folderId);
}