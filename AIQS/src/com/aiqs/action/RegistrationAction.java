package com.aiqs.action;
	import javax.servlet.http.HttpServletRequest;

	import org.apache.struts2.interceptor.ServletRequestAware;
	import org.apache.struts2.interceptor.validation.SkipValidation;

	import com.opensymphony.xwork2.ActionSupport;
	import com.opensymphony.xwork2.Preparable;
	import com.aiqs.bean.UserBean;
	import com.aiqs.domain.SiteUser;

	public class RegistrationAction extends ActionSupport implements ServletRequestAware, Preparable{

		UserBean NewUser;
		HttpServletRequest request ;
		@Override
		public void setServletRequest(HttpServletRequest request) {
			// TODO Auto-generated method stub
			this.request=request;
		}
		@Override
		public void prepare() throws Exception {
			// TODO Auto-generated method stub
			NewUser = new UserBean();
		}
		@SkipValidation
		public String getInputForm(){
			return SUCCESS;
		}
		public String doRegister(){
			String Response = null;
			SiteUser AnyBody = new SiteUser();
			String DomainResponse = AnyBody.registerUser(NewUser);
			this.addActionMessage(DomainResponse);
			Response = SUCCESS;
			return Response;
		}
		
		/////////////////////////////////////////////
		
		public UserBean getNewUser() {
			return NewUser;
		}
		public void setNewUser(UserBean newUser) {
			NewUser = newUser;
		}
		

	}

