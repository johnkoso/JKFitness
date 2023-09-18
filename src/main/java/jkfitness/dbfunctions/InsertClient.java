package jkfitness.dbfunctions;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import jkfitness.model.Clients;
import jkfitness.utility.HibernateUtil;
import jkfitness.utility.ReturnResults;

public class InsertClient {
	
	public static ReturnResults InserClient(String wName,String wSurname,String wEmail,String wStreetAddress,String wPostCode,String wPhoneNumber, Session wSession, boolean wNewSession ) {
	       
		ReturnResults returnResults = new ReturnResults();
		returnResults.setFunctionResult(true);
		Transaction tx = null;
		Boolean SessionActive;
		
		SessionActive = false;
		if (wNewSession)
		{
		  try
		  {
		    wSession = HibernateUtil.getSessionFactory().openSession();  
			wNewSession = false;
			SessionActive = true;
		  }
		  catch (HibernateException e) {
			  e.printStackTrace();    
		  }
		}
		
		Clients InsClient = new Clients();
		try
		{
		   tx = wSession.beginTransaction();
		   InsClient.setName(wName);
	   	   InsClient.setSurname(wSurname);
	   	   InsClient.setStreetAddress(wStreetAddress);
	   	   InsClient.setPostCode(wPostCode);
	   	   InsClient.setEmail(wEmail);
	   	   InsClient.setPhoneNumber(wPhoneNumber);
	   	   wSession.save(InsClient); 
	       tx.commit();
		} 
		catch (HibernateException e) 
		{
			
        returnResults.setFunctionResult(false); 
    	  returnResults.getErrorMsgs().add(e.toString()); 
    	  e.printStackTrace();    
    	  if(tx!=null)
    	  {
   	       tx.rollback();
   	      }
		}      
		finally 
		{  
         if (SessionActive)
	     {
		  wSession.close();
	     }
	     else
	     {
		 wSession.clear();	
	     }
         return returnResults;
		} 
	}

}
