package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Splash_screen extends AppCompatActivity
{
    private final int SPLASH_TIME = 2000;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        sleep(SPLASH_TIME);
                        if(Splash_screen.this.hasWindowFocus()) {
                            Intent intent = new Intent(Splash_screen.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.start();
        }
    }
}
