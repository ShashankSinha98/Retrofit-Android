package com.example.gsondemo.part3_list;

import com.example.gsondemo.part2_Nested.Address;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EmployeeNestedList {

    @SerializedName("firstname")
    private String mFirstname;

    @SerializedName("age")
    private int mAge;

    @SerializedName("email")
    private String mEmail;

    @SerializedName("address")
    private Address mAddress;

    @SerializedName("family")
    private List<FamilyMember> mFamily;

    public EmployeeNestedList(String firstname, int age, String email, Address address, List<FamilyMember> familyMembers) {
        mFirstname = firstname;
        mAge = age;
        mEmail = email;
        mAddress = address;
        mFamily = familyMembers;
    }
}
