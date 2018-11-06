package food.sharefood.com.sharefood.login

import food.sharefood.com.sharefood.user.UserModel

class LoginInteractor {

    interface LoginFinishedListener
    {
        fun loginSucess(model: UserModel)
        fun loginFailure()
    }


    fun requestLoginUser(finishedListener: LoginFinishedListener)
    {

    }
}