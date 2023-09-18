package jkfitness.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import jakarta.el.Expression;

import org.junit.jupiter.api.Test;
import jkfitness.executedprocedures.LoginUser;
import jkfitness.utility.ReturnResults;
public class LoginUserTest {
	private LoginUser	LoginUserTst;
	@BeforeEach                                        
     void setUp() {
		LoginUserTst = new LoginUser();
	             }
	@Test
	@DisplayName("Test With No Values")  
	  void TestWithNoValue() {
		ReturnResults returnResult =  LoginUserTst.LoginUser("", "");
		
		assertEquals("This Email does not exists in our system. Are you a registered user ?",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
	@Test
	@DisplayName("Test With Not Registered Email")  
	  void TestWithNotRegisteredEmail() {
		ReturnResults returnResult =  LoginUserTst.LoginUser("something@gmail.com", "");
		
		assertEquals("This Email does not exists in our system. Are you a registered user ?",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
	@Test
	@DisplayName("Test With No Password Value")  
	  void TestWithNoPasswordValue() {
		ReturnResults returnResult =  LoginUserTst.LoginUser("gwashington2@gmail.com", "");
		
		assertEquals("Wrong Password. Please try again",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
	@Test
	@DisplayName("Test With Wrong Password Value")  
	  void TestWithWrongPasswordValue() {
		ReturnResults returnResult =  LoginUserTst.LoginUser("gwashington2@gmail.com", "1234@Aq");
		
		assertEquals("Wrong Password. Please try again",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
	}   