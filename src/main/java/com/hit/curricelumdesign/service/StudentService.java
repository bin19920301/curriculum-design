package com.hit.curricelumdesign.service;

import com.hit.curricelumdesign.manager.student.StudentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentManager studentManager;

}
