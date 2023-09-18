package jkfitness.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import jakarta.el.Expression;

import org.junit.jupiter.api.Test;
import jkfitness.executedprocedures.ChooseClientMembership;
import jkfitness.utility.ReturnResults;
public class ChooseClientMembershipTest {
	private ChooseClientMembership	ChooseClientMembershipTst;
	@BeforeEach                                        
     void setUp() {
		ChooseClientMembershipTst = new ChooseClientMembership();
	             }
	@Test
	@DisplayName("Test With No Values")  
	  void TestWithNoValue() {
		ReturnResults returnResult =  ChooseClientMembershipTst.ChooseMembershipPublishBill("", "");
		
		assertEquals("ClientPk is not an Integer",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
	@Test
	@DisplayName("Test With Text Value ClientPk ")  
	  void TestWithTextValueClientPk() {
		ReturnResults returnResult =  ChooseClientMembershipTst.ChooseMembershipPublishBill("aaa", "");
		
		assertEquals("ClientPk is not an Integer",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
	@Test
	@DisplayName("Test With Double Value ClientPk ")  
	  void TestWithDoubleValueClientPk() {
		ReturnResults returnResult =  ChooseClientMembershipTst.ChooseMembershipPublishBill("1.2", "");
		
		assertEquals("ClientPk is not an Integer",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
	@Test
	@DisplayName("Test With No Values MembershipPk")  
	  void TestWithNoValueMembershipPk() {
		ReturnResults returnResult =  ChooseClientMembershipTst.ChooseMembershipPublishBill("2", "");
		
		assertEquals("MembershipPk is not an Integer",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
	@Test
	@DisplayName("Test With Text Value MembershipPk ")  
	  void TestWithTextValueMembershipPk() {
		ReturnResults returnResult =  ChooseClientMembershipTst.ChooseMembershipPublishBill("2", "aaa");
		
		assertEquals("MembershipPk is not an Integer",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
	@Test
	@DisplayName("Test With Double Value MembershipPk ")  
	  void TestWithDoubleValueMembershipPk() {
		ReturnResults returnResult =  ChooseClientMembershipTst.ChooseMembershipPublishBill("2", "1.2");
		
		assertEquals("MembershipPk is not an Integer",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
 }