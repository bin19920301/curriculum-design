package com.hit.curricelumdesign.service;

import com.github.pagehelper.PageHelper;
import com.hit.curricelumdesign.context.dto.finishedsurface.FinishedSurfaceDTO;
import com.hit.curricelumdesign.context.dto.procedurerules.ProcedureRulesDTO;
import com.hit.curricelumdesign.context.entity.ProcedureRules;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.context.param.procedurerules.AddProcedureRulesParam;
import com.hit.curricelumdesign.context.param.procedurerules.DeleteProcedureRulesParam;
import com.hit.curricelumdesign.context.param.procedurerules.ListProcedureRulesByProjectIdParam;
import com.hit.curricelumdesign.context.param.procedurerules.UpdateProcedureRulesParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.FinishedSurfaceMapper;
import com.hit.curricelumdesign.dao.ProcedureRulesMapper;
import com.hit.curricelumdesign.utils.BeanUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProcedureRulesService {

    @Autowired
    private ProcedureRulesMapper procedureRulesMapper;

    @Autowired
    private FinishedSurfaceMapper finishedSurfaceMapper;

    public Result addProcessRules(AddProcedureRulesParam param) {

        //20200329 增加规则校验
        Boolean result = this.validationRules(param.getRulesDetails(), param.getRulesType());
        if (!result){
            throw new BaseException(Error.VALIDATION_RULES_ERROR);
        }

        List<Integer> surfaceIdList = new ArrayList<>();
        if (1 == param.getRulesType()) {
            surfaceIdList = getOrderSurfaceIdList(param.getRulesDetails());

        } else if (2 == param.getRulesType()) {
            surfaceIdList = getMethodSurfaceIdList(param.getRulesDetails());
        }
        verifySurface(param.getWorkProjectId(), surfaceIdList);



        ProcedureRules procedureRules = new ProcedureRules();
        BeanUtil.copyProperties(param,procedureRules);
        //设置属性
        procedureRules.setCreatetime(new Date());
        procedureRules.setCreatorId(param.getLoginTeacherId());
        procedureRules.setIsDelete(false);
        procedureRules.setUpdatetime(new Date());
        procedureRules.setUpdaterId(param.getLoginTeacherId());
        //保存属性
        procedureRulesMapper.insert(procedureRules);
        return Result.success();
    }

    /**
     * 获取加工方式表面id列表
     *
     * @param rulesDetails
     * @return
     */
    private List<Integer> getMethodSurfaceIdList(String rulesDetails) {
        List<Integer> surfaceIdList = new ArrayList<>();
        String[] split = rulesDetails.split(";");
        for (String ruleString : split) {
            String[] ruleSplit = ruleString.split("-");
            surfaceIdList.add(Integer.parseInt(ruleSplit[0]));
        }
        return surfaceIdList;
    }

    /**
     * 获取排序表面id列表
     *
     * @param rulesDetails
     * @return
     */
    private List<Integer> getOrderSurfaceIdList(String rulesDetails) {
        List<Integer> surfaceIdList = new ArrayList<>();
        String[] split = rulesDetails.split(",");
        for (String s : split) {
            surfaceIdList.add(Integer.parseInt(s));
        }
        return surfaceIdList;
    }

    public Result updateProcessRules(UpdateProcedureRulesParam param) {


        //20200329 增加规则校验
        Boolean result = this.validationRules(param.getRulesDetails(), param.getRulesType());
        if (!result){
            throw new BaseException(Error.VALIDATION_RULES_ERROR);
        }

        List<Integer> surfaceIdList = new ArrayList<>();
        if (1 == param.getRulesType()) {
            surfaceIdList = getOrderSurfaceIdList(param.getRulesDetails());

        } else if (2 == param.getRulesType()) {
            surfaceIdList = getMethodSurfaceIdList(param.getRulesDetails());
        }
        verifySurface(param.getWorkProjectId(), surfaceIdList);


        ProcedureRules procedureRules = new ProcedureRules();
        BeanUtil.copyProperties(param,procedureRules);
        // 设置属性
        procedureRules.setUpdatetime(new Date());
        procedureRules.setUpdaterId(param.getLoginTeacherId());
        // 更新属性
        procedureRulesMapper.updateByPrimaryKeySelective(procedureRules);
        return Result.success();
    }

    public Result deleteProcessRules(DeleteProcedureRulesParam param){
        ProcedureRules procedureRules = procedureRulesMapper.selectByPrimaryKey(param.getId());
        // 设置属性
        procedureRules.setIsDelete(true);
        procedureRules.setUpdatetime(new Date());
        procedureRules.setUpdaterId(param.getLoginTeacherId());
        // 保存属性
        procedureRulesMapper.updateByPrimaryKeySelective(procedureRules);
        return Result.success();
    }

    public Result listProcessResults(ListProcedureRulesByProjectIdParam param){
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        List<ProcedureRulesDTO> procedureRules = procedureRulesMapper.findByProjectId(param.getProjectId());
        return  Result.success(procedureRules);
    }

    private void verifySurface(Integer workProjectId, List<Integer> surfaceIdList) {

        List<FinishedSurfaceDTO> finishedSurfaceDTOS = finishedSurfaceMapper.selectByWorkProjectId(workProjectId);
        if (CollectionUtils.isNotEmpty(finishedSurfaceDTOS)) {
            List<Integer> existSurfaceIdList = finishedSurfaceDTOS.stream().map(FinishedSurfaceDTO::getSurfaceId).collect(Collectors.toList());
            for (Integer surfaceId : surfaceIdList) {
                if (!existSurfaceIdList.contains(surfaceId)) {
                    throw new BaseException(Error.RULE_CONTAINS_NON_EXISTENT_SURFACE_ERROR);
                }
            }
        }else{
            throw new BaseException(Error.RULE_CONTAINS_NON_EXISTENT_SURFACE_ERROR);
        }
    }

    private Boolean validationRules(String rulesDetails,Integer rulesType){
        switch (rulesType){
            case 1:
                return this.validationRulesTypeOne(rulesDetails);
            case 2:
                return this.validationRulesTypeTwo(rulesDetails);
            default:
                return false;
        }
    }

    private Boolean validationRulesTypeOne(String rulesDetails){
        //判断非空
        if (StringUtils.isBlank(rulesDetails)){
            return false;
        }
        String pattern = "([，,0-9]*)";
        //先判断是否包含除了数字和两种逗号以外的字符
        if (rulesDetails.matches(pattern)){
            String[] split = rulesDetails.split(",");
            //排除;;;;;;情况
            if(split == null ){
                return false;
            }
            //排除类似a,,,,b情况
            //原始规则的长度
            int len = rulesDetails.length();//获取原来的字符串长度
            //获取去掉;的字符串长度
            String s1 = rulesDetails.replace(",", "");
            int len2 = s1.length();
            //差值代表出现,的次数,分割后,数组的长度要和这个差值大1
            int differenceValue = len - len2;
            System.out.println("len:"+len);
            System.out.println("len2"+len2);
            if (differenceValue != split.length-1 && differenceValue != 0){
                return false;
            }
            return true;
           /* for (String s : split) {
                if (!StringUtils.isBlank(s)){
                    return true;
                }else{
                    //通过判断两个逗号之间是否非空,即判断出现1,2,,3,,,4这种形式
                    return false;
                }
            }*/
        }
        //包含其他字符返回false
        return false;
    }
    private Boolean validationRulesTypeTwo(String rulesDetails){
        //判断非空
        if (StringUtils.isBlank(rulesDetails)){
            return false;
        }
        String patternFirstStep = "([0-9a-z\\-;]*)";
        //先判断是否包含除了数字和两种逗号以外的字符
        if (rulesDetails.matches(patternFirstStep)){

            String[] split = rulesDetails.split(";");
            //排除;;;;;;情况
            if(split == null ){
                return false;
            }
            //排除类似1-a;;;;情况
            //原始规则的长度
            int len = rulesDetails.length();//获取原来的字符串长度
            //获取去掉;的字符串长度
            String s1 = rulesDetails.replace(";", "");
            int len2 = s1.length();
            //差值代表出现;的次数,分割后,数组的长度要和这个差值大1;如果1-a情况,没有;,通过差值!=0判断
            int differenceValue = len - len2;
            if (differenceValue != split.length-1 && differenceValue != 0){
                return false;
            }
            System.out.println("获取到的长度是:"+split.length);
            for (String s : split) {
                if (!StringUtils.isBlank(s)){
                    //这里获取到的理想格式是1-a形式
                    String patternSecondStep = "([0-9a-z\\-]*)";
                    if (s.matches(patternSecondStep)){
                        //这里按照"-"分隔后,应该为2,且0的位置为数字,1的位置为小写字母
                        String[] split1 = s.split("-");
                        if(split1 != null && split1.length == 2){
                            //判断第一个位置
                            String patternThirdStep = "([0-9]*)";
                            //第一个位置是否是纯数字或者长度大于三
                            if (!split1[0].matches(patternThirdStep) || split1[0].length()> 3 ){
                                return false;
                            }
                            //判断第二个位置,因为字母只能出现一次,所以不用判断长度,即aa和ab等情况不符合规则
                            String patternFourthStep = "([a-z])";
                            if (!split1[1].matches(patternFourthStep)){
                                return false;
                            }
                            return true;
                        }
                    }
                    return false;
                }else{
                    //通过判断两个分号之间是否非空,即判断出现1-a;;;2-b这种形式
                    return false;
                }
            }
        }
        //包含其他字符返回false
        return false;
    }

    public static void main(String[] args) {
        //Pattern pattern = Pattern.compile("[^0-9,]+");
      /*  String pattern = "([，,0-9]*)";
        String aim = "1,22,,2,3,4";*/

      /*  String patternOneStep = "([0-9a-z\\-]*)";
        String aim = "111a-a1";*/
/*        String patternOneStep ="([0-9]*)";
        String aim = "111";*/
        String patternOneStep ="([a-z])";
        String aim = "abc";
        System.out.println(aim.matches(patternOneStep));
    }
}
