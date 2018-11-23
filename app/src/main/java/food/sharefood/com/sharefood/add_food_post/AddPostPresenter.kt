package food.sharefood.com.sharefood.add_food_post

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.provider.Settings
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import food.sharefood.com.sharefood.databinding.ActivityAddPostBinding
import food.sharefood.com.sharefood.databinding.ActivitySignupBinding
import food.sharefood.com.sharefood.network.VolleyClass
import food.sharefood.com.sharefood.util.FoodSharePost
import food.sharefood.com.sharefood.util.FoodSharer
import food.sharefood.com.sharefood.util.Helper
import food.sharefood.com.sharefood.util.IntArrayWrapper

class AddPostPresenter(var addPostView: AddPostView , var addPostInteractor: AddPostInteractor) : AddPostInteractor.AddPostFinishedListener
{
    private lateinit var foodSharePost: FoodSharePost

    fun addPost(context: Context , binding: ActivityAddPostBinding)
    {
        addPostView.showProgress()

        addPostInteractor.requestAddPost(context,foodSharePost, this)

    }


   /* fun checkData(binding: ActivityAddPostBinding): Boolean {

        foodSharePost = FoodSharePost()
        foodSharePost.name = binding.nameEdit.text.toString()
        foodSharer.name = binding.nameEdit.text.toString()
        foodSharer.password = binding.signupPassword.text.toString()
        foodSharer.registeredAs = spinnerPosition.toString()
        foodSharer.picture = selectedImageUrl
        foodSharer.address = currentLocation

        if (foodSharer.password.isEmpty()) {
            binding.passwordLayout.error = "Please enter password"
            signUpView.hideProgress()
            return false
        }

        if (foodSharer.loginId.isEmpty()) {
            binding.emailLayout.error = "Please enter login id"
            signUpView.hideProgress()
            return false
        }

        if (foodSharer.name.isEmpty()) {
            binding.nameLayout.error = "Please enter user name"
            signUpView.hideProgress()
            return false
        }

        if (spinnerPosition == 0) {
            binding.nameLayout.error = "Invalid option for Registering As"
            signUpView.hideProgress()
            return false
        }

        return true
    }*/

    fun fillPhotoList(context: Context, imagesList: ArrayList<Bitmap>, binding: ActivityAddPostBinding)
    {

        var adapter = AddPhotoAdapter(context, this, imagesList)

        binding.addPhotoList.layoutManager = LinearLayoutManager(context, LinearLayout.HORIZONTAL, false)

        binding.addPhotoList.adapter = adapter

    }


    fun alertDialog(context: Context) {
        val builder = AlertDialog.Builder(context)

        val items = arrayOf<CharSequence>(
                "Camera",
                "Gallery",
                "Cancel")
        // Set the alert dialog title
        builder.setTitle("Choose image")
        builder.setItems(items, { _, which -> addPostView.selectImage(which) })

        // Create a new AlertDialog using builder object
        val dialog = builder.create()

        // Finally, display the alert dialog
        dialog.show()
    }


    override fun onPostSuccess() {
        addPostView.hideProgress()
    }

    override fun onPostError() {

        addPostView.hideProgress()
    }
}