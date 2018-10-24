package food.sharefood.com.sharefood.main

interface MainView
{
    fun showProgress()
    fun hideProgress()
    fun setData(arrFood: List<FoodPostModel>)
    fun setDataError(strError: String)
    fun onItemClick(adapterPosition: Int)
}