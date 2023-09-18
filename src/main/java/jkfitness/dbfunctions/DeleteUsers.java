package jkfitness.dbfunctions;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import jkfitness.model.Users;
import jkfitness.model.Clients;
import jkfitness.utility.HibernateUtil;
import jkfitness.utility.ReturnResults;

public class DeleteUsers {
	public static ReturnResults DeleteUserByClientPk(String wClientPk, Session wSession, boolean wNewSession ) {
		
		ReturnResults returnResults = new ReturnResults();
		returnResults.setFunctionResult(true);
		String QueryStr;
		Users DelUser;
		Query qrExists;
		Transaction tx;
		Boolean SessionActive;
		
		tx = null;
		SessionActive = false;
		qrExists = null;
		DelUser = null;
		
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
		QueryStr = "select u from  Users u where u.ClientPk = '"+wClientPk+"'";
		tx = wSession.beginTransaction();
		qrExists = wSession.createQuery(QueryStr,Users.class);
		DelUser = (Users)qrExists.getSingleResultOrNull();
		wSession.delete(DelUser);
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
