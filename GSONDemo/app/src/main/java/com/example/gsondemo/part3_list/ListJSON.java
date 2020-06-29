package com.example.gsondemo.part3_list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.gsondemo.R;
import com.example.gsondemo.part2_Nested.Address;
import com.example.gsondemo.part2_Nested.EmployeeNested;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ListJSON extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_j_s_o_n);

        Gson gson = new Gson();

        List<FamilyMember> familyMembers = new ArrayList<>(); // List is just interface, so new Arraylist();
        familyMembers.add(new FamilyMember("Wife",30));
        familyMembers.add(new FamilyMember("Son",10));


        Address address = new Address("India","Delhi");

        // Java obj to json (Serialization)
        EmployeeNestedList employee = new EmployeeNestedList("Shashank",20,"shashank@gmail.com",address,familyMembers);
        String json = gson.toJson(employee);

        // JSON String to Java Obj (DeSerialization)
        String jsonString = "{\"address\":{\"city\":\"Delhi\",\"country\":\"India\"},\"age\":20,\"email\":\"shashank@gmail.com\",\"family\":[{\"age\":30,\"role\":\"Wife\"},{\"age\":10,\"role\":\"Son\"}],\"firstname\":\"Shashank\"}";
        EmployeeNestedList newEmployee = gson.fromJson(jsonString,EmployeeNestedList.class);


        // Getting only family list as json
        String familyJson = gson.toJson(familyMembers);

        // converting family json string to family members array
        String familyJsonString = "[{\"age\":30,\"role\":\"Wife\"},{\"age\":10,\"role\":\"Son\"}]";
        FamilyMember[] members = gson.fromJson(familyJsonString,FamilyMember[].class);

        // converting family json string to array list of family members
        /*
        *  We can use this approach to save whole arraylist in shared prefernces.
        * By def, shared pre don't take ann arraylist, but it take string, so we convert our arraylist of custom
        * class to json string, save it in shared pref, and then convert back it to Java class using gson
        * */
        Type familyType = new TypeToken<ArrayList<FamilyMember>>(){}.getType();
        ArrayList<FamilyMember> familyMembersArraylist = gson.fromJson(familyJsonString,familyType);

    }
}