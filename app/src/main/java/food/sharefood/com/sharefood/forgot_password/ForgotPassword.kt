package food.sharefood.com.sharefood.forgot_password

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import food.sharefood.com.sharefood.R
import food.sharefood.com.sharefood.databinding.ActivityForgotBinding

class ForgotPassword : AppCompatActivity()
{
    lateinit var binding:ActivityForgotBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this , R.layout.activity_forgot)

    }
}