package com.example.p_passwordgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        Thread thread = new Thread(){
            public void run(){
                try{
                    // waits for 3 seconds
                    sleep(3000);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                finally{
                    // after waiting for 3 seconds, opens the Main Activity
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };

        thread.start();
    }
}