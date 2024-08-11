package com.example.asmaasweet;

public class AdminTAblebill {

    String User_name;
    String city;
    String Email;
    String Password;
    String Role;

    public AdminTAblebill(String user_name, String city, String email, String password, String role) {
        User_name = user_name;
        this.city = city;
        Email = email;
        Password = password;
        Role = role;
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String user_name) {
        User_name = user_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }
}