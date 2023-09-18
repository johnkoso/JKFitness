package jkfitness.executedprocedures;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import jkfitness.dbfunctions.DeleteBill;
import jkfitness.dbfunctions.DeleteClientMembership;
import jkfitness.dbfunctions.DeleteUsers;
import jkfitness.dbfunctions.GetBills;
import jkfitness.dbfunctions.GetClientMemberships;
import jkfitness.dbfunctions.DeleteClient;
import jkfitness.model.Bills;
import jkfitness.model.ClientMemberships;
import jkfitness.model.Clients;
import jkfitness.model.Users;
import jkfitness.utility.DataUtility;
import jkfitness.utility.HibernateUtil;
import jkfitness.utility.InputDataValidator;
import jkfitness.utility.ReturnResults;

public class RemoveClient {
public static ReturnResults RemoveClient(String wClientPk) {
		
		ReturnResults returnResults = new ReturnResults();
		returnResults.setFunctionResult(true);
		Boolean ContinueFlag;
		Session NewSession;	
		int ClientPk;
		Boolean BillExsts ;
		Boolean ClientMembershipExsts;
		ClientMemberships CurrenClientMembership;
		Bills CurrentClientBill;
		
		
		ContinueFlag = true;
		NewSession = null;
		ClientPk = -1;
		BillExsts = false ;
		ClientMembershipExsts =false ;
		CurrenClientMembership = null;
		CurrentClientBill = null; 
		
		returnResults = InputDataValidator.ValidateInputClientPk(wClientPk);
	    if (!returnResults.getFunctionResult())
	    {
	      ContinueFlag = false;
		}
	    else
	    {
	     ClientPk = Integer.valueOf(wClientPk);	
	    }
	    if (ContinueFlag)
	    {
		 try
		  {
		    NewSession = HibernateUtil.getSessionFactory().openSession();  
		  }
		  catch (HibernateException e)
		 {    
	      ContinueFlag = false;
	      returnResults.setFunctionResult(false); 
	      returnResults.getErrorMsgs().add(e.toString()); 
	      e.printStackTrace();
	     }
	   }
		if (ContinueFlag)
		   {
			 CurrentClientBill = GetBills.GetBillByClientPk(wClientPk, NewSession, false);
			 if (CurrenClientMembership != null)
			 {
			  BillExsts = true;
		     }
		   }
		if (ContinueFlag && BillExsts)
		{
		 returnResults = DeleteBill.DeleteBillByBillPk(CurrentClientBill.getBillPk() , NewSession, false);
	     if (returnResults.getFunctionResult() == false)
	     {
	    	 ContinueFlag = false;
		 }	
		}
		if (ContinueFlag)
		   {
			 CurrenClientMembership = GetClientMemberships.GetClientMembershipByClientPk(wClientPk, NewSession, false);
			 if (CurrenClientMembership != null)
			 {
			  ClientMembershipExsts = true;
		     }
		   }
		if (ContinueFlag && ClientMembershipExsts)
		{
		 returnResults = DeleteClientMembership.DeleteClientMembershipByClientMembershipPk(CurrenClientMembership.getClientMembershipPk() , NewSession, false);
	     if (returnResults.getFunctionResult() == false)
	     {
		  ContinueFlag = false;
		 }	
		}
		if (ContinueFlag)
		{
		 returnResults = DeleteUsers.DeleteUserByClientPk(wClientPk , NewSession, false);
	     if (returnResults.getFunctionResult() == false)
	     {
		  ContinueFlag = false;
		 }	
		}
		if (ContinueFlag)
		{
		 returnResults = DeleteClient.DeleteClientByClientPk(ClientPk , NewSession, false);
	     if (returnResults.getFunctionResult() == false)
	     {
		  ContinueFlag = false;
		 }	
		}
		if (NewSession != null)
		{
		 NewSession.close();
		}	  
	    return returnResults;
		  	
 }
}
