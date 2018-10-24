package food.sharefood.com.sharefood.main

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AppCompatDelegate
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import food.sharefood.com.sharefood.R
import food.sharefood.com.sharefood.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , MainView
{

    lateinit var binding: ActivityMainBinding

    private lateinit var mainPresenter: MainPresenter


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);


        mainPresenter = MainPresenter(this , MainInteractor())
        mainPresenter.getListData()

    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

    override fun setData(arrFood: List<FoodPostModel>) {
        if (arrFood.size != 0) {
            binding.foodList.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

            binding.foodList.adapter = FoodListAdapter(arrFood)
            {
                mainPresenter.onItemClick(it)
            }


        }
    }

    override fun setDataError(strError: String) {
    }

    override fun onItemClick(adapterPosition: Int) {

    }
}
