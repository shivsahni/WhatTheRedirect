package com.example.WhatTheRedirect;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class SessionTokenInterceptor implements Interceptor {
private String sessionToken="ThisIsASampleSecretSessionToken";
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        Request newRequest=request.newBuilder().addHeader("Auth", sessionToken)
                .build();
        return chain.proceed(newRequest);

    }
}

