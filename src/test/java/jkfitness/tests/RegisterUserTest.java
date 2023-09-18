package jkfitness.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import jakarta.el.Expression;

import org.junit.jupiter.api.Test;
import jkfitness.executedprocedures.RegisterUser;
import jkfitness.utility.ReturnResults;
public class RegisterUserTest {
	private RegisterUser	RegisterUserTst;
	@BeforeEach                                        
     void setUp() {
    	RegisterUserTst = new RegisterUser();
	             }
	@Test
	@DisplayName("Test Name With No Value")  
	  void TestNameWithNoValue() {
		ReturnResults returnResult =  RegisterUserTst.RegisterUser
				( "","", "", "", "", "", "", "");
		
		assertEquals("Name should be at least 1 Letter without Spaces, Numbers, or Special Characters",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
	@Test
	@DisplayName("Test Name With Number")  
	  void TestNameWithNumber() {
		ReturnResults returnResult =  RegisterUserTst.RegisterUser
				( "","", "Mark1", "", "", "", "", "");
		
		assertEquals("Name should be at least 1 Letter without Spaces, Numbers, or Special Characters",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
	@Test
	@DisplayName("Test Name With Space")  
	  void TestNameWithSpace() {
		ReturnResults returnResult =  RegisterUserTst.RegisterUser
				( "","", "Mark Washington", "", "", "", "", "");
		
		assertEquals("Name should be at least 1 Letter without Spaces, Numbers, or Special Characters",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
	@DisplayName("Test Surname With Special Char ")  
	  void TestSurnameWithSpecialChar() {
		ReturnResults returnResult =  RegisterUserTst.RegisterUser
				( "","", "Mark", "Wa$hington", "", "", "", "");
		
		assertEquals("Surname should be at least 1 Letter without Spaces, Numbers, or Special Characters",
				returnResult.getErrorMsgs().get(0), "This will fail");  
     }
	@Test
	@DisplayName("TestSurname With Number")  
	  void TestSurnameWithNumber() {
		ReturnResults returnResult =  RegisterUserTst.RegisterUser
				( "","", "Mark", "Washingt0n", "", "", "", "");
		
		assertEquals("Surname should be at least 1 Letter without Spaces, Numbers, or Special Characters",
				returnResult.getErrorMsgs().get(0), "This will fail");  
     }
	@Test
	@DisplayName("Test Surname With Space")  
	  void TestSurnameWithSpace() {
		ReturnResults returnResult =  RegisterUserTst.RegisterUser
				( "","", "Mark", "Mark Washington", "", "", "", "");
		
		assertEquals("Surname should be at least 1 Letter without Spaces, Numbers, or Special Characters",
				returnResult.getErrorMsgs().get(0), "This will fail");  
     }
	@Test
	@DisplayName("Test Email With Letters")  
	  void TestEmailWithLetters() {
		ReturnResults returnResult =  RegisterUserTst.RegisterUser
				( "","", "Mark", "Washington", "mwashington2gmailcom", "", "", "");
		
		assertEquals("Email should be at least 5 characters matching the pattern x@y.y where x includes numbers or letters and y includes letters",
				returnResult.getErrorMsgs().get(0), "This will fail");  
     }
	@Test
	@DisplayName("Test Email With Letters And Email Symbol")  
	  void TestWithLetterAndEmailSymbol() {
		ReturnResults returnResult =  RegisterUserTst.RegisterUser
				( "","", "Mark", "Washington", "mgwashington2@gmailcom", "", "", "");
		
		assertEquals("Email should be at least 5 characters matching the pattern x@y.y where x includes numbers or letters and y includes letters",
				returnResult.getErrorMsgs().get(0), "This will fail");  
     }
	@Test
	@DisplayName("Test Email With Number After Email Symbol")  
	  void TestEmailWithNumberAfterEmailSymbol() {
		ReturnResults returnResult =  RegisterUserTst.RegisterUser
				( "","", "Mark", "Washington", "mgwashington2a@gmail.c0m", "", "", "");
		
		assertEquals("Email should be at least 5 characters matching the pattern x@y.y where x includes numbers or letters and y includes letters",
				returnResult.getErrorMsgs().get(0), "This will fail");  
     }
	@Test
	@DisplayName("Test Phone Number With Letters")  
	  void TestPhoneNumberWithLetters() {
		ReturnResults returnResult =  RegisterUserTst.RegisterUser
				( "","", "Mark", "Washington", "mgwashington2@gmail.com", "", "", "5aaaaaaaaa");
		
		assertEquals("Phone number should contain exactly 10 numbers", returnResult.getErrorMsgs().get(0), "This will fail");  
     }
	@Test
	@DisplayName("Test Phone Number With 9 numbers")  
	  void TestPhoneNumberWith9Numbers() {
		ReturnResults returnResult =  RegisterUserTst.RegisterUser
				( "","", "Mark", "Washington", "mgwashington2@gmail.com", "", "", "696634221");
		
		assertEquals("Phone number should contain exactly 10 numbers", returnResult.getErrorMsgs().get(0), "This will fail");  
   }
	@Test
	@DisplayName("Test Phone Number With 11 numbers")  
	  void TestPhoneNumberWith11Numbers() {
		ReturnResults returnResult =  RegisterUserTst.RegisterUser
				( "","", "Mark", "Washington", "mgwashington2@gmail.com", "", "", "69663422122");
		
		assertEquals("Phone number should contain exactly 10 numbers", returnResult.getErrorMsgs().get(0), "This will fail");  
 }	
	@Test
	@DisplayName("Test Post Code With Letters")  
	  void TestPostCodeWithLetters() {
		ReturnResults returnResult =  RegisterUserTst.RegisterUser
				( "","", "Mark", "Washington", "mgwashington2@gmail.com", "", "aaaaa", "6966342212");
		
		assertEquals("Post Code should contain exactly 5 numbers", returnResult.getErrorMsgs().get(0), "This will fail");  
     }
	@Test
	@DisplayName("Test Post Code With 4 numbers")  
	  void TestPostCode4numbers() {
		ReturnResults returnResult =  RegisterUserTst.RegisterUser
				( "","", "Mark", "Washington", "mgwashington2@gmail.com", "", "6761", "6966342212");
		
		assertEquals("Post Code should contain exactly 5 numbers", returnResult.getErrorMsgs().get(0), "This will fail");  
     }
	@Test
	@DisplayName("Test Post Code With 6 numbers")  
	  void TestPostCode6numbers() {
		ReturnResults returnResult =  RegisterUserTst.RegisterUser
				( "","", "Mark", "Washington", "mgwashington2@gmail.com", "", "676166", "6966342212");
		
		assertEquals("Post Code should contain exactly 5 numbers", returnResult.getErrorMsgs().get(0), "This will fail");  
     }
	
	
	@Test
	@DisplayName("Test New Password Field Pattern")  
	void TestNewPasswordFieldPettern() {
	ReturnResults returnResult =  RegisterUserTst.RegisterUser
		      ( "123456G","", "Mark", "Washington", "mgwashington2@gmail.com", "", "67616", "6966342212");
			
			assertEquals("Password Must Be at least 6 characters and contain at least 1 Uppercase Letter, 1 Number, 1 Lowercase Letter",
					returnResult.getErrorMsgs().get(0), "This will fail"); 
    }
	@Test
	@DisplayName("Test New Password And Retype New Paswword")  
	void TestNewPasswordAndRetypeNewPaswword() {
	ReturnResults returnResult =  RegisterUserTst.RegisterUser
		      ( "123456Gw","123456Gww", "Mark", "Washington", "mgwashington2@gmail.com", "", "67616", "6966342212");
			
			assertEquals("Passwords Do Not Match",
					returnResult.getErrorMsgs().get(0), "This will fail"); 
    }
	@Test
	@DisplayName("Test With Registered Email")  
	void TestWithRegisteredEmail() {
	ReturnResults returnResult =  RegisterUserTst.RegisterUser
		      ( "123456Gw","123456Gw", "Mark", "Washington", "gwashington2@gmail.com", "", "67616", "6966342212");
			
			assertEquals("This Email already exists in our system. Please choose a different Email",
					returnResult.getErrorMsgs().get(0), "This will fail"); 
    }
	
}