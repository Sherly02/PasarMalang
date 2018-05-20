package id.sch.smktelkom_mlg.afinal.xirpl1103033.pasarmalang.application;

import android.app.Application;

import com.android.volley.RequestQueue;

/**
 * Created by batuh on 20/05/2018.
 */

public class MyApplication extends Application {

    public static final String TAG = MyApplication.class
            .getSimpleName();
    private static MyApplication mInstance;
    private RequestQueue mRequestQueue;

}
