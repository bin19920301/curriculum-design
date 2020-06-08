package com.hit.curricelumdesign.service;

import com.hit.curricelumdesign.context.constant.Constants;
import com.hit.curricelumdesign.context.entity.WorkFile;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.context.param.workfile.AddWorkFileParam;
import com.hit.curricelumdesign.context.param.workfile.WorkFileBaseParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.WorkFileMapper;
import com.hit.curricelumdesign.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class WorkFileService {

    @Autowired
    private WorkFileMapper workFileMapper;

    @Value("${hit.curricelumdesign.workfile.workFileFolderName}")
    private String workFileUploadPath;


    /**
     * 增加作业文件信息（文件上传）
     *
     * @param fileParam
     * @return
     */
    public Result addFile(AddWorkFileParam fileParam) {
        MultipartFile multipartFile = fileParam.getFile();
        // 当前项目路径
        String currentSystemPath = System.getProperty("user.dir");
        // 获取原始名字，已经带扩展名
        String fileName = multipartFile.getOriginalFilename();
        //获取文件大小
        Double size = Double.valueOf(multipartFile.getSize());
        String sizeString = "";
        DecimalFormat df = new DecimalFormat("#.00");
        if (size > 1024 * 1024 * 1024) {
            size = size / (1024 * 1024 * 1024);
            sizeString = df.format(size) + "GB";
        } else if (size > 1024 * 1024) {
            size = size / (1024 * 1024);
            sizeString = df.format(size) + "MB";
        } else if (size > 1024) {
            size = size / 1024;
            sizeString = df.format(size) + "KB";
        } else {
            sizeString = size + "B";
        }
        System.out.println("获取得文件大小" + multipartFile.getSize());
        // 获取后缀名
        // String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 文件保存路径
        String filePath = currentSystemPath + workFileUploadPath;
        // 文件重命名，防止重复
        String fileNewName = UUID.randomUUID() + "_" + fileName;
        // 真实路径
        String pathFileName = filePath + fileNewName;
        // 相对路径
        String relativePath = workFileUploadPath + fileNewName;
        // 文件对象
        File dest = new File(pathFileName);
        // 判断路径是否存在，如果不存在则创建
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        WorkFile file = new WorkFile();
        try {
            // 保存到服务器中
            multipartFile.transferTo(dest);
            file.setName(fileName);
            file.setPath(relativePath);
            file.setWorkId(fileParam.getWorkId());
            file.setSize(sizeString);
            file.setIsDelete(Constants.Common.IS_NOT);
            file.setCreatetime(new Date());
            file.setUpdatetime(new Date());
            workFileMapper.insert(file);
            return Result.success();
        } catch (Exception e) {
            throw new BaseException(Error.FILE_UPLOAD_FAILURE);
        }
    }

    /**
     * 删除作业文件信息
     *
     * @param workFileParam
     * @return
     */
    public Result deleteFile(WorkFileBaseParam workFileParam) {
        WorkFile workFile = new WorkFile();
        BeanUtil.copyProperties(workFileParam, workFile);
        workFile.setIsDelete(Constants.Common.IS_YES);
        workFile.setUpdatetime(new Date());
        workFileMapper.updateByPrimaryKeySelective(workFile);
        return Result.success();
    }

}
