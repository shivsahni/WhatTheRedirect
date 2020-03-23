package com.example.WhatTheRedirect;

import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Communicator extends AsyncTask {
    private OkHttpClient client;
    private Response response;
    private Request request;

    @Override
    protected Object doInBackground(Object[] objects) {
        client = new OkHttpClient.Builder()
                .addInterceptor(new SessionTokenInterceptor())
                .addNetworkInterceptor(new LoggingInterceptor())
                .build();
        request = new Request.Builder()
                .url("http://192.168.1.70:5000/redirect")
                .header("User-Agent", "OkHttp Example")
                .build();
        response = null;
        try {
            response = client.newCall(request).execute();
            response.body().close();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return null;
    }
}
