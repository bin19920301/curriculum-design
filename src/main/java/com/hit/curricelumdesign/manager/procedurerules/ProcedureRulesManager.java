package com.hit.curricelumdesign.manager.procedurerules;

import com.hit.curricelumdesign.dao.ProcedureRulesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcedureRulesManager {

    @Autowired
    private ProcedureRulesMapper procedureRulesMapper;



}
