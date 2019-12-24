package com.hit.curricelumdesign.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hit.curricelumdesign.context.constant.Constants;
import com.hit.curricelumdesign.context.dto.BaseListDTO;
import com.hit.curricelumdesign.context.dto.file.FileListDTO;
import com.hit.curricelumdesign.context.dto.workproject.WorkProjectInfoDTO;
import com.hit.curricelumdesign.context.dto.workproject.WorkProjectListDTO;
import com.hit.curricelumdesign.context.entity.File;
import com.hit.curricelumdesign.context.entity.WorkProject;
import com.hit.curricelumdesign.context.entity.WorkProjectFile;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.context.param.workproject.*;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.FileMapper;
import com.hit.curricelumdesign.dao.WorkProjectFileMapper;
import com.hit.curricelumdesign.dao.WorkProjectMapper;
import com.hit.curricelumdesign.manager.file.FileManager;
import com.hit.curricelumdesign.manager.workproject.WorkProjectManager;
import com.hit.curricelumdesign.utils.BeanUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author xbr
 * @Date 2019-12-12
 * @ClassName WorkProjectService
 * @Description
 */
@Service
public class WorkProjectService {

    @Autowired
    private WorkProjectManager workProjectManager;

    @Autowired
    private WorkProjectMapper workProjectMapper;

    @Autowired
    private FileMapper fileMapper;

    @Autowired
    private FileManager fileManager;

    @Autowired
    private WorkProjectFileMapper workProjectFileMapper;

    /**
     * 添加作业项目
     *
     * @param param
     * @return
     */
    @Transactional
    public Result addWorkProject(AddWorkProjectParam param) {
        WorkProject workProjectByName = workProjectMapper.getWorkProjectByName(param.getName());
        if (null != workProjectByName) {
            throw new BaseException(Error.WORK_PROJECT_NAME_IS_EXIST);
        }
        if (CollectionUtils.isEmpty(param.getFileIdList())) {
            throw new BaseException(Error.WORK_PROJECT_NEED_ASSOCIATE_FILE);
        }
        List<File> fileList = fileManager.getFileByIdList(param.getFileIdList());
        if (CollectionUtils.isEmpty(fileList) || param.getFileIdList().size() != fileList.size()) {
            throw new BaseException(Error.WORK_PROJECT_ASSOCIATE_FILE_HAS_NOT_EXIST);
        }
        Date now = new Date();
        WorkProject workProject = new WorkProject();
        BeanUtil.copyProperties(param, workProject, "fileIdList");
        workProject.setUseCount(0);
        workProject.setIsDelete(Constants.Common.IS_NOT);
        workProject.setCreatetime(now);
        //todo id
        workProject.setCreatorId(0);
        workProject.setUpdatetime(now);
        workProject.setUpdaterId(0);
        workProjectMapper.insert(workProject);
        List<WorkProjectFile> workProjectFileList = new ArrayList<>();
        for (File file : fileList) {
            WorkProjectFile workProjectFile = buildWorkProjectFile(file, workProject);
            workProjectFileList.add(workProjectFile);
            Integer useCount = file.getUseCount();
            file.setUseCount(useCount + 1);
        }
        workProjectFileMapper.insertList(workProjectFileList);
        for (File file : fileList) {
            fileMapper.updateByPrimaryKey(file);
        }
        return Result.success();
    }


    public WorkProjectFile buildWorkProjectFile(File file, WorkProject workProject) {
        WorkProjectFile record = new WorkProjectFile();
        record.setWorkProjectId(workProject.getId());
        record.setFileId(file.getId());
        record.setIsDelete(Constants.Common.IS_NOT);
        Date now = new Date();
        record.setCreatetime(now);
        record.setCreatorId(workProject.getCreatorId());
        record.setUpdatetime(now);
        record.setUpdaterId(workProject.getUpdaterId());
        return record;
    }

    /**
     * 获取作业项目列表
     *
     * @param param
     * @return
     */
    public Result getWorkProjectList(GetWorkProjectListParam param) {
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        List<WorkProjectListDTO> workProjectListDTOList = workProjectMapper.getWorkProjectList();
        PageInfo<WorkProjectListDTO> pageInfo = new PageInfo(workProjectListDTOList);
        for (WorkProjectListDTO workProjectListDTO : workProjectListDTOList) {
            List<String> fileNameList = fileMapper.getFileNameByWorkProjectId(workProjectListDTO.getId());
            workProjectListDTO.setFileName(fileNameList);
        }
        BaseListDTO<WorkProjectListDTO> baseListDTO = new BaseListDTO<>(pageInfo.getTotal(), pageInfo.getList());
        return Result.success(baseListDTO);
    }


