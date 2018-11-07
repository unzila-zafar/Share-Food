package food.sharefood.com.sharefood.settings

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import food.sharefood.com.sharefood.R
import food.sharefood.com.sharefood.databinding.ActivitySettingsBinding

class FragmentSettings :Fragment()
{

    private lateinit var binding: ActivitySettingsBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {

        binding = DataBindingUtil.inflate(inflater, R.layout.activity_settings , container , false)

        return binding.root
    }


}