/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;
import java.util.Random;
import java.util.regex.Pattern;
/**
 *
 * @author Student
 */
public class Message {
    private final String messageID;
    private final int messageNumber;
    private final String recipient;
    private final String messageText;
    private final String messageHash;
    private String status;
 

    public Message(int messageNumber, String recipient,
                   String messageText) {
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;

        Random random = new Random();
        this.messageID = String.format("%010d",
                1_000_000_000L + random.nextInt(1_000_000_000));

        this.messageHash = createMessageHash();
        this.status = "Pending";
    }

    public boolean checkMessageID() {
        return messageID.length() <= 10;
    }

    public boolean checkRecipientCell() {
        // South African international format: +27 followed
        // by nine digits.
        return Pattern.matches("\\+27\\d{9}", recipient);
    }

    public String createMessageHash() {
        String trimmed = messageText.trim();

        if (trimmed.isEmpty()) {
            return messageID.substring(0, 2) + ":"
                    + messageNumber + ":";
        }

        String[] words = trimmed.split("\\s+");

        return (messageID.substring(0, 2) + ":"
                + messageNumber + ":"
                + words[0] + words[words.length - 1])
                .toUpperCase();
    }

    public String SentMessage(String choice) {
        switch (choice) {
            case "1":
                status = "Sent";
                return "Message successfully sent.";

            case "2":
                status = "Disregarded";
                return "Press 0 to delete the message.";

            case "3":
                status = "Stored";
                return "Message successfully stored.";

            default:
                return "Invalid option.";
        }
    }

    public String printMessages() {
        return "Message ID: " + messageID
                + "\nMessage Hash: " + messageHash
                + "\nRecipient: " + recipient
                + "\nMessage: " + messageText;
    }

    public int returnTotalMessagess() {
        return status.equals("Sent") ? 1 : 0;
    }

    public String getMessageID() {
        return messageID;
    }

    public String getMessageHash() {
        return messageHash;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getStatus() {
        return status;
    }
    
    public String checkMessageLength() {
    if (messageText.length() <= 250) {
        return "Message ready to send.";
    }

    int excess = messageText.length() - 250;

    return "Message exceeds 250 characters by "
            + excess + "; please reduce the size.";
}
    
}

