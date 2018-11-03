package food.sharefood.com.sharefood.signup

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import food.sharefood.com.sharefood.main.MainActivity
import food.sharefood.com.sharefood.R
import food.sharefood.com.sharefood.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() , SignUpView{


    lateinit var binding: ActivitySignupBinding
    lateinit var presenter: SignUpPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup)

        init()

    }

    private fun init() {
        presenter = SignUpPresenter(this, SignUpInteractor())

        setRegisterCategories()

        binding.buttonSignup.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }


    private fun setRegisterCategories() {
        ArrayAdapter.createFromResource(
                this,
                R.array.type,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            binding.spinner.adapter = adapter
        }
    }

    override fun showProgress() {
    }

    override fun hideProgress() {
    }

    override fun registerUser() {
    }
}