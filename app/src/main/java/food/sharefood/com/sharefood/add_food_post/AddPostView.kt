package food.sharefood.com.sharefood.add_food_post

import food.sharefood.com.sharefood.util.FoodSharePost

interface AddPostView {

    fun showProgress()
    fun hideProgress()
    fun onSuccess(foodSharePost: FoodSharePost)
    fun onFailure(message: String)
    fun selectImage(position: Int)
    fun setSelectedDateTime(dateTime : String)
    fun setSelectedLocation(location : String)

}