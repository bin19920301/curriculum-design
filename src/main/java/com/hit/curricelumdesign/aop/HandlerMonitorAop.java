package com.hit.curricelumdesign.aop;

import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.utils.LogUtils;
import com.hit.curricelumdesign.utils.RequestUtils;
import com.hit.curricelumdesign.utils.ResponseUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Description: 监控器
 * ClassName: HandlerMonitorAop
 * date: 2018年11月11日
 *
 * @author xbr
 * @since JDK 1.8
 */
@Aspect
@Order(1)
@Component
public class HandlerMonitorAop {

    private static final Logger logger = LoggerFactory.getLogger(HandlerMonitorAop.class);

    @Pointcut("execution(public * com.hit.curricelumdesign..controller..*.*(..))")
    public void handlerMonitor() {

    }

    @Around("handlerMonitor()")
    public Result processHandler(ProceedingJoinPoint pjp) {
        //开始时间
        long startTime = System.currentTimeMillis();

        //返回结果
        Result result = null;
        HttpServletRequest request = null;

        try {
            request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            if (request == null) {
                throw new Exception("该方法没有HttpServletRequest参数.");
            }

            //打印请求参数
            logger.info(LogUtils.getRequestLog(request));

            result = (Result) pjp.proceed();
        } catch (Exception e) {
            // 判断是否为BaseException异常及其子异常
            if (BaseException.class.isAssignableFrom(e.getClass())) {
                BaseException baseException = (BaseException) e;
                result = Result.failure(baseException.getErrorcode(), baseException.getDescription());
                logger.error(LogUtils.getCommLog(String.format("[%s:%s]业务异常:%s", request.getRequestURL().toString(),
                        RequestUtils.getRequest4String(request), baseException.toString())), e);
            } else {
                result = Result.failure(Error._100002);
                logger.error(LogUtils.getCommLog(String.format("[%s:%s]未知错误类型:%s", request.getRequestURL().toString(),
                        RequestUtils.getRequest4String(request), e.toString())), e);
            }
        } catch (Throwable e) {
            result = Result.failure(Error._100002);
            logger.error(LogUtils.getCommLog(String.format("[%s:%s]未知错误类型:%s", request.getRequestURL().toString(),
                    RequestUtils.getRequest4String(request), e.toString())), e);
        }

        //请求耗时
        long costTime = System.currentTimeMillis() - startTime;

        logger.info(LogUtils.getResponseLog(costTime, ResponseUtils.getResponseContent(request, result),
                request.getRequestURL().toString()));

        return result;
    }
}
