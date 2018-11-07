package food.sharefood.com.sharefood.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import food.sharefood.com.sharefood.R
import food.sharefood.com.sharefood.databinding.FragmentMainBinding

class MainFragment : Fragment() , MainView
{


    private lateinit var binding: FragmentMainBinding
    private lateinit var mainPresenter: MainPresenter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main , container, false)


        mainPresenter = MainPresenter(this, MainInteractor())
        mainPresenter.getListData()

        return binding.root

    }


    override fun showProgress() {
    }

    override fun hideProgress() {
    }

    override fun setData(arrFood: List<FoodPostModel>) {

        if (arrFood.size != 0) {
            binding.foodList.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)

            binding.foodList.adapter = FoodListAdapter(arrFood)
            {
                mainPresenter.onItemClick(it)
            }


        }
    }

    override fun setDataError(strError: String)
    {

    }

    override fun onItemClick(adapterPosition: Int) {
    }
}