package food.sharefood.com.sharefood.util

import com.android.volley.Request
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty



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
        val LOGIN: String = "$BASE_URL/login",
        val GREETING: String = "$BASE_URL/greeting",
        val SIGNUP: String = "$BASE_URL/signup"
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
        var picture: String? = "" //this should be base64 data

       /* @JsonProperty(value = "facebookUrl")
        var facebookUrl: String? = "",

        @JsonProperty(value = "facebookId")
        var facebookId: String? = ""*/
) {
    override fun toString(): String {
        return "FoodSharer(loginId='$loginId', password='$password', name='$name', registeredAs='$registeredAs', address='$address', picture='$picture'"
    }
}

class APIParams
{
    companion object {
        var LOGIN_ID: String = "loginId"
        var PASSWORD: String = "password"
        var NAME: String = "name"
        var REGISTERED_AS : String = "registeredAs"
        var PICTURE: String = "picture"
        var ADDRESS: String ="address"
    }
}