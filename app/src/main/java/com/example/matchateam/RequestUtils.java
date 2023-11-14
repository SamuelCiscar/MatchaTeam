package com.example.matchateam;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RequestUtils {
    private static final String MON_API = "urlApi";
    private final Gson gson;
    private final OkHttpClient client;

    public RequestUtils() {
        this.gson = new Gson();
        this.client = new OkHttpClient();
    }

    public String sendPost(String url, String jsontoSend) {
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsontoSend);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body() != null ? response.body().string() : null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String sendGet(String url) {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body() != null ? response.body().string() : null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
