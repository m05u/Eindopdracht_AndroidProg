package com.example.thelistcompany;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import Models.Launch;

public class LaunchDataService {
    private static ArrayList<Launch> launches;
    private final Context ctx;
    private final String LOGTAG = "DataService";

    public LaunchDataService(Context context) {
        ctx = context;
    }

    /**
     * makes request to SpaceX API and retrieves launch data
     */
    public void getLaunchData() {
        String url = "https://randomuser.me/api/?inc=gender,name,nat";
        RequestQueue requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());


        StringRequest request = new StringRequest(Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        launches = (ArrayList<Launch>) parseJSON(response);
                        Log.d("POG", "Launch data retrieved");
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.d(LOGTAG, "Request failed.");
            }
        });
        MySingleton.getInstance(ctx).addToRequestQueue(request);
    }

    /**
     * parses JSON data to model objects
     * @param response : launch data as JSON string
     * @return list of launch data
     */
    private List<Launch> parseJSON(String response) {
        Log.d(LOGTAG, "Parse method called.");
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();
        Type listType = new TypeToken<ArrayList<Launch>>() {
        }.getType();
        return gson.fromJson(response, listType);
    }

    public static ArrayList<Launch> getLaunches() {
        return launches;
    }

    public Context getCtx() {
        return ctx;
    }
}

