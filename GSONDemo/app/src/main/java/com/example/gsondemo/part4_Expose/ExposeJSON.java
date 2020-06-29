package com.example.gsondemo.part4_Expose;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.gsondemo.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ExposeJSON extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expose_j_s_o_n);

        Gson gson = new Gson();

        EmployeePassword employeePassword = new EmployeePassword("Shashank",20,"s@g.com","12345");
        String json = gson.toJson(employeePassword);

        // For working with Expose annotations, we don't use normal Gson obj
        EmployeePasswordExpose employeePasswordExpose = new EmployeePasswordExpose(
                "Shashank",
                20, // serialize false
                "Shashank@gmail.com", // deserialze false
                "12345" // both false
        );
        Gson gsonExpose = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String exposedJson = gsonExpose.toJson(employeePasswordExpose); // only firstname and email

        String jsonTest = "{\"age\":20,\"firstname\":\"Shashank\",\"email\":\"s@gmail.com\",\"password\":\"12345\"}";
        EmployeePasswordExpose employeePasswordExpose1 = gsonExpose.fromJson(jsonTest,EmployeePasswordExpose.class); // only name and age
    }
}