package food.sharefood.com.sharefood.signup

import food.sharefood.com.sharefood.user.UserModel

class SignUpInteractor
{
    private lateinit var model: UserModel

    interface onSignUpFinishedListener
    {
        fun onSignUpSuccess(model: UserModel)
        fun onSignUpFailure()
    }


    fun requestSignUpUser(finishedListener: onSignUpFinishedListener)
    {
        //TODO
        finishedListener.onSignUpSuccess(model)

    }
}