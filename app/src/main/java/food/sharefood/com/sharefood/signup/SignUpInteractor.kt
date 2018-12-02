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
    private lateinit var foodSharer: FoodSharer

    interface onSignUpFinishedListener {
        fun onSignUpSuccess(foodSharer: FoodSharer)
        fun onSignUpFailure(message: String)
        fun onSignUpSuccess()
    }


    fun requestSignUpUser(context: Context, finishedListener: onSignUpFinishedListener, foodSharer: FoodSharer) {


        listener = finishedListener

        val objectMapper = ObjectMapper()
        val data = objectMapper.convertValue(FoodSharer(), JSONObject::class.java)
        data.put(APIParams.LOGIN_ID, foodSharer.loginId)
        data.put(APIParams.PASSWORD, foodSharer.password)
        data.put(APIParams.NAME, foodSharer.name)
        data.put(APIParams.REGISTERED_AS, foodSharer.registeredAs)
        data.put(APIParams.PICTURE, foodSharer.picture)
        data.put(APIParams.ADDRESS, foodSharer.address)
        data.put(APIParams.TOKEN, foodSharer.token)
        data.put(APIParams.TOKEN_START, foodSharer.tokenStartTime.toString())
        data.put(APIParams.TOKEN_END, foodSharer.tokenExpiryTime.toString())


        println("data === $data")


        VolleyClass.getInstance(context).createPostRequest(WebUrls().SIGNUP, RequestMethods().POST, data, this, WebUrls().SIGNUP)
    }

    override fun onServiceResponse(jsonString: String, tag: String) {

        if (jsonString != null) {
            val rootObject = JSONObject(jsonString)

            if (tag.equals(WebUrls().SIGNUP)) {

                if (rootObject != null) {
                    setUserData(rootObject)

                    listener.onSignUpSuccess(foodSharer)
                }


            }
        }
    }

    override fun onServiceError(errorMessage: String) {
        listener.onSignUpFailure(errorMessage)
    }


    private fun setUserData(rootObject: JSONObject) {
        foodSharer = FoodSharer()

        if (rootObject.has(APIParams.LOGIN_ID) && !rootObject.isNull(APIParams.LOGIN_ID)) {
            foodSharer.loginId = rootObject.getString(APIParams.LOGIN_ID)
        }

        if (rootObject.has(APIParams.NAME) && !rootObject.isNull(APIParams.NAME)) {
            foodSharer.name = rootObject.getString(APIParams.NAME)
        }

        if (rootObject.has(APIParams.ADDRESS) && !rootObject.isNull(APIParams.ADDRESS)) {
            foodSharer.address = rootObject.getString(APIParams.ADDRESS)
        }

        if (rootObject.has(APIParams.REGISTERED_AS) && !rootObject.isNull(APIParams.REGISTERED_AS)) {
            foodSharer.registeredAs = rootObject.getString(APIParams.REGISTERED_AS)
        }

        if (rootObject.has(APIParams.PICTURE) && !rootObject.isNull(APIParams.PICTURE)) {
            foodSharer.picture = rootObject.getString(APIParams.PICTURE)
        }

        if(rootObject.has(APIParams.TOKEN) && !rootObject.isNull(APIParams.TOKEN))
        {
            foodSharer.token = rootObject.getString(APIParams.TOKEN)

        }
    }
}