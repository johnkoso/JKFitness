package jkfitness.executedprocedures;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import jkfitness.dbfunctions.DeleteBill;
import jkfitness.dbfunctions.GetClientMemberships;
import jkfitness.dbfunctions.GetMemberships;
import jkfitness.dbfunctions.InsertBill;
import jkfitness.dbfunctions.InsertClientMembership;
import jkfitness.model.Bills;
import jkfitness.model.ClientMemberships;
import jkfitness.model.Memberships;
import jkfitness.utility.DataUtility;
import jkfitness.utility.HibernateUtil;
import jkfitness.utility.InputDataValidator;
import jkfitness.utility.ReturnResults;

public class ChooseClientMembership {
public static ReturnResults ChooseMembershipPublishBill(String wClientPk,String wMembershipPk ) {
		
		ReturnResults returnResults = new ReturnResults();
		returnResults.setFunctionResult(true);
		Boolean ContinueFlag;
		Session NewSession;	
		Bills  CurrentBill;
		int ClientPk;
		int MembershipPk;
		boolean UpdateBill;
		double BillNewAmount;
		Memberships CurrenMembership;
		ClientMemberships CurrenClientMembership;
		Date IssueDate ;
		Date Expdate ;
		
		ContinueFlag = true;
		NewSession = null;
		CurrenMembership =null;
		CurrenClientMembership = null;
		IssueDate = null; 
		Expdate = null  ;
		
		ClientPk = -1;
		MembershipPk = -1 ;
		UpdateBill = false;
		BillNewAmount = 0;
		
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
	     returnResults = InputDataValidator.ValidateInputMembershipPk(wMembershipPk);
	     if (!returnResults.getFunctionResult())
		 {
	      ContinueFlag = false;
		 }
		 else
		 {
		  MembershipPk = Integer.valueOf(wMembershipPk);	
		 }	
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
			 CurrenClientMembership = GetClientMemberships.GetClientMembershipByClientPk(wClientPk, NewSession, false);
			 if (CurrenClientMembership != null)
			 {
			  ContinueFlag = false;
			  returnResults.setFunctionResult(false); 
		   	  returnResults.getErrorMsgs().add("This client has already chosen a membership.");
		     }
		   }
		 if (ContinueFlag)
		   {
			 CurrenMembership = GetMemberships.GetCurrentMembershipbyMembershipPk(MembershipPk, NewSession, false);
			 if (CurrenMembership == null)
			 {
			  ContinueFlag = false;
			  returnResults.setFunctionResult(false); 
		   	  returnResults.getErrorMsgs().add("This Membership does not exist in our system.");
		     }
		   }
		 
		 if (ContinueFlag)
			{
			 returnResults = InsertClientMembership.InsertClientMembership( MembershipPk, ClientPk , NewSession, false);
		     if (returnResults.getFunctionResult() == false)
		     {
			  ContinueFlag = false;
			 }	
			}
		 if (ContinueFlag)
			{
			 IssueDate = DataUtility.ReturnDateAfterMonths(0); 
			 Expdate  = DataUtility.ReturnDateAfterMonths(CurrenMembership.getNumOfMonths()); 
			}
		 if (ContinueFlag)
			{
			 returnResults = InsertBill.InsertBill(ClientPk, CurrenMembership.getName(), IssueDate, Expdate, CurrenMembership.getPrice(), NewSession, false);
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
