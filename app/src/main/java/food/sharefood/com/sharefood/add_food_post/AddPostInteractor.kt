package food.sharefood.com.sharefood.add_food_post

import android.content.Context
import com.fasterxml.jackson.databind.ObjectMapper
import food.sharefood.com.sharefood.network.ServiceInterface
import food.sharefood.com.sharefood.network.VolleyClass
import food.sharefood.com.sharefood.util.*
import org.json.JSONObject

class AddPostInteractor : ServiceInterface
{
    private lateinit var listener: AddPostFinishedListener

    interface AddPostFinishedListener {

        fun onPostSuccess()
        fun onPostError()

    }


    fun requestAddPost(context: Context, foodSharePost: FoodSharePost, finishedListener: AddPostFinishedListener) {
        listener = finishedListener

        val objectMapper = ObjectMapper()
        val data = objectMapper.convertValue(LoginData(), JSONObject::class.java)
        data.put(APIParams.NAME, foodSharePost.name)
        data.put(APIParams.EMAIL, foodSharePost.email)
        data.put(APIParams.PHONE, foodSharePost.phone_number)
        data.put(APIParams.PICKUP_LOCATION , foodSharePost.foodPickupLocation)
        data.put(APIParams.PICKUP_TIME , foodSharePost.pickUntilTime)
        data.put(APIParams.FOOD_ITEMS , foodSharePost.foodItems)
        data.put(APIParams.SUFFICIENT_FOR , foodSharePost.sufficientFor)
        data.put(APIParams.PICTURE , foodSharePost.postPictures)
        data.put(APIParams.TOKEN , AppSharedPref.getData(SharedPrefKeys.TOKEN, AppSharedPref.STRING, context))

        println("data === $data")

        VolleyClass.getInstance(context).createPostRequest(WebUrls().GETPOST, RequestMethods().POST, data, this, WebUrls().GREETING)

    }


    override fun onServiceResponse(jsonString: String, tag: String)
    {
    }

    override fun onServiceError(errorMessage: String) {
    }
}