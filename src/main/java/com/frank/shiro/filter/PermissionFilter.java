package com.frank.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Service;

@Service
public class PermissionFilter extends AccessControlFilter {
	
	//��¼ҳ��
	final String LOGIN_URL = "/login";
	//û��Ȩ������
	static String UNAUTHORIZED = "/unauthorized";
	
	@Override
	protected boolean isAccessAllowed(ServletRequest request,ServletResponse response, Object mappedValue) throws Exception {
		Subject subject = getSubject(request, response);
		HttpServletRequest httpRequest = ((HttpServletRequest)request);
		String uri = httpRequest.getRequestURI();//��ȡURI
		String basePath = httpRequest.getContextPath();//��ȡbasePath
		if(null != uri && uri.startsWith(basePath)){
			uri = uri.replace(basePath, "");
		}
		if (subject.isPermitted(uri)) {
			return true;
		}
		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request,ServletResponse response) throws Exception {
		Subject subject = getSubject(request, response);
		if (null==subject) {
			saveRequestAndRedirectToLogin(request, response);
		}else {
			WebUtils.issueRedirect(request, response,UNAUTHORIZED);
		}
		return false;
	}

}
