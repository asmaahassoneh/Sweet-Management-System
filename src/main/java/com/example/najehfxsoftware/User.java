package com.example.najehfxsoftware;

public class User {
    private String UserName;
    private String Email;
    private String PassWord;
    private  String role;
    private  String City;

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }


    public User(String userName,String city, String email, String passWord, String ConfirmPass ,String role) {
        UserName = userName;
        City=city;
        Email = email;
        PassWord = passWord;
        this.role = role;

    }

    public String getUserName() {
        return UserName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassWord() {
        return PassWord;
    }
    public String getRole() {
        return role;
    }
    @Override
    public String toString() {
        return  "UserName:"+getUserName()+"  "+"Email"+getEmail();
    }
}
