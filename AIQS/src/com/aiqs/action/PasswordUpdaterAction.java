package com.aiqs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.aiqs.domain.DefaultUser;
import com.aiqs.domain.AiqsUser;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class PasswordUpdaterAction extends ActionSupport implements ServletRequestAware, Preparable{
	
	private String NewPassword;
	private String OldPassword;
	private String ConfirmPassword;
	HttpServletRequest request;
	
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
		
	}
	
	@SkipValidation
	public String getInputForm(){
		return SUCCESS;
	}
	
	public String changePassword(){
		String Response = ERROR;
		String AckMsg = null;
		HttpSession UserSession = request.getSession(false);
		DefaultUser user = (DefaultUser)UserSession.getAttribute("USER");
		if(user != null){
			AckMsg  = user.changePassword(NewPassword);  
			Response=SUCCESS;
		}else{
			AckMsg ="ERROR HAPPENS";
		}
		this.addActionMessage(AckMsg);
		return Response;
		
	}
	
	//////////////////////////////////////////////////////////
	
	public String getNewPassword() {
		return NewPassword;
	}
	public void setNewPassword(String newPassword) {
		NewPassword = newPassword;
	}
	public String getConfirmPassword() {
		return ConfirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		ConfirmPassword = confirmPassword;
	}
	public String getOldPassword() {
		return OldPassword;
	}
	public void setOldPassword(String oldPassword) {
		OldPassword = oldPassword;
	}
	

}
