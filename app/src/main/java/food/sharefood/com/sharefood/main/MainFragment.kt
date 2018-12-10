package food.sharefood.com.sharefood.main

import android.databinding.DataBindingUtil
import android.graphics.Rect
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import food.sharefood.com.sharefood.R
import food.sharefood.com.sharefood.databinding.FragmentMainBinding
import food.sharefood.com.sharefood.dialog.DialogUtils
import food.sharefood.com.sharefood.util.FoodSharePost
import android.opengl.ETC1.getWidth
import android.support.v7.widget.RecyclerView
import food.sharefood.com.sharefood.databinding.ItemFoodListBinding


class MainFragment : Fragment(), MainView {


    private lateinit var binding: FragmentMainBinding
    private lateinit var mainPresenter: MainPresenter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)


        mainPresenter = MainPresenter(this, MainInteractor())
        mainPresenter.getListData(activity!!)

        return binding.root

    }


    override fun showProgress() {
        DialogUtils.ShowProgressDialog(activity!!)
    }

    override fun hideProgress() {
        DialogUtils.HideProgressDialog()
    }

    override fun setData(arrFood: List<FoodSharePost>) {

        if (arrFood.size != 0) {
            binding.foodList.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)

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