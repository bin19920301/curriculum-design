package com.hit.curricelumdesign.resolver;

import com.hit.curricelumdesign.context.annotation.DateObj;
import com.hit.curricelumdesign.context.annotation.JsonArr;
import com.hit.curricelumdesign.context.annotation.JsonAttribute;
import com.hit.curricelumdesign.context.annotation.JsonObj;
import com.hit.curricelumdesign.utils.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.ModelFactory;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: JSON属性字段解析器
 *
 * @author: tengguodong
 * @date: 2017/4/6
 */
@Component
public class JsonAttributeArgumentResolver implements HandlerMethodArgumentResolver {

	private static Log logger = LogFactory.getLog(JsonAttributeArgumentResolver.class);

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.hasParameterAnnotation(JsonAttribute.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		Class<?> parameterType = parameter.getParameterType();
		List<Class<?>> clazzs = BeanUtil.getSuperClasses(parameterType);
		if (CollectionUtils.isNotEmpty(clazzs)) {
			HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
			Map<String, String[]> map = new HashMap<>(request.getParameterMap());
			for (Class<?> aClass : clazzs) {
				Field[] fields = aClass.getDeclaredFields();
				for (Field field : fields) {
					String paramName = null;
					if (field.isAnnotationPresent(JsonObj.class)) {
						JsonObj jsonObj = field.getAnnotation(JsonObj.class);
						paramName = jsonObj.paramName();
						if (StringUtil.isBlank(paramName)) {
							paramName = field.getName();
						}
					} else if (field.isAnnotationPresent(JsonArr.class)) {
						JsonArr jsonArr = field.getAnnotation(JsonArr.class);
						paramName = jsonArr.paramName();
						if (StringUtil.isBlank(paramName)) {
							paramName = field.getName();
						}
					} else if (field.isAnnotationPresent(DateObj.class)) {
						paramName = field.getName();
					}
					if (paramName != null) {
						map.remove(paramName);
					}
				}
			}

			String name = ModelFactory.getNameForParameter(parameter);
			Object attribute = (mavContainer.containsAttribute(name) ? mavContainer.getModel().get(name)
					: createAttribute(name, parameter, binderFactory, webRequest));

			WebDataBinder binder = binderFactory.createBinder(webRequest, attribute, name);
			if (binder.getTarget() != null) {
				bindRequestParameters(binder, map);
				validateIfApplicable(binder, parameter);
				if (binder.getBindingResult().hasErrors() && isBindExceptionRequired(binder, parameter)) {
					throw new BindException(binder.getBindingResult());
				}
			}

			// Add resolved attribute and BindingResult at the end of the model
			Map<String, Object> bindingResultModel = binder.getBindingResult().getModel();
			mavContainer.removeAttributes(bindingResultModel);
			mavContainer.addAllAttributes(bindingResultModel);

			Object object = binder.convertIfNecessary(binder.getTarget(), parameter.getParameterType(), parameter);

			for (Class<?> aClass : clazzs) {
				Field[] fields = aClass.getDeclaredFields();
				for (Field field : fields) {
					field.setAccessible(true);

					// JSON对象
					JsonObj jsonObj = field.getAnnotation(JsonObj.class);
					if (jsonObj != null) {
						String parameterName = jsonObj.paramName();
						if (StringUtil.isBlank(parameterName)) {
							parameterName = field.getName();
						}
						String value = request.getParameter(parameterName);
						logger.info(LogUtils.getCommLog(String.format("解析参数%s:%s", parameterName, value)));
						Class<?> elementType = jsonObj.type();
						field.set(object, GsonUtils.getInstace().fromJson(value, elementType));
					}

					// JSON数组
					JsonArr jsonArr = field.getAnnotation(JsonArr.class);
					if (jsonArr != null) {
						String parameterName = jsonArr.paramName();
						if (StringUtil.isBlank(parameterName)) {
							parameterName = field.getName();
						}
						String value = request.getParameter(parameterName);
						logger.info(LogUtils.getCommLog(String.format("解析参数%s:%s", parameterName, value)));
						Class<?> elementType = jsonArr.type();
						field.set(object, RequestUtils.resolveParameter(value, parameterName, false, elementType));
					}

					// 日期对象
					DateObj dateObj = field.getAnnotation(DateObj.class);
					if (dateObj != null) {
						String parameterName = field.getName();
						String value = request.getParameter(parameterName);
						logger.info(LogUtils.getCommLog(String.format("解析参数%s:%s", parameterName, value)));
						if (value != null) {
							field.set(object, DateUtil.parseDate(value));
						}
					}
				}
			}

			return object;
		} else {
			logger.error(LogUtils.getCommLog(String.format("不支持的参数类型：%s", parameterType.getCanonicalName())));
			return null;
		}
	}

	protected Object createAttribute(String attributeName, MethodParameter methodParam,
                                     WebDataBinderFactory binderFactory, NativeWebRequest request) throws Exception {

		return BeanUtils.instantiateClass(methodParam.getParameterType());
	}

	protected void bindRequestParameters(WebDataBinder binder, Map<String, String[]> map) {
		PropertyValues propertyValues = new MutablePropertyValues(map);
		binder.bind(propertyValues);
	}

	protected void validateIfApplicable(WebDataBinder binder, MethodParameter methodParam) {
		Annotation[] annotations = methodParam.getParameterAnnotations();
		for (Annotation ann : annotations) {
			Validated validatedAnn = AnnotationUtils.getAnnotation(ann, Validated.class);
			if (validatedAnn != null || ann.annotationType().getSimpleName().startsWith("Valid")) {
				Object hints = (validatedAnn != null ? validatedAnn.value() : AnnotationUtils.getValue(ann));
				Object[] validationHints = (hints instanceof Object[] ? (Object[]) hints : new Object[] { hints });
				binder.validate(validationHints);
				break;
			}
		}
	}

	protected boolean isBindExceptionRequired(WebDataBinder binder, MethodParameter methodParam) {
		int i = methodParam.getParameterIndex();
		Class<?>[] paramTypes = methodParam.getMethod().getParameterTypes();
		boolean hasBindingResult = (paramTypes.length > (i + 1) && Errors.class.isAssignableFrom(paramTypes[i + 1]));
		return !hasBindingResult;
	}
}
