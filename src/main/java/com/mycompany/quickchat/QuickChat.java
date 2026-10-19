/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Student
 */
public class QuickChat {
   public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Connect this section to your Part 1 Login class.
        System.out.println("Please log in first.");
        System.out.print("Username: ");
        String username = input.nextLine();

        System.out.print("Password: ");
        String password = input.nextLine();

        // Replace with your actual loginUser() method.
        boolean loggedIn = false;

        // Example only:
        // loggedIn = login.loginUser(username, password);

        if (!loggedIn) {
            System.out.println(
                "Login unsuccessful. Please connect your Part 1 login."
            );
            input.close();
            return;
        }

        List<Message> messages = new ArrayList<>();

        System.out.println("Welcome to QuickChat.");

        System.out.print("How many messages would you like to enter? ");
        int numberOfMessages = Integer.parseInt(input.nextLine());

        int choice;

        do {
            System.out.println("\n1. Send Messages");
            System.out.println("2. Show recently sent messages");
            System.out.println("3. Quit");
            System.out.print("Choose an option: ");

            choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1:
                    for (int i = 0; i < numberOfMessages; i++) {
                        System.out.println(
                            "\nMessage number: " + (i + 1)
                        );

                        System.out.print("Recipient (+27...): ");
                        String recipient = input.nextLine();

                        if (!java.util.regex.Pattern.matches(
                                "\\+27\\d{9}", recipient)) {
                            System.out.println(
                                "Cell phone number is incorrectly "
                                + "formatted or does not contain an "
                                + "international code. Please correct "
                                + "the number and try again."
                            );
                            i--;
                            continue;
                        }

                        System.out.print("Enter your message: ");
                        String text = input.nextLine();

                        if (text.length() > 250) {
                            System.out.println(
                                "Message exceeds 250 characters by "
                                + (text.length() - 250)
                                + "; please reduce the size."
                            );
                            i--;
                            continue;
                        }

                        Message message = new Message(
                            i + 1, recipient, text
                        );

                        System.out.println("Message ready to send.");
                        System.out.println("1. Send Message");
                        System.out.println("2. Disregard Message");
                        System.out.println("3. Store Message");
                        System.out.print("Choose an option: ");

                        String action = input.nextLine();
                        System.out.println(message.SentMessage(action));

                        if (message.getStatus().equals("Sent")) {
                            messages.add(message);
                        } else if (
                                message.getStatus().equals("Stored")) {
                            messages.add(message);
                            MessageStore score = new MessageStore();
                            store.storeMessage(messages);
                        }

                        System.out.println(message.printMessages());
                    }

                    System.out.println(
                        "Total messages sent: "
                        + messages.stream()
                            .filter(m -> m.getStatus().equals("Sent"))
                            .count()
                    );
                    break;

                case 2:
                    System.out.println("Coming Soon.");
                    break;

                case 3:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println(
                        "Invalid option. Please select 1, 2 or 3."
                    );
            }

        } while (choice != 3);

        input.close();
    }

    private static class store {

        private static void storeMessage(List<Message> messages) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public store() {
        }
    }
}