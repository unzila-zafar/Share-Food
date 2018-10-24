package food.sharefood.com.sharefood.login

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import food.sharefood.com.sharefood.main.MainActivity
import food.sharefood.com.sharefood.R
import food.sharefood.com.sharefood.databinding.ActivityLoginBinding
import android.text.*
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import food.sharefood.com.sharefood.signup.SignupActivity
import android.widget.Toast


class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        init()

    }

    private fun init() {
        spanText()

        binding.buttonSignIn.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }


    fun setBoldSpannable(myText: String): SpannableString {
        val spannableContent = SpannableString(myText)

        val clickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                this@LoginActivity.startActivity(Intent(this@LoginActivity, SignupActivity::class.java))
            }
        }
        spannableContent.setSpan(clickableSpan, 22, 34, 0)

        return spannableContent
    }

    fun spanText() {

        val spannable = setBoldSpannable(binding.textRegister.getText().toString())

        binding.textRegister.setMovementMethod(LinkMovementMethod.getInstance());
        binding.textRegister.text = setBoldSpannable(spannable.toString())

    }


}