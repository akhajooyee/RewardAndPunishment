package com.example.alirezakjy.rewardpunishment.services;

import android.os.AsyncTask;

import com.example.alirezakjy.rewardpunishment.MainLogin;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONObject;

/**
 * Created by alirezakjy on 10/07/2018.
 */

public class userListService extends AsyncTask<String , Object , String> {

    public static String thisResponse = "";

    OkHttpClient client = new OkHttpClient();
    String headerName = "Authorization" , headerValue = "Bearer " + MainLogin.token;


    @Override
    protected String doInBackground(String... strings) {

        Request.Builder builder = new Request.Builder();
        builder.url(strings[0]);
        builder.header(headerName , headerValue);
        Request request = builder.build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
