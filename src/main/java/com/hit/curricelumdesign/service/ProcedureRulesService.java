package com.hit.curricelumdesign.service;

import com.hit.curricelumdesign.dao.ProcedureRulesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProcedureRulesService {

    @Autowired
    private ProcedureRulesMapper procedureRulesMapper;
}
