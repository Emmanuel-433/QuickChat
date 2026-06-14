/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapp_registration_login;

import java.util.Scanner;
/**
 *
 * @author Student
 */

//Created main class menu
public class Main {
    
    public static void main(String[] args, String longMessage) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Welcome to QuickChat");
        
        System.out.println("How many messages would you like to send?");
        int totalMessages = input.nextInt();
        input.nextLine();
        
        //Added loop for multiple messages
        for (int i = 1; i <= totalMessages; i++) {
            System.out.println("\nMessage " + i);
            
            System.out.print("Enter recipient number: ");
            String recipient = input.nextLine();
            
            System.out.print("Enter your message: ");
            String text = input.nextLine();
            
            Message msg = new Message(i, recipient, longMessage);
            
            System.out.println(msg.checkRecipientCell());
            System.out.println(msg.checkMessageLength());
            
            if (msg.checkMessageLength().contains("ready")) {
                System.out.println("Choose option:");
                System.out.println("1. Send Message");
                System.out.println("2. Store Message");
                System.out.println("3. Disregard Message");
                System.out.println("4. Stored Messages");
                
                int choice = input.nextInt();
                input.nextLine();
                
                System.out.println(msg.sendMessage(choice));
                MessageManager manager = new MessageManager();
                
                if (choice == 1) {
                    System.out.println(msg.printMessages());
                }
                if (choice == 2) {
                    System.out.println("Message successully stored.");
                }
                if (choice == 3) {
                    System.out.println("Message disregarded.");
                }
                if (choice == 4) {
                    manager.displayStoredMessages();
                    
                    System.out.println("\nLongest Stored Message:");
                    System.out.println(manager.getLongestMessage());
                    
                    System.out.println("\nSearch ny recipient:");
                    manager.searchRecipient("+27838884567");
                    
                    System.out.println("\nSearch by Message ID:");
                    manager.searchMessageID("0838884567");
                    
                    System.out.println("\nDelete Message:");
                    manager.deleteMessage("HASH002");
                    
                    System.out.println("\nStored Messages Report:");
                    manager.displayReport(); 
                }
            }
            
            
        }
        System.out.println("\nTotal messages sent: "
                + Message.returnTotalMessages());
        
        MessageManager manager = new MessageManager();
        manager.loadTestData();
        manager.displayStoredMessages();
    }
}


