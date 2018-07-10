package com.example.alirezakjy.rewardpunishment;

import android.os.AsyncTask;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.sql.Time;
import java.util.Timer;

/**
 * Created by alirezakjy on 19/06/2018.
 */

public class OkHttpHandler extends AsyncTask<String, Object, String> {

    OkHttpClient client = new OkHttpClient();

    @Override
    protected String doInBackground(String... strings) {

        Request.Builder builder = new Request.Builder();
        builder.url(strings[0]);
        Request request = builder.build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPreExecute(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onPostExecute(String bytes) {
        super.onPostExecute(bytes);
        try {
            if (bytes != null && bytes.length() > 0) {
                MainLogin.token = bytes;
            }
        } catch (Exception e) {
            MainLogin.token = "motasefane token nagerefti";
        }
    }
}
