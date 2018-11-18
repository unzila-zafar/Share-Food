package food.sharefood.com.sharefood.login

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.constraint.solver.widgets.Helper
import android.support.v7.app.AppCompatActivity
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Toast
import food.sharefood.com.sharefood.R
import food.sharefood.com.sharefood.databinding.ActivityLoginBinding
import food.sharefood.com.sharefood.dialog.DialogUtils
import food.sharefood.com.sharefood.main.MainActivity
import food.sharefood.com.sharefood.signup.SignupActivity


class LoginActivity : AppCompatActivity(), LoginView {



    lateinit var binding: ActivityLoginBinding

    private lateinit var presenter:LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        init()

    }

    private fun init() {

        presenter = LoginPresenter(this,LoginInteractor())

        spanText()

        binding.buttonSignIn.setOnClickListener {

            var email_id: String = binding.email.text.toString()
            var password: String = binding.password.text.toString()

            if(email_id != null && password != null) {
                presenter.loginUser(this@LoginActivity, email_id, password)
            }

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


    override fun showProgress() {

        DialogUtils.ShowProgressDialog(this)
    }

    override fun hideProgress() {

        DialogUtils.HideProgressDialog()
    }

    override fun loginUser() {

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun loginFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    }
}
