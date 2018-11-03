package food.sharefood.com.sharefood.signup

import food.sharefood.com.sharefood.user.UserModel

class SignUpPresenter(var signUpView: SignUpView, var signUpInteractor: SignUpInteractor) : SignUpInteractor.onSignUpFinishedListener
{


    fun registerUser()
    {
        signUpView.showProgress()
        signUpInteractor.requestSignUpUser(this)
    }



    override fun onSignUpFailure() {

    }

    override fun onSignUpSuccess(model: UserModel) {

    }
}