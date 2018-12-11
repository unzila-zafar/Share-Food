package food.sharefood.com.sharefood.view_post

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import food.sharefood.com.sharefood.R
import food.sharefood.com.sharefood.databinding.ActivityViewFoodPostBinding
import food.sharefood.com.sharefood.main.FoodImagesAdapter
import food.sharefood.com.sharefood.util.Extras
import food.sharefood.com.sharefood.util.FoodSharePost

class ViewPostActivity: AppCompatActivity() {

    lateinit var binding: ActivityViewFoodPostBinding
    private lateinit var postData : FoodSharePost

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

        if(intent != null)
            postData = intent.getSerializableExtra(Extras.FOOD_MODEL) as FoodSharePost

        if(postData != null)
        {
            binding.textPostItemValues.text = postData.foodItems
            binding.valueSufficent.text = postData.sufficientFor
            binding.textPickupTime.text = postData.pickUntilTime
            binding.textLocation.text = postData.foodPickupLocation
           // binding.textSharing.text = postData. //TODO: add user type i.e individual etc

            setPictures(postData.postPictures!!)
        }


    }


    private fun setPictures(arrayPic: ArrayList<String>)
    {
        if(arrayPic.size != 0)
        {
            binding.imagesPostList.layoutManager = LinearLayoutManager(this, LinearLayout.HORIZONTAL, false)

            binding.imagesPostList.adapter = FoodImagesAdapter(this, arrayPic)
        }
    }
}