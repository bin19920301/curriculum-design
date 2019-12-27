package com.hit.curricelumdesign.aop;

import com.hit.curricelumdesign.context.annotation.HitApi;
import com.hit.curricelumdesign.context.constant.Constants;
import com.hit.curricelumdesign.context.entity.Token;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.context.param.BaseRequestParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.TokenMapper;
import com.hit.curricelumdesign.utils.LogUtils;
import com.hit.curricelumdesign.utils.RequestUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * Description: 校验登录AOP
 * ClassName: CheckLoginAop
 * date: 2018年11月11日
 *
 * @author xbr
 * @since JDK 1.8
 */
@Aspect
@Order(2)
@Component
public class CheckLoginAop {

    private static final Logger logger = LoggerFactory.getLogger(CheckLoginAop.class);

    @Autowired
    private TokenMapper tokenMapper;


    @Pointcut("execution(public * com.hit.curricelumdesign..controller..*.*(..))")
    public void checkLogin() {

    }

    @Around("checkLogin()")
    public Result processHandler(ProceedingJoinPoint pjp) {
        logger.info(LogUtils.getCommLog("[登录校验]登录校验开始"));

        //返回结果
        Result result = null;

        try {
            Signature sig = pjp.getSignature();

            MethodSignature msig = null;
            if (!(sig instanceof MethodSignature)) {
                throw new IllegalArgumentException("[登录校验]该注解只能用于方法");
            }
            msig = (MethodSignature) sig;
            Object target = pjp.getTarget();
            Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
            HitApi hitApi = currentMethod.getAnnotation(HitApi.class);
            boolean checkAdminLogin = false;
            boolean checkTeacherLogin = false;
            boolean checkStudentLogin = false;
            if (hitApi != null) {
                checkAdminLogin = hitApi.checkAdminLogin();
                checkTeacherLogin = hitApi.checkTeacherLogin();
                checkStudentLogin = hitApi.checkStudentLogin();
            }

            // 校验登录
            if (checkAdminLogin) {
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                        .getRequest();
                String token = RequestUtils.getHeaderString(request, "adminToken");
                Token tokenObj = tokenMapper.getByTokenAndType(token, Constants.Token.TYPE_ADMIN);

                if (tokenObj == null) {
                    logger.error(LogUtils.getCommLog(String.format("[登录校验]未登录或登录已超时 token：%s", token)));
                    throw new BaseException(Error._200201);
                }

                //初始化登录用户ID
                request.setAttribute("adminId", tokenObj.getUserId());
                Object[] args = pjp.getArgs();
                for (Object arg : args) {
                    if (arg instanceof BaseRequestParam) {
                        ((BaseRequestParam) arg).setAdminId(tokenObj.getUserId());
                    }
                }
            } else if (checkTeacherLogin) {
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                        .getRequest();
                String token = RequestUtils.getHeaderString(request, "teacherToken");
                Token tokenObj = tokenMapper.getByTokenAndType(token, Constants.Token.TYPE_TEACHER);

                if (tokenObj == null) {
                    logger.error(LogUtils.getCommLog(String.format("[登录校验]未登录或登录已超时 token：%s", token)));
                    throw new BaseException(Error._200201);
                }

                //初始化登录用户ID
                request.setAttribute("teacherId", tokenObj.getUserId());
                Object[] args = pjp.getArgs();
                for (Object arg : args) {
                    if (arg instanceof BaseRequestParam) {
                        ((BaseRequestParam) arg).setTeacherId(tokenObj.getUserId());
                    }
                }
            } else if (checkStudentLogin) {
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                        .getRequest();
                String token = RequestUtils.getHeaderString(request, "studentToken");
                Token tokenObj = tokenMapper.getByTokenAndType(token, Constants.Token.TYPE_STUDENT);

                if (tokenObj == null) {
                    logger.error(LogUtils.getCommLog(String.format("[登录校验]未登录或登录已超时 token：%s", token)));
                    throw new BaseException(Error._200201);
                }

                //初始化登录用户ID
                request.setAttribute("studentId", tokenObj.getUserId());
                Object[] args = pjp.getArgs();
                for (Object arg : args) {
                    if (arg instanceof BaseRequestParam) {
                        ((BaseRequestParam) arg).setStudentId(tokenObj.getUserId());
                    }
                }
            }
            logger.info(LogUtils.getCommLog("[登录校验]登录校验结束"));
            result = (Result) pjp.proceed();
        } catch (Exception e) {
            // 判断是否为BaseException异常及其子异常
            if (BaseException.class.isAssignableFrom(e.getClass())) {
                BaseException baseException = (BaseException) e;
                result = Result.failure(baseException.getErrorcode(), baseException.getDescription());
                logger.error(LogUtils.getCommLog(baseException.toString()), e);

            } else {
                result = Result.failure(Error._100002);
                logger.error(LogUtils.getCommLog(e.toString()), e);
            }
        } catch (Throwable e) {
            result = Result.failure(Error._100002);
            logger.error(LogUtils.getCommLog(e.toString()), e);
        }
        return result;

    }
}
