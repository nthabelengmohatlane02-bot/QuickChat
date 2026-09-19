/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Student
 */
public class Message {

private final String messageID;
private final int messageNumber;
private final String recipient;
private final String message;
private final String messageHash;
private String status;

public Message(String messageID, int messageNumber,
String recipient, String message) {
this.messageID = messageID;
this.messageNumber = messageNumber;
this.recipient = recipient;
this.message = message;
this.messageHash = createMessageHash();
this.status = "Stored";
}
public boolean checkMessageID() {
return messageID != null && messageID.length() <= 10;
}
public boolean checkRecipientCell() {
return recipient != null
    && recipient.matches("^\\+[0-9]{1,3}[0-9]{1,10}$");
}
public String checkMessageLength() {
if (message == null) return "Message ready to send.";
if (message.length() <= 250) return "Message ready to send.";
return "Message exceeds 250 characters by" + (message.length() - 250) + "; please reduce the size.";
}
public String createMessageHash() {
String[] words = message.trim().split("\\s+");
String first = words.length > 0 ? words[0] : "";
String last = words.length > 0 ? words[words.length - 1] : "";
String firstTwoId = messageID.substring(0, Math.min(2, messageID.length()));

return (firstTwoId + ":" + messageNumber + ":" + first + last).toUpperCase();
}
public String SentMessage(String choice) {
switch (choice.toLowerCase()) {
case "send&":
status = "Sent&";
return "Message successfully sent.";
case "disregard":
status = "Disregarded";
return "Press 0 to delete the message.";
case "store&":
status = "Stored";
return "Message successfully stored.";
default:
return "Invalid option.";
}
}
public String printMessages() {
return "Message ID: " + messageID + "\nMessage Hash:" + messageHash + "\nRecipient:" + recipient + "\nMessage:" + message;
}
public int returnTotalMessagess() {
return status.equals("Sent") ? 1 : 0;
}
public void storeMessage(String fileName) throws IOException {
List <Message> messages = new ArrayList<>();
messages.add(this);
Gson gson = new GsonBuilder().setPrettyPrinting().create();
try (FileWriter writer = new FileWriter(fileName)) {
gson.toJson(messages, writer);
}
}
public String getMessageID() { return messageID; }
public int getMessageNumber() { return messageNumber; }
public String getRecipient() { return recipient; }
public String getMessage() { return message; }
public String getMessageHash() { return messageHash; }
public String getStatus() { return status; }
}

