package jkfitness.dbfunctions;


import java.util.Calendar;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import jkfitness.model.Bills;
import jkfitness.model.ClientMemberships;
import jkfitness.utility.HibernateUtil;
import jkfitness.utility.ReturnResults;

public class InsertBill {
	public static ReturnResults InsertBill(int wClientPk, String wMembershipName, Date wIssueDate, Date wExpdate, double wMembershipPrice, Session wSession, boolean wNewSession ) {
       
		ReturnResults returnResults = new ReturnResults();
		returnResults.setFunctionResult(true);
		Transaction tx;
		Boolean SessionActive;
		Bills  InsBill;
		
		InsBill = new Bills ();
		tx = null;
		SessionActive = false;
		
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
	      InsBill.setDescr(wMembershipName);
	      InsBill.setClientPk(wClientPk);
	      InsBill.setAmount(wMembershipPrice);
	      InsBill.setIssueDate(wIssueDate);
	      InsBill.setExpDate(wExpdate);
	   	  wSession.save(InsBill); 
		  tx.commit();     
		}
	   catch (HibernateException e) {
		 returnResults.setFunctionResult(false); 
		 returnResults.getErrorMsgs().add(e.toString()); 
	  if(tx!=null)  
	  {
	      tx.rollback();
	  }
	  e.printStackTrace();  }
	finally {
  
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
