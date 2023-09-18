package jkfitness.utility;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DataUtility {
	

	  public static final String APP_DATE_FORMAT = "dd/MM/yyyy";
	   
	  private static final SimpleDateFormat formatter = new SimpleDateFormat(APP_DATE_FORMAT);

	  public static String getDateString(Date date) {
	    
	    try {
	       if(date!=null) {
	        return formatter.format(date);
	      }
	      else{
	        return "";
	      }
	    } catch (Exception e) {
	      return "";
	    }
	    
	  }
	  public static ReturnResults ValidateMembershipNamePattern(String wName ) {
			ReturnResults returnResults = new ReturnResults();
			returnResults.setFunctionResult(true);
		    String name = "^[0-9]{1,}-[A-Za-z ]{1,}$";
		    if (!wName.matches(name)) {
		    	returnResults.setFunctionResult(false); 
	   		    returnResults.getErrorMsgs().add("Membership Name should match the pattern x-y  whrere x is number, y words");
		      }
		      return returnResults;
		  }
		public static ReturnResults ValidateNamePattern(String wName ) {
			ReturnResults returnResults = new ReturnResults();
			returnResults.setFunctionResult(true);
		    String name = "[A-Za-z]{1,}$";
		    if (!wName.matches(name)) {
		    	returnResults.setFunctionResult(false); 
	   		    returnResults.getErrorMsgs().add("Name should be at least 1 Letter without Spaces, Numbers, or Special Characters");
		      }
		      return returnResults;
		  }
		  
		  
		  public static ReturnResults ValidatePhoneNoPattern(String wPhoneNo) {
		    ReturnResults returnResults = new ReturnResults();
			returnResults.setFunctionResult(true);
		    String regex = "[0-9]{10}$";
		    if (!wPhoneNo.matches(regex)) {
		    	returnResults.setFunctionResult(false); 
	   		    returnResults.getErrorMsgs().add("Phone number should contain exactly 10 numbers");
		      }
		      return returnResults;
		  }
		  
		  public static ReturnResults ValidatePostCodePattern(String wPostCode) {
			    ReturnResults returnResults = new ReturnResults();
				returnResults.setFunctionResult(true);
			    String regex = "[0-9]{5}$";
			    if (!wPostCode.matches(regex)) {
			    	returnResults.setFunctionResult(false); 
		   		    returnResults.getErrorMsgs().add("Post Code should contain exactly 5 numbers");
			      }
			      return returnResults;
			  }

		  public static ReturnResults isNotNull(String val) {
			ReturnResults returnResults = new ReturnResults();
			returnResults.setFunctionResult(true);
		    if ((val == null || val.trim().length() == 0 )) {
		    	returnResults.setFunctionResult(false); 
	   		    returnResults.getErrorMsgs().add("Value Is Null");
		      }
		      return returnResults;
		  }

		 

		  public static ReturnResults ValidateInteger(String val) {
			ReturnResults returnResults = new ReturnResults();
			returnResults.setFunctionResult(true);  
		    if (isNotNull(val).getFunctionResult()) {
		      try {
		        int i = Integer.parseInt(val);
		      } catch (NumberFormatException e) {
		    	  returnResults.setFunctionResult(false); 
		   		  returnResults.getErrorMsgs().add("Val is not Integer");
		      }
		    } else {
		    	returnResults.setFunctionResult(false); 
		   		returnResults.getErrorMsgs().add("Val is Null");
		    }
		    return returnResults;
		  }

		  public static ReturnResults ValidateDouble(String val) {
		    ReturnResults returnResults = new ReturnResults();
			returnResults.setFunctionResult(true); 
		    if (isNotNull(val).getFunctionResult()) {
		      try {
		    	  Double i = Double.parseDouble(val);
		      } catch (NumberFormatException e) {
		    	  returnResults.setFunctionResult(false); 
		   		  returnResults.getErrorMsgs().add("Val is not Double");
		      }
		    } else 
		    {
		    	returnResults.setFunctionResult(false); 
		   		returnResults.getErrorMsgs().add("Val is Null");
		    }
		    return returnResults;
		  }

		  public static ReturnResults ValidateEmailPattern(String wEmail) {
			    ReturnResults returnResults = new ReturnResults();
				returnResults.setFunctionResult(true);
			    String regex = "[A-Za-z0-9]{1,}@[A-Za-z0-9]{1,}\\.[A-Za-z]{1,}$";
			    if (!wEmail.matches(regex)) {
			    	returnResults.setFunctionResult(false); 
		   		    returnResults.getErrorMsgs().add("Email should be at least 5 characters matching the pattern x@y.y where x includes numbers or letters and y includes letters");
			      }
			      return returnResults;
			  }
		  public static ReturnResults CheckBillAmount(double wGivenAmount, double wBillAmmount) {
			    ReturnResults returnResults = new ReturnResults();
				returnResults.setFunctionResult(true);
			   
			    if (wGivenAmount < wBillAmmount) 
			    {
			     returnResults.getStringResults().add("Update");
			    }
			    else if (wGivenAmount == wBillAmmount) 
			    {
			     returnResults.getStringResults().add("Delete");	
			    }
			    else 
			    {
			     returnResults.setFunctionResult(false); 
			   	 returnResults.getErrorMsgs().add("The given amount is bigger than the total price. Please give an equal or a smaller amount");	
			    }
			      return returnResults;
			  }
		  public static double SubTwoDoubles(double a, double b) {
			  
			  double ResultDouble;
			  
			  BigDecimal c = BigDecimal.valueOf(a).subtract(BigDecimal.valueOf(b));
			  ResultDouble = c.doubleValue();
			  return ResultDouble;
		  }
		  public static Date ReturnDateAfterMonths(int wNumOfMonths){
			  
			    Calendar cal ;
			    Date ReturnDate;
			    
			    cal = Calendar.getInstance(); 
				cal.add(Calendar.MONTH, wNumOfMonths);
				ReturnDate = cal.getTime();
				return ReturnDate;
		  }
		  
}
