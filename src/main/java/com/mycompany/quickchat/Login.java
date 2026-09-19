/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;
import java.util.regex.Pattern;
/**
 *
 * @author Student
 */
public class Login {
    private String username;
private String password;
private String cellPhone;
private String firstName;
private String lastName;

public Login() {}
    
    public Login(String username, String password, String cellPhone, String firstName, String lastName) {
this.username = username;
this.password = password;
this.cellPhone = cellPhone;

this.firstName = firstName;
this.lastName = lastName;
}
public boolean checkUserName() {
return username != null
   &&username.matches("^(?=.{1,5}$).*_.*$");
}
public boolean checkPasswordComplexity() {
if (password == null || password.length() < 8) {
return false;
}
return password.matches(".*[A-Z].*")
    && password.matches(".*[0-9].*")
    && password.matches(".*[^A-Za-z0-9].*");
}
public boolean checkCellPhoneNumber() {
if (cellPhone == null) {
return false;
}
// International code followed by at most ten digits.
return Pattern.matches("^\\+[0-9]{1,3}[0-9]{1,10}$", cellPhone);
}
public String registerUser() {
if (!checkUserName()) {
return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
}
if (!checkPasswordComplexity()) {
return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
}
return "User successfully registered.";
}
public boolean loginUser(String enteredUsername, String enteredPassword) {
return username != null && password != null
    && username.equals(enteredUsername)
    && password.equals(enteredPassword);
}
public String returnLoginStatus(String enteredUsername, String enteredPassword)
{
if (loginUser(enteredUsername, enteredPassword)) {
return "Welcome &quot; + firstName + &quot;, &quot; + lastName + &quot; it is great to see you again.";
}
return "Username or password incorrect, please try again.";
}
public String getUsername() { return username; }
public String getPassword() { return password; }
public String getCellPhone() { return cellPhone; }
public String getFirstName() { return firstName; }
public String getLastName() { return lastName; }

}

   