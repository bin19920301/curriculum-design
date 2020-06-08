package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.context.dto.processingmethod.ProcessingMethodDTO;
import com.hit.curricelumdesign.context.entity.ProcessingMethod;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.ProcessingMethodMapper;
import com.hit.curricelumdesign.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbr
 * @Date 2019-12-21
 * @ClassName ProcessingMethodController
 * @Description
 */
@RestController
public class ProcessingMethodController {

    @Autowired
    private ProcessingMethodMapper processingMethodMapper;

    /**
     * 查询所有加工形式
     *
     * @return
     */
    @RequestMapping(value = "/processingmethod/getallprocessingmethod/", method = RequestMethod.POST)
    public Result getAllProcessingMethod() {
        List<ProcessingMethod> allProcessingMethod = processingMethodMapper.getAllProcessingMethod();
        List<ProcessingMethodDTO> dtoList = new ArrayList<>();
        for (ProcessingMethod processingMethod : allProcessingMethod) {
            ProcessingMethodDTO dto = new ProcessingMethodDTO();
            BeanUtil.copyProperties(processingMethod, dto);
            dtoList.add(dto);
        }
        return Result.success(dtoList);
    }
}
