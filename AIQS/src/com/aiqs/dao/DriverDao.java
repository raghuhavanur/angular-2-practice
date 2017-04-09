package com.aiqs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.aiqs.bean.DriverBean;




public class DriverDao {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement pstmt;
	
	public DriverDao(Connection con){
		this.con=con;
		this.rs=null;
		this.pstmt=null;
	}
	
	public String create(DriverBean driver){
		String Ack = null;
		final String Insert_Query ="INSERT INTO driverdetails values(?,?,?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = con.prepareStatement(Insert_Query);
			pstmt.setString(1, driver.getUserId());
			pstmt.setString(2, driver.getQuoteId());
			pstmt.setString(3, driver.getFirstName());
			pstmt.setString(4, driver.getLastName());
			pstmt.setInt(5, driver.getAge());
			pstmt.setString(6, driver.getGender());
			pstmt.setLong(7, Long.parseLong(driver.getPhoneNo()));
			pstmt.setString(8, driver.getAddress());
			pstmt.setString(9, driver.getEmailId());
			pstmt.setString(10, driver.getDriverId());
			
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
	
	public String edit(DriverBean driver){
		String Ack = null;
        final String Modify_Query ="UPDATE driverdetails SET first_name=?, last_name=?, age=?, gender=?,phone_no=?, address=?,emailid=? WHERE driverid=? and quoteid=?";
		
		try {
			pstmt = con.prepareStatement(Modify_Query);
			pstmt.setString(1, driver.getFirstName());
			pstmt.setString(2, driver.getLastName());
			pstmt.setInt(3, driver.getAge());
			pstmt.setString(4, driver.getGender());
			pstmt.setLong(5, Long.parseLong(driver.getPhoneNo()) );
			pstmt.setString(6, driver.getAddress());
			pstmt.setString(7, driver.getEmailId());
			pstmt.setString(8, driver.getDriverId());
			pstmt.setString(9, driver.getQuoteId());
			
			int RowAffect = pstmt.executeUpdate();
			
			
			if(RowAffect != 0){
				System.out.println("Row updated");
				Ack="updated";
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
	
	public String remove(String driverId){
		String Ack = null;
		final String Delete_Query ="DELETE FROM driverdetails WHERE driverid=?";
		try {
			pstmt = con.prepareStatement(Delete_Query);
			pstmt.setString(1, driverId);
			int RowAffect = pstmt.executeUpdate();
			if(RowAffect != 0){
				Ack="deleted";
			}
		}catch (SQLException e) {
			
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
	
	
	public ArrayList<DriverBean> findAll(String userid){
		ArrayList<DriverBean> driverList=new ArrayList<DriverBean>();
		
		final String findAll_Query ="SELECT * FROM driverdetails WHERE userid=?";
		try {
			pstmt = con.prepareStatement(findAll_Query);
			pstmt.setString(1,userid);
			rs=pstmt.executeQuery();
			while(rs.next()){
				DriverBean driver=new DriverBean();
				driver.setUserId(rs.getString(1));
				driver.setQuoteId(rs.getString(2));
				driver.setFirstName(rs.getNString(3));
				driver.setLastName(rs.getString(4));
				driver.setAge(rs.getInt(5));
				driver.setGender(rs.getString(6));
				driver.setPhoneNo(new Long(rs.getLong(7)).toString());
				driver.setAddress(rs.getString(8));
				driver.setEmailId(rs.getString(9));
				driver.setDriverId(rs.getString(10));
				driverList.add(driver);
				
				
			}
		}catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return driverList;
	}
	public DriverBean findByid(String DriverId){
		DriverBean driver = null;
		final String Select_Query ="SELECT * FROM driverdetails WHERE driverid=?";
		try {
			pstmt=con.prepareStatement(Select_Query);
			pstmt.setString(1, DriverId);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				driver=new DriverBean();
				driver.setUserId(rs.getString(1));
				driver.setQuoteId(rs.getString(2));
				driver.setFirstName(rs.getNString(3));
				driver.setLastName(rs.getString(4));
				driver.setAge(rs.getInt(5));
				driver.setGender(rs.getString(6));
				driver.setAddress(rs.getString(8));
				driver.setEmailId(rs.getString(9));
				driver.setDriverId(rs.getString(10));
				driver.setPhoneNo(new Long(rs.getInt(7)).toString());
				
				
				
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
		return driver;
	}
}
