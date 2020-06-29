package com.example.gsondemo.part1;

import com.google.gson.annotations.SerializedName;

public class Employee {

    @SerializedName("firstname")
    private String mFirstname;

    @SerializedName("age")
    private int mAge;

    @SerializedName("email")
    private String mEmail;

    public Employee(String firstname, int age, String email) {
        mFirstname = firstname;
        mAge = age;
        mEmail = email;
    }
}
