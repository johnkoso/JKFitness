package jkfitness.dbfunctions;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import jkfitness.model.Bills;
import jkfitness.model.Clients;
import jkfitness.model.Users;
import jkfitness.utility.HibernateUtil;
import jkfitness.utility.ReturnResults;

public class DeleteBill {
public static ReturnResults DeleteBillByClientPk(String wClientPk, Session wSession, boolean wNewSession ) {
		
	ReturnResults returnResults = new ReturnResults();
	returnResults.setFunctionResult(true);
	String QueryStr;
	Bills DelBill;
	Query qrExists;
	Transaction tx;
	Boolean SessionActive;
	
	tx = null;
	SessionActive = false;
	qrExists = null;
	DelBill = null;
	
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
	QueryStr = "select b from  Bills b where b.ClientPk = '"+wClientPk+"'";
	tx = wSession.beginTransaction();
	qrExists = wSession.createQuery(QueryStr,Clients.class);
	DelBill = (Bills)qrExists.getSingleResultOrNull();
	wSession.delete(DelBill);
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

public static ReturnResults DeleteBillByBillPk(int wBillPk, Session wSession, boolean wNewSession ) {
	
	ReturnResults returnResults = new ReturnResults();
	returnResults.setFunctionResult(true);
	String QueryStr;
	Bills DelBill;
	Query qrExists;
	Transaction tx;
	Boolean SessionActive;
	
	tx = null;
	SessionActive = false;
	qrExists = null;
	DelBill = null;
	
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
	DelBill = (Bills) wSession.get(Bills.class, new Integer(wBillPk));
	wSession.delete(DelBill);
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
