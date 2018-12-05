package food.sharefood.com.sharefood.login

import android.content.Context
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.convertValue
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import food.sharefood.com.sharefood.network.ServiceInterface
import food.sharefood.com.sharefood.network.VolleyClass
import food.sharefood.com.sharefood.util.*
import org.json.JSONObject


class LoginInteractor : ServiceInterface {

    private lateinit var listener: LoginFinishedListener

    interface LoginFinishedListener {
        fun loginSuccess(foodSharer: FoodSharer)
        fun loginFailure()
    }


    fun requestLoginUser(context: Context, loginId: String, password: String, finishedListener: LoginFinishedListener) {

        listener = finishedListener

        val objectMapper = ObjectMapper()
        val data = objectMapper.convertValue(LoginData(), JSONObject::class.java)
        data.put(APIParams.LOGIN_ID, loginId)
        data.put(APIParams.PASSWORD, password)

        println("data === $data")

        VolleyClass.getInstance(context).createPostRequest(WebUrls().LOGIN, RequestMethods().POST, data, this, WebUrls().LOGIN)

    }


    override fun onServiceResponse(jsonString: String, tag: String) {

        if (jsonString != null) {
            val rootObject = JSONObject(jsonString)

            if (tag.equals(WebUrls().LOGIN)) {

                listener.loginSuccess(Helper.setUserData(rootObject))
            }
        }
    }

    override fun onServiceError(errorMessage: String) {
        listener.loginFailure()

    }

}