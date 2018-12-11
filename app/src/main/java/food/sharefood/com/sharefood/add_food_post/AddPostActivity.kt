package food.sharefood.com.sharefood.add_food_post

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.databinding.DataBindingUtil
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import food.sharefood.com.sharefood.R
import food.sharefood.com.sharefood.databinding.ActivityAddPostBinding
import food.sharefood.com.sharefood.dialog.DialogUtils
import food.sharefood.com.sharefood.util.FoodSharePost
import food.sharefood.com.sharefood.util.Helper
import food.sharefood.com.sharefood.util.IntArrayWrapper
import java.io.File
import java.util.*

import android.app.Activity

import com.google.android.gms.location.places.ui.PlaceAutocomplete


class AddPostActivity : AppCompatActivity(), AddPostView {


    private lateinit var binding: ActivityAddPostBinding
    private lateinit var presenter: AddPostPresenter
    private lateinit var mCapturedPhoto: Uri
    var list: ArrayList<Bitmap> = ArrayList()
    var imagesUrlList: ArrayList<String> = ArrayList()
    private var capturePhotoPath: String? = null
    private val PLACE_AUTOCOMPLETE_REQUEST_CODE = 188

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_post)


        init()

    }


    private fun init() {

        setSupportActionBar(binding.toolbar.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true);

        binding.toolbar.toolbarTitle.text = resources.getString(R.string.add_post)
        binding.toolbar.toolbar.setNavigationOnClickListener { onBackPressed() }


        presenter = AddPostPresenter(this, AddPostInteractor())

        if (list != null) {
            list.add(BitmapFactory.decodeResource(getResources(), R.drawable.ic_add))

            presenter.fillPhotoList(this, list, binding)
        }

        binding.buttonAdd.setOnClickListener {

            presenter.addPost(this, binding, imagesUrlList)
            //finish()
        }

        binding.addLocationEdit.setOnClickListener {
            val intent = PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_OVERLAY)
                    .build(this)
            startActivityForResult(intent, PLACE_AUTOCOMPLETE_REQUEST_CODE)
        }

        binding.addPicktimeEdit.setOnClickListener {
            presenter.showDatePickerDialog(this)
        }
    }


    override fun showProgress() {
        DialogUtils.ShowProgressDialog(this)
    }

    override fun hideProgress() {
        DialogUtils.HideProgressDialog()
    }

    override fun onSuccess(foodSharePost: FoodSharePost) {

        finish()
    }

    override fun onFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun selectImage(position: Int) {
        if (position == 0) // camera
        {
            startCamera()
        }
        if (position == 1) //gallery
        {
            startGallery()
        }
    }

    override fun setSelectedDateTime(dateTime: String) {
        binding.addPicktimeEdit.setText(dateTime)
    }


    override fun setSelectedLocation(location: String) {

        binding.addLocationEdit.setText(location)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            Helper.REQUEST_SELECT_IMAGE_IN_ALBUM -> {

                if (!grantResults.isEmpty() || grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startGallery()
                }
            }
            Helper.REQUEST_TAKE_PHOTO -> {
                if (!grantResults.isEmpty() || grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startCamera()
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun startCamera() {
        if (Helper.checkPermission(this,
                        arrayOf(Manifest.permission.CAMERA)
                        , Helper.REQUEST_TAKE_PHOTO)) {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            var imageFile: File? = null
            try {
                imageFile = File.createTempFile(System.currentTimeMillis().toString(), ".jpg",
                        getExternalFilesDir(Environment.DIRECTORY_PICTURES))
            } catch (e: Exception) {
                e.printStackTrace()
            }

            if (imageFile != null) {
                if (imageFile.exists()) {
                    mCapturedPhoto = Uri.fromFile(imageFile)

                    val photoURI = FileProvider.getUriForFile(this, "food.sharefood.com.sharefood.provider", imageFile)

                    val pm = getPackageManager()
                    if (cameraIntent.resolveActivity(pm) != null) {
                        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                        startActivityForResult(cameraIntent, Helper.REQUEST_TAKE_PHOTO)
                    }


                }
            }
        }
    }


    private fun startGallery() {
        if (Helper.checkPermission(this,
                        arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
                        , Helper.REQUEST_SELECT_IMAGE_IN_ALBUM)) {
            val intentGallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intentGallery, Helper.REQUEST_SELECT_IMAGE_IN_ALBUM)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            Helper.REQUEST_TAKE_PHOTO -> {

                if (mCapturedPhoto != null) {
                    var updatedPic: Bitmap = BitmapFactory.decodeFile(mCapturedPhoto.path)

                    if (list != null && list.size < 10) {
                        list.add(updatedPic)

                        IntArrayWrapper(list.size) { index, value ->
                            println("$index changed to $value")
                        }

                        presenter.fillPhotoList(this, list, binding)

                        // var max: Int by Delegates.observable(0) {property, oldValue, newValue ->
                        imagesUrlList = Helper.setDataInList(mCapturedPhoto.path)

                        //}


                    } else {
                        Toast.makeText(this, "Images limit exceed!", Toast.LENGTH_SHORT).show()
                    }


                }

            }

            Helper.REQUEST_SELECT_IMAGE_IN_ALBUM -> {
                val selectedImageUri = data?.getData()
                val picturePath = Helper.getRealPathFromURI(selectedImageUri!!, this)
                mCapturedPhoto = selectedImageUri
                var updatedPic: Bitmap = BitmapFactory.decodeFile(picturePath)

                if (list != null && list.size < 10) {
                    list.add(updatedPic)

                    presenter.fillPhotoList(this, list, binding)

                    imagesUrlList = Helper.setDataInList(picturePath!!)
                } else {
                    Toast.makeText(this, "Images limit exceed!", Toast.LENGTH_SHORT).show()

                }
            }

            PLACE_AUTOCOMPLETE_REQUEST_CODE -> {
                if (resultCode === Activity.RESULT_OK) {
                    val place = PlaceAutocomplete.getPlace(this, data)
                    var longitude: Double = place.latLng.longitude
                    var latitude: Double = place.latLng.latitude
                    var placeName: String = place.name.toString()


                    presenter.setLocationData(latitude, longitude, placeName)

                } else if (resultCode === PlaceAutocomplete.RESULT_ERROR) {
                    val status = PlaceAutocomplete.getStatus(this, data)

                    Toast.makeText(this, "No Location Found.", Toast.LENGTH_SHORT).show()

                } else if (resultCode === Activity.RESULT_CANCELED) {
                }
            }
        }
    }


}