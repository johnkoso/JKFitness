package jkfitness.executedprocedures;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import jkfitness.dbfunctions.GetClients;
import jkfitness.dbfunctions.GetUsers;
import jkfitness.dbfunctions.UpdateClient;
import jkfitness.dbfunctions.UpdateUser;
import jkfitness.model.Clients;
import jkfitness.model.Users;
import jkfitness.utility.CheckPassword;
import jkfitness.utility.DataUtility;
import jkfitness.utility.HibernateUtil;
import jkfitness.utility.InputDataValidator;
import jkfitness.utility.ReturnResults;

public class UpdateClientCredentials {

	public static ReturnResults UpdateClientCredentials(String wClientPk, String wOldPassword, String wNewPassword, String wretypeNewPassword,String wEmail, String wOldEmail, String wName,String wSurname,String wStreetAddress,String wPostCode,String wPhoneNumber) {
	       
		ReturnResults returnResults = new ReturnResults();
		returnResults.setFunctionResult(true);
		Boolean ContinueFlag;
		Session NewSession;
		Clients UpdClient;
		Users  UpdUser;
		String HashedPassword;
		int ClientPk;
	    boolean UpdateUsersTable;
		
	    UpdUser =null;
	    UpdClient =null;
		ContinueFlag = true;
		NewSession = null;
		ClientPk = -1;
		UpdateUsersTable = false;
		wEmail = wEmail.toLowerCase();
		wOldEmail = wOldEmail.toLowerCase();
		returnResults = InputDataValidator.ValidateInputClientPk(wClientPk);
	    if (!returnResults.getFunctionResult())
	    {
	      ContinueFlag = false;
		}
	    else
	    {
	     ClientPk = Integer.valueOf(wClientPk);	
	    }
	    if (ContinueFlag)
		{
		 returnResults = InputDataValidator.ValidateInputClient( wName, wSurname, wEmail,  wPostCode, wPhoneNumber);
	     if (!returnResults.getFunctionResult())
	  	 {
	  	   ContinueFlag = false;
	  	 }
		}
	    if (ContinueFlag)
	       {
	    	if ( !((!wNewPassword.isEmpty() && !wretypeNewPassword.isEmpty() && !wOldPassword.isEmpty()) ||
	    			(wNewPassword.isEmpty() && wretypeNewPassword.isEmpty() && wOldPassword.isEmpty()))	)	
	        {
	    	  ContinueFlag = false;
	  		  returnResults.setFunctionResult(false); 
	  	   	  returnResults.getErrorMsgs().add("You havent Completeted one or more Password Fields");	
	        }
	       }
	    if (ContinueFlag)
	       {
	    	if (!wretypeNewPassword.isEmpty() )	
	        {
	        	UpdateUsersTable = true;
	        	returnResults = CheckPassword.CheckPasswordForRegister(wNewPassword,  wretypeNewPassword );
	        	if (!returnResults.getFunctionResult())
	        	{
	        	  ContinueFlag = false;
	        	}
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
    	      returnResults.setFunctionResult(false); 
    	      returnResults.getErrorMsgs().add(e.toString()); 
    	      e.printStackTrace();
    	     }
       }
       if (ContinueFlag)
       {
    	 UpdClient = GetClients.GetCurrentClientByClientPk(wClientPk, NewSession, false);
    	 if (UpdClient == null)
		 {
		  ContinueFlag = false;
		  returnResults.setFunctionResult(false); 
	   	  returnResults.getErrorMsgs().add("Client with that ClientPk not Found in Clients table");
		 }
       }
       if (ContinueFlag && !wOldEmail.equals(wEmail))
	   {
	    UpdClient = GetClients.GetCurrentClientByEmail(wEmail, NewSession, false);
	    if (UpdClient != null)
	    {
	    	ContinueFlag = false;
	  		returnResults.setFunctionResult(false); 
	  	    returnResults.getErrorMsgs().add("This Email is been used by another client. Please choose a diferent email");
	    }
	    else 
	    {
	      UpdateUsersTable = true;
	    }	
	   }  
       
       if (ContinueFlag && UpdateUsersTable)
       {
    	 UpdUser = GetUsers.GetCurrentUserByClientPk(wClientPk, NewSession, false);
    	 if (UpdUser == null)
		 {
		  ContinueFlag = false;
		  returnResults.setFunctionResult(false); 
	   	  returnResults.getErrorMsgs().add("User with that ClientPk not Found in Users table");
		 }
       }
       
       if (ContinueFlag && UpdateUsersTable && !wOldPassword.isEmpty())
       {
   		 returnResults = CheckPassword.CheckPasswordForLogin(wOldPassword, UpdUser.getPassword());
   	     if (!returnResults.getFunctionResult())
   	      {
   	       ContinueFlag = false;
   	       returnResults.getErrorMsgs().set(0,"You typed your Old Password Wrong. Please try again");
   	      }  
       }
       if (ContinueFlag && UpdateUsersTable && !wOldPassword.isEmpty()) 
	    {
    	  returnResults = CheckPassword.VerifyOldNewPasswords(wOldPassword, wNewPassword);
 		  if (!returnResults.getFunctionResult())
 		  {
 		    ContinueFlag = false;
 		  }
	    }
       if (ContinueFlag && UpdateUsersTable && !wNewPassword.isEmpty()) 
	    {
		  returnResults = CheckPassword.HashPassword(wNewPassword);
		  if (returnResults.getFunctionResult())
		  {
		    wNewPassword = returnResults.getStringResults().get(0);
		  }
	    }
       if (ContinueFlag && UpdateUsersTable) 
	    {
    	  returnResults = UpdateUser.UpdateUser(UpdUser.getUserPk(), wEmail, wNewPassword, ClientPk, NewSession, false);
     	  if (!returnResults.getFunctionResult())
     	   {
     	    ContinueFlag = false;
     	   }
	    }
       if (ContinueFlag)
       {
	    returnResults = UpdateClient.UpdateClient(ClientPk, wName, wSurname, wEmail, wStreetAddress, wPostCode, wPhoneNumber, NewSession, false );
	    if (!returnResults.getFunctionResult())
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

