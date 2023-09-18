package jkfitness.dbfunctions;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import jkfitness.model.Clients;
import jkfitness.model.Users;
import jkfitness.utility.HibernateUtil;
import jkfitness.utility.ReturnResults;

public class GetClients {
	
	public static Clients GetCurrentClientByEmail(String wEmail, Session wSession, boolean wNewSession) 
	{
		String QueryStr;
		Clients CurrentClient ;
		Transaction tx;
		Boolean SessionActive;
			
	    tx = null;
		SessionActive = false;
		CurrentClient =null;
		
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
    		QueryStr = "select c from  Clients c where c.Email = '"+wEmail+"'";
            tx = wSession.beginTransaction();
            Query qrExists = wSession.createQuery(QueryStr,Clients.class);
            CurrentClient = (Clients)qrExists.getSingleResultOrNull();
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
           return CurrentClient;
		
 }
	
	public static Clients GetCurrentClientByClientPk(String wClientPk, Session wSession, boolean wNewSession) 
	{
		
		Clients CurrentClient ;
		Integer ClientPk ;
		Transaction tx;
		Boolean SessionActive;
			
	    tx = null;
		SessionActive = false;
		ClientPk =Integer.valueOf(wClientPk);
		CurrentClient = null;
		
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
            tx = wSession.beginTransaction();
            CurrentClient = (Clients) wSession.get(Clients.class, new Integer(ClientPk));
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
	      
		  return CurrentClient;
		}
		
	}
	public static List GetAllClientsList (Session wSession, boolean wNewSession) 
	{
		String QueryStr;
		Query qrExists;
		Transaction tx;
		Boolean SessionActive;
		List AllClientsList;
			
	    tx = null;
		SessionActive = false;
		AllClientsList = null;
		
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
	     QueryStr = "select c from  Clients c order by c.ClientPk";
	     tx = wSession.beginTransaction();
	     qrExists = wSession.createQuery(QueryStr,Clients.class);
	     AllClientsList = qrExists.getResultList();
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
	  return AllClientsList  ;

	}
	
	
}
}