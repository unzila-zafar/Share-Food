package food.sharefood.com.sharefood.add_food_post

import android.content.Context
import com.fasterxml.jackson.databind.ObjectMapper
import food.sharefood.com.sharefood.network.ServiceInterface
import food.sharefood.com.sharefood.network.VolleyClass
import food.sharefood.com.sharefood.util.*
import org.json.JSONObject

class AddPostInteractor : ServiceInterface {
    private lateinit var listener: AddPostFinishedListener

    interface AddPostFinishedListener {

        fun onPostSuccess(foodSharePost: FoodSharePost)
        fun onPostError(message: String)

    }


    fun requestAddPost(context: Context, foodSharePost: FoodSharePost, finishedListener: AddPostFinishedListener) {
        listener = finishedListener

        val objectMapper = ObjectMapper()
        val data = objectMapper.convertValue(LoginData(), JSONObject::class.java)
        data.put(APIParams.NAME, AppSharedPref.getData(SharedPrefKeys.NAME, AppSharedPref.STRING, context))
        data.put(APIParams.EMAIL, AppSharedPref.getData(SharedPrefKeys.EMAIL, AppSharedPref.STRING, context))
        data.put(APIParams.PHONE, foodSharePost.phone_number)
        data.put(APIParams.PICKUP_LOCATION, foodSharePost.foodPickupLocation)
        data.put(APIParams.PICKUP_TIME, foodSharePost.pickUntilTime)
        data.put(APIParams.FOOD_ITEMS, foodSharePost.foodItems)
        data.put(APIParams.SUFFICIENT_FOR, foodSharePost.sufficientFor)
        data.put(APIParams.PICTURE, foodSharePost.postPictures)
        data.put(APIParams.TOKEN, AppSharedPref.getData(SharedPrefKeys.TOKEN, AppSharedPref.STRING, context))

        VolleyClass.getInstance(context).createPostRequest(WebUrls().NEW_FOOD_SHARE_POST, RequestMethods().POST, data, this, WebUrls().NEW_FOOD_SHARE_POST)

    }

    override fun onServiceResponse(jsonString: String, tag: String) {
        if (jsonString != null) {
            var rootObject = JSONObject(jsonString)

            listener.onPostSuccess(Helper.addFoodPostData(rootObject))

        }
    }

    override fun onServiceError(errorMessage: String) {
        listener.onPostError(errorMessage)
    }
}