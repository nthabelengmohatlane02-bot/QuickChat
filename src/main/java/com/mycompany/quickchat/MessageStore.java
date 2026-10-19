/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
/**
 *
 * @author Student
 */
public class MessageStore {
    private List<Message> messages = new ArrayList<>();
    
    public void storeMessage(List<Message> messages){
        this.messages = messages;
    }
        
    public List<Message> getMessages(){
        return messages.stream().filter(message -> "SENT".equals(message.getStatus())).collect(Collectors.toList());
    
    }
    public void logMessages(){
        Gson gson = (Gson) new GsonBuilder()
                .setPrettyPrinting() .create();
    
        try (FileWriter writer =
                     new FileWriter("messages.json")) {
            gson.toJson(messages, writer);
            System.out.println("Messages saved to message.json");
        } catch (IOException e) {
            System.out.println(
                "Error storing messages: " + e.getMessage()
            );
        }
    
    }

    
}   

