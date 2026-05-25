/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapp_registration_login;

import java.util.Random;
/**
 *
 * @author Student
 */
//Create Message class
public class Message {
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String message;
    private String messageHash;
    
    private static int totalMessages = 0;
    
    public Message(int messageNumber, String recipient, String longMessage) {
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.message = message;
        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();
    }
    
    private String generateMessageID() {
        Random random = new Random();
        long number = 1000000000L + (long)(random.nextDouble() * 9000000000L);
        return String.valueOf(number);
    }
    
    public boolean checkMessageID() {
        return messageID.length() <=10;
    }
    
    public String checkRecipientCell() {
        if (recipient.matches("^\\+27\\d{9}$")) {
            return "Cell phone number successfully captured.";
        }else{
            return "Cell phone number is incorrectly formatted or does not contain the international code.";
        }
    }
    
    public String checkMessageLength() {
        if (message.length() <=250) {
            return "Message ready to send.";
        }else{
            int excess = message.length() - 250;
            return "Message exceeds 250 characters by " + excess + ", please reduce size.";
        }
    }
    
    public String createMessageHash() {
        String[] words = message.split(" ");
        
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        
        return messageID.substring(0, 2) + ":" +
                messageNumber + ":" +
                firstWord.toUpperCase() +
                lastWord.toUpperCase();
    }
    
    public String sendMessage(int choice) {
        switch(choice) {
            case 1:
                totalMessages++;
                return "Message successfully sent.";
                
            case 2:
                return "Press 0 to delete message.";
                
            case 3:
                return "Message successfully stored.";
                
            default:
                return "Invalid option.";
        }
    }
    
    public String printMessages() {
        return "Message ID: " + messageID +
                "\nMessage Hash: " + messageHash +
                "\nRecipient: " + recipient +
                "\nMessage: " + message;
    }
    
    public static int returnTotalMessages() {
        return totalMessages;
    }
    public String getMessageHash() {
        return messageHash;
    }
    public String getMessageID() {
        return messageID;
    }
}
