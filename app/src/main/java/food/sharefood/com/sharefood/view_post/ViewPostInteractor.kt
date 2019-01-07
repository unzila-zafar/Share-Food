package food.sharefood.com.sharefood.view_post

import android.content.Context
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import food.sharefood.com.sharefood.network.ServiceInterface
import food.sharefood.com.sharefood.network.VolleyClass
import food.sharefood.com.sharefood.util.*
import org.json.JSONArray
import org.json.JSONObject
import java.util.*

class ViewPostInteractor : ServiceInterface {
    private lateinit var listener: ViewPostInterface


    interface ViewPostInterface {
        fun deletePostSuccess()
        fun deletePostFailure()

    }


    fun requestDeletePost(context: Context, foodSharePost: FoodSharePost, viewListener: ViewPostInterface) {
        listener = viewListener

        val objectMapper = ObjectMapper()
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        val data = objectMapper.convertValue(FoodSharePost(), JSONObject::class.java)
        data.put(APIParams._ID, foodSharePost._id)
        data.put(APIParams.NAME, AppSharedPref.getData(SharedPrefKeys.NAME, AppSharedPref.STRING, context))
        data.put(APIParams.EMAIL, AppSharedPref.getData(SharedPrefKeys.EMAIL, AppSharedPref.STRING, context))
        data.put(APIParams.PHONE, foodSharePost.phone_number)
        data.put(APIParams.PICKUP_LOCATION, foodSharePost.foodPickupLocation)
        data.put(APIParams.PICKUP_TIME, foodSharePost.pickUntilTime)
        data.put(APIParams.FOOD_ITEMS, foodSharePost.foodItems)
        data.put(APIParams.SUFFICIENT_FOR, foodSharePost.sufficientFor)
        val postPictures = JSONArray(foodSharePost.postPictures)
        data.put(APIParams.POST_PICTURES, postPictures)
        val creationDate = Date()
        data.put(APIParams.POST_CREATION_TIME, creationDate)
        data.put(APIParams.TOKEN, AppSharedPref.getData(SharedPrefKeys.TOKEN, AppSharedPref.STRING, context))

        println("data = $data")

        VolleyClass.getInstance(context).createPostRequest(WebUrls().DELETE_FOOD_POST, RequestMethods().DELETE, data, this, WebUrls().DELETE_FOOD_POST)


    }

    override fun onServiceResponse(jsonString: String, tag: String) {
        if (jsonString != null) {
            var rootObject = JSONObject(jsonString)

            when (tag) {
                WebUrls().DELETE_FOOD_POST ->
                    listener.deletePostSuccess()

              /*  WebUrls().NEW_FOOD_SHARE_POST ->
                    listener.editPostSuccess()*/

            }


        }
    }

    override fun onServiceError(errorMessage: String) {

        listener.deletePostFailure()
    }

}