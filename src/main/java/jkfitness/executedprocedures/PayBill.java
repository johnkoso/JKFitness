package jkfitness.executedprocedures;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import jkfitness.utility.DataUtility;
import jkfitness.utility.HibernateUtil;
import jkfitness.utility.InputDataValidator;
import jkfitness.utility.ReturnResults;
import jkfitness.dbfunctions.DeleteBill;
import jkfitness.dbfunctions.GetBills;
import jkfitness.dbfunctions.UpdateBills;
import jkfitness.model.Bills;

public class PayBill {
	public static ReturnResults PayBill(String wClientPk,String wAmount ) {
		
		ReturnResults returnResults = new ReturnResults();
		returnResults.setFunctionResult(true);
		Boolean ContinueFlag;
		Session NewSession;	
		Bills  CurrentBill;
		int ClientPk;
		double GivenAmount;
		boolean UpdateBill;
		double BillNewAmount;
		
		ContinueFlag = true;
		NewSession = null;
		CurrentBill =null;
		ClientPk = -1;
		GivenAmount = 0;
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
		 returnResults  = InputDataValidator.ValidateInputPayment(wAmount);
		 if (!returnResults.getFunctionResult())
	  	 {
	  	  ContinueFlag = false;
	  	 }
		 else
		 {
		  GivenAmount = Double.valueOf(wAmount);
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
			CurrentBill = GetBills.GetBillByClientPk(wClientPk, NewSession, false);
			if (CurrentBill == null)
			 {
			  ContinueFlag = false;
			  returnResults.setFunctionResult(false); 
		   	  returnResults.getErrorMsgs().add("There is no Bill for this Client");
			 }
		   }	
		if (ContinueFlag)
		   {
			returnResults = DataUtility.CheckBillAmount( GivenAmount, CurrentBill.getAmount());
		    if (returnResults.getFunctionResult() == false)
		    {
			 ContinueFlag = false;
			}
		   }
		if (ContinueFlag)
		   {
			if (returnResults.getStringResults().get(0).equals("Update"))
			{
			  UpdateBill = true;
			  BillNewAmount = DataUtility.SubTwoDoubles(CurrentBill.getAmount(), GivenAmount) ;
			  System.out.println(String.valueOf(BillNewAmount));
			}
		   }
		if (ContinueFlag && UpdateBill)
		{
		 returnResults = UpdateBills.UpdateBill(CurrentBill.getBillPk(),CurrentBill.getDescr(), BillNewAmount, CurrentBill.getIssueDate(), CurrentBill.getExpDate(), ClientPk, NewSession, false);
	     if (returnResults.getFunctionResult() == false)
	     {
		  ContinueFlag = false;
		 }	
		}
		if (ContinueFlag && !UpdateBill)
		{
		 returnResults = DeleteBill.DeleteBillByBillPk (CurrentBill.getBillPk(), NewSession, false);
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
