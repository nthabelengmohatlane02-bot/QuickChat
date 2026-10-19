/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Student
 */
public class LoginTest {

    @Test
    void usernameCorrect() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertTrue(login.checkUserName());
    }

    @Test
    void usernameIncorrect() {
        Login login = new Login("kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertFalse(login.checkUserName());
    }

    @Test
    void passwordCorrect() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertTrue(login.checkPasswordComplexity());
    }

    @Test
    void passwordIncorrect() {
        Login login = new Login("kyl_1", "password", "+27838968976", "Kyle", "Smith");
        assertFalse(login.checkPasswordComplexity());
    }

    @Test
    void phoneCorrect() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertTrue(login.checkCellPhoneNumber());
    }

    @Test
    void phoneIncorrect() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "08966553", "Kyle", "Smith");
        assertFalse(login.checkCellPhoneNumber());
    }

    @Test
    void loginSuccessful() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    void loginFailed() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertFalse(login.loginUser("wrong", "wrong"));
    }
}