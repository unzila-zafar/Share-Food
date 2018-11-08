package food.sharefood.com.sharefood.network

import android.content.Context
import android.text.TextUtils
import com.android.volley.*
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlin.reflect.KClass

class VolleyClass {

    companion object {
        private val TAG = VolleyClass::class.java!!.getSimpleName()
        var instance: VolleyClass? = null
        lateinit var context: Context
        lateinit var requestQueue: RequestQueue



        fun  getInstance(mContext: Context): VolleyClass {
            context = mContext
            if (instance == null)  // NOT thread safe!
                instance = VolleyClass()

            return instance!!
        }


    }

   /* fun VolleyClass(mContext: Context) {
        context = mContext;
        requestQueue = getRequestQueue()

    }

    fun getRequestQueue(): RequestQueue {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext())
        }
        return requestQueue
    }*/


    val requestQueue: RequestQueue? = null
        get() {
            if (field == null) {
                return Volley.newRequestQueue(context)
            }
            return field
        }

 /*   @Synchronized
    public fun getInstance(context: Context): VolleyClass {
        if (instance == null) {
            instance = VolleyClass()
        }
        return instance
    }*/


    fun <T> addToRequestQueue(request: Request<T>, tag: String) {
        request.tag = if (TextUtils.isEmpty(tag)) TAG else tag
        requestQueue?.add(request)
    }

    fun <T> addToRequestQueue(request: Request<T>) {
        requestQueue?.add(request)
    }


    fun createRequest(url: String, requestMethod: Int, map: Map<String, String>, listener: ServiceInterface, tag: String) {

        val stringRequest = object : StringRequest(requestMethod, url, Response.Listener { s ->
            // Your success code here
            listener.onServiceResponse(s, tag)

        }, Response.ErrorListener { error ->
            // Your error code here
            if (error is AuthFailureError) {
                listener.onServiceError("Authentication Error")
            } else if (error is NetworkError) {
                listener.onServiceError("Please check your internet connection")

            } else if (error is ParseError) {
                listener.onServiceError("Parse error.")

            } else if (error is ServerError) {

                //String json = null;
                val response = error.networkResponse
                if ((response != null) and (response!!.data != null)) {
                    listener.onServiceError("Server error. Please try again later")
                } else {
                    listener.onServiceError("Server error. Please try again later")
                }

            } else if (error is TimeoutError) {
                listener.onServiceError("Server Timeout. Please try again later")
            }

        }) {
            override fun getParams(): Map<String, String> = map

            override fun getHeaders(): Map<String, String> {
                val headers = HashMap<String, String>()
                headers.put("Content-Type", "application/json; charset=utf8")
                return headers
            }
        }

        stringRequest.retryPolicy = DefaultRetryPolicy(60000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)


        if (tag != null && tag != "") {
            addToRequestQueue<String>(stringRequest, tag)
        } else {
            addToRequestQueue<String>(stringRequest)
        }


    }
}