package food.sharefood.com.sharefood.add_food_post

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.graphics.Bitmap
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.DatePicker
import android.widget.LinearLayout
import android.widget.TimePicker
import food.sharefood.com.sharefood.databinding.ActivityAddPostBinding

import food.sharefood.com.sharefood.util.FoodSharePost
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class AddPostPresenter(var addPostView: AddPostView, var addPostInteractor: AddPostInteractor) : AddPostInteractor.AddPostFinishedListener {
    private var foodSharePost: FoodSharePost = FoodSharePost()

    fun addPost(context: Context, binding: ActivityAddPostBinding, imagesList: ArrayList<String>) {
        addPostView.showProgress()

        if (checkData(binding, imagesList)) {
            addPostInteractor.requestAddPost(context, foodSharePost, this)
        }

    }


    fun checkData(binding: ActivityAddPostBinding, imagesList: ArrayList<String>): Boolean {

        var checkValues = true
        foodSharePost = FoodSharePost();
       // foodSharePost.name = binding.addNameEdit.text.toString()
      //  foodSharePost.email = binding.addEmailEdit.text.toString()
        foodSharePost.phone_number = binding.addNumberEdit.text.toString()
        foodSharePost.sufficientFor = binding.addSufficientEdit.text.toString()
        foodSharePost.pickUntilTime = binding.addPicktimeEdit.text.toString()
        foodSharePost.foodPickupLocation = binding.addLocationEdit.text.toString()
        foodSharePost.postPictures = imagesList

        foodSharePost.foodItems = binding.addFooditemsEdit.text.toString()

        //TODO Why this???
       /* if (!foodSharePost.email.isEmpty() && !foodSharePost.phone_number.isEmpty()
                && !foodSharePost.foodPickupLocation!!.isEmpty() && !foodSharePost.foodItems.isEmpty() && !foodSharePost.pickUntilTime!!.isEmpty()) {
        }*/


      /*  if (foodSharePost.email.isEmpty()) {
            binding.emailLayout.error = "Please enter email"
            addPostView.hideProgress()
            checkValues = false
        }*/

        if (foodSharePost.phone_number.isEmpty()) {
            binding.phoneLayout.error = "Please enter phone number"
            addPostView.hideProgress()
            checkValues = false
        }

        if (foodSharePost.pickUntilTime!!.isEmpty()) {
            binding.pickLayout.error = "Please enter pickup time"
            addPostView.hideProgress()
            checkValues = false
        }

        //TODO can we autopopulate location?
        if (foodSharePost.foodPickupLocation!!.isEmpty()) {
            binding.addLocationLayout.error = "Please add location"
            addPostView.hideProgress()
            checkValues = false
        }

        if (foodSharePost.foodItems.isEmpty()) {
            binding.fooditemsLayout.error = "Please add food items"
            addPostView.hideProgress()
            checkValues = false
        }

        return checkValues
    }

    fun fillPhotoList(context: Context, imagesList: ArrayList<Bitmap>, binding: ActivityAddPostBinding) {

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

    fun setLocationData(longitude: Double, latitude: Double, place: String) {
        foodSharePost.foodPickupLocation = latitude.toString() + "," + longitude.toString()
        addPostView.setSelectedLocation(place)
    }


    override fun onPostSuccess(foodSharePost: FoodSharePost) {
        addPostView.hideProgress()
        addPostView.onSuccess(foodSharePost)
    }

    override fun onPostError(message: String) {

        addPostView.hideProgress()
        addPostView.onFailure(message)
    }


    fun showDatePickerDialog(context: Context) {
        val c = Calendar.getInstance()
        val sdf = SimpleDateFormat("yyyy-MM-dd")

        val datePickerStart = DatePickerDialog(context,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    Log.d("Date", "Selected date")
                    val picked_date = year.toString() + "-" + (monthOfYear + 1) + "-" + dayOfMonth

                    TimePickerDialog(context, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                        val AM_PM: String
                        if (hourOfDay < 12) {
                            AM_PM = "AM"
                        } else {
                            AM_PM = "PM"
                        }

                        var time = String.format("%2d", hourOfDay) + ":" + String.format("%2d", minute) + " " + AM_PM

                        addPostView.setSelectedDateTime(picked_date + "," + time)
                    }, c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), false).show()

                }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH))
        datePickerStart.show()
    }
}