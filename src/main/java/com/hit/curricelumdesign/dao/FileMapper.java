package com.hit.curricelumdesign.dao;

import com.hit.curricelumdesign.context.dto.file.FileDTO;
import com.hit.curricelumdesign.context.dto.file.FileListDTO;
import com.hit.curricelumdesign.context.entity.File;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

    List<File> getFileByIdList(@Param("fileIdList") List<Integer> fileIdList);

    List<String> getFileNameByWorkProjectId(Integer workProjectListId);

    List<FileListDTO> getFileListDTOByWorkProjectId(Integer workProjectListId);
}
