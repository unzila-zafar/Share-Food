package food.sharefood.com.sharefood

import android.content.Intent
import android.os.Bundle
import android.os.Handler

import android.support.v7.app.AppCompatActivity
import food.sharefood.com.sharefood.login.LoginActivity
import food.sharefood.com.sharefood.main.MainActivity
import food.sharefood.com.sharefood.util.AppSharedPref
import food.sharefood.com.sharefood.util.SharedPrefKeys


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppSharedPref.loadPrefs(this)
        if (AppSharedPref.getData(SharedPrefKeys.LOGGED_IN, AppSharedPref.BOOLEAN, this) == true) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            setContentView(R.layout.activity_splash)

            Handler().postDelayed(
                    Runnable {
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                        finish()


                    }, 1000)
        }
    }
}