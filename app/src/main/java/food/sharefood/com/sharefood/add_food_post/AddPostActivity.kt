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
import com.bumptech.glide.Glide
import com.cloudinary.android.MediaManager
import food.sharefood.com.sharefood.R
import food.sharefood.com.sharefood.databinding.ActivityAddPostBinding
import food.sharefood.com.sharefood.dialog.DialogUtils
import food.sharefood.com.sharefood.util.FoodSharePost
import food.sharefood.com.sharefood.util.Helper
import food.sharefood.com.sharefood.util.IntArrayWrapper
import java.io.File

class AddPostActivity : AppCompatActivity(), AddPostView {



    private lateinit var binding: ActivityAddPostBinding
    private lateinit var presenter: AddPostPresenter
    private lateinit var mCapturedPhoto: Uri


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_post)


        init()

    }


    private fun init() {

        setSupportActionBar(binding.toolbar.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true);

        binding.toolbar.toolbar.setNavigationOnClickListener { onBackPressed() }

        presenter = AddPostPresenter(this, AddPostInteractor())

        binding.buttonAdd.setOnClickListener {

            presenter.addPost(this, binding)
            finish()
        }
    }


    override fun showProgress() {
        DialogUtils.ShowProgressDialog(this)
    }

    override fun hideProgress() {
        DialogUtils.HideProgressDialog()
    }

    override fun onSuccess(foodSharePost: FoodSharePost) {
    }

    override fun onFailure(message: String) {
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

                    var list : ArrayList<String> = ArrayList()

                    list.add()

                    IntArrayWrapper()

                    presenter.fillPhotoList(this)

                }

            }

            Helper.REQUEST_SELECT_IMAGE_IN_ALBUM -> {
                val selectedImageUri = data?.getData()
                val picturePath = Helper.getRealPathFromURI(selectedImageUri!!, this)
                mCapturedPhoto = selectedImageUri

                Glide.with(this).load(picturePath).into(binding.imageView)

                var url: String = MediaManager.get().url().secure(true).generate(mCapturedPhoto.path)
                presenter.saveSelectedImagePath(url)
            }
        }
    }
}