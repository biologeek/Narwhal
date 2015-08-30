package fr.biologeek.narwhal.presentation.jsf.beans;

import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class SessionUtils {
	
	private static HttpServletRequest request;
	private static FacesContext ctx;
	private static ExternalContext ectx;
	private static Map<String, Object> session;
	
	public static FacesContext getFacesContext (){
		return ctx = FacesContext.getCurrentInstance();
	}
	
	public static ExternalContext getExternalContext() {
		return ectx = SessionUtils.getFacesContext().getExternalContext();
	}

	private static HttpServletRequest getRequest() {
		return request = (HttpServletRequest) getFacesContext().getExternalContext().getRequest();
	}
	public static Map<String, Object> getHttpSession (){
		return session = SessionUtils.getExternalContext().getSessionMap();
	}

}
