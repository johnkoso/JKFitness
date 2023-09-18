package jkfitness.dbfunctions;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import jkfitness.model.Memberships;
import jkfitness.utility.ReturnResults;
import jkfitness.utility.HibernateUtil;

public class InsertMembership {
		public static ReturnResults InsertClientMembership( String wMembershipName,String wMembershipDescr, int wMembershipNumOfMonths, double wMembershipPrice, Session wSession, boolean wNewSession ) {
			ReturnResults returnResults = new ReturnResults();
			returnResults.setFunctionResult(true);
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
				  returnResults.setFunctionResult(false); 
                  returnResults.getErrorMsgs().add(e.toString()); 
				  e.printStackTrace();    
			  }
			}
			Memberships InsMembership = new Memberships();
			
			try 
			{
		    
		      tx = wSession.beginTransaction();
		      InsMembership = new Memberships();
		      InsMembership.setName(wMembershipName);
		      InsMembership.setDescr(wMembershipDescr);
		      InsMembership.setNumOfMonths(wMembershipNumOfMonths);
		      InsMembership.setPrice(wMembershipPrice);
		   	  wSession.save(InsMembership); 
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
