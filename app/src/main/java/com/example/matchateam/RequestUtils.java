package com.example.matchateam;

import com.example.matchateam.Beans.ProductBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RequestUtils {
    private static final String MON_API = "http://90.1.172.128:8080/api";
    private final Gson gson;
    private static OkHttpClient client = new OkHttpClient();

    public RequestUtils() {
        this.gson = new Gson();
        this.client = new OkHttpClient();
    }

    public static String sendGet(String url) throws Exception {
        System.out.println("url: " + url);
        OkHttpClient client = new OkHttpClient();

        // Création de la requête
        Request request = new Request.Builder().url(url).build();

        // Le try-with ressource doc ici
        // Nous permet de fermer la réponse en cas de succès ou d'échec (dans le finally)
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        }
    }

    public static List<ProductBean> getAllProducts() throws Exception {
        String json = sendGet(MON_API + "/produits");

        // Parser le JSON avec le bon bean et GSON
        List<ProductBean> productList = new Gson().fromJson(json, new TypeToken<List<ProductBean>>() {
        }.getType());

        // Retourner la donnée
        return productList;
    }

    public static String sendCommand(String json) throws Exception {
        String url = MON_API + "/addCommand";

        OkHttpClient client = new OkHttpClient();

        // Création du corps de la requête en utilisant le JSON
        RequestBody requestBody = RequestBody.create(json, MediaType.parse("application/json"));

        // Création de la requête POST avec le corps JSON
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        // Utilisation du try-with-resources pour garantir la fermeture des ressources
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException(response.body().string());
            }
            return response.body().string();
        }
    }

}
