package jkfitness.utility;

import java.util.Date;
import java.text.ParseException;
import jkfitness.utility.ReturnResults;
import jkfitness.utility.DataUtility;

public class InputDataValidator {

	  
	  
	  public static ReturnResults ValidateInputClient(String wName,String wSurname,String wEmail, String wPostCode,String wPhoneNumber ) 
	  {
	  ReturnResults returnResults = new ReturnResults();
  	  returnResults.setFunctionResult(true);
  	  Boolean ContinueFlag = true;
  	 if (ContinueFlag)
	  {
	    returnResults = DataUtility.ValidateNamePattern(wName);
	  
	    if (returnResults.getFunctionResult() == false)
	    {
	      ContinueFlag = false;
	    }
	  }
  	 if (ContinueFlag)
	  {
	    returnResults = DataUtility.ValidateNamePattern(wSurname);
	  
	    if (returnResults.getFunctionResult() == false)
	    {
	      ContinueFlag = false;
	      returnResults.getErrorMsgs().set(0,"Surname should be at least 1 Letter without Spaces, Numbers, or Special Characters");
	    }
	  } 
  	 if (ContinueFlag)
	  {
	    returnResults = DataUtility.ValidateEmailPattern(wEmail);
	  
	    if (returnResults.getFunctionResult() == false)
	    {
	      ContinueFlag = false;
	    }
	  }
  	 if (ContinueFlag)
	  {
	    returnResults = DataUtility.ValidatePhoneNoPattern(wPhoneNumber);
	  
	    if (returnResults.getFunctionResult() == false)
	    {
	      ContinueFlag = false;
	    }
	  }  	
  	 if (ContinueFlag)
	  {
	    returnResults = DataUtility.ValidatePostCodePattern(wPostCode);
	  
	    if (returnResults.getFunctionResult() == false)
	    {
	      ContinueFlag = false;
	    }
	  }
  	  return returnResults;
}
	  
	  public static ReturnResults ValidateInputMembership(String wMembershipName,String wMembershipNumOfMonths,String wMembershipPrice ) 
	  {
	  ReturnResults returnResults = new ReturnResults();
  	  returnResults.setFunctionResult(true);
  	  Boolean ContinueFlag = true;
  	 if (ContinueFlag)
	  {
	    returnResults = DataUtility.ValidateMembershipNamePattern(wMembershipName);
	  
	    if (returnResults.getFunctionResult() == false)
	    {
	      ContinueFlag = false;
	    }
	  }
  	 if (ContinueFlag)
	  {
	    returnResults = DataUtility.ValidateInteger(wMembershipNumOfMonths);
	  
	    if (returnResults.getFunctionResult() == false)
	    {
	      ContinueFlag = false;
	      returnResults.getErrorMsgs().set(0,"Number of Months is not a number. Please re-Enter");
	    }
	  } 
  	if (ContinueFlag)
	  {
	    if (Integer.valueOf(wMembershipNumOfMonths) <= 0)
	    {
	      ContinueFlag = false;
	      returnResults.setFunctionResult(false);
	      returnResults.getErrorMsgs().add("Number of Months is not > 0. Please re-Enter");
	    }
	  }
  	 if (ContinueFlag)
	  {
	    returnResults = DataUtility.ValidateDouble(wMembershipPrice);
	  
	    if (returnResults.getFunctionResult() == false)
	    {
	      ContinueFlag = false;
	      returnResults.getErrorMsgs().set(0,"Price is not a number. Please re-Enter");
	    }
	  }
  	if (ContinueFlag)
	  {
	    if (Double.valueOf(wMembershipPrice)<= 0)
	    {
	      
	      ContinueFlag = false;
	      returnResults.setFunctionResult(false);
	      returnResults.getErrorMsgs().add("Price is not > 0. Please re-Enter");
	    }
	    
	  }
  	return returnResults;
	  }
	  
	  public static ReturnResults ValidateInputPayment(String wAmount ) 
	  {
	  ReturnResults returnResults = new ReturnResults();
  	  returnResults.setFunctionResult(true);
  	  Boolean ContinueFlag = true;
  	 
  	 if (ContinueFlag)
	  {
	    returnResults = DataUtility.ValidateDouble(wAmount);
	  
	    if (returnResults.getFunctionResult() == false)
	    {
	      ContinueFlag = false;
	      returnResults.getErrorMsgs().set(0,"Amount is not a number");
	    }
	    if (ContinueFlag)
		  {
		    if (Double.valueOf(wAmount)<= 0)
		    {
		      
		      ContinueFlag = false;
		      returnResults.setFunctionResult(false);
		      returnResults.getErrorMsgs().add("Amount is not > 0. Please re-Enter");
		    }
		  }
	  }
  	 
  	return returnResults;
	  }
	  public static ReturnResults ValidateInputClientPk(String wClientPk) 
	  {
	  ReturnResults returnResults = new ReturnResults();
  	  returnResults.setFunctionResult(true);
  	  Boolean ContinueFlag = true;
  	 
  	 if (ContinueFlag)
	  {
	    returnResults = DataUtility.ValidateInteger(wClientPk);
	  
	    if (returnResults.getFunctionResult() == false)
	    {
	      ContinueFlag = false;
	      returnResults.getErrorMsgs().set(0,"ClientPk is not an Integer");
	    }
	  }
  	 
  	return returnResults;
	  }
	  public static ReturnResults ValidateInputMembershipPk(String wMembershipPk) 
	  {
	  ReturnResults returnResults = new ReturnResults();
  	  returnResults.setFunctionResult(true);
  	  Boolean ContinueFlag = true;
  	 
  	 if (ContinueFlag)
	  {
	    returnResults = DataUtility.ValidateInteger(wMembershipPk);
	  
	    if (returnResults.getFunctionResult() == false)
	    {
	      ContinueFlag = false;
	      returnResults.getErrorMsgs().set(0,"MembershipPk is not an Integer");
	    }
	  }
  	 
  	return returnResults;
	  }
}
