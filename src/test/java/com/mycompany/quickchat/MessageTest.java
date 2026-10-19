/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author Student
 */
public class MessageTest {
     @Test
    public void testMessageID() {
        Message message = new Message(
            1, "+27718693002", "Hi Mike, dinner tonight?"
        );

        assertTrue(message.checkMessageID());
        assertEquals(10, message.getMessageID().length());
    }

    @Test
    public void testValidRecipient() {
        Message message = new Message(
            1, "+27718693002", "Hello"
        );

        assertTrue(message.checkRecipientCell());
    }

    @Test
    public void testInvalidRecipient() {
        Message message = new Message(
            1, "08575975889", "Hello"
        );

        assertFalse(message.checkRecipientCell());
    }

    @Test
    public void testMessageHashFormat() {
        Message message = new Message(
            1, "+27718693002",
            "Hi Mike, can you join us for dinner tonight?"
        );

        String hash = message.createMessageHash();
        
        assertTrue(hash.matches("\\d{2}:1:HITONIGHT\\??"));
    }

    @Test
    public void testSendMessage() {
        Message message = new Message(
            1, "+27718693002", "Hello"
        );

        assertEquals(
            "Message successfully sent.",
            message.SentMessage("1")
        );

        assertEquals("Sent", message.getStatus());
    }

    @Test
    public void testDisregardMessage() {
        Message message = new Message(
            2, "+27718693002", "Hello"
        );

        assertEquals(
            "Press 0 to delete the message.",
            message.SentMessage("2")
        );

        assertEquals("Disregarded", message.getStatus());
    }

    @Test
    public void testStoreMessage() {
        Message message = new Message(
            2, "+27718693002", "Hello"
        );

        assertEquals(
            "Message successfully stored.",
            message.SentMessage("3")
        );

        assertEquals("Stored", message.getStatus());
    }
}

