package com.example.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button studiesButton = findViewById(R.id.studies);

        final Button skillsButton = findViewById(R.id.skills);

        studiesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                postData("education");
            }
        });

        skillsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                postData("skills");
            }
        });
    }

    public void  postData(String select){
        {
            try{
                String url = "http://10.35.112.128:8080/greeting/selectcomponent?name="+select;
                System.out.println(url);
                URL urlObj = new URL(url);
                HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
                int responseCode = conn.getResponseCode();
                System.out.println(responseCode);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
