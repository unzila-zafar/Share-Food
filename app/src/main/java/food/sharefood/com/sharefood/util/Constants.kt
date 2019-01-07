package food.sharefood.com.sharefood.util

import com.android.volley.Request
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import food.sharefood.com.sharefood.R.string.*
import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList


@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class LoginData(
        @JsonProperty("loginId")
        var loginId: String = "",

        @JsonProperty(value = "password")
        var password: String = "") {
    override fun toString(): String {
        return "LoginData(loginId='$loginId', password='$password')"
    }
}


data class WebUrls(
        val BASE_URL: String = "https://foodshareservice.herokuapp.com",
        val LOGIN: String = "$BASE_URL/user/login",
        val GREETING: String = "$BASE_URL/user/greeting",
        val SIGNUP: String = "$BASE_URL/user/signup",
        val NEW_FOOD_SHARE_POST: String = "$BASE_URL/posts/addFoodSharePost",
        val GET_FOOD_SHARE_POSTS: String = "$BASE_URL/posts/allFoodSharePosts",
        val DELETE_FOOD_POST: String = "$BASE_URL/posts/deleteFoodSharePost",
        val SEARCH_ANY_FOOD_POST: String = "$BASE_URL/posts/searchAnyFoodSharePost",
        val SEARCH_EXACT_FOOD_POST: String = "$BASE_URL/posts/searchExactFoodSharePost"


)


data class RequestMethods(
        val POST: Int = Request.Method.POST,
        val GET: Int = Request.Method.GET,
        val PUT: Int = Request.Method.PUT,
        val DELETE: Int = Request.Method.DELETE
)

@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class FoodSharer(
        @JsonProperty("loginId")
        var loginId: String = "",

        @JsonProperty(value = "password")
        var password: String = "",

        @JsonProperty(value = "name")
        var name: String = "",

        @JsonProperty(value = "registeredAs")
        var registeredAs: String? = "",

        @JsonProperty(value = "address")
        var address: String? = "",

        @JsonProperty(value = "picture")
        var picture: String? = "",

        @JsonProperty(value = "token")
        var token: String? = "",

        @JsonProperty(value = "tokenStartTime")
        var tokenStartTime: Long? = null,

        @JsonProperty(value = "tokenExpiryTime")
        var tokenExpiryTime: Long? = null

) {
    override fun toString(): String {
        return "FoodSharer(loginId='$loginId', password='$password', name='$name', registeredAs='$registeredAs', address='$address', picture='$picture'"
    }
}

@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class FoodSharePost(

        @JsonProperty(value = "_id")
        var _id: String? = "",

        @JsonProperty(value = "name")
        var name: String? = "",

        @JsonProperty(value = "email")
        var email: String? = "",

        @JsonProperty(value = "phone")
        var phone_number: String? = "",

        @JsonProperty(value = "sufficientFor")
        var sufficientFor: String? = "",

        @JsonProperty(value = "pickUntilTime")
        var pickUntilTime: String? = "",

        @JsonProperty(value = "foodPickupLocation")
        var foodPickupLocation: String? = "",

        @JsonProperty(value = "foodItems")
        var foodItems: String? = "",

        @JsonProperty(value = "postPictures")
        var postPictures: ArrayList<String>? = ArrayList(),

        @JsonProperty(value = "token")
        var token: String? = "",

        @JsonProperty(value = "tokenStartTime")
        var tokenStartTime: Long? = null,

        @JsonProperty(value = "tokenExpiryTime")
        var tokenExpiryTime: Long? = null,

        @JsonProperty(value = "postCreationTime")
        var postCreationTime: String? = "",

        @JsonProperty(value = "comments")
        var comments: ArrayList<String>? = ArrayList(),

        @JsonProperty(value = "shares")
        var shares: ArrayList<String>? = ArrayList(),

        @JsonProperty(value = "likes")
        var likes: ArrayList<String>? = ArrayList(),

        @JsonProperty(value = "longitude")
        var longitude: String? = "",

        @JsonProperty(value = "latitude")
        var latitude: String? = "",

        @JsonProperty(value = "noOfTimesPostSeen")
        var noOfTimesPostSeen: String? = "",

        @JsonProperty(value = "viewedBy")
        var viewedBy: ArrayList<String>? = ArrayList()


) : Serializable {
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return "FoodSharePost(_id=$_id, name=$name, email=$email, phone_number=$phone_number, sufficientFor=$sufficientFor, pickUntilTime=$pickUntilTime, foodPickupLocation=$foodPickupLocation, foodItems=$foodItems, postPictures=$postPictures, token=$token, tokenStartTime=$tokenStartTime, tokenExpiryTime=$tokenExpiryTime, postCreationTime=$postCreationTime, comments=$comments, shares=$shares, likes=$likes, longitude=$longitude, latitude=$latitude, noOfTimesPostSeen=$noOfTimesPostSeen, viewedBy=$viewedBy)"
    }
}

class IntArrayWrapper(size: Int,
                      val setterObs: ((index: Int, value: Int) -> Unit)? = null) {
    val field = IntArray(size)
    val size
        get() = field.size

    operator fun iterator() = field.iterator()

    operator fun get(i: Int): Int {
        return field[i]
    }

    operator fun set(i: Int, value: Int) {
        field[i] = value
        setterObs?.invoke(i, value)
    }
}


class APIParams {
    companion object {
        var LOGIN_ID: String = "loginId"
        var PASSWORD: String = "password"
        var NAME: String = "name"
        var REGISTERED_AS: String = "registeredAs"
        var PICTURE: String = "picture"
        var ADDRESS: String = "address"
        var TOKEN = "token"
        var TOKEN_START = "tokenStartTime"
        var TOKEN_END = "tokenExpiryTime"

        /*add post*/
        var _ID = "_id"
        var EMAIL = "email"
        var PICKUP_LOCATION = "foodPickupLocation"
        var PICKUP_TIME = "pickUntilTime"
        var FOOD_ITEMS = "foodItems"
        var PHONE = "phone"
        var SUFFICIENT_FOR = "sufficientFor"
        var PHONE_NUMBER = "phone_number"
        var POST_PICTURES: String = "postPictures"
        var POST_CREATION_TIME: String = "postCreationTime"
        var LATITUDE = "latitude"
        var LONGITUDE = "longitude"
    }
}

class SharedPrefKeys {
    companion object {
        var LOGGED_IN = "login"
        var TOKEN = "token"
        var TOKENSTART = "token_start"
        var TOKENEND = "token_end"
        var NAME = "name"
        var EMAIL = "email"
    }
}

class Extras {
    companion object {
        var FOOD_MODEL = "food_model"
        var LATITUDE_VALUE = "latitude"
        var LONGITUDE_VALUE = "longitude"
        var ADD_POST_DATA = 1
        var REFRESH_POSTS_DATA = "refresh_posts"
        var Set_EDIT_POST_DATA = "edit_data"
        var GET_EDIT_POST_DATA = "get_data"
        var EDIT_POST_RESPONSE = 2
        var IS_FROM_HOME = "is_from_home"
        var IMAGE_PATH = "image_path"
    }
}

data class FoodPostArrays(

        var foodSharePostArray: ArrayList<FoodSharePost>? = null


)

