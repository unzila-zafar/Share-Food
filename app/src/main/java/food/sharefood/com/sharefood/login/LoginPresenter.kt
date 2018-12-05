package food.sharefood.com.sharefood.login

import android.content.Context
import android.graphics.drawable.Drawable
import android.provider.SyncStateContract
import android.util.Base64
import food.sharefood.com.sharefood.user.UserModel
import food.sharefood.com.sharefood.util.FoodSharer
import java.math.BigInteger
import java.nio.charset.Charset
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import javax.crypto.Cipher
import javax.crypto.SecretKey

class LoginPresenter(var loginView: LoginView, var loginInteractor: LoginInteractor) : LoginInteractor.LoginFinishedListener {

    fun loginUser(context: Context, id: String, password: String) {
        loginView.showProgress()

        loginInteractor.requestLoginUser(context, id, password, this)
    }


    override fun loginSuccess(foodSharer: FoodSharer) {
        loginView.hideProgress()
        loginView.loginUser(foodSharer)
    }

    override fun loginFailure() {
        loginView.hideProgress()
    }


}