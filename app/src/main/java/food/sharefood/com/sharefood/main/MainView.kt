package food.sharefood.com.sharefood.main

import food.sharefood.com.sharefood.util.FoodSharePost

interface MainView
{
    fun showProgress()
    fun hideProgress()
    fun setData(arrFood: List<FoodSharePost>)
    fun setDataError(strError: String)
    fun onItemClick(adapterPosition: Int)
}