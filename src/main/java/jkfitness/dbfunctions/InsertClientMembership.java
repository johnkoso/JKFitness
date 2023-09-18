package jkfitness.dbfunctions;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jkfitness.model.ClientMemberships;
import jkfitness.utility.ReturnResults;
import jkfitness.utility.HibernateUtil;

public class InsertClientMembership {
	public static ReturnResults InsertClientMembership( int wMembershipPk, int wClientPk, Session wSession, boolean wNewSession ) {
		ReturnResults returnResults = new ReturnResults();
		returnResults.setFunctionResult(true);
		
		ClientMemberships InsClientMembership;
		Transaction tx;
		Boolean SessionActive;
		
		tx = null;
		SessionActive = false;
		InsClientMembership = null;
		
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
	      InsClientMembership = new ClientMemberships();
	      InsClientMembership.setMembershipPk(wMembershipPk);
	      InsClientMembership.setClientPk(wClientPk);
	   	  wSession.save(InsClientMembership); 
		  tx.commit();  

		}
	catch (HibernateException e) {
		 returnResults.setFunctionResult(false); 
		 returnResults.getErrorMsgs().add(e.toString()); 
	  if(tx!=null)
	  {
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
