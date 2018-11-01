package food.sharefood.com.sharefood.add_food_post

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import food.sharefood.com.sharefood.R
import food.sharefood.com.sharefood.databinding.ActivityAddPostBinding

class AddPostActivity : AppCompatActivity()
{
    lateinit var binding: ActivityAddPostBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this , R.layout.activity_add_post)


        init()

    }


    private fun init()
    {

        setSupportActionBar(binding.toolbar.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true);

        binding.toolbar.toolbar.setNavigationOnClickListener { onBackPressed() }

        binding.buttonAdd.setOnClickListener {

            finish()
        }
    }
}