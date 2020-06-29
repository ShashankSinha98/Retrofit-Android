package com.example.gsondemo.part4_Expose;

import com.google.gson.annotations.SerializedName;

public class EmployeePassword {

    private String firstname;

    private int age;

    private String email;

    private transient String password; // transient is a java keyword which prevennt this variable from serialization, i.e
    // it will not appear in json string

    // transient work both ways.. i.e, if i had password in json and i try to deserialize it, it'll not appear in java obj

    // @Expose annotation will enable var for both serialization and deserialization. If we annotate firstname,age and email with
    // @Expose and leave email, then email will not undergo serialization and deserialization.
    // @Expose annotation means both serialization and deserialization will happen
    // If we want certain var to only undergo either serialization or deserialization, we use-
    // @Expose(serialize=false) - serialization not happen but deserialization will happen.
    // @Expose(deserialize=false) - deserialization not happen but serialization will happen, def value for both is true.
    // @Expose(serialize=false,deserialize=false) // also set both to false or just leave the annotation

    public EmployeePassword(String firstname, int age, String email, String password) {
        this.firstname = firstname;
        this.age = age;
        this.email = email;
        this.password = password;
    }
}
