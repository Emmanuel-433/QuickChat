/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapp_registration_login;

import java.util.ArrayList;
/**
 *
 * @author Student
 */
public class MessageManager {
    
    public ArrayList<String> sentMessages = new ArrayList<>();
    public ArrayList<String> storedMessages = new ArrayList<>();
    public ArrayList<String> disregardedMessages = new ArrayList<>();
    
    public ArrayList<String> recipients = new ArrayList<>();
    public ArrayList<String> messageIDs = new ArrayList<>();
    public ArrayList<String> messageHashes = new ArrayList<>();
    
public void loadTestData() {
    
    sentMessages.add("Did you get the Cake?");
    recipients.add("+27834557896");
    messageIDs.add("MSG002");
    messageHashes.add("HASH001");
    
    storedMessages.add("Where are you? You are late. I have asked you to be on time.");
    recipients.add("+27838884567");
    messageIDs.add("MSG002");
    messageHashes.add("HASH002");
    
    disregardedMessages.add("Yoo-hoo, I am at your gate.");
    messageIDs.add("MSG003");
    messageHashes.add("HASH003");
    
    sentMessages.add("It is dinner time.");
    recipients.add("0838884567");
    messageIDs.add("0838884567");
    messageHashes.add("HASH004");
    
    storedMessages.add("Okay, I am leaving without you.");
    recipients.add("+27838884567");
    messageIDs.add("MSG005");
    messageHashes.add("HASH005");
}

    public void displayStoredMessages() {
        System.out.println("Stored Messages:");
        
        for (String message : storedMessages) {
            System.out.println(message);
        }
    }

    
    public String getLongestMessage() {
        String longest = "";
        
        for (String message : storedMessages) {
            if (message.length() > longest.length()) {
                longest = message;
            }
        }
        return longest;
    }
    
    public void searchRecipient(String recipient) {
        for (int i = 0; i < recipients.size(); i++) {
            
            if (recipients.get(i).equals(recipient)) {
                
                if (i < storedMessages.size()) {
                    System.out.println(storedMessages.get(i));
                }
            }
        }
    }
    public void searchMessageID(String id){
        for (int i = 0; i < messageIDs.size(); i++) {
        if (messageIDs.get(i).equals(id)) {
            System.out.println("Recipient: " + recipients.get(i));
            if (i < storedMessages.size()) {
                System.out.println("Message: " + storedMessages.get(i));
            }
            return;
        }
    }
        System.out.println("Message Id not found.");
    }
    public void deleteMessage(String hash) {
        for (int i = 0; i < messageHashes.size(); i++) {
        if (messageHashes.get(i).equals(hash)) {
            System.out.println(storedMessages.get(i) + "successfully deleted.");
            messageHashes.remove(i);
            if (i < storedMessages.size()) {
                storedMessages.remove(i);
            }
            return;
        }
    }
        System.out.println("Message hash not found.");
    }
    
    public void displayReport() {
        System.out.println("Stored Messages Report");
        
        for (int i = 0; i < storedMessages.size(); i++) {
            System.out.println("Message ID: " + messageIDs.get(i));
            System.out.println("Message Hash: " + messageHashes.get(i));
            System.out.println("Recipient: " + recipients.get(i));
            System.out.println("Message: " + storedMessages.get(i));
            
            System.out.println("-----------------");
        }
    }
}    

