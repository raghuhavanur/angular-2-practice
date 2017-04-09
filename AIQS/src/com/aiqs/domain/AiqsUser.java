package com.aiqs.domain;

import java.util.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.aiqs.bean.Credential;
import com.aiqs.bean.DriverBean;
import com.aiqs.bean.PaymentBean;
import com.aiqs.bean.QuoteBean;
import com.aiqs.dao.DriverDao;
import com.aiqs.dao.QuoteDao;
import com.aiqs.util.DataSource;
import com.aiqs.util.Generator;

public class AiqsUser extends DefaultUser{
	public static String qid;
	Credential UserCredential;

	public Credential getUserCredential() {
		return UserCredential;
	}

	public void setUserCredential(Credential userCredential) {
		UserCredential = userCredential;
	}
	
	public String addDriver(DriverBean driver){
		String Ack =null;
		if(driver != null){
			DriverDao ddao = new DriverDao(DataSource.getNewConnection());
			driver.setDriverId(Generator.genDriverid());
			String DaoAck = ddao.create(driver);
			if(DaoAck != null){
				if(DaoAck.equalsIgnoreCase("saved")){
					Ack = "DRIVER ADDED SUCCESSFULLY, DRIVERID : "+ driver.getDriverId();
				}
			}else{
				Ack ="THERE IS AN ERROR !";
			}
			
		}
		return Ack;
	}
	
	public String deleteDriver(String driverid){
		String Ack =null;
		if(driverid != null){
			DriverDao ddao = new DriverDao(DataSource.getNewConnection());
			String DaoAck = ddao.remove(driverid);
			if(DaoAck != null){
				if(DaoAck.equalsIgnoreCase("deleted")){
					Ack = "DRIVER DELETED SUCCESSFULLY, DRIVERID : "+ driverid;
				}
			}else{
				Ack ="THERE IS AN ERROR !";
			}
			
		}
		return Ack;
	}
	public ArrayList<DriverBean> findAll(){
			DriverDao ddao = new DriverDao(DataSource.getNewConnection());
			ArrayList<DriverBean> dList = ddao.findAll(UserCredential.getUserId());
		return dList;
	}
	
	public DriverBean getTheDriverDetails(String driverId){
		DriverDao ddao = new DriverDao(DataSource.getNewConnection());
		DriverBean driver=ddao.findByid(driverId);
		System.out.println(driver);
		return driver;
	}
	
	public String modifyDriver(DriverBean driver){
		
		String Ack =null;
		if(driver != null){
			DriverDao ddao = new DriverDao(DataSource.getNewConnection());
			String DaoAck = ddao.edit(driver);
			if(DaoAck != null){
				if(DaoAck.equalsIgnoreCase("updated")){
					Ack = "DRIVER UPDATED SUCCESSFULLY, DRIVERID : "+ driver.getDriverId();
				}
			}else{
				Ack ="THERE IS AN ERROR !";
			}
			
		}
		return Ack;
	}
	
	
/*-----------------------------Quote Manager----------------------------------------*/
	
	
	
	public String createQuote(HttpSession UserSession,QuoteBean biq) {
		String userid=SiteUser.uid;
		biq.setUserId(userid);
		String Ack =null;
			if(biq != null){
				//QuoteDao qdao = new QuoteDao(DataSource.getNewConnection());
				
				biq.setQuoteId(Generator.genQuoteId());
				qid=biq.getQuoteId();
				
				System.out.println(qid);
				UserSession.setAttribute("quoteid",qid);
				UserSession.setAttribute("Userid",userid);
				UserSession.setAttribute("PolicyType",biq.getPolicyType());
				Date pst=biq.getPolicyStartDate();
				UserSession.setAttribute("PolStartDate",pst);
				UserSession.setAttribute("VehicleMake",biq.getVehicleMake());
				UserSession.setAttribute("VehicleModel",biq.getVehicleModel());
				UserSession.setAttribute("Yom",biq.getManufactureYear());
				Date regDate=biq.getRegistrationDate();
				UserSession.setAttribute("RegDate",regDate);
				UserSession.setAttribute("RegState",biq.getRegistrationState());
				UserSession.setAttribute("RegCity",biq.getRegistrationCity());
				UserSession.setAttribute("FuelType",biq.getFuelType());
				UserSession.setAttribute("ShowRoomPrice",biq.getShowroomPrice());
				Date dobOwner=biq.getDobOfOwner();
				UserSession.setAttribute("DobOwer",dobOwner);
				UserSession.setAttribute("Profession",biq.getProfessionOfOwner());
				String s=(String)UserSession.getAttribute("Profession");
						Ack = "success";
				
			}
			
			return Ack;
		}

