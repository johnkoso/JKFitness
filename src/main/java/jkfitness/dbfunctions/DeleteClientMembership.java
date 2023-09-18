package jkfitness.dbfunctions;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import jkfitness.model.Bills;
import jkfitness.model.ClientMemberships;
import jkfitness.utility.HibernateUtil;
import jkfitness.utility.ReturnResults;

public class DeleteClientMembership {
	public static ReturnResults DeleteClientMembershipByClientPk(String wClientPk, Session wSession, boolean wNewSession ) {
		
		ReturnResults returnResults = new ReturnResults();
		returnResults.setFunctionResult(true);
		String QueryStr;
		ClientMemberships DelClientMembership;
		Query qrExists;
		Transaction tx;
		Boolean SessionActive;
		
		tx = null;
		SessionActive = false;
		qrExists = null;
		DelClientMembership = null;
		
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
		QueryStr = "select cm from  ClientMemberships cm where cm.ClientPk = '"+wClientPk+"'";
		tx = wSession.beginTransaction();
		qrExists = wSession.createQuery(QueryStr,ClientMemberships.class);
		DelClientMembership = (ClientMemberships)qrExists.getSingleResultOrNull();
		wSession.delete(DelClientMembership);
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
	public static ReturnResults DeleteClientMembershipByClientMembershipPk(int wClientMembershipPk, Session wSession, boolean wNewSession ) {
		
		ReturnResults returnResults = new ReturnResults();
		returnResults.setFunctionResult(true);
		String QueryStr;
		ClientMemberships DelClientMembership;
		Query qrExists;
		Transaction tx;
		Boolean SessionActive;
		
		tx = null;
		SessionActive = false;
		qrExists = null;
		DelClientMembership = null;
		
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
		DelClientMembership = (ClientMemberships) wSession.get(ClientMemberships.class, new Integer(wClientMembershipPk));
		wSession.delete(DelClientMembership);
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
