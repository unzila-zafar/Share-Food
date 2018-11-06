package food.sharefood.com.sharefood.network

import org.json.JSONObject

interface ServiceInterface {

    //fun post(path: String, params: JSONObject, completionHandler: (response: JSONObject?) -> Unit)
    fun onServiceResponse(jsonString: String, tag: String)
    fun onServiceError(errorMessage: String)
}