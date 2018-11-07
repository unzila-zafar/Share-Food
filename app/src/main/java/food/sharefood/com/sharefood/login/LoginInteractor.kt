package food.sharefood.com.sharefood.login

import android.content.Context
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import food.sharefood.com.sharefood.network.ServiceInterface
import food.sharefood.com.sharefood.user.UserModel
import food.sharefood.com.sharefood.util.Constants
import org.json.JSONObject

class LoginInteractor {

    private lateinit var listener: LoginFinishedListener

    interface LoginFinishedListener {
        //fun loginSuccess(model: UserModel)
        fun loginSuccess()

        fun loginFailure()
    }


    fun requestLoginUser(context: Context, loginId: String, password: String, finishedListener: LoginFinishedListener) {

        listener = finishedListener
        val queue = Volley.newRequestQueue(context)

        val stringRequest = object : StringRequest(Request.Method.POST, Constants.WebUrls.LOGIN, Response.Listener { jsonString ->
            val rootObject = JSONObject(jsonString)

            listener.loginSuccess()

        }, Response.ErrorListener { e ->
            listener.loginSuccess()
        }) {
            override fun getParams(): Map<String, String> = mapOf<String, String>(Constants.APIParams.LOGINID to loginId, Constants.APIParams.PASSWORD to password)

            override fun getHeaders(): Map<String, String> {
                val headers = HashMap<String, String>()
                headers.put("Content-Type", "application/json")
                return headers
            }
        }

        stringRequest.retryPolicy = DefaultRetryPolicy(60000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)

        queue.add(stringRequest)

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