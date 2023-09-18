package jkfitness.executedprocedures;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import jkfitness.dbfunctions.GetClients;
import jkfitness.dbfunctions.InsertClient;
import jkfitness.dbfunctions.InsertUser;
import jkfitness.model.Clients;
import jkfitness.utility.CheckPassword;
import jkfitness.utility.HibernateUtil;
import jkfitness.utility.InputDataValidator;
import jkfitness.utility.ReturnResults;

public class RegisterUser {
	public static ReturnResults RegisterUser(String wPassword, String wretypePassword, String wName,String wSurname,String wEmail,String wStreetAddress,String wPostCode,String wPhoneNumber) {
	       
		ReturnResults returnResults = new ReturnResults();
		returnResults.setFunctionResult(true);
		Boolean ContinueFlag;
		Session NewSession;
		Clients InsClient;
		String HashedPassword;
		int ClientPk;
		
		InsClient =null;
		ContinueFlag = true;
		NewSession = null;
		ClientPk = -1;
		HashedPassword = "";
		wEmail =wEmail.toLowerCase();
		
		returnResults = InputDataValidator.ValidateInputClient(  wName, wSurname, wEmail,  wPostCode, wPhoneNumber);
  	    if (returnResults.getFunctionResult() == false)
  	    {
  	     ContinueFlag = false;
  	    }
  	    if (ContinueFlag)
  	    {
  	     returnResults  = CheckPassword.CheckPasswordForRegister(wPassword, wretypePassword);  
         if (returnResults.getFunctionResult() == false)
	     {
	      ContinueFlag = false;
	     }
  	    }
  	    if (ContinueFlag)
	    {
  	     returnResults = CheckPassword.HashPassword(wPassword);
		 if (returnResults.getFunctionResult())
		 {
		   HashedPassword = returnResults.getStringResults().get(0);
		 }
		 else
		 {
		   ContinueFlag = false;
		 }
	    }
  	   if (ContinueFlag)
	    {
  		 try
		  {
		    NewSession = HibernateUtil.getSessionFactory().openSession();  
		  }
		  catch (HibernateException e)
  		 {    
	      ContinueFlag = false;
	      e.printStackTrace();
	     }
	    } 
  	   if (ContinueFlag)
  	   {
  		InsClient = GetClients.GetCurrentClientByEmail(wEmail, NewSession, false);
		if (InsClient != null)
		 {
		  ContinueFlag = false;
		  returnResults.setFunctionResult(false); 
	   	  returnResults.getErrorMsgs().add("This Email already exists in our system. Please choose a different Email");
		  }
  	   }
  	  if (ContinueFlag)
	   {
  		returnResults = InsertClient.InserClient(  wName, wSurname, wEmail, wStreetAddress,  wPostCode, wPhoneNumber, NewSession, false);
        if (returnResults.getFunctionResult() == false)
	    {
	     ContinueFlag = false;
	    }
	   }
  	if (ContinueFlag)
	   {
		InsClient = GetClients.GetCurrentClientByEmail(wEmail, NewSession, false);
		if (InsClient == null)
		 {
		  ContinueFlag = false;
		  returnResults.setFunctionResult(false); 
	   	  returnResults.getErrorMsgs().add("Something went wrong when inserting th client");
		 }
		else 
		{
		 ClientPk = InsClient.getClientPk();
		}
		
	   }  
  	if (ContinueFlag)
	   {
		returnResults = InsertUser.InsertUser(wEmail, HashedPassword, ClientPk, NewSession, false);
     if (returnResults.getFunctionResult() == false)
	    {
	     ContinueFlag = false;
	    }
	   }
  	  if (NewSession != null)
  	  {
  		  NewSession.close();
  	  }	  
	   return returnResults;
	}	

}
