package jkfitness.dbfunctions;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import jkfitness.model.Clients;
import jkfitness.utility.HibernateUtil;
import jkfitness.utility.ReturnResults;

public class DeleteClient {
	public static ReturnResults DeleteClientByClientPk(int wClientPk, Session wSession, boolean wNewSession ) {
		
		ReturnResults returnResults = new ReturnResults();
		returnResults.setFunctionResult(true);
		String QueryStr;
		Clients DelClient;
		Query qrExists;
		Transaction tx;
		Boolean SessionActive;
		
		tx = null;
		SessionActive = false;
		qrExists = null;
		DelClient = null;
		
		if (wNewSession)
		{
		  try
		  {
		    wSession = HibernateUtil.getSessionFactory().openSession();  
			wNewSession = false;
			SessionActive = true;
		  }
		  catch (HibernateException e) {
			   returnResults.setFunctionResult(false); 
		       returnResults.getErrorMsgs().add(e.toString()); 
	           e.printStackTrace();   
		  }
		}
	    
		
		try 
		{
		tx = wSession.beginTransaction();
		DelClient = (Clients) wSession.get(Clients.class, new Integer(wClientPk));
		wSession.delete(DelClient);
		tx.commit();  
		    		
			}
		 catch (HibernateException e) {
			 returnResults.setFunctionResult(false); 
			 returnResults.getErrorMsgs().add(e.toString()); 
		     if(tx!=null){
	         //   Roll back if any exception occurs. 
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
