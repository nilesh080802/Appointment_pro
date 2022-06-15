package com.dollop.appointment.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dollop.appointment.dao.PaymentDAOimp;
import com.dollop.appointment.model.DoctorSettingData;
import com.dollop.appointment.model.PatientSettingData;
import com.dollop.appointment.model.PaymentSettingData;

public class PaymentService {

	PaymentDAOimp pdo =new PaymentDAOimp();
	public Boolean addPaymentData(PaymentSettingData pm){
		 return pdo.addPaymentData(pm);
	}

	public String checkAllDetailIsValid(PaymentSettingData pm) {
		
		if(pm.getFirstName()==""||pm.getLastName()==""||pm.getMobileNumber()==""|| pm.getEmail()==""|| pm.getCardName()==""|| pm.getCardNumber()==""||pm.getExpiryMonth()==""||pm.getCvv()==""||pm.getExpiryYear()==""||pm.getAmount()==null) {
			return "FeelAllDetailError" ;
		}
		else if(!checkMobileNumberIsValid(pm.getMobileNumber()))
		{
			return"MobileNumberError";
		}
		else if(!checkCardDetailIsValid(pm))
		{
			return "CardDetailError";
		}
		else {
		    return "DetaiIsValid";
		}
	}

	private boolean checkCardDetailIsValid(PaymentSettingData pm) {
		
		String str=pm.getCardNumber().replaceAll(" ", "");
		Long cardNumber=Long.valueOf(str);
		return validitychk(cardNumber);
	}

	private boolean checkMobileNumberIsValid(String mobileNumber) {
		// The given argument to compile() method
        // is regular expression. With the help of
        // regular expression we can validate mobile
        // number.
        // The number should be of 10 digits.
 
        // Creating a Pattern class object
        Pattern p = Pattern.compile("^\\d{10}$");
 
        // Pattern class contains matcher() method
        // to find matching between given number
        // and regular expression for which
        // object of Matcher class is created
        java.util.regex.Matcher m = p.matcher(mobileNumber);
 
        // Returning boolean value
        return (m.matches());
	}

	public String genrateReciptNumber() {
		
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
		 StringBuilder sb = new StringBuilder();
		Random rand = new Random(); 
		for(int i = 0; i <2; i++) 
		{
               int index = rand.nextInt(alphabet.length());
		      char randomChar = alphabet.charAt(index);
		      sb.append(randomChar);
		}
	    int random1 = rand.nextInt(999999);
	    int random2 =rand.nextInt(9999);
		return  random1+sb.toString()+random2;
   }
	
