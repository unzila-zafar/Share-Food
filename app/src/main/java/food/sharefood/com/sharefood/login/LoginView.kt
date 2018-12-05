package food.sharefood.com.sharefood.login

import food.sharefood.com.sharefood.util.FoodSharer

interface LoginView
{
    fun showProgress()
    fun hideProgress()
    fun loginUser(foodSharer: FoodSharer)
    fun loginFailure(message: String)
}