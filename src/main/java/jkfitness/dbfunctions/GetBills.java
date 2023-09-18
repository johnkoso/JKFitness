package jkfitness.dbfunctions;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import jkfitness.model.Bills;
import jkfitness.model.ClientMemberships;
import jkfitness.utility.HibernateUtil;

public class GetBills {
	
	public static Bills GetBillByClientPk(String wClientPk, Session wSession, boolean wNewSession) 
	{
		String QueryStr;
		Bills CurrentBill;
		Query qrExists ;
		Transaction tx;
		Boolean SessionActive;
		
		tx = null;
		SessionActive = false;
		CurrentBill = null;
		qrExists = null;
		CurrentBill = null;
		
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
            QueryStr = "select b from  Bills b where b.ClientPk = '"+wClientPk+"'";
            tx = wSession.beginTransaction();
            qrExists = wSession.createQuery(QueryStr,Bills.class);
            CurrentBill = (Bills)qrExists.getSingleResultOrNull();
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
	      
		  return CurrentBill;
		}
		
	}
}