	public void getPaymentInfo(PaymentSettingData pm,HttpServletRequest request, HttpServletResponse response) throws ServletException {
	    
        ArrayList arr =new ArrayList();
        arr=pdo.getPaymentInfo(pm);
        for(Object ob:arr) {
     	   
     	   if(ob instanceof DoctorSettingData)
     	   {
     		   
     		   DoctorSettingData dst=(DoctorSettingData)ob;
     	       request.setAttribute("dst",dst);	
   
     	   }
     	   else if(ob instanceof PaymentSettingData){
     		   
     		   PaymentSettingData pmd=(PaymentSettingData)ob;
     		   pm.setPaymentId(pmd.getPaymentId());     		   
     		   request.setAttribute("pmd",pmd);		
     	   }
       	  
        }
   
       }		
	
	
	// Return true if the card number is valid
	   public static boolean validitychk(long cnumber) {
	      return (thesize(cnumber) >= 13 && thesize(cnumber) <= 16) && (prefixmatch(cnumber, 4)
	         || prefixmatch(cnumber, 5) || prefixmatch(cnumber, 37) || prefixmatch(cnumber, 6))
	         && ((sumdoubleeven(cnumber) + sumodd(cnumber)) % 10 == 0);
	   }
	   // Get the result from Step 2
	   public static int sumdoubleeven(long cnumber) {
	      int sum = 0;
	      String num = cnumber + "";
	      for (int i = thesize(cnumber) - 2; i >= 0; i -= 2)
	         sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);
	      return sum;
	   }
	  
	   public static int getDigit(int cnumber) {
	      if (cnumber < 9)
	         return cnumber;
	      return cnumber / 10 + cnumber % 10;
	   }
	   // Return sum of odd-place digits in cnumber
	   public static int sumodd(long cnumber) {
	      int sum = 0;
	      String num = cnumber + "";
	      for (int i = thesize(cnumber) - 1; i >= 0; i -= 2)
	         sum += Integer.parseInt(num.charAt(i) + "");
	      return sum;
	   }
	   // Return true if the digit d is a prefix for cnumber
	   public static boolean prefixmatch(long cnumber, int d) {
	      return getprefx(cnumber, thesize(d)) == d;
	   }
	   // Return the number of digits in d
	   public static int thesize(long d) {
	      String num = d + "";
	      return num.length();
	   }
	   // Return the first k number of digits from
	   // number. If the number of digits in number
	   // is less than k, return number.
	   public static long getprefx(long cnumber, int k) {
	      if (thesize(cnumber) > k) {
	         String num = cnumber + "";
	         return Long.parseLong(num.substring(0, k));
	      }
	      return cnumber;
	   }
	   
	   public PaymentSettingData fetchDataFromJsp(HttpServletRequest request) {
			
			PaymentSettingData pm =new PaymentSettingData();
			
			HttpSession session=request.getSession(false);
			Integer patientId=(Integer)session.getAttribute("patientId");
			String mobileNumber=request.getParameter("mobileNumber");
			String firstName=request.getParameter("firstName");
			String lastName=request.getParameter("lastName");
			String email=request.getParameter("email");
			Integer doctorId=Integer.parseInt( request.getParameter("doctorId"));
		    Double amount=Double.parseDouble(request.getParameter("amount"));
			String cardNumber=request.getParameter("cardNumber");
			String paymentType=request.getParameter("paymentType");
			String cardName=request.getParameter("cardName");
			String expiryMonth=request.getParameter("expiryMonth");
			String expiryYear=request.getParameter("expiryYear");
			String cvv=request.getParameter("cvv");
			String reciptNumber=genrateReciptNumber();
			 
		
		     cardNumber=cardNumber.trim();
			 paymentType=paymentType.trim();
			 cardName=cardName.trim();
			 expiryMonth=expiryMonth.trim();
			 expiryYear=expiryYear.trim();
			 cvv=cvv.trim();
			 mobileNumber=mobileNumber.trim();
			 firstName=firstName.trim();
			 lastName=lastName.trim();
			 email=email.trim();
			 
			 pm.setFirstName(firstName);
			 pm.setLastName(lastName);
			 pm.setEmail(email);
			 pm.setMobileNumber(mobileNumber);
			 pm.setDoctorId(doctorId);
			 pm.setPatientId(patientId);
			 pm.setAmount(amount);
			 pm.setReciptNumber(reciptNumber);
			 pm.setCardNumber(cardNumber);
			 pm.setPaymentType(paymentType);
			 pm.setCardName(cardName);
			 pm.setExpiryMonth(expiryMonth);
			 pm.setExpiryYear(expiryYear);
			 pm.setCvv(cvv);
			 return pm;
		}

	public void genrateInvoice(PaymentSettingData pm,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		Integer invoiceId=pdo.addInvoiceData(pm);		 
		PaymentSettingData psd=(PaymentSettingData)request.getAttribute("pmd");	
		psd.setInvoiceId(invoiceId);
		String OrderId = (invoiceId<10?"000"+invoiceId:invoiceId<100?"00"+invoiceId:invoiceId<1000?"0"+invoiceId:""+invoiceId);
	    pdo.addOrderId(OrderId,invoiceId);
	    if(action.equals("payment")) {
       	 
      	  RequestDispatcher rd3 =request.getRequestDispatcher("booking-success.jsp");
  		  rd3.forward(request, response);
        }
			    
	}

	public void getInvoiceData(PaymentSettingData pm, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	        ArrayList arr =new ArrayList();
	        arr=pdo.getInvoiceData(pm);
	        for(Object ob:arr) {
	     	   
	     	   if(ob instanceof DoctorSettingData)
	     	   {
	     		   
	     		   DoctorSettingData dst=(DoctorSettingData)ob;
	     	       request.setAttribute("dst",dst);	
	   
	     	   }
	     	   else if(ob instanceof PaymentSettingData){
	     		   
	     		   PaymentSettingData pmd=(PaymentSettingData)ob;
	     		   request.setAttribute("pmd",pmd);		
	     	   }
	     	  else if(ob instanceof PatientSettingData)
	     	   {
	     		  PatientSettingData psd=(PatientSettingData)ob;
	     		  request.setAttribute("psd", psd);
	     	   }
	        }	
	}
}
