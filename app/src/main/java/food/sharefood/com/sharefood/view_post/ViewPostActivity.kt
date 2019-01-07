package food.sharefood.com.sharefood.view_post

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import food.sharefood.com.sharefood.R
import food.sharefood.com.sharefood.add_food_post.AddPostActivity
import food.sharefood.com.sharefood.add_food_post.MapViewActivity
import food.sharefood.com.sharefood.databinding.ActivityViewFoodPostBinding
import food.sharefood.com.sharefood.dialog.DialogUtils
import food.sharefood.com.sharefood.main.FoodImagesAdapter
import food.sharefood.com.sharefood.network.VolleyClass.Companion.context
import food.sharefood.com.sharefood.util.Extras
import food.sharefood.com.sharefood.util.FoodSharePost
import kotlinx.android.synthetic.main.post_toolbar.view.*
import java.util.concurrent.ThreadPoolExecutor

class ViewPostActivity : AppCompatActivity(), PostView {


    lateinit var binding: ActivityViewFoodPostBinding
    private lateinit var postData: FoodSharePost
    private var latitude: Double = 33.720001
    private var longitude: Double = 73.059998
    private lateinit var presenter: ViewPostPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_food_post)

        init()

    }

    private fun init() {
        setSupportActionBar(binding.postBar.postToolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true);

        binding.postBar.postToolbar.setNavigationOnClickListener { onBackPressed() }

        if (intent != null)
            postData = intent.getSerializableExtra(Extras.FOOD_MODEL) as FoodSharePost

        presenter = ViewPostPresenter(this, this, ViewPostInteractor())

        presenter.setData(binding, postData)

        if (postData != null) {

            if(postData.latitude != null && !postData.latitude!!.isEmpty())
                latitude = postData.latitude.toString().toDouble()

            if(postData.longitude != null && !postData.longitude!!.isEmpty())
                longitude = postData.longitude.toString().toDouble()

        }
        binding.viewMap.setOnClickListener {
            val intent = Intent(context, MapViewActivity::class.java)
            intent.putExtra(Extras.LATITUDE_VALUE, longitude)
            intent.putExtra(Extras.LONGITUDE_VALUE, latitude)
            context.startActivity(intent)
        }

        binding.postBar.postToolbar.imageEdit.setOnClickListener {

            var intent = Intent(context, AddPostActivity::class.java)
            intent.putExtra(Extras.Set_EDIT_POST_DATA, postData)
            startActivityForResult(intent, Extras.EDIT_POST_RESPONSE)

        }

        binding.postBar.postToolbar.imageRemove.setOnClickListener {
            presenter.showDeleteDialog(postData)
        }

    }


/*    private fun setPictures(arrayPic: ArrayList<String>)
    {
        if(arrayPic.size != 0)
        {
            binding.imagesPostList.layoutManager = LinearLayoutManager(this, LinearLayout.HORIZONTAL, false)

            binding.imagesPostList.adapter = FoodImagesAdapter(this, arrayPic)
        }
    }*/


    override fun deletePost() {

        var intent = Intent()
        intent.action = Extras.REFRESH_POSTS_DATA
        sendBroadcast(intent)
        finish()
    }

    override fun editPost() {
    }

    override fun showProgress() {
        DialogUtils.ShowProgressDialog(this)
    }

    override fun hideProgress() {
        DialogUtils.HideProgressDialog()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            Extras.EDIT_POST_RESPONSE -> {
                if (data != null) {
                    postData = data!!.getSerializableExtra(Extras.GET_EDIT_POST_DATA) as FoodSharePost
                    presenter.setData(binding, postData)
                    latitude = postData.latitude.toString()!!.toDouble()
                    longitude = postData.longitude.toString()!!.toDouble()
                }
            }
        }
    }
}