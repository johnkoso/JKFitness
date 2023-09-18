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
import jkfitness.executedprocedures.UpdateClientCredentials;
import jkfitness.utility.ReturnResults;
public class UpdateClientCredentialsTest {
	private UpdateClientCredentials	UpdateClientCredentialsTst;
	@BeforeEach                                        
     void setUp() {
    	UpdateClientCredentialsTst = new UpdateClientCredentials();
	             }
	@Test
	@DisplayName("Test Name With No Value")  
	  void TestNameWithNoValue() {
		ReturnResults returnResult =  UpdateClientCredentialsTst.UpdateClientCredentials
				("2", "","", "", "", "", "", "", "", "", "");
		
		assertEquals("Name should be at least 1 Letter without Spaces, Numbers, or Special Characters",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
	@Test
	@DisplayName("Test Name With Number")  
	  void TestNameWithNumber() {
		ReturnResults returnResult =  UpdateClientCredentialsTst.UpdateClientCredentials
				("2", "","", "", "", "", "George1", "", "", "", "");
		
		assertEquals("Name should be at least 1 Letter without Spaces, Numbers, or Special Characters",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
	@Test
	@DisplayName("Test Name With Space")  
	  void TestNameWithSpace() {
		ReturnResults returnResult =  UpdateClientCredentialsTst.UpdateClientCredentials
				("2", "","", "", "", "", "George Washington", "", "", "", "");
		
		assertEquals("Name should be at least 1 Letter without Spaces, Numbers, or Special Characters",
				returnResult.getErrorMsgs().get(0), "This will fail");  
       }
	@DisplayName("Test Surname With Special Char ")  
	  void TestSurnameWithSpecialChar() {
		ReturnResults returnResult =  UpdateClientCredentialsTst.UpdateClientCredentials
				("2", "","", "", "", "George", "Wa$hington", "", "", "", "");
		
		assertEquals("Surname should be at least 1 Letter without Spaces, Numbers, or Special Characters",
				returnResult.getErrorMsgs().get(0), "This will fail");  
     }
	@Test
	@DisplayName("TestSurname With Number")  
	  void TestSurnameWithNumber() {
		ReturnResults returnResult =  UpdateClientCredentialsTst.UpdateClientCredentials
				("2", "","", "", "", "", "George", "Washingt0n", "", "", "");
		
		assertEquals("Surname should be at least 1 Letter without Spaces, Numbers, or Special Characters",
				returnResult.getErrorMsgs().get(0), "This will fail");  
     }
	@Test
	@DisplayName("Test Surname With Space")  
	  void TestSurnameWithSpace() {
		ReturnResults returnResult =  UpdateClientCredentialsTst.UpdateClientCredentials
				("2", "","", "", "", "", "George", "George Washington", "", "", "");
		
		assertEquals("Surname should be at least 1 Letter without Spaces, Numbers, or Special Characters",
				returnResult.getErrorMsgs().get(0), "This will fail");  
     }
	@Test
	@DisplayName("Test Email With Letters")  
	  void TestEmailWithLetters() {
		ReturnResults returnResult =  UpdateClientCredentialsTst.UpdateClientCredentials
				("2", "","", "", "gwashington2gmailcom", "", "George", "Washington", "", "", "");
		
		assertEquals("Email should be at least 5 characters matching the pattern x@y.y where x includes numbers or letters and y includes letters",
				returnResult.getErrorMsgs().get(0), "This will fail");  
     }
	@Test
	@DisplayName("Test Email With Letters And Email Symbol")  
	  void TestWithLetterAndEmailSymbol() {
		ReturnResults returnResult =  UpdateClientCredentialsTst.UpdateClientCredentials
				("2", "","", "", "gwashington2@gmailcom", "", "George", "Washington", "", "", "");
		
		assertEquals("Email should be at least 5 characters matching the pattern x@y.y where x includes numbers or letters and y includes letters",
				returnResult.getErrorMsgs().get(0), "This will fail");  
     }
	@Test
	@DisplayName("Test Email With Number After Email Symbol")  
	  void TestEmailWithNumberAfterEmailSymbol() {
		ReturnResults returnResult =  UpdateClientCredentialsTst.UpdateClientCredentials
				("2", "","", "", "gwashington2a@gmail.c0m", "", "George", "Washington", "", "", "");
		
		assertEquals("Email should be at least 5 characters matching the pattern x@y.y where x includes numbers or letters and y includes letters",
				returnResult.getErrorMsgs().get(0), "This will fail");  
     }
	@Test
	@DisplayName("Test Phone Number With Letters")  
	  void TestPhoneNumberWithLetters() {
		ReturnResults returnResult =  UpdateClientCredentialsTst.UpdateClientCredentials
				("2", "","", "", "gwashington2@gmail.com", "", "George", "Washington", "", "", "5aaaaaaaaa");
		
		assertEquals("Phone number should contain exactly 10 numbers", returnResult.getErrorMsgs().get(0), "This will fail");  
     }
	@Test
	@DisplayName("Test Phone Number With 9 numbers")  
	  void TestPhoneNumberWith9Numbers() {
		ReturnResults returnResult =  UpdateClientCredentialsTst.UpdateClientCredentials
				("2", "","", "", "gwashington2@gmail.com", "", "George", "Washington", "", "", "696634221");
		
		assertEquals("Phone number should contain exactly 10 numbers", returnResult.getErrorMsgs().get(0), "This will fail");  
   }
	@Test
	@DisplayName("Test Phone Number With 11 numbers")  
	  void TestPhoneNumberWith11Numbers() {
		ReturnResults returnResult =  UpdateClientCredentialsTst.UpdateClientCredentials
				("2", "","", "", "gwashington2@gmail.com", "", "George", "Washington", "", "", "69663422122");
		
		assertEquals("Phone number should contain exactly 10 numbers", returnResult.getErrorMsgs().get(0), "This will fail");  
 }	
	@Test
	@DisplayName("Test Post Code With Letters")  
	  void TestPostCodeWithLetters() {
		ReturnResults returnResult =  UpdateClientCredentialsTst.UpdateClientCredentials
				("2", "","", "", "gwashington2@gmail.com", "", "George", "Washington", "", "aaaaa", "6966342212");
		
		assertEquals("Post Code should contain exactly 5 numbers", returnResult.getErrorMsgs().get(0), "This will fail");  
     }
	@Test
	@DisplayName("Test Post Code With 4 numbers")  
	  void TestPostCode4numbers() {
		ReturnResults returnResult =  UpdateClientCredentialsTst.UpdateClientCredentials
				("2", "","", "", "gwashington2@gmail.com", "", "George", "Washington", "", "6761", "6966342212");
		
		assertEquals("Post Code should contain exactly 5 numbers", returnResult.getErrorMsgs().get(0), "This will fail");  
     }
	@Test
	@DisplayName("Test Post Code With 6 numbers")  
	  void TestPostCode6numbers() {
		ReturnResults returnResult =  UpdateClientCredentialsTst.UpdateClientCredentials
				("2", "","", "", "gwashington2@gmail.com", "", "George", "Washington", "", "676166", "6966342212");
		
		assertEquals("Post Code should contain exactly 5 numbers", returnResult.getErrorMsgs().get(0), "This will fail");  
     }
	@Test
	@DisplayName("Test Password Fields Not All Filled")  
	  void TestPasswordFieldsNotAllFilled() {
		ReturnResults returnResult =  UpdateClientCredentialsTst.UpdateClientCredentials
				("2", "","123", "", "gwashington2@gmail.com", "", "George", "Washington", "", "67616", "6966342212");
		
		assertEquals("You havent Completeted one or more Password Fields", returnResult.getErrorMsgs().get(0), "This will fail");  
     }
	@Test
	@DisplayName("Test Password Fields Not All Filled 2")  
	  void TestPasswordFieldsNotAllFilled2() {
		ReturnResults returnResult =  UpdateClientCredentialsTst.UpdateClientCredentials
				("2", "","123", "123", "gwashington2@gmail.com", "", "George", "Washington", "", "67616", "6966342212");
		
		assertEquals("You havent Completeted one or more Password Fields", returnResult.getErrorMsgs().get(0), "This will fail");  
	}
	@Test
	@DisplayName("Test New Password Field Pattern")  
	void TestNewPasswordFieldPettern() {
	ReturnResults returnResult =  UpdateClientCredentialsTst.UpdateClientCredentials
		      ("2", "123456A","123456G", "123456G", "gwashington2@gmail.com", "", "George", "Washington", "", "67616", "6966342212");
			
			assertEquals("Password Must Be at least 6 characters and contain at least 1 Uppercase Letter, 1 Number, 1 Lowercase Letter",
					returnResult.getErrorMsgs().get(0), "This will fail"); 
    }
	@Test
	@DisplayName("Test New Password And Retype New Paswword")  
	void TestNewPasswordAndRetypeNewPaswword() {
	ReturnResults returnResult =  UpdateClientCredentialsTst.UpdateClientCredentials
		      ("2", "123456A","123456Gw", "12345Gw", "gwashington2@gmail.com", "", "George", "Washington", "", "67616", "6966342212");
			
			assertEquals("Passwords Do Not Match",
					returnResult.getErrorMsgs().get(0), "This will fail"); 
    }
	@Test
	@DisplayName("Test Wrong ClientPk")  
	void TestWrongClientPk() {
	ReturnResults returnResult =  UpdateClientCredentialsTst.UpdateClientCredentials
		      ("aaa", "123456A","123456Gw", "123456Gw", "gwashington2@gmail.com", "", "George", "Washington", "", "67616", "6966342212");
			
			assertEquals("ClientPk is not an Integer",
					returnResult.getErrorMsgs().get(0), "This will fail"); 
    }
	@Test
	@DisplayName("Test Not Existed ClientPk")  
	void TestNotExistedClientPk() {
	ReturnResults returnResult =  UpdateClientCredentialsTst.UpdateClientCredentials
		      ("3000", "123456A","123456Gw", "123456Gw", "gwashington2@gmail.com", "", "George", "Washington", "", "67616", "6966342212");
			
			assertEquals("Client with that ClientPk not Found in Clients table",
					returnResult.getErrorMsgs().get(0), "This will fail"); 
    }
	@Test
	@DisplayName("Test Wrong Old Paswword")  
	void TestWrongOldPassword() {
	ReturnResults returnResult =  UpdateClientCredentialsTst.UpdateClientCredentials
		      ("2", "123456A","123456Gw", "123456Gw", "gwashington2@gmail.com", "gwashington2@gmail.com", "George", "Washington", "", "67616", "6966342212");
			
			assertEquals("You typed your Old Password Wrong. Please try again",
					returnResult.getErrorMsgs().get(0), "This will fail"); 
    }
	@Test
	@DisplayName("Test Same Old/New Paswword")  
	void TestSameOldNewPassword() {
	ReturnResults returnResult =  UpdateClientCredentialsTst.UpdateClientCredentials
		      ("2", "123456Gw","123456Gw", "123456Gw", "gwashington2@gmail.com", "gwashington2@gmail.com", "George", "Washington", "", "67616", "6966342212");
			
			assertEquals("New Password cannot be the same with old password",
					returnResult.getErrorMsgs().get(0), "This will fail"); 
    }
	@Test
	@DisplayName("Test Same Old/New Paswword")  
	void TestEmailUsedByAnotherUser() {
	ReturnResults returnResult =  UpdateClientCredentialsTst.UpdateClientCredentials
		      ("2", "123456Gw","123456Gw", "123456Gw", "aomn900@gmail.com", "gwashington2@gmail.com", "George", "Washington", "", "67616", "6966342212");
			
			assertEquals("This Email is been used by another client. Please choose a diferent email",
					returnResult.getErrorMsgs().get(0), "This will fail"); 
    }
}
