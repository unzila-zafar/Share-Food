package food.sharefood.com.sharefood.login

import android.content.Context
import food.sharefood.com.sharefood.util.FoodSharer

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