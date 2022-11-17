package com.example.thelistcompany

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

object RequestService {
    private var instance: RequestQueue? = null
    fun getInstance(context: Context): RequestQueue {
        if (instance == null) {
            instance = Volley.newRequestQueue(context.applicationContext)
        }
        return instance!!
    }

    fun <T> addToRequestQueue(req: Request<T>?) {
        if (instance != null) instance!!.add(req)
    }

}
