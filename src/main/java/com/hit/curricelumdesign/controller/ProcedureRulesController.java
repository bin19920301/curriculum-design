package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.context.annotation.HitApi;
import com.hit.curricelumdesign.context.param.procedurerules.AddProcedureRulesParam;
import com.hit.curricelumdesign.context.param.procedurerules.DeleteProcedureRulesParam;
import com.hit.curricelumdesign.context.param.procedurerules.ListProcedureRulesByProjectIdParam;
import com.hit.curricelumdesign.context.param.procedurerules.UpdateProcedureRulesParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.service.ProcedureRulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcedureRulesController {

    @Autowired
    private ProcedureRulesService procedureRulesService;

    @RequestMapping(value = "/procedurerules/addrule/", method = RequestMethod.POST)
    //@HitApi(checkTeacherLogin = true)
    public Result addRule(AddProcedureRulesParam param) {
        return  procedureRulesService.addProcessRules(param);
    }

    @RequestMapping(value = "/procedurerules/updaterule/", method = RequestMethod.POST)
    //@HitApi(checkTeacherLogin = true)
    public Result updateRule(UpdateProcedureRulesParam param) {
        return procedureRulesService.updateProcessRules(param);
    }

    @RequestMapping(value = "/procedurerules/deleterule/", method = RequestMethod.POST)
    @HitApi(checkTeacherLogin = true)
    public Result deleteRule(DeleteProcedureRulesParam param) {
        return procedureRulesService.deleteProcessRules(param);
    }

    @RequestMapping(value = "/procedurerules/listrules/", method = RequestMethod.POST)
    @HitApi(checkTeacherLogin = true)
    public Result listFolder(ListProcedureRulesByProjectIdParam param) {
        return procedureRulesService.listProcessResults(param);
    }
}
