package com.example.thelistcompany;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
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
    private static final String LOGTAG = LaunchesAdapter.class.getName();
    private String responseData;

    public LaunchDataService(Context context) {
        ctx = context;
    }

    /**
     * makes request to SpaceX API and retrieves launch data
     */
    public void getLaunchData() {
        if (responseData != null) {
            launches = (ArrayList<Launch>) parseJSON(responseData);
        } else {
            launches = (ArrayList<Launch>) parseJSON(sendRequest());
        }

    }

    public String sendRequest() {
        String url = "https://api.spacexdata.com/v3/launches?order=desc";
//        RequestQueue requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());


        StringRequest request = new StringRequest(Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response == null) {
                            Toast.makeText(getCtx(), "Error to read launch information", Toast.LENGTH_LONG).show();
                            return;
                        }
                        responseData = response;
                        Log.d(LOGTAG, "Launch data retrieved");
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.d(LOGTAG, "Request failed.");
            }
        });
        MySingleton.getInstance(ctx).addToRequestQueue(request);
        return responseData;
    }

    /**
     * parses JSON data to model objects
     *
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

