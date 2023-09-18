package jkfitness.dbfunctions;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import jkfitness.model.Clients;
import jkfitness.model.Users;
import jkfitness.utility.HibernateUtil;
import jkfitness.utility.ReturnResults;

public class GetUsers {
	
	public static Users GetCurrentUserByClientPk(String wClientPk, Session wSession, boolean wNewSession) 
	{
		String QueryStr;
		Users CurrentUser;
		Transaction tx;
		Boolean SessionActive;
		
		tx = null;
		SessionActive = false;
		CurrentUser = null;
		
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
            QueryStr = "select u from  Users u where u.ClientPk = '"+wClientPk+"'";
            tx = wSession.beginTransaction();
            Query qrExists = wSession.createQuery(QueryStr,Users.class);
            CurrentUser = (Users)qrExists.getSingleResultOrNull();
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
   
		  return CurrentUser;
    	} 		  
	}
	
	public static Users GetCurrentUserByEmail(String wEmail, Session wSession, boolean wNewSession) 
	{
		String QueryStr;
		Users CurrentUser;
		
		Transaction tx;
		Boolean SessionActive;
		
	    tx = null;
		SessionActive = false;
		CurrentUser = null;
		
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
            QueryStr = "select u from  Users u where u.Username = '"+wEmail+"'";
            tx = wSession.beginTransaction();
            Query qrExists = wSession.createQuery(QueryStr,Users.class);
            CurrentUser = (Users)qrExists.getSingleResultOrNull();
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
    	}    
       return CurrentUser;
    		
     }
}