	public String createInsQuote(HttpSession UserSession,QuoteBean biq) {
		String Ack =null;
			if(biq != null){
				UserSession.setAttribute("InsProvider",biq.getInsuranceProvider());
				UserSession.setAttribute("PrmAmt",biq.getPremiumAmount());
				String s=(String)UserSession.getAttribute("InsProvider");
				System.out.println(s);
						Ack = "success";			
			}
			
			return Ack;
	}

	public String createPaymentQuote(HttpSession UserSession,QuoteBean biq) {
		String Ack =null;
		if(biq != null){
			String s=(String)UserSession.getAttribute("EngineNumber");
			QuoteDao qdao = new QuoteDao(DataSource.getNewConnection());
			String usr=(String)UserSession.getAttribute("Userid");
			biq.setUserId(usr);
			String qid=(String)UserSession.getAttribute("quoteid");
			biq.setQuoteId(qid);
			String ptype=(String)UserSession.getAttribute("PolicyType");
			biq.setPolicyType(ptype);
			Date psd=(Date)UserSession.getAttribute("PolStartDate");
			biq.setPolicyStartDate(psd);
			String vmk=(String)UserSession.getAttribute("VehicleMake");
			biq.setVehicleMake(vmk);
			String vmd=(String)UserSession.getAttribute("VehicleModel");
			biq.setVehicleModel(vmd);
			int yom=(Integer)UserSession.getAttribute("Yom");
			biq.setManufactureYear(yom);
			Date regd=(Date)UserSession.getAttribute("RegDate");
			biq.setRegistrationDate(regd);
			String regs=(String)UserSession.getAttribute("RegState");
			biq.setRegistrationState(regs);
			String regc=(String)UserSession.getAttribute("RegCity");
			biq.setRegistrationCity(regc);
			String ft=(String)UserSession.getAttribute("FuelType");
			biq.setFuelType(ft);
			int srp=(Integer)UserSession.getAttribute("ShowRoomPrice");
			biq.setShowroomPrice(srp);
			Date dobo=(Date)UserSession.getAttribute("DobOwer");
			biq.setDobOfOwner(dobo);
			String pf=(String)UserSession.getAttribute("Profession");
			biq.setProfessionOfOwner(pf);
			String isp=(String)UserSession.getAttribute("InsProvider");
			biq.setInsuranceProvider(isp);
			int pm=(Integer)UserSession.getAttribute("PrmAmt");
			biq.setPremiumAmount(pm);
			String en=(String)UserSession.getAttribute("EngineNumber");
			biq.setEngineNumber(en);
			String chn=(String)UserSession.getAttribute("ChassisNumber");
			biq.setChassisNumber(chn);
			String pann=(String)UserSession.getAttribute("PANNumber");
			biq.setPanNumber(pann);
			String maddr=(String)UserSession.getAttribute("MailingAddress");
			biq.setMailingAddress(maddr);
			String paym=(String)UserSession.getAttribute("PaymentMode");
			biq.setPaymentMode(paym);
			UserSession.setAttribute("QUOTE",biq);
						
			String DaoAck = qdao.createQuote(biq);
			if(DaoAck != null){
				if(DaoAck.equalsIgnoreCase("saved")){
					Ack = "Successfully Purchased, YOUR QUOTEID :"+biq.getQuoteId();
				}
			}else{
				Ack ="Error !";
			}
			System.out.println(s);
			}
		
		return Ack;		
	}

	public String createPayment(PaymentBean payment) {
		String Ack =null;
		
		if(payment != null){
			QuoteDao qdao = new QuoteDao(DataSource.getNewConnection());
			String DaoAck = qdao.createPayment(payment);
			if(DaoAck != null){
				if(DaoAck.equalsIgnoreCase("saved")){
					Ack = "success";
				}
			}else{
				Ack ="THERE IS AN ERROR !";
			}
			
		}
		
		return Ack;
		}

	public String doPay(HttpSession UserSession, QuoteBean biq) {
		String Ack =null;
		if(biq != null){
			UserSession.setAttribute("EngineNumber",biq.getEngineNumber());
			UserSession.setAttribute("ChassisNumber",biq.getChassisNumber());
			UserSession.setAttribute("PANNumber",biq.getPanNumber());
			UserSession.setAttribute("MailingAddress",biq.getMailingAddress());
			UserSession.setAttribute("PaymentMode",biq.getPaymentMode());
					Ack = "success";
					}
		
		return Ack;
	}
	
	//////////////View Quote///////////////////
	
	public QuoteBean getQuote(String parameter) {
		QuoteDao ddao = new QuoteDao(DataSource.getNewConnection());
		QuoteBean DaoAck = ddao.findById(parameter);
		return DaoAck;	
	
}
}
