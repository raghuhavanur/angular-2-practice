package com.aiqs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.aiqs.bean.Credential;
import com.aiqs.bean.PaymentBean;
import com.aiqs.bean.QuoteBean;
import com.aiqs.bean.UserBean;
import com.aiqs.domain.DefaultUser;
import com.aiqs.domain.AiqsUser;
import com.aiqs.domain.SiteUser;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class UserAction extends ActionSupport implements ServletRequestAware, Preparable{
	QuoteBean biq=new QuoteBean();
	Credential userCredential=new Credential();
	PaymentBean payment=new PaymentBean();

	public PaymentBean getPayment() {
		return payment;
	}

	public void setPayment(PaymentBean payment) {
		this.payment = payment;
	}

	HttpServletRequest request;
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	
	
	


public Credential getUserCredential() {
	return userCredential;
}

public void setUserCredential(Credential userCredential) {
	this.userCredential = userCredential;
}

public QuoteBean getBiq() {
	return biq;
}

public void setBiq(QuoteBean biq) {
	this.biq = biq;
}

public String doBuyInsQuote(){
	HttpSession UserSession = null;
	UserSession = request.getSession(false);
	String Response=null;
	AiqsUser regUser = (AiqsUser)UserSession.getAttribute("USER");
	if(regUser != null){
	String DomainResponse = regUser.createInsQuote(UserSession,biq);
	this.addActionMessage(DomainResponse);
	Response=SUCCESS;
	}
	else{
		Response="error";
	}
	return Response;
}

public String doProceed(){
	HttpSession UserSession = null;
	UserSession = request.getSession(false);
	String Response=null;
	AiqsUser regUser = (AiqsUser)UserSession.getAttribute("USER");
	if(regUser != null){
	String DomainResponse = regUser.createPaymentQuote(UserSession,biq);
	this.addActionMessage(DomainResponse);
	Response=SUCCESS;
	}
	else{
		Response="error";
	}
	return Response;
}

public String setQuoteAttributes(){
	HttpSession UserSession = null;
	UserSession = request.getSession(false);
	String Response=null;
	AiqsUser regUser = (AiqsUser)UserSession.getAttribute("USER");
	if(regUser != null){
		String DomainResponse = regUser.createQuote(UserSession,biq);
		this.addActionMessage(DomainResponse);
		Response=SUCCESS;
	}else{
		Response="error";
	}
	return Response;
}

public String doPayment(){
	String Response=null;
	AiqsUser regUser = new AiqsUser();
	String DomainResponse = regUser.createPayment(payment);
	this.addActionMessage(DomainResponse);
	Response=SUCCESS;
	return Response;
}

public String doPay(){
	HttpSession UserSession = null;
	UserSession = request.getSession(false);
	String Response=null;
	AiqsUser regUser = (AiqsUser)UserSession.getAttribute("USER");
	if(regUser != null){
	String DomainResponse = regUser.doPay(UserSession,biq);
	this.addActionMessage(DomainResponse);
	Response=SUCCESS;
	}
	else{
		Response="error";
	}
	return Response;
}

public String getQuote(){
	String Response = null;
	AiqsUser regUser = new AiqsUser();
	biq = regUser.getQuote(request.getParameter("qid"));
	request.setAttribute("Quote", biq);
	Response=SUCCESS;
	return Response;
}

}
