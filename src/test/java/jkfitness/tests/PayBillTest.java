package jkfitness.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import jakarta.el.Expression;

import org.junit.jupiter.api.Test;
import jkfitness.executedprocedures.PayBill;
import jkfitness.utility.ReturnResults;
public class PayBillTest {
	private PayBill	PayBillTst;
	@BeforeEach                                        
     void setUp() {
		PayBillTst = new PayBill();
	             }
	@Test
	@DisplayName("Test With No Values")  
	  void TestWithNoValue() {
		ReturnResults returnResult =  PayBillTst.PayBill("", "");
		
		assertEquals("ClientPk is not an Integer",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
	@Test
	@DisplayName("Test With Text Value ClientPk ")  
	  void TestWithTextValueClientPk() {
		ReturnResults returnResult =  PayBillTst.PayBill("aaa", "");
		
		assertEquals("ClientPk is not an Integer",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
	@Test
	@DisplayName("Test With Double Value ClientPk ")  
	  void TestWithDoubleValueClientPk() {
		ReturnResults returnResult =  PayBillTst.PayBill("1.2", "");
		
		assertEquals("ClientPk is not an Integer",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
	@Test
	@DisplayName("Test With No Value Amount")  
	  void TestWithNoValueAmount() {
		ReturnResults returnResult =  PayBillTst.PayBill("11", "");
		
		assertEquals("Amount is not a number",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
	@Test
	@DisplayName("Test With Text Value Amount ")  
	  void TestWithTextValueAmount() {
		ReturnResults returnResult =  PayBillTst.PayBill("11", "Twelve");
		
		assertEquals("Amount is not a number",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
	@Test
	@DisplayName("Test With Negative Value Amount ")  
	  void TestWithNegativeValueAmount() {
		ReturnResults returnResult =  PayBillTst.PayBill("11", "-12");
		
		assertEquals("Amount is not > 0. Please re-Enter",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
	@Test
	@DisplayName("Test With Negative Value Amount ")  
	  void TestWithNotExistedClientPk() {
		ReturnResults returnResult =  PayBillTst.PayBill("3000", "12");
		
		assertEquals("There is no Bill for this Client",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
	@DisplayName("Test With Greater Amount Than Pay Price In The DB")  
	  void TestWithGreaterAmountThaPayPrice() {
		ReturnResults returnResult =  PayBillTst.PayBill("11", "1200");
		
		assertEquals("The given amount is bigger than the total price. Please give an equal or a smaller amount",
				returnResult.getErrorMsgs().get(0), "This will fail");  
     }
 }
