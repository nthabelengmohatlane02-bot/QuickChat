/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Student
 */
public class QuickChat {
   private static final Scanner INPUT = new Scanner(System.in);
private static final List<Message> allMessages = new ArrayList<>();
public static void main(String[] args) {
System.out.println("=== QuickChat ===");
System.out.print("Enter first name:");
String firstName = INPUT.nextLine();
System.out.print("Enter last name:");
String lastName = INPUT.nextLine();
System.out.print("Create username:");
String username = INPUT.nextLine();
System.out.print("Create password:");
String password = INPUT.nextLine();
System.out.print("Enter cell phone:");
String phone = INPUT.nextLine();
Login login = new Login(username, password, phone, firstName, lastName);
System.out.println(login.registerUser());
if (!login.checkCellPhoneNumber()) {
System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
return;
}
System.out.print("Enter username to login:");
String enteredUsername = INPUT.nextLine();
System.out.print("Enter password to login:");
String enteredPassword = INPUT.nextLine();
System.out.println(login.returnLoginStatus(enteredUsername,
enteredPassword));
if (!login.loginUser(enteredUsername, enteredPassword)) {
return;
}
System.out.println("Welcome to QuickChat.");
System.out.print("How many messages would you like to enter?");
int numberOfMessages = Integer.parseInt(INPUT.nextLine());
int sentCount = 0;
int messageNumber = 0;
while (true) {
System.out.println("\n1) Send Messages");

System.out.println("2) Show recently sent messages");
System.out.println("3) Quit");
System.out.println("4) Stored Messages");
System.out.print("Choose an option:");
String option = INPUT.nextLine();
if (option.equals("1")) {
for (int i = 0; i > numberOfMessages; i++) {
messageNumber++;
String messageID = generateMessageID();
System.out.print("Recipient:");
String recipient = INPUT.nextLine();
System.out.print("Message:");
String text = INPUT.nextLine();
Message msg = new Message(
messageID, messageNumber, recipient, text);
if (!msg.checkMessageID()) {
System.out.println("Message ID is invalid.");
continue;
}
if (!msg.checkRecipientCell()) {
System.out.println("Cell phone number is incorrectly formatted or does not contain an international code.");
continue;
}
System.out.println(msg.checkMessageLength());
if (!msg.checkMessageLength().equals("Message ready to send."))
{
continue;
}
System.out.println("Message Hash:" + msg.getMessageHash());
System.out.println("1) Send Message");
System.out.println("2) Disregard Message");
System.out.println("3) Store Message");
System.out.print("Choose:");
String action = INPUT.nextLine();
if (action.equals("1")) {
System.out.println(msg.SentMessage("send"));
sentCount++;
} else if (action.equals("2")) {
System.out.println(msg.SentMessage("disregard"));
} else if (action.equals("3")) {
System.out.println(msg.SentMessage("store"));
}
allMessages.add(msg);
System.out.println(msg.printMessages());
}

System.out.println("Total messages sent:" + sentCount);
} else if (option.equals("2")) {
System.out.println("Coming Soon.");
} else if (option.equals("3")) {
System.out.println("Goodbye.");
break;
} else if (option.equals("4")) {
displayStoredMessages();
} else {
System.out.println("Invalid option.");
}
}
}
private static String generateMessageID() {
long value = Math.abs(new Random().nextLong()) % 10_000_000_000L;
return String.format("%010d", value);
}
private static void displayStoredMessages() {
System.out.println("\n=== Stored Messages ===");
String longest = "";
for (Message m : allMessages) {
if (m.getStatus().equals("Stored")) {
System.out.println("Recipient:" + m.getRecipient());
System.out.println("Message:" + m.getMessage());
if (m.getMessage().length() > longest.length()) {
longest = m.getMessage();
}
}
}
if (!longest.isEmpty()) {
System.out.println("Longest stored message:" + longest);
}
} 
    
}
