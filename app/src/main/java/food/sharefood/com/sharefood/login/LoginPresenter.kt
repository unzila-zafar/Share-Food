package food.sharefood.com.sharefood.login

import food.sharefood.com.sharefood.user.UserModel

class LoginPresenter(var loginView: LoginView , var loginInteractor: LoginInteractor) : LoginInteractor.LoginFinishedListener
{

    fun loginUser()
    {
        loginView.showProgress()
        loginInteractor.requestLoginUser(this)
    }



    override fun loginSucess(model: UserModel) {

    }

    override fun loginFailure()
    {

    }
}