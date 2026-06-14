/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import chatapp_registration_login.MessageManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Student
 */
public class MessageManagerTest {
    
    public MessageManagerTest() {
    }
    private  MessageManager manager;
    
    @BeforeEach
    public void setUP() {
        manager = new MessageManager();
        manager.loadTestData();
    }
    
    @Test
    public void testSentMessagesArray() {
        assertEquals("Did you get the cake?",
                manager.sentMessages.get(0));
        
        assertEquals("It is dinner time.",
                manager.sentMessages.get(1));
    }
    @Test
    public void testLongestMessage() {
        assertEquals(
                "where are you? You are late. I have asked you to be on time.",
                manager.getLongestMessage()
        );
    }
    @Test
    public void testSearchRecipient() {
        assertEquals("+27838884567",
                manager.recipients.get(1));
        
        assertEquals("+27838884567",
                manager.recipients.get(4));
    }
    @Test
    public void testSearchMessageID() {
        assertEquals("0838884567",
                manager.messageIDs.get(3));
    }
    @Test
    public void testDeleteMessage() {
        manager.deleteMessage("HASH002");
        
        assertFalse(
                manager.messageHashes.contains("HASH002"));
    }
    @Test
    public void testDisplayReportData() {
        assertTrue(
                manager.storedMessages.contains("Okay, I am leaving without you."));
    }
}
