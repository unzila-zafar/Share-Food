package food.sharefood.com.sharefood.add_food_post

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import com.cloudinary.android.MediaManager
import com.cloudinary.android.callback.ErrorInfo
import com.cloudinary.android.callback.UploadCallback
import food.sharefood.com.sharefood.R
import food.sharefood.com.sharefood.databinding.ActivityAddPostBinding
import food.sharefood.com.sharefood.dialog.DialogUtils
import food.sharefood.com.sharefood.util.FoodPostArrays
import food.sharefood.com.sharefood.util.FoodSharePost
import food.sharefood.com.sharefood.util.Helper
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class AddPostPresenter(var context: Context, var addPostView: AddPostView, var addPostInteractor: AddPostInteractor) : AddPostInteractor.AddPostFinishedListener {
    private var foodSharePost: FoodSharePost = FoodSharePost()
    private var imagesUrlList: ArrayList<String> = ArrayList()
    private val UNSIGNED_UPLOAD_PRESET = "v1fykxtz"
    private lateinit var postMode: String
    private lateinit var postID : String

    fun addPost(context: Context, binding: ActivityAddPostBinding, imagesList: ArrayList<String>, mode: String) {
        addPostView.showProgress()
        postMode = mode

        if (Helper.checkNetworkConnectivity(context) && imagesList.size != 0) {
            uploadToCloudinary(imagesList, binding)
        } else {

            sendPostApiCall(binding)
        }

    }


    fun checkData(binding: ActivityAddPostBinding): Boolean {

        var checkValues = true
        foodSharePost = FoodSharePost()
        foodSharePost.phone_number = binding.addNumberEdit.text.toString()
        foodSharePost.sufficientFor = binding.addSufficientEdit.text.toString()
        foodSharePost.pickUntilTime = binding.addPicktimeEdit.text.toString()
        foodSharePost.foodPickupLocation = binding.addLocationEdit.text.toString()
        foodSharePost.foodItems = binding.addFooditemsEdit.text.toString()
        foodSharePost._id = postID

        if (imagesUrlList.size != 0)
            foodSharePost.postPictures = imagesUrlList

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

        /*  if (foodSharePost.foodPickupLocation!!.isEmpty()) {
              binding.addLocationLayout.error = "Please add location"
              addPostView.hideProgress()
              checkValues = false
          }*/

        //foodSharePost.foodPickupLocation = "kfc"

        if (foodSharePost.foodItems.isEmpty()) {
            binding.fooditemsLayout.error = "Please add food items"
            addPostView.hideProgress()
            checkValues = false
        }


        return checkValues
    }

    fun fillPhotoList(context: Context, imagesList: ArrayList<String>, binding: ActivityAddPostBinding, postMode :String) {

        var adapter = AddPhotoAdapter(context, this, imagesList, postMode)

        binding.addPhotoList.layoutManager = LinearLayoutManager(context, LinearLayout.HORIZONTAL, false)

        binding.addPhotoList.adapter = adapter

    }

    fun setEditData(foodPost: FoodSharePost, binding: ActivityAddPostBinding) {
        binding.addNumberEdit.setText(foodPost.phone_number)
        binding.addSufficientEdit.setText(foodPost.sufficientFor)
        binding.addPicktimeEdit.setText(foodPost.pickUntilTime)
        binding.addLocationEdit.setText(foodPost.foodPickupLocation)
        binding.addFooditemsEdit.setText(foodPost.foodItems)
        postID = foodPost._id!!
       // var list: ArrayList<String> = ArrayList()

        if (foodPost.postPictures!!.size != 10) {

            Helper.displayList.add(Helper.getURLForResource(R.drawable.ic_add))
        }


        (0..(foodPost.postPictures!!.size - 1)).forEach { i ->
            Helper.foodPostImagesArray.add(foodPost.postPictures!!.get(i))
            Helper.displayList.add(foodPost.postPictures!!.get(i))
        }

        fillPhotoList(context, Helper.displayList, binding, Helper.postEditMode)
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


    override fun onPostSuccess(foodSharePost: FoodSharePost, mode: String) {
        addPostView.hideProgress()
        addPostView.onSuccess(foodSharePost, mode)
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

    fun uploadToCloudinary(imagesList: ArrayList<String>, binding: ActivityAddPostBinding) {
        var counter = 0
        if (imagesList.size != 0) {
            (0..(imagesList.size - 1)).forEach { i ->
                if (imagesList.get(i).contains("cloudinary")) {
                    imagesUrlList.add(imagesList.get(i))

                    if (counter == (imagesList.size - 1)) {
                        sendPostApiCall(binding)
                    }
                    counter++
                } else {

                    MediaManager.get()
                            .upload(imagesList.get(i))
                            .unsigned(UNSIGNED_UPLOAD_PRESET)
                            .option("resource_type", "image")
                            .callback(object : UploadCallback {
                                override fun onStart(requestId: String) {
                                    Log.d("upload: ", "onStart")
                                    DialogUtils.ShowProgressDialog(context)

                                }

                                override fun onProgress(requestId: String, bytes: Long, totalBytes: Long) {
                                }

                                override fun onSuccess(requestId: String, resultData: Map<*, *>) {
                                    Toast.makeText(context, "Upload successful", Toast.LENGTH_LONG).show()
                                    DialogUtils.HideProgressDialog()
                                    imagesUrlList.add(MediaManager.get().url().secure(true).generate(resultData["public_id"].toString())) //Helper.setDataInList(resultData["public_id"].toString())

                                    if (counter == (imagesList.size - 1)) {
                                        sendPostApiCall(binding)
                                    }
                                    counter++
                                }

                                override fun onError(requestId: String, error: ErrorInfo) {
                                    Log.d("upload: ", error.description)
                                    DialogUtils.HideProgressDialog()
                                    Toast.makeText(context, "Upload was not successful", Toast.LENGTH_LONG).show()
                                }

                                override fun onReschedule(requestId: String, error: ErrorInfo) {
                                    Log.d("upload: ", "onReschedule")
                                    DialogUtils.HideProgressDialog()
                                }
                            }).dispatch()
                }
            }


        }
    }


    private fun sendPostApiCall(binding: ActivityAddPostBinding) {
        if (checkData(binding)) {
            addPostInteractor.requestAddPost(context, foodSharePost, this, postMode)
        }
    }
}