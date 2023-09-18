package jkfitness.utility;
import  jkfitness.dbfunctions.GetClients;
import jkfitness.model.Clients;
import jkfitness.model.Users;

import org.hibernate.Session;

import jkfitness.utility.BCrypt;
import jkfitness.utility.DataUtility;
import jkfitness.utility.ReturnResults;

public class CheckPassword {

	public static ReturnResults CheckPasswordForLogin(String password_plaintext, String stored_hash) {
	    ReturnResults returnResults = new ReturnResults();
		returnResults.setFunctionResult(true);
		Boolean CheckPass = false;

		if(null == stored_hash || !stored_hash.startsWith("$2a$"))
		 {
			returnResults.setFunctionResult(false);
	          returnResults.getErrorMsgs().add("Invalid hash provided for comparison");
		 }

		CheckPass = BCrypt.checkpw(password_plaintext, stored_hash);
		if (!CheckPass)
		{
		  returnResults.setFunctionResult(false);
	      returnResults.getErrorMsgs().add("Wrong Password. Please try again");	
		}

		return returnResults;
	  }

	  public static ReturnResults ValidatePasswordPattern(String wPassword) {
		 ReturnResults returnResults = new ReturnResults();
	     returnResults.setFunctionResult(true);
	     String passregex =  "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}";
	     if (!wPassword.matches(passregex)) {
	    	 returnResults.setFunctionResult(false); 
	   	     returnResults.getErrorMsgs().add("Password Must Be at least 6 characters and contain at least 1 Uppercase Letter, 1 Number, 1 Lowercase Letter");
		      }
		   return returnResults;
	      }
	  
	  public static ReturnResults VerifyPasswords(String wPassword, String wretypePassword) {
		    ReturnResults returnResults = new ReturnResults();
			returnResults.setFunctionResult(true);
		    if (!(wPassword.equals(wretypePassword))) {
		    	returnResults.setFunctionResult(false); 
	   		    returnResults.getErrorMsgs().add("Passwords Do Not Match");
		      }
		    return returnResults;
		  }
	  public static ReturnResults VerifyOldNewPasswords(String wOldPassword, String wNewPassword) {
		    ReturnResults returnResults = new ReturnResults();
			returnResults.setFunctionResult(true);
		    if ((wOldPassword.equals(wNewPassword))) {
		    	returnResults.setFunctionResult(false); 
	   		    returnResults.getErrorMsgs().add("New Password cannot be the same with old password");
		      }
		    return returnResults;
		  }
	  public static ReturnResults CheckPasswordForRegister( String wPassword, String wretypePassword) 
	  {
		    ReturnResults returnResults = new ReturnResults();
			returnResults.setFunctionResult(true);
			Boolean ContinueFlag;
			ContinueFlag = true;
			
			if (ContinueFlag)
		  	  {
		  	    returnResults = ValidatePasswordPattern(wPassword);
		  	  
		  	    if (returnResults.getFunctionResult() == false)
		  	    {
		  	      ContinueFlag = false;
		  	    }
		  	  }
		  	if (ContinueFlag)
			  {
			    returnResults = VerifyPasswords(wPassword, wretypePassword);
			  
			    if (returnResults.getFunctionResult() == false)
			    {
			      ContinueFlag = false;
			    }
			  }
		      return returnResults;
	  } 
//	  public static ReturnResults CheckPasswordForUpdate(String wOldPassword, String wPasswordHash, String wPassword, String wretypePassword) 
//	  {
//		    ReturnResults returnResults = new ReturnResults();
//			returnResults.setFunctionResult(true);
//			Boolean ContinueFlag;
//			ContinueFlag = true;
//			if (ContinueFlag)
//		  	  {
//		  	    returnResults = CheckPasswordForLogin(wOldPassword, wPasswordHash);
//		  	  
//		  	    if (returnResults.getFunctionResult() == false)
//		  	    {
//		  	      ContinueFlag = false;
//		  	    }
//		  	  }
//		  	if (ContinueFlag)
//			  {
//			    returnResults = CheckPasswordForRegister(wPassword, wretypePassword);
//			  
//			    if (returnResults.getFunctionResult() == false)
//			    {
//			      ContinueFlag = false;
//			    }
//			  }
//		      return returnResults;
//	  } 
	  public static ReturnResults HashPassword(String password_plaintext)
	  {     ReturnResults returnResults = new ReturnResults();
		    returnResults.setFunctionResult(true);
		    String hashed_password = "";
		    try
		    {
			String salt = BCrypt.gensalt(12);
			hashed_password = BCrypt.hashpw(password_plaintext, salt);
		    }
		    catch (Exception e)
		    {
		      returnResults.setFunctionResult(false); 
	    	  returnResults.getErrorMsgs().add(e.toString()); 	
		    }
		    returnResults.getStringResults().add(hashed_password);
		    return returnResults;
            
			//return(hashed_password);
	    }
	  
}
