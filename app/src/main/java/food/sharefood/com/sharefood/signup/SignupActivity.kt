package food.sharefood.com.sharefood.signup

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.databinding.DataBindingUtil
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import food.sharefood.com.sharefood.main.MainActivity
import food.sharefood.com.sharefood.R
import food.sharefood.com.sharefood.databinding.ActivitySignupBinding
import food.sharefood.com.sharefood.dialog.DialogUtils
import food.sharefood.com.sharefood.util.Helper
import java.io.File
import java.io.IOException
import android.graphics.Bitmap
import com.bumptech.glide.Glide
import com.cloudinary.android.MediaManager
import food.sharefood.com.sharefood.BuildConfig
import food.sharefood.com.sharefood.util.Helper.Companion.getRealPathFromURI


class SignupActivity : AppCompatActivity(), SignUpView, AdapterView.OnItemSelectedListener {


    lateinit var binding: ActivitySignupBinding
    lateinit var presenter: SignUpPresenter
    lateinit var mCapturedPhoto: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup)

        init()

    }

    private fun init() {
        presenter = SignUpPresenter(this, SignUpInteractor(), this)

        setRegisterCategories()

        presenter.getCurrentLocation()

        binding.buttonSignup.setOnClickListener {


            presenter.registerUser(this, binding)

        }

        binding.imageView.setOnClickListener {

            presenter.alertDialog(this)
        }
    }


    private fun setRegisterCategories() {
        ArrayAdapter.createFromResource(
                this,
                R.array.type,
                R.layout.spinner_text
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            binding.spinner.adapter = adapter
        }
    }

    override fun showProgress() {

        DialogUtils.ShowProgressDialog(this)
    }

    override fun hideProgress() {

        DialogUtils.HideProgressDialog()
    }

    override fun registerUser() {

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun registerFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

        presenter.setSpinnerSelectedPosition(p2)
    }


    override fun selectImage(pos: Int) {

        if (pos == 0) // camera
        {
            startCamera()
        }
        if (pos == 1) //gallery
        {
            startGallery()
        }
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

            Helper.REQUEST_LOCATION -> {
                if (!grantResults.isEmpty() || grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    presenter.getCurrentLocation()
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

                    /*val photoURI = FileProvider.getUriForFile(this@SignupActivity,
                            "food.sharefood.com.sharefood.provider",
                            imageFile)*/

                }
            }
        }
    }


    private fun startGallery() {
        if (Helper.checkPermission(this,
                        arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
                        , Helper.REQUEST_SELECT_IMAGE_IN_ALBUM)) {
            val intentGallery = Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intentGallery, Helper.REQUEST_SELECT_IMAGE_IN_ALBUM)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            Helper.REQUEST_TAKE_PHOTO -> {

                if (mCapturedPhoto != null) {
                    var updatedPic: Bitmap = BitmapFactory.decodeFile(mCapturedPhoto.path)

                    Glide.with(this).load(updatedPic).into(binding.imageView)

                    var url: String = MediaManager.get().url().secure(true).generate(mCapturedPhoto.path)
                    presenter.saveSelectedImagePath(url)
                }

            }

            Helper.REQUEST_SELECT_IMAGE_IN_ALBUM -> {
                val selectedImageUri = data?.getData()
                val picturePath = getRealPathFromURI(selectedImageUri!!, this)
                mCapturedPhoto = selectedImageUri

                Glide.with(this).load(picturePath).into(binding.imageView)

                var url: String = MediaManager.get().url().secure(true).generate(mCapturedPhoto.path)
                presenter.saveSelectedImagePath(url)
            }
        }
    }

}