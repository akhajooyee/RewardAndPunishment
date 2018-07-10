package com.example.alirezakjy.rewardpunishment.services;

import android.os.AsyncTask;

import com.example.alirezakjy.rewardpunishment.MainLogin;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Created by alirezakjy on 21/06/2018.
 */

public class loginRequestService extends AsyncTask<String, Object, String> {

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
