package com.aiqs.domain;

import com.aiqs.bean.Credential;
import com.aiqs.bean.UserBean;

import com.aiqs.dao.UserDao;
import com.aiqs.util.DataSource;

public abstract class DefaultUser {
	private Credential userCredential;

	public Credential getUserCredential() {
		return userCredential;
	}

	public void setUserCredential(Credential userCredential) {
		this.userCredential = userCredential;
	}
	
	public String changePassword(String newPassword){
		String AckMsg = null;
		if(newPassword != null){
			UserDao udao = new UserDao(DataSource.getNewConnection());
			UserBean TheUser = udao.findByid(getUserCredential().getUserId());
			TheUser.setPassword(newPassword);
			String Daores =udao.edit(TheUser);
			if(Daores != null){
				AckMsg ="Password Updated Successfully";
			}else{
				AckMsg ="Unabel update Password, There is an error";
			}
		}
		return AckMsg;
	}
}
