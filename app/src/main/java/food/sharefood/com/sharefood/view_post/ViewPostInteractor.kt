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

        val map: HashMap<String, String> = HashMap()
        val objectMapper = ObjectMapper()
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        val data = objectMapper.convertValue(FoodSharePost(), JSONObject::class.java)
        map.put(APIParams._ID, foodSharePost._id.toString())
        map.put(APIParams.NAME, AppSharedPref.getData(SharedPrefKeys.NAME, AppSharedPref.STRING, context).toString())
        map.put(APIParams.EMAIL, AppSharedPref.getData(SharedPrefKeys.EMAIL, AppSharedPref.STRING, context).toString())
        map.put(APIParams.PHONE, foodSharePost.phone_number.toString())
        map.put(APIParams.PICKUP_LOCATION, foodSharePost.foodPickupLocation.toString())
        map.put(APIParams.PICKUP_TIME, foodSharePost.pickUntilTime.toString())
        map.put(APIParams.FOOD_ITEMS, foodSharePost.foodItems.toString())
        map.put(APIParams.SUFFICIENT_FOR, foodSharePost.sufficientFor.toString())
        val postPictures = JSONArray(foodSharePost.postPictures)
        map.put(APIParams.POST_PICTURES, postPictures.toString())
        val creationDate = Date()
        map.put(APIParams.POST_CREATION_TIME, creationDate.toString())
        map.put(APIParams.TOKEN, AppSharedPref.getData(SharedPrefKeys.TOKEN, AppSharedPref.STRING, context).toString())

        println("data = $data")

        VolleyClass.getInstance(context).createRequest(WebUrls().DELETE_FOOD_POST, RequestMethods().DELETE, map, this, WebUrls().DELETE_FOOD_POST)


    }

    override fun onServiceResponse(jsonString: String, tag: String) {
        if (jsonString != null) {
            var rootObject = jsonString

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