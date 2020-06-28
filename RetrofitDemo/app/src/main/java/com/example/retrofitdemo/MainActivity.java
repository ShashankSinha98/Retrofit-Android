package com.example.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    // 1. Retrofit is android and Java library which is used to send and receive data from web service
    // It provides abstraction layer over Http calls and automatically generates all the complicated low level networking codes
    // we only create a Java Interface that contains method declaration for diff network operations that we want to do on server, add some
    // annotations to these methods and retrofit automatically generates implementation for them.

    // Room is to SQL LITE what retrofit is for Web Services


    // Connverters are used to convert response from web service to Java Objects

    // JSON - [] - JSON Array, {} - JSON object - single java object
    

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/") // passing base url
                .addConverterFactory(GsonConverterFactory.create()) // mentioning how we want to parse the response
                .build();

        JsonPlaceholderApi jsonPlaceholderApi = retrofit.create(JsonPlaceholderApi.class); // retrofit will implement the get method in interface

        Call<List<Post>> call = jsonPlaceholderApi.getPost();

         // call.execute() - run on main thread - freeze app
        // so we use call.enqueue

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if(!response.isSuccessful()) { // HTTP code is btw 200 and 300, 404- error

                    textView.setText("Code: "+response.code());
                    return; // actual data is null from this response, if we try to do any operations on it, we'll get NullPointer Exception
                }

                List<Post> posts = response.body();

                for(Post post : posts){
                    String content = "";

                    content += "ID: "+post.getId()+"\n"+
                            "USER ID: "+post.getUserId()+"\n"+
                            "TITLE: "+post.getTitle()+"\n"+
                            "TEXT: "+post.getText()+"\n\n";

                    textView.append(content);
                }



            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });

    }
}