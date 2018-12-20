package food.sharefood.com.sharefood.view_post

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import food.sharefood.com.sharefood.add_food_post.AddPostActivity
import food.sharefood.com.sharefood.databinding.ActivityViewFoodPostBinding
import food.sharefood.com.sharefood.main.FoodImagesAdapter
import food.sharefood.com.sharefood.util.Extras
import food.sharefood.com.sharefood.util.FoodSharePost

class ViewPostPresenter(var context: Context, var postView: PostView, var viewPostInteractor: ViewPostInteractor) : ViewPostInteractor.ViewPostInterface {

    fun setData(binding: ActivityViewFoodPostBinding, foodSharePost: FoodSharePost) {
        if (foodSharePost != null) {
            binding.textPostItemValues.text = foodSharePost.foodItems
            binding.valueSufficent.text = foodSharePost.sufficientFor
            binding.textPickupTime.text = foodSharePost.pickUntilTime
            binding.textLocation.text = foodSharePost.foodPickupLocation

            var location: String = binding.textLocation.text.toString()
            val locationData = arrayOf(location.split(","))
            // latitude = locationData[0].toString().toDouble()
            // longitude = locationData[1].toString().toDouble()

            // binding.textSharing.text = postData. //TODO: add user type i.e individual etc

            setPictures(foodSharePost.postPictures!!, binding)
        }

    }


    fun sendDeleteCall(foodSharePost: FoodSharePost) {
        postView.showProgress()
        viewPostInteractor.requestDeletePost(context, foodSharePost, this)
    }


    fun sendEditCall(foodSharePost: FoodSharePost) {
        postView.showProgress()

        // viewPostInteractor.requestEditPost(context, foodSharePost, this)
    }

    private fun setPictures(arrayPic: ArrayList<String>, binding: ActivityViewFoodPostBinding) {
        if (arrayPic.size != 0) {
            binding.imagesPostList.layoutManager = LinearLayoutManager(context, LinearLayout.HORIZONTAL, false)

            binding.imagesPostList.adapter = FoodImagesAdapter(context, arrayPic)
        }
    }


    override fun deletePostSuccess() {
        postView.hideProgress()
        postView.deletePost()
    }

    override fun deletePostFailure() {
        postView.hideProgress()
    }

}