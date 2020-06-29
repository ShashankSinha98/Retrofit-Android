package com.example.gsondemo.part2_Nested;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.gsondemo.R;
import com.example.gsondemo.part1.Employee;
import com.google.gson.Gson;

public class NestedJSON extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_j_s_o_n);

        Gson gson = new Gson();

        Address address = new Address("India","Delhi");

        // Java obj to json (Serialization)
        EmployeeNested employee = new EmployeeNested("Shashank",20,"shashank@gmail.com",address);
        String json = gson.toJson(employee);


        // JSON String to Java Obj (DeSerialization)
        String jsonString = "{\"address\":{\"city\":\"Delhi\",\"country\":\"India\"},\"age\":20,\"email\":\"shashank@gmail.com\",\"firstname\":\"Shashank\"}";
        EmployeeNested newEmployee = gson.fromJson(jsonString,EmployeeNested.class);
    }
}