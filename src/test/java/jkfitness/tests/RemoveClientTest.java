package jkfitness.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import jakarta.el.Expression;

import org.junit.jupiter.api.Test;
import jkfitness.executedprocedures.RemoveClient;
import jkfitness.utility.ReturnResults;
public class RemoveClientTest {
	private RemoveClient	RemoveClientTst;
	@BeforeEach                                        
     void setUp() {
		RemoveClientTst = new RemoveClient();
	             }
	@Test
	@DisplayName("Test With No Values")  
	  void TestWithNoValue() {
		ReturnResults returnResult =  RemoveClientTst.RemoveClient("");
		
		assertEquals("ClientPk is not an Integer",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
	@Test
	@DisplayName("Test With Text Value ClientPk ")  
	  void TestWithTextValueClientPk() {
		ReturnResults returnResult =  RemoveClientTst.RemoveClient("aaa");
		
		assertEquals("ClientPk is not an Integer",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
	@Test
	@DisplayName("Test With Double Value ClientPk ")  
	  void TestWithDoubleValueClientPk() {
		ReturnResults returnResult =  RemoveClientTst.RemoveClient("1.2");
		
		assertEquals("ClientPk is not an Integer",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
	@Test
	@DisplayName("Test With Unknown ClientPk ")  
	  void TestUnknownClientPk() {
		ReturnResults returnResult =  RemoveClientTst.RemoveClient("1.2");
		
		assertEquals(false,
				returnResult.getFunctionResult(), "This will fail");  
     }
  }