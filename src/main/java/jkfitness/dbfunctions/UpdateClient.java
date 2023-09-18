package jkfitness.dbfunctions;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jkfitness.model.Clients;
import jkfitness.model.Users;
import jkfitness.utility.HibernateUtil;
import jkfitness.utility.ServletUtility;
import jkfitness.utility.ReturnResults;
import jkfitness.utility.InputDataValidator;
public class UpdateClient {
	public static ReturnResults UpdateClient(int wClientPk, String wName,String wSurname,String wEmail,String wStreetAddress,String wPostCode,String wPhoneNumber, Session wSession, boolean wNewSession ) {
		
		ReturnResults returnResults = new ReturnResults();
		returnResults.setFunctionResult(true);
		Clients UpdClient;
		Transaction tx;
		Boolean SessionActive;
		
		tx = null;
		SessionActive = false;
	    UpdClient = null;
		
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
		try 
		{
	     tx = wSession.beginTransaction();
	     UpdClient = (Clients) wSession.get(Clients.class, new Integer(wClientPk));
		 UpdClient.setName(wName);
		 UpdClient.setSurname(wSurname);
		 UpdClient.setEmail(wEmail);
		 UpdClient.setPhoneNumber(wPhoneNumber);
		 UpdClient.setPostCode(wPostCode);
		 UpdClient.setStreetAddress(wStreetAddress);
		 wSession.update(UpdClient);
		 tx.commit();  
	    		
		}
	 catch (HibernateException e) {
		 returnResults.setFunctionResult(false); 
		 returnResults.getErrorMsgs().add(e.toString()); 
	     if(tx!=null){
         
	         tx.rollback();
	     }
	     e.printStackTrace();    
	  }finally {
       
		  
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
