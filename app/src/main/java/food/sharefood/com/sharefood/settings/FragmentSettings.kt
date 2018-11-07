package food.sharefood.com.sharefood.settings

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import food.sharefood.com.sharefood.R
import food.sharefood.com.sharefood.databinding.ActivitySettingsBinding

class SettingsActivity :AppCompatActivity()
{

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_settings)


    }
}