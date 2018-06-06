package bys.common.resolver;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import bys.common.common.CommandMap;


/************************************************************************************/
/**   HandlerMethodArgumentResolver는 Spring의 컨트롤러들을 다룰 때,   				         /
/**   컨트롤러에 들어오는 파라미터를 수정하거나 공통적으로 추가해야 하는 경우에 사용한다.							 /
/************************************************************************************/
public class CustomMapArgumentResolver implements HandlerMethodArgumentResolver{
	
	
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		/************************************************************************************/
		/**   isAssignableFrom 함수는  동적으로 Class를 확인할 때 사용한다	    				         /
		/**   Parameter로 들어온 값이 CommandMap 클래스인지 확인 하는 절차		    				         /
		/************************************************************************************/
		return CommandMap.class.isAssignableFrom(parameter.getParameterType());
	}
	

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		CommandMap commandMap = new CommandMap();
		
		HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
		Enumeration<?> enumeration = request.getParameterNames();
		
		String key = null;
		String[] values = null;
		while(enumeration.hasMoreElements()){
			key = (String) enumeration.nextElement();
			values = request.getParameterValues(key);
			if(values != null){
				commandMap.put(key, (values.length > 1) ? values:values[0] );
			}
		}
		return commandMap;
	}

}
