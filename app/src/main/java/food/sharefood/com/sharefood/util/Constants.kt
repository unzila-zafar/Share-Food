package food.sharefood.com.sharefood.util

import com.android.volley.Request
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import food.sharefood.com.sharefood.R.string.address
import food.sharefood.com.sharefood.R.string.phone_number
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
        val GETPOST: String = "$BASE_URL/post/foodSharePost"


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
        @JsonProperty(value = "name")
        var name: String = "",

        @JsonProperty(value = "email")
        var email: String = "",

        @JsonProperty(value = "phone")
        var phone_number: String,

        @JsonProperty(value = "sufficientFor")
        var sufficientFor: String,

        @JsonProperty(value = "pickUntilTime")
        var pickUntilTime: String? = "",

        @JsonProperty(value = "foodPickupLocation")
        var foodPickupLocation: String? = "",

        @JsonProperty(value = "foodItems")
        var foodItems: String,

        @JsonProperty(value = "postPictures")
        var postPictures: ArrayList<String>? = null,

        @JsonProperty(value = "token")
        var token: String? = "",

        @JsonProperty(value = "tokenStartTime")
        var tokenStartTime: Long? = null,

        @JsonProperty(value = "tokenExpiryTime")
        var tokenExpiryTime: Long? = null


){
    override fun toString(): String {
        return "FoodSharerPost(name='$name', email='$email', foodPickupLocation='$foodPickupLocation', phone_number='$phone_number', sufficientFor='$sufficientFor', pickUntilTime='$pickUntilTime', foodItems='$foodItems', postPictures='$postPictures'"
    }
}

class IntArrayWrapper(size: Int,
                      val setterObs : ((index: Int, value: Int) -> Unit)? = null){
    val field = IntArray(size)
    val size
        get() = field.size
    operator fun iterator() = field.iterator()

    operator fun get(i: Int) : Int {
        return field[i]
    }
    operator fun set(i: Int, value: Int){
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
        var EMAIL = "email"
        var PICKUP_LOCATION = "foodPickupLocation"
        var PICKUP_TIME = "pickUntilTime"
        var FOOD_ITEMS = "foodItems"
        var PHONE = "phone"
        var SUFFICIENT_FOR = "sufficientFor"
    }
}

class SharedPrefKeys
{
    companion object {
        var LOGGED_IN = "login"
        var TOKEN = "token"
        var TOKENSTART = "token_start"
        var TOKENEND = "token_end"
    }
}