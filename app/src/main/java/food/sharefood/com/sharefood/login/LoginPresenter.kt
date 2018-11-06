package food.sharefood.com.sharefood.login

import android.content.Context
import food.sharefood.com.sharefood.user.UserModel

class LoginPresenter(var loginView: LoginView , var loginInteractor: LoginInteractor) : LoginInteractor.LoginFinishedListener
{

    fun loginUser(context : Context, id : String , password : String)
    {
        loginView.showProgress()
        loginInteractor.requestLoginUser(context,id, password,this)
    }



    override fun loginSuccess(model: UserModel) {
        loginView.hideProgress()
        loginView.loginUser()
    }

    override fun loginFailure()
    {
        loginView.hideProgress()
    }
}