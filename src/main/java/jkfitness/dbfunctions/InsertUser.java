package jkfitness.dbfunctions;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



import jkfitness.model.Users;
import jkfitness.utility.HibernateUtil;
import jkfitness.utility.ReturnResults;

public class InsertUser {
	
	public static ReturnResults InsertUser(String wEmail,String wPassword,int wClientPk, Session wSession, boolean wNewSession ) {
	       
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
		
		Users InsUser = new Users();
		try
		{
		   tx = wSession.beginTransaction();
		   InsUser.setUsername(wEmail);
	  	   InsUser.setPassword(wPassword);
	  	   InsUser.setAdminInd("F");
	  	   InsUser.setClientPk(wClientPk);
	   	   wSession.save(InsUser); 
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