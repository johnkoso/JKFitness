package jkfitness.dbfunctions;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Date;

import jkfitness.model.Bills;
import jkfitness.utility.HibernateUtil;
import jkfitness.utility.ReturnResults;

public class UpdateBills {
	public static ReturnResults UpdateBill(int wBillPk ,String wbillDescr, double wAmount, Date wIssueDate, Date wExpdate,int wClientPk, Session wSession, boolean wNewSession ) {
		ReturnResults returnResults = new ReturnResults();
		returnResults.setFunctionResult(true);
		Bills UpdBill;
		Transaction tx;
		Boolean SessionActive;
		
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
	     UpdBill = (Bills) wSession.get(Bills.class, new Integer(wBillPk));
	     UpdBill.setDescr(wbillDescr);
	     UpdBill.setClientPk(wClientPk);
	     UpdBill.setAmount(wAmount);
	     UpdBill.setIssueDate(wIssueDate);
	     UpdBill.setExpDate(wExpdate);
		 wSession.update(UpdBill);
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
