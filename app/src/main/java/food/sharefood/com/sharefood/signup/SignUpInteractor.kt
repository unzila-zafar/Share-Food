package food.sharefood.com.sharefood.signup

import android.content.Context
import food.sharefood.com.sharefood.network.ServiceInterface
import food.sharefood.com.sharefood.user.UserModel

class SignUpInteractor : ServiceInterface {


    private lateinit var model: UserModel
    private lateinit var listener: onSignUpFinishedListener

    interface onSignUpFinishedListener {
        fun onSignUpSuccess(model: UserModel)
        fun onSignUpFailure(message :String)
        fun onSignUpSuccess()
    }


    fun requestSignUpUser(context: Context,finishedListener: onSignUpFinishedListener) {
        //TODO
        listener = finishedListener


        var map: Map<String, String> = emptyMap()

       /* map = mapOf<String, String>(Constants.APIParams.LOGINID to "12", Constants.APIParams.PASSWORD to "123")

        //var volleyInstance: VolleyClass = VolleyClass()

        VolleyClass.getInstance(context).createRequest(Constants.WebUrls.LOGIN, Request.Method.POST, map, this, Constants.WebUrls.LOGIN)
*/
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