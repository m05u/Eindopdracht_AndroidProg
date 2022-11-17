package com.example.thelistcompany

import com.example.thelistcompany.RequestService.addToRequestQueue
import com.example.thelistcompany.LaunchDataService
import Models.Launch
import android.content.Context
import android.util.Log
import com.android.volley.toolbox.StringRequest
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.example.thelistcompany.RequestService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.example.thelistcompany.LaunchesAdapter
import java.util.ArrayList

class LaunchDataService(val ctx: Context) {
    private var responseData: String? = null

    /**
     * makes request to SpaceX API and retrieves launch data
     */
    val launchData: Unit
        get() {
            if (responseData != null) {
                launches = parseJSON(responseData) as ArrayList<Launch?>
            } else {
                launches = parseJSON(sendRequest()) as ArrayList<Launch?>
            }
        }

    fun sendRequest(): String? {
        val url = "https://api.spacexdata.com/v3/launches?order=desc"
        //        RequestQueue requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        val request = StringRequest(
            Request.Method.GET,
            url,
            Response.Listener { response ->
                if (response == null) {
                    Toast.makeText(ctx, "Error to read launch information", Toast.LENGTH_LONG)
                        .show()
                    return@Listener
                }
                responseData = response
                Log.d(LOGTAG, "Launch data retrieved")
            }) { error ->
            error.printStackTrace()
            Log.d(LOGTAG, "Request failed.")
        }
        addToRequestQueue(request)
        return responseData
    }

    /**
     * parses JSON data to model objects
     *
     * @param response : launch data as JSON string
     * @return list of launch data
     */
    private fun parseJSON(response: String?): List<Launch?> {
        Log.d(LOGTAG, "Parse method called.")
        val gson = GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
            .create()
        val listType = object : TypeToken<ArrayList<Launch?>?>() {}.type
        return gson.fromJson(response, listType)
    }

    companion object {
        @JvmStatic
        var launches: ArrayList<Launch?>? = null
            private set
        private val LOGTAG = LaunchesAdapter::class.java.name
    }
}