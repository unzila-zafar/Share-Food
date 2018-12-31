package food.sharefood.com.sharefood.main

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.fasterxml.jackson.databind.ObjectMapper
import food.sharefood.com.sharefood.R
import food.sharefood.com.sharefood.network.ServiceInterface
import food.sharefood.com.sharefood.network.VolleyClass
import food.sharefood.com.sharefood.network.VolleyClass.Companion.context
import food.sharefood.com.sharefood.util.*
import org.json.JSONArray
import org.json.JSONObject

class MainInteractor : ServiceInterface {


    val food_description = arrayOf("abcd", "abcd", "abcd")
    val food_quatity = arrayOf("2kg", "10kg", "15kg")
    val food_time = arrayOf("2:39am", "5:30 pm", "4:00 pm")
    val food_location = arrayOf("islamabad", "karachi", "lahore")
    val food_pic = arrayOf(R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background)
    val food_menu_items = arrayOf("Chinese", "Italian Food", "Pizza")

    //TODO its list so name should not be array
    var food_post_array: MutableList<FoodPostModel> = ArrayList()

    lateinit var listener: OnFinishedListener

    interface OnFinishedListener {
        fun onResultSuccess(arrFoodList: List<FoodSharePost>)
        fun onResultFail(strError: String)
    }


    fun requestData(context: Context, finishedListener: OnFinishedListener) {
        listener = finishedListener

        val map: HashMap<String, String> = HashMap()
        /* val objectMapper = ObjectMapper()
         val data = objectMapper.convertValue(LoginData(), JSONObject::class.java)
         data.put(APIParams.TOKEN, AppSharedPref.getData(SharedPrefKeys.TOKEN, AppSharedPref.STRING, context))

         println("Request to send = ${WebUrls().GET_FOOD_SHARE_POSTS}")
         println("data = ${data}")*/

        map.put(APIParams.TOKEN, AppSharedPref.getData(SharedPrefKeys.TOKEN, AppSharedPref.STRING, context).toString())
        VolleyClass.getInstance(context).createRequest(WebUrls().GET_FOOD_SHARE_POSTS, RequestMethods().POST, map, this, WebUrls().GET_FOOD_SHARE_POSTS)

    }

    fun requestSearch(context: Context, foodSharePost: FoodSharePost, finishedListener: OnFinishedListener) {
        listener = finishedListener

        val map: HashMap<String, String> = HashMap()
        val objectMapper = ObjectMapper()
        val data = objectMapper.convertValue(FoodSharePost(), JSONObject::class.java)
        data.put(APIParams.NAME, foodSharePost.name)
        data.put(APIParams.EMAIL, foodSharePost.email)
        data.put(APIParams.PHONE, foodSharePost.phone_number)
        data.put(APIParams.PICKUP_LOCATION, foodSharePost.foodPickupLocation)
        data.put(APIParams.PICKUP_TIME, foodSharePost.pickUntilTime)
        data.put(APIParams.FOOD_ITEMS, foodSharePost.foodItems)
        data.put(APIParams.SUFFICIENT_FOR, foodSharePost.sufficientFor)
        map.put(APIParams.TOKEN, AppSharedPref.getData(SharedPrefKeys.TOKEN, AppSharedPref.STRING, context).toString())
        VolleyClass.getInstance(context).createRequest(WebUrls().SEARCH_ANY_FOOD_POST, RequestMethods().POST, map, this, WebUrls().SEARCH_ANY_FOOD_POST)

    }

    override fun onServiceResponse(jsonString: String, tag: String) {
        println("onServiceResponse:: $jsonString")

        if (jsonString != null) {
            val rootObject = JSONArray(jsonString)
            println("rootObject === $rootObject")

            if (tag.equals(WebUrls().GET_FOOD_SHARE_POSTS)) {
                listener.onResultSuccess(Helper.setFoodPostData(rootObject))
            }
            if(tag.equals(WebUrls().SEARCH_ANY_FOOD_POST))
            {
                listener.onResultSuccess(Helper.setFoodPostData(rootObject))
            }
        }

    }

    override fun onServiceError(errorMessage: String) {
        listener.onResultFail(errorMessage)
    }


}