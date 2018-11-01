package food.sharefood.com.sharefood.view_post

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import food.sharefood.com.sharefood.R
import food.sharefood.com.sharefood.databinding.ActivityViewFoodPostBinding

class ViewPostActivity: AppCompatActivity() {

    lateinit var binding: ActivityViewFoodPostBinding

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

    }
}