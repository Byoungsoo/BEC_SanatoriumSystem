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
/**   HandlerMethodArgumentResolver�� Spring�� ��Ʈ�ѷ����� �ٷ� ��,   				         /
/**   ��Ʈ�ѷ��� ������ �Ķ���͸� �����ϰų� ���������� �߰��ؾ� �ϴ� ��쿡 ����Ѵ�.							 /
/************************************************************************************/
public class CustomMapArgumentResolver implements HandlerMethodArgumentResolver{
	
	
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		/************************************************************************************/
		/**   isAssignableFrom �Լ���  �������� Class�� Ȯ���� �� ����Ѵ�	    				         /
		/**   Parameter�� ���� ���� CommandMap Ŭ�������� Ȯ�� �ϴ� ����		    				         /
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
