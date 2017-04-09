package com.aiqs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.aiqs.bean.Credential;
//import com.aiqs.domain.Admin;
//import com.aiqs.domain.AIQSUser;
import com.aiqs.domain.SiteUser;

public class SignInAction extends ActionSupport implements ServletRequestAware, Preparable{

	HttpServletRequest request;
	private Credential UserCredential;
	private String UrlToRedirect;
	
	///////////////////////////////////////
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		UserCredential = new Credential();
	}
	
	////////////////////////////////////////
	
	public String getInputForm(){
		return SUCCESS;
	}
	
	public String doSignin(){
		String Response = null;
		HttpSession UserSession = null;
		UserSession = request.getSession();
		SiteUser AnyBody = new SiteUser();
		String DomainResponse = AnyBody.checkCredential(UserCredential);
		if(DomainResponse.equals("valid")){
			UrlToRedirect =AnyBody.createNewUserSession(UserSession, UserCredential);
			Response = SUCCESS;
		}else{
			this.addActionMessage(DomainResponse);
			Response = ERROR;
		}
		return Response;
	}
	
	
	////////////////////////////////////////////////
	
	public Credential getUserCredential() {
		return UserCredential;
	}
	public void setUserCredential(Credential userCredential) {
		UserCredential = userCredential;
	}
	public String getUrlToRedirect() {
		return UrlToRedirect;
	}
	public void setUrlToRedirect(String urlToRedirect) {
		UrlToRedirect = urlToRedirect;
	}
	

}

