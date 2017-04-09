package com.aiqs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aiqs.bean.UserBean;

public class UserDao {
	
	private Connection con;
	private ResultSet rs;
	private PreparedStatement pstmt;
	
	public UserDao(Connection con){
		this.con=con;
		this.rs=null;
		this.pstmt=null;
	}
	
	public String create(UserBean user){
		String Ack = null;
		final String Insert_Query ="INSERT INTO userdetails VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(Insert_Query);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getFirstName());
			pstmt.setString(4, user.getLastName());
			pstmt.setInt(5, user.getAge());
			pstmt.setString(6, user.getGender());
			pstmt.setString(7, user.getAddress());
			pstmt.setLong(8, user.getPhoneNo());
			pstmt.setInt(9, 0);
			pstmt.setString(10, user.getEmailId());
			pstmt.setString(11, user.getType());
			int RowAffect = pstmt.executeUpdate();
			
			if(RowAffect != 0){
				Ack="saved";
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return Ack;
	}
	public String edit(UserBean user){
		String Ack = null;
		final String Update_Query ="UPDATE userdetails SET "+
									"password=?, first_name=?, last_name=?, age=?, gender=?, "+
									"address=?, phone_no=?, login_status=?, emailid=?, type=? "+
									"WHERE userid=?";
		
		try {
			pstmt = con.prepareStatement(Update_Query);
			
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getFirstName());
			pstmt.setString(3, user.getLastName());
			pstmt.setLong(4, user.getAge());
			pstmt.setString(5, user.getGender());
			pstmt.setString(6, user.getAddress());
			pstmt.setLong(7, user.getPhoneNo());
			pstmt.setInt(8, 0);
			pstmt.setString(9, user.getEmailId());
			pstmt.setString(10,user.getType());
			pstmt.setString(11, user.getUserId());
			
			int RowAffect = pstmt.executeUpdate();
			
			if(RowAffect != 0){
				Ack="updated";
				System.out.println("update done");
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return Ack;
		
	}
	
	public String remove(String Userid){
		String Ack = null;
		return Ack;
	}
	public UserBean findByid(String Userid){
		UserBean AckObj = null;
		final String Select_Query ="SELECT * FROM userdetails WHERE userid=?";
		try {
			pstmt=con.prepareStatement(Select_Query);
			pstmt.setString(1, Userid);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				AckObj = new UserBean();
				AckObj.setUserId(rs.getString(1));
				AckObj.setPassword(rs.getString(2));
				AckObj.setFirstName(rs.getString(3));
				AckObj.setLastName(rs.getString(4));
				AckObj.setAge(rs.getInt(5));
				AckObj.setGender(rs.getString(6));
				AckObj.setAddress(rs.getString(7));
				AckObj.setPhoneNo(rs.getLong(8));
				AckObj.setLoginStatus(rs.getInt(9));
				AckObj.setEmailId(rs.getString(10));
				AckObj.setType(rs.getString(11));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		return AckObj;
	}
	
	public  ArrayList<UserBean> findAll(){
		ArrayList<UserBean> AckList = null;
		UserBean TheUser = null;
		final String Select_Query ="SELECT * FROM userdetails ";
		try {
			con.prepareStatement(Select_Query);
			rs = pstmt.executeQuery();
			AckList = new ArrayList<UserBean>();
			while(rs.next()){
				TheUser = new UserBean();
				TheUser.setUserId(rs.getString(1));
				TheUser.setPassword(rs.getString(2));
				TheUser.setType(rs.getString(3));
				TheUser.setFirstName(rs.getString(4));
				TheUser.setLastName(rs.getString(5));
				TheUser.setAddress(rs.getString(7));
				TheUser.setEmailId(rs.getString(8));
				TheUser.setPhoneNo(rs.getLong(9));
				
				AckList.add(TheUser);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		return AckList;
	}

}

