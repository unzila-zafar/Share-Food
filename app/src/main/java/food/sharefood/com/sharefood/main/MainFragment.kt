package food.sharefood.com.sharefood.main

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import food.sharefood.com.sharefood.R
import food.sharefood.com.sharefood.databinding.FragmentMainBinding
import food.sharefood.com.sharefood.dialog.DialogUtils
import food.sharefood.com.sharefood.util.Extras
import food.sharefood.com.sharefood.util.FoodSharePost


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

    val broadCastReceiver = object : BroadcastReceiver() {
        override fun onReceive(contxt: Context?, intent: Intent?) {

            when (intent?.action) {
                Extras.REFRESH_POSTS_DATA ->
                    mainPresenter.getListData(activity!!)

            }
        }
    }

    override fun onStart() {
        super.onStart()
        LocalBroadcastManager.getInstance(activity!!)
                .registerReceiver(broadCastReceiver, IntentFilter(Extras.REFRESH_POSTS_DATA))
    }


    override fun onStop() {
        super.onStop()
        LocalBroadcastManager.getInstance(activity!!)
                .unregisterReceiver(broadCastReceiver)
    }
}