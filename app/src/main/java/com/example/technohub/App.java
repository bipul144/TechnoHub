package com.example.technohub;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("9rUTj7yTMzObOg3VRvgzsiP02Myrx4l2T3JthXgS")
                // if defined
                .clientKey("Tka4ZR6S0QSqkeZmiOgeYWcb6zn52jz0MUvEfhb4")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }



}
