package food.sharefood.com.sharefood.util

import food.sharefood.com.sharefood.util.Constants.WebUrls.Companion.BASE_URL

class Constants {

    class WebUrls {
        companion object {
            const val BASE_URL = "https://foodshareservice.herokuapp.com";
            const val LOGIN = "$BASE_URL/login"
            const val GREETING = "$BASE_URL/greeting"

        }
    }


    //TODO Review
    //TODO Please follow formatting of IDE ,its much better and more readable than adding { on new line
    //TODO Make data class ,its much better

    class APIParams {
        companion object {
            const val LOGINID = "loginId"
            const val PASSWORD = "password"
        }

    }
}