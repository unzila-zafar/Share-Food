package food.sharefood.com.sharefood.signup

import android.content.Context
import com.fasterxml.jackson.databind.ObjectMapper
import food.sharefood.com.sharefood.network.ServiceInterface
import food.sharefood.com.sharefood.network.VolleyClass
import food.sharefood.com.sharefood.user.UserModel
import food.sharefood.com.sharefood.util.*
import org.json.JSONObject

class SignUpInteractor : ServiceInterface {


    private lateinit var model: UserModel
    private lateinit var listener: onSignUpFinishedListener

    interface onSignUpFinishedListener {
        fun onSignUpSuccess(model: UserModel)
        fun onSignUpFailure(message: String)
        fun onSignUpSuccess()
    }


    fun requestSignUpUser(context: Context, finishedListener: onSignUpFinishedListener) {

        listener = finishedListener

        val objectMapper = ObjectMapper()
        val data = objectMapper.convertValue(FoodSharer(), JSONObject::class.java)
        println("FoodSharer() = " + FoodSharer())
        data.put("loginId", FoodSharer().loginId)
        data.put("password", FoodSharer().password)
        data.put("name", FoodSharer().name)
        data.put("registeredAs", FoodSharer().registeredAs)
        data.put("picture", FoodSharer().picture)
        data.put("address", FoodSharer().address)


        println("data === $data")

        VolleyClass.getInstance(context).createPostRequest(WebUrls().SIGNUP, RequestMethods().POST, data, this, WebUrls().SIGNUP)
    }

    override fun onServiceResponse(jsonString: String, tag: String) {

        if (jsonString != null) {
            val rootObject = JSONObject(jsonString)

            if (tag.equals(WebUrls().SIGNUP)) {

                listener.onSignUpSuccess()
            }
        }
    }

    override fun onServiceError(errorMessage: String) {
        listener.onSignUpFailure(errorMessage)
    }
}