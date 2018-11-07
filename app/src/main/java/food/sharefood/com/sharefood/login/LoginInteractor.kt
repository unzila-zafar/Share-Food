package food.sharefood.com.sharefood.login

import android.content.Context
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.JsonRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import food.sharefood.com.sharefood.user.UserModel
import food.sharefood.com.sharefood.util.Constants
import org.json.JSONObject
import java.io.ObjectOutput
import java.util.*
import java.util.concurrent.ConcurrentHashMap

class LoginInteractor {

    private lateinit var listener: LoginFinishedListener

    interface LoginFinishedListener {
        fun loginSuccess(model: UserModel)
        fun loginFailure()
    }


    fun requestLoginUser(context: Context, loginId: String, password: String, finishedListener: LoginFinishedListener) {

        listener = finishedListener
        val queue = Volley.newRequestQueue(context)

        val request = object : StringRequest(
                Request.Method.POST,
                Constants.WebUrls.LOGIN,
                Response.Listener { response ->
                    println("response = $response")
                    //val responseObject = JSONObject(response)
                    //println("responseObject = $responseObject")
                },
                Response.ErrorListener { e ->
                    println("error = $e")
                    e.printStackTrace()
                    //listener.loginFailure()
                }
        ) {

            @Throws(AuthFailureError::class)

            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String, String>()
                params.put("loginId", "2")
                params.put("password", "123")

                return params
            }

            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers.put("Content-Type", "application/json; charset=utf-8")
                return headers
            }

        }
        request.retryPolicy = DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)

        println("request = $request")
        queue.add(request)

    }


    /*  override fun onServiceError(errorMessage: String) {

          listener.loginFailure()
      }

      override fun onServiceResponse(jsonString: String, tag: String) {

          if (jsonString != null) {
              val rootObject = JSONObject(jsonString)

              when (tag.equals(Constants.WebUrls.LOGIN)) {

                  //listener.loginSuccess(model)
              }

          }
      }*/


    //  var map: Map<String, String> = emptyMap()

    //  map = mapOf<String, String>(Constants.APIParams.LOGINID to loginId, Constants.APIParams.PASSWORD to password)

}