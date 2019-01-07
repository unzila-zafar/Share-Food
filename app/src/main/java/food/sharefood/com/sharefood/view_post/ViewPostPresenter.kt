package food.sharefood.com.sharefood.view_post

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
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

            if (location != null) {
                binding.viewMap.setVisibility(View.VISIBLE)
                binding.textLocation.setText(location)
            } else {
                binding.viewMap.setVisibility(View.GONE)
            }
            // binding.textSharing.text = postData. //TODO: add user type i.e individual etc

            setPictures(foodSharePost.postPictures!!, binding)
        }

    }


    fun sendDeleteCall(foodSharePost: FoodSharePost) {
        postView.showProgress()
        viewPostInteractor.requestDeletePost(context, foodSharePost, this)
    }


    fun showDeleteDialog(foodSharePost: FoodSharePost) {
        val builder = AlertDialog.Builder(context)

        // Set the alert dialog title
        builder.setTitle("Delete Post")

        // Display a message on alert dialog
        builder.setMessage("Are you sure you want to delete this post?")

        // Set a positive button and its click listener on alert dialog
        builder.setPositiveButton("Yes") { dialog, which ->

            sendDeleteCall(foodSharePost)
            dialog.dismiss()
        }


        // Display a negative button on alert dialog
        builder.setNegativeButton("No") { dialog, which ->
            dialog.dismiss()
        }

        val dialog: AlertDialog = builder.create()

        // Display the alert dialog on app interface
        dialog.show()
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