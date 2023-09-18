package jkfitness.executedprocedures;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import jkfitness.dbfunctions.GetUsers;
import jkfitness.model.Users;
import jkfitness.utility.CheckPassword;
import jkfitness.utility.HibernateUtil;
import jkfitness.utility.ReturnResults;

public class LoginUser {
	public static ReturnResults LoginUser(String wEmail,String wPassword) {
	
	ReturnResults returnResults = new ReturnResults();
	returnResults.setFunctionResult(true);
	Boolean ContinueFlag;
	Session NewSession;
	Users CurrentUser;
	String StoredHash;
	
	CurrentUser =null;
	ContinueFlag = true;
	NewSession = null;
	StoredHash = "";
	wEmail = wEmail.toLowerCase();
	
    try
	  {
	    NewSession = HibernateUtil.getSessionFactory().openSession();  
	  }
	  catch (HibernateException e)
	 {    
      ContinueFlag = false;
      returnResults.setFunctionResult(false); 
      returnResults.getErrorMsgs().add(e.toString()); 
      e.printStackTrace();
     }
    if (ContinueFlag)
	   {
    	CurrentUser = GetUsers.GetCurrentUserByEmail(wEmail, NewSession, false);
		if (CurrentUser == null)
		 {
		  ContinueFlag = false;
		  returnResults.setFunctionResult(false); 
	   	  returnResults.getErrorMsgs().add("This Email does not exists in our system. Are you a registered user ?");
		 }
		else
		{
		 StoredHash = CurrentUser.getPassword();	
		}
	   }
    if (ContinueFlag)
	   {
		returnResults = CheckPassword.CheckPasswordForLogin( wPassword, StoredHash);
        if (returnResults.getFunctionResult() == false)
	    {
	     ContinueFlag = false;
	    }
	   }
    if (ContinueFlag)
    {
  	 if (CurrentUser.getAdminInd().equals("F"))
  	 {
  	  returnResults.getStringResults().add("Client");
	  returnResults.getIntResults().add(CurrentUser.getClientPk());
     }
  	
  	 else if (CurrentUser.getAdminInd().equals("T"))
  	 {
      returnResults.getStringResults().add("Admin");
     }
  	 else
  	 {
  	   returnResults.setFunctionResult(false);
       returnResults.getErrorMsgs().add("Current User role is not defined");	
  	 }
    }
    
    if (NewSession != null)
	  {
		  NewSession.close();
	  }	  
    return returnResults;
  }
}
