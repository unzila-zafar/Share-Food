package food.sharefood.com.sharefood.signup

import android.content.Context
import android.widget.Toast
import food.sharefood.com.sharefood.user.UserModel

class SignUpPresenter(var signUpView: SignUpView, var signUpInteractor: SignUpInteractor) : SignUpInteractor.onSignUpFinishedListener
{


    fun registerUser(context: Context)
    {
        signUpView.showProgress()
        signUpInteractor.requestSignUpUser(context, this)
    }


    override fun onSignUpSuccess(model: UserModel) {
        signUpView.registerUser()
    }

    override fun onSignUpFailure(message: String)
    {
        signUpView.hideProgress()
        signUpView.registerFailure(message)
    }

    override fun onSignUpSuccess() {
        signUpView.registerUser()
    }

}