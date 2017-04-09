package com.aiqs.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Generator {
	
	public static String genUserid(String type){
		String NewUserid = null;
		long Numeric = genNumber();
		if(type.equals("User")){
			NewUserid = "u"+Numeric;
		}else{
			NewUserid = "a"+Numeric;
		}
		
		return NewUserid;
	}
	
	private static long genNumber(){
		long Number = 0;
		final String Select_Query= "SELECT aiqs_user.NEXTVAL FROM DUAL"; 
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		Connection con = DataSource.getNewConnection();
		try {
			pstmt = con.prepareStatement(Select_Query);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Number = rs.getLong(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return Number;
		
	}

	
	public static String genDriverid(){
		String NewDriverid = null;
		long Numeric = genDriverNumber();
			NewDriverid = "d"+Numeric;
		
		return NewDriverid;
	}
	
	private static long genDriverNumber(){
		long Number = 0;
		final String Select_Query= "SELECT aiqs_driver.NEXTVAL FROM DUAL"; 
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		Connection con = DataSource.getNewConnection();
		try {
			pstmt = con.prepareStatement(Select_Query);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Number = rs.getLong(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return Number;
		
	}
	
	public static String genQuoteId(){
		String NewQuoteId = null;
		long Numeric = genQuoteNumber();
		NewQuoteId = "q"+Numeric;
		
		return NewQuoteId;
	}
	private static long genQuoteNumber(){
		long Number = 0;
		final String Select_Query= "SELECT aiqs_quote.NEXTVAL FROM DUAL"; 
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		Connection con = DataSource.getNewConnection();
		try {
			pstmt = con.prepareStatement(Select_Query);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Number = rs.getLong(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return Number;
		}

}

