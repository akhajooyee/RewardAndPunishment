package com.example.alirezakjy.rewardpunishment;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.example.alirezakjy.rewardpunishment.services.loginRequestService;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MainLogin extends AppCompatActivity {



    String username,password;
    String[] userIdentity;
    public static String token = "" , localHostUrl = "192.168.1.11" , mainUrl = "http://" + localHostUrl + ":8080/RefineAndPunishment/api/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        try {
            init();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Button loginButton;
        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                username = ((EditText) findViewById(R.id.usernameText)).getText().toString();
                password = ((EditText) findViewById(R.id.passwordText)).getText().toString();
                token = loginProcess(username , password);
                String tempJsonForLogin =  loginProcess(username , password);
                try {
                    JSONHandler.loginResponseToStrings(tempJsonForLogin);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext() , tempJsonForLogin , Toast.LENGTH_LONG).show();

                //this part start MainPageActivity

                Intent intent = new Intent(getBaseContext() , MainPageActivity.class);
                startActivity(intent);






            }
        });


    }

    private void init() throws JSONException {
        //inja goh karia ro anjam midim
        MaterialDialog dialog = new MaterialDialog.Builder(MainLogin.this)
                .title("enter your localhost ip")
                .customView(R.layout.local_host_ip_dialog , true)
                .positiveText("ok")
                .negativeText("cancel")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        MainLogin.localHostUrl = ((EditText) dialog.findViewById(R.id.ipEditText)).getText().toString();
                    }
                })
                .show();
    }

    private String loginProcess(String username, String password) {

        String loginUrl = mainUrl + "user/login?personnelCode="  + username + "&password=" + password;

        loginRequestService loginHandler = new loginRequestService();

        Toast.makeText(getApplicationContext() , "lotfan sabr konid" , Toast.LENGTH_SHORT).show();

        String str = "";

        try {
            str = loginHandler.execute(loginUrl).get();

            if (str != null && str.length()  > 0) {

                return str;
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),"server behemoon javab nadade o erroresham ine:" +
                    e.getMessage().toString(), Toast.LENGTH_LONG).show();
        }


        return null;
    }


    private void extraMethod() {

        OkHttpHandler handler = new OkHttpHandler();

        Toast.makeText(getApplicationContext() , "lotfan sabr konid" , Toast.LENGTH_LONG).show();

        String str = "";
        final TextView t = (TextView) findViewById(R.id.ttqq);
        try {
            str = handler.execute("https://reqres.in/api/user?page=2").get();
            t.setText(token);
            if (str != null && str.length()  > 0) {

                t.setText(str);
            }
        } catch (Exception e) {
            t.setText("ehtemalan nashode");
        }
    }

}
