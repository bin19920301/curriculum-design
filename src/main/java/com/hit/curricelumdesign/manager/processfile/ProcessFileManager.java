package com.hit.curricelumdesign.manager.processfile;

import com.hit.curricelumdesign.dao.ProcessFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessFileManager {
    @Autowired
    private ProcessFileMapper processFileMapper;

}
