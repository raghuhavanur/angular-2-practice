package com.aiqs.action;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.aiqs.bean.DriverBean;
import com.aiqs.domain.AiqsUser;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;


public class DriverAction extends ActionSupport implements ServletRequestAware, Preparable{
	
	DriverBean DriverDetails;
	private ArrayList<DriverBean> driverList=null;
	private AiqsUser ValidUser;
	HttpServletRequest request ;
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		ValidUser = (AiqsUser)(request.getSession(false)).getAttribute("USER");
		driverList = ValidUser.findAll();
		DriverDetails = new DriverBean();
	}
	
	@SkipValidation
	public String getDriverList(){
		String Response = null;
		request.setAttribute("DRIVER", driverList);
		Response=SUCCESS;
		return Response;
	}
	
	@SkipValidation
	public String getDriverInputForm(){
		return SUCCESS;
	}
	
	public String addNewDriver(){
		String DomainResponse = ValidUser.addDriver(DriverDetails);
		this.addActionMessage(DomainResponse);
		return SUCCESS;
	}
	
	@SkipValidation
	public String getTheDriverDetails(){
		String Response = null;
		DriverDetails = ValidUser.getTheDriverDetails(request.getParameter("driver_id"));
		request.setAttribute("MODE","EDIT" );
		Response=SUCCESS;
		return Response;
	}
	@SkipValidation
	public String updateDriver(){
		String DomainResponse = ValidUser.modifyDriver(DriverDetails);
		this.addActionMessage(DomainResponse);
		return SUCCESS;
	}
	@SkipValidation
	public String deleteDriver(){
		String DomainResponse = ValidUser.deleteDriver(request.getParameter("driver_id"));
		this.addActionMessage(DomainResponse);
		String Response=getDriverList();
		return Response;
		
	}
//////////////////////////////////////////////////////////////////
	
	public DriverBean getDriverDetails() {
		return DriverDetails;
	}

	public void setDriverDetails(DriverBean driverDetails) {
		DriverDetails = driverDetails;
	}

	public AiqsUser getValidUser() {
		return ValidUser;
	}

	public void setValidUser(AiqsUser validUser) {
		ValidUser = validUser;
	}

	public void setDriverList(ArrayList<DriverBean> driverList) {
		this.driverList = driverList;
	}
	
	

}
