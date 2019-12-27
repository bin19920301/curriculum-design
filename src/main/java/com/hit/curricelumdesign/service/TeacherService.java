package com.hit.curricelumdesign.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hit.curricelumdesign.context.constant.Constants;
import com.hit.curricelumdesign.context.dto.BaseListDTO;
import com.hit.curricelumdesign.context.dto.admin.TeacherLoginDTO;
import com.hit.curricelumdesign.context.dto.teacher.TeacherDTO;
import com.hit.curricelumdesign.context.entity.Teacher;
import com.hit.curricelumdesign.context.entity.Token;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.context.param.BaseListRequestParam;
import com.hit.curricelumdesign.context.param.BaseRequestParam;
import com.hit.curricelumdesign.context.param.teacher.*;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.TeacherMapper;
import com.hit.curricelumdesign.dao.TokenMapper;
import com.hit.curricelumdesign.manager.teacher.TeacherManager;
import com.hit.curricelumdesign.utils.BeanUtil;
import com.hit.curricelumdesign.utils.MsgUtils;
import com.hit.curricelumdesign.utils.TokenUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TeacherService {

    @Autowired
    private TeacherManager teacherManager;
    @Autowired
    private TeacherMapper teacherMapper;

    @Value("${hit.curricelumdesign.teacher.password.default}")
    private String teacherPasswordDefault;

    @Value("${hit.curricelumdesign.password.md5.pre}")
    private String md5Pre;

    @Autowired
    private TokenMapper tokenMapper;


    /**
     * 教师信息详情展示
     *
     * @param teacherParam
     * @return
     */
    public Result getTeacherById(GetTeacherParam teacherParam) {
        TeacherDTO teacher = teacherManager.getTeacherById(teacherParam.getId());
        return Result.success(teacher);
    }

    /**
     * 增加教师信息
     *
     * @param teacherParam
     * @return
     */
    public Result addTeacher(AddTeacherParam teacherParam) {
        //判断教师编号是否存在
        Teacher teacherByNumber = teacherMapper.getTeacherByNumber(teacherParam.getNumber());
        if (null != teacherByNumber) {
            throw new BaseException(Error.TEACHER_NUMBER_IS_EXIST);
        }
        Teacher teacher = new Teacher();
        BeanUtil.copyProperties(teacherParam, teacher);
        teacher.setIsDelete(false);
        teacher.setCreatorId(teacherParam.getLoginAdminId());
        teacher.setCreatetime(new Date());
        teacher.setUpdaterId(0);
        teacher.setPassword(DigestUtils.md5Hex(md5Pre + teacherPasswordDefault));
        teacherMapper.insert(teacher);
        return Result.success();
    }

    /**
     * 更新教师信息
     *
     * @param teacherParam
     * @return
     */
    public Result updateTeacher(UpdateTeacherParam teacherParam) {
        Teacher teacher = new Teacher();
        BeanUtil.copyProperties(teacherParam, teacher, "password");
        teacher.setUpdatetime(new Date());
        teacher.setUpdaterId(teacherParam.getLoginAdminId());
        teacher.setPassword(DigestUtils.md5Hex(md5Pre + teacherParam.getPassword()));
        teacherMapper.updateByPrimaryKeySelective(teacher);
        return Result.success();
    }

    /**
     * 删除教师信息
     *
     * @param teacherParam
     * @return
     */
    public Result deleteTeacher(DeleteTeacherParam teacherParam) {
        Teacher teacher = new Teacher();
        BeanUtil.copyProperties(teacherParam, teacher);
        teacher.setIsDelete(Boolean.TRUE);
        teacher.setUpdatetime(new Date());
        teacher.setUpdaterId(teacherParam.getLoginAdminId());
        teacherMapper.updateByPrimaryKeySelective(teacher);
        return Result.success();
    }

    /**
     * 重置教师密码
     *
     * @param teacherParam
     * @return
     */
    public Result resetTeacherPassword(ResetPasswordParam teacherParam) {
        TeacherDTO dto = teacherMapper.selectById(teacherParam.getId());
        Teacher teacher = new Teacher();
        BeanUtil.copyProperties(dto, teacher);
        teacher.setPassword(DigestUtils.md5Hex(md5Pre + teacherPasswordDefault));
        //更新操作者的id
        teacher.setUpdaterId(teacherParam.getLoginAdminId());
        teacher.setUpdatetime(new Date());
        teacherMapper.updateByPrimaryKeySelective(teacher);
        return Result.success();
    }

    /**
     * 分页查询教师信息
     *
     * @param param
     * @return
     */
    public Result getTeacherList(BaseListRequestParam param) {
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        List<TeacherDTO> teacherList = teacherManager.getTeacherList();
        PageInfo<TeacherDTO> pageInfo = new PageInfo<>(teacherList);

        BaseListDTO<TeacherDTO> teacherBaseListDTO = new BaseListDTO<>(pageInfo.getTotal(), teacherList);
        return Result.success(teacherBaseListDTO);
    }

    /**
     * 教师登录
     *
     * @param param
     * @return
     */
    public Result teacherLogin(TeacherLoginParam param) {
        Teacher teacher = teacherMapper.getTeacherByNumber(param.getNumber());
        if (null == teacher) {
            throw new BaseException(Error._200202);
        }
        String password = param.getPassword();
        String md5Password = DigestUtils.md5Hex(md5Pre + password);
        if (!StringUtils.equals(md5Password, teacher.getPassword())) {
            throw new BaseException(Error._200203);
        }
        String tokenStr = TokenUtils.getToken(teacher.getId(), teacher.getName(), teacher.getNumber(), MsgUtils.generateUUIDStr());
        Token token = new Token();
        token.setToken(tokenStr);
        token.setType(Constants.Token.TYPE_TEACHER);
        token.setUserId(teacher.getId());
        token.setIsDelete(Constants.Common.IS_NOT);
        Date now = new Date();
        token.setCreatetime(now);
        token.setUpdatetime(now);
        tokenMapper.insert(token);
        TeacherLoginDTO teacherLoginDTO = new TeacherLoginDTO();
        teacherLoginDTO.setToken(tokenStr);
        teacherLoginDTO.setTeacherId(teacher.getId());
        teacherLoginDTO.setTeacherName(teacher.getName());
        return Result.success(teacherLoginDTO);
    }

    /**
     * 教师登出
     *
     * @param param
     * @return
     */
    public Result teacherLogout(BaseRequestParam param) {
        String teacherToken = param.getTeacherToken();
        if (StringUtils.isBlank(teacherToken)) {
            throw new BaseException(Error._200201);
        }
        Token token = tokenMapper.getByTokenAndType(teacherToken, Constants.Token.TYPE_TEACHER);
        if (null != token) {
            token.setIsDelete(Constants.Common.IS_YES);
            token.setUpdatetime(new Date());
            tokenMapper.updateByPrimaryKey(token);
        }

        return Result.success();
    }
}
