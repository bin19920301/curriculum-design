package com.hit.curricelumdesign.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hit.curricelumdesign.context.dto.BaseListDTO;
import com.hit.curricelumdesign.context.dto.folder.FolderDTO;
import com.hit.curricelumdesign.context.entity.Folder;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.context.param.BaseListRequestParam;
import com.hit.curricelumdesign.context.param.folder.AddFolderParam;
import com.hit.curricelumdesign.context.param.folder.DeleteFolderParam;
import com.hit.curricelumdesign.context.param.folder.GetFolderParam;
import com.hit.curricelumdesign.context.param.folder.UpdateFolderParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.FolderMapper;
import com.hit.curricelumdesign.manager.folder.FolderManager;
import com.hit.curricelumdesign.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FolderService {

    @Autowired
    private FolderManager folderManager;
    
    @Autowired
    private FolderMapper folderMapper;

    /**
     * 文件夹信息详情展示
     * @param folderParam
     * @return
     */
    public Result getFolderById(GetFolderParam folderParam) {
        FolderDTO folder = folderManager.getFolderById(folderParam.getId());
        return  Result.success(folder);
    }

    /**
     * 增加文件夹信息
     * @param folderParam
     * @return
     */
    public Result addFolder(AddFolderParam folderParam){
        //判断文件夹名称是否存在
        FolderDTO folderByName = folderMapper.selectByName(folderParam.getName());
        if (null != folderByName){
            throw new BaseException(Error.FOLDER_NAME_IS_EXIST);
        }
        Folder folder = new Folder();
        BeanUtil.copyProperties(folderParam,folder);
        folder.setIsDelete(false);
        folder.setCreatorId(0);
        folder.setCreatetime(new Date());
        folder.setUpdaterId(0);
        folderMapper.insert(folder);
        return Result.success();
    }

    /**
     * 更新文件夹信息
     * @param folderParam
     * @return
     */
    public Result updateFolder(UpdateFolderParam folderParam){
        Folder folder = new Folder();
        BeanUtil.copyProperties(folderParam,folder);
        folder.setUpdatetime(new Date());
        folderMapper.updateByPrimaryKeySelective(folder);
        return Result.success();
    }

    /**
     * 删除文件夹信息
     * @param folderParam
     * @return
     */
    public Result deleteFolder(DeleteFolderParam folderParam){
        Folder folder = new Folder();
        BeanUtil.copyProperties(folderParam,folder);
        folder.setIsDelete(true);
        folder.setUpdatetime(new Date());
        folderMapper.updateByPrimaryKeySelective(folder);
        return Result.success();
    }

    /**
     * 分页查询文件夹信息
     * @param param
     * @return
     */
    public Result getFolderList(BaseListRequestParam param){
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        List<FolderDTO> folderList = folderMapper.getFolderDTOList();
        PageInfo<FolderDTO> pageInfo = new PageInfo<>(folderList);

        BaseListDTO<FolderDTO> folderBaseListDTO = new BaseListDTO<>(pageInfo.getTotal(), folderList);
        return Result.success(folderBaseListDTO);
    }

    /**
     * 查询所有文件夹信息
     * @param
     * @return
     */
    public Result getAllFolder(){
        List<FolderDTO> folderList = folderMapper.getFolderDTOList();
        PageInfo<FolderDTO> pageInfo = new PageInfo<>(folderList);

        BaseListDTO<FolderDTO> folderBaseListDTO = new BaseListDTO<>(pageInfo.getTotal(), folderList);
        return Result.success(folderBaseListDTO);
    }

}
