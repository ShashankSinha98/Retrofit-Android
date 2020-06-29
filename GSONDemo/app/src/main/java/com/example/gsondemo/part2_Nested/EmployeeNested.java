package com.example.gsondemo.part2_Nested;

import com.example.gsondemo.part1.Employee;
import com.google.gson.annotations.SerializedName;

public class EmployeeNested {

    @SerializedName("firstname")
    private String mFirstname;

    @SerializedName("age")
    private int mAge;

    @SerializedName("email")
    private String mEmail;

    @SerializedName("address")
    private Address mAddress;

    public EmployeeNested(String firstname, int age, String email, Address address) {
        mFirstname = firstname;
        mAge = age;
        mEmail = email;
        mAddress = address;
    }
}
