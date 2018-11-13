package food.sharefood.com.sharefood.signup

import food.sharefood.com.sharefood.databinding.ActivitySignupBinding

interface SignUpView {

    fun showProgress()
    fun hideProgress()
    fun registerUser()
    fun registerFailure(message : String)
    fun selectImage(pos : Int)
}