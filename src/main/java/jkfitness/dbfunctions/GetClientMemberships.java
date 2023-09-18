package jkfitness.dbfunctions;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import jkfitness.model.ClientMemberships;
import jkfitness.utility.HibernateUtil;
public class GetClientMemberships {
	
	public static ClientMemberships GetClientMembershipByClientPk(String wClientPk, Session wSession, boolean wNewSession) 
	{
		String QueryStr;
		ClientMemberships CurrentClientMembership ;
		
		Query qrExists ;
		Transaction tx;
		Boolean SessionActive;
		
		tx = null;
		SessionActive = false;
		qrExists = null;
		CurrentClientMembership = null;
		
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
		
		try{ 
            QueryStr = "select cm from  ClientMemberships cm where cm.ClientPk = '"+wClientPk+"'";
            tx = wSession.beginTransaction();
            qrExists = wSession.createQuery(QueryStr,ClientMemberships.class);
            CurrentClientMembership = (ClientMemberships)qrExists.getSingleResultOrNull();
            tx.commit();
		   }
        catch (HibernateException e) {
       	     e.printStackTrace();    
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
	      
		  return CurrentClientMembership;
		}
		
	}

}
