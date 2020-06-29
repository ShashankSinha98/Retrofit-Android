package com.example.gsondemo.part1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.gsondemo.R;
import com.google.gson.Gson;


// 1. GSON - library by google
//            - Convert java obj to JSON format (Serialization)  and from JSON to java obj (Deserialization)

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new Gson();

        // Java obj to json (Serialization)
        Employee employee = new Employee("Shashank",20,"shashank@gmail.com");
        String json = gson.toJson(employee);


        // JSON String to Java Obj (DeSerialization)
        String jsonString = "{\"age\":20,\"email\":\"shashank@gmail.com\",\"firstname\":\"Shashank\"}";
        Employee newEmployee = gson.fromJson(jsonString,Employee.class);



    }
}