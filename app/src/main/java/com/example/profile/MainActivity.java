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

        final Button aboutmeButton = findViewById(R.id.aboutme);

        final Button projectButton = findViewById(R.id.projects);

        final Button completedButton = findViewById(R.id.completed);

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

        aboutmeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                postData("aboutme");
            }
        });

        projectButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                postData("projects");
            }
        });

        completedButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                postData("null");
            }
        });
    }

    public void  postData(String select){
        {
            try{
                String url = "https://myprofilespring.herokuapp.com/greeting/selectcomponent?name="+select;
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
