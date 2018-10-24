package food.sharefood.com.sharefood.main

import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import food.sharefood.com.sharefood.R

class MainInteractor {

    val food_description = arrayOf("abcd", "abcd", "abcd")
    val food_quatity = arrayOf("2kg", "10kg", "15kg")
    val food_time = arrayOf("2:39am", "5:30 pm", "4:00 pm")
    val food_location = arrayOf("islamabad", "karachi", "lahore")
    val food_pic = arrayOf(R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background)
    val food_menu_items = arrayOf("Chinese", "Italian Food", "Pizza")
    var food_post_array: MutableList<FoodPostModel> = ArrayList()

    interface OnFinishedListener {
        fun onResultSuccess(arrFoodList: List<FoodPostModel>)
        fun onResultFail(strError: String)
    }


    fun requestData(finishedListener: OnFinishedListener) {
        //implement Api call
        setListData()

        finishedListener.onResultSuccess(food_post_array)
    }

    private fun setListData()
    {
        food_post_array.clear();

        for (i in food_description.indices) {
            val description: String = food_description[i]
            var model: FoodPostModel = FoodPostModel(description = food_description[i],
                    time = food_time[i], foodItems = food_menu_items[i], foodQuantity = food_quatity[i],
                    foodLocation = food_location[i], longitude = 0.0, latitude = 0.0, foodPic = food_pic[i])
            food_post_array.add(model)
        }


    }
}