    /**
     * 查询作业项目详情
     *
     * @param param
     * @return
     */
    public Result getWorkProjectInfo(GetWorkProjectInfoParam param) {
        WorkProjectInfoDTO workProjectInfoDTO = workProjectMapper.getWorkProjectInfoById(param.getWorkProjectId());
        if (null == workProjectInfoDTO) {
            throw new BaseException(Error.WORK_PROJECT_IS_NOT_EXIST);
        }
        List<FileListDTO> fileListDTOList = fileMapper.getFileListDTOByWorkProjectId(workProjectInfoDTO.getId());
        workProjectInfoDTO.setFilelist(fileListDTOList);
        return Result.success(workProjectInfoDTO);
    }

    /**
     * 修改作业项目
     *
     * @param param
     * @return
     */
    public Result updateWorkProject(UpdateWorkProjectParam param) {
        WorkProject workProject = workProjectMapper.selectByPrimaryKey(param.getId());
        if (null == workProject) {
            throw new BaseException(Error.WORK_PROJECT_IS_NOT_EXIST);
        }
        WorkProject workProjectByName = workProjectMapper.getWorkProjectByName(param.getName());
        if (null != workProjectByName && workProjectByName.getId().compareTo(param.getId()) != 0) {
            throw new BaseException(Error.WORK_PROJECT_NAME_IS_EXIST);
        }
        if (CollectionUtils.isEmpty(param.getFileIdList())) {
            throw new BaseException(Error.WORK_PROJECT_NEED_ASSOCIATE_FILE);
        }
        List<File> fileList = fileManager.getFileByIdList(param.getFileIdList());
        if (CollectionUtils.isEmpty(fileList) || param.getFileIdList().size() != fileList.size()) {
            throw new BaseException(Error.WORK_PROJECT_ASSOCIATE_FILE_HAS_NOT_EXIST);
        }
        workProjectFileMapper.deleteByWorkProjectId(workProject.getId());
        workProject.setUpdatetime(new Date());
        //todo id
        workProject.setUpdaterId(0);
        workProject.setName(param.getName());
        workProject.setDesc(param.getDesc());
        workProjectMapper.updateByPrimaryKey(workProject);
        List<WorkProjectFile> workProjectFileList = new ArrayList<>();
        for (File file : fileList) {
            WorkProjectFile workProjectFile = buildWorkProjectFile(file, workProject);
            workProjectFileList.add(workProjectFile);
            Integer useCount = file.getUseCount();
            file.setUseCount(useCount + 1);
        }
        workProjectFileMapper.insertList(workProjectFileList);
        for (File file : fileList) {
            fileMapper.updateByPrimaryKey(file);
        }

        return Result.success();
    }

    /**
     * 删除作业项目
     *
     * @param param
     * @return
     */
    public Result deleteWorkProject(DeleteWorkProjectParam param) {
        WorkProject workProject = workProjectMapper.selectByPrimaryKey(param.getWorkProjectId());
        if (null == workProject) {
            throw new BaseException(Error.WORK_PROJECT_IS_NOT_EXIST);
        }
        workProject.setIsDelete(Constants.Common.IS_YES);
        // todo id
        workProject.setUpdaterId(0);
        workProject.setUpdatetime(new Date());
        workProjectMapper.updateByPrimaryKey(workProject);
        workProjectFileMapper.deleteByWorkProjectId(workProject.getId());

        return Result.success();
    }

    /**
     * 获取全部作业项目
     * @return
     */
    public Result getAllWorkProjectList() {
        List<WorkProjectListDTO> workProjectListDTOList = workProjectMapper.getWorkProjectList();
        for (WorkProjectListDTO workProjectListDTO : workProjectListDTOList) {
            List<String> fileNameList = fileMapper.getFileNameByWorkProjectId(workProjectListDTO.getId());
            workProjectListDTO.setFileName(fileNameList);
        }
        BaseListDTO<WorkProjectListDTO> baseListDTO = new BaseListDTO<>(workProjectListDTOList.size(), workProjectListDTOList);
        return Result.success(baseListDTO);
    }
}
