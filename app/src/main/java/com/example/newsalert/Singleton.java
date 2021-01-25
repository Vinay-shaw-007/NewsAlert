package com.example.newsalert;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class Singleton {
    private static Singleton sInstance = null;
    private RequestQueue mRequestQueue;

    private Singleton() {
        mRequestQueue = Volley.newRequestQueue(MyApplication.getAppContext());
    }

    public static Singleton getInstance() {
        if (sInstance == null) {
            sInstance = new Singleton();
        }
        return sInstance;
    }

    public Request getRequestQueue(Request requestQueue) {
        return mRequestQueue.add(requestQueue);
    }
}
