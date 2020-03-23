package com.example.WhatTheRedirect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private OkHttpClient client;
    private Response response;
    private Request request;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("WhatTheRedirect!");

        client = new OkHttpClient.Builder()
                .addInterceptor(new SessionTokenInterceptor())
                .build();


        Button button=findViewById(R.id.temp);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Communicator communicator=new Communicator();
                communicator.execute();
            }

        });
    }
}
