package com.example.shoopingapp;

public class itemModel {
    private String FirstName;
    private String Email;

    public itemModel(String firstName, String email) {
        FirstName = firstName;
        Email = email;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getEmail() {
        return Email;
    }
}
