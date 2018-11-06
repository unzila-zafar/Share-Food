package food.sharefood.com.sharefood.util

import food.sharefood.com.sharefood.util.Constants.WebUrls.Companion.BASE_URL

class Constants
{

    public class WebUrls
    {
        companion object {
            public const val BASE_URL: String = "https://foodshareservice.herokuapp.com/";
            public const val LOGIN: String = BASE_URL + "greeting"

        }



    }


    public class APIParams
    {
        companion object {
            public const val ID: String = "_id"
            public const val LOGINID:String = "loginId"
            public const val PASSWORD:String = "password"
        }

    }
}