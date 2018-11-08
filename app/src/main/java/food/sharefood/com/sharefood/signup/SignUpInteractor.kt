package food.sharefood.com.sharefood.signup

import android.content.Context
import com.fasterxml.jackson.databind.ObjectMapper
import food.sharefood.com.sharefood.network.ServiceInterface
import food.sharefood.com.sharefood.network.VolleyClass
import food.sharefood.com.sharefood.user.UserModel
import food.sharefood.com.sharefood.util.LoginData
import food.sharefood.com.sharefood.util.RequestMethods
import food.sharefood.com.sharefood.util.SignupData
import food.sharefood.com.sharefood.util.WebUrls
import org.json.JSONObject

class SignUpInteractor : ServiceInterface {


    private lateinit var model: UserModel
    private lateinit var listener: onSignUpFinishedListener

    interface onSignUpFinishedListener {
        fun onSignUpSuccess(model: UserModel)
        fun onSignUpFailure(message :String)
        fun onSignUpSuccess()
    }


    fun requestSignUpUser(context: Context,finishedListener: onSignUpFinishedListener) {

        listener = finishedListener

        val objectMapper = ObjectMapper()
        val data = objectMapper.convertValue(SignupData(), JSONObject::class.java)
        //data.put("loginId", loginId)
        //data.put("password", password)

        println("data === $data")

        VolleyClass.getInstance(context).createPostRequest(WebUrls().SIGNUP, RequestMethods().POST, data, this, WebUrls().SIGNUP)
    }

    override fun onServiceResponse(jsonString: String, tag: String) {

        /*if (jsonString != null) {
            val rootObject = JSONObject(jsonString)

            if (tag.equals(Constants.WebUrls.LOGIN)) {

                listener.onSignUpSuccess()
            }
        }*/
    }

    override fun onServiceError(errorMessage: String) {
        listener.onSignUpFailure(errorMessage)
    }
}