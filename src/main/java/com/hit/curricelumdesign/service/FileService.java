package com.hit.curricelumdesign.service;

import com.hit.curricelumdesign.context.constant.Constants;
import com.hit.curricelumdesign.context.dto.BaseListDTO;
import com.hit.curricelumdesign.context.dto.file.FileDTO;
import com.hit.curricelumdesign.context.entity.File;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.context.param.file.AddFileParam;
import com.hit.curricelumdesign.context.param.file.FileBaseParam;
import com.hit.curricelumdesign.context.param.file.ConditionFileParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.FileMapper;
import com.hit.curricelumdesign.manager.file.FileManager;
import com.hit.curricelumdesign.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class FileService {

    @Autowired
    private FileManager fileManager;

    @Autowired
    private FileMapper fileMapper;

    @Value("${hit.curricelumdesign.file.uploadFolderName}")
    private String fileUploadPath;


    /**
     * 增加文件信息（文件上传）
     *
     * @param fileParam
     * @return
     */
    public Result addFile(AddFileParam fileParam) {
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
        String filePath = currentSystemPath + fileUploadPath;
        // 文件重命名，防止重复
        String pathFileName = filePath + UUID.randomUUID() + "_" + fileName;
        // 文件对象
        java.io.File dest = new java.io.File(pathFileName);
        // 判断路径是否存在，如果不存在则创建
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        File file = new File();
        try {
            // 保存到服务器中
            multipartFile.transferTo(dest);
            file.setName(fileName);
            file.setPath(pathFileName);
            file.setFolderId(fileParam.getFolderId());
            file.setSize(sizeString);
            file.setUseCount(0);
            file.setCreatorId(fileParam.getTeacherId());
            file.setIsDelete(Constants.Common.IS_NOT);
            file.setCreatetime(new Date());
            file.setUpdaterId(fileParam.getTeacherId());
            file.setUpdatetime(new Date());
            fileMapper.insert(file);
            return Result.success();
        } catch (Exception e) {
            throw new BaseException(Error.FILE_UPLOAD_FAILURE);
        }

    }

    /**
     * 下载文件
     *
     * @param fileParam
     * @return
     */
    public void downloadFile(FileBaseParam fileParam, HttpServletResponse response) throws IOException {
        File currentFile = fileMapper.selectByPrimaryKey(fileParam.getId());
        String filePath = null;
        if (currentFile != null) {
            filePath = currentFile.getPath();
        } else {
            throw new BaseException(Error.FILE_IS_NOT_EXIST);
        }
        // 文件地址，真实环境是存放在数据库中的
        java.io.File file = new java.io.File(filePath);
        // 穿件输入对象
        FileInputStream fis = new FileInputStream(file);
        // 设置相关格式
        response.setContentType("application/force-download");
        // 设置下载后的文件名以及header
        response.addHeader("Content-disposition", "attachment;fileName=" + "a.txt");
        // 创建输出对象
        OutputStream os = response.getOutputStream();
        // 常规操作
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = fis.read(buf)) != -1) {
            os.write(buf, 0, len);
        }
        fis.close();

    }

    /**
     * 删除文件信息
     *
     * @param fileParam
     * @return
     */
    public Result deleteFile(FileBaseParam fileParam) {
        File file = new File();
        BeanUtil.copyProperties(fileParam, file);
        file.setIsDelete(Constants.Common.IS_YES);
        file.setUpdaterId(fileParam.getTeacherId());
        file.setUpdatetime(new Date());
        fileMapper.updateByPrimaryKeySelective(file);
        return Result.success();
    }


    /**
     * 查询文件夹下的文件信息所有文件信息
     *
     * @param
     * @return
     */
    public Result getFileByFolderId(ConditionFileParam fileParam) {
        List<FileDTO> fileDTOList = fileMapper.getListByFolderId(fileParam.getFolderId());
        BaseListDTO<FileDTO> fileDTOBaseList = new BaseListDTO<>(fileDTOList.size(), fileDTOList);
        return Result.success(fileDTOBaseList);
    }

    /**
     * 增加一次使用次数
     *
     * @param fileParam
     * @return
     */
    public Result addUseCount(FileBaseParam fileParam) {
        File currentFile = fileMapper.selectByPrimaryKey(fileParam.getId());
        String filePath = null;
        if (currentFile != null || currentFile.getIsDelete()) {
            filePath = currentFile.getPath();
        } else {
            throw new BaseException(Error.FILE_IS_NOT_EXIST);
        }
        currentFile.setUseCount(currentFile.getUseCount() + 1);
        fileMapper.updateByPrimaryKeySelective(currentFile);
        return Result.success();
    }
}
