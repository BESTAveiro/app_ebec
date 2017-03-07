package com.example.jmfs1.ebec;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by root on 3/5/17.
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // This sets the database persistence (even offline it will work)
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
