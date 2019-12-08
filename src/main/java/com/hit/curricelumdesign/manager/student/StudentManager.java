package com.hit.curricelumdesign.manager.student;

import com.hit.curricelumdesign.dao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentManager {
    @Autowired
    private StudentMapper studentMapper;

}
