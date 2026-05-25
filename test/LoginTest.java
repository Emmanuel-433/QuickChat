/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import chatapp_registration_login.Login;
import chatapp_registration_login.Message;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class LoginTest {
    Login login= new Login();
   

    @Test
    public void testUserNameCorrect() {
        assertTrue(login.checkUserName("Ka_1"),"Username correctly formatted");
    }
    @Test
    public void testUserNameIncorrect(){
        assertFalse(login.checkUserName("Karl"),"Username incorrectly formatted");
    }
    
    @Test
    public void testPasswordCorrect(){
        assertTrue(login.checkPasswordComplexity("Pass@123"),"Password meets complexity requirements");
    }
    @Test
    public void testPasswordIncorrect(){
        assertFalse(login.checkPasswordComplexity("pass"),"Password does mot meet complexity requirements");
    }
    
    @Test
    public void testCellCorrect(){
        assertTrue(login.checkCellPhoneNumber("+27831234567"),"Cell phone number correctly formatted");
    }
    @Test
    public void testCellInCorrect(){
        assertFalse(login.checkCellPhoneNumber("0831234567"),"Cell phone incorrectly formatted");
    }
    
    @Test
    public void testLoginSuccess(){
        login.registerUser("Ka_1", "Pass@123", "+27831234567", "Karl", "Smith");
        assertEquals(login.loginUser("Ka_1", "Pass@123"),"Login successful");
    }
    @Test
    public void testLoginFail(){
        login.registerUser("Ka_1", "Pass@123", "+27831234567", "Karl", "Smith");
        assertEquals(login.loginUser("Ka_1", "wrongPass"),"Login failed");
    }
    @Test
    public void testRegisterSuccessMessage(){
        String result = login.registerUser("Ka_1", "Pass@123", "+27831234567", "Karl", "Smith");
        assertEquals("Username successfullycaptured.\nCell phone number successfully added.", result);
    }
    @Test
     public void testLoginMessageSuccess(){
        login.registerUser("Ka_1", "Pass@123", "+27831234567", "Karl", "Smith");
        String message =login.loginUser("Ka_1", "Pass@123");
        assertEquals("Welcome Karl Smith.It is great to see you again.", message);
    }
    @Test
    public void testMessageFail(){
        String message = login.loginUser("Ka_1", "wrongPass");
        assertEquals("Username or password incorrect.Please try again.", message);
    }
    
    public class MessageTest {
        
        @Test
        public void testMessageLengthSuccess() {
             Message msg = new Message(
                     1,
                     "+27718693002",
                     "Hi Mike can you join us tonight"
             );
             assertEquals(
                    "Message ready to send.",
                     msg.checkMessageLength()
             );
        }
        
        @Test
        public void testMessageLengthFailure() {
            String longMessage = "a".repeat(260);
            
            Message msg = new Message(
                    1,
                    "+27718693002",
                    longMessage
             );
                    assertTrue(
                            msg.checkMessageLength().contains("Message exceeds")
             );
        }
        
        @Test
        public void testRecipientSuccess() {
             Message msg = new Message(
                     1,
                     "+27718693002",
                     "Hello"
             );
             assertEquals(
                    "Cell phone number successfully captured.",
                     msg.checkRecipientCell()
             );
        }
        
        @Test
        public void testMessageID() {
            
            Message msg = new Message(
            1,
            "+27718693002",
            "Hello"
            );
            assertTrue(msg.checkMessageID());
        }
    }
}

