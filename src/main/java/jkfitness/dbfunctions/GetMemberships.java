package jkfitness.dbfunctions;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import jkfitness.model.ClientMemberships;
import jkfitness.model.Clients;
import jkfitness.utility.HibernateUtil;
import jkfitness.utility.ReturnResults;
import jkfitness.model.Memberships;

public class GetMemberships {
	public static List GetAllMembershipsList (Session wSession, boolean wNewSession) 
	{
		String QueryStr;
		List AllMemberships;
		Query qrExists ;
		
		Transaction tx;
		Boolean SessionActive;
		
		tx = null;
		SessionActive = false;
		AllMemberships = null;
		qrExists = null;
		
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
	     QueryStr = "select m from  Memberships m order by m.MembershipPk";
	     tx = wSession.beginTransaction();
         qrExists = wSession.createQuery(QueryStr,Memberships.class);
	     AllMemberships = qrExists.getResultList();
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
	  return AllMemberships;
		}

	}
	public static Memberships GetCurrentMembershipbyMembershipPk(int wMembershipPk, Session wSession, boolean wNewSession) 
	{
		Memberships CurrentMembership;
		
		Transaction tx;
		Boolean SessionActive;
			
	    tx = null;
		SessionActive = false;
		CurrentMembership = null;
		
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
            CurrentMembership = (Memberships) wSession.get(Memberships.class, new Integer(wMembershipPk));
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
	      
		  return CurrentMembership;
    	}
		
	}
	
	public static Memberships GetCurrentMembershipbyClientPk(String wClientPk, Session wSession, boolean wNewSession) 
	{
		int MembershipPk;
		ClientMemberships CurrentClientMembership;
        Memberships CurrentMembership;
		
		CurrentMembership = null;
		CurrentClientMembership = null;
		MembershipPk = -1;
		
		CurrentClientMembership = GetClientMemberships.GetClientMembershipByClientPk(wClientPk, wSession, wNewSession);
		if (CurrentClientMembership != null)
		{
			MembershipPk = CurrentClientMembership.getMembershipPk();
			CurrentMembership = GetCurrentMembershipbyMembershipPk(MembershipPk, wSession, wNewSession);
		}
		
		  return CurrentMembership;
	
}
}