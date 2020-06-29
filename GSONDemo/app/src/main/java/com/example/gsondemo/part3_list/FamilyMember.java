package com.example.gsondemo.part3_list;

import com.google.gson.annotations.SerializedName;

public class FamilyMember {

    @SerializedName("role")
    private String mRole;

    @SerializedName("age")
    private int mAge;

    public FamilyMember(String mRole, int mAge) {
        this.mRole = mRole;
        this.mAge = mAge;
    }
}
