package food.sharefood.com.sharefood.login

import android.content.Context
import android.graphics.drawable.Drawable
import android.provider.SyncStateContract
import android.util.Base64
import food.sharefood.com.sharefood.user.UserModel
import java.math.BigInteger
import java.nio.charset.Charset
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import javax.crypto.Cipher
import javax.crypto.SecretKey

class LoginPresenter(var loginView: LoginView , var loginInteractor: LoginInteractor) : LoginInteractor.LoginFinishedListener
{

    fun loginUser(context : Context, id : String , password : String)
    {
        loginView.showProgress()

        loginInteractor.requestLoginUser(context,id, getMd5Base64(password).toString(),this)
    }

    fun getMd5Base64(password: String): String? {
        val md5 = MessageDigest.getInstance("MD5")
        val hash = BigInteger(1, md5.digest(password.toByteArray(Charset.defaultCharset()))).toString(16)

        return hash
    }


    override fun loginSuccess() {
        loginView.hideProgress()
        loginView.loginUser()
    }

    override fun loginFailure()
    {
        loginView.hideProgress()
    }


}