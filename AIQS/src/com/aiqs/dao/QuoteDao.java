package com.aiqs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.aiqs.bean.PaymentBean;
import com.aiqs.bean.QuoteBean;
import com.aiqs.bean.UserBean;
import com.aiqs.domain.AiqsUser;
import com.aiqs.domain.SiteUser;
public class QuoteDao {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement pstmt;
	public String qid=AiqsUser.qid;
	public String uid=SiteUser.uid;
	public QuoteDao(Connection con){
		this.con=con;
		this.rs=null;
		this.pstmt=null;
	}
	
	public String createQuote(QuoteBean biq){
		String Ack = null;
		
		final String Insert_Query ="INSERT INTO quotedetails(userid,quoteid,policy_type,policy_start_date,vehicle_make,vehicle_model,manufacture_year,registration_date,registration_state,registration_city,fuel_type,showroom_price,dob_of_owner,profession_of_owner,insurance_provider,premium_amount,engine_number,chassis_no,pan_number,mailing_address,payment_mode) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(Insert_Query);
			pstmt.setString(1, biq.getUserId());
			pstmt.setString(2, biq.getQuoteId());
			pstmt.setString(3, biq.getPolicyType());
			pstmt.setDate(4, new java.sql.Date(biq.getPolicyStartDate().getTime()));
			pstmt.setString(5, biq.getVehicleMake());
			pstmt.setString(6, biq.getVehicleModel());
			pstmt.setInt(7, biq.getManufactureYear());
			pstmt.setDate(8, new java.sql.Date(biq.getRegistrationDate().getTime()));
			pstmt.setString(9, biq.getRegistrationState());
			pstmt.setString(10, biq.getRegistrationCity());
			pstmt.setString(11, biq.getFuelType());
			pstmt.setInt(12, biq.getShowroomPrice());
			pstmt.setDate(13, new java.sql.Date(biq.getDobOfOwner().getTime()));
			pstmt.setString(14, biq.getProfessionOfOwner());
			pstmt.setString(15, biq.getInsuranceProvider());
			pstmt.setInt(16, biq.getPremiumAmount());
			pstmt.setString(17, biq.getEngineNumber());
			pstmt.setString(18, biq.getChassisNumber());
			pstmt.setString(19, biq.getPanNumber());
			pstmt.setString(20, biq.getMailingAddress());
			pstmt.setString(21,biq.getPaymentMode());
			
			int RowAffect = pstmt.executeUpdate();
			con.commit();
			if(RowAffect != 0){
				Ack="saved";
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return Ack;
	}

	public String createInsQuote(QuoteBean biq) {
		String Ack = null;
		
		return Ack;
	}

	public String createPayment(PaymentBean payment) {
		String Ack = null;
		payment.setUserId(uid);
		final String Insert_Query ="select card_type,card_no from payment where card_type=? and card_no=? and userid=?";
		
		try {
			pstmt = con.prepareStatement(Insert_Query);
			pstmt.setString(1, payment.getCardType());
			System.out.println(payment.getCardType());
			pstmt.setLong(2, payment.getCardNumber());
			System.out.println(payment.getCardNumber());
			pstmt.setString(3, payment.getUserId());
			int RowAffect = pstmt.executeUpdate();
			if(RowAffect != 0){
				Ack="saved";
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return Ack;
	}
	
public QuoteBean findById(String parameter) {
		
		QuoteBean biq=null;
		final String Insert_Query ="select userid,quoteid,policy_type,policy_start_date,vehicle_make,vehicle_model,manufacture_year,registration_date,registration_state,registration_city,fuel_type,showroom_price,dob_of_owner,profession_of_owner,insurance_provider,premium_amount,engine_number,chassis_no,pan_number,mailing_address,payment_mode from quotedetails where quoteid=?";
		
		try {
			pstmt = con.prepareStatement(Insert_Query);
			pstmt.setString(1,parameter);
			System.out.println(parameter);
			rs=pstmt.executeQuery();
			while(rs.next()){
				biq=new QuoteBean();
				biq.setUserId(rs.getString(1));
				biq.setQuoteId(rs.getString(2));
				biq.setPolicyType(rs.getString(3));
				biq.setPolicyStartDate(rs.getDate(4));
				biq.setVehicleMake(rs.getString(5));
				biq.setVehicleModel(rs.getString(6));
				biq.setManufactureYear(rs.getInt(7));
				biq.setRegistrationDate(rs.getDate(8));
				biq.setRegistrationCity(rs.getString(9));
				biq.setRegistrationState(rs.getString(10));
				biq.setFuelType(rs.getString(11));
				biq.setShowroomPrice(rs.getInt(12));
				biq.setDobOfOwner(rs.getDate(13));
				biq.setProfessionOfOwner(rs.getString(14));
				biq.setInsuranceProvider(rs.getString(15));
				biq.setPremiumAmount(rs.getInt(16));
				biq.setEngineNumber(rs.getString(17));
				biq.setChassisNumber(rs.getString(18));
				biq.setPanNumber(rs.getString(19));
				biq.setMailingAddress(rs.getString(20));
				biq.setPaymentMode(rs.getString(21));
							}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return biq;
	}

}
