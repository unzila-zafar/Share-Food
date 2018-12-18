package food.sharefood.com.sharefood.view_post

import food.sharefood.com.sharefood.databinding.ActivityViewFoodPostBinding
import food.sharefood.com.sharefood.util.FoodSharePost

interface PostView {

   // fun showPostData(binding: ActivityViewFoodPostBinding, foodData: FoodSharePost)
    fun deletePost()
    fun editPost()
    fun showProgress()
    fun hideProgress()
}