package food.sharefood.com.sharefood.signup

import android.content.Context
import android.support.v7.app.AlertDialog
import food.sharefood.com.sharefood.databinding.ActivitySignupBinding
import food.sharefood.com.sharefood.user.UserModel
import food.sharefood.com.sharefood.util.FoodSharer
import food.sharefood.com.sharefood.util.Helper.Companion.getMd5Base64


class SignUpPresenter(var signUpView: SignUpView, var signUpInteractor: SignUpInteractor) : SignUpInteractor.onSignUpFinishedListener {

    private var spinnerPosition: Int = 0
    private lateinit var mContext:Context
    private var selectedImageUrl: String = ""


    fun registerUser(context: Context, binding: ActivitySignupBinding) {
        mContext = context
        signUpView.showProgress()

        if (checkData(binding)) {
            signUpInteractor.requestSignUpUser(context, this)
        }
    }

    fun checkData(binding: ActivitySignupBinding): Boolean
    {
        var checkValues: Boolean = false

        FoodSharer().loginId = binding.emailEdit.text.toString()
        FoodSharer().name = binding.nameEdit.text.toString()
        FoodSharer().address = binding.addressEdit.text.toString()
        FoodSharer().password = binding.signupPassword.text.toString()
        var confirmPassword: String = binding.confirmPwdEdit.text.toString()


        if (!FoodSharer().password.isEmpty()) {

            checkValues = !confirmPassword.isEmpty() && FoodSharer().password.equals(confirmPassword)

            if (!checkValues) {
                binding.confirmLayout.error = "Password doesn't match"
            } else {
                FoodSharer().password = getMd5Base64(FoodSharer().password).toString()
            }
        } else {
            binding.passwordLayout.error = "Please enter password"
        }

        checkValues = !FoodSharer().loginId.isEmpty()
        if (!checkValues) {
            binding.emailLayout.error = "Please enter login id"
        }

        checkValues = !FoodSharer().name.isEmpty()
        if (!checkValues) {
            binding.emailLayout.error = "Please enter user name"
        }

        checkValues = spinnerPosition != 0
        if (checkValues) {
            FoodSharer().registeredAs = spinnerPosition.toString()
        }

        checkValues = !selectedImageUrl.isEmpty()

        if(checkValues){
            FoodSharer().picture = selectedImageUrl
        }


        return checkValues
    }

    fun setSpinnerSelectedPosition(position: Int) {
        spinnerPosition = position
    }


    override fun onSignUpSuccess(model: UserModel) {
        signUpView.registerUser()
    }

    override fun onSignUpFailure(message: String) {
        signUpView.hideProgress()
        signUpView.registerFailure(message)
    }

    override fun onSignUpSuccess() {
        signUpView.registerUser()
    }


    fun alertDialog(context: Context)
    {
        val builder = AlertDialog.Builder(context)

        val items = arrayOf<CharSequence>(
                "Camera",
                "Gallery",
                "Cancel")
        // Set the alert dialog title
        builder.setTitle("Choose image")
        builder.setItems(items,{_, which ->

            signUpView.selectImage(which)

        })

        // Create a new AlertDialog using builder object
        val dialog = builder.create()

        // Finally, display the alert dialog
        dialog.show()
    }

    fun saveSelectedImagePath(path : String)
    {
        selectedImageUrl = path
    }

}