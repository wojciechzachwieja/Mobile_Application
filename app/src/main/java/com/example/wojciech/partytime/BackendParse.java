package com.example.wojciech.partytime;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by Wojciech on 2015-09-14.
 */
public class BackendParse extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "h9ryp2fLzrfvvKtpZFpPrdu22MxDOVyqjab5TPFG", "ONTRn9U8WuIAL3kYIEXnWhxci7KJyKC3B9GsrJUa");
    }
}
