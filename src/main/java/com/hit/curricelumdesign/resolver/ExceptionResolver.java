package com.hit.curricelumdesign.resolver;

import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.utils.LogUtils;
import com.hit.curricelumdesign.utils.RequestUtils;
import com.hit.curricelumdesign.utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description: 异常处理器
 * ClassName: ExceptionResolver.java
 * date: 2018年12月3日
 *
 * @author xbr
 * @version
 * @since JDK 1.8
 */
@Component
public class ExceptionResolver implements HandlerExceptionResolver {
	private static final Logger logger = LoggerFactory.getLogger(ExceptionResolver.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception e) {
		response.setContentType("text/html;charset=UTF-8");

		Result result = null;

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

		ResponseUtils.writer(response, ResponseUtils.getResponseContent(request, result));

		ModelAndView mv = new ModelAndView();
		return mv;
	}

}
