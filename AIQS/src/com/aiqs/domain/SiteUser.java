package com.aiqs.domain;

import javax.servlet.http.HttpSession;

import com.aiqs.bean.Credential;
import com.aiqs.bean.UserBean;
import com.aiqs.dao.UserDao;
import com.aiqs.util.DataSource;
import com.aiqs.util.Generator;

public class SiteUser {
	
	public static String uid;
	public String checkCredential(Credential credential){
		String Ack =null;
		if(credential != null){
			UserDao udao = new UserDao(DataSource.getNewConnection());
			UserBean TheUser = udao.findByid(credential.getUserId());
			uid=credential.getUserId();
			if(TheUser != null){
				if(TheUser.getPassword().equals(credential.getPassword())){
					if(TheUser.getType().equals(credential.getType()) ){
						credential.setName(TheUser.getFirstName()+" "+TheUser.getLastName());
						Ack ="valid";
					}else{
						Ack="SELECT CORRECT TYPE";
					}
				}else{
					Ack="ENTER CORRECT PASSWORD";
				}
			}else{
				Ack = "ENTER VALID USERID";
			}
		}
		
		return Ack;
	}
	
	public String createNewUserSession( HttpSession UserSession, Credential UserCredential){
		
		final String UserHomeUrl ="user_home.jsp"; 
		final String AdminHomeUrl ="admin_home.jsp";
		String AckUrl = null;
		if(UserCredential != null){
			
			if(UserCredential.getType().equals("User")){
				DefaultUser customer = new AiqsUser();
				customer.setUserCredential(UserCredential);
				UserSession.setAttribute("USER", customer);
				AckUrl=UserHomeUrl;
			}else{
				DefaultUser admin = new AiqsAdmin();
				admin.setUserCredential(UserCredential);
				UserSession.setAttribute("USER", admin);
				AckUrl=AdminHomeUrl;
			}
			
		}
		return AckUrl;
		
	}
	
	public String registerUser(UserBean user){
		String Ack =null;
		if(user != null){
			UserDao udao = new UserDao(DataSource.getNewConnection());
			user.setType("User");
			user.setUserId(Generator.genUserid(user.getType()));
			String DaoAck = udao.create(user);
			if(DaoAck != null){
				if(DaoAck.equalsIgnoreCase("saved")){
					Ack = "REGISTRATION SUCCESSFULL, YOUR USERID : "+user.getUserId();
				}
			}else{
				Ack ="THERE IS AN ERROR !";
			}
			
		}
		
		return Ack;
	}

}
