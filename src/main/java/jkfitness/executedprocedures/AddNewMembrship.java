package jkfitness.executedprocedures;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import jkfitness.dbfunctions.InsertMembership;
import jkfitness.utility.HibernateUtil;
import jkfitness.utility.InputDataValidator;
import jkfitness.utility.ReturnResults;


public class AddNewMembrship {
	public static ReturnResults AddMembership(String wMembershipName,String wMembershipDescr, String wMembershipNumOfMonths, String wMembershipPrice) {
		
	ReturnResults returnResults = new ReturnResults();
	returnResults.setFunctionResult(true);
	Boolean ContinueFlag;
	Session NewSession;	
	int MembershipNumOfMonths;
	double MembershipPrice;
	
	ContinueFlag = true;
	NewSession = null;
	MembershipNumOfMonths = 0;
	MembershipPrice = 0;
	
	returnResults  = InputDataValidator.ValidateInputMembership(wMembershipName, wMembershipNumOfMonths, wMembershipPrice);
	if (!returnResults.getFunctionResult())
  	 {
  	   ContinueFlag = false;
  	 }
	else
	{
		MembershipNumOfMonths = Integer.valueOf(wMembershipNumOfMonths)	;
		MembershipPrice = Double.valueOf(wMembershipPrice);
	}
	
	if (ContinueFlag)
    {
	  returnResults  = InsertMembership.InsertClientMembership(wMembershipName, wMembershipDescr ,MembershipNumOfMonths ,MembershipPrice, null, true);
	  if (!returnResults.getFunctionResult())
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
