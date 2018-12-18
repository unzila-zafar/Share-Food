package food.sharefood.com.sharefood.view_post

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import food.sharefood.com.sharefood.R
import food.sharefood.com.sharefood.add_food_post.MapViewActivity
import food.sharefood.com.sharefood.databinding.ActivityViewFoodPostBinding
import food.sharefood.com.sharefood.main.FoodImagesAdapter
import food.sharefood.com.sharefood.network.VolleyClass.Companion.context
import food.sharefood.com.sharefood.util.Extras
import food.sharefood.com.sharefood.util.FoodSharePost
import kotlinx.android.synthetic.main.post_toolbar.view.*

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

    private fun init()
    {
        setSupportActionBar(binding.postBar.postToolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true);

        binding.postBar.postToolbar.setNavigationOnClickListener { onBackPressed() }

        if (intent != null)
            postData = intent.getSerializableExtra(Extras.FOOD_MODEL) as FoodSharePost

        presenter = ViewPostPresenter(this, this, ViewPostInteractor())

        presenter.setData(binding, postData)

        /*  if(postData != null)
          {
              binding.textPostItemValues.text = postData.foodItems
              binding.valueSufficent.text = postData.sufficientFor
              binding.textPickupTime.text = postData.pickUntilTime
              binding.textLocation.text = postData.foodPickupLocation

              var location : String = binding.textLocation.text.toString()
              val locationData = arrayOf(location.split(","))
             // latitude = locationData[0].toString().toDouble()
             // longitude = locationData[1].toString().toDouble()

             // binding.textSharing.text = postData. //TODO: add user type i.e individual etc

              setPictures(postData.postPictures!!)
          }
  */
        binding.viewMap.setOnClickListener {
            val intent = Intent(context, MapViewActivity::class.java)
            intent.putExtra(Extras.LATITUDE_VALUE, latitude)
            intent.putExtra(Extras.LONGITUDE_VALUE, longitude)
            context.startActivity(intent)
        }

        binding.postBar.postToolbar.imageEdit.setOnClickListener {

            presenter.sendEditCall(postData)

        }

        binding.postBar.postToolbar.imageRemove.setOnClickListener {
            presenter.sendDeleteCall(postData)
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
        intent.setAction(Extras.REFRESH_POSTS_DATA)
        sendBroadcast(intent)
        finish()
    }

    override fun editPost() {
    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }
}