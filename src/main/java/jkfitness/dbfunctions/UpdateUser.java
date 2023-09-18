package jkfitness.dbfunctions;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import jkfitness.model.Clients;
import jkfitness.model.Users;
import jkfitness.utility.CheckPassword;
import jkfitness.utility.HibernateUtil;
import jkfitness.utility.ReturnResults;

public class UpdateUser {
	public static ReturnResults UpdateUser(int wUserPk, String wUsername,String wPassword, int wClientPk, Session wSession, boolean wNewSession ) {
		ReturnResults returnResults = new ReturnResults();
		returnResults.setFunctionResult(true);
		Users UpdUser;
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
         UpdUser = (Users) wSession.get(Users.class, new Integer(wUserPk));
	     UpdUser.setUsername(wUsername);
	     if (wPassword.isEmpty())
	     {
	      UpdUser.setPassword(UpdUser.getPassword()); 
	     }
	     else
	     {
		  UpdUser.setPassword(wPassword);
		 }
		 UpdUser.setAdminInd("F");
		 UpdUser.setClientPk(wClientPk);
		 wSession.update(UpdUser);
		 tx.commit(); 
		}
	catch (HibernateException e) {
		 returnResults.setFunctionResult(false); 
		 returnResults.getErrorMsgs().add(e.toString()); 
	  if(tx!=null){
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
