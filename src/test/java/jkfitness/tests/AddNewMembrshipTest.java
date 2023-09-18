package jkfitness.tests;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import jakarta.el.Expression;

import org.junit.jupiter.api.Test;
import jkfitness.executedprocedures.AddNewMembrship;
import jkfitness.utility.ReturnResults;
public class AddNewMembrshipTest {
	private AddNewMembrship	AddNewMembrshipTst;
	@BeforeEach                                        
     void setUp() {
		AddNewMembrshipTst = new AddNewMembrship();
	             }
	@Test
	@DisplayName("Test With No Values")  
	  void TestWithNoValue() {
		ReturnResults returnResult =  AddNewMembrshipTst.AddMembership("", "", "", "");
		
		assertEquals("Membership Name should match the pattern x-y  whrere x is number, y words",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }

	@Test
	@DisplayName("Test Name With Wrong Memebership Name")  
	  void TestNameWithWrongMemebershipName() {
		ReturnResults returnResult =  AddNewMembrshipTst.AddMembership("Membership1", "", "", "");
		
		assertEquals("Membership Name should match the pattern x-y  whrere x is number, y words",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
	@Test
	@DisplayName("Test Name With Wrong Memebership Name2")  
	  void TestNameWithWrongMemebershipName2() {
		ReturnResults returnResult =  AddNewMembrshipTst.AddMembership("First-Membership", "", "", "");
		
		assertEquals("Membership Name should match the pattern x-y  whrere x is number, y words",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
	@Test
	@DisplayName("Test With No Value For Number Of Months")  
	  void TestWithNoValueForNumberOfMonths() {
		ReturnResults returnResult =  AddNewMembrshipTst.AddMembership("12-Month Membership", "", "", "");
		
		assertEquals("Number of Months is not a number. Please re-Enter",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
	@Test
	@DisplayName("Test With Text Value For Number Of Months")  
	  void TestWithTextValueForNumberOfMonths() {
		ReturnResults returnResult =  AddNewMembrshipTst.AddMembership("12-Month Membership", "", "Twelve", "");
		
		assertEquals("Number of Months is not a number. Please re-Enter",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
	@Test
	@DisplayName("Test Negative Value For Number Of Months")  
	  void TestWithNegativeValueForNumberOfMonths() {
		ReturnResults returnResult =  AddNewMembrshipTst.AddMembership("12-Month Membership", "", "-12", "");
		
		assertEquals("Number of Months is not > 0. Please re-Enter",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
	@Test
	@DisplayName("Test With No Value For Price")  
	  void TestWithNoValueForprice() {
		ReturnResults returnResult =  AddNewMembrshipTst.AddMembership("12-Month Membership", "", "12", "");
		
		assertEquals("Price is not a number. Please re-Enter",
				returnResult.getErrorMsgs().get(0), "This will fail");  
	}
	@Test
	@DisplayName("Test With Text Value Price")  
	  void TestWithTextValueForPrice() {
		ReturnResults returnResult =  AddNewMembrshipTst.AddMembership("12-Month Membership", "", "12", "Humderd");
		
		assertEquals("Price is not a number. Please re-Enter",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
	@Test
	@DisplayName("Test Negative Value For Price")  
	  void TestWithNegativeValueForPrice() {
		ReturnResults returnResult =  AddNewMembrshipTst.AddMembership("12-Month Membership", "", "12", "-120");
		
		assertEquals("Price is not > 0. Please re-Enter",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
}
