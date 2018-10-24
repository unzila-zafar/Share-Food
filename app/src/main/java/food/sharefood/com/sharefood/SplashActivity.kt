package food.sharefood.com.sharefood

import android.content.Intent
import android.os.Bundle
import android.os.Handler

import android.support.v7.app.AppCompatActivity
import food.sharefood.com.sharefood.login.LoginActivity


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val postDelayed = Handler().postDelayed(
                Runnable {
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()


                }, 1000)

    }
